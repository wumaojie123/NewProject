package com.neuedu.room;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

  public class HelloWord {
	  
  public static void main(String[] args) {
  	
	  Resource resource=new ClassPathResource("applicationContext.xml");
	  BeanFactory beanFactory=new XmlBeanFactory(resource);
	  System.out.println(beanFactory);
	  Object result=beanFactory.getBean("UserDao");
	  System.out.println(result);
  } 
  }
  