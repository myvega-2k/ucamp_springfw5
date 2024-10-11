package myspring.di.xml.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
@PropertySource(value = "classpath:values.properties")
public class HelloConfig {
	@Autowired
	Environment environment;
	
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
		hello.setName(environment.getProperty("mynameConfig"));
		hello.setPrinter(strPrinter());
		return hello;
	}
	
}
