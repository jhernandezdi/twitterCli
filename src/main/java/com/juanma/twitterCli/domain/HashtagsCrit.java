
package com.juanma.twitterCli.domain;

import java.io.Serializable;
import java.util.List;
import io.github.jhipster.service.filter.*;

////START_{Import}
////END_{Import}

@SuppressWarnings("unused")
public class HashtagsCrit implements Serializable {
	private static final long serialVersionUID = 1L;

	private LongFilter id;

	private StringFilter hashtags;

	private LongFilter contador;

	public HashtagsCrit setId(LongFilter valor)
	{
		this.id=valor;
		return this;
	}
	
	public HashtagsCrit id(LongFilter valor)
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

	public HashtagsCrit setHashtags(StringFilter valor)
	{
		this.hashtags=valor;
		return this;
	}
	
	public HashtagsCrit hashtags(StringFilter valor)
	{
		this.hashtags=valor;
		return this;
	}
	
	public StringFilter getHashtags(){
		return this.hashtags;
	}
	
	public StringFilter hashtags(){
		return this.hashtags;
	}

	public HashtagsCrit setContador(LongFilter valor)
	{
		this.contador=valor;
		return this;
	}
	
	public HashtagsCrit contador(LongFilter valor)
	{
		this.contador=valor;
		return this;
	}
	
	public LongFilter getContador(){
		return this.contador;
	}
	
	public LongFilter contador(){
		return this.contador;
	}

    @Override
    public String toString() {
        return "Hashtags{" +
        "id=" + getId() +
        ", hashtags=" + getHashtags() +
        ", contador=" + getContador() +
        
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
