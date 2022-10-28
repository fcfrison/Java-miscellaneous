package com.springexercise.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class firstSpringApp {
    public static void main(String[] args) {
        //load config file using xml file
        ClassPathXmlApplicationContext context = 
            new ClassPathXmlApplicationContext("applicationContext.xml");
        //retrieve bean
        Coach myCoach = context.getBean("mycoach",Coach.class);
        Coach mySonsCoach = context.getBean("mySonsCoach", Coach.class);
        //calls methods on the bean
        System.out.println(myCoach.getDailyWokout());
        System.out.println(mySonsCoach.getDailyWokout());

        //close context
        context.close();
        
    }
}
