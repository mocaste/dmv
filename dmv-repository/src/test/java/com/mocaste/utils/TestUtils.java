package com.mocaste.utils;

public class TestUtils {

    public static void assertAll(Asserts... consumers) {

        for (Asserts v : consumers) {
            v.apply();
        }

    }
}
