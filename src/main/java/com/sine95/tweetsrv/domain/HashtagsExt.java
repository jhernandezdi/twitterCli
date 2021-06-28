
package com.sine95.tweetsrv.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.*;
import java.math.*;



////START_{Import}
////END_{Import}

/**
* 
*/

@SuppressWarnings("unused")
public class HashtagsExt  implements Serializable
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
	public HashtagsExt setId(Long _id)
	{
		id=_id;
		return this;
	}
	public Collection< Long > getId_IN()
	{
		return id_IN;
	}
	public HashtagsExt setId_IN(Collection< Long > _id)
	{
		id_IN=_id;
		return this;
	}
	public Collection< Long > getId_NOTIN()
	{
		return id_NOTIN;
	}
	public HashtagsExt setId_NOTIN(Collection< Long > _id)
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
	public HashtagsExt setId_DISTINCT(Long _id)
	{
		id_DISTINCT=_id;
		return this;
	}

	public Long getId_GREATERTHAN()
	{
		return id_GREATERTHAN;
	}
	public HashtagsExt setId_GREATERTHAN(Long _id)
	{
		id_GREATERTHAN=_id;
		return this;
	}

	public Long getId_GREATEROREQUALTHAN()
	{
		return id_GREATEROREQUALTHAN;
	}
	public HashtagsExt setId_GREATEROREQUALTHAN(Long _id)
	{
		id_GREATEROREQUALTHAN=_id;
		return this;
	}

	public Long getId_LESSTHAN()
	{
		return id_LESSTHAN;
	}
	public HashtagsExt setId_LESSTHAN(Long _id)
	{
		id_LESSTHAN=_id;
		return this;
	}

	public Long getId_LESSOREQUALTHAN()
	{
		return id_LESSOREQUALTHAN;
	}
	public HashtagsExt setId_LESSOREQUALTHAN(Long _id)
	{
		id_LESSOREQUALTHAN=_id;
		return this;
	}



	//hashtags
	private String hashtags;
	private Collection< String > hashtags_IN;
	private Collection< String > hashtags_NOTIN;

	public String getHashtags()
	{
		return hashtags;
	}
	public HashtagsExt setHashtags(String _hashtags)
	{
		hashtags=_hashtags;
		return this;
	}
	public Collection< String > getHashtags_IN()
	{
		return hashtags_IN;
	}
	public HashtagsExt setHashtags_IN(Collection< String > _hashtags)
	{
		hashtags_IN=_hashtags;
		return this;
	}
	public Collection< String > getHashtags_NOTIN()
	{
		return hashtags_NOTIN;
	}
	public HashtagsExt setHashtags_NOTIN(Collection< String > _hashtags)
	{
		hashtags_NOTIN=_hashtags;
		return this;
	}



	private String hashtags_LIKE;
	private String hashtags_NOTLIKE;

	public String getHashtags_LIKE()
	{
		return hashtags_LIKE;
	}
	public HashtagsExt setHashtags_LIKE(String _hashtags)
	{
		hashtags_LIKE=_hashtags;
		return this;
	}
	public String getHashtags_NOTLIKE()
	{
		return hashtags_NOTLIKE;
	}
	public HashtagsExt setHashtags_NOTLIKE(String _hashtags)
	{
		hashtags_NOTLIKE=_hashtags;
		return this;
	}





	//contador
	private Long contador;
	private Collection< Long > contador_IN;
	private Collection< Long > contador_NOTIN;

	public Long getContador()
	{
		return contador;
	}
	public HashtagsExt setContador(Long _contador)
	{
		contador=_contador;
		return this;
	}
	public Collection< Long > getContador_IN()
	{
		return contador_IN;
	}
	public HashtagsExt setContador_IN(Collection< Long > _contador)
	{
		contador_IN=_contador;
		return this;
	}
	public Collection< Long > getContador_NOTIN()
	{
		return contador_NOTIN;
	}
	public HashtagsExt setContador_NOTIN(Collection< Long > _contador)
	{
		contador_NOTIN=_contador;
		return this;
	}





	private Long contador_DISTINCT;
	private Long contador_GREATERTHAN;
	private Long contador_GREATEROREQUALTHAN;
	private Long contador_LESSTHAN;
	private Long contador_LESSOREQUALTHAN;

	public Long getContador_DISTINCT()
	{
		return contador_DISTINCT;
	}
	public HashtagsExt setContador_DISTINCT(Long _contador)
	{
		contador_DISTINCT=_contador;
		return this;
	}

	public Long getContador_GREATERTHAN()
	{
		return contador_GREATERTHAN;
	}
	public HashtagsExt setContador_GREATERTHAN(Long _contador)
	{
		contador_GREATERTHAN=_contador;
		return this;
	}

	public Long getContador_GREATEROREQUALTHAN()
	{
		return contador_GREATEROREQUALTHAN;
	}
	public HashtagsExt setContador_GREATEROREQUALTHAN(Long _contador)
	{
		contador_GREATEROREQUALTHAN=_contador;
		return this;
	}

	public Long getContador_LESSTHAN()
	{
		return contador_LESSTHAN;
	}
	public HashtagsExt setContador_LESSTHAN(Long _contador)
	{
		contador_LESSTHAN=_contador;
		return this;
	}

	public Long getContador_LESSOREQUALTHAN()
	{
		return contador_LESSOREQUALTHAN;
	}
	public HashtagsExt setContador_LESSOREQUALTHAN(Long _contador)
	{
		contador_LESSOREQUALTHAN=_contador;
		return this;
	}



	private String orderby[];

	public String [] getOrderBy()
	{
		return orderby;
	}

	public HashtagsExt setOrderBy(String[] order)
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

	public HashtagsExt setMaxElemsPerPage(Integer max)
	{
		maxElemsPerPage=max;
		return this;
	}
	public Integer  getPage()
	{
		return page;
	}

	public HashtagsExt setPage(Integer page)
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


