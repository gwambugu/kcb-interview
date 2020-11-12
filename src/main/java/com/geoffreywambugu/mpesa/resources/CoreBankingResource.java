package com.geoffreywambugu.mpesa.resources;

import com.geoffreywambugu.mpesa.dto.CoreBankingReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class CoreBankingResource {

    private final Logger log = LoggerFactory.getLogger(CoreBankingResource.class);

    @PostMapping("/mpesa")
    public ResponseEntity<CoreBankingReq> coreProcessMpesa(@RequestBody CoreBankingReq coreBankingReq) throws URISyntaxException {
        log.debug("Mpesa REST request  : {}", coreBankingReq);
        return null;
    }

}
