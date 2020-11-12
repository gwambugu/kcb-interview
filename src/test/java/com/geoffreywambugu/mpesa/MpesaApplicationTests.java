package com.geoffreywambugu.mpesa;

import com.geoffreywambugu.mpesa.dto.CoreBankingReq;
import com.geoffreywambugu.mpesa.dto.RequestPayload;
import com.geoffreywambugu.mpesa.dto.resp.CoreBankingResp;
import com.geoffreywambugu.mpesa.dto.resp.Header;
import com.geoffreywambugu.mpesa.dto.resp.ResponsePayload;
import com.geoffreywambugu.mpesa.dto.resp.TransactionInfo;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MpesaApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void testObjctConverion(){
        CoreBankingReq coreBankingReq = new CoreBankingReq();
        RequestPayload requestPayload  = new RequestPayload();
        requestPayload.setTransactionInfo(new com.geoffreywambugu.mpesa.dto.TransactionInfo());
        coreBankingReq.setRequestPayload(requestPayload);
        procesResponse(coreBankingReq);
    }

    private CoreBankingResp procesResponse(Object obj) {
        if(obj instanceof JSONObject){
            JSONObject jsonObject  = (JSONObject) obj;
            CoreBankingResp coreBankingResp = new CoreBankingResp();
            coreBankingResp.setHeader(new Header());
            ResponsePayload responsePayload  = new ResponsePayload();
            TransactionInfo transactionInfo  = new TransactionInfo();
            transactionInfo.setTransactionId(jsonObject.getAsString("TransactionID"));
            transactionInfo.setFalconBalance(jsonObject.getAsString("Balance"));
            responsePayload.setTransactionInfo(transactionInfo);
            coreBankingResp.setResponsePayload(responsePayload);
            return  coreBankingResp;
        }else{
            return null ;
        }
    }

}
