package springdi.a02_middle.z03_vo;

public class Cpu {
	private String company;
	private double spec;
	public Cpu() {
		super();
		company="삼성(기본옵션)";
		spec=3.2;
		// TODO Auto-generated constructor stub
	}
	public Cpu(String company, double spec) {
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
	public void setSpec(double spec) {
		this.spec = spec;
	}
	public void info() {
		System.out.println(company+"\t"+spec+"GHz");
	}
	
}
