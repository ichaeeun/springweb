package springdi.z01_vo;
// springdi.z01_vo.Player
public class Player {
	private String name;
	private double record;
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(String name, double record) {
		super();
		this.name = name;
		this.record = record;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRecord() {
		return record;
	}
	public void setRecord(double record) {
		this.record = record;
	}
	
	public void showInfo() {
		System.out.println(name+"\t"+record);
	}
}
