package com.juanma.twitterCli.service;

import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sine95.kernel.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juanma.twitterCli.domain.Configuration;
import com.juanma.twitterCli.service.crud.ConfigurationServiceCRUD;


@Service
public class Config {

	@Autowired
	ConfigurationServiceCRUD service;

	@Autowired
	ApplicationContext appCon;
	
	public enum Claves{
		MaxNumHashTags,
		NumMinSuscriptoresUsuarioParaPersistir,
		IdiomasPermitidosParaPersistir
	}
	
	protected static Map<String, String> data=null;
	
	protected static Map<String,String> getData(ConfigurationServiceCRUD _service)
	{
		if(data==null)
		{
			data=new HashMap<>();
			Result<List<Configuration>> findAll = _service.findAll();
			if(findAll.isOk())
			{
				for(Configuration datum: findAll.getData())
				{
					data.put(datum.getKeyid(), datum.getValue());
				}
			}
		}
		return data;
	}
	
	/**
	Máximo de hashtags
	*/
	public String getMaxNumHashTagsAsString()
	{
		return Config.getData(service).get(Claves.MaxNumHashTags.toString());
	}
	public Integer getMaxNumHashTags()
	{
        return Integer.parseInt(getMaxNumHashTagsAsString(),10);
	}

	/**
	Solo se deben persistir aquellos tweets cuyos usuarios superen un número N de seguidores (default 1500).
	*/
	public String getNumMinSuscriptoresUsuarioParaPersistirAsString()
	{
		return Config.getData(service).get(Claves.NumMinSuscriptoresUsuarioParaPersistir.toString());
	}
	public Long getNumMinSuscriptoresUsuarioParaPersistir()
	{
        return Long.parseLong(getNumMinSuscriptoresUsuarioParaPersistirAsString(),10);
	}

	/**
	Solo se deben persistir aquellos tweets cuyo idioma esté en una lista de idiomas permitidos (default español, francés, italiano).
	*/
	public String getIdiomasPermitidosParaPersistirAsString()
	{
		return Config.getData(service).get(Claves.IdiomasPermitidosParaPersistir.toString());
	}
	public String getIdiomasPermitidosParaPersistir()
	{
		return getIdiomasPermitidosParaPersistirAsString();
	}
}

