
package com.juanma.twitterCli.service.ln.ClienteTwitter;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanma.twitterCli.TwitterCliApp;
import com.juanma.twitterCli.domain.Configuration;
import com.juanma.twitterCli.domain.Tweets;
import com.juanma.twitterCli.domain.TweetsCrit;
import com.juanma.twitterCli.domain.TweetsCritPaged;
import com.juanma.twitterCli.domain.TweetsExt;
import com.juanma.twitterCli.errores.*;
import com.juanma.twitterCli.repository.UtilDB;
import com.juanma.twitterCli.service.Config;
import com.juanma.twitterCli.service.crud.ConfigurationServiceCRUD;
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
* Logica de negocio para el acceso a Twitter
*/

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TwitterCliApp.class)
public class ClienteTwitter_InitLNServiceTest extends ClienteTwitterLNServiceTest
{

////START_{AutoWired}
////END_{AutoWired}

////START_{Init}
////END_{Init}

    
	// Inicio tests metodo Init()
	/* Descripcion del metodo:
	* Arranca la escucha de twits
	*/
      

	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	//*****************************************************************************
	// Inicio test y funciones auxiliares del metodo Init()
	/**
	* Test de ClienteTwitterLNService.Init()
	* ___________________________________________________
	* Por hacer
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
	public void testInit_porHacer()
	{
		Map<String,Object> ctx=new HashMap<String,Object>();
		try {		
			Result< Vacio > res = new Result<>();
			Contexto con=Contexto.init();
			this.preTestInit_porHacer(ctx);
			////START_{testInit_porHacer}
			throw new UnsupportedOperationException();


			//res=serviceLN.Init(  ); 
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

			////END_{testInit_porHacer}
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
			postTestInit_porHacer(ctx);
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
		File resource = getFileResourceOfClassMethod(this.getClass(),"porHacer","json");// buca el recurso en el mismo path que la clase, con el nombre <nombreClase>_porHacer.json
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
	public Map<String,Object> preTestInit_porHacer(Map<String,Object> ctx) throws Throwable
	{
		////START_{preTestInit_porHacer}
		//Inserciones en BBDD o similares para probar el metodo
		////END_{preTestInit_porHacer}
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
	public void postTestInit_porHacer(Map<String,Object> ctx)
	{
		try {
		
		////START_{postTestInit_porHacer}
		//Limpiar lo generado en pre o en el metodo
		////END_{postTestInit_porHacer}
		Contexto.close();
		ctx.clear();
		} catch (Throwable e) {	
			e.printStackTrace();
			fail("Error en vaciado de tablas");
		}
	}
	// Fin test y funciones auxiliares del metodo Init



	// Fin tests metodo Init()

////START_{Others}
////END_{Others}

/*
////DELETE_START
////START_{testInit_ComprobarTweetValido}
			throw new UnsupportedOperationException();


			//res=serviceLN.Init(  ); 
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

			////END_{testInit_ComprobarTweetValido}

////START_{preTestInit_ComprobarTweetValido}
		//Inserciones en BBDD o similares para probar el metodo
		////END_{preTestInit_ComprobarTweetValido}

////START_{postTestInit_ComprobarTweetValido}
		//Limpiar lo generado en pre o en el metodo
		////END_{postTestInit_ComprobarTweetValido}

////START_{testInit_ErrorIdNoEncontrado}
			throw new UnsupportedOperationException();


			//res=serviceLN.Init(  ); 
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

			////END_{testInit_ErrorIdNoEncontrado}

////START_{preTestInit_ErrorIdNoEncontrado}
		//Inserciones en BBDD o similares para probar el metodo
		////END_{preTestInit_ErrorIdNoEncontrado}

////START_{postTestInit_ErrorIdNoEncontrado}
		//Limpiar lo generado en pre o en el metodo
		////END_{postTestInit_ErrorIdNoEncontrado}

////DELETE_END
*/
}


