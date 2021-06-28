package com.sine95.tweetsrv.security;

/**
 * Constants for Spring Security authorities.
 * This file is generated automatically from a template
 */
@SuppressWarnings("unused")
public class AuthoritiesConstants {

 	public static final String ADMIN = "ADMIN";
 	public static final String USER = "USER";
 	public static final String MANAGER = "MANAGER";
 	public static final String SUPERVISOR = "SUPERVISOR";
 	public static final String ANONYMOUS = "ANONYMOUS";
 	public static final String PUBLIC = "PUBLIC";
 	public static final String SWAGGER = "SWAGGER";
 	public static final String REPORTS = "REPORTS";

	public enum Enum {

			ADMIN(AuthoritiesConstants.ADMIN)
			,USER(AuthoritiesConstants.USER)
			,MANAGER(AuthoritiesConstants.MANAGER)
			,SUPERVISOR(AuthoritiesConstants.SUPERVISOR)
			,ANONYMOUS(AuthoritiesConstants.ANONYMOUS)
			,PUBLIC(AuthoritiesConstants.PUBLIC)
			,SWAGGER(AuthoritiesConstants.SWAGGER)
			,REPORTS(AuthoritiesConstants.REPORTS);

		private String name;
		
		private Enum(String name)
		{
			this.name = name;
		};
		
		public String getName() {
			return name;
		}
	
		public String toString() {
			return name;
		}
	
////START_{Others}
////END_{Others}
	}
}
/*
////DELETE_START
////DELETE_END
*/
