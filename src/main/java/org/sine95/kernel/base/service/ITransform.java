package org.sine95.kernel.base.service;

public interface ITransform<T extends Object> {

	T transformPreInsert(T obj);
	T transformPostInsert(T obj);
	T transformPreUpdate(T obj);
	T transformPostUpdate(T obj);
	T transformPreDelete(T obj);
}
