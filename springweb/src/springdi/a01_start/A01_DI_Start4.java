package springdi.a01_start;

import org.springframework.context.support.AbstractApplicationContext;


import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Book;

public class A01_DI_Start4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springdi/a01_start/container4.xml");
		Book b01 = ctx.getBean("b01", Book.class);
		System.out.println(b01.getName());
		System.out.println(b01.getPrice());
		System.out.println(b01.getAuthor());
		
	}
}
