package com.conversormoneda.modelos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexion {
    HttpClient client;
    HttpRequest request;
    HttpResponse response;

    public Conexion(String api_key, String currency) {
        this.client = HttpClient.newHttpClient();;
        this.request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/" + api_key + "/latest/"+currency+"/")).build();


    }
    public void get(){
        try {
            this.response = this.client.send(this.request, HttpResponse.BodyHandlers.ofString());
        }catch(Exception e){
            System.out.println("Ha ocurrido un problema al recopilar los datos");
        }
    }

    public HttpResponse getResponse() {
        return response;
    }

    public HttpRequest getRequest() {
        return request;
    }
}
