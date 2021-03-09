package springdi.z01_vo;
// springdi.z01_vo.Restore 
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Restore {
	private ArrayList<String> arry;
	private Set<String> set;
	private Properties prop;
	private Map<String, String> map;
	public Restore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<String> getArry() {
		return arry;
	}
	public void setArry(ArrayList<String> arry) {
		this.arry = arry;
	}
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[arry = "+arry+"],[set="+set+"],[prop="+prop+"],[map="+map+"]";
	}
	 
}
