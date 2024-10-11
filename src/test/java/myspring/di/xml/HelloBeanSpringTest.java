package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_di.xml")
public class HelloBeanSpringTest {
	@Autowired
	//@Qualifier("helloC")
	Hello hello;
	
	@Resource(name = "helloC")
	Hello helloCons;
	
	@Test
	void helloBean() {
		System.out.println(hello.sayHello());
		assertEquals("Hello 스프링", hello.sayHello());
		
		System.out.println(helloCons.sayHello());
		assertEquals("Hello 생성자", helloCons.sayHello());
		
		helloCons.print();
		
	}
	
	
}
