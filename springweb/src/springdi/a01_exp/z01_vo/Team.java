package springdi.a01_exp.z01_vo;

import java.util.ArrayList;

public class Team {
	private String tname;
	private ArrayList<Player> plist;
	private Player player;
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Team(String tname) {
		super();
		this.tname = tname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public ArrayList<Player> getPlist() {
		return plist;
	}
	public void setPlist(ArrayList<Player> plist) {
		this.plist = plist;
	}
	
	public void setPl2(Player player) {
		this.player = player;
	}
	public void show() {
		System.out.println("팀명: "+tname);
		if(plist!=null) {
			for(Player p01:plist) {
				p01.showInfo();
			}
		}else {
			System.out.println("선수가 없습니다.");
		}
		
	}
}
