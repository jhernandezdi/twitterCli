package com.sine95.tweetsrv.service.util;

import java.util.Optional;

import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.service.ServiceCRUD;

import com.sine95.tweetsrv.errores.ErrorIdNoEncontrado;
import com.sine95.tweetsrv.errores.ErrorParamIncorrecto;

public class ServiceUtil {
	public static <T> Result<T> getEntidad(Long id, ServiceCRUD< T ,Long > service)
	{
		Result<T> res = new Result<>();
		if (id==null)
		{
			res.addError(new ErrorParamIncorrecto("id","null"));
			return res;
		}
		if (service==null)
		{
			res.addError(new ErrorParamIncorrecto("service","null"));
			return res;
		}
		Result<Optional<T>> r = service.findById(id);
		if (!r.isOk())
		{
			res.copyStatus(r);
			return res;
		}
		Optional<T> o = r.getData();
		if (!o.isPresent())
		{
			res.addError(new ErrorIdNoEncontrado(service.getCRUDName(),id));
		}
		else res.setData(o.get());
		return res;
	}
/*
	public static <T> Result<Optional<T>> getEntidad(Long id, ServiceCRUD< T ,Long > service)
	{
		Result<Optional<T>> res = new Result<>();
		if (id==null)
		{
			res.addError(new ErrorParamIncorrecto("id","null"));
			return res;
		}
		if (service==null)
		{
			res.addError(new ErrorParamIncorrecto("service","null"));
			return res;
		}
		res = service.findById(id);
		Optional<T> o = res.getData();
		if (!o.isPresent())
		{
			res.addError(new ErrorIdNoEncontrado(service.getCRUDName(),id));
		}
		return res;
	}
*/
}
