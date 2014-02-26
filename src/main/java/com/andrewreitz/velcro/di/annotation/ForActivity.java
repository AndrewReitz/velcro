package com.andrewreitz.velcro.di.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @author areitz
 */
@Qualifier @Retention(RetentionPolicy.RUNTIME)
public @interface ForActivity {
}
