package org.sine95.kernel.base.errores;

import java.util.Map;

import com.sine95.tweetsrv.enums.EnumCategoriasErrores;

public interface IError {
	public String getMensaje();
	public String getCode();
	public Map<String, Object> getParams();
	public boolean isPerteneceCategoria(EnumCategoriasErrores categ);
}
