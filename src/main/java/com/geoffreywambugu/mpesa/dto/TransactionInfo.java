
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
    "companyCode",
    "transactionType",
    "creditAccountNumber",
    "credintMobileNumber",
    "transactionAmount",
    "transactionReference",
    "currencyCode",
    "amountCurrency",
    "dateTime",
    "dateString"
})
public class TransactionInfo {

    @JsonProperty("companyCode")
    private String companyCode;
    @JsonProperty("transactionType")
    private String transactionType;
    @JsonProperty("creditAccountNumber")
    private String creditAccountNumber;
    @JsonProperty("credintMobileNumber")
    private String credintMobileNumber;
    @JsonProperty("transactionAmount")
    private String transactionAmount;
    @JsonProperty("transactionReference")
    private String transactionReference;
    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonProperty("amountCurrency")
    private String amountCurrency;
    @JsonProperty("dateTime")
    private String dateTime;
    @JsonProperty("dateString")
    private String dateString;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("companyCode")
    public String getCompanyCode() {
        return companyCode;
    }

    @JsonProperty("companyCode")
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @JsonProperty("transactionType")
    public String getTransactionType() {
        return transactionType;
    }

    @JsonProperty("transactionType")
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @JsonProperty("creditAccountNumber")
    public String getCreditAccountNumber() {
        return creditAccountNumber;
    }

    @JsonProperty("creditAccountNumber")
    public void setCreditAccountNumber(String creditAccountNumber) {
        this.creditAccountNumber = creditAccountNumber;
    }

    @JsonProperty("credintMobileNumber")
    public String getCredintMobileNumber() {
        return credintMobileNumber;
    }

    @JsonProperty("credintMobileNumber")
    public void setCredintMobileNumber(String credintMobileNumber) {
        this.credintMobileNumber = credintMobileNumber;
    }

    @JsonProperty("transactionAmount")
    public String getTransactionAmount() {
        return transactionAmount;
    }

    @JsonProperty("transactionAmount")
    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @JsonProperty("transactionReference")
    public String getTransactionReference() {
        return transactionReference;
    }

    @JsonProperty("transactionReference")
    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    @JsonProperty("currencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    @JsonProperty("currencyCode")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @JsonProperty("amountCurrency")
    public String getAmountCurrency() {
        return amountCurrency;
    }

    @JsonProperty("amountCurrency")
    public void setAmountCurrency(String amountCurrency) {
        this.amountCurrency = amountCurrency;
    }

    @JsonProperty("dateTime")
    public String getDateTime() {
        return dateTime;
    }

    @JsonProperty("dateTime")
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @JsonProperty("dateString")
    public String getDateString() {
        return dateString;
    }

    @JsonProperty("dateString")
    public void setDateString(String dateString) {
        this.dateString = dateString;
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
