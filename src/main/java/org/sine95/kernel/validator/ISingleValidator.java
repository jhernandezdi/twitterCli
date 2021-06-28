package org.sine95.kernel.validator;

import java.util.List;
import java.util.Map;

import org.sine95.kernel.base.errores.IError;

public interface ISingleValidator {
	void init(Map<String,Object> params);

	List<IError> validate(Object obj);
}
