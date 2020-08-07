package com.isfinal.util;

public class ResultDto {
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    private int failCode = 1;
    private String flag;
    private String result;
    private Object data;

    public ResultDto() {
    }

    public ResultDto(String flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public ResultDto(String flag, String result) {
        this.flag = flag;
        this.result = result;
    }

    public ResultDto(String flag, String result, Object data) {
        this.flag = flag;
        this.result = result;
        this.data = data;
    }

    public ResultDto(String flag, String result, Object data, int failCode) {
        this.flag = flag;
        this.result = result;
        this.data = data;
        this.failCode = failCode;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultDto success(String result) {
        ResultDto dto = new ResultDto();
        dto.setFlag("true");
        dto.setResult(result);
        return dto;
    }

    public static ResultDto success(String result, Object data) {
        return new ResultDto("true", result, data);
    }

    public static ResultDto success(Object data) {
        return new ResultDto("true", data);
    }

    public static ResultDto fail(String result, Object data) {
        return new ResultDto("false", result, data);
    }

    public static ResultDto fail(String result) {
        ResultDto dto = new ResultDto();
        dto.setFlag("false");
        dto.setResult(result);
        dto.setFailCode(-1);
        return dto;
    }

    public static ResultDto fail(int failCode) {
        ResultDto dto = new ResultDto();
        dto.setFlag("false");
        dto.setFailCode(failCode);
        return dto;
    }

    public static ResultDto fail(int failCode, String failMsg) {
        ResultDto dto = new ResultDto();
        dto.setFlag("false");
        dto.setFailCode(failCode);
        dto.setResult(failMsg);
        return dto;
    }

    public void setFailCode(int failCode) {
        this.failCode = failCode;
    }

    public int getFailCode() {
        return this.failCode;
    }
}
