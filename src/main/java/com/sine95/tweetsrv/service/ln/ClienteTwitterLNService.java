
package com.sine95.tweetsrv.service.ln;

import org.sine95.kernel.base.errores.IError;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import java.io.*;
import java.util.*;
import org.springframework.context.ApplicationContext;


//entity
import com.sine95.tweetsrv.domain.Tweets;
import com.sine95.tweetsrv.domain.TweetsCrit;
import com.sine95.tweetsrv.domain.TweetsCritPaged;
import com.sine95.tweetsrv.service.crud.TweetsServiceCRUD;

//import com.sine95.tweetsrv.domain.TweetsExt;
import com.sine95.tweetsrv.domain.TweetsExt;

//entity
import com.sine95.tweetsrv.domain.Hashtags;
import com.sine95.tweetsrv.domain.HashtagsCrit;
import com.sine95.tweetsrv.domain.HashtagsCritPaged;
import com.sine95.tweetsrv.service.crud.HashtagsServiceCRUD;

//import com.sine95.tweetsrv.domain.HashtagsExt;
import com.sine95.tweetsrv.domain.HashtagsExt;

//enum

import com.sine95.tweetsrv.enums.SiNo;
    


import org.springframework.beans.factory.annotation.Autowired;
import org.sine95.kernel.base.Result;
import com.sine95.tweetsrv.errores.*;
import com.sine95.tweetsrv.infos.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import org.sine95.kernel.base.*;
import com.sine95.tweetsrv.service.Config;
import com.sine95.tweetsrv.domain.validator.*;
import java.util.*;
import java.util.stream.*;

////START_{Import}
import org.springframework.data.domain.Example;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import org.apache.commons.collections.CollectionUtils;
import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.ResponseList;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterAdapter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterListener;
import twitter4j.TwitterMethod;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
////END_{Import}

/**
* Logica de negocio para el acceso a Twitter
*/

@SuppressWarnings("unused")
@Service

public class ClienteTwitterLNService extends LNService
{
  private final Logger log = LoggerFactory.getLogger(ClienteTwitterLNService.class);
////START_{AutoWired}
  @Autowired
  private PlatformTransactionManager transactionManager;

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
    private Long minNumSeguidores;
    private Set<String> idiomasPermitidos;
////END_{Init}



	/**
	* Precondiciones para el metodo InitCli.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	////START_{Comentarios_preConditionsInitCli}
	////END_{Comentarios_preConditionsInitCli}
	private Map<String,Object> preConditionsInitCli(Result< Vacio > res )
	{
		Map<String,Object> cache=new HashMap<>();

		////START_{preConditionsInitCli}
		////END_{preConditionsInitCli}
		return cache;
	}

	/**
	* Arranca la escucha de twits
	*/

////START_{Comentarios_InitCli}
////END_{Comentarios_InitCli}

	@Transactional
	public Result< Vacio > InitCli()
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en ClienteTwitterService.InitCli ("+_params_+")");
		Map<String,Object> cache=preConditionsInitCli( res  );
		if(res.isOk())
		{
			try
			{


				////START_{InitCli}
				inicializaConfiguracion();
				StatusListener listener = new StatusListener(){
					public void onStatus(Status status) {
						//				            System.out.println(status.getUser().getName() + " : " + status.getText());
						int numSeguidores = status.getUser().getFollowersCount();
						String idioma = status.getLang();
						GeoLocation localizacion = status.getGeoLocation();
						if (numSeguidores>minNumSeguidores && idiomasPermitidos.contains(idioma)) {
							// Establece las propiedades de la Tx
							DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
							// Abrimos Tx
						    TransactionStatus tSt = transactionManager.getTransaction(definition);
							
							// Persistimos el Tweet
							Tweets twt = new Tweets();
//							twt.setId(status.getId()); // Usamos un id secuencial para los tweets que guardamos, para que se más sencillo identificarlos
							try {
								twt.setLocalizacion(localizacion==null?"":JSON.stringify(localizacion));
							} catch (JsonProcessingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							twt.setTexto(status.getText());
							twt.setUsuario(status.getUser().getName());
							twt.setValidacion(SiNo.N);
							
							Result<Tweets> rt = tweetsService.insert(twt);
							res.copyStatus(rt);

							// Actualizamos hashtags
							HashtagEntity[] hts = status.getHashtagEntities();
							for(HashtagEntity ht:hts) {
								if (res.isOk()) {
									Hashtags htg = new Hashtags();
									htg.setHashtags(ht.getText());
									Result<List<Hashtags>> rlHtg =  hashtagsService.findAll(Example.of(htg));
									if (rlHtg.isOk()) {
										List<Hashtags> lHtg = rlHtg.getData();
										if (lHtg.isEmpty()) {
											// Es nuevo, lo creamos
											htg.setContador(1L);

											Result<Hashtags> rHtg = hashtagsService.insert(htg);
											res.copyStatus(rHtg);
										}
										else {
											// Ya existe, incrementamos el contador
											htg = lHtg.get(0);
											htg.setContador(htg.getContador()+1);
											Result<Hashtags> rHtg = hashtagsService.update(htg);
											res.copyStatus(rHtg);
										}
									}
									else {
										res.copyStatus(rlHtg);
									}
								}
							}

							if (!res.isOk()) {
								// Anulamos la Tx
								transactionManager.rollback(tSt);

								log.error(rt.getErrores().get(0).toString());
							}
							else {
								// Commit Tx
								transactionManager.commit(tSt);

								log.info("Status persistido correctamente: "+twt.toString());
							}
						}
					}
					public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
					public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
					public void onException(Exception ex) {
						ex.printStackTrace();
					}
					@Override
					public void onScrubGeo(long userId, long upToStatusId) {
						// TODO Auto-generated method stub

					}
					@Override
					public void onStallWarning(StallWarning warning) {
						// TODO Auto-generated method stub

					}
				};
				TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
				twitterStream.addListener(listener);
				// sample() method internally creates a thread which manipulates TwitterStream and calls these adequate listener methods continuously.
				twitterStream.sample();
				////END_{InitCli}

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en ClienteTwitterServiceCRUD.InitCli ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de ClienteTwitterServiceCRUD.InitCli ("+UtilParams.paramsToString()+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de ClienteTwitterServiceCRUD.InitCli ("+UtilParams.paramsToString()+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo SendTwit.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	////START_{Comentarios_preConditionsSendTwit}
	////END_{Comentarios_preConditionsSendTwit}
	private Map<String,Object> preConditionsSendTwit(Result< Vacio > res ,String texto)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:texto Tipo:String 

		if(texto==null)
		{
			res.addError(new ErrorParametroObligatorio("texto"));
		}


		////START_{preConditionsSendTwit}
		////END_{preConditionsSendTwit}
		return cache;
	}

	/**
	* Envía un twit
	*/

////START_{Comentarios_SendTwit}
////END_{Comentarios_SendTwit}

	public Result< Vacio > SendTwit(String texto)
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString("texto",texto);
		if (log.isInfoEnabled()) log.info("Entrando en ClienteTwitterService.SendTwit ("+_params_+")");
		Map<String,Object> cache=preConditionsSendTwit( res , texto );
		if(res.isOk())
		{
			try
			{


				////START_{SendTwit}
				Twitter twitter = TwitterFactory.getSingleton();
				twitter.updateStatus(texto);
				////END_{SendTwit}

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en ClienteTwitterServiceCRUD.SendTwit ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de ClienteTwitterServiceCRUD.SendTwit ("+UtilParams.paramsToString("texto",texto)+"). Result:"+res.toString());


		return res;
	}


////START_{Others}
	public void inicializaConfiguracion() {
	    minNumSeguidores = config.getNumMinSuscriptoresUsuarioParaPersistir();
	    idiomasPermitidos = new HashSet<>();
	    {
		    String sIdiomasPermitidos = config.getIdiomasPermitidosParaPersistir();
		    String[] aIdiomasPermitidos = sIdiomasPermitidos.split(",");
		    CollectionUtils.addAll(idiomasPermitidos, aIdiomasPermitidos);
	    }
	}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}

