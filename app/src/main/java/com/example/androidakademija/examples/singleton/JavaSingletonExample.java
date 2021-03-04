package com.example.androidakademija.examples.singleton;

public class JavaSingletonExample {

    private static JavaSingletonExample instance = null;

    public int counter = 0;

    protected JavaSingletonExample() {}

    public static JavaSingletonExample getInstance() {
        if (instance == null) {
            instance = new JavaSingletonExample();
        }
        return instance;
    }

    public void increment() {
        this.counter++;
    }

    public static void main(String[] args) {
        JavaSingletonExample singleton = JavaSingletonExample.getInstance();
        System.out.println(singleton.counter);
        singleton.increment();
        singleton.increment();
        singleton.increment();
        System.out.println(singleton.counter);
    }
}
