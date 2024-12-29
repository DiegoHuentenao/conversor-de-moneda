package com.conversormoneda.principal;

import com.conversormoneda.modelos.Conexion;
import com.conversormoneda.modelos.Menu;

import java.net.URI;
import java.net.http.HttpClient;


public class Principal {
    public static void main(String[] args) {
        String api_key = System.getenv("API_KEY");
        Menu menu = new Menu(api_key);
        menu.validarOpcion();

    }
}
