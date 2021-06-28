
package com.juanma.twitterCli.domain;

import java.io.Serializable;
import java.util.List;
import io.github.jhipster.service.filter.*;

////START_{Import}
////END_{Import}

@SuppressWarnings("unused")
public class ConfigurationCrit implements Serializable {
	private static final long serialVersionUID = 1L;

	private LongFilter id;

	private StringFilter keyid;

	private StringFilter value;

	private StringFilter type;

	private StringFilter description;

	public ConfigurationCrit setId(LongFilter valor)
	{
		this.id=valor;
		return this;
	}
	
	public ConfigurationCrit id(LongFilter valor)
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

	public ConfigurationCrit setKeyid(StringFilter valor)
	{
		this.keyid=valor;
		return this;
	}
	
	public ConfigurationCrit keyid(StringFilter valor)
	{
		this.keyid=valor;
		return this;
	}
	
	public StringFilter getKeyid(){
		return this.keyid;
	}
	
	public StringFilter keyid(){
		return this.keyid;
	}

	public ConfigurationCrit setValue(StringFilter valor)
	{
		this.value=valor;
		return this;
	}
	
	public ConfigurationCrit value(StringFilter valor)
	{
		this.value=valor;
		return this;
	}
	
	public StringFilter getValue(){
		return this.value;
	}
	
	public StringFilter value(){
		return this.value;
	}

	public ConfigurationCrit setType(StringFilter valor)
	{
		this.type=valor;
		return this;
	}
	
	public ConfigurationCrit type(StringFilter valor)
	{
		this.type=valor;
		return this;
	}
	
	public StringFilter getType(){
		return this.type;
	}
	
	public StringFilter type(){
		return this.type;
	}

	public ConfigurationCrit setDescription(StringFilter valor)
	{
		this.description=valor;
		return this;
	}
	
	public ConfigurationCrit description(StringFilter valor)
	{
		this.description=valor;
		return this;
	}
	
	public StringFilter getDescription(){
		return this.description;
	}
	
	public StringFilter description(){
		return this.description;
	}

    @Override
    public String toString() {
        return "Configuration{" +
        "id=" + getId() +
        ", keyid=" + getKeyid() +
        ", value=" + getValue() +
        ", type=" + getType() +
        ", description=" + getDescription() +
        
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
