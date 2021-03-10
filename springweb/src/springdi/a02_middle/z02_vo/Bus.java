package springdi.a02_middle.z02_vo;

import org.springframework.beans.factory.annotation.Autowired;

public class Bus {
	private int no;
	@Autowired
	private Passenger passenger;
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bus(int no) {
		super();
		this.no = no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public void showPass() {
		System.out.println(no+"번 버스 탑승객");
		passenger.passInfo();
	}
	
}
