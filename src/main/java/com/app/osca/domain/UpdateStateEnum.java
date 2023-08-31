package com.app.osca.domain;

public enum UpdateStateEnum {
    SUCCESS(UpdateState.SUCCESS),
    FAIL(UpdateState.FAIL);

    private final Integer updateState;

    UpdateStateEnum(Integer updateState){
        this.updateState = updateState;
    }

    public Integer getUpdateState(){
        return this.updateState;
    }

    public static class UpdateState{
        public static final Integer SUCCESS = 1;
        public static final Integer FAIL = 0;
    }
}
