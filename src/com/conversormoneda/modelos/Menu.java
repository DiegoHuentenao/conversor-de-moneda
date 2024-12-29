package com.conversormoneda.modelos;

import java.util.Scanner;

public class Menu {
    public int alternativa;
    private String api_key;

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
            Scanner teclado = new Scanner(System.in);
            while(this.alternativa < 1 || this.alternativa > 7) {
                desplegarInterfaz();
                this.alternativa = teclado.nextInt();
                if (this.alternativa < 0) {
                    System.out.println("Escriba una opción válida, no negativo");
                }else if(this.alternativa >7){
                    System.out.println("Escriba una opción válida, no positiva");
                }
            }
            logicaOpciones();
        }
        public void logicaOpciones(){
            switch (this.alternativa){
                case 1:
                    Conexion curr_api = new Conexion(this.api_key, "USD");
                    curr_api.get();
                    System.out.println(curr_api.getResponse().body());
                case 2:;
                case 3:;
                case 4:;
                case 5:;
                case 6:;
                case 7:
                    System.out.println("Hasta Luego");
                    System.exit(0);
                    break;
            }
        }
}
