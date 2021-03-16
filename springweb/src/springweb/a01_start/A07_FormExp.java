package springweb.a01_start;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springweb.z03_vo.Purchase;

@Controller 
@RequestMapping("/purchase.do")
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
//	@RequestMapping("/purchase.do")
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
