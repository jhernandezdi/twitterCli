
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
    


////START_{Import}
////END_{Import}

/**
* Logica de negocio para los tweets
*/

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TwitterCliApp.class)
public class GestionTweets_TweetsMasUsadosLNServiceTest extends GestionTweetsLNServiceTest
{

////START_{AutoWired}
////END_{AutoWired}

////START_{Init}
////END_{Init}

    
	// Inicio tests metodo TweetsMasUsados(info)
	/* Descripcion del metodo:
	* Consultar una clasificación de los N hashtags más usados.
	*/
      

	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	// Inicio test y funciones auxiliares del metodo TweetsMasUsados(info)
	/**
	* Test de GestionTweetsLNService.TweetsMasUsados(info)
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
	public void testTweetsMasUsados_DevuelveListaVacia()
	{
		Map<String,Object> ctx=new HashMap<String,Object>();
		try {		
			Result< List <Hashtags> > res = new Result<>();
			Contexto con=Contexto.init();
			this.preTestTweetsMasUsados_DevuelveListaVacia(ctx);
			////START_{testTweetsMasUsados_DevuelveListaVacia}
			throw new UnsupportedOperationException();


			//In_GestionTweets_TweetsMasUsados info = ... ;

			//res=serviceLN.TweetsMasUsados( info ); 
			//Comprobacion todo correcto
			//if(res.isOk()){
			//	assertEquals(1,res.getData().getXXXX());
			//}
			//else {
			//	fail("El res no es válido");
			//}

			//Comprobacion de tipo Error
			//if(res.isOk()){
			//	fail("El res no es válido");
			//}
			//else {
			//	assertEquals("Deberia dar un error de tipo <TipoError>",1,UtilError.findErrorByType(res.getErrores(), <TipoError>.class).size());
			//}

			////END_{testTweetsMasUsados_DevuelveListaVacia}
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
			postTestTweetsMasUsados_DevuelveListaVacia(ctx);
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
	public Map<String,Object> preTestTweetsMasUsados_DevuelveListaVacia(Map<String,Object> ctx) throws Throwable
	{
		////START_{preTestTweetsMasUsados_DevuelveListaVacia}
		//Inserciones en BBDD o similares para probar el metodo
		////END_{preTestTweetsMasUsados_DevuelveListaVacia}
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
	public void postTestTweetsMasUsados_DevuelveListaVacia(Map<String,Object> ctx)
	{
		try {
		
		////START_{postTestTweetsMasUsados_DevuelveListaVacia}
		//Limpiar lo generado en pre o en el metodo
		////END_{postTestTweetsMasUsados_DevuelveListaVacia}
		Contexto.close();
		ctx.clear();
		} catch (Throwable e) {	
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
	}
	// Fin test y funciones auxiliares del metodo TweetsMasUsados




	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	// Inicio test y funciones auxiliares del metodo TweetsMasUsados(info)
	/**
	* Test de GestionTweetsLNService.TweetsMasUsados(info)
	* ___________________________________________________
	* Devuelve un dato
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
	public void testTweetsMasUsados_Devuelve1()
	{
		Map<String,Object> ctx=new HashMap<String,Object>();
		try {		
			Result< List <Hashtags> > res = new Result<>();
			Contexto con=Contexto.init();
			this.preTestTweetsMasUsados_Devuelve1(ctx);
			////START_{testTweetsMasUsados_Devuelve1}
			throw new UnsupportedOperationException();


			//In_GestionTweets_TweetsMasUsados info = ... ;

			//res=serviceLN.TweetsMasUsados( info ); 
			//Comprobacion todo correcto
			//if(res.isOk()){
			//	assertEquals(1,res.getData().getXXXX());
			//}
			//else {
			//	fail("El res no es válido");
			//}

			//Comprobacion de tipo Error
			//if(res.isOk()){
			//	fail("El res no es válido");
			//}
			//else {
			//	assertEquals("Deberia dar un error de tipo <TipoError>",1,UtilError.findErrorByType(res.getErrores(), <TipoError>.class).size());
			//}

			////END_{testTweetsMasUsados_Devuelve1}
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
			postTestTweetsMasUsados_Devuelve1(ctx);
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
		File resource = getFileResourceOfClassMethod(this.getClass(),"Devuelve1","json");// buca el recurso en el mismo path que la clase, con el nombre <nombreClase>_Devuelve1.json
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
	public Map<String,Object> preTestTweetsMasUsados_Devuelve1(Map<String,Object> ctx) throws Throwable
	{
		////START_{preTestTweetsMasUsados_Devuelve1}
		//Inserciones en BBDD o similares para probar el metodo
		////END_{preTestTweetsMasUsados_Devuelve1}
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
	public void postTestTweetsMasUsados_Devuelve1(Map<String,Object> ctx)
	{
		try {
		
		////START_{postTestTweetsMasUsados_Devuelve1}
		//Limpiar lo generado en pre o en el metodo
		////END_{postTestTweetsMasUsados_Devuelve1}
		Contexto.close();
		ctx.clear();
		} catch (Throwable e) {	
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
	}
	// Fin test y funciones auxiliares del metodo TweetsMasUsados




	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	// Inicio test y funciones auxiliares del metodo TweetsMasUsados(info)
	/**
	* Test de GestionTweetsLNService.TweetsMasUsados(info)
	* ___________________________________________________
	* Devuelve Max pasando Max por parametro
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
	public void testTweetsMasUsados_DevuelveMaxParametro()
	{
		Map<String,Object> ctx=new HashMap<String,Object>();
		try {		
			Result< List <Hashtags> > res = new Result<>();
			Contexto con=Contexto.init();
			this.preTestTweetsMasUsados_DevuelveMaxParametro(ctx);
			////START_{testTweetsMasUsados_DevuelveMaxParametro}
			throw new UnsupportedOperationException();


			//In_GestionTweets_TweetsMasUsados info = ... ;

			//res=serviceLN.TweetsMasUsados( info ); 
			//Comprobacion todo correcto
			//if(res.isOk()){
			//	assertEquals(1,res.getData().getXXXX());
			//}
			//else {
			//	fail("El res no es válido");
			//}

			//Comprobacion de tipo Error
			//if(res.isOk()){
			//	fail("El res no es válido");
			//}
			//else {
			//	assertEquals("Deberia dar un error de tipo <TipoError>",1,UtilError.findErrorByType(res.getErrores(), <TipoError>.class).size());
			//}

			////END_{testTweetsMasUsados_DevuelveMaxParametro}
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
			postTestTweetsMasUsados_DevuelveMaxParametro(ctx);
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
		File resource = getFileResourceOfClassMethod(this.getClass(),"DevuelveMaxParametro","json");// buca el recurso en el mismo path que la clase, con el nombre <nombreClase>_DevuelveMaxParametro.json
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
	public Map<String,Object> preTestTweetsMasUsados_DevuelveMaxParametro(Map<String,Object> ctx) throws Throwable
	{
		////START_{preTestTweetsMasUsados_DevuelveMaxParametro}
		//Inserciones en BBDD o similares para probar el metodo
		////END_{preTestTweetsMasUsados_DevuelveMaxParametro}
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
	public void postTestTweetsMasUsados_DevuelveMaxParametro(Map<String,Object> ctx)
	{
		try {
		
		////START_{postTestTweetsMasUsados_DevuelveMaxParametro}
		//Limpiar lo generado en pre o en el metodo
		////END_{postTestTweetsMasUsados_DevuelveMaxParametro}
		Contexto.close();
		ctx.clear();
		} catch (Throwable e) {	
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
	}
	// Fin test y funciones auxiliares del metodo TweetsMasUsados




	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	// Inicio test y funciones auxiliares del metodo TweetsMasUsados(info)
	/**
	* Test de GestionTweetsLNService.TweetsMasUsados(info)
	* ___________________________________________________
	* Devuelve Max sin pasar Max por parametro
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
	public void testTweetsMasUsados_DevuelveMaxSinParametro()
	{
		Map<String,Object> ctx=new HashMap<String,Object>();
		try {		
			Result< List <Hashtags> > res = new Result<>();
			Contexto con=Contexto.init();
			this.preTestTweetsMasUsados_DevuelveMaxSinParametro(ctx);
			////START_{testTweetsMasUsados_DevuelveMaxSinParametro}
			throw new UnsupportedOperationException();


			//In_GestionTweets_TweetsMasUsados info = ... ;

			//res=serviceLN.TweetsMasUsados( info ); 
			//Comprobacion todo correcto
			//if(res.isOk()){
			//	assertEquals(1,res.getData().getXXXX());
			//}
			//else {
			//	fail("El res no es válido");
			//}

			//Comprobacion de tipo Error
			//if(res.isOk()){
			//	fail("El res no es válido");
			//}
			//else {
			//	assertEquals("Deberia dar un error de tipo <TipoError>",1,UtilError.findErrorByType(res.getErrores(), <TipoError>.class).size());
			//}

			////END_{testTweetsMasUsados_DevuelveMaxSinParametro}
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
			postTestTweetsMasUsados_DevuelveMaxSinParametro(ctx);
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
		File resource = getFileResourceOfClassMethod(this.getClass(),"DevuelveMaxSinParametro","json");// buca el recurso en el mismo path que la clase, con el nombre <nombreClase>_DevuelveMaxSinParametro.json
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
	public Map<String,Object> preTestTweetsMasUsados_DevuelveMaxSinParametro(Map<String,Object> ctx) throws Throwable
	{
		////START_{preTestTweetsMasUsados_DevuelveMaxSinParametro}
		//Inserciones en BBDD o similares para probar el metodo
		////END_{preTestTweetsMasUsados_DevuelveMaxSinParametro}
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
	public void postTestTweetsMasUsados_DevuelveMaxSinParametro(Map<String,Object> ctx)
	{
		try {
		
		////START_{postTestTweetsMasUsados_DevuelveMaxSinParametro}
		//Limpiar lo generado en pre o en el metodo
		////END_{postTestTweetsMasUsados_DevuelveMaxSinParametro}
		Contexto.close();
		ctx.clear();
		} catch (Throwable e) {	
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
	}
	// Fin test y funciones auxiliares del metodo TweetsMasUsados



	// Fin tests metodo TweetsMasUsados(info)

////START_{Others}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}

