
package com.geoffreywambugu.mpesa.dto.resp;

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
    "conversationID",
    "targetSystemID",
    "routeCode",
    "statusCode",
    "statusDescription",
    "statusMessage"
})
public class Header {

    @JsonProperty("messageID")
    private String messageID;
    @JsonProperty("conversationID")
    private String conversationID;
    @JsonProperty("targetSystemID")
    private String targetSystemID;
    @JsonProperty("routeCode")
    private String routeCode;
    @JsonProperty("statusCode")
    private String statusCode;
    @JsonProperty("statusDescription")
    private String statusDescription;
    @JsonProperty("statusMessage")
    private String statusMessage;
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

    @JsonProperty("conversationID")
    public String getConversationID() {
        return conversationID;
    }

    @JsonProperty("conversationID")
    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

    @JsonProperty("targetSystemID")
    public String getTargetSystemID() {
        return targetSystemID;
    }

    @JsonProperty("targetSystemID")
    public void setTargetSystemID(String targetSystemID) {
        this.targetSystemID = targetSystemID;
    }

    @JsonProperty("routeCode")
    public String getRouteCode() {
        return routeCode;
    }

    @JsonProperty("routeCode")
    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    @JsonProperty("statusCode")
    public String getStatusCode() {
        return statusCode;
    }

    @JsonProperty("statusCode")
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @JsonProperty("statusDescription")
    public String getStatusDescription() {
        return statusDescription;
    }

    @JsonProperty("statusDescription")
    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    @JsonProperty("statusMessage")
    public String getStatusMessage() {
        return statusMessage;
    }

    @JsonProperty("statusMessage")
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
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
