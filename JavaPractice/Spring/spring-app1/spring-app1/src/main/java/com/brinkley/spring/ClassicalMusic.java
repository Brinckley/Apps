package com.brinkley.spring;

public class ClassicalMusic implements Music {
    private ClassicalMusic(){}

    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }

    public void doMyInit() {
        System.out.println("Doing my initialization in classical bean");
    }

    public void doMyDestroy() {
        System.out.println("Destroying classical bean :(");
    }

    @Override
    public String getSong() {
        return "Moonlight Sonata";
    }

}
