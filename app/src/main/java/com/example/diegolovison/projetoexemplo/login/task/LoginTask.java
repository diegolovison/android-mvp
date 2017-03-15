package com.example.diegolovison.projetoexemplo.login.task;

import android.os.AsyncTask;

import com.example.diegolovison.projetoexemplo.login.domain.OAuth2Response;

import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by diego.lovison on 21/12/2015.
 */
public class LoginTask extends AsyncTask<Void, Void, OAuth2Response> {

    private String username;
    private String password;

    public LoginTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    protected OAuth2Response doInBackground(Void... params) {

        HttpAuthentication authentication = new HttpBasicAuthentication("app", "secret");

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAuthorization(authentication);
        requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("username", this.username);
        request.add("password", this.password);
        request.add("grant_type", "password");
        request.add("client_id", "app");
        request.add("client_secret", "secret");
        request.add("scope", "openid");

        HttpEntity<?> requestEntity = new HttpEntity<>(request, requestHeaders);

        final String url = "http://172.16.104.103:2222/oauth/token";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        ResponseEntity<OAuth2Response> response =
                restTemplate.exchange(url, HttpMethod.POST, requestEntity, OAuth2Response.class);

        return response.getBody();
    }
}
