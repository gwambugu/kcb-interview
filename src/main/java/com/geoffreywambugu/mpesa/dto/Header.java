
package com.geoffreywambugu.mpesa.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "messageID",
    "featureCode",
    "featureName",
    "serviceCode",
    "serviceName",
    "serviceSubCategory",
    "minorServiceVersion",
    "channelCode",
    "channelName",
    "routeCode",
    "timeStamp",
    "serviceMode",
    "subscribeEvents",
    "callBackURL"
})
public class Header {

    @JsonProperty("messageID")
    private String messageID;
    @JsonProperty("featureCode")
    private String featureCode;
    @JsonProperty("featureName")
    private String featureName;
    @JsonProperty("serviceCode")
    private String serviceCode;
    @JsonProperty("serviceName")
    private String serviceName;
    @JsonProperty("serviceSubCategory")
    private String serviceSubCategory;
    @JsonProperty("minorServiceVersion")
    private String minorServiceVersion;
    @JsonProperty("channelCode")
    private String channelCode;
    @JsonProperty("channelName")
    private String channelName;
    @JsonProperty("routeCode")
    private String routeCode;
    @JsonProperty("timeStamp")
    private String timeStamp;
    @JsonProperty("serviceMode")
    private String serviceMode;
    @JsonProperty("subscribeEvents")
    private String subscribeEvents;
    @JsonProperty("callBackURL")
    private String callBackURL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("messageID")
    public String getMessageID() {
        return messageID;
    }

    @JsonProperty("messageID")
    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    @JsonProperty("featureCode")
    public String getFeatureCode() {
        return featureCode;
    }

    @JsonProperty("featureCode")
    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    @JsonProperty("featureName")
    public String getFeatureName() {
        return featureName;
    }

    @JsonProperty("featureName")
    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    @JsonProperty("serviceCode")
    public String getServiceCode() {
        return serviceCode;
    }

    @JsonProperty("serviceCode")
    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @JsonProperty("serviceName")
    public String getServiceName() {
        return serviceName;
    }

    @JsonProperty("serviceName")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @JsonProperty("serviceSubCategory")
    public String getServiceSubCategory() {
        return serviceSubCategory;
    }

    @JsonProperty("serviceSubCategory")
    public void setServiceSubCategory(String serviceSubCategory) {
        this.serviceSubCategory = serviceSubCategory;
    }

    @JsonProperty("minorServiceVersion")
    public String getMinorServiceVersion() {
        return minorServiceVersion;
    }

    @JsonProperty("minorServiceVersion")
    public void setMinorServiceVersion(String minorServiceVersion) {
        this.minorServiceVersion = minorServiceVersion;
    }

    @JsonProperty("channelCode")
    public String getChannelCode() {
        return channelCode;
    }

    @JsonProperty("channelCode")
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    @JsonProperty("channelName")
    public String getChannelName() {
        return channelName;
    }

    @JsonProperty("channelName")
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    @JsonProperty("routeCode")
    public String getRouteCode() {
        return routeCode;
    }

    @JsonProperty("routeCode")
    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    @JsonProperty("timeStamp")
    public String getTimeStamp() {
        return timeStamp;
    }

    @JsonProperty("timeStamp")
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @JsonProperty("serviceMode")
    public String getServiceMode() {
        return serviceMode;
    }

    @JsonProperty("serviceMode")
    public void setServiceMode(String serviceMode) {
        this.serviceMode = serviceMode;
    }

    @JsonProperty("subscribeEvents")
    public String getSubscribeEvents() {
        return subscribeEvents;
    }

    @JsonProperty("subscribeEvents")
    public void setSubscribeEvents(String subscribeEvents) {
        this.subscribeEvents = subscribeEvents;
    }

    @JsonProperty("callBackURL")
    public String getCallBackURL() {
        return callBackURL;
    }

    @JsonProperty("callBackURL")
    public void setCallBackURL(String callBackURL) {
        this.callBackURL = callBackURL;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
