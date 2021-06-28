

package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.*;


import java.math.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

	import com.sine95.tweetsrv.domain.SecurityGroup;
	
////START_{Import}
////END_{Import}
/**
 */
@SuppressWarnings("unused")
public class SecurityGroupPoj implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long id;

	private String allowedgroup;

	private String identifier;

	public SecurityGroupPoj()
	{
		super();
	}
	
	public SecurityGroupPoj(Long id,String allowedgroup,String identifier)
	{

		setId(id);

		setAllowedgroup(allowedgroup);

		setIdentifier(identifier);

	}

  public SecurityGroupPoj setId(Long valor){
    this.id=valor;
    return this;
  }

  public SecurityGroupPoj id(Long valor){
    this.id=valor;
    return this;
  }

  public Long getId(){
    return this.id;
  }

  public SecurityGroupPoj setAllowedgroup(String valor){
    this.allowedgroup=valor;
    return this;
  }

  public SecurityGroupPoj allowedgroup(String valor){
    this.allowedgroup=valor;
    return this;
  }

  public String getAllowedgroup(){
    return this.allowedgroup;
  }

  public SecurityGroupPoj setIdentifier(String valor){
    this.identifier=valor;
    return this;
  }

  public SecurityGroupPoj identifier(String valor){
    this.identifier=valor;
    return this;
  }

  public String getIdentifier(){
    return this.identifier;
  }

	public Long getId_()
	{
		return this.id;
	}

	public SecurityGroupPoj(SecurityGroup o)
	{
		if (o==null) return;

		this.id = o.getId();

		this.allowedgroup = o.getAllowedgroup();

		this.identifier = o.getIdentifier();

	}
	

	public static SecurityGroup getModel(SecurityGroupPoj p)
	{

		SecurityGroup o = new SecurityGroup();

		o.setId(p.getId());

		o.setAllowedgroup(p.getAllowedgroup());

		o.setIdentifier(p.getIdentifier());

		return o;
	}

	public static List< SecurityGroup > toModelList(List< SecurityGroupPoj > l)
	{
		ArrayList< SecurityGroup > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< SecurityGroupPoj > it = l.iterator();
			while(it.hasNext())
			{
				SecurityGroupPoj o = it.next();
				if (o!=null)
				{
					SecurityGroup m = getModel(o);
					res.add(m);
				}
			}
		}
		return res;
	}
	

	public static List< SecurityGroupPoj > toPOJOList(List< SecurityGroup > l)
	{
		ArrayList< SecurityGroupPoj > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< SecurityGroup > it = l.iterator();
			while(it.hasNext())
			{
				SecurityGroup o = it.next();
				if (o!=null)
				{
					SecurityGroupPoj m = new SecurityGroupPoj(o);
					res.add(m);
				}
			}
		}
		return res;
	}

	public static Page< SecurityGroupPoj > toPOJOPage(Page< SecurityGroup > p)
	{
		if (p==null) return null;
		List< SecurityGroup > l = p.getContent();
		List< SecurityGroupPoj > ll  = toPOJOList(l);
		PageImpl< SecurityGroupPoj > pageImpl = new PageImpl<>(ll,p.getPageable(),p.getTotalElements());
		
		Page< SecurityGroupPoj > res = pageImpl;

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
		SecurityGroupPoj obj = (SecurityGroupPoj) o;

		if (obj.getId() != getId()) {
			if (obj.getId() == null || getId() == null) return false;
			if (!obj.getId().equals(getId())) return false;
		}

		if (obj.getAllowedgroup() != getAllowedgroup()) {
			if (obj.getAllowedgroup() == null || getAllowedgroup() == null) return false;
			if (!obj.getAllowedgroup().equals(getAllowedgroup())) return false;
		}

		if (obj.getIdentifier() != getIdentifier()) {
			if (obj.getIdentifier() == null || getIdentifier() == null) return false;
			if (!obj.getIdentifier().equals(getIdentifier())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getId()==null?"":getId().toString())+(getAllowedgroup()==null?"":getAllowedgroup().toString())+(getIdentifier()==null?"":getIdentifier().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "SecurityGroupPoj{" +
			"id=" + getId() + ", allowedgroup=" + getAllowedgroup() + ", identifier=" + getIdentifier() + "}";
	}
	
////START_{Others}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
} // Eliminar
// HASTA AQUI SUBTPL: Java/EsqueletoPOJOS


