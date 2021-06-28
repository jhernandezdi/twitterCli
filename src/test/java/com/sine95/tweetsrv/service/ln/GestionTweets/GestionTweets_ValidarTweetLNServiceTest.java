
package com.sine95.tweetsrv.service.ln.GestionTweets;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import com.sine95.tweetsrv.TweetsrvApp;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.sine95.kernel.base.Result;
import com.sine95.tweetsrv.errores.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import org.sine95.kernel.base.test.*;
import com.sine95.tweetsrv.service.Config;
import com.sine95.tweetsrv.service.crud.ConfigurationServiceCRUD;
import com.sine95.tweetsrv.repository.UtilDB;
import com.sine95.tweetsrv.domain.Configuration;
import org.sine95.kernel.base.Contexto;

import java.util.*;
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

//obj    
import com.sine95.tweetsrv.domain.In_GestionTweets_TweetsMasUsados;
    


////START_{Import}
import com.sine95.tweetsrv.enums.SiNo;
////END_{Import}

/**
* Logica de negocio para los tweets
*/

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TweetsrvApp.class)
public class GestionTweets_ValidarTweetLNServiceTest extends GestionTweetsLNServiceTest
{

////START_{AutoWired}
////END_{AutoWired}

////START_{Init}
////END_{Init}

    
	// Inicio tests metodo ValidarTweet(tweetid)
	/* Descripcion del metodo:
	* Marcar un tweet como válido
	*/
      

	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	// Inicio test y funciones auxiliares del metodo ValidarTweet(tweetid)
	/**
	* Test de GestionTweetsLNService.ValidarTweet(tweetid)
	* ___________________________________________________
	* Validar un tweet y ver que ha cambiado
	* ___________________________________________________
	* Recordatorio: tambien hay que probar casos de error
	* ayudas:
	*
	* Para crear Fechas (Date) de una determinada fecha:
	* Date fechaIni=sdfFechaCompleta.parse("2019-07-07T00:00:00+0000");
	*
	* Para verificar errores:
	*	assertEquals(1, res.getErrores().size());
	*	assertEquals(<ClaseDeError>.class, res.getErrores().get(0).getClass());
	*/
	@Test
	@Transactional
	public void testValidarTweet_ComprobarTweetValido()
	{
		Map<String,Object> ctx=new HashMap<String,Object>();
		try {		
			Result< Vacio > res = new Result<>();
			Contexto con=Contexto.init();
			this.preTestValidarTweet_ComprobarTweetValido(ctx);
			////START_{testValidarTweet_ComprobarTweetValido}
			Long tweetid = 1L ;

			res=serviceLN.ValidarTweet( tweetid ); 
			//Comprobacion todo correcto
			if(res.isOk()){
				
				Tweets find = tweetsService.find(1L);
				assertEquals(SiNo.S,find.getValidacion());
				
			}
			else {
				fail("El res no es válido");
			}

			//Comprobacion de tipo Error
			//if(res.isOk()){
			//	fail("El res no es válido");
			//}
			//else {
			//	assertEquals("Deberia dar un error de tipo <TipoError>",1,UtilError.findErrorByType(res.getErrores(), <TipoError>.class).size());
			//}

			////END_{testValidarTweet_ComprobarTweetValido}
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Throwable e)
		{
			fail("Se ha levantado la siguiente excepción:"+UtilException.printStackTrace(e));
		}
		finally
		{
			postTestValidarTweet_ComprobarTweetValido(ctx);
		}
	}
	/*
	Ayuda: 
		Para insertar en BD un usuario con uno o mas roles y meterlo en sesion:
		Long numIdUser=inyectaUsuarioEnSesionYBD(udb,userSevice "usuario",new String[]{"roles"});

		para insertar datos en BD
		udb.insert(<cadena>) o udb.insert(new File(<fichero))
		
		Para pasar datos al resto del test, usar ctx, que se devuelve 

		La forma mas habitual sera la siguiente:
		File resource = getFileResourceOfClassMethod(this.getClass(),"ComprobarTweetValido","json");// buca el recurso en el mismo path que la clase, con el nombre <nombreClase>_ComprobarTweetValido.json
		if(!resource.exists())
		{
			fail("Fichero de recursos "+resource.getAbsolutePath()+" no encontrado");
		}
		else {
			udb.truncate(resource);
			udb.insert(resource);
			Contexto con=Contexto.get();
			inyectaUsuarioYRolesEnSesion("admin",new String[] {"ADMIN","USER"}); // esta linea si se necesita el usuario en sesion
			ctx.put("fichero", resource); // pasar el fichero a la parte de post
		}
	*/
	public Map<String,Object> preTestValidarTweet_ComprobarTweetValido(Map<String,Object> ctx) throws Throwable
	{
		////START_{preTestValidarTweet_ComprobarTweetValido}
		File resource = getFileResourceOfClassMethod(this.getClass(),"ComprobarTweetValido","json");// buca el recurso en el mismo path que la clase, con el nombre <nombreClase>_ComprobarTweetValido.json
		if(!resource.exists())
		{
			fail("Fichero de recursos "+resource.getAbsolutePath()+" no encontrado");
		}
		else {
			udb.truncate(resource);
			udb.insert(resource);
			Contexto con=Contexto.get();
			inyectaUsuarioYRolesEnSesion("admin",new String[] {"ADMIN","USER"}); // esta linea si se necesita el usuario en sesion
			ctx.put("fichero", resource); // pasar el fichero a la parte de post
		}
		////END_{preTestValidarTweet_ComprobarTweetValido}
		return ctx;
	}
	/*
		Ayuda:
		Para vaciar BD:
		try {
			udb.truncate(new String[] {"jhi_user_authority","jhi_authority","jhi_user"});
		} catch (Throwable e) {
			
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
		En este ejemplo se incluyen los de usuarios, cuidado con el orden de los datos

		La forma mas comun sera:
		File resource=(File) ctx.get("fichero"); //obtiene el recurso empleado en el preTest
		if(resource!=null )
		{
			if(resource.exists())
			{
				udb.truncate(resource);//invierte las tablas y hace el truncate de cada uno de ellas
			}
			else {
				fail("Fichero de recursos "+resource.getAbsolutePath()+" no encontrado");//si no lo encuentra esta mal el test
			}
		}
	*/
	public void postTestValidarTweet_ComprobarTweetValido(Map<String,Object> ctx)
	{
		try {
		
		////START_{postTestValidarTweet_ComprobarTweetValido}
			File resource=(File) ctx.get("fichero"); //obtiene el recurso empleado en el preTest
			if(resource!=null )
			{
				if(resource.exists())
				{
					udb.truncate(resource);//invierte las tablas y hace el truncate de cada uno de ellas
				}
				else {
					fail("Fichero de recursos "+resource.getAbsolutePath()+" no encontrado");//si no lo encuentra esta mal el test
				}
			}
		////END_{postTestValidarTweet_ComprobarTweetValido}
		Contexto.close();
		ctx.clear();
		} catch (Throwable e) {	
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
	}
	// Fin test y funciones auxiliares del metodo ValidarTweet




	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	// Inicio test y funciones auxiliares del metodo ValidarTweet(tweetid)
	/**
	* Test de GestionTweetsLNService.ValidarTweet(tweetid)
	* ___________________________________________________
	* El tweet no existe en BBDD
	* ___________________________________________________
	* Recordatorio: tambien hay que probar casos de error
	* ayudas:
	*
	* Para crear Fechas (Date) de una determinada fecha:
	* Date fechaIni=sdfFechaCompleta.parse("2019-07-07T00:00:00+0000");
	*
	* Para verificar errores:
	*	assertEquals(1, res.getErrores().size());
	*	assertEquals(<ClaseDeError>.class, res.getErrores().get(0).getClass());
	*/
	@Test
	@Transactional
	public void testValidarTweet_ErrorIdNoEncontrado()
	{
		Map<String,Object> ctx=new HashMap<String,Object>();
		try {		
			Result< Vacio > res = new Result<>();
			Contexto con=Contexto.init();
			this.preTestValidarTweet_ErrorIdNoEncontrado(ctx);
			////START_{testValidarTweet_ErrorIdNoEncontrado}
			Long tweetid = 1L ;

			res=serviceLN.ValidarTweet( tweetid ); 
			

			
			if(res.isOk()){
				fail("El res no debe ser válido");
			}
			else {
				assertEquals("Deberia dar un error de tipo ErrorIdNoEncontrado",1,UtilError.findErrorByType(res.getErrores(), ErrorIdNoEncontrado.class).size());
			}

			////END_{testValidarTweet_ErrorIdNoEncontrado}
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Throwable e)
		{
			fail("Se ha levantado la siguiente excepción:"+UtilException.printStackTrace(e));
		}
		finally
		{
			postTestValidarTweet_ErrorIdNoEncontrado(ctx);
		}
	}
	/*
	Ayuda: 
		Para insertar en BD un usuario con uno o mas roles y meterlo en sesion:
		Long numIdUser=inyectaUsuarioEnSesionYBD(udb,userSevice "usuario",new String[]{"roles"});

		para insertar datos en BD
		udb.insert(<cadena>) o udb.insert(new File(<fichero))
		
		Para pasar datos al resto del test, usar ctx, que se devuelve 

		La forma mas habitual sera la siguiente:
		File resource = getFileResourceOfClassMethod(this.getClass(),"ErrorIdNoEncontrado","json");// buca el recurso en el mismo path que la clase, con el nombre <nombreClase>_ErrorIdNoEncontrado.json
		if(!resource.exists())
		{
			fail("Fichero de recursos "+resource.getAbsolutePath()+" no encontrado");
		}
		else {
			udb.truncate(resource);
			udb.insert(resource);
			Contexto con=Contexto.get();
			inyectaUsuarioYRolesEnSesion("admin",new String[] {"ADMIN","USER"}); // esta linea si se necesita el usuario en sesion
			ctx.put("fichero", resource); // pasar el fichero a la parte de post
		}
	*/
	public Map<String,Object> preTestValidarTweet_ErrorIdNoEncontrado(Map<String,Object> ctx) throws Throwable
	{
		////START_{preTestValidarTweet_ErrorIdNoEncontrado}
		//Inserciones en BBDD o similares para probar el metodo
		////END_{preTestValidarTweet_ErrorIdNoEncontrado}
		return ctx;
	}
	/*
		Ayuda:
		Para vaciar BD:
		try {
			udb.truncate(new String[] {"jhi_user_authority","jhi_authority","jhi_user"});
		} catch (Throwable e) {
			
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
		En este ejemplo se incluyen los de usuarios, cuidado con el orden de los datos

		La forma mas comun sera:
		File resource=(File) ctx.get("fichero"); //obtiene el recurso empleado en el preTest
		if(resource!=null )
		{
			if(resource.exists())
			{
				udb.truncate(resource);//invierte las tablas y hace el truncate de cada uno de ellas
			}
			else {
				fail("Fichero de recursos "+resource.getAbsolutePath()+" no encontrado");//si no lo encuentra esta mal el test
			}
		}
	*/
	public void postTestValidarTweet_ErrorIdNoEncontrado(Map<String,Object> ctx)
	{
		try {
		
		////START_{postTestValidarTweet_ErrorIdNoEncontrado}
		//Limpiar lo generado en pre o en el metodo
		////END_{postTestValidarTweet_ErrorIdNoEncontrado}
		Contexto.close();
		ctx.clear();
		} catch (Throwable e) {	
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
	}
	// Fin test y funciones auxiliares del metodo ValidarTweet



	// Fin tests metodo ValidarTweet(tweetid)

////START_{Others}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}


