package springweb.z02_vo;

public class Link {
//	id NUMBER PRIMARY KEY,
//	SOURCE NUMBER NOT NULL,
//	target NUMBER NOT NULL,
//	TYPE varchar2(1) NOT NULL
	private int id;
	private int source;
	private int target;
	private int type;
	public Link() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Link(int id, int source, int target, int type) {
		super();
		this.id = id;
		this.source = source;
		this.target = target;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
}
