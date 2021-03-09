package springdi.a01_start;

import org.springframework.context.support.AbstractApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Mart;
import springdi.z01_vo.Product;

public class A01_DI_Start3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springdi/a01_start/container3.xml");
		Mart m01 = ctx.getBean("m01",Mart.class);
		m01.buy();
		
		Mart m02 = ctx.getBean("m02",Mart.class);
		m02.buy();
	}
}
