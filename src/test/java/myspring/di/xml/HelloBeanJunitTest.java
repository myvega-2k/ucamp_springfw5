package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {
	ApplicationContext container;
	
	@BeforeEach
	void setup() {
		//1. Container Object 생성
		container = new GenericXmlApplicationContext("classpath:spring_di.xml"); 		
	}

	@Test
	void helloBean() {	
		//2. Container에게 Hello SpringBean 요청하기
		Hello hello1 = (Hello)container.getBean("hello");
		Hello hello2 = container.getBean("hello", Hello.class);
		System.out.println(hello1 == hello2);
		//SpringBean의 주소 비교 - assertSame()
		assertSame(hello1, hello2);
		//setName setter injection 체크
		assertEquals("Hello 스프링", hello1.sayHello());
		//setPrinter setter injection 체크
		hello1.print();
		
		//3. Container에게 StringPrinter SpringBean 요청하기
		Printer printer = container.getBean("strPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());
	}
}
