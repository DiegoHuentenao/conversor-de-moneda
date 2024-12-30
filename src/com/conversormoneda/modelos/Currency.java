package com.conversormoneda.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Currency {
    private String currency_origen;
    private String currency_destino;
    private double monto;

    private Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy
                    .LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create();


    public Currency(String currency_origen, String currency_destino, double monto) {
        this.currency_origen = currency_origen;
        this.currency_destino = currency_destino;
        this.monto = monto;
    }

    public void getValor(String api_key){
        Conexion curr_api = new Conexion(api_key, this.currency_origen);
        curr_api.get();
        String json = curr_api.getResponse().body().toString();
//        System.out.println(json);
        CurrencyApi data = gson.fromJson(json, CurrencyApi.class);
        Double tc = (double) data.conversion_rates().get(this.currency_destino);
        Double monto_tc = this.monto * tc;
        System.out.println("El valor 25.0 ["+this.currency_origen+"] corresponde al valor final de =>>> "+monto_tc+"["+this.currency_destino+"]");
    }
}
