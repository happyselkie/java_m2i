package org.example.order.util;

import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestClient<T> {

    private RestTemplate restTemplate;
    private final HttpHeaders headers;
    private final String url;

    public RestClient(String url) {
        this.restTemplate = new RestTemplate();
        this.headers = new HttpHeaders();
        this.headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        this.headers.setContentType(MediaType.APPLICATION_JSON);
        this.headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        this.url = url;
    }

    public T get(Class<T> responseType) {
        try{
            HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
            ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, responseType);
            return response.hasBody() ? response.getBody() : null;
        } catch (RestClientException e){
            return null;
        }
    }



}
