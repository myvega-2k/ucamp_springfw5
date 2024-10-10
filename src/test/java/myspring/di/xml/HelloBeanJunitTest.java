package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {

	@Test
	void helloBean() {
		//1. Container Object 생성
		ApplicationContext container = 
				new GenericXmlApplicationContext("classpath:spring_di.xml"); 
		
		//2. Container에게 SpringBean 요청하기
		Hello hello1 = (Hello)container.getBean("hello");
		Hello hello2 = container.getBean("hello", Hello.class);
		System.out.println(hello1 == hello2);
		//SpringBean의 주소 비교 - assertSame()
		assertSame(hello1, hello2);
	}
}
