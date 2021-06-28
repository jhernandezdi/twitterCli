package org.sine95.kernel.base;

import java.util.ArrayList;
import java.util.List;

import org.sine95.kernel.base.errores.IError;
import org.sine95.kernel.base.errores.IInfo;
import org.sine95.kernel.base.errores.IWarning;
import org.sine95.kernel.base.errores.RestError;

public  class ResultRest<T>  {
	
	protected List<RestError> errores=new ArrayList<>();
	protected List<RestError> warnings=new ArrayList<>();
	protected List<RestError> infos=new ArrayList<>();
	
	protected T data;
	
	protected boolean ok;
	
	
	

	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public T getData() {
		return data;
	}
	public ResultRest<T> setData(T data) {
		this.data = data;
		return this;
	}
	
	
	
	
	
	

	public List<RestError> getErrores() {
		return errores;
	}
	public void setErrores(List<RestError> errores) {
		this.errores = errores;
	}
	public List<RestError> getWarnings() {
		return warnings;
	}
	public void setWarnings(List<RestError> warnings) {
		this.warnings = warnings;
	}
	public List<RestError> getInfos() {
		return infos;
	}
	public void setInfos(List<RestError> infos) {
		this.infos = infos;
	}
	@Override
	public String toString() {
		return "ResultRest [errores=" + errores + ", warnings=" + warnings + ", infos=" + infos + ", data=" + data
				+ ", isOk()=" + isOk() + "]";
	}

	 

}
