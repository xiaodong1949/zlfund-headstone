package com.zlfund.headstone.common.utils;

/**
 * Helper Class for hold a value.
 *
 * @author william.liangf
 */
public class Holder<T> {

    private volatile T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public static void main(String[] args) {
        Holder<String> s = new Holder<>();
        s.set("abc");
        System.out.println(s.get());
    }

}