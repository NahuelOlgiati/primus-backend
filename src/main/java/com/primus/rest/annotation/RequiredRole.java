package com.primus.rest.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.primus.rest.app.RoleEnum;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface RequiredRole
{
	RoleEnum[] value();
}