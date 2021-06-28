
package com.sine95.tweetsrv.infos;

import com.sine95.tweetsrv.enums.EnumCategoriasErrores;
import org.sine95.kernel.base.errores.IInfo;
import java.util.*;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Clase generada, no tocar

public class InfoEnvioCorreoBienvenida implements IInfo
{

  protected Map<String,String> params=new HashMap<>();
  protected Set<EnumCategoriasErrores> categorias=new HashSet<>();

  private static Logger log = LoggerFactory.getLogger(InfoEnvioCorreoBienvenida.class);
 
  //Code:EMAIL_SEND_BIENVENIDA
 
  public InfoEnvioCorreoBienvenida()
  {
  	super();
    
    String _params_=UtilParams.paramsToString();
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    if (log.isInfoEnabled()) {
	    log.info("Entrando en InfoEnvioCorreoBienvenida ("+_params_+"):"+UtilString.toString(stackTrace));
    }

  }

  
  public void setParams(HashMap<String,String> params)
  {
  	this.params=params;
  }

  @Override
  public String getMensaje()
  {
    return UtilError.genMsg("Se le ha enviado un correo de Bienvenida. Revise su correo",getParams());  
  }

	public String getCode(){
    return "EMAIL_SEND_BIENVENIDA";
  }

	public Map<String, Object> getParams()
  {
    HashMap<String,Object> res= new HashMap<>();
    res.putAll(params);
    return res;
  }

  public boolean isPerteneceCategoria(EnumCategoriasErrores categ)
  {
    return categorias.contains(categ);
  }

  public Set<EnumCategoriasErrores> getCategorias()
  {
    Set<EnumCategoriasErrores> res=new HashSet<>();
    res.addAll(categorias);
    return res;
  }
  @Override
  public String toString()
  {
    return "Info:"+getCode()+"["+getMensaje()+"]";
  }
}

