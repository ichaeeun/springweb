package springdi.a01_exp;

import org.springframework.context.support.AbstractApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z04_vo.Player;
import springdi.z04_vo.Game;
import springdi.z04_vo.Team;

public class A04_0308 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springdi/a01_exp/container2.xml");
		// Component 기본 형식으로 호출 
		Game g01 = ctx.getBean("g01",Game.class);
		System.out.println("g01: "+g01);
		Player player = ctx.getBean("player",Player.class);
		System.out.println("player: "+player);
		Team team = ctx.getBean("team",Team.class);
		System.out.println("team: "+team);
/*
 [spring]
[하] 1. 1:다의 예제로  스포츠에  팀과 선수를 설정하여 Team, ArrayList<Player> 형태로 처리하여 출력하세요
[하] 2. 여러가지 Collection 타입(list, set, properties, map)의 특징을 기술하고, 해당 예제를 di로 처리하세요.
[하] 3. z04_vo 폴드에 Team, Player, Game 클래스를 선언하고, 해당 클래스롤 객체로 로딩하는 처리를
    @Component형식, RegExp형식으로 호출하여 처리하세요
[하] 4. info2 파일에 물건명, 가격, 갯수를 key=value 형식으로 저장하고, 해당 파일로 Product 클래스롤 di로 호출한 객체에서
    할당하여, 저장된 값을 호출하세요.
 */
	}
}
