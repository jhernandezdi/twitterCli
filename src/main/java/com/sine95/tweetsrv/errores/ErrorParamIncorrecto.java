
package com.sine95.tweetsrv.errores;

import com.sine95.tweetsrv.enums.EnumCategoriasErrores;
import org.sine95.kernel.base.errores.IError;
import java.util.*;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Clase generada, no tocar

public class ErrorParamIncorrecto implements IError
{

  protected Map<String,String> params=new HashMap<>();
  protected Set<EnumCategoriasErrores> categorias=new HashSet<>();

  private static Logger log = LoggerFactory.getLogger(ErrorParamIncorrecto.class);
 
  //Code:SERVER_GEN_002
   
  public ErrorParamIncorrecto(
    
   String nombre
  , String razon
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "nombre", nombre
  , "razon", razon
      
    );
    
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    if (log.isErrorEnabled()) {
	    log.error("Entrando en ErrorParamIncorrecto ("+_params_+"):"+UtilString.toString(stackTrace));
    }
    

    if(nombre!=null)
      params.put("nombre",nombre.toString());
    else 
      params.put("nombre","<NULL>");
    
    

    if(razon!=null)
      params.put("razon",razon.toString());
    else 
      params.put("razon","<NULL>");
    
    



  }
  


  
  public void setParams(HashMap<String,String> params)
  {
  	this.params=params;
  }

  @Override
  public String getMensaje()
  {
    return UtilError.genMsg("Parametro incorrecto. El parametro ((nombre)) no es valido. Razon: ((razon))",getParams());  
  }

	public String getCode(){
    return "SERVER_GEN_002";
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
    return "Error:"+getCode()+"["+getMensaje()+"]";
  }
}

