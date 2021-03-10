package springdi.a02_middle;

import org.springframework.context.support.AbstractApplicationContext;


import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.a02_middle.z02_vo.*;

public class A01_DI_Start03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springdi/a02_middle/container03.xml");
		Passenger p01 = ctx.getBean("passenger",Passenger.class);
		p01.setName("김길동");
		p01.setAge(26);
		Bus b01 = ctx.getBean("bus",Bus.class);
		b01.setNo(9000);
		b01.showPass();
	}
}
