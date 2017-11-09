package com.hongfeng.common.result;

import java.util.Map;

/**
 * Created by Jiazefeng on 2017/10/12.
 */
public class SuccessApiResult extends ApiResult {

    public SuccessApiResult() {
        this.init();
        this.addAttribute("data", "");
    }

    public SuccessApiResult(Object data) {
        this.init();
        this.addAttribute("data", data);
    }

    public SuccessApiResult(Map<Integer, String> codemap, Object data) {
        java.util.Iterator it = codemap.entrySet().iterator();
        Map.Entry entry = (Map.Entry) it.next();
        this.addAttribute("code", entry.getKey());
        this.addAttribute("msg", entry.getValue());
        this.addAttribute("data", data);
    }


    private void init() {
        this.addAttribute("code", 0);
        this.addAttribute("msg", "OK");
    }

    public Object getData() {
        return this.getOrDefault("data", "");
    }
}
