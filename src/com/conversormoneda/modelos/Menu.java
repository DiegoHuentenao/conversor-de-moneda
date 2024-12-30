package com.conversormoneda.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class Menu {
    public int alternativa;
    private String api_key;
    private Scanner teclado = new Scanner(System.in);
    public Menu(String api_key) {
        this.api_key = api_key;
    }

    public void desplegarInterfaz(){
        System.out.println(
                """
                ******************************************
                Sea bienvenido/a al Conversor de Moneda =]
                1) Dólar =>> Peso argentino
                2) Peso argentino ==> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño ==> Dólar
                5) Dólar ==> Peso colombiano
                6) Peso colombiano ==> Dólar
                7) Salir
                Elija una opción válida:
                ******************************************        
                """
        );
    }
        public void validarOpcion(){
            while(this.alternativa < 1 || this.alternativa > 7 || this.alternativa != 7) {
                desplegarInterfaz();
                this.alternativa = teclado.nextInt();
                logicaOpciones();
                if (this.alternativa < 0) {
                    System.out.println("Escriba una opción válida, no negativo");
                }else if(this.alternativa >7){
                    System.out.println("Escriba una opción válida, no más de 7");
                }
            }
        }
        public void logicaOpciones(){

                switch (this.alternativa){
                    case 1:
                        ingresarDatos("USD","ARS");
                        break;
                    case 2:
                        ingresarDatos("ARS","USD");
                        break;
                    case 3:
                        ingresarDatos("USD","BRL");
                        break;
                    case 4:
                        ingresarDatos("BRL","USD");
                        break;
                    case 5:
                        ingresarDatos("USD","COP");
                        break;
                    case 6:
                        ingresarDatos("COP","USD");
                        break;
                }

        }
        public void ingresarDatos(String currency_origen, String currency_destino){
            System.out.println("Ingrese el monto: ");
            double monto = this.teclado.nextDouble();
            Currency currency = new Currency(currency_origen, currency_destino, monto);
            currency.getValor(this.api_key);
        }
}
