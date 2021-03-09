package springdi.a01_start;

import org.springframework.context.support.AbstractApplicationContext;


import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Computer;
import springdi.z01_vo.Mart;

public class A01_DI_Start11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springdi/a01_start/container11.xml");

		Mart mart = ctx.getBean("mart",Mart.class);
		mart.buy();
		
		Computer computer = ctx.getBean("computer",Computer.class);
		computer.showInfo();
		
	}
}
