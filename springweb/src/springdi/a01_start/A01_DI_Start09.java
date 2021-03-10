package springdi.a01_start;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// import springdi.z01_vo.Product;
// import springdi.z01_vo.Book;
// import springdi.z01_vo.Mart;
// import springdi.z01_vo.Person;
import springdi.z02_vo.Person;
import springdi.z02_vo.Product;

public class A01_DI_Start09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springdi/a01_start/container09.xml");
//		Person p01 = ctx.getBean("person",Person.class);
//		Book book = ctx.getBean("book",Book.class);
//		Mart mart = ctx.getBean("mart",Mart.class);
//		Product prod = ctx.getBean("prod",Product.class);
//		System.out.println("객체생성여부확인(person): "+p01);
//		System.out.println("객체생성여부확인(book): "+book);
//		System.out.println("객체생성여부확인(mart): "+mart);
//		System.out.println("객체생성여부확인(product): "+prod);
		
		Person p02 = ctx.getBean("p02",Person.class);
		System.out.println("객체생성(Person): "+p02);
		Product prod03 = ctx.getBean("prod03",Product.class);
		System.out.println("객체생성(Product): "+prod03);
		
		
		
	}
}
