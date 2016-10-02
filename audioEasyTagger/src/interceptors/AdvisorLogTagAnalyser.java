package interceptors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//interceptor that adds traces to the class TagAnalyser
@Component
@Aspect
@Order(3)
public class AdvisorLogTagAnalyser {
	// Que se ejecute cada vez que se va a realizar
	// una transferencia y que escriba:
	// "Transfiriendo de al 1 desde el 2, 500 euros"
	@Before("execution(* main.TagAnalyser.*(..))")
	public void antes(JoinPoint llamada){
		System.out.println("--------------------------------------------------------");
		System.out.println("INFO: entering TagAnalyser "+ llamada.getClass().toString());
	}
}
