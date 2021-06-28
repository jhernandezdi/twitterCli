

package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.*;


import java.math.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

	import com.sine95.tweetsrv.domain.Tweets;
	
import com.sine95.tweetsrv.enums.*;

////START_{Import}
////END_{Import}
/**
 */
@SuppressWarnings("unused")
public class TweetsPoj implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long id;

	private String usuario;

	private String texto;

	private String localizacion;

	private SiNo validacion;

	public TweetsPoj()
	{
		super();
	}
	
	public TweetsPoj(Long id,String usuario,String texto,String localizacion,SiNo validacion)
	{

		setId(id);

		setUsuario(usuario);

		setTexto(texto);

		setLocalizacion(localizacion);

		setValidacion(validacion);

	}

  public TweetsPoj setId(Long valor){
    this.id=valor;
    return this;
  }

  public TweetsPoj id(Long valor){
    this.id=valor;
    return this;
  }

  public Long getId(){
    return this.id;
  }

  public TweetsPoj setUsuario(String valor){
    this.usuario=valor;
    return this;
  }

  public TweetsPoj usuario(String valor){
    this.usuario=valor;
    return this;
  }

  public String getUsuario(){
    return this.usuario;
  }

  public TweetsPoj setTexto(String valor){
    this.texto=valor;
    return this;
  }

  public TweetsPoj texto(String valor){
    this.texto=valor;
    return this;
  }

  public String getTexto(){
    return this.texto;
  }

  public TweetsPoj setLocalizacion(String valor){
    this.localizacion=valor;
    return this;
  }

  public TweetsPoj localizacion(String valor){
    this.localizacion=valor;
    return this;
  }

  public String getLocalizacion(){
    return this.localizacion;
  }

  public TweetsPoj setValidacion(SiNo valor){
    this.validacion=valor;
    return this;
  }

  public TweetsPoj validacion(SiNo valor){
    this.validacion=valor;
    return this;
  }

  public SiNo getValidacion(){
    return this.validacion;
  }

	public Long getId_()
	{
		return this.id;
	}

	public TweetsPoj(Tweets o)
	{
		if (o==null) return;

		this.id = o.getId();

		this.usuario = o.getUsuario();

		this.texto = o.getTexto();

		this.localizacion = o.getLocalizacion();

		this.validacion = o.getValidacion();

	}
	

	public static Tweets getModel(TweetsPoj p)
	{

		Tweets o = new Tweets();

		o.setId(p.getId());

		o.setUsuario(p.getUsuario());

		o.setTexto(p.getTexto());

		o.setLocalizacion(p.getLocalizacion());

		o.setValidacion(p.getValidacion());

		return o;
	}

	public static List< Tweets > toModelList(List< TweetsPoj > l)
	{
		ArrayList< Tweets > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< TweetsPoj > it = l.iterator();
			while(it.hasNext())
			{
				TweetsPoj o = it.next();
				if (o!=null)
				{
					Tweets m = getModel(o);
					res.add(m);
				}
			}
		}
		return res;
	}
	

	public static List< TweetsPoj > toPOJOList(List< Tweets > l)
	{
		ArrayList< TweetsPoj > res = new ArrayList<>();
		if (l!=null)
		{
			Iterator< Tweets > it = l.iterator();
			while(it.hasNext())
			{
				Tweets o = it.next();
				if (o!=null)
				{
					TweetsPoj m = new TweetsPoj(o);
					res.add(m);
				}
			}
		}
		return res;
	}

	public static Page< TweetsPoj > toPOJOPage(Page< Tweets > p)
	{
		if (p==null) return null;
		List< Tweets > l = p.getContent();
		List< TweetsPoj > ll  = toPOJOList(l);
		PageImpl< TweetsPoj > pageImpl = new PageImpl<>(ll,p.getPageable(),p.getTotalElements());
		
		Page< TweetsPoj > res = pageImpl;

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
		TweetsPoj obj = (TweetsPoj) o;

		if (obj.getId() != getId()) {
			if (obj.getId() == null || getId() == null) return false;
			if (!obj.getId().equals(getId())) return false;
		}

		if (obj.getUsuario() != getUsuario()) {
			if (obj.getUsuario() == null || getUsuario() == null) return false;
			if (!obj.getUsuario().equals(getUsuario())) return false;
		}

		if (obj.getTexto() != getTexto()) {
			if (obj.getTexto() == null || getTexto() == null) return false;
			if (!obj.getTexto().equals(getTexto())) return false;
		}

		if (obj.getLocalizacion() != getLocalizacion()) {
			if (obj.getLocalizacion() == null || getLocalizacion() == null) return false;
			if (!obj.getLocalizacion().equals(getLocalizacion())) return false;
		}

		if (obj.getValidacion() != getValidacion()) {
			if (obj.getValidacion() == null || getValidacion() == null) return false;
			if (!obj.getValidacion().equals(getValidacion())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getId()==null?"":getId().toString())+(getUsuario()==null?"":getUsuario().toString())+(getTexto()==null?"":getTexto().toString())+(getLocalizacion()==null?"":getLocalizacion().toString())+(getValidacion()==null?"":getValidacion().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "TweetsPoj{" +
			"id=" + getId() + ", usuario=" + getUsuario() + ", texto=" + getTexto() + ", localizacion=" + getLocalizacion() + ", validacion=" + getValidacion() + "}";
	}
	
////START_{Others}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
} // Eliminar
// HASTA AQUI SUBTPL: Java/EsqueletoPOJOS


