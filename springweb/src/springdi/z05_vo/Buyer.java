package springdi.z05_vo;

import java.util.ArrayList;

public class Buyer {
	private String name;
	private ArrayList<Product> plist;
	private Product product;
	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Buyer(String name) {
		super();
		this.name = name;
		plist = new ArrayList<Product>();
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void setProd03(Product product) {
		this.product = product;
	}
	public void setProd01(Product product) {
		plist.add(product);
	}
	public void setProd02(Product product) {
		plist.add(product);
	}
	
	public void buy2() {
		if(plist.size()>0) {
			System.out.println(name+"의 구매물건");
			System.out.println("물건명\t가격\t갯수\t");
			for(Product p:plist) {
				System.out.println(p.getName()+"\t"+p.getPrice()+"\t"+p.getCnt()+"\t");
			}
		}else {
			System.out.println("없다");
		}
	}
	public void buy() {
		System.out.println(name+"의 구매물건!!");
		if(product!=null) {
			product.show();
		}else {
			System.out.println("구매 물건이 없습니다.");
		}
	}
}
