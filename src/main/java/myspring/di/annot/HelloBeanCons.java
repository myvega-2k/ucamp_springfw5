package myspring.di.annot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloBeanCons {
	
	String name;
	PrinterBean printer;
	
	List<String> names;

	@Autowired
	public HelloBeanCons(@Value("어노테이션생성자") String name, 
			             @Qualifier("consolePrinter") PrinterBean printer) {
		this.name = name;
		this.printer = printer;
	}



	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

//	public void setName(String name) {
//		System.out.println("setName 메서드 호출됨 " + name);
//		this.name = name;
//	}
//
//	public void setPrinter(PrinterBean printer) {
//		System.out.println("setPrinter 메서드 호출됨 " + printer.getClass().getName());
//		this.printer = printer;
//	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
