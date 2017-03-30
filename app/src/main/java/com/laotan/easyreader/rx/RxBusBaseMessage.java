package com.laotan.easyreader.rx;

/**
 * Created by quantan.liu on 2017/3/10.
 */

public class RxBusBaseMessage {

    private  int code;
    private Object object;
    private RxBusBaseMessage(){}
    public RxBusBaseMessage(int code, Object object){
        this.code=code;
        this.object=object;
    }

    public int getCode() {
        return code;
    }

    public Object getObject() {
        return object;
    }
}
