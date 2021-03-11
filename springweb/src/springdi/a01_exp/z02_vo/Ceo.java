package springdi.a01_exp.z02_vo;

public class Ceo {
	private String name;

	public Ceo() {
		super();
		// TODO Auto-generated constructor stub
		name="마대표(CEO)";
	}
	
	
	public Ceo(String name) {
		super();
		this.name = name;
	}


	public void show() {
		System.out.println(name);
	}
	
}
