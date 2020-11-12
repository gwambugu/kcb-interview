package com.geoffreywambugu.mpesa.resources;

import com.geoffreywambugu.mpesa.dto.CoreBankingReq;
import com.geoffreywambugu.mpesa.dto.TokenResp;
import com.geoffreywambugu.mpesa.dto.resp.CoreBankingResp;
import com.geoffreywambugu.mpesa.dto.resp.Header;
import com.geoffreywambugu.mpesa.dto.resp.ResponsePayload;
import com.geoffreywambugu.mpesa.dto.resp.TransactionInfo;
import com.geoffreywambugu.mpesa.util.BasicAuthRestTemplate;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class CoreBankingResource {

    private final Logger log = LoggerFactory.getLogger(CoreBankingResource.class);

    @Autowired
    private Environment env;

    @PostMapping("/mpesa-topup")
    public @ResponseBody CoreBankingResp coreProcessMpesa(@RequestBody CoreBankingReq coreBankingReq, HttpServletRequest request) throws URISyntaxException {
        log.debug("Mpesa REST request  : {}", coreBankingReq);
        Object obj   = b2ctransaction(coreBankingReq,request);
        CoreBankingResp resp  = procesResponse(obj);
        return  resp;
    }



    private HttpEntity<Object> b2ctransaction(CoreBankingReq coreBankingReq, HttpServletRequest request) {
        log.debug("Daraja Mpesa B2C.... request {}",coreBankingReq);
        TokenResp tokenResp  = signOn(request);
        String authHeader = request.getHeader("Authorization");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
       // headers.add("Authorization", authHeader);
        headers.add("Authorization", "Bearer " + tokenResp.getAccess_token());
        headers.add("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity(coreBankingReq.toString(), (MultiValueMap) headers);
        try {
            ResponseEntity responseEntity = restTemplate.exchange(env.getProperty("mpesa.daraja.url"), HttpMethod.POST, entity, String.class, new Object[0]);
            if (responseEntity != null) {
                System.out.println(responseEntity);
                Object resp =  responseEntity.getBody();
                if (resp != null) {
                    System.out.println(resp);
                    HttpEntity<Object> stringHttpEntity = new HttpEntity<>(resp);
                    log.debug("stringHttpEntity" + stringHttpEntity.getBody().toString());
                    return stringHttpEntity;
                }
            }
        } catch (HttpStatusCodeException e) {
/*       return ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
               .body(e.getResponseBodyAsString());*/
            String errorpayload = e.getResponseBodyAsString();
            HttpEntity<Object> stringHttpEntity = new HttpEntity<>(errorpayload);
            log.debug("stringHttpEntity" + stringHttpEntity.getBody().toString());
            return stringHttpEntity;
        } catch (RestClientException e) {
            log.error("Daraja RestClientException: " + e.getMessage());
            return null;
        }
        return null;
    }

    private TokenResp signOn(HttpServletRequest request) {
        log.debug("Daraja signOn....");
        String authHeader = request.getHeader("Authorization");
        String[] up = getUserPassword(authHeader);
        log.debug("authHeader: " + authHeader);
        if (up != null) {
            System.out.println(" u: " + up[0] + " p:" + up[1]);
            BasicAuthRestTemplate restTemplate = new BasicAuthRestTemplate(up[0], up[1]);
            log.debug("Sending Request getToken: " + env.getProperty("daraja.token.url"));
            TokenResp token = null;
            try {
                token = (TokenResp) restTemplate.getForObject(env.getProperty("daraja.token.url"), TokenResp.class, new Object[0]);
                if (token != null) {
                    System.out.println("Mpesa checkout Token OK..");
                    token.setCreatedOn(new Date());
                }
            } catch (RestClientException e) {
                log.debug("daraja signOn RestClientException: " + e.getMessage());
            }
            return token;
        } else {
            return null;
        }


    }

    private String[] getUserPassword(String authorization) {
        //final String authorization = httpRequest.getHeader("Authorization");
        if (authorization != null && authorization.toLowerCase().startsWith("basic")) {
            // Authorization: Basic base64credentials
            String base64Credentials = authorization.substring("Basic".length()).trim();
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded, StandardCharsets.UTF_8);
            // credentials = username:password
            final String[] values = credentials.split(":", 2);
            return values;
        }
        return null;
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
