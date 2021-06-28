
package com.sine95.tweetsrv.errores;

import com.sine95.tweetsrv.enums.EnumCategoriasErrores;
import org.sine95.kernel.base.errores.IError;
import java.util.*;
import org.sine95.kernel.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Clase generada, no tocar

public class ErrorGeneral implements IError
{

  protected Map<String,String> params=new HashMap<>();
  protected Set<EnumCategoriasErrores> categorias=new HashSet<>();

  private static Logger log = LoggerFactory.getLogger(ErrorGeneral.class);
 
  //Code:SERVER_GEN_001
   
  public ErrorGeneral(
    
   java.lang.Throwable excepcion
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "excepcion", excepcion
      
    );
    
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    if (log.isErrorEnabled()) {
	    log.error("Entrando en ErrorGeneral ("+_params_+"):"+UtilString.toString(stackTrace));
    }
    

    if(excepcion!=null)
      params.put("excepcion",excepcion.toString());
    else 
      params.put("excepcion","<NULL>");
    
    


    categorias.add(EnumCategoriasErrores.ErrorIrrecuperable);

    categorias.add(EnumCategoriasErrores.ErrorFisico);


  }
  

  public ErrorGeneral(
    
   String excepcion
  )
  {
    super();
    String _params_=UtilParams.paramsToString(
   "excepcion", excepcion
      
    );
    
    
    
      params.put("excepcion",excepcion);
    


    categorias.add(EnumCategoriasErrores.ErrorIrrecuperable);

    categorias.add(EnumCategoriasErrores.ErrorFisico);


  }


  
  public void setParams(HashMap<String,String> params)
  {
  	this.params=params;
  }

  @Override
  public String getMensaje()
  {
    return UtilError.genMsg("Se ha producido un error inesperado. Avise a su administrador:((excepcion))",getParams());  
  }

	public String getCode(){
    return "SERVER_GEN_001";
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

