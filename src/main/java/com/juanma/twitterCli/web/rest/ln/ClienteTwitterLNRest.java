package com.juanma.twitterCli.web.rest.ln;

import java.util.*;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.sine95.kernel.base.Contexto;
import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.ResultExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import com.codahale.metrics.annotation.Timed;
import com.juanma.twitterCli.*;
import com.juanma.twitterCli.domain.*;
import com.juanma.twitterCli.enums.SiNo;
import com.juanma.twitterCli.errores.*;
import com.juanma.twitterCli.service.*;
import com.juanma.twitterCli.service.crud.*;
import com.juanma.twitterCli.service.ln.*;

import org.springframework.transaction.interceptor.TransactionInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.*;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
////START_{Import}
////END_{Import}

/**
* Controlador REST para la LN de ClienteTwitterLNService
*/
@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class ClienteTwitterLNRest
{
  private final Logger log = LoggerFactory.getLogger(ClienteTwitterLNRest.class);
  @Autowired
  ClienteTwitterLNService service;
////START_{AutoWired}
////END_{AutoWired}

    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;

    @Autowired
    protected TweetsServiceCRUD tweetsService;

    @Autowired
    protected HashtagsServiceCRUD hashtagsService;


  
  ////START_{Init}
  ////END_{Init}

	@PutMapping("/clientetwitter.SendTwit/{texto}")
	@Timed
	
	public ResultExt< Vacio> SendTwit(HttpServletRequest request,HttpServletResponse response, @PathVariable String texto)
	{
		
		String params=UtilParams.paramsToString("String",texto);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_CLIENTETWITTER_SendTwit");
		ctx.put(Contexto.URL_SOLICITADA,"/clientetwitter.SendTwit/{texto}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:SendTwit("+params+")"+params);
		
		params=UtilParams.paramsToString("String",texto);
		if (log.isInfoEnabled()) log.info("Verificado en REST PUT:SendTwit("+params+")"+params);

		String texto_ = texto;

		Result< Vacio > res_=service.SendTwit(texto_);
		res.setInfoEWI(res_);

		res=res_;

		if (log.isInfoEnabled()) log.info("Salida de REST PUT:SendTwit("+params+"). Resultado:"+res.toString());

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



////START_{Others}
//Si hay que anadir metodos se incluyen aqui, 
//se recomienda utilizar este tipo de comentario para no interferir con el DELETE
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}

