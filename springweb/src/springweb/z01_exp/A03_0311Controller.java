package springweb.z01_exp;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.z02_vo.Product;



@Controller 
public class A03_0311Controller {
	/*
[스프링]
[하] 1. controller와 view를 만들고, controller에 공통 model데이터 ArrayList형태로
        사과 2000
        바나나 3000
        딸기  12000 으로 설정한 뒷, 화면에 select로 출력하게 하세요.
[하] 2. 스프링 데이터베이스 연결을 위한 환경 설정 작업을 컨테이너 기술하세요.
[하] 3. dao인터페이스와 XXXmapper.xml과 구성요소가 연동관계에 대하여 기술하세요
[하] 4. 오늘 마지막 모델 데이터 emplist 화면 출력.
[중] 5. springweb2 프로젝트에 mybatis가 설정되어 emp list를 출력하게 하세요.(캡쳐)
	 */
	@ModelAttribute("fruits")
	public ArrayList<Product> flist(){
		ArrayList<Product> plist = new ArrayList<Product>();
		plist.add(new Product("사과",2000,0));
		plist.add(new Product("바나나",3000,0));
		plist.add(new Product("딸기",12000,0));
		return plist;
	}
	
	@RequestMapping("fruits.do")
	public String empList() {
		// 객체생성 없이 호출 처리됨 
		// DAO 객체 생성 부분 삭제 
	//	A01_Dao dao = new A01_Dao();
		
		return "WEB-INF/views/a01_start/a12_0311Exp.jsp";
		
	}
	
}

