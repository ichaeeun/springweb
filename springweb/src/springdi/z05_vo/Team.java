package springdi.z05_vo;

public class Team {
	private String tname;
	private Player player;
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Team(String tname) {
		super();
		this.tname = tname;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public void setPl02(Player player) {
		this.player = player;
	}
	
	public void showTeam() {
		System.out.println(tname+"팀 선수");
		player.showInfo();
	}
}
