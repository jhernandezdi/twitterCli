package org.sine95.kernel.base.service;

import java.util.List;

import org.sine95.kernel.base.errores.IError;

public interface IValidator<T extends Object> {
	List<IError> validateInsert(T obj);
	List<IError> validateUpdate(T obj);
	List<IError> validateDelete(T obj);
	
}
