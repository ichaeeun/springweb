package springdi.a02_middle.z03_vo;

import org.springframework.beans.factory.annotation.Autowired;


public class Computer {
	private String company;
	
	// required=false
	// 만일 컨테이너에 객체가 있다면, autowiring으로 객체를 할당 처리한다. 
	
	@Autowired(required=false)
	private Cpu cpu;
	@Autowired(required=false)
	private Ram ram;
	@Autowired(required=false)
	private Ssd ssd;
	public Computer() {
		super();
		company="조립(기본옵션)";
		// TODO Auto-generated constructor stub
	}
	public Computer(String company) {
		super();
		this.company = company;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}
	public void setRam(Ram ram) {
		this.ram = ram;
	}
	public void setSsd(Ssd ssd) {
		this.ssd = ssd;
	}
	
	public void showCom() {
		System.out.println(company+"컴퓨터 장착부품");
		if(cpu!=null) cpu.info();
		if(ram!=null) ram.info();
		if(ssd!=null) ssd.info();
	}
}




