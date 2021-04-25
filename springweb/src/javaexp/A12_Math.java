package javaexp;

import java.util.Random;

public class A12_Math {
/*
 # Math api 활용 
 1. Math.random()을 통해서 익숙해 있는 해당 api의 다른 기능 메서드를 확인한다. 
 2. 주요 기능 메서드 
 	.addExact() 추가 합산 처리 
 	.abs() : 절대값 처리 
 	.ceil() : 올림, floor() 내림 처리 
 	.max(데이터1,데이터2...) 최대값 리턴 
 	.sin() : 사인값 그외의 삼각함수값 지원 
 	.random() : 랜덤값 java.util.Random 클래스를 통해서도 랜덤 변수에 대한 처리를 할 수 있다. 
 	.round() : 반올림 처리 
 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Integer : int 변수의 Wrapper 클래스 
		// Integer.MAX_VALUE : 정수형의 최대치(상수)를 가져온다. 
		int intMax = Integer.MAX_VALUE;
		System.out.println("정수형의 최대값:"+intMax);
		int overMax = intMax+1;
		System.out.println("오버 flow:"+overMax);
		int intMin = Integer.MIN_VALUE;
		System.out.println("정수형의 최소값:"+intMin);
		// Math.addExact(합산1,합산2) 
		System.out.println("합산함수활용:"+Math.addExact(10, 20));
		try {
		// 예외발생처리
			// 합산 함수를 활용하면 overflow에 대한 예외 발생처리를 해주는 것을 확인할 수 있다. 
		System.out.println(""
				+ "합산함수를 활용한 overflow:"+Math.addExact(intMax, 1));
		}catch(ArithmeticException ae) {
			System.out.println("예외발생: "+ae.getMessage());
		}
		// 출력처리 (format형식) 
		// printf("%형 #형식",mapping되는 데이터1, mapping데이터2)
		// 형식: %f : 실수형, %d: 정수형, %s: 문자열 
		// Math.abs() : 음수/양수 상관없이 모두 양수로 표현 처리한다. 
		System.out.printf("절대값: %f\n",Math.abs(-10.25));
		// Math.ceil() : 올림처리..
		System.out.printf("올림처리: %f,%f\n",Math.ceil(-10.1),Math.ceil(10.1));
		System.out.printf("내림처리: %f,%f\n",Math.floor(-10.1),Math.ceil(10.1));
		// Math.max() : 최대값
		System.out.printf("최대값: %d\n",Math.max(100,200));
		System.out.printf("최소값: %d\n",Math.min(100,200));
		// Math.sin(() : 삼각함수의 사인값 
		// 90.0*Math.PI/180 1라디언으로 호의 길이, 면적 구할 때 사용 
		System.out.printf("삼각함수: %f\n",Math.sin(Math.toRadians(30)));
/*
 # Math.random() 
 1. 0.0 <= Math.random() < 1.0 사이의 임의이 데이터 
 2. (int)(Math.random()*경우의 수 + 시작수) 
 		특정한 경우에 나오는 수를 범위로 하여 처리할 때, 활용한다. 
 # java.util.Random
 1. .nextInt(경우의수)+시작수 
 2. .nextDouble()
 3. .nextBoolean()
 */
		int ran = (int)(Math.random()*6)+1;
		System.out.println("주사위던지기: "+ran);
		Random random = new Random();
		System.out.println("주사위던지기2: "+(random.nextInt(6)+1));
		// 임의의 boolean 값 
		System.out.println(random.nextBoolean());
		if(random.nextBoolean()) {
			System.out.println("합격@@");
		}else {
			System.out.println("불합격@@");
		}
		// ex) java.util.Random을 활용해서 
		// 1) 주사위 2개를 던져 합산값을 출력하세요 
		int dice1 = random.nextInt(6)+1;
		int dice2 = random.nextInt(6)+1;
		System.out.printf("주사위1: %d, 주사위2: %d, 합산:%d\n",dice1,dice2,dice1+dice2);
		// 2) Math.min(), Math.max() 를 활용하여, 주사위 중 큰 수와 작은수를 출력하세요 
		System.out.printf("큰수:%d,작은수:%d\n",Math.max(dice1, dice2),Math.min(dice1, dice2));
		// 3) 실수범위로 10.0~20.0사이에 나오게 하여 올림과 내림을 처리한 결과값을 출력하세요 
		double ranDbl = random.nextDouble()*10+10;
		System.out.println("임의의 수(10.0~20.0):"+ranDbl);
		System.out.println("올림:"+Math.ceil(ranDbl));
		System.out.println("내림:"+Math.floor(ranDbl));
	}
}
