package springdi.a02_middle.z01_vo;

import org.springframework.beans.factory.annotation.Autowired;

public class Bus {
	private int no;
	// 컨테이너에 해당 객체가 메모리에 없더라도 에러가 발생하지 않게 
	// autowired 옵션 설정 
	@Autowired(required=false)
	private Passenger passenger;
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bus(int no) {
		super();
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public void showPass() {
		System.out.println(no+"번 버스 탑승객");
		if(passenger!=null) {
			passenger.passInfo();
		}else {
			System.out.println("탑승객없음");
		}
	}
	
}
