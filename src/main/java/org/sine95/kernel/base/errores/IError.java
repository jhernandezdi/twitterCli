package org.sine95.kernel.base.errores;

import java.util.Map;

import com.juanma.twitterCli.enums.EnumCategoriasErrores;

public interface IError {
	public String getMensaje();
	public String getCode();
	public Map<String, Object> getParams();
	public boolean isPerteneceCategoria(EnumCategoriasErrores categ);
}
