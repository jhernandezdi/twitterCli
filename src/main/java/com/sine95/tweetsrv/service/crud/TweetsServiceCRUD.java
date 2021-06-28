
package com.sine95.tweetsrv.service.crud;

import java.util.*;
import java.util.stream.Collectors;

import com.sine95.tweetsrv.service.crud.validator.*;

import org.sine95.kernel.util.*;
import org.sine95.kernel.base.repository.RepositoryBase;
import org.sine95.kernel.base.service.ServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.sine95.tweetsrv.domain.*;
//import com.sine95.tweetsrv.repository.*;
//import com.sine95.tweetsrv.service.crud.*;
import com.sine95.tweetsrv.domain.*;
import com.sine95.tweetsrv.errores.*;
import org.sine95.kernel.base.Result;
import com.sine95.tweetsrv.repository.TweetsRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sine95.tweetsrv.service.Config;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.context.ApplicationContext;
import javax.persistence.EntityManager;
//import com.sine95.tweetsrv.domain.*; // for static metamodels



////START_{Import}
////END_{Import}


@Service
//@Transactional
@SuppressWarnings("unused")
public class TweetsServiceCRUD extends ServiceCRUD< Tweets ,Long > {

	private final Logger log = LoggerFactory.getLogger(TweetsServiceCRUD.class);

////START_{Autowired}
////END_{Autowired}
	@Autowired
    protected EntityManager entityManager;

	@Autowired
    protected ApplicationContext appContext;

	

	
	@Autowired
	private TweetsRepository repository;
	

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	public TweetsRepository  getRepositoryPublic(){
		return repository;
	}

	public TweetsServiceCRUD() {
		super();
		addValidator(new TweetsValidator(this));


		////START_{constructor}
		////END_{constructor}
	}

	@Override
	public String getCRUDName()
	{
		return "Tweets";
	}	

	@Override
	public Result<List< Tweets >> listByExample(Tweets example) {

		Result<List< Tweets >> res=new Result<>();
		try {
			Example< Tweets > examp=Example.of(example);
			res.setData(repository.findAll(examp));

		}catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}
	
	public Result<Vacio> delete(Long id) {
		Result<Vacio> res=new Result<>();
		if (id==null) {
			res.addError(new ErrorCampoObligatorio("Tweets","id"));
			return res;
		}
		// Levantamos la Tweets
		Result< Tweets > rI = findWithResult(id);
		if (!rI.isOk()) return res.copyStatus(rI);
		Tweets i = rI.getData();
		// Eliminamos la Tweets
		try {
			res.copyStatus(delete(i));
		} catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	public Result<Page< Tweets >> listByExample(Tweets example, Pageable page) {

		Result<Page< Tweets >> res=new Result<>();
		try {
			Example< Tweets > examp=Example.of(example);
			res.setData(repository.findAll(examp,page));

		}catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	protected RepositoryBase< Tweets , Long > getRepository()
	{
		return repository;
	}

	/**
	 * Busca una instancia de la entidad por su id
	 * Si el id es nulo lanza una IllegalArgumentException
	 * Si no encuentra la instancia devuelve un null 
	 * @param id Identificador de la instancia
	 * @return La instancia de la entidad o null si no la encuentra
	 */
	protected Tweets findWithNull(Long id) throws IllegalArgumentException
	{
		Optional< Tweets > optional = repository.findById(id);
		if (!optional.isPresent()) return null;
		return optional.get();
	}

	/**
	 * Busca una instancia de la entidad por su id y lo devuelve en un Result<...>
	 * Si el id es nulo, devuelve un ErrorCampoObligatorio
	 * Si no encuentra la instancia, devuelve un ErrorIdNoEncontrado 
	 * @param id Identificador de la instancia
	 * @return Siempre devuelve un result, con la instancia de la entidad si la encuentra encontrada o null en caso contrario
	 */
	public Result< Tweets > findWithResult(Long id)
	{
		Result< Tweets > res = new Result<>();
		Tweets o = null;
		try {
			o = findWithNull(id);
		} catch (IllegalArgumentException iae) {
			res.addError(new ErrorParamObligatorio("id"));
		} catch (Exception e) {
			res.addError(new ErrorGeneral(e));
		}
		if (o==null) res.addError(new ErrorIdNoEncontrado("Tweets",id));
	
		res.setData(o);
		return res;
	}

	@Override
	protected Result< Tweets > findWithResultFromObject(Tweets obj)
	{

		return findWithResult(obj.getId());
	}
	
	



	@Override
	protected Result< Vacio > copyFieldsUpdate(Tweets src, Tweets dest)
	{
    	dest.usuario(src.getUsuario());
    	dest.texto(src.getTexto());
    	dest.localizacion(src.getLocalizacion());
    	dest.validacion(src.getValidacion());

		Result< Vacio > res = new Result<>();
		res.setData(new Vacio());
		return res;
	}

    /**
     * Return a {@link List} of {@link Tweets } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    public Result< List< Tweets >> listByCriteria(TweetsCrit criteria) {
				Result<List< Tweets >> res=new Result<>();
				try {
					if (log.isInfoEnabled()) log.info("find by criteria : {}", criteria);
	        final Specification< Tweets > specification = createSpecification(criteria);
					res.setData(repository.findAll(specification));
				}catch(Exception e)
				{
					res.addError(new ErrorGeneral(e));
				}
				return res;
    }

    /**
     * Return a {@link Page} of {@link Tweets } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    public  Result< Page< Tweets >> listByCriteriaPaged(TweetsCritPaged criteria) {
			Result<Page< Tweets >> res=new Result<>();
			try {
				TweetsCrit crit = criteria.getCrit();
				Pageable pag = criteria.getPag();

				////START_{listByCriteriaPaged}
				////END_{listByCriteriaPaged}
				
        		if (log.isInfoEnabled()) log.info("find by criteria : {}, page: {}", crit, pag);
        		final Specification< Tweets > specification = createSpecification(crit);
        		res.setData(repository.findAll(specification, pag));
			}catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
			}
			return res;
    }
/*
	@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
	@StaticMetamodel(Tweets.class)
	public abstract class Tweets_ {
		
		public static volatile SingularAttribute< Tweets , Long > id;
		
		public static volatile SingularAttribute< Tweets , String > usuario;
		
		public static volatile SingularAttribute< Tweets , String > texto;
		
		public static volatile SingularAttribute< Tweets , String > localizacion;
		
		public static volatile SingularAttribute< Tweets , null > validacion;
		

	}*/
    /**
     * Function to convert TweetsCriteria to a {@link Specification}
     */
    private Specification< Tweets > createSpecification(TweetsCrit criteria) {
        Specification< Tweets > specification = Specification.where(null);
        if (criteria != null) {

            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Tweets_.id));
            }


            if (criteria.getUsuario() != null) {
                specification = specification.and(buildStringSpecification(criteria.getUsuario(), Tweets_.usuario));
            }


            if (criteria.getTexto() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTexto(), Tweets_.texto));
            }


            if (criteria.getLocalizacion() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLocalizacion(), Tweets_.localizacion));
            }


            if (criteria.getValidacion() != null) {
                specification = specification.and(buildSpecification(criteria.getValidacion(), Tweets_.validacion));
            }


        }
        return specification;
    }

// Metodos para gestionar las relaciones


	//@Override
	public void preInsert(Tweets data) {
		////START_{preInsert}
		////END_{preInsert}
	}

	//@Override
	public void preUpdate(Tweets data,Tweets userData,Result< Tweets > res) {
		////START_{preUpdate}
		////END_{preUpdate}	
	}

	//@Override
	public void preDelete(Tweets data) {
		////START_{preDelete}
		////END_{preDelete}
	}

	@Override
	public void postInsert(Tweets data) {
		////START_{postInsert}
		////END_{postInsert}
	}

	@Override
	public void postUpdate(Tweets data) {
		////START_{postUpdate}
		////END_{postUpdate}	
	}

	@Override
	public void postDelete(Tweets data) {
		////START_{postDelete}
		////END_{postDelete}
	}

// LN DE CRUD

// FIN DE LN DE CRUD

	@Autowired
	EntityManager em;
	public Result<Page< Tweets >> listByExampleExt(TweetsExt obj/*, Pageable page*/)
	{
		Result<Page< Tweets >> res= new Result<>();
		String from=" FROM  Tweets AS obj ";
		String head=new String("SELECT obj "+from);
		Map<String,Object> params=new HashMap<>();
		//where
		String where;
		StringBuilder sbWhere=new StringBuilder("");


		if(obj.getId()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ0",obj.getId());
			sbWhere.append(" obj.id = :OBJ0 ");
		}
		if(obj.getId_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ1",obj.getId_IN());
			sbWhere.append(" obj.id IN :OBJ1 ");
		}
		if(obj.getId_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ2",obj.getId_NOTIN());
			sbWhere.append(" obj.id NOT IN :OBJ2 ");
		}

		if(obj.getId_DISTINCT()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ3",obj.getId_DISTINCT());
			sbWhere.append(" obj.id <> :OBJ3 ");
		}
	
		if(obj.getId_GREATERTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ4",obj.getId_GREATERTHAN());
			sbWhere.append(" obj.id > :OBJ4 ");
		}
	
		if(obj.getId_GREATEROREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ5",obj.getId_GREATEROREQUALTHAN());
			sbWhere.append(" obj.id >= :OBJ5 ");
		}
	
		if(obj.getId_LESSTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ6",obj.getId_LESSTHAN());
			sbWhere.append(" obj.id < :OBJ6 ");
		}
	
		if(obj.getId_LESSOREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ7",obj.getId_LESSOREQUALTHAN());
			sbWhere.append(" obj.id <= :OBJ7 ");
		}

		if(obj.getUsuario()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ8",obj.getUsuario());
			sbWhere.append(" obj.usuario = :OBJ8 ");
		}
		if(obj.getUsuario_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ9",obj.getUsuario_IN());
			sbWhere.append(" obj.usuario IN :OBJ9 ");
		}
		if(obj.getUsuario_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ10",obj.getUsuario_NOTIN());
			sbWhere.append(" obj.usuario NOT IN :OBJ10 ");
		}

		if(obj.getUsuario_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ11",obj.getUsuario_LIKE());
			sbWhere.append(" obj.usuario LIKE :OBJ11 ");
		}
		if(obj.getUsuario_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ12",obj.getUsuario_NOTLIKE());
			sbWhere.append(" obj.usuario NOT LIKE :OBJ12 ");
		}

		if(obj.getTexto()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ13",obj.getTexto());
			sbWhere.append(" obj.texto = :OBJ13 ");
		}
		if(obj.getTexto_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ14",obj.getTexto_IN());
			sbWhere.append(" obj.texto IN :OBJ14 ");
		}
		if(obj.getTexto_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ15",obj.getTexto_NOTIN());
			sbWhere.append(" obj.texto NOT IN :OBJ15 ");
		}

		if(obj.getTexto_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ16",obj.getTexto_LIKE());
			sbWhere.append(" obj.texto LIKE :OBJ16 ");
		}
		if(obj.getTexto_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ17",obj.getTexto_NOTLIKE());
			sbWhere.append(" obj.texto NOT LIKE :OBJ17 ");
		}

		if(obj.getLocalizacion()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ18",obj.getLocalizacion());
			sbWhere.append(" obj.localizacion = :OBJ18 ");
		}
		if(obj.getLocalizacion_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ19",obj.getLocalizacion_IN());
			sbWhere.append(" obj.localizacion IN :OBJ19 ");
		}
		if(obj.getLocalizacion_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ20",obj.getLocalizacion_NOTIN());
			sbWhere.append(" obj.localizacion NOT IN :OBJ20 ");
		}

		if(obj.getLocalizacion_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ21",obj.getLocalizacion_LIKE());
			sbWhere.append(" obj.localizacion LIKE :OBJ21 ");
		}
		if(obj.getLocalizacion_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ22",obj.getLocalizacion_NOTLIKE());
			sbWhere.append(" obj.localizacion NOT LIKE :OBJ22 ");
		}

		if(obj.getValidacion()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ23",obj.getValidacion());
			sbWhere.append(" obj.validacion = :OBJ23 ");
		}
		if(obj.getValidacion_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ24",obj.getValidacion_IN());
			sbWhere.append(" obj.validacion IN :OBJ24 ");
		}
		if(obj.getValidacion_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ25",obj.getValidacion_NOTIN());
			sbWhere.append(" obj.validacion NOT IN :OBJ25 ");
		}

		if(sbWhere.length()>0){
			 where=" WHERE "+sbWhere.toString();
		}
		else where="";
		//orderby
		String orderby;
		StringBuilder sbOrderby=new StringBuilder("");
		if(obj.getOrderBy()!=null)
		{
			for(String orden:obj.getOrderBy())
			{
				if(sbOrderby.length()>0) sbOrderby.append(",");
				if(orden.contains(":"))
				{
					String [] partes=orden.split(":");
					sbOrderby.append(partes[0]);
					if("A".equalsIgnoreCase(partes[1])
						|| "ASC".equalsIgnoreCase(partes[1])
					)
					{
						sbOrderby.append("ASC");
					}
					else{
						sbOrderby.append("DESC");
					}
				}
				else {
					sbOrderby.append(orden).append(" ASC");
				}
			}
		}

		if(sbOrderby.length()>0) orderby=" ORDER BY "+sbOrderby.toString();
		else orderby="";
		
		String sQuery = head+where+orderby;
		Query query = em.createQuery(sQuery,Tweets.class);
//		Query queryNUM = em.createQuery("Select count(obj) "+from+where);
		if(params.size()>0)
		{
			for(String key:params.keySet())
			{
				query.setParameter(key, params.get(key));
//				queryNUM.setParameter(key, params.get(key));
			}
		}
		try {
//			int num=(int) queryNUM.getSingleResult();
			@SuppressWarnings("unchecked")
			List< Tweets > lista=(List< Tweets >)query.getResultList();
			int num = lista.size();
	
			Page< Tweets > page=new org.sine95.kernel.base.PageBase< Tweets >(num,obj.getMaxElemsPerPage(),obj.getPage(),lista);
			res.setData(page);
		}catch(Throwable t)
		{
			res.addError(new ErrorGeneral(t));
			if (log.isErrorEnabled()) log.error("Error por Excepcion. Excepcion:"+UtilException.printStackTrace(t));
		}
		return res;
	}

////START_{Others}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}
