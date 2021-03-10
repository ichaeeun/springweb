package springdi.a01_start;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Book;
import springdi.z01_vo.Mart;
import springdi.z01_vo.Person;
import springdi.z01_vo.Product;

public class A01_DI_Start08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springdi/a01_start/container08.xml");
		Person p01 = ctx.getBean("person",Person.class);
		Book book = ctx.getBean("book",Book.class);
		Mart mart = ctx.getBean("mart",Mart.class);
		Product prod = ctx.getBean("prod",Product.class);
		System.out.println("객체생성여부확인(person): "+p01);
		System.out.println("객체생성여부확인(book): "+book);
		System.out.println("객체생성여부확인(mart): "+mart);
		System.out.println("객체생성여부확인(product): "+prod);
		
		springdi.z02_vo.Person person = ctx.getBean("p02",springdi.z02_vo.Person.class);
		System.out.println("객체생성: "+person);
		
		springdi.z03_vo.Computer com = ctx.getBean("computer",springdi.z03_vo.Computer.class);
		System.out.println("객체생성: "+com);
		
		springdi.z03_vo.Sensor sen =  ctx.getBean("sensor",springdi.z03_vo.Sensor.class);
		System.out.println("객체생성: "+sen);
		
	}
}
