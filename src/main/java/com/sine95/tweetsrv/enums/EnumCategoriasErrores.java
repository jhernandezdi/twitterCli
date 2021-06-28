
package com.sine95.tweetsrv.enums;

/**
* Esta enum se usa para gestionar las categorias en las que los errores se
* compactan. Enum generada. No tocar manualmente. Editar Errores.xml
*/
public enum EnumCategoriasErrores {

  /**
  * Error no dependiente de lógica de negocio
  */
  ErrorFisico 

  /**
  * No se puede hacer nada en este caso
  */
  ,ErrorIrrecuperable 

  /**
  * Errores en las transiciones de la máquina de estados  debidos a incumplimiento de la Lógica de Negocio
  */
  ,SM_LN 

  /**
  * Errores por transiciones no permitidas de la máquina de estados 
  */
  ,SM_TE 

}
