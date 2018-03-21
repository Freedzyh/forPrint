package com.github.xuejike.springboot.jkfaststart.domain_ext;

import org.hibernate.annotations.ValueGenerationType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ValueGenerationType(generatedBy = CreationDateTimeGeneration.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface CreationDateTime {
}
