

package com.juanma.twitterCli.domain;

import java.io.Serializable;
import java.util.*;

import com.juanma.twitterCli.enums.*;

////START_{Import}
////END_{Import}
/**
 */
@SuppressWarnings("unused")
public class ResLogin implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String login;

	private String email;

	private String first_name;

	private String last_name;

	private String image_url;

	private String lang_key;

	private SiNo change_pass;

	private List<String> grupos;

	public ResLogin()
	{
		super();
	}
	
	public ResLogin(String login,String email,String first_name,String last_name,String image_url,String lang_key,SiNo change_pass,List<String> grupos)
	{

		setLogin(login);

		setEmail(email);

		setFirst_name(first_name);

		setLast_name(last_name);

		setImage_url(image_url);

		setLang_key(lang_key);

		setChange_pass(change_pass);

		setGrupos(grupos);

	}

  public ResLogin setLogin(String valor){
    this.login=valor;
    return this;
  }

  public ResLogin login(String valor){
    this.login=valor;
    return this;
  }

  public String getLogin(){
    return this.login;
  }

  public ResLogin setEmail(String valor){
    this.email=valor;
    return this;
  }

  public ResLogin email(String valor){
    this.email=valor;
    return this;
  }

  public String getEmail(){
    return this.email;
  }

  public ResLogin setFirst_name(String valor){
    this.first_name=valor;
    return this;
  }

  public ResLogin first_name(String valor){
    this.first_name=valor;
    return this;
  }

  public String getFirst_name(){
    return this.first_name;
  }

  public ResLogin setLast_name(String valor){
    this.last_name=valor;
    return this;
  }

  public ResLogin last_name(String valor){
    this.last_name=valor;
    return this;
  }

  public String getLast_name(){
    return this.last_name;
  }

  public ResLogin setImage_url(String valor){
    this.image_url=valor;
    return this;
  }

  public ResLogin image_url(String valor){
    this.image_url=valor;
    return this;
  }

  public String getImage_url(){
    return this.image_url;
  }

  public ResLogin setLang_key(String valor){
    this.lang_key=valor;
    return this;
  }

  public ResLogin lang_key(String valor){
    this.lang_key=valor;
    return this;
  }

  public String getLang_key(){
    return this.lang_key;
  }

  public ResLogin setChange_pass(SiNo valor){
    this.change_pass=valor;
    return this;
  }

  public ResLogin change_pass(SiNo valor){
    this.change_pass=valor;
    return this;
  }

  public SiNo getChange_pass(){
    return this.change_pass;
  }

  public ResLogin setGrupos(List<String> valor){
    this.grupos=valor;
    return this;
  }

  public ResLogin grupos(List<String> valor){
    this.grupos=valor;
    return this;
  }

  public List<String> getGrupos(){
    return this.grupos;
  }


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResLogin obj = (ResLogin) o;

		if (obj.getLogin() != getLogin()) {
			if (obj.getLogin() == null || getLogin() == null) return false;
			if (!obj.getLogin().equals(getLogin())) return false;
		}

		if (obj.getEmail() != getEmail()) {
			if (obj.getEmail() == null || getEmail() == null) return false;
			if (!obj.getEmail().equals(getEmail())) return false;
		}

		if (obj.getFirst_name() != getFirst_name()) {
			if (obj.getFirst_name() == null || getFirst_name() == null) return false;
			if (!obj.getFirst_name().equals(getFirst_name())) return false;
		}

		if (obj.getLast_name() != getLast_name()) {
			if (obj.getLast_name() == null || getLast_name() == null) return false;
			if (!obj.getLast_name().equals(getLast_name())) return false;
		}

		if (obj.getImage_url() != getImage_url()) {
			if (obj.getImage_url() == null || getImage_url() == null) return false;
			if (!obj.getImage_url().equals(getImage_url())) return false;
		}

		if (obj.getLang_key() != getLang_key()) {
			if (obj.getLang_key() == null || getLang_key() == null) return false;
			if (!obj.getLang_key().equals(getLang_key())) return false;
		}

		if (obj.getChange_pass() != getChange_pass()) {
			if (obj.getChange_pass() == null || getChange_pass() == null) return false;
			if (!obj.getChange_pass().equals(getChange_pass())) return false;
		}

		if (obj.getGrupos() != getGrupos()) {
			if (obj.getGrupos() == null || getGrupos() == null) return false;
			if (!obj.getGrupos().equals(getGrupos())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getLogin()==null?"":getLogin().toString())+(getEmail()==null?"":getEmail().toString())+(getFirst_name()==null?"":getFirst_name().toString())+(getLast_name()==null?"":getLast_name().toString())+(getImage_url()==null?"":getImage_url().toString())+(getLang_key()==null?"":getLang_key().toString())+(getChange_pass()==null?"":getChange_pass().toString())+(getGrupos()==null?"":getGrupos().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "ResLogin{" +
			"login=" + getLogin() + ", email=" + getEmail() + ", first_name=" + getFirst_name() + ", last_name=" + getLast_name() + ", image_url=" + getImage_url() + ", lang_key=" + getLang_key() + ", change_pass=" + getChange_pass() + ", grupos=" + getGrupos() + "}";
	}
	
////START_{Others}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
} // Eliminar
// HASTA AQUI SUBTPL: Java/EsqueletoPOJOS


