package com.unt.SpringDemo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	
    	//deprecated
    /*	BeanFactory bf= new XmlBeanFactory(new FileSystemResource("spring.xml")); 
    	Alien a= (Alien)bf.getBean("alien"); //spring framework creates object and give
    	//we should configure alien in spring.xml file as id for Alien class
    	obj.code(); */
    	
    	
    	//ApplicationContext creates spring container
    	//all processing in java happens in jvm
    	//inside jvm we have spring container that has spring beans
    	//Bean is a simple class with variables and getters n setters
    	//spring container check this spring.xml file and create objects for bean id
    	//creates object in spring container even if u don't use but configured in xml file
    	ApplicationContext ctx= new ClassPathXmlApplicationContext("spring.xml");
    	
    	//spring container gives the object whose id is alien
    	Alien a1= (Alien) ctx.getBean("alien"); 
    	a1.code();
    	a1.age=18;
    	System.out.println(a1.age);//18
    	
    	Alien a2=(Alien) ctx.getBean("alien");
    	a2.code();
    	System.out.println(a2.age);//18, both a1,a2 references points to same object
    	//all spring beans are singleton beans because the object is created only once
   //by default spring follows singleton design pattern, spring container gives only one object
   // so that's why we have attribute "scope" in xml file scope=singleton(default)
    	// to get different objects set scope="prototype"
    //if scope="prototype" spring container creates object only when you ask for the object
   // when scope="singleton" container creates object even if u don't ask for it
    	//check by using constructor and commenting the code(28-35)
    }
}
