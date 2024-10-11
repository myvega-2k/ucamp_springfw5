package myspring.di.xml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
public class HelloConfig {
	@Bean
	public Printer strPrinter() {
		return new StringPrinter();
	}
	
	@Bean
	//method name이 Bean의 id가 된다.
	public Printer conPrinter() {
		return new ConsolePrinter();
	}
	
	@Bean //alt + shift + l(엘)
	public Hello hello() {
		Hello hello = new Hello();
		hello.setName("Java컨피그");
		hello.setPrinter(strPrinter());
		return hello;
	}
	
}
