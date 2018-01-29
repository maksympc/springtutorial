package com.springtutorial.idols;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws PerformanceException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-idol.xml");

        Instrumentalist eddie = (Instrumentalist) context.getBean("eddie");

        eddie.perform();
    }
}
