package org.sine95.kernel.base.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.repository.RepositoryBase;
import org.sine95.kernel.util.UtilException;
import org.sine95.kernel.util.Vacio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.sine95.tweetsrv.errores.ErrorGeneral;
import com.sine95.tweetsrv.errores.ErrorIdNoEncontrado;

import io.github.jhipster.service.QueryService;



public abstract class ServiceCRUD<T extends Object,ID> extends QueryService<T>{
	
	
	
	private final Logger log = LoggerFactory.getLogger(ServiceCRUD.class);

	private List<IValidator<T>> validadores = new ArrayList<>();
	private List<ITransform<T>> transforms = new ArrayList<>();
	
	

	abstract public String getCRUDName();

	public void addValidator(IValidator<T> val) {
		validadores.add(val);
	}

	public void resetValidators() {
		validadores.clear();
	}

	public void addTransform(ITransform<T> trans) {
		transforms.add(trans);
	}

	public void resetTransforms() {
		transforms.clear();
	}
	
	public Result<T> insert(T obj)
	{
		log.debug("Insert:"+obj);
		Result<T> res=new Result<>();
		try {
			for(IValidator<T> val:validadores)
			{
				res.addErrores(val.validateInsert(obj));
			}
			
			if(!res.isOk())
			{
				log.error("Insert:"+obj+"->"+res.getErrores());
				return res;
			}
			for(ITransform<T> trans:transforms)
			{
				trans.transformPreInsert(obj);
			}
			preInsert(obj);
			obj=getRepository().save(obj);
			for(ITransform<T> trans:transforms)
			{
				obj=trans.transformPostInsert(obj);
			}
			postInsert(obj);
			res.setData(obj);
			
			log.debug("Insert:"+obj+":OK");
		}catch(Exception e)
		{
			log.error("Error Insert:"+obj+"->"+UtilException.printStackTrace(e));
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	
	
	public Result<T> update(T obj)
	{
		Result<T> res=new Result<>();
		log.debug("Update:"+obj);
		try {
			for(IValidator<T> val:validadores)
			{
				res.addErrores(val.validateUpdate(obj));
			}
			if(!res.isOk()) {
				log.error("Update:"+obj+"->"+res.getErrores());
				return res;
			}
			T objUpdate=null;
			Result<T> rObj=findWithResultFromObject(obj);
			if(rObj.isOk())
			{
				objUpdate=rObj.getData();
			}
			else
			{
				return res.copyStatus(rObj);
			}
			if(objUpdate!=null)
			{
				copyFieldsUpdate(obj,objUpdate);
			}
			for(ITransform<T> trans:transforms)
			{
				trans.transformPreUpdate(objUpdate);
			}
			preUpdate(objUpdate,obj,res);
			if(res.isOk())
			{
				obj=getRepository().save(objUpdate);
				for(ITransform<T> trans:transforms)
				{
					obj=trans.transformPostUpdate(obj);
				}
				postUpdate(obj);
				res.setData(obj);
			}
			log.debug("Update:"+obj+":OK");
		}catch(Exception e)
		{
			log.error("Error Insert:"+obj+"->"+UtilException.printStackTrace(e));
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

//	protected abstract Result<Optional<T>> findByIdToUpdate(T obj);
	
	protected abstract Result<T> findWithResultFromObject(T obj);

	protected abstract Result<Vacio> copyFieldsUpdate(T obj, T objUpdate);

	public Result<T> delete(T obj)
	{
		Result<T> res=new Result<>();
		log.debug("Delete:"+obj);
		try {
			for(IValidator<T> val:validadores)
			{
				res.addErrores(val.validateDelete(obj));
			}
			
			if(!res.isOk()) {
				log.error("Delete:"+obj+"->"+res.getErrores());
				return res;
			}
			for(ITransform<T> trans:transforms)
			{
				trans.transformPreDelete(obj);
			}
			preDelete(obj);
			getRepository().delete(obj);
			postDelete(obj);
			
			
		}catch(Exception e)
		{
			log.error("Error Delete:"+obj+"->"+UtilException.printStackTrace(e));
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	
	
	public abstract Result<List<T>> listByExample(T example);
	public abstract Result<Page<T>> listByExample(T example,Pageable page);
	
	protected abstract RepositoryBase<T, ID> getRepository();
/*
	public <S extends T> S save(S entity) {
		return repository.save(entity);
	}
*/
	public <S extends T> Result<Optional<S>> findOne(Example<S> example) {
		Result<Optional<S>> res = new Result<>();
		res.setData(getRepository().findOne(example));
		return res;
	}

	public Result<Page<T>> findAll(Pageable pageable) {
		Result<Page<T>> res = new Result<>();
		res.setData(getRepository().findAll(pageable));
		return res;
	}

	public Result<List<T>> findAll() {
		Result<List<T>> res = new Result<>();
		res.setData(getRepository().findAll());
		return res;
	}

	public Result<List<T>> findAll(Sort sort) {
		Result<List<T>> res = new Result<>();
		res.setData(getRepository().findAll(sort));
		return res;
	}

	public Result<Optional<T>> findById(ID id) {
		Result<Optional<T>> res = new Result<>();
		Optional<T> opt = getRepository().findById(id); 
		res.setData(opt);
		if(opt.isEmpty())
		{
			res.addError(new ErrorIdNoEncontrado(getCRUDName() , id));
		}
		return res;
	}

	public T find(ID id) {
		Result<Optional<T>> res = new Result<>();
		Optional<T> opt = getRepository().findById(id); 
		res.setData(opt);
		if(opt.isEmpty())
		{
			return null;
		}
		return res.getData().get();
	}
	

	public Result<List<T>> findAllById(Iterable<ID> ids) {
		Result<List<T>> res = new Result<>();
		res.setData(getRepository().findAllById(ids));
		return res;
	}
/*
	public <S extends T> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}
*/
	public boolean existsById(ID id) {
		return getRepository().existsById(id);
	}

	public void flush() {
		getRepository().flush();
	}
/*
	public <S extends T> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	public void deleteInBatch(Iterable<T> entities) {
		repository.deleteInBatch(entities);
	}
*/
	public <S extends T> Result<Page<S>> findAll(Example<S> example, Pageable pageable) {
		Result<Page<S>> res = new Result<>();
		res.setData(getRepository().findAll(example, pageable));
		return res;
	}

	public long count() {
		return getRepository().count();
	}
/*
	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	public void deleteById(ID id) {
		repository.deleteById(id);
	}

	public T getOne(ID id) {
		return repository.getOne(id);
	}

	public void delete(T entity) {
		repository.delete(entity);
	}
*/
	public <S extends T> long count(Example<S> example) {
		return getRepository().count(example);
	}
/*
	public void deleteAll(Iterable<? extends T> entities) {
		repository.deleteAll(entities);
	}
*/
	public <S extends T> Result<List<S>> findAll(Example<S> example) {
		Result<List<S>> res = new Result<>();
		res.setData(getRepository().findAll(example));
		return res;
	}

	public <S extends T> boolean exists(Example<S> example) {
		return getRepository().exists(example);
	}

	public Result<Vacio> deleteAll() {
		log.debug("DeleteAll:"+this.getClass().getCanonicalName());
		Result<Vacio> res = new Result<>();
		getRepository().deleteAll();
		res.setData(new Vacio());
		return res;
	}

	public <S extends T> Result<List<S>> findAll(Example<S> example, Sort sort) {
		Result<List<S>> res = new Result<>();
		res.setData(getRepository().findAll(example, sort));
		return res;
	}
	
	public abstract void preInsert(T data);
	public abstract void postInsert(T data);
	public abstract void preUpdate(T data,T obj,Result<T> res);
	public abstract void postUpdate(T data);
	public abstract void preDelete(T data);
	public abstract void postDelete(T data);
}
