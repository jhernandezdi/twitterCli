

package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.*;


import java.math.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

	import com.sine95.tweetsrv.domain.Configuration;
	
////START_{Import}
////END_{Import}
/**
 */
@SuppressWarnings("unused")
public class ConfigurationPoj implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long id;

	private String keyid;

	private String value;

	private String type;

	private String description;

	public ConfigurationPoj()
	{
		super();
	}
	
	public ConfigurationPoj(Long id,String keyid,String value,String type,String description)
	{

		setId(id);

		setKeyid(keyid);

		setValue(value);

		setType(type);

		setDescription(description);

	}

  public ConfigurationPoj setId(Long valor){
    this.id=valor;
    return this;
  }

  public ConfigurationPoj id(Long valor){
    this.id=valor;
    return this;
  }

  public Long getId(){
    return this.id;
  }

  public ConfigurationPoj setKeyid(String valor){
    this.keyid=valor;
    return this;
  }

  public ConfigurationPoj keyid(String valor){
    this.keyid=valor;
    return this;
  }

  public String getKeyid(){
    return this.keyid;
  }

  public ConfigurationPoj setValue(String valor){
    this.value=valor;
    return this;
  }

  public ConfigurationPoj value(String valor){
    this.value=valor;
    return this;
  }

  public String getValue(){
    return this.value;
  }

  public ConfigurationPoj setType(String valor){
    this.type=valor;
    return this;
  }

  public ConfigurationPoj type(String valor){
    this.type=valor;
    return this;
  }

  public String getType(){
    return this.type;
  }

  public ConfigurationPoj setDescription(String valor){
    this.description=valor;
    return this;
  }

  public ConfigurationPoj description(String valor){
    this.description=valor;
    return this;
  }

  public String getDescription(){
    return this.description;
  }

	public Long getId_()
	{
		return this.id;
	}

	public ConfigurationPoj(Configuration o)
	{
		if (o==null) return;

		this.id = o.getId();

		this.keyid = o.getKeyid();

		this.value = o.getValue();

		this.type = o.getType();

		this.description = o.getDescription();

	}
	

	public static Configuration getModel(ConfigurationPoj p)
	{

		Configuration o = new Configuration();

		o.setId(p.getId());

		o.setKeyid(p.getKeyid());

		o.setValue(p.getValue());

		o.setType(p.getType());

		o.setDescription(p.getDescription());

		return o;
	}

	public static List< Configuration > toModelList(List< ConfigurationPoj > l)
	{
		ArrayList< Configuration > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< ConfigurationPoj > it = l.iterator();
			while(it.hasNext())
			{
				ConfigurationPoj o = it.next();
				if (o!=null)
				{
					Configuration m = getModel(o);
					res.add(m);
				}
			}
		}
		return res;
	}
	

	public static List< ConfigurationPoj > toPOJOList(List< Configuration > l)
	{
		ArrayList< ConfigurationPoj > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< Configuration > it = l.iterator();
			while(it.hasNext())
			{
				Configuration o = it.next();
				if (o!=null)
				{
					ConfigurationPoj m = new ConfigurationPoj(o);
					res.add(m);
				}
			}
		}
		return res;
	}

	public static Page< ConfigurationPoj > toPOJOPage(Page< Configuration > p)
	{
		if (p==null) return null;
		List< Configuration > l = p.getContent();
		List< ConfigurationPoj > ll  = toPOJOList(l);
		PageImpl< ConfigurationPoj > pageImpl = new PageImpl<>(ll,p.getPageable(),p.getTotalElements());
		
		Page< ConfigurationPoj > res = pageImpl;

		return res;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ConfigurationPoj obj = (ConfigurationPoj) o;

		if (obj.getId() != getId()) {
			if (obj.getId() == null || getId() == null) return false;
			if (!obj.getId().equals(getId())) return false;
		}

		if (obj.getKeyid() != getKeyid()) {
			if (obj.getKeyid() == null || getKeyid() == null) return false;
			if (!obj.getKeyid().equals(getKeyid())) return false;
		}

		if (obj.getValue() != getValue()) {
			if (obj.getValue() == null || getValue() == null) return false;
			if (!obj.getValue().equals(getValue())) return false;
		}

		if (obj.getType() != getType()) {
			if (obj.getType() == null || getType() == null) return false;
			if (!obj.getType().equals(getType())) return false;
		}

		if (obj.getDescription() != getDescription()) {
			if (obj.getDescription() == null || getDescription() == null) return false;
			if (!obj.getDescription().equals(getDescription())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getId()==null?"":getId().toString())+(getKeyid()==null?"":getKeyid().toString())+(getValue()==null?"":getValue().toString())+(getType()==null?"":getType().toString())+(getDescription()==null?"":getDescription().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "ConfigurationPoj{" +
			"id=" + getId() + ", keyid=" + getKeyid() + ", value=" + getValue() + ", type=" + getType() + ", description=" + getDescription() + "}";
	}
	
////START_{Others}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
} // Eliminar
// HASTA AQUI SUBTPL: Java/EsqueletoPOJOS


