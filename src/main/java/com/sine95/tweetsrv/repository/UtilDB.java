package com.sine95.tweetsrv.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



@SuppressWarnings("unused")
@Repository
public class UtilDB {
	public static SimpleDateFormat sdfDateTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat sdfGMTDateTime=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	public static SimpleDateFormat sdfDate=new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sdfDateSQLServer=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public void truncate(String[] tables) throws IOException
	{
		for(String table:tables)
		{
			truncate(table);
		}
	}
	
	public void truncate(File fich) throws IOException
	{
		byte[] readAllBytes = Files.readAllBytes(fich.toPath());
		String cadena=new String(readAllBytes);
		truncateJson(cadena);
	}
	public void truncateJson(String cadJson)
	{
		JsonParser parser = new JsonParser();
		JsonElement o = parser.parse(cadJson);
		List<String> tablas=new ArrayList<>();
		Map<String,List<String>> truncatePreMap=new HashMap<String, List<String>>();
		for(JsonElement tableElem: o.getAsJsonArray()) {
			JsonObject table = tableElem.getAsJsonObject();
			String nombreTabla = table.get("tabla").getAsString();
			tablas.add(nombreTabla);
			JsonElement truncatePreObj = table.get("truncatePre");
			if(truncatePreObj!=null)
			{
				JsonArray truncatePre = truncatePreObj.getAsJsonArray();
				List<String> lst=new ArrayList<String>();
				for(JsonElement pre:truncatePre)
				{
					lst.add(pre.getAsString());
				}
				truncatePreMap.put(nombreTabla,lst);
			}
			
		}
		Collections.reverse(tablas);
		for(String tabla:tablas)
		{
			List<String> list = truncatePreMap.get(tabla);
			if(list!=null && list.size()>0)
			{
				for(String tbl:list)
				{
					truncate(tbl);
				}
			}
			truncate(tabla);
		}

	}
	public void truncate(String table) {

		//Query query = entityManager.createNativeQuery("truncate table "+table+" ");
		Query query = entityManager.createNativeQuery("delete from "+table+" ");
		query.executeUpdate();
		
	}
	
	public void delete(String[] tables) throws IOException
	{
		for(String table:tables)
		{
			delete(table);
		}
	}
	public void delete(String table) {
		Query query = entityManager.createNativeQuery("delete from "+table);
		query.executeUpdate();		
	}
	
	public void insert(File fich) throws IOException,ParseException
	{
		byte[] readAllBytes = Files.readAllBytes(fich.toPath());
		String cadena=new String(readAllBytes);
		
		System.out.println(cadena);
		
		insert(cadena);
	}

	public void insert(String cadena) throws IOException,ParseException {
		JsonParser parser = new JsonParser();
		JsonElement o = parser.parse(cadena);
		System.out.println(o);
		
		//o.getAsJsonArray()
		//.forEach((tableElem)->{//tablas;
		for(JsonElement tableElem: o.getAsJsonArray()) {
			JsonObject table = tableElem.getAsJsonObject();
			JsonArray meta = table.getAsJsonArray("meta");
			Map<String,String> tipoPorCampo=new HashMap<>();
			meta.forEach((elem)->{
				JsonObject obj = elem.getAsJsonObject();
				
				String nombre = obj.get("nombre").getAsString();
				String tipo = obj.get("tipo").getAsString();
				tipoPorCampo.put(nombre,tipo);
				
			});
			
			JsonArray data=table.get("data").getAsJsonArray();
			
			for(JsonElement datum:data){//datum
				StringBuilder sb=new StringBuilder("insert into "+table.get("tabla").getAsString() +"(");
				StringBuilder sbNombres=new StringBuilder("");
				StringBuilder sbDatos=new StringBuilder("");
				
				List<Object> objetos=new ArrayList<Object>();
				Set<Entry<String, JsonElement>> set = datum.getAsJsonObject().entrySet();
				
				for(Entry<String, JsonElement> entry : set) { //campo
					String nombre = entry.getKey();
					JsonElement valor = entry.getValue();
					
					boolean append=false;
					if(valor.isJsonPrimitive())
					{
						if(valor.getAsJsonPrimitive().isString())
						{
							String tipo=tipoPorCampo.get(nombre);
							if("Date".equals(tipo)
									|| "java.sql.Timestamp".equals(tipo))
							{
								Date parseObject = (Date)sdfDateTime.parseObject(valor.getAsJsonPrimitive().getAsString());
								objetos.add(Timestamp.valueOf(sdfDateSQLServer.format(parseObject)));
								append=true;
								
							}	
							else if("java.sql.Date".equals(tipo))
							{
								objetos.add(sdfDate.parseObject(valor.getAsJsonPrimitive().getAsString()));
								append=true;
							}
							else if("java.sql.Time".equals(tipo))
							{
								objetos.add(Time.valueOf(valor.getAsJsonPrimitive().getAsString()));
								append=true;
							}
							else if("java.lang.Boolean".equals(tipo))
							{
								objetos.add(Boolean.valueOf(valor.getAsJsonPrimitive().getAsString()));
								append=true;
							}
							else
							{
								objetos.add(valor.getAsJsonPrimitive().getAsString());
								append=true;
							}
						}
						else if(valor.getAsJsonPrimitive().isNumber())
						{
							objetos.add(valor.getAsJsonPrimitive().getAsInt());
							append=true;
						}
						else if(valor.getAsJsonPrimitive().isBoolean())
						{
							Boolean b=valor.getAsJsonPrimitive().getAsBoolean();
							//SQLSERVER objetos.add((b)?1:0);
							objetos.add(b);
							append=true;
						}
					}
					if(append)
					{
						if(objetos.size()>1) {
							sbNombres.append(",");
							sbDatos.append(",");
						}
						sbNombres.append(nombre);
						sbDatos.append("?");
					}
				};//campo
				sb.append(sbNombres).append(") VALUES (").append(sbDatos);
				sb.append(")");
				
				//jdbcTemplate.batchUpdate(sb.toString(),dat);
				//jdbcTemplate.update(sb.toString(), objetos.toArray());
				Query query = entityManager.createNativeQuery(sb.toString());
				int i=1;
				for(Object obj:objetos)
				{
					query.setParameter(i, obj);
					i++;
				}
				try {
					query.executeUpdate();
				}catch(Throwable e)
				{
					entityManager.getTransaction().setRollbackOnly();
					Query query2 = entityManager.createNativeQuery("select error_number(),error_message()");
					Object obj=query2.getResultList();
					System.out.println(obj);
				}
			};//datum
			
		};//tablas
		entityManager.flush();
		//jdbcTemplate.getDataSource().getConnection().commit();
		
		
	}
	
}