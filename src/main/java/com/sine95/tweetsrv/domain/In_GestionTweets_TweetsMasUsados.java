

package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.*;


import com.sine95.tweetsrv.enums.*;

////START_{Import}
////END_{Import}
/**
 */
@SuppressWarnings("unused")
public class In_GestionTweets_TweetsMasUsados implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Integer maxHashtags;

	public In_GestionTweets_TweetsMasUsados()
	{
		super();
	}
	
	public In_GestionTweets_TweetsMasUsados(Integer maxHashtags)
	{

		setMaxHashtags(maxHashtags);

	}

  public In_GestionTweets_TweetsMasUsados setMaxHashtags(Integer valor){
    this.maxHashtags=valor;
    return this;
  }

  public In_GestionTweets_TweetsMasUsados maxHashtags(Integer valor){
    this.maxHashtags=valor;
    return this;
  }

  public Integer getMaxHashtags(){
    return this.maxHashtags;
  }


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		In_GestionTweets_TweetsMasUsados obj = (In_GestionTweets_TweetsMasUsados) o;

		if (obj.getMaxHashtags() != getMaxHashtags()) {
			if (obj.getMaxHashtags() == null || getMaxHashtags() == null) return false;
			if (!obj.getMaxHashtags().equals(getMaxHashtags())) return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		String code =
(getMaxHashtags()==null?"":getMaxHashtags().toString());
		return Objects.hashCode(code);
	}
	
	@Override
	public String toString() {
		return "In_GestionTweets_TweetsMasUsados{" +
			"maxHashtags=" + getMaxHashtags() + "}";
	}
	
////START_{Others}
////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
} // Eliminar
// HASTA AQUI SUBTPL: Java/EsqueletoPOJOS


