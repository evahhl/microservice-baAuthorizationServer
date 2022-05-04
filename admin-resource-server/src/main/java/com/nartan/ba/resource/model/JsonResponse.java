package com.nartan.ba.resource.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nartan.ba.resource.enums.ResultCode;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class JsonResponse implements Serializable {

    private ResultCode resultCode;
    private String message;
    private String resultDesc;
    private Map<String, Object> data;

    public JsonResponse() {
        this.resultCode = ResultCode.SUCCESS;
        this.message = null;
        this.resultDesc = "";
        this.data = new TreeMap();
    }

    public JsonResponse addObject(Object value) {
        String key = "defaultKey";
        if (value != null) {
            key = StringUtils.uncapitalize(value.getClass().getSimpleName());
        }

        return this.addObject(key, value);
    }

    public JsonResponse addObject(String key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("The \"key\" provided to the UnipagosJsonResponse must be not null");
        } else {
            this.data.put(key, value);
            return this;
        }
    }

    public JsonResponse addAllInMap(Map<String, ?> map) {
        if (map != null && !map.isEmpty()) {
            Iterator var2 = map.keySet().iterator();

            while(var2.hasNext()) {
                String key = (String)var2.next();
                this.data.put(key, map.get(key));
            }
        }

        return this;
    }

    @JsonProperty("_resultType")
    public ResultCode getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    @JsonProperty("_resultCode")
    public String getResultCodeAux() {
        return this.resultCode.getCode();
    }

    @JsonProperty("_resultDesc")
    public String getResultDesc() {
        return this.resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    @JsonProperty("_message")
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonAnyGetter
    public Map<String, Object> getData() {
        return this.data;
    }

    public String toString() {
        return (new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).append("data", this.data).append("_resultType", this.getResultCode()).append("_resultCode", this.getResultCode()).append("_resultDesc", this.getResultDesc()).append("_message", this.message).toString();
    }

}
