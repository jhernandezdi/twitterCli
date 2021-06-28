package org.sine95.kernel.base.service;

import java.util.List;

import org.sine95.kernel.base.errores.IError;

public interface IValidatorObj<T extends Object> {
	List<IError> validate(T obj);
	
}
