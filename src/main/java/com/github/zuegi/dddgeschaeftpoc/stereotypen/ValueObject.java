package com.github.zuegi.dddgeschaeftpoc.stereotypen;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * Represents a value object. Value objects are immutable. Equality between two value object instances is defined by
 * their type and their internal state.
 */
@Target(TYPE)
@Documented
public @interface ValueObject {

}
