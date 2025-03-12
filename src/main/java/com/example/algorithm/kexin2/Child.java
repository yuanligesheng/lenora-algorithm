package com.example.algorithm.kexin2;

public class Child extends Base {
    public int id = 101;

    @Override
    public void doSomething() {
        System.out.println("child");
    }

    public static void main(String[] args) {
        Base base = new Child();
        System.out.println(base.id);
        base.doSomething();
    }
}
