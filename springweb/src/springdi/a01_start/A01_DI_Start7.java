package springdi.a01_start;

import org.springframework.context.support.AbstractApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Person;
import springdi.z01_vo.Restore;

public class A01_DI_Start7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springdi/a01_start/container7.xml");
		
		Restore rs = ctx.getBean("restore",Restore.class);
		System.out.println(rs.toString());
	}
}
