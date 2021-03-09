package springdi.z01_vo;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Collection {
	private ArrayList<String> list;
	private Set<String> sets;
	private Properties props;
	private Map<String,String> maps;
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	public void setSets(Set<String> sets) {
		this.sets = sets;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}
	// toString(): 객체 생성하고, 참조변수로 출력처리할 때 default로 리턴할 문자열을 
	// 선언하는 기능 메서드이다. 
	public String toString() {
		return "[list="+list+"],[sets="+sets+"],[props="+props+"],[maps="+maps+"]";
	}
}
