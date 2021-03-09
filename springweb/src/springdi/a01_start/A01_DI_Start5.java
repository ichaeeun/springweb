package springdi.a01_start;

import org.springframework.context.support.AbstractApplicationContext;


import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Compart;
import springdi.z01_vo.Computer;

public class A01_DI_Start5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springdi/a01_start/container5.xml");
		Computer com = ctx.getBean("com", Computer.class);
		Compart p02 = ctx.getBean("p02",Compart.class);
		Compart p03 = ctx.getBean("p03",Compart.class);
		com.setPart(p02);
		com.setPart(p03);
		
		com.showInfo();
		Computer comM = ctx.getBean("comM",Computer.class);
		comM.showInfo();
	}
}
