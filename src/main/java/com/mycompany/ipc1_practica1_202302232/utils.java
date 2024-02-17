package com.mycompany.ipc1_practica1_202302232;

import java.util.Random;

/**
 *
 * @author pablo
 */
class utils {
    public static int getRandomNumber(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
