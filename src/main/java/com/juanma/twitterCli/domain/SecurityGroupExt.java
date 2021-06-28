
package com.juanma.twitterCli.domain;

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
public class SecurityGroupExt  implements Serializable
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
	public SecurityGroupExt setId(Long _id)
	{
		id=_id;
		return this;
	}
	public Collection< Long > getId_IN()
	{
		return id_IN;
	}
	public SecurityGroupExt setId_IN(Collection< Long > _id)
	{
		id_IN=_id;
		return this;
	}
	public Collection< Long > getId_NOTIN()
	{
		return id_NOTIN;
	}
	public SecurityGroupExt setId_NOTIN(Collection< Long > _id)
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
	public SecurityGroupExt setId_DISTINCT(Long _id)
	{
		id_DISTINCT=_id;
		return this;
	}

	public Long getId_GREATERTHAN()
	{
		return id_GREATERTHAN;
	}
	public SecurityGroupExt setId_GREATERTHAN(Long _id)
	{
		id_GREATERTHAN=_id;
		return this;
	}

	public Long getId_GREATEROREQUALTHAN()
	{
		return id_GREATEROREQUALTHAN;
	}
	public SecurityGroupExt setId_GREATEROREQUALTHAN(Long _id)
	{
		id_GREATEROREQUALTHAN=_id;
		return this;
	}

	public Long getId_LESSTHAN()
	{
		return id_LESSTHAN;
	}
	public SecurityGroupExt setId_LESSTHAN(Long _id)
	{
		id_LESSTHAN=_id;
		return this;
	}

	public Long getId_LESSOREQUALTHAN()
	{
		return id_LESSOREQUALTHAN;
	}
	public SecurityGroupExt setId_LESSOREQUALTHAN(Long _id)
	{
		id_LESSOREQUALTHAN=_id;
		return this;
	}



	//allowedgroup
	private String allowedgroup;
	private Collection< String > allowedgroup_IN;
	private Collection< String > allowedgroup_NOTIN;

	public String getAllowedgroup()
	{
		return allowedgroup;
	}
	public SecurityGroupExt setAllowedgroup(String _allowedgroup)
	{
		allowedgroup=_allowedgroup;
		return this;
	}
	public Collection< String > getAllowedgroup_IN()
	{
		return allowedgroup_IN;
	}
	public SecurityGroupExt setAllowedgroup_IN(Collection< String > _allowedgroup)
	{
		allowedgroup_IN=_allowedgroup;
		return this;
	}
	public Collection< String > getAllowedgroup_NOTIN()
	{
		return allowedgroup_NOTIN;
	}
	public SecurityGroupExt setAllowedgroup_NOTIN(Collection< String > _allowedgroup)
	{
		allowedgroup_NOTIN=_allowedgroup;
		return this;
	}



	private String allowedgroup_LIKE;
	private String allowedgroup_NOTLIKE;

	public String getAllowedgroup_LIKE()
	{
		return allowedgroup_LIKE;
	}
	public SecurityGroupExt setAllowedgroup_LIKE(String _allowedgroup)
	{
		allowedgroup_LIKE=_allowedgroup;
		return this;
	}
	public String getAllowedgroup_NOTLIKE()
	{
		return allowedgroup_NOTLIKE;
	}
	public SecurityGroupExt setAllowedgroup_NOTLIKE(String _allowedgroup)
	{
		allowedgroup_NOTLIKE=_allowedgroup;
		return this;
	}





	//identifier
	private String identifier;
	private Collection< String > identifier_IN;
	private Collection< String > identifier_NOTIN;

	public String getIdentifier()
	{
		return identifier;
	}
	public SecurityGroupExt setIdentifier(String _identifier)
	{
		identifier=_identifier;
		return this;
	}
	public Collection< String > getIdentifier_IN()
	{
		return identifier_IN;
	}
	public SecurityGroupExt setIdentifier_IN(Collection< String > _identifier)
	{
		identifier_IN=_identifier;
		return this;
	}
	public Collection< String > getIdentifier_NOTIN()
	{
		return identifier_NOTIN;
	}
	public SecurityGroupExt setIdentifier_NOTIN(Collection< String > _identifier)
	{
		identifier_NOTIN=_identifier;
		return this;
	}



	private String identifier_LIKE;
	private String identifier_NOTLIKE;

	public String getIdentifier_LIKE()
	{
		return identifier_LIKE;
	}
	public SecurityGroupExt setIdentifier_LIKE(String _identifier)
	{
		identifier_LIKE=_identifier;
		return this;
	}
	public String getIdentifier_NOTLIKE()
	{
		return identifier_NOTLIKE;
	}
	public SecurityGroupExt setIdentifier_NOTLIKE(String _identifier)
	{
		identifier_NOTLIKE=_identifier;
		return this;
	}





	private String orderby[];

	public String [] getOrderBy()
	{
		return orderby;
	}

	public SecurityGroupExt setOrderBy(String[] order)
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

	public SecurityGroupExt setMaxElemsPerPage(Integer max)
	{
		maxElemsPerPage=max;
		return this;
	}
	public Integer  getPage()
	{
		return page;
	}

	public SecurityGroupExt setPage(Integer page)
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


