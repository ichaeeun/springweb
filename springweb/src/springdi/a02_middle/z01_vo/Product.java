package springdi.a02_middle.z01_vo;


// springdi.z05_vo.Product 

// <bean id="prod" class="springdi.z01_vo.Product"> 와 동일한 선언. 
public class Product {
	private String name;
	private int price;
	private int cnt;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, int price, int cnt) {
		super();
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public void show() {
		System.out.println("#물건구매정보#");
		System.out.print(name+"\t");
		System.out.print(price+"\t");
		System.out.print(cnt+"\n");
	}
	
}
