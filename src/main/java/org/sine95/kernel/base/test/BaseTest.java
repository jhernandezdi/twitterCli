package org.sine95.kernel.base.test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.sine95.kernel.base.Contexto;

import com.juanma.twitterCli.repository.UtilDB;

/**
 * Clase base para los Tests de JUnit
 * 
 * @author juanma.h
 *
 */
@SuppressWarnings("unused")
public class BaseTest {
	
	protected static SimpleDateFormat sdfFechaCompleta=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"); 
	protected static SimpleDateFormat sdfFechaCompletaSinZ=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	protected Long setCredentialsInBD(UtilDB udb, boolean activo, boolean createRol)
	{
		return setCredentialsInBD(udb, "test",new String[] { "rol"}, activo, createRol);
	}
	
	protected Long setCredentialsInBD(UtilDB udb, String login, String rol, boolean activo, boolean createRol)
	{
		return setCredentialsInBD(udb,login, new String[] {rol}, activo, createRol);
	}

	protected Long setCredentialsInBD(UtilDB udb, String login, String[] roles, boolean activo, boolean createRol)
	{
		Long userId = setUser(udb, login, activo);
		
		if (createRol) {
			for(String rol:roles)
			{
				setRol(udb, rol);
				setUserRol(udb, userId, rol);
			}
		}
		
		
		return userId;
	}

//	protected void setUser(UserService userService, String login, String rol, boolean activo)
	protected Long setUser(UtilDB udb, String login, boolean activo)
	{
/*
		UserDTO u = new UserDTO();
		u.setActivated(activo); // NO lo usa el m�todo createUser. Considero que es un error
		u.setFirstName(login);
		u.setCreatedBy("user");
		u.setCreatedDate(Instant.now());
		u.setLogin(login);
//		u.setPassword("AAAAAAAAAAA");
		User user = userService.createUser(u);
		u.setId(user.getId());
		userService.updateUser(u); // Es surrealista: el updateUser SI que tiene en cuenta el campo activated

		Set<Authority> authorities = new HashSet<>();
		Authority auth = new Authority();
		auth.setName(rol);
		AuthorityRepository kk;
		kk.save(auth);
		authorities.add(auth);
		user.setAuthorities(authorities);
*/
		String iUser =  
				"[\r\n" + 
				"	{\r\n" + 
				"		\"tabla\":\"jhi_user\",\r\n" + 
				"		\"meta\":[\r\n" + 
				"			{\"nombre\":\"id\"                ,\"tipo\":\"Int\"},\r\n" + 
				"			{\"nombre\":\"created_by\"        ,\"tipo\":\"String\"},\r\n" + 
				"			{\"nombre\":\"created_date\"      ,\"tipo\":\"Date\"},\r\n" + 
				"			{\"nombre\":\"last_modified_by\"  ,\"tipo\":\"String\"},\r\n" + 
				"			{\"nombre\":\"last_modified_date\",\"tipo\":\"Date\"},\r\n" + 
				"			{\"nombre\":\"activated\"         ,\"tipo\":\"Boolean\"},\r\n" + 
				"			{\"nombre\":\"activation_key\"    ,\"tipo\":\"String\"},\r\n" + 
				"			{\"nombre\":\"email\"             ,\"tipo\":\"String\"},\r\n" + 
				"			{\"nombre\":\"first_name\"        ,\"tipo\":\"String\"},\r\n" + 
				"			{\"nombre\":\"image_url\"         ,\"tipo\":\"String\"},\r\n" + 
				"			{\"nombre\":\"lang_key\"          ,\"tipo\":\"String\"},\r\n" + 
				"			{\"nombre\":\"last_name\"         ,\"tipo\":\"String\"},\r\n" + 
				"			{\"nombre\":\"login\"             ,\"tipo\":\"String\"},\r\n" + 
				"			{\"nombre\":\"password_hash\"     ,\"tipo\":\"String\"},\r\n" + 
				"			{\"nombre\":\"reset_date\"        ,\"tipo\":\"Date\"},\r\n" + 
				"			{\"nombre\":\"reset_key\"         ,\"tipo\":\"String\"},\r\n" + 
				"			{\"nombre\":\"scale\"             ,\"tipo\":\"Integer\"}\r\n" + 
				"		],\r\n" + 
				"		\"data\":[\r\n" + 
				"			{\r\n" + 
				"				\"id\"           :${id},\r\n" + 
				"				\"created_by\"   :\"${created_by}\",\r\n" + 
				"				\"created_date\" :\"${created_date}\",\r\n" + 
				"				\"activated\"    :${activated}, \r\n" + 
				"				\"login\"        :\"${login}\",\r\n" + 
				"				\"password_hash\":\"${password_hash}\"\r\n" + 
				"			}\r\n" + 
				"		]\r\n" + 
				"		\r\n" + 
				"	}\r\n" + 
				"]\r\n" + 
				"";
		Long id = new Date().getTime();
		iUser = iUser.replace("${id}"           ,Long.toString(id));
		iUser = iUser.replace("${created_by}"   ,"admin");
		iUser = iUser.replace("${created_date}" ,"2019-06-05 00:00:00");
		iUser = iUser.replace("${activated}"    ,Boolean.toString(activo));
		iUser = iUser.replace("${login}"        ,login);
		iUser = iUser.replace("${password_hash}","XXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
		try {
			udb.insert(iUser);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	protected void setRol(UtilDB udb, String rol)
	{
		String iAut = "[\r\n" + 
				"	{\r\n" + 
				"		\"tabla\":\"jhi_authority\",\r\n" + 
				"		\"meta\":[\r\n" + 
				"			{\"nombre\":\"name\"              ,\"tipo\":\"String\"}\r\n" + 
				"		],\r\n" + 
				"		\"data\":[\r\n" + 
				"			{\r\n" + 
				"				\"name\"         :${rol}\r\n" + 
				"			}\r\n" + 
				"		]\r\n" + 
				"		\r\n" + 
				"	}\r\n" + 
				"]";
		iAut = iAut.replace("${rol}",rol);
		try {
			udb.insert(iAut);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void setUserRol(UtilDB udb, Long userId, String rol)
	{
		String iUsuRol = "[\r\n" + 
				"	{\r\n" + 
				"		\"tabla\":\"jhi_user_authority\",\r\n" + 
				"		\"meta\":[\r\n" + 
				"			{\"nombre\":\"user_id\"       ,\"tipo\":\"Integer\"},\r\n" + 
				"			{\"nombre\":\"authority_name\",\"tipo\":\"String\"}\r\n" + 
				"		],\r\n" + 
				"		\"data\":[\r\n" + 
				"			{\r\n" + 
				"				\"user_id\"         :${user_id},\r\n" + 
				"				\"authority_name\":${authority_name}\r\n" + 
				"			}\r\n" + 
				"		]\r\n" + 
				"		\r\n" + 
				"	}\r\n" + 
				"]\r\n" + 
				"";
		iUsuRol = iUsuRol.replace("${user_id}",Long.toString(userId));
		iUsuRol = iUsuRol.replace("${authority_name}",rol);
		try {
			udb.insert(iUsuRol);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
/*
	protected void inyectaUsuarioEnSesionYBD(UtilDB udb, UserService userService, String login, String rol)
	{
		inyectaUsuarioEnSesionYBD(udb, userService, login, new String[] {rol},true);
	}
	protected Long inyectaUsuarioEnSesionYBD(UtilDB udb, UserService userService, String login, String[] roles,boolean toBD) {
		inyectaUsuarioYRolesEnSesion(login, roles);
		// Tambi�n tenemos que a�adirlo a la BD porque los m�todos de UserService obtienen el usuario de la sesi�n, pero los permisos/roles de la BD
		if (toBD) 
		{
			return setCredentialsInBD(udb, login, roles, true, true);
		}
		return -1L;
	}
*/
	protected void inyectaUsuarioYRolesEnSesion(String login, String[] roles) {
		// Primero inyectamos el usuario en la sesi�n
		Contexto ctx=Contexto.get();
		ctx.put(Contexto.LOGIN, login);
		ctx.put(Contexto.GRUPOS, roles);
		ctx.put( Contexto.ID_SESION, "1");
	}
	
	@SuppressWarnings("rawtypes")
	public File getFileResourceOfClassMethod(Class clase,String nombreMetodo,String extension)
	{
		ClassLoader classLoader = getClass().getClassLoader();
		String partes[]=clase.getSimpleName().split("_");
		String nom="";
		for(int i=1;i<partes.length;i++)
		{
			if(i!=1)
			{
				nom+="_";
			}
			nom+=partes[i];
		}
		String nombre=clase.getPackage().getName().replace(".", "/")+
				"/"+nom.replace("LNServiceTest","").replace("TaskServiceTest","")+"/";
		nombre+=nombreMetodo+"."+extension;

		URL uFile = classLoader.getResource(nombre);
		if (uFile == null)
		{
			System.out.println("No se pudo acceder al fichero para carga de datos de Test solicitado: "+nombre);
			return new File("Fichero_No_Encontrado:"+nombre);
		}
		File file = new File(uFile.getFile());
		/*try {
			System.out.println(file.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return file;
	}
}

