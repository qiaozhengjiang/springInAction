package com.prac.springInAction.chapter01.main;

import com.prac.springInAction.chapter01.config.KnightConfig;
import com.prac.springInAction.chapter01.inter.Knight;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class KnightMain {
	public static void main(String[] args) {
		//ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("com/prac/springInAction/chapter01/config/knights.xml");
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(KnightConfig.class);
		Knight knight=(Knight) context.getBean("knight");
		knight.embarkOnQuest();
		context.close();
	}
}
