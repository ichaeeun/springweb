package springdi.a01_exp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z05_vo.Team;

public class A05_0309 {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springdi/a01_exp/container3.xml");
		Team team = ctx.getBean("team",Team.class);
		team.showTeam();
	}
/*
 *[스프링]
[하] 1. autowire란 무엇인가? 개념과 옵션을 기술하세요
	1) 컨테이너 안에 있는 객체들간에 연관관계가 설정되어 있을 때, 
		autowire 옵션에 따라서 객체들 간에 메모리가 자동 로딩 처리 되는 것을 말한다. 
		ex) 컴퓨터와 부품 객체 
	2) 옵션 <bean class="포함할 클래스" autowire="옵션"> 
		- byType : 해당 객체의 type이 setXXX property가 선언되어 있고, 
				   매개변수로 해당 type을 입력이 가능할 때, 처리된다. 
		- byName : 할당할 객체의 id/name의 속성명이 setXXX property의 이름이 같고, 
				   해당 type을 매개변수로 선언되었을 때, 처리된다. 
		- constructor : 생성자 정의가 해당 type이 생성자의 매개변수와 같을 때, 자동으로 할당된다. 
		- autodetect : 우선 생성자의 type을 확인하고 그다음 메서드의 type을 확인하여 
					   해당 객체를 자동 할당한다. 
					   

[하] 2. Team과 Player를 동일한 패키지에 선언하고, 연관관계를 설정한 후, 
    autowire의 이용하여 Player pl1, pl2, pl3이 선언되었을 때, pl2를 객체로 Team에 할당할려고 사용되는 컨테이너 코드를 기술하세요.  
    ------container------
     <bean id="pl01" class="springdi.z05_vo.Player">
      		<constructor-arg value="박건우"></constructor-arg>
      		<constructor-arg value="0.345"></constructor-arg>
      </bean>
      <bean id="pl02" class="springdi.z05_vo.Player">
      		<constructor-arg value="양의지"></constructor-arg>
      		<constructor-arg value="0.312"></constructor-arg>
      </bean>
      <bean id="pl03" class="springdi.z05_vo.Player">
      		<constructor-arg value="김재호"></constructor-arg>
      		<constructor-arg value="0.287"></constructor-arg>
      </bean>
      <bean id="team" class="springdi.z05_vo.Team" autowire="byName">
      		<constructor-arg value="두산"></constructor-arg>
      </bean>
 */
}
