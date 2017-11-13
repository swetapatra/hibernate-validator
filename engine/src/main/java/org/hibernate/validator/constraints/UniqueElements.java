/*
 * Hibernate Validator, declare and validate application constraints
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.validator.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hibernate.validator.internal.constraintvalidators.hv.UniqueElementsValidator;

/**
 * Validates that every object in the provided {@link Collection} is unique, i.e. that we can't find 2 equal elements in
 * the collection.
 * <p>
 * For instance, this can be useful with JAX-RS, which always deserializes collections to a list. Thus, duplicates would
 * implicitly and silently be removed when converting it to a set. This constraint allows you to check for duplicates in
 * the list and to raise an error instead.
 *
 * @author Tadhg Pearson
 * @since 6.0.5
 */
@Documented
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueElementsValidator.class)
public @interface UniqueElements {

	String message() default "{org.hibernate.validator.constraints.UniqueElements.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
