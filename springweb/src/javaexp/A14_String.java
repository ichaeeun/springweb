package javaexp;

public class A14_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 # String 객체가 지원하는 메서드 
 1. concat() : 문자열을 이어주는 역할 
 2. replace() : 문자열을 대체 처리 
 3. substring() : 부분 문자열 추출 
 4. toLowerCase() : 소문자 변환 
 5. toUpperCase() : 대문자 변환 
 6. endsWith() : 끝나는 문자열 비교 
 7. charAt() : 인덱스의 문자 출력 
 8. length() : 문자열 길이 
 9. indexOf() : 해당 문자열의 위치 출력 
 10. trim() : 공백제거 
 11. split() : 구분자로 문자열 분리해서 배열로 처리 
 12. valueOf() : 특정 데이터를 문자열 형식으로 변환 
 13. format() : 문자열 format 형식으로 데이터 할당 
 */
		String str1 = "abcde";
		String str2 = "		Hello	";
		String str3 = "홍길동/김길동/신길동";
		System.out.println(str1.concat("test")); // 문자열 연결
		System.out.println(str1.replace('a', 'c'));
		System.out.println(str1.substring(2,4));
		System.out.println(str1.toLowerCase());
		System.out.println(str1.toUpperCase());
		// 끝나는지 여부를 확인해서 boolean 값 리턴 처리 
		System.out.println(str1.endsWith("cde"));
		// 특정 위치에 있는 문자열 출력 
		System.out.println(str1.charAt(3));
		// ex) 주민번호를 위에 있는 기능 메서드를 활용해서 
		//  생년월일/남녀 출력 처리하세요 
		String civilNum = "921214-1835356";
		System.out.println("생년월일: "+civilNum.substring(0,2)+"년"+civilNum.substring(2,4)+"월"+civilNum.substring(4,6)+"일");
		System.out.println("성별: "+(civilNum.charAt(7)=='2'?"여자":"남자"));
		System.out.println(str1.length());// 문자열 길이 
		System.out.println(str1.indexOf("a"));// 해당 문자열의 위치 
		System.out.println(str1.indexOf("x"));// 검색되지 않으면  -1 
		System.out.println(str2.trim());// 좌우 공백 제거 
		String [] names = str3.split("/");  // 구분자로 문자열 분리 
		for(int idx=0;idx<names.length;idx++) {
			System.out.println(names[idx]);
		}
		System.out.println(String.valueOf(123));
		System.out.println(String.valueOf(3.14));
		System.out.println(String.valueOf(true));
		// %s: 문자열, %d:정수, %.2f 소숫점 이하의 자리수 지정 
		String formatStr = String.format("이름은 %s, 나이는 %d, 키는 %.2f", "홍길동",20,180.3);
		System.out.println(formatStr);
		
	}

}
