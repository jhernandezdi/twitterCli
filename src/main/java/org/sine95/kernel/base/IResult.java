package org.sine95.kernel.base;

import java.util.List;

import org.sine95.kernel.base.errores.IError;
import org.sine95.kernel.base.errores.IInfo;
import org.sine95.kernel.base.errores.IWarning;

public interface IResult<T> {
	boolean isOk();

	List<IError> getErrores();

	List<IWarning> getWarnings();

	List<IInfo> getInfos();

	Result<T> addError(IError err);

	Result<T> addWarning(IWarning warn);

	Result<T> addInfos(IInfo info);
	
	Result<T> setInfoEWI(IResult res);
	
	T getData();

}
