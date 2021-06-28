
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

@Entity(name = "SecurityGroup")
@Table(name = "SECURITYGROUP")
@SuppressWarnings("unused")
public class SecurityGroup  implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenSecurityGroup")
	@SequenceGenerator(name = "seqGenSecurityGroup",sequenceName="securitygroup_seq", allocationSize=1)

	
	private Long id;
	@NotNull	@Size(max = 150)
	@Column(name = "ALLOWEDGROUP", length = 150, nullable = false)
	private String allowedgroup;
	@NotNull	@Size(max = 300)
	@Column(name = "IDENTIFIER", length = 300, nullable = false)
	private String identifier;

// jhipster-needle-entity-add-field - JHipster will add fields here, do not remove

  public SecurityGroup setId(Long valor){
    this.id=valor;
    return this;
  }

  public SecurityGroup id(Long valor){
    this.id=valor;
    return this;
  }

  public Long getId(){
    return this.id;
  }

  public SecurityGroup setAllowedgroup(String valor){
    this.allowedgroup=valor;
    return this;
  }

  public SecurityGroup allowedgroup(String valor){
    this.allowedgroup=valor;
    return this;
  }

  public String getAllowedgroup(){
    return this.allowedgroup;
  }

  public SecurityGroup setIdentifier(String valor){
    this.identifier=valor;
    return this;
  }

  public SecurityGroup identifier(String valor){
    this.identifier=valor;
    return this;
  }

  public String getIdentifier(){
    return this.identifier;
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
		SecurityGroup obj = null;
		try {
			obj = (SecurityGroup) o;
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
		return "SecurityGroup{" +
			
			"id=" + getId() +
			
			", allowedgroup=" + getAllowedgroup() +
			
			", identifier=" + getIdentifier() +
			
			"}";
	}

////START_{Others}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}


