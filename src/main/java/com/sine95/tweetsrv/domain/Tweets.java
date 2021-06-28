
package com.sine95.tweetsrv.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.*;
import java.math.*;


import com.sine95.tweetsrv.enums.*;


////START_{Import}
////END_{Import}

/**
* 
*/

@Entity(name = "Tweets")
@Table(name = "TWEETS")
@SuppressWarnings("unused")
public class Tweets  implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenTweets")
	@SequenceGenerator(name = "seqGenTweets",sequenceName="configuration_seq", allocationSize=1)
	
	private Long id;
	@NotNull	@Size(max = 300)
	@Column(name = "USUARIO", length = 300, nullable = false)
	private String usuario;
	@NotNull	@Size(max = 1000)
	@Column(name = "TEXTO", length = 1000, nullable = false)
	private String texto;
	@NotNull	@Size(max = 200)
	@Column(name = "LOCALIZACION", length = 200, nullable = false)
	private String localizacion;
	@NotNull	@Enumerated(EnumType.STRING)
	@Column(name = "validacion", nullable = false)
	private SiNo validacion;

// jhipster-needle-entity-add-field - JHipster will add fields here, do not remove

  public Tweets setId(Long valor){
    this.id=valor;
    return this;
  }

  public Tweets id(Long valor){
    this.id=valor;
    return this;
  }

  public Long getId(){
    return this.id;
  }

  public Tweets setUsuario(String valor){
    this.usuario=valor;
    return this;
  }

  public Tweets usuario(String valor){
    this.usuario=valor;
    return this;
  }

  public String getUsuario(){
    return this.usuario;
  }

  public Tweets setTexto(String valor){
    this.texto=valor;
    return this;
  }

  public Tweets texto(String valor){
    this.texto=valor;
    return this;
  }

  public String getTexto(){
    return this.texto;
  }

  public Tweets setLocalizacion(String valor){
    this.localizacion=valor;
    return this;
  }

  public Tweets localizacion(String valor){
    this.localizacion=valor;
    return this;
  }

  public String getLocalizacion(){
    return this.localizacion;
  }

  public Tweets setValidacion(SiNo valor){
    this.validacion=valor;
    return this;
  }

  public Tweets validacion(SiNo valor){
    this.validacion=valor;
    return this;
  }

  public SiNo getValidacion(){
    return this.validacion;
  }

// jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
/*  Con clases controladas por hibernate esto no funciona porque usa clases proxy (mediante herencia) y las considera distintas
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
*/
		Tweets obj = null;
		try {
			obj = (Tweets) o;
		}
		catch(ClassCastException cce)
		{
			return false;
		}
		if (obj.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), obj.getId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
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
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}


