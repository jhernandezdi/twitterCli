

package com.juanma.twitterCli.domain;

import java.io.Serializable;
import java.util.*;


import java.math.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.juanma.twitterCli.domain.Hashtags;
	
////START_{Import}
////END_{Import}
/**
 */
@SuppressWarnings("unused")
public class HashtagsPoj implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long id;

	private String hashtags;

	private Long contador;

	public HashtagsPoj()
	{
		super();
	}
	
	public HashtagsPoj(Long id,String hashtags,Long contador)
	{

		setId(id);

		setHashtags(hashtags);

		setContador(contador);

	}

  public HashtagsPoj setId(Long valor){
    this.id=valor;
    return this;
  }

  public HashtagsPoj id(Long valor){
    this.id=valor;
    return this;
  }

  public Long getId(){
    return this.id;
  }

  public HashtagsPoj setHashtags(String valor){
    this.hashtags=valor;
    return this;
  }

  public HashtagsPoj hashtags(String valor){
    this.hashtags=valor;
    return this;
  }

  public String getHashtags(){
    return this.hashtags;
  }

  public HashtagsPoj setContador(Long valor){
    this.contador=valor;
    return this;
  }

  public HashtagsPoj contador(Long valor){
    this.contador=valor;
    return this;
  }

  public Long getContador(){
    return this.contador;
  }

	public Long getId_()
	{
		return this.id;
	}

	public HashtagsPoj(Hashtags o)
	{
		if (o==null) return;

		this.id = o.getId();

		this.hashtags = o.getHashtags();

		this.contador = o.getContador();

	}
	

	public static Hashtags getModel(HashtagsPoj p)
	{

		Hashtags o = new Hashtags();

		o.setId(p.getId());

		o.setHashtags(p.getHashtags());

		o.setContador(p.getContador());

		return o;
	}

	public static List< Hashtags > toModelList(List< HashtagsPoj > l)
	{
		ArrayList< Hashtags > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< HashtagsPoj > it = l.iterator();
			while(it.hasNext())
			{
				HashtagsPoj o = it.next();
				if (o!=null)
				{
					Hashtags m = getModel(o);
					res.add(m);
				}
			}
		}
		return res;
	}
	

	public static List< HashtagsPoj > toPOJOList(List< Hashtags > l)
	{
		ArrayList< HashtagsPoj > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< Hashtags > it = l.iterator();
			while(it.hasNext())
			{
				Hashtags o = it.next();
				if (o!=null)
				{
					HashtagsPoj m = new HashtagsPoj(o);
					res.add(m);
				}
			}
		}
		return res;
	}

	public static Page< HashtagsPoj > toPOJOPage(Page< Hashtags > p)
	{
		if (p==null) return null;
		List< Hashtags > l = p.getContent();
		List< HashtagsPoj > ll  = toPOJOList(l);
		PageImpl< HashtagsPoj > pageImpl = new PageImpl<>(ll,p.getPageable(),p.getTotalElements());
		
		Page< HashtagsPoj > res = pageImpl;

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
		HashtagsPoj obj = (HashtagsPoj) o;

		if (obj.getId() != getId()) {
			if (obj.getId() == null || getId() == null) return false;
			if (!obj.getId().equals(getId())) return false;
		}

		if (obj.getHashtags() != getHashtags()) {
			if (obj.getHashtags() == null || getHashtags() == null) return false;
			if (!obj.getHashtags().equals(getHashtags())) return false;
		}

		if (obj.getContador() != getContador()) {
			if (obj.getContador() == null || getContador() == null) return false;
			if (!obj.getContador().equals(getContador())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getId()==null?"":getId().toString())+(getHashtags()==null?"":getHashtags().toString())+(getContador()==null?"":getContador().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "HashtagsPoj{" +
			"id=" + getId() + ", hashtags=" + getHashtags() + ", contador=" + getContador() + "}";
	}
	
////START_{Others}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
} // Eliminar
// HASTA AQUI SUBTPL: Java/EsqueletoPOJOS


