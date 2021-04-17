package springaop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springaop.z01_vo.Message;
import springdi.z01_vo.Person;

public class AOP_Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("/springaop/container2.xml");
		Message msg = ctx.getBean("target", Message.class);
		msg.helloApp();
		
		
		ctx.close();
	}

}
