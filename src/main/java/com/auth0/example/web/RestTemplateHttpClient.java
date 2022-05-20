package com.auth0.example.web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Objects;
import java.util.function.Supplier;




public class RestTemplateHttpClient {
    private static final HttpEntity<?> EMPTY_BODY = null;

    private final RestTemplate restTemplate;

    public RestTemplateHttpClient() {
        this(new RestTemplate());
    }

    public RestTemplateHttpClient(RestTemplate restTemplate) {
        this.restTemplate = Objects.requireNonNull(restTemplate);
    }

    public <T> T postForObject(String url, Object body, Class<T> responseType, String... params) {
        return execute(() -> restTemplate.postForObject(url, body, responseType, (Object[]) params));
    }


    public URI postForLocation(String url, Object body, String... params) {
        return execute(() -> restTemplate.postForLocation(url, body, (Object[]) params));
    }


    public <T> T get(String url, Class<T> responseType, String... params) {
        return execute(() -> restTemplate.getForObject(url, responseType, (Object[]) params));
    }


    public <T> T putForObject(String url, Object body, Class<T> objectClass, String... params) {
        return execute(() -> restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(body), objectClass, (Object[]) params)
                .getBody());
    }


    public <T> T delete(String url, Class<T> responseType, String... params) {
        return execute(() -> restTemplate.exchange(url, HttpMethod.DELETE, EMPTY_BODY, responseType, (Object[]) params)
                .getBody());
    }


    public <T> T postFileForObject(String url, File file, Class<T> responseType, String... params) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>(1);
        body.add("file", file);

        return execute(() -> restTemplate.postForObject(url, new HttpEntity<>(body, headers), responseType, (Object[]) params));
    }

    private <T> T execute(Supplier<T> httpResult) {
        try {
            return httpResult.get();
        } catch (HttpStatusCodeException e) {
            throw e;
        }
    }

}

