package com.sine95.tweetsrv.service.ln;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.sine95.kernel.base.Contexto;
import org.sine95.kernel.base.IResult;
import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.errores.IError;

import com.sine95.tweetsrv.errores.*;



import org.sine95.kernel.util.UtilException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sine95.tweetsrv.errores.ErrorGeneral;

//entity

@SuppressWarnings("unused")
@Service
public class LNService {

    private final Logger log = LoggerFactory.getLogger(LNService.class);
	
	protected void postCondicionErrores(IResult<?> res,Set<Class<? extends IError>> erroresValidos,String params)
	{
		//Aqui se puede hacer lo que se quiera, incluyendo quitar errores
		//Hay que ver que hacemos con ello
		List<IError> erroresInvalidos=new ArrayList<IError>();
		
		for(IError error:(List<IError>)res.getErrores())
		{
			Class<? extends IError> clase=error.getClass();
			if(!erroresValidos.contains(clase))
			{
				erroresInvalidos.add(error);
			}
		}
		if(erroresInvalidos.size()>0)
		{
			//Podemos susituir errores por algún error no controlado
			//enviar un correo a un administrador
			//savar un log...
			log.error(params+"=>Errores no válidos:"+erroresInvalidos);
		}
	}
			
	

	protected String getLoginUsuarioLogado()
	{
		
		Contexto ctx=Contexto.get();
		return ctx.getAsString(Contexto.LOGIN);
		
	}

	
	
	protected Result<String> generaUrl(String urlRelativa,String urlBase)
	{
		Result<String> res = new Result<String>();
		if (urlRelativa==null)
		{
			return res.addError(new ErrorParametroObligatorio("urlRelativa"));
		}
		if (urlBase==null)
		{
			return res.addError(new ErrorParametroObligatorio("urlBase"));
		}
		if (urlBase.endsWith("/"))
		{
			if (urlRelativa.startsWith("/")) urlRelativa=urlRelativa.substring(1);
		}
		String s = urlBase+urlRelativa;
		return res.setData(s);
	}
	
}
