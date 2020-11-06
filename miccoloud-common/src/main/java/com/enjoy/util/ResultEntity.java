package com.enjoy.util;

import java.io.Serializable;

public class ResultEntity implements Serializable {
    private Integer code;
    private String message;
    private Object data;

    public ResultEntity(ResultCode resultCode, Object data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public ResultEntity() {

    }




    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setResultCode(ResultCode resultCode){
        this.code = resultCode.code();
        this.message = resultCode.message();
    }
    //返回成功
    public static ResultEntity success(){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setResultCode(ResultCode.SUCCESS);return resultEntity;
    }


    public static ResultEntity successNoData() {
        return success();
    }
    //返回成功
    public static ResultEntity success(Object data){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setResultCode(ResultCode.SUCCESS);
        resultEntity.setData(data);
        return resultEntity;
    }

    public static ResultEntity successWithData(Object data) {
        return success(data);
    }

    //返回失败
    public static ResultEntity failure(){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setResultCode(ResultCode.FAIUL);
        return resultEntity;
    }

    public static ResultEntity failed(){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setResultCode(ResultCode.FAIUL);
        return resultEntity;
    }
    //返回失败
    public static ResultEntity failed(Object data){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity. setResultCode(ResultCode.FAIUL);
        resultEntity.setData(data);
        return resultEntity;
    }

    //返回失败
    public static ResultEntity failure(Object data){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity. setResultCode(ResultCode.FAIUL);
        resultEntity.setData(data);
        return resultEntity;
    }

}
