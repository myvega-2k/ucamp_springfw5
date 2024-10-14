import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

public class LambdaTest {
	
	@Test
	void consumer() {
		List<String> asList = Arrays.asList("Java","Python","EcmaScript");
		//1. Anonymous InnerClass
		asList.forEach(new Consumer<String>() {
			@Override
			public void accept(String value) {
				// TODO Auto-generated method stub
				System.out.println(value);
			}
		});
		//2. Lambda Expression
		System.out.println("여기서 부터는 람다식");
		asList.forEach(value -> System.out.println(value));
		
		//3. Method Reference - 람다식의 아규먼트를 생략하고 Body만 구현하기
		System.out.println("여기서 부터는 Method Reference");
		asList.forEach(System.out::println);
		
		
		
		
	}
	

	@Test
	void lambda() {
		//1. Anonymous InnerClass
		Thread t1 = new Thread(new Runnable() {			
			@Override
			public void run() {
				System.out.println("익명의 Inner 클래스");				
			}
		});
		t1.start();
		//2. Lambda Expression
		Thread t2 = new Thread(() -> System.out.println("람다식"));
		t2.start();				
	}
	
	/*
	 * class MyRunnable implements Runnable {
	 *     void run(){
	 *     
	 * 	}
	 * 
	 * new Thread(new MyRunnble());
	 */
}
