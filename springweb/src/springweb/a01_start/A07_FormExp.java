package springweb.a01_start;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springweb.z03_vo.Purchase;

@Controller 
@RequestMapping("/buy.do")
public class A07_FormExp {
	/*
	 # 구매물품 
	 물건 종류 [전자제품/식품류/잡화]
	 가격: [1000~10000] 천단위로 10000까지
	 갯수: [1~10]
	 form:form modelattribute를 이용해서 
	 get/post 방식으로 출력 
	 */
	
	@ModelAttribute("prodKind")
	public ArrayList<String> prodKind(){
		ArrayList<String> prodKind = new ArrayList<String>();
		prodKind.add("전자제품");
		prodKind.add("식품류");
		prodKind.add("잡화");
		return prodKind;
	}
	
	/*
	 # 주의 
	 1. 공통된 모델어트리뷰트와 요청값에 의해서나 모델에 의해서 처리하는 데이터 차이 
	 2. 
	 	물건종류 [전자제품/식품류/잡화] ==> 공통모델어트리뷰트에서 선언 
	 			[submit] 클릭해서 요청값으로 선택한 내용을 처리하는 부분 
	 		 ==>	public String postBuy(@ModelAttribute("prod") Product sch)		
	 		 		Product의 setKind() 선택한 물건종류 할당 처리 
	 		 		
	 */
	// http://localhost:8080/springweb/buy.do 
//	GetMapping("/buy.do")
//	public String buy(Model d) {
//		d.addAttribute("prod",new Purchase());
//		return "WEB-INF/views/a01_start/a14_formExp.jsp";
//	}
//	
	
	
	@ModelAttribute("prices")
	public ArrayList<Integer> prices(){
		ArrayList<Integer> prices = new ArrayList<Integer>();
		for(int i=1000;i<=10000;i+=1000) {
			prices.add(i);
		}
		return prices;
	}
	
	@ModelAttribute("cnts")
	public ArrayList<Integer> cnts(){
		ArrayList<Integer> cnts = new ArrayList<Integer>();
		for(int i=1;i<=10;i++) {
			cnts.add(i);
		}
		return cnts;
	}
//	RequestMapping("/purchase.do")
//	public String form1(@ModelAttribute("purchase") Purchase purchase) {
//		return "WEB-INF/views/a01_start/a14_formExp.jsp";
//	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(@ModelAttribute("purchase") Purchase purchase) {
		return "WEB-INF/views/a01_start/a14_formExp.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String form1(@ModelAttribute("purchase") Purchase purchase) {
		return "WEB-INF/views/a01_start/a14_formExp.jsp";
	}
	
}
