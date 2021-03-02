package com.example.androidakademija.examples.functions;

import java.util.Random;

public class JavaFunctionExamples {

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(100);
    }

//    public String person(String name, int age, boolean isRightHanded) {
//        return name + ", " + age + ", " + isRightHanded;
//    }
}
