package org.sine95.kernel.base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.sine95.kernel.base.errores.IError;

public class UtilResult {

	public static List<IError> findErrorOfClass(IResult<?> result,Class<? extends IError> clase)
	{
		List<IError> res=new ArrayList<IError>();
		
		List<IError> resAux =(List<IError>) result.getErrores().parallelStream().filter(err->{
			return err.getClass()==clase;
		}).collect(Collectors.toList());
		res.addAll(resAux);
		return res;
	}
}
