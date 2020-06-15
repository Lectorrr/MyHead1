package com.example.myhead.one.common.entity;

public class Result {
    private Object data;
    private String errorMessage;
    private boolean hasErrors;

    public Result(){
    }

    public Result(boolean hasErrors, Object data, String errorMessage) {
        this.hasErrors = hasErrors;
        this.data = data;
        this.errorMessage = errorMessage;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.data = data;
        result.hasErrors = false;
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.hasErrors = false;
        return result;
    }

    public static Result failure(String message) {
        Result result = new Result();
        result.hasErrors = true;
        result.errorMessage = message;
        return result;
    }

    public static Result failure(String message, Object data) {
        Result result = new Result();
        result.hasErrors = true;
        result.errorMessage = message;
        result.data = data;
        return result;
    }

    public void setSuccess(boolean hasErrors) {
        this.hasErrors = false;
        this.errorMessage = this.hasErrors ? "操作失败，请检查操作是否合规！" : "操作成功！";
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }
}
