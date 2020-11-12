package com.geoffreywambugu.mpesa.util;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.*;
import org.springframework.web.client.RestTemplate;

public class BasicAuthRestTemplate extends RestTemplate {
    public BasicAuthRestTemplate(String username, String password) {
        addAuthentication(username, password);
    }

    private void addAuthentication(String username, String password) {
        if (username == null) {
            return;
        }

        List<ClientHttpRequestInterceptor> interceptors = Collections.singletonList(new BasicAuthorizationInterceptor(username, password));

        setRequestFactory((ClientHttpRequestFactory)new InterceptingClientHttpRequestFactory(getRequestFactory(), interceptors));
    }


    private static class BasicAuthorizationInterceptor
            implements ClientHttpRequestInterceptor
    {
        private final String username;

        private final String password;

        public BasicAuthorizationInterceptor(String username, String password) {
            this.username = username;
            this.password = (password == null) ? "" : password;
        }



        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            Base64 base64 = new Base64();

            byte[] token = base64.encodeAsString((this.username + ":" + this.password).getBytes()).getBytes();
            request.getHeaders().add("Authorization", "Basic " + new String(token));
            return execution.execute(request, body);
        }
    }
}
