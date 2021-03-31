package springweb.z02_vo;

import java.util.Date;
// springweb.z02_vo.Data
public class Data {
//	id NUMBER PRIMARY KEY,
//	text varchar2(255) NOT NULL,
//	start_date DATE NOT NULL,
//	duration NUMBER NOT NULL,
//	progress NUMBER NOT NULL,
//	sortorder NUMBER NOT NULL,
//	parent NUMBER NOT NULL
	private int id;
	private String text;
	private Date start_date;
	private int duration;
	private double progress;
	private int sortorder;
	private int parent;
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Data(int id, String text, Date start_date, int duration, double progress, int sortorder, int parent) {
		super();
		this.id = id;
		this.text = text;
		this.start_date = start_date;
		this.duration = duration;
		this.progress = progress;
		this.sortorder = sortorder;
		this.parent = parent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getProgress() {
		return progress;
	}
	public void setProgress(double progress) {
		this.progress = progress;
	}
	public int getSortorder() {
		return sortorder;
	}
	public void setSortorder(int sortorder) {
		this.sortorder = sortorder;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	
	
}
