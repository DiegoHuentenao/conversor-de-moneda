package com.conversormoneda.modelos;

public class Currency {
    String currency_x;
    String currency_y;
    double tc;

    public Currency(CurrencyApi currencyApi,String currency_comparar) {
        this.currency_x = currencyApi.base_code();
        this.currency_y = currency_comparar;
        this.tc = currencyApi.conversion_rates().get(this.currency_y);
    }
}
