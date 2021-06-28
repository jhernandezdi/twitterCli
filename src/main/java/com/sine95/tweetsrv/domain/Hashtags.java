
package com.sine95.tweetsrv.domain;

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

@Entity(name = "Hashtags")
@Table(name = "HASHTAGS")
@SuppressWarnings("unused")
public class Hashtags  implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenHashtags")
	@SequenceGenerator(name = "seqGenHashtags",sequenceName="configuration_seq", allocationSize=1)
	
	private Long id;
	@NotNull	@Size(max = 300)
	@Column(name = "HASHTAGS", length = 300, nullable = false)
	private String hashtags;
	@NotNull
	@Column(name = "CONTADOR", nullable = false)
	private Long contador;

// jhipster-needle-entity-add-field - JHipster will add fields here, do not remove

  public Hashtags setId(Long valor){
    this.id=valor;
    return this;
  }

  public Hashtags id(Long valor){
    this.id=valor;
    return this;
  }

  public Long getId(){
    return this.id;
  }

  public Hashtags setHashtags(String valor){
    this.hashtags=valor;
    return this;
  }

  public Hashtags hashtags(String valor){
    this.hashtags=valor;
    return this;
  }

  public String getHashtags(){
    return this.hashtags;
  }

  public Hashtags setContador(Long valor){
    this.contador=valor;
    return this;
  }

  public Hashtags contador(Long valor){
    this.contador=valor;
    return this;
  }

  public Long getContador(){
    return this.contador;
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
		Hashtags obj = null;
		try {
			obj = (Hashtags) o;
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
		return "Hashtags{" +
			
			"id=" + getId() +
			
			", hashtags=" + getHashtags() +
			
			", contador=" + getContador() +
			
			"}";
	}

////START_{Others}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}


