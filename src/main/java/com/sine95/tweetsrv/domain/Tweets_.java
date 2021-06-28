
package com.sine95.tweetsrv.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.math.*;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


import com.sine95.tweetsrv.enums.*;


@SuppressWarnings("unused")
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tweets.class)
public abstract class Tweets_  {

	public static volatile SingularAttribute< Tweets, Long > id;	

	public static volatile SingularAttribute< Tweets, String > usuario;	

	public static volatile SingularAttribute< Tweets, String > texto;	

	public static volatile SingularAttribute< Tweets, String > localizacion;	

	public static volatile SingularAttribute< Tweets, SiNo > validacion;	


}

