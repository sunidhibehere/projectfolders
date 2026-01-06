package carengine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		
		Car car1 = (Car) context.getBean("carByType");
		car1.showCarDetails();
		
		Car car2 = (Car) context.getBean("carByName");
		car2.showCarDetails();
		
		Car car3 = (Car) context.getBean("carByConstructor");
		car3.showCarDetails();
	}
}
