package org.sine95.kernel.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.sine95.kernel.base.errores.IError;
import org.sine95.kernel.base.errores.IInfo;
import org.sine95.kernel.base.errores.IWarning;

import com.juanma.twitterCli.enums.EnumCategoriasErrores;

public class UtilError {
	
	public static String genMsg(String cad,Map<String,Object> params)
	{
		String res=cad;
		for(Entry<String, Object> entry:params.entrySet())
		{
			String val=(entry.getValue()!=null)?entry.getValue().toString():"[NULL]";
			res=res.replace("(("+entry.getKey()+"))", val);
		}
		return res;
	}
	
	public static List<IError> findErrorByType(List<IError> errores,Class<?> tipo)
	{
		List<IError> res=new ArrayList<IError>();
		for(IError error:errores)
		{
			
			if(tipo.isInstance(error))
			{
				res.add(error);
			}
			
		}
		return res;
	}
	public static List<IWarning> findWarningByType(List<IWarning> warnings,Class<?> tipo)
	{
		List<IWarning> res=new ArrayList<>();
		for(IWarning warn:warnings)
		{
			
			if(tipo.isInstance(warn))
			{
				res.add(warn);
			}
			
		}
		return res;
	}
	public static List<IInfo> findInfoByType(List<IInfo> infos,Class<?> tipo)
	{
		List<IInfo> res=new ArrayList<>();
		for(IInfo info:infos)
		{
			
			if(tipo.isInstance(info))
			{
				res.add(info);
			}
			
		}
		return res;
	}
	public static List<IError> getErrorOfCategoria(List<IError> lErrores,EnumCategoriasErrores categ)
	{
//		List<IError> res = lErrores.stream()                
//                .filter(error -> error.isPerteneceCategoria(categ))
//                .collect(Collectors.toList());
		List<IError> res = lErrores.stream().
				takeWhile(error ->!error.isPerteneceCategoria(categ)).
				collect(Collectors.toList());                
		return res;
	}
	
	public static List<IError> getErrorNotOfCategoria(List<IError> lErrores,EnumCategoriasErrores categ)
	{
//		List<IError> res = lErrores.stream()                
//      .filter(error -> !error.isPerteneceCategoria(categ))
//      .collect(Collectors.toList());
		List<IError> res = lErrores.stream().
				takeWhile(error ->!error.isPerteneceCategoria(categ)).
				collect(Collectors.toList());                
		return res;
	}

	public static List<IError> getErrorInCategorias(List<IError> lErrores,EnumCategoriasErrores[] categs)
	{
		for (EnumCategoriasErrores c:categs) {
			lErrores = getErrorOfCategoria(lErrores,c);
		}
		return lErrores;
	}

	public static List<IError> getErrorNotInCategorias(List<IError> lErrores,EnumCategoriasErrores[] categs)
	{
		for (EnumCategoriasErrores c:categs) {
			lErrores = getErrorNotOfCategoria(lErrores,c);
		}
		return lErrores;
	}
	

}
