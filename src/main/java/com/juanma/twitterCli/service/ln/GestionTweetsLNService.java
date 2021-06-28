
package com.juanma.twitterCli.service.ln;

import org.sine95.kernel.base.errores.IError;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.juanma.twitterCli.domain.Hashtags;
import com.juanma.twitterCli.domain.HashtagsCrit;
import com.juanma.twitterCli.domain.HashtagsCritPaged;
import com.juanma.twitterCli.domain.HashtagsExt;
import com.juanma.twitterCli.domain.In_GestionTweets_TweetsMasUsados;
import com.juanma.twitterCli.domain.Tweets;
import com.juanma.twitterCli.domain.TweetsCrit;
import com.juanma.twitterCli.domain.TweetsCritPaged;
import com.juanma.twitterCli.domain.TweetsExt;
import com.juanma.twitterCli.domain.validator.*;
import com.juanma.twitterCli.enums.SiNo;
import com.juanma.twitterCli.errores.*;
import com.juanma.twitterCli.infos.*;
import com.juanma.twitterCli.service.Config;
import com.juanma.twitterCli.service.crud.HashtagsServiceCRUD;
import com.juanma.twitterCli.service.crud.TweetsServiceCRUD;

import java.io.*;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.sine95.kernel.base.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import org.sine95.kernel.base.*;

import java.util.*;
import java.util.stream.*;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
////END_{Import}

/**
* Logica de negocio para los tweets
*/

@SuppressWarnings("unused")
@Service

public class GestionTweetsLNService extends LNService
{
  private final Logger log = LoggerFactory.getLogger(GestionTweetsLNService.class);
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



	/**
	* Precondiciones para el metodo ValidarTweet.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	////START_{Comentarios_preConditionsValidarTweet}
	////END_{Comentarios_preConditionsValidarTweet}
	private Map<String,Object> preConditionsValidarTweet(Result< Vacio > res ,Long tweetid)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:tweetid Tipo:Long 

		if(tweetid==null)
		{
			res.addError(new ErrorParametroObligatorio("tweetid"));
		}


		if(tweetid!=null)
		{
			Result<Optional< Tweets >> byId = tweetsService.findById(tweetid);
			if(byId.isOk() && byId.getData().isPresent())
			{
				cache.put("TweetsFromTweetid",byId.getData().get());
			}
			else {
				res.addError( new ErrorIdNoEncontrado(
						Tweets.class.getName()
						, tweetid
						)
				);
			}
		}

		////START_{preConditionsValidarTweet}
		////END_{preConditionsValidarTweet}
		return cache;
	}

	/**
	* Marcar un tweet como válido
	*/

////START_{Comentarios_ValidarTweet}
////END_{Comentarios_ValidarTweet}

	@Transactional
	public Result< Vacio > ValidarTweet(Long tweetid)
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString("tweetid",tweetid);
		if (log.isInfoEnabled()) log.info("Entrando en GestionTweetsService.ValidarTweet ("+_params_+")");
		Map<String,Object> cache=preConditionsValidarTweet( res , tweetid );
		if(res.isOk())
		{
			try
			{

				Tweets tweetsFromTweetid = (Tweets) cache.get("TweetsFromTweetid");


				////START_{ValidarTweet}
				Tweets tweet=tweetsFromTweetid;
				tweet.setValidacion(SiNo.S);
				Result<Tweets> rTwts = tweetsService.update(tweet);
				res.copyStatus(rTwts);
				////END_{ValidarTweet}

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionTweetsServiceCRUD.ValidarTweet ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionTweetsServiceCRUD.ValidarTweet ("+UtilParams.paramsToString("tweetid",tweetid)+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de GestionTweetsServiceCRUD.ValidarTweet ("+UtilParams.paramsToString("tweetid",tweetid)+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo TweetsValidos.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	////START_{Comentarios_preConditionsTweetsValidos}
	////END_{Comentarios_preConditionsTweetsValidos}
	private Map<String,Object> preConditionsTweetsValidos(Result< List <Tweets> > res )
	{
		Map<String,Object> cache=new HashMap<>();

		////START_{preConditionsTweetsValidos}
		////END_{preConditionsTweetsValidos}
		return cache;
	}

	/**
	* Consultar los tweets validados por usuario.
	*/

////START_{Comentarios_TweetsValidos}
////END_{Comentarios_TweetsValidos}

	@Transactional
	public Result< List <Tweets> > TweetsValidos()
	{
		Result< List <Tweets> > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en GestionTweetsService.TweetsValidos ("+_params_+")");
		Map<String,Object> cache=preConditionsTweetsValidos( res  );
		if(res.isOk())
		{
			try
			{


				////START_{TweetsValidos}
				// Hacemos una búsqueda byExample en la BF
				Tweets twt=new Tweets();
				twt.setValidacion(SiNo.S);
				Result<List<Tweets>> lTwts = tweetsService.findAll(Example.of(twt));
				
				if(lTwts.isOk())
				{
					res.setData(lTwts.getData());
				}
				else {
					res.copyStatus(lTwts);
				}
				////END_{TweetsValidos}

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionTweetsServiceCRUD.TweetsValidos ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionTweetsServiceCRUD.TweetsValidos ("+UtilParams.paramsToString()+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de GestionTweetsServiceCRUD.TweetsValidos ("+UtilParams.paramsToString()+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo Tweets.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	////START_{Comentarios_preConditionsTweets}
	////END_{Comentarios_preConditionsTweets}
	private Map<String,Object> preConditionsTweets(Result< List <Tweets> > res )
	{
		Map<String,Object> cache=new HashMap<>();

		////START_{preConditionsTweets}
		////END_{preConditionsTweets}
		return cache;
	}

	/**
	* Consultar los tweets
	*/

////START_{Comentarios_Tweets}
////END_{Comentarios_Tweets}

	@Transactional
	public Result< List <Tweets> > Tweets()
	{
		Result< List <Tweets> > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en GestionTweetsService.Tweets ("+_params_+")");
		Map<String,Object> cache=preConditionsTweets( res  );
		if(res.isOk())
		{
			try
			{


				////START_{Tweets}
				// Levantamos todos los Tweets de la BD
				Result<List<Tweets>> lTwts = tweetsService.findAll();
				if(lTwts.isOk())
				{
					res.setData(lTwts.getData());
				}
				else {
					res.copyStatus(lTwts);
				}
				////END_{Tweets}

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionTweetsServiceCRUD.Tweets ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionTweetsServiceCRUD.Tweets ("+UtilParams.paramsToString()+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de GestionTweetsServiceCRUD.Tweets ("+UtilParams.paramsToString()+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo HashtagsMasUsados.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	////START_{Comentarios_preConditionsHashtagsMasUsados}
	////END_{Comentarios_preConditionsHashtagsMasUsados}
	private Map<String,Object> preConditionsHashtagsMasUsados(Result< List <Hashtags> > res ,In_GestionTweets_TweetsMasUsados info)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:info Tipo:In_GestionTweets_TweetsMasUsados 

		if(info==null)
		{
			res.addError(new ErrorParametroObligatorio("info"));
		}


		if( info !=null )
		{
			In_GestionTweets_TweetsMasUsadosObjValidator val=new In_GestionTweets_TweetsMasUsadosObjValidator(appContext);
			res.addErrores(val.validate(info));
		}

		////START_{preConditionsHashtagsMasUsados}
		////END_{preConditionsHashtagsMasUsados}
		return cache;
	}

	/**
	* Consultar una clasificación de los N hashtags más usados.
	*/

////START_{Comentarios_HashtagsMasUsados}
////END_{Comentarios_HashtagsMasUsados}

	@Transactional
	public Result< List <Hashtags> > HashtagsMasUsados(In_GestionTweets_TweetsMasUsados info)
	{
		Result< List <Hashtags> > res=new Result<>();
		String _params_=UtilParams.paramsToString("info",info);
		if (log.isInfoEnabled()) log.info("Entrando en GestionTweetsService.HashtagsMasUsados ("+_params_+")");
		Map<String,Object> cache=preConditionsHashtagsMasUsados( res , info );
		if(res.isOk())
		{
			try
			{


				////START_{HashtagsMasUsados}
				// Obtenemos el número máximo de Hashtags a buscar del parámetro suministrado o de la configuración
				Integer maxHsts=info.getMaxHashtags();

				if(maxHsts == null) {
					maxHsts=config.getMaxNumHashTags();
				}
				
				// Utilizamos una búsqueda con paginación para obtener el número que queremos
				HashtagsCritPaged lPaged = new HashtagsCritPaged();

				lPaged.setPaged(true);
				lPaged.setSort(new String[] { "contador,desc" });

				lPaged.setPageSize(maxHsts);
				Result<Page<Hashtags>> lHsts = hashtagsService.findAll(lPaged);
				
				if (lHsts.isOk()) {
					res.setData(lHsts.getData().getContent());
				} else {
					res.copyStatus(lHsts); 
				}
				////END_{HashtagsMasUsados}

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionTweetsServiceCRUD.HashtagsMasUsados ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionTweetsServiceCRUD.HashtagsMasUsados ("+UtilParams.paramsToString("info",info)+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de GestionTweetsServiceCRUD.HashtagsMasUsados ("+UtilParams.paramsToString("info",info)+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}


////START_{Others}
//Si hay que annadir metodos se incluyen aqui, se recomienda utilizar este tipo de comentario para no interferir con el DELETE
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}

