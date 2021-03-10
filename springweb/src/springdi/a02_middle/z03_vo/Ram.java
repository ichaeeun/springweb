package springdi.a02_middle.z03_vo;

public class Ram {
	private String company;
	private int spec;
	public Ram() {
		super();
		company="삼성(기본옵션)";
		spec=16;
		// TODO Auto-generated constructor stub
	}
	public Ram(String company, int spec) {
		super();
		this.company = company;
		this.spec = spec;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getSpec() {
		return spec;
	}
	public void setSpec(int spec) {
		this.spec = spec;
	}
	
	public void info() {
		System.out.println(company+"\t"+spec+"GB");
	}
	
}
