package com.springtutorial.knights;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("knights.xml");

        Knight knight = (Knight) context.getBean("knight");
        knight.embarkOnQuest();
    }
}
