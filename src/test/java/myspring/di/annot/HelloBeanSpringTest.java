package myspring.di.annot;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_di.xml")
public class HelloBeanSpringTest {
	@Autowired
	HelloBean helloBean;
	
	@Resource(name = "stringPrinter")
	PrinterBean printer;
	
	@Autowired
	HelloBeanCons helloCons;
	
	@Test
	void helloBeanCons() {
		assertEquals("Hello 어노테이션생성자", helloCons.sayHello());
		helloCons.print();
	}
	
	@Test @Disabled
	void helloBean() {
		assertEquals("Hello 어노테이션", helloBean.sayHello());
		helloBean.print();
		assertEquals("Hello 어노테이션", printer.toString());
	}
}
