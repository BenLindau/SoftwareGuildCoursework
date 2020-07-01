/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.person;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

/**
 *
 * @author benli
 */
public class Person {
    
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
    public boolean test(Person person) {
        return person.getAge() >= 18;
    }
    
    Predicate<Person> oldEnoughToVote = (Person p) -> {
        return p.getAge() >= 18;
    };
    
    Predicate<Person> oldEnoughToVote2 = p -> p.getAge() >= 18;
    
    public void accept(Person person) {
        System.out.println(person.getName() + " is " + person.getAge() + " years old.");
     
    }
    
    Consumer<Person> howOld = (Person p) -> {
        System.out.println(p.getName() + " is " + p.getAge() + " years old.");
    };
    Consumer<Person> howOld2 = p -> System.out.println(p.getName() + " is " + p.getAge() + " years old.");
    
    public int applyAsInt(Person p) {
        return p.getAge();
    }
    ToIntFunction<Person> toAge = (Person p) -> {
        return p.getAge();
    };

}

