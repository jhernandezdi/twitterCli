package org.sine95.kernel.util;

import org.sine95.kernel.base.Contexto;

public class UtilParams {

	public static String paramsToString(Object... params)
	{
		StringBuilder sb=new StringBuilder();
		Contexto ctx=Contexto.get();
		if(ctx!=null)
		{
			sb.append("URL ["+ctx.getAsString(Contexto.URL_SOLICITADA)+"]");
			sb.append(" Sesion ["+ctx.getAsString(Contexto.ID_SESION)+"]");
			sb.append(" Login ["+ctx.getAsString(Contexto.LOGIN)+"]");
			sb.append(" URL ["+ctx.getAsString(Contexto.URL_SOLICITADA)+"]");
		}
		sb.append("Parametros:{");
		for(int i=0;i<params.length;i++)
		{
			sb.append(params[i]);
			if(i%2==0)
			{
				sb.append("=");
			}
			else
			{
				sb.append(",");
			}
		}
		sb.append("}");
		return sb.toString();
	}
		
}
