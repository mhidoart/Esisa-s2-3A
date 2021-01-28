package com.esisa.java.reflexion.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target(value=ElementType.TYPE)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Form {
	//	String title() default "" ;
	String title() default "";
	int labelWidth()default 100;
	
}
