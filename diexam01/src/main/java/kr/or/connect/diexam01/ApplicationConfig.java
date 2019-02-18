package kr.or.connect.diexam01;

import org.springframework.context.annotation.*;

//@Configuration
public class ApplicationConfig {
	@Bean
	public Car c(Engine e) {
		Car c = new Car();
	//	c.setEngine(e);
		return c;
	}
	
	@Bean
	public Engine engine() {
		return new Engine();
	}
}
