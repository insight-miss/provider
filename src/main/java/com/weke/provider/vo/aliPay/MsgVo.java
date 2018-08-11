package com.weke.provider.vo.aliPay;

import java.io.Serializable;

public class MsgVo implements Serializable {

    private String msg;

    public MsgVo() {}

    public MsgVo(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "MsgVo{" +
                "msg='" + msg + '\'' +
                '}';
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
