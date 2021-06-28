
package com.juanma.twitterCli.service.ln.GestionTweets;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanma.twitterCli.TwitterCliApp;
import com.juanma.twitterCli.domain.Configuration;
import com.juanma.twitterCli.domain.Hashtags;
import com.juanma.twitterCli.domain.HashtagsCrit;
import com.juanma.twitterCli.domain.HashtagsCritPaged;
import com.juanma.twitterCli.domain.HashtagsExt;
import com.juanma.twitterCli.domain.In_GestionTweets_TweetsMasUsados;
import com.juanma.twitterCli.domain.Tweets;
import com.juanma.twitterCli.domain.TweetsCrit;
import com.juanma.twitterCli.domain.TweetsCritPaged;
import com.juanma.twitterCli.domain.TweetsExt;
import com.juanma.twitterCli.enums.SiNo;
import com.juanma.twitterCli.errores.*;
import com.juanma.twitterCli.repository.UtilDB;
import com.juanma.twitterCli.service.Config;
import com.juanma.twitterCli.service.crud.ConfigurationServiceCRUD;
import com.juanma.twitterCli.service.crud.HashtagsServiceCRUD;
import com.juanma.twitterCli.service.crud.TweetsServiceCRUD;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.sine95.kernel.base.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import org.sine95.kernel.base.test.*;
import org.sine95.kernel.base.Contexto;

import java.util.*;
import java.io.*;
import java.util.*;
import org.springframework.context.ApplicationContext;

/**
* Logica de negocio para los tweets
*/

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TwitterCliApp.class)
public class GestionTweets_TweetsLNServiceTest extends GestionTweetsLNServiceTest
{

////START_{AutoWired}
////END_{AutoWired}

////START_{Init}
////END_{Init}

    
	// Inicio tests metodo Tweets()
	/* Descripcion del metodo:
	* Consultar los tweets
	*/
      

	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	// Inicio test y funciones auxiliares del metodo Tweets()
	/**
	* Test de GestionTweetsLNService.Tweets()
	* ___________________________________________________
	* Sin datos
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
	public void testTweets_DevuelveListaVacia()
	{
		Map<String,Object> ctx=new HashMap<String,Object>();
		try {		
			Result< List <Tweets> > res = new Result<>();
			Contexto con=Contexto.init();
			this.preTestTweets_DevuelveListaVacia(ctx);
			////START_{testTweets_DevuelveListaVacia}
			res=serviceLN.Tweets(  ); 
			//Comprobacion todo correcto
			if(res.isOk()){
				assertEquals(0,res.getData().size());
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

			////END_{testTweets_DevuelveListaVacia}
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
			postTestTweets_DevuelveListaVacia(ctx);
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
		File resource = getFileResourceOfClassMethod(this.getClass(),"DevuelveListaVacia","json");// buca el recurso en el mismo path que la clase, con el nombre <nombreClase>_DevuelveListaVacia.json
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
	public Map<String,Object> preTestTweets_DevuelveListaVacia(Map<String,Object> ctx) throws Throwable
	{
		////START_{preTestTweets_DevuelveListaVacia}
		File resource = getFileResourceOfClassMethod(this.getClass(),"DevuelveListaVacia","json");// buca el recurso en el mismo path que la clase, con el nombre <nombreClase>_DevuelveListaVacia.json
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
		////END_{preTestTweets_DevuelveListaVacia}
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
	public void postTestTweets_DevuelveListaVacia(Map<String,Object> ctx)
	{
		try {
		
		////START_{postTestTweets_DevuelveListaVacia}
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
		////END_{postTestTweets_DevuelveListaVacia}
		Contexto.close();
		ctx.clear();
		} catch (Throwable e) {	
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
	}
	// Fin test y funciones auxiliares del metodo Tweets




	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	// Inicio test y funciones auxiliares del metodo Tweets()
	/**
	* Test de GestionTweetsLNService.Tweets()
	* ___________________________________________________
	* Devolvemos dos datos
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
	public void testTweets_DevuelveLista()
	{
		Map<String,Object> ctx=new HashMap<String,Object>();
		try {		
			Result< List <Tweets> > res = new Result<>();
			Contexto con=Contexto.init();
			this.preTestTweets_DevuelveLista(ctx);
			////START_{testTweets_DevuelveLista}
			res=serviceLN.Tweets(  ); 
			//Comprobacion todo correcto
			if(res.isOk()){
				assertEquals(2,res.getData().size());
				assertEquals(SiNo.N,res.getData().get(0).getValidacion());
				assertEquals(SiNo.S,res.getData().get(1).getValidacion());
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

			////END_{testTweets_DevuelveLista}
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
			postTestTweets_DevuelveLista(ctx);
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
		File resource = getFileResourceOfClassMethod(this.getClass(),"DevuelveLista","json");// buca el recurso en el mismo path que la clase, con el nombre <nombreClase>_DevuelveLista.json
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
	public Map<String,Object> preTestTweets_DevuelveLista(Map<String,Object> ctx) throws Throwable
	{
		////START_{preTestTweets_DevuelveLista}
		File resource = getFileResourceOfClassMethod(this.getClass(),"DevuelveLista","json");// buca el recurso en el mismo path que la clase, con el nombre <nombreClase>_DevuelveLista.json
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
		////END_{preTestTweets_DevuelveLista}
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
	public void postTestTweets_DevuelveLista(Map<String,Object> ctx)
	{
		try {
		
		////START_{postTestTweets_DevuelveLista}
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
		////END_{postTestTweets_DevuelveLista}
		Contexto.close();
		ctx.clear();
		} catch (Throwable e) {	
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
	}
	// Fin test y funciones auxiliares del metodo Tweets



	// Fin tests metodo Tweets()

////START_{Others}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}


