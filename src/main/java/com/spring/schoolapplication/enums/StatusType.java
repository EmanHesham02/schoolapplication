package com.spring.schoolapplication.enums;

public enum StatusType {
    PASSED(new Integer(1)),
    FAILD(new Integer(0));

    private final Integer value;

    StatusType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
