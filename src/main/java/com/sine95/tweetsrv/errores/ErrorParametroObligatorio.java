
package com.sine95.tweetsrv.errores;

import com.sine95.tweetsrv.enums.EnumCategoriasErrores;
import org.sine95.kernel.base.errores.IError;
import java.util.*;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Clase generada, no tocar

public class ErrorParametroObligatorio implements IError
{

  protected Map<String,String> params=new HashMap<>();
  protected Set<EnumCategoriasErrores> categorias=new HashSet<>();

  private static Logger log = LoggerFactory.getLogger(ErrorParametroObligatorio.class);
 
  //Code:PARAM_OBLIG
   
  public ErrorParametroObligatorio(
    
   String parametro
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "parametro", parametro
      
    );
    
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    if (log.isErrorEnabled()) {
	    log.error("Entrando en ErrorParametroObligatorio ("+_params_+"):"+UtilString.toString(stackTrace));
    }
    

    if(parametro!=null)
      params.put("parametro",parametro.toString());
    else 
      params.put("parametro","<NULL>");
    
    



  }
  


  
  public void setParams(HashMap<String,String> params)
  {
  	this.params=params;
  }

  @Override
  public String getMensaje()
  {
    return UtilError.genMsg("El parámetro ((parametro)) es obligatorio",getParams());  
  }

	public String getCode(){
    return "PARAM_OBLIG";
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

