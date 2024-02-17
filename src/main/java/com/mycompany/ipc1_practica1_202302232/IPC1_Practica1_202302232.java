/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ipc1_practica1_202302232;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pablo
 */

public class IPC1_Practica1_202302232 {

    public static int correlativo = 1;
    public static int conteoCasillas = 0;
    public static String[][] tabla = new String[8][8];

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;  //Llevara el numero de la cad opcion del menu

        //Desplegamos el menú para el usuario
        do {
            System.out.println("\n            *****MENÚ*****" + "\n1. Iniciar Juego" + "\n2. Retomar Juego"
                    + "\n3. Mostrar información del estudiante" + "\n4. Salir");
            System.out.print("\nIngrese una opción: ");
            opcion = entrada.nextInt(); //Guardamos la opción guardada del jugador

            //El usuario ingresara un numero y respecto a el se le llevara a la opción escogida con el switch
            switch (opcion) {
                case 1:
                    tablero();
                    break;
                case 2:
                    tablero();
                    break;
                case 3: 
                    informacion();
                    break;
                case 4:
                    break;
            }
        } while (opcion != 4);
    }
    
    //TABLERO
    public static void tablero() {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random(); 
        
        int correlativo = 1; //Para imprimir los numeros del tablero
        boolean dado = true;
        char reanudar;
        int recorrido = 0;
        
        String[][] tabla = new String[8][8];
        
        for (int i = 7; i >= 0; i--) {  //Definimos las coordenadas en donde estaran los numeros
            int numPenalizaciones = utils.getRandomNumber(2,4);
            boolean[] columnasConPenalizacion = new boolean[8];
            for (int k = 0; k < numPenalizaciones; k++) {
                int columna; 
                
                do {
                    columna = random.nextInt(8);
                } while (columnasConPenalizacion[columna]);
                
                columnasConPenalizacion[columna] = true;
                tabla[i][columna] = obtenerCasilla(correlativo, true, false);
                
            }
            
            
            if ((7 - i) % 2 == 0) { //verificamos si es par o impar para realizar el movimiento de serpiente al imprimir los numeros
                for (int j = 7; j >= 0; j--) { // si es para se ejecutara lo siguiente
                    if(tabla[i][j] == null){
                        tabla[i][j] = obtenerCasilla(correlativo++, false, true);
                    }else{
                        tabla[i][j] = obtenerCasilla(correlativo++, true, true);
                    }
                }
            } else { //si es impar se ejecutara lo que contenga en else
                for (int j = 0; j < 8; j++) {
                    if(tabla[i][j] == null){
                        tabla[i][j] = obtenerCasilla(correlativo++, false, true);
                    }else{
                        tabla[i][j] = obtenerCasilla(correlativo++, true, true);
                    }
                }
            }
        }
        //Imprimimos cada numero en la tabla
        for (int i = 0; i < 8; i++) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            for (int j = 0; j < 8; j++) {
                System.out.print(tabla[i][j] + "\t" + "|" + "\t");
            }
            System.out.println("\n"); //Dejamos un salto de linea para que salga el tablero 8x8
        }
        
        //DADO
        //System.out.println("Dado: "+numeroDado());
        do{
            System.out.print("\nPresione -d- para tirar dado ó presione -p- para retornar al menú: ");
            reanudar = entrada.next().charAt(0);
            if(reanudar == 'p' || reanudar == 'P'){
                dado = false; 
                System.out.println("Conteo de las casillas: "+conteoCasillas);
            }
            else if(reanudar == 'd' || reanudar == 'D'){
                dado = true;
                System.out.println("\nEl # del dado es: "+numeroDado());
                conteoCasillas += numeroDado();
            }
            else{
                System.out.println("\n\t¡CARACTER NO VÁLIDO!");
            }
        }while(dado);
        
    }

    //definimos si en una casilla hay una penalización, y si esta el jugador en una casilla
    public static String obtenerCasilla(int correlativo, boolean tienePenalizacion, boolean jugadorEstaEnLaCasilla) {
        String casilla = ""; 

        if (tienePenalizacion && jugadorEstaEnLaCasilla) {
            casilla += "# " + Integer.toString(correlativo) + " @";
        } else if (tienePenalizacion && !jugadorEstaEnLaCasilla) {
            casilla += "# " + Integer.toString(correlativo);
        } else if (!tienePenalizacion && jugadorEstaEnLaCasilla) {
            casilla += "  " + Integer.toString(correlativo) + " @";
        } else {
            casilla += "  " + Integer.toString(correlativo) + "  ";
        }

        return casilla;
    }
    
    //Numero aleatorio para el dado
    public static int numeroDado(){
        Random random = new Random();
        int x = 2+random.nextInt(5);
        return x;
    }
    
    //OPCIÓN 3, información del estudiante
    public static void informacion(){
        System.out.println("\n-------------------------Información del estudiante----------------------------");
        System.out.println("Facultad de Ingeniería - Ciencias y sistemas"+"\nNombre: Pablo Daniel Velásquez Hernández"+"\nCarné: 202302232"
                            +"\nCurso: Lab. Introducción a la programación 1"
                            +"\nSección: E");
    }

}
