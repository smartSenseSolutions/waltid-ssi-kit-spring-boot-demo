package com.cofinityx.waltid.waltidssikitdemo.utils;

import java.util.Objects;

public class Validate<T> {


    private T value;
    private boolean match = false;

    private Validate() {
    }

    private Validate(T value) {
        this.value = value;
    }

    /**
     * Value validate.
     *
     * @param <V>   the type parameter
     * @param value the value
     * @return the validate
     */
    public static <V> Validate<V> value(V value) {
        return new Validate<>(value);
    }

    /**
     * Is true validate.
     *
     * @param <V>       the type parameter
     * @param condition the condition
     * @return the validate
     */
    public static <V> Validate<V> isTrue(boolean condition) {
        Validate<V> validate = new Validate<>();
        if (condition) {
            validate.match = true;
        }
        return validate;
    }

    /**
     * Throws if {@code condition} is false
     *
     * @param <V>       the type parameter
     * @param condition the condition
     * @return validate validate
     */
    public static <V> Validate<V> isFalse(boolean condition) {
        Validate<V> validate = new Validate<>();
        if (!condition) {
            validate.match = true;
        }
        return validate;
    }

    /**
     * Is null validate.
     *
     * @param <T>   the type parameter
     * @param value the value
     * @return the validate
     */
    public static <T> Validate<T> isNull(T value) {
        return new Validate<>(value).isNull();
    }

    /**
     * Is not null validate.
     *
     * @param <T>   the type parameter
     * @param value the value
     * @return the validate
     */
    public static <T> Validate<T> isNotNull(T value) {
        return new Validate<>(value).isNotNull();
    }


    /**
     * Is not empty validate.
     *
     * @return the validate
     */
    public Validate<T> isNotEmpty() {
        if (match || Objects.isNull(value) || String.valueOf(value).trim().isEmpty()) {
            match = true;
        }
        return this;
    }

    /**
     * Is null validate.
     *
     * @return the validate
     */
    public Validate<T> isNull() {
        if (match || Objects.isNull(value)) {
            match = true;
        }
        return this;
    }

    /**
     * Is not null validate.
     *
     * @return the validate
     */
    public Validate<T> isNotNull() {
        if (match || !Objects.isNull(value)) {
            match = true;
        }
        return this;
    }

    /**
     * Throw passed exception if expression is match
     *
     * @param e exception to throw
     * @return the t
     */
    public T launch(RuntimeException e) {
        if (match) {
            throw e;
        }
        return value;
    }
}