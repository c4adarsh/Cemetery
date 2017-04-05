package com.ancestry.cemetery.Dagger.Scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by adarsh on 4/4/2017.
 */



@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface MemorialActivityScope {
}

