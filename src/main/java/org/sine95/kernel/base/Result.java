package org.sine95.kernel.base;

import java.util.ArrayList;
import java.util.List;

import org.sine95.kernel.base.errores.IError;
import org.sine95.kernel.base.errores.IInfo;
import org.sine95.kernel.base.errores.IWarning;

public  class Result<T> implements IResult<T> {
	
	protected List<IError> errores=new ArrayList<>();
	protected List<IWarning> warnings=new ArrayList<>();
	protected List<IInfo> infos=new ArrayList<>();
	
	protected T data;
	
	public boolean isOk()
	{
		return errores.size()==0;
	}
	
	public List<IInfo> getInfos() {
		return infos;
	}

	public Result<T> setInfos(List<IInfo> infos) {
		this.infos = infos;
		return this;
	}

	public T getData() {
		return data;
	}
	public Result<T> setData(T data) {
		this.data = data;
		return this;
	}
	public List<IError> getErrores() {
		return errores;
	}
	public List<IWarning> getWarnings() {
		return warnings;
	}
	
	public Result<T> addError(IError err)
	{
		errores.add(err);
		return this;
	}
	
	public Result<T> addWarning(IWarning warn)
	{
		warnings.add(warn);
		return this;
	}
	
	public Result<T> addInfos(IInfo info)
	{
		infos.add(info);
		return this;
	}
	public Result<T> addErrores(List<IError> errs)
	{
		if(errs!=null && errs.size()>0)
			errores.addAll(errs);
		return this;
	}
	
	public Result<T> addWarnings(List<IWarning> warn)
	{
		if(warn!=null && warn.size()>0)
			warnings.addAll(warn);
		return this;
	}
	public Result<T> addInfos(List<IInfo> _infos)
	{
		if(_infos!=null && _infos.size()>0)
			infos.addAll(_infos);
		return this;
	}
	@Override
	@SuppressWarnings("unchecked")
	public Result<T> setInfoEWI(@SuppressWarnings("rawtypes")IResult res) {
		addErrores(res.getErrores());
		addWarnings(res.getWarnings());
		addInfos(res.getInfos());
		return this;
	}
	
	
	
	public Result<T> clear()
	{
		addErrores(new ArrayList<>());
		addWarnings(new ArrayList<>());
		addInfos(new ArrayList<>());
		return this;
	}

	@Override
	public String toString() {
		return "Result [errores=" + errores + ", warnings=" + warnings + ", infos=" + infos + ", data=" + data
				+ ", isOk()=" + isOk() + "]";
	}

	@SuppressWarnings("unchecked")
	public Result<T> copyStatus(@SuppressWarnings("rawtypes") IResult r)
	{
		this.addErrores(r.getErrores());
		this.addWarnings(r.getWarnings());
		this.addInfos(r.getInfos());
		return this;
	}

	public Result<T> copy( Result<T> r)
	{
		setData(r.getData());
		setInfoEWI(r);
		return this;
	} 

}
