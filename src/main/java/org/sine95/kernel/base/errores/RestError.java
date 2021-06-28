package org.sine95.kernel.base.errores;

import java.util.HashMap;
import java.util.Map;

public class RestError {

	private String mensaje;
	private String code;
	private Map<String,Object> params=new HashMap<>();
	
	
	
	public RestError() {
		super();
	}
	
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	
	
	
}
