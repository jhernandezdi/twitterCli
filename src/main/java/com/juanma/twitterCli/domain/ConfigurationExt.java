
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
public class ConfigurationExt  implements Serializable
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
	public ConfigurationExt setId(Long _id)
	{
		id=_id;
		return this;
	}
	public Collection< Long > getId_IN()
	{
		return id_IN;
	}
	public ConfigurationExt setId_IN(Collection< Long > _id)
	{
		id_IN=_id;
		return this;
	}
	public Collection< Long > getId_NOTIN()
	{
		return id_NOTIN;
	}
	public ConfigurationExt setId_NOTIN(Collection< Long > _id)
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
	public ConfigurationExt setId_DISTINCT(Long _id)
	{
		id_DISTINCT=_id;
		return this;
	}

	public Long getId_GREATERTHAN()
	{
		return id_GREATERTHAN;
	}
	public ConfigurationExt setId_GREATERTHAN(Long _id)
	{
		id_GREATERTHAN=_id;
		return this;
	}

	public Long getId_GREATEROREQUALTHAN()
	{
		return id_GREATEROREQUALTHAN;
	}
	public ConfigurationExt setId_GREATEROREQUALTHAN(Long _id)
	{
		id_GREATEROREQUALTHAN=_id;
		return this;
	}

	public Long getId_LESSTHAN()
	{
		return id_LESSTHAN;
	}
	public ConfigurationExt setId_LESSTHAN(Long _id)
	{
		id_LESSTHAN=_id;
		return this;
	}

	public Long getId_LESSOREQUALTHAN()
	{
		return id_LESSOREQUALTHAN;
	}
	public ConfigurationExt setId_LESSOREQUALTHAN(Long _id)
	{
		id_LESSOREQUALTHAN=_id;
		return this;
	}



	//keyid
	private String keyid;
	private Collection< String > keyid_IN;
	private Collection< String > keyid_NOTIN;

	public String getKeyid()
	{
		return keyid;
	}
	public ConfigurationExt setKeyid(String _keyid)
	{
		keyid=_keyid;
		return this;
	}
	public Collection< String > getKeyid_IN()
	{
		return keyid_IN;
	}
	public ConfigurationExt setKeyid_IN(Collection< String > _keyid)
	{
		keyid_IN=_keyid;
		return this;
	}
	public Collection< String > getKeyid_NOTIN()
	{
		return keyid_NOTIN;
	}
	public ConfigurationExt setKeyid_NOTIN(Collection< String > _keyid)
	{
		keyid_NOTIN=_keyid;
		return this;
	}



	private String keyid_LIKE;
	private String keyid_NOTLIKE;

	public String getKeyid_LIKE()
	{
		return keyid_LIKE;
	}
	public ConfigurationExt setKeyid_LIKE(String _keyid)
	{
		keyid_LIKE=_keyid;
		return this;
	}
	public String getKeyid_NOTLIKE()
	{
		return keyid_NOTLIKE;
	}
	public ConfigurationExt setKeyid_NOTLIKE(String _keyid)
	{
		keyid_NOTLIKE=_keyid;
		return this;
	}





	//value
	private String value;
	private Collection< String > value_IN;
	private Collection< String > value_NOTIN;

	public String getValue()
	{
		return value;
	}
	public ConfigurationExt setValue(String _value)
	{
		value=_value;
		return this;
	}
	public Collection< String > getValue_IN()
	{
		return value_IN;
	}
	public ConfigurationExt setValue_IN(Collection< String > _value)
	{
		value_IN=_value;
		return this;
	}
	public Collection< String > getValue_NOTIN()
	{
		return value_NOTIN;
	}
	public ConfigurationExt setValue_NOTIN(Collection< String > _value)
	{
		value_NOTIN=_value;
		return this;
	}



	private String value_LIKE;
	private String value_NOTLIKE;

	public String getValue_LIKE()
	{
		return value_LIKE;
	}
	public ConfigurationExt setValue_LIKE(String _value)
	{
		value_LIKE=_value;
		return this;
	}
	public String getValue_NOTLIKE()
	{
		return value_NOTLIKE;
	}
	public ConfigurationExt setValue_NOTLIKE(String _value)
	{
		value_NOTLIKE=_value;
		return this;
	}





	//type
	private String type;
	private Collection< String > type_IN;
	private Collection< String > type_NOTIN;

	public String getType()
	{
		return type;
	}
	public ConfigurationExt setType(String _type)
	{
		type=_type;
		return this;
	}
	public Collection< String > getType_IN()
	{
		return type_IN;
	}
	public ConfigurationExt setType_IN(Collection< String > _type)
	{
		type_IN=_type;
		return this;
	}
	public Collection< String > getType_NOTIN()
	{
		return type_NOTIN;
	}
	public ConfigurationExt setType_NOTIN(Collection< String > _type)
	{
		type_NOTIN=_type;
		return this;
	}



	private String type_LIKE;
	private String type_NOTLIKE;

	public String getType_LIKE()
	{
		return type_LIKE;
	}
	public ConfigurationExt setType_LIKE(String _type)
	{
		type_LIKE=_type;
		return this;
	}
	public String getType_NOTLIKE()
	{
		return type_NOTLIKE;
	}
	public ConfigurationExt setType_NOTLIKE(String _type)
	{
		type_NOTLIKE=_type;
		return this;
	}





	//description
	private String description;
	private Collection< String > description_IN;
	private Collection< String > description_NOTIN;

	public String getDescription()
	{
		return description;
	}
	public ConfigurationExt setDescription(String _description)
	{
		description=_description;
		return this;
	}
	public Collection< String > getDescription_IN()
	{
		return description_IN;
	}
	public ConfigurationExt setDescription_IN(Collection< String > _description)
	{
		description_IN=_description;
		return this;
	}
	public Collection< String > getDescription_NOTIN()
	{
		return description_NOTIN;
	}
	public ConfigurationExt setDescription_NOTIN(Collection< String > _description)
	{
		description_NOTIN=_description;
		return this;
	}



	private String description_LIKE;
	private String description_NOTLIKE;

	public String getDescription_LIKE()
	{
		return description_LIKE;
	}
	public ConfigurationExt setDescription_LIKE(String _description)
	{
		description_LIKE=_description;
		return this;
	}
	public String getDescription_NOTLIKE()
	{
		return description_NOTLIKE;
	}
	public ConfigurationExt setDescription_NOTLIKE(String _description)
	{
		description_NOTLIKE=_description;
		return this;
	}





	private String orderby[];

	public String [] getOrderBy()
	{
		return orderby;
	}

	public ConfigurationExt setOrderBy(String[] order)
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

	public ConfigurationExt setMaxElemsPerPage(Integer max)
	{
		maxElemsPerPage=max;
		return this;
	}
	public Integer  getPage()
	{
		return page;
	}

	public ConfigurationExt setPage(Integer page)
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


