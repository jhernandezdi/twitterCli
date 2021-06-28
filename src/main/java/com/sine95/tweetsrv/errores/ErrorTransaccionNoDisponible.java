
package com.sine95.tweetsrv.errores;

import com.sine95.tweetsrv.enums.EnumCategoriasErrores;
import org.sine95.kernel.base.errores.IError;
import java.util.*;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Clase generada, no tocar

public class ErrorTransaccionNoDisponible implements IError
{

  protected Map<String,String> params=new HashMap<>();
  protected Set<EnumCategoriasErrores> categorias=new HashSet<>();

  private static Logger log = LoggerFactory.getLogger(ErrorTransaccionNoDisponible.class);
 
  //Code:SERVER_TX_001
 
  public ErrorTransaccionNoDisponible()
  {
  	super();
    
    String _params_=UtilParams.paramsToString();
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    if (log.isErrorEnabled()) {
	    log.error("Entrando en ErrorTransaccionNoDisponible ("+_params_+"):"+UtilString.toString(stackTrace));
    }

  }

  
  public void setParams(HashMap<String,String> params)
  {
  	this.params=params;
  }

  @Override
  public String getMensaje()
  {
    return UtilError.genMsg("No hay transacción disponible en el contexto. Si el método en el que se produjo este error está marcado como transaccional, el problema puede venir de que se haya cerrado la transacción explícitamente en algún punto antes del error, o bien que se esté invocando el método desde otro método NO transaccional de la misma clase (si se invoca localmente NO se está pasando a través de los proxies de gestión de tx de Spring Persistence, así pues si el método desde el que se invoca no es transaccional no le llegaría Tx en el contexto).",getParams());  
  }

	public String getCode(){
    return "SERVER_TX_001";
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

