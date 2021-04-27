package javaexp;

public class A16_StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 # StringBuffer api 
 1. String 객체의 concat 처리 시, 메모리 비효율에 대비하여 
 	하나의 메모리 안에 추가적인 문자열을 처리하는 객체를 말한다. 
 	
 	ex) String s = "사과" ; // heap 영역 메모리1 
 		s+=" 바나나"; // heap 영역 메모리2 
 		overflow의 원인이 된다. 
 2. StringBuffer를 활용하면 append() 라는 메서드를 통해서 
 	추가적인 문자열 처리를 하더라도 같은 heap 영역에서 
 	누적하여 데이터를 할당처리하여 String 보다 
 	효과적으로 메모리 관리를 할 수 있다. 
 	
 */
		StringBuffer sb = new StringBuffer("Hello");
		sb.append(" World");
		// append("추가문자열") 
		System.out.println(sb);
		// insert(인덱스위치,"문자열") : 특정 위치에 문자열 추가 
		sb.insert(5, "!!!!");
		System.out.println(sb);
		// delete(시작 index, 마지막) : 해당 위치의 문자열 삭제 처리 
		sb.delete(0, 5);
		System.out.println(sb);
		// ex1) 초기 "Good " 
		// 문자열 추가 :bye!! 
		// 특정 위치 추가 My Friend Good bye ! 
		// 삭제 후 , 추가 Welcome my friend 
		StringBuffer sb2 = new StringBuffer("Good ");
		sb2.append("Bye!!");
		System.out.println(sb2);
		sb2.insert(0, "My Friend ");
		System.out.println(sb2);
		sb2.delete(10, sb2.length());
		System.out.println(sb2);
		sb2.insert(0, "Welcome ");
		System.out.println(sb2);
		
		
	}
}
