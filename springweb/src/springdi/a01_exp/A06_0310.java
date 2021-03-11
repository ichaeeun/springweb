package springdi.a01_exp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.a01_exp.z02_vo.Ceo;
import springdi.a01_exp.z02_vo.Company;

public class A06_0310 {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springdi/a01_exp/container4.xml");
		Company com = ctx.getBean("company",Company.class);
		com.setCeo(new Ceo("홍대표"));
		com.show();
	}
}