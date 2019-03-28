package com.myMineSweeper.example;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }



    public void registerMe(){
        PersonService.registerPerson(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
