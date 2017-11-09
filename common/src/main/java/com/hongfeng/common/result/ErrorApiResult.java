package com.hongfeng.common.result;

/**
 * Created by Jiazefeng on 2017/10/12.
 */
public class ErrorApiResult extends ApiResult {
    public ErrorApiResult(String errorCode) {
        this(errorCode, (String) CustomizedPropertyPlaceholderConfigurer.getContextProperty(errorCode), null);
    }

    public ErrorApiResult(String errorCode, Exception exception) {
        this.addAttribute("code", errorCode);
        this.addAttribute("msg", CustomizedPropertyPlaceholderConfigurer.getContextProperty(errorCode));
        this.addAttribute("data", "");
        if (exception != null) {
            this.addAttribute("innerExceptionMessage", exception.getMessage());
            this.addAttribute("innerExceptionStackTrace", exception.getStackTrace());
        }
    }

    public ErrorApiResult(String errorCode, String errorMessage, Exception exception) {
        this.addAttribute("code", errorCode);
        this.addAttribute("msg", errorMessage);
        this.addAttribute("data", "");
        if (exception != null) {
            this.addAttribute("innerExceptionMessage", exception.getMessage());
            this.addAttribute("innerExceptionStackTrace", exception.getStackTrace());
        }
    }
    public ErrorApiResult(String errorCode,String errorMessage){
        this.addAttribute("code",errorCode);
        this.addAttribute("msg",errorMessage);
    }
}
