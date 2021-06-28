
package com.sine95.tweetsrv.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.*;
import java.math.*;


import com.sine95.tweetsrv.enums.*;


////START_{Import}
////END_{Import}

/**
* 
*/

@SuppressWarnings("unused")
public class TweetsExt  implements Serializable
{
	private static final long serialVersionUID = 1L;

	//id
	private Long id;
	private Collection< Long > id_IN;
	private Collection< Long > id_NOTIN;

	public Long getId()
	{
		return id;
	}
	public TweetsExt setId(Long _id)
	{
		id=_id;
		return this;
	}
	public Collection< Long > getId_IN()
	{
		return id_IN;
	}
	public TweetsExt setId_IN(Collection< Long > _id)
	{
		id_IN=_id;
		return this;
	}
	public Collection< Long > getId_NOTIN()
	{
		return id_NOTIN;
	}
	public TweetsExt setId_NOTIN(Collection< Long > _id)
	{
		id_NOTIN=_id;
		return this;
	}





	private Long id_DISTINCT;
	private Long id_GREATERTHAN;
	private Long id_GREATEROREQUALTHAN;
	private Long id_LESSTHAN;
	private Long id_LESSOREQUALTHAN;

	public Long getId_DISTINCT()
	{
		return id_DISTINCT;
	}
	public TweetsExt setId_DISTINCT(Long _id)
	{
		id_DISTINCT=_id;
		return this;
	}

	public Long getId_GREATERTHAN()
	{
		return id_GREATERTHAN;
	}
	public TweetsExt setId_GREATERTHAN(Long _id)
	{
		id_GREATERTHAN=_id;
		return this;
	}

	public Long getId_GREATEROREQUALTHAN()
	{
		return id_GREATEROREQUALTHAN;
	}
	public TweetsExt setId_GREATEROREQUALTHAN(Long _id)
	{
		id_GREATEROREQUALTHAN=_id;
		return this;
	}

	public Long getId_LESSTHAN()
	{
		return id_LESSTHAN;
	}
	public TweetsExt setId_LESSTHAN(Long _id)
	{
		id_LESSTHAN=_id;
		return this;
	}

	public Long getId_LESSOREQUALTHAN()
	{
		return id_LESSOREQUALTHAN;
	}
	public TweetsExt setId_LESSOREQUALTHAN(Long _id)
	{
		id_LESSOREQUALTHAN=_id;
		return this;
	}



	//usuario
	private String usuario;
	private Collection< String > usuario_IN;
	private Collection< String > usuario_NOTIN;

	public String getUsuario()
	{
		return usuario;
	}
	public TweetsExt setUsuario(String _usuario)
	{
		usuario=_usuario;
		return this;
	}
	public Collection< String > getUsuario_IN()
	{
		return usuario_IN;
	}
	public TweetsExt setUsuario_IN(Collection< String > _usuario)
	{
		usuario_IN=_usuario;
		return this;
	}
	public Collection< String > getUsuario_NOTIN()
	{
		return usuario_NOTIN;
	}
	public TweetsExt setUsuario_NOTIN(Collection< String > _usuario)
	{
		usuario_NOTIN=_usuario;
		return this;
	}



	private String usuario_LIKE;
	private String usuario_NOTLIKE;

	public String getUsuario_LIKE()
	{
		return usuario_LIKE;
	}
	public TweetsExt setUsuario_LIKE(String _usuario)
	{
		usuario_LIKE=_usuario;
		return this;
	}
	public String getUsuario_NOTLIKE()
	{
		return usuario_NOTLIKE;
	}
	public TweetsExt setUsuario_NOTLIKE(String _usuario)
	{
		usuario_NOTLIKE=_usuario;
		return this;
	}





	//texto
	private String texto;
	private Collection< String > texto_IN;
	private Collection< String > texto_NOTIN;

	public String getTexto()
	{
		return texto;
	}
	public TweetsExt setTexto(String _texto)
	{
		texto=_texto;
		return this;
	}
	public Collection< String > getTexto_IN()
	{
		return texto_IN;
	}
	public TweetsExt setTexto_IN(Collection< String > _texto)
	{
		texto_IN=_texto;
		return this;
	}
	public Collection< String > getTexto_NOTIN()
	{
		return texto_NOTIN;
	}
	public TweetsExt setTexto_NOTIN(Collection< String > _texto)
	{
		texto_NOTIN=_texto;
		return this;
	}



	private String texto_LIKE;
	private String texto_NOTLIKE;

	public String getTexto_LIKE()
	{
		return texto_LIKE;
	}
	public TweetsExt setTexto_LIKE(String _texto)
	{
		texto_LIKE=_texto;
		return this;
	}
	public String getTexto_NOTLIKE()
	{
		return texto_NOTLIKE;
	}
	public TweetsExt setTexto_NOTLIKE(String _texto)
	{
		texto_NOTLIKE=_texto;
		return this;
	}





	//localizacion
	private String localizacion;
	private Collection< String > localizacion_IN;
	private Collection< String > localizacion_NOTIN;

	public String getLocalizacion()
	{
		return localizacion;
	}
	public TweetsExt setLocalizacion(String _localizacion)
	{
		localizacion=_localizacion;
		return this;
	}
	public Collection< String > getLocalizacion_IN()
	{
		return localizacion_IN;
	}
	public TweetsExt setLocalizacion_IN(Collection< String > _localizacion)
	{
		localizacion_IN=_localizacion;
		return this;
	}
	public Collection< String > getLocalizacion_NOTIN()
	{
		return localizacion_NOTIN;
	}
	public TweetsExt setLocalizacion_NOTIN(Collection< String > _localizacion)
	{
		localizacion_NOTIN=_localizacion;
		return this;
	}



	private String localizacion_LIKE;
	private String localizacion_NOTLIKE;

	public String getLocalizacion_LIKE()
	{
		return localizacion_LIKE;
	}
	public TweetsExt setLocalizacion_LIKE(String _localizacion)
	{
		localizacion_LIKE=_localizacion;
		return this;
	}
	public String getLocalizacion_NOTLIKE()
	{
		return localizacion_NOTLIKE;
	}
	public TweetsExt setLocalizacion_NOTLIKE(String _localizacion)
	{
		localizacion_NOTLIKE=_localizacion;
		return this;
	}





	//validacion
	private SiNo validacion;
	private Collection< SiNo > validacion_IN;
	private Collection< SiNo > validacion_NOTIN;

	public SiNo getValidacion()
	{
		return validacion;
	}
	public TweetsExt setValidacion(SiNo _validacion)
	{
		validacion=_validacion;
		return this;
	}
	public Collection< SiNo > getValidacion_IN()
	{
		return validacion_IN;
	}
	public TweetsExt setValidacion_IN(Collection< SiNo > _validacion)
	{
		validacion_IN=_validacion;
		return this;
	}
	public Collection< SiNo > getValidacion_NOTIN()
	{
		return validacion_NOTIN;
	}
	public TweetsExt setValidacion_NOTIN(Collection< SiNo > _validacion)
	{
		validacion_NOTIN=_validacion;
		return this;
	}







	private String orderby[];

	public String [] getOrderBy()
	{
		return orderby;
	}

	public TweetsExt setOrderBy(String[] order)
	{
		orderby=order;
		return this;
	}

	private Integer maxElemsPerPage=10;
	private Integer page=0;

	public Integer  getMaxElemsPerPage()
	{
		return maxElemsPerPage;
	}

	public TweetsExt setMaxElemsPerPage(Integer max)
	{
		maxElemsPerPage=max;
		return this;
	}
	public Integer  getPage()
	{
		return page;
	}

	public TweetsExt setPage(Integer page)
	{
		this.page=page;
		return this;
	}


////START_{Others}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}


