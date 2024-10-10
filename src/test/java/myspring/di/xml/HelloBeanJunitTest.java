package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {

	@Test
	void helloBean() {
		//1. Container Object 생성
		ApplicationContext container = 
				new GenericXmlApplicationContext("classpath:spring_di.xml"); 
	}
}
