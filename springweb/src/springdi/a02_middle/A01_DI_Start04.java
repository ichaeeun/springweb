package springdi.a02_middle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.a02_middle.z01_vo.Bus;

public class A01_DI_Start04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springdi/a02_middle/container04.xml");
		Bus b01 = ctx.getBean("bus01", Bus.class);
		b01.showPass();
	}
}
