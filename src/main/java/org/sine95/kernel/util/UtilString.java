package org.sine95.kernel.util;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.UUID;


public class UtilString {


	public static String abbreviate(String cadena,int max)
	{
		if(cadena.length()<=max) return cadena;
		String cadAux=cadena.substring(0, max-3)+"...";
		return cadAux;
	}

	public static String convertTildesToPercent(final String cad)
	{
		if(cad==null) return "";
		String res=cad.toString();

		List<String> busquedas=Arrays.asList("á", "é","í","ó","ú",
				"Á","É","Í","Ó","Ú",
				"à","è","ì","ò","ù",
				"À","È","Ì","Ò","Ù",
				"ä","ë","ï","ö","ü",
				"Ä","Ë","Ï","Ö","Ü",
				"ñ","Ñ","Ç","ç");

		for(String sub:busquedas)
		{
			res=res.replaceAll(sub, "%");
		}
		return res;
	}

	public static String getBase64FromArrayBytes(byte [] arr)
	{
		return Base64.getEncoder().encodeToString(arr);
	}

	public static String getStringFromBase64String(String b64) throws UnsupportedEncodingException
	{
		return new String(Base64.getDecoder().decode(b64),"UTF-8");
	}
	
	public static byte[] getArrBytesFromBase64String(String b64) throws UnsupportedEncodingException
	{
		return Base64.getDecoder().decode(b64);
	}
	public static String limpiaComillas(String s)
	{
		if (s==null) return null;
		if (s.startsWith("\"")) s=s.substring(1);
		if (s.endsWith("\"")) s=s.substring(0,s.length()-1);
		return s;
	}

	public static String limpiaDoblesEscapados(String s)
	{
		if (s!=null) s=s.replaceAll("\\\\\\\\","\\\\");
		return s;
    }

    public static String toString(StackTraceElement[] stacktrace)
	{

		StringBuilder sb=new StringBuilder();
		for(StackTraceElement elem:stacktrace)
		{
			sb.append(System.lineSeparator()+"\t"+elem.toString());
		}
		return sb.toString();
	}

	public static String newUUID()
    {
    	return UUID.randomUUID().toString();
    }
}
