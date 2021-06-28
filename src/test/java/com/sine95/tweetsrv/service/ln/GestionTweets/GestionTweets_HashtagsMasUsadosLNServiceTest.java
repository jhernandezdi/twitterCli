
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
////END_{Import}

/**
* Logica de negocio para los tweets
*/

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TweetsrvApp.class)
public class GestionTweets_HashtagsMasUsadosLNServiceTest extends GestionTweetsLNServiceTest
{

////START_{AutoWired}
////END_{AutoWired}

////START_{Init}
////END_{Init}

    
	// Inicio tests metodo HashtagsMasUsados(info)
	/* Descripcion del metodo:
	* Consultar una clasificación de los N hashtags más usados.
	*/
      

	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	// Inicio test y funciones auxiliares del metodo HashtagsMasUsados(info)
	/**
	* Test de GestionTweetsLNService.HashtagsMasUsados(info)
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
	public void testHashtagsMasUsados_DevuelveListaVacia()
	{
		Map<String,Object> ctx=new HashMap<String,Object>();
		try {		
			Result< List <Hashtags> > res = new Result<>();
			Contexto con=Contexto.init();
			this.preTestHashtagsMasUsados_DevuelveListaVacia(ctx);
			////START_{testHashtagsMasUsados_DevuelveListaVacia}
			In_GestionTweets_TweetsMasUsados info = new In_GestionTweets_TweetsMasUsados() ;

			res=serviceLN.HashtagsMasUsados( info ); 
			//Comprobacion todo correcto
			if(res.isOk()){
				assertEquals(0,res.getData().size());
			}
			else {
				fail("El res no es válido");
			}


			////END_{testHashtagsMasUsados_DevuelveListaVacia}
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
			postTestHashtagsMasUsados_DevuelveListaVacia(ctx);
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
	public Map<String,Object> preTestHashtagsMasUsados_DevuelveListaVacia(Map<String,Object> ctx) throws Throwable
	{
		////START_{preTestHashtagsMasUsados_DevuelveListaVacia}
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
		////END_{preTestHashtagsMasUsados_DevuelveListaVacia}
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
	public void postTestHashtagsMasUsados_DevuelveListaVacia(Map<String,Object> ctx)
	{
		try {
		
		////START_{postTestHashtagsMasUsados_DevuelveListaVacia}
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
		////END_{postTestHashtagsMasUsados_DevuelveListaVacia}
		Contexto.close();
		ctx.clear();
		} catch (Throwable e) {	
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
	}
	// Fin test y funciones auxiliares del metodo HashtagsMasUsados




	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	// Inicio test y funciones auxiliares del metodo HashtagsMasUsados(info)
	/**
	* Test de GestionTweetsLNService.HashtagsMasUsados(info)
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
	public void testHashtagsMasUsados_Devuelve1()
	{
		Map<String,Object> ctx=new HashMap<String,Object>();
		try {		
			Result< List <Hashtags> > res = new Result<>();
			Contexto con=Contexto.init();
			this.preTestHashtagsMasUsados_Devuelve1(ctx);
			////START_{testHashtagsMasUsados_Devuelve1}
			In_GestionTweets_TweetsMasUsados info = new In_GestionTweets_TweetsMasUsados() ;

			res=serviceLN.HashtagsMasUsados( info ); 
			
			if(res.isOk()){
				assertEquals(1,res.getData().size());
				assertEquals(150,res.getData().get(0).getContador().intValue());
				assertEquals("#HolaMundo",res.getData().get(0).getHashtags());
			}
			else {
				fail("El res no es válido");
			}

			////END_{testHashtagsMasUsados_Devuelve1}
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
			postTestHashtagsMasUsados_Devuelve1(ctx);
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
	public Map<String,Object> preTestHashtagsMasUsados_Devuelve1(Map<String,Object> ctx) throws Throwable
	{
		////START_{preTestHashtagsMasUsados_Devuelve1}
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
		////END_{preTestHashtagsMasUsados_Devuelve1}
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
	public void postTestHashtagsMasUsados_Devuelve1(Map<String,Object> ctx)
	{
		try {
		
		////START_{postTestHashtagsMasUsados_Devuelve1}
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
		////END_{postTestHashtagsMasUsados_Devuelve1}
		Contexto.close();
		ctx.clear();
		} catch (Throwable e) {	
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
	}
	// Fin test y funciones auxiliares del metodo HashtagsMasUsados




	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	// Inicio test y funciones auxiliares del metodo HashtagsMasUsados(info)
	/**
	* Test de GestionTweetsLNService.HashtagsMasUsados(info)
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
	public void testHashtagsMasUsados_DevuelveMaxParametro()
	{
		Map<String,Object> ctx=new HashMap<String,Object>();
		try {		
			Result< List <Hashtags> > res = new Result<>();
			Contexto con=Contexto.init();
			this.preTestHashtagsMasUsados_DevuelveMaxParametro(ctx);
			////START_{testHashtagsMasUsados_DevuelveMaxParametro}
			In_GestionTweets_TweetsMasUsados info = new In_GestionTweets_TweetsMasUsados(3) ;

			res=serviceLN.HashtagsMasUsados( info ); 
			
			if(res.isOk()){
				assertEquals(3,res.getData().size());
				assertEquals(1,res.getData().get(0).getId().intValue());
				assertEquals(2,res.getData().get(1).getId().intValue());
				assertEquals(4,res.getData().get(2).getId().intValue());
			}
			else {
				fail("El res no es válido");
			}

			////END_{testHashtagsMasUsados_DevuelveMaxParametro}
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
			postTestHashtagsMasUsados_DevuelveMaxParametro(ctx);
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
	public Map<String,Object> preTestHashtagsMasUsados_DevuelveMaxParametro(Map<String,Object> ctx) throws Throwable
	{
		////START_{preTestHashtagsMasUsados_DevuelveMaxParametro}
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
		////END_{preTestHashtagsMasUsados_DevuelveMaxParametro}
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
	public void postTestHashtagsMasUsados_DevuelveMaxParametro(Map<String,Object> ctx)
	{
		try {
		
		////START_{postTestHashtagsMasUsados_DevuelveMaxParametro}
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
		////END_{postTestHashtagsMasUsados_DevuelveMaxParametro}
		Contexto.close();
		ctx.clear();
		} catch (Throwable e) {	
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
	}
	// Fin test y funciones auxiliares del metodo HashtagsMasUsados




	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	// Inicio test y funciones auxiliares del metodo HashtagsMasUsados(info)
	/**
	* Test de GestionTweetsLNService.HashtagsMasUsados(info)
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
	public void testHashtagsMasUsados_DevuelveMaxSinParametro()
	{
		Map<String,Object> ctx=new HashMap<String,Object>();
		try {		
			Result< List <Hashtags> > res = new Result<>();
			Contexto con=Contexto.init();
			this.preTestHashtagsMasUsados_DevuelveMaxSinParametro(ctx);
			////START_{testHashtagsMasUsados_DevuelveMaxSinParametro}
			In_GestionTweets_TweetsMasUsados info = new In_GestionTweets_TweetsMasUsados() ;

			res=serviceLN.HashtagsMasUsados( info ); 
			
			if(res.isOk()){
				assertEquals(2,res.getData().size());
				assertEquals(1,res.getData().get(0).getId().intValue());
				assertEquals(2,res.getData().get(1).getId().intValue());
			}
			else {
				fail("El res no es válido");
			}

			////END_{testHashtagsMasUsados_DevuelveMaxSinParametro}
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
			postTestHashtagsMasUsados_DevuelveMaxSinParametro(ctx);
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
	public Map<String,Object> preTestHashtagsMasUsados_DevuelveMaxSinParametro(Map<String,Object> ctx) throws Throwable
	{
		////START_{preTestHashtagsMasUsados_DevuelveMaxSinParametro}
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
		////END_{preTestHashtagsMasUsados_DevuelveMaxSinParametro}
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
	public void postTestHashtagsMasUsados_DevuelveMaxSinParametro(Map<String,Object> ctx)
	{
		try {
		
		////START_{postTestHashtagsMasUsados_DevuelveMaxSinParametro}
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
		////END_{postTestHashtagsMasUsados_DevuelveMaxSinParametro}
		Contexto.close();
		ctx.clear();
		} catch (Throwable e) {	
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
	}
	// Fin test y funciones auxiliares del metodo HashtagsMasUsados



	// Fin tests metodo HashtagsMasUsados(info)

////START_{Others}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}

