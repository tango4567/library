package com.sowmitras.utils;

public class CheckEmptyString {

    public CheckEmptyString() {
    }

    /**
     *
     * @param text
     *
     * */
    public Boolean check(String text) {
      return (text != null && !text.trim().isEmpty());
    }
}
