
package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.List;
import io.github.jhipster.service.filter.*;

import com.sine95.tweetsrv.enums.*;

////START_{Import}
////END_{Import}

@SuppressWarnings("unused")
public class TweetsCrit implements Serializable {
	private static final long serialVersionUID = 1L;

	private LongFilter id;

	private StringFilter usuario;

	private StringFilter texto;

	private StringFilter localizacion;

	public static class SiNoFilter extends Filter< SiNo > {
		private static final long serialVersionUID = 1L;
		@Override
		public List< SiNo > getIn() {
			List< SiNo > in = super.getIn();
			if(in!=null && in.isEmpty())
			{
				return null;
			}
			return in;
		}
	}

	private SiNoFilter validacion;

	public TweetsCrit setId(LongFilter valor)
	{
		this.id=valor;
		return this;
	}
	
	public TweetsCrit id(LongFilter valor)
	{
		this.id=valor;
		return this;
	}
	
	public LongFilter getId(){
		return this.id;
	}
	
	public LongFilter id(){
		return this.id;
	}

	public TweetsCrit setUsuario(StringFilter valor)
	{
		this.usuario=valor;
		return this;
	}
	
	public TweetsCrit usuario(StringFilter valor)
	{
		this.usuario=valor;
		return this;
	}
	
	public StringFilter getUsuario(){
		return this.usuario;
	}
	
	public StringFilter usuario(){
		return this.usuario;
	}

	public TweetsCrit setTexto(StringFilter valor)
	{
		this.texto=valor;
		return this;
	}
	
	public TweetsCrit texto(StringFilter valor)
	{
		this.texto=valor;
		return this;
	}
	
	public StringFilter getTexto(){
		return this.texto;
	}
	
	public StringFilter texto(){
		return this.texto;
	}

	public TweetsCrit setLocalizacion(StringFilter valor)
	{
		this.localizacion=valor;
		return this;
	}
	
	public TweetsCrit localizacion(StringFilter valor)
	{
		this.localizacion=valor;
		return this;
	}
	
	public StringFilter getLocalizacion(){
		return this.localizacion;
	}
	
	public StringFilter localizacion(){
		return this.localizacion;
	}

	public TweetsCrit setValidacion(SiNoFilter valor)
	{
		this.validacion=valor;
		return this;
	}
	
	public TweetsCrit validacion(SiNoFilter valor)
	{
		this.validacion=valor;
		return this;
	}
	
	public SiNoFilter getValidacion(){
		return this.validacion;
	}
	
	public SiNoFilter validacion(){
		return this.validacion;
	}

    @Override
    public String toString() {
        return "Tweets{" +
        "id=" + getId() +
        ", usuario=" + getUsuario() +
        ", texto=" + getTexto() +
        ", localizacion=" + getLocalizacion() +
        ", validacion=" + getValidacion() +
        
        "}";
    }
////START_{Others}
//Si hay que annadir metodos se incluyen aqui, 
//se recomienda utilizar este tipo de comentario para no interferir con el DELETE
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}
