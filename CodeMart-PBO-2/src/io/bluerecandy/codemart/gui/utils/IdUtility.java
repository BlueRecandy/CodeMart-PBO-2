package io.bluerecandy.codemart.gui.utils;

import java.util.Random;

public class IdUtility {

    private static final Random RANDOM = new Random();

    public static int generateRandomId(){
        return RANDOM.nextInt(10000000);
    }

}
