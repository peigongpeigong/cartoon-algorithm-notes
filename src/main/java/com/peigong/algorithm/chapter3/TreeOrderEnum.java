package com.peigong.algorithm.chapter3;

public enum TreeOrderEnum {

    PRE_MODE(0),
    IN_MODE(1),
    POST_MODE(2),
    PRE_STACK_MODE(3),
    IN_STACK_MODE(4),
    POST_STACK_MODE(5),
    ;


    private TreeOrderEnum(int val) {
        this.value = val;
    }

    private int value;

    public int getValue() {
        return value;
    }
}
