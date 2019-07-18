package Week1;

public class Employee {
	private int Id;
	private String name;
	
	public Employee(int iniId,String iniName) {
		Id = iniId;
		name = iniName;
	}
	
	public int getId() {
		return Id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return Id + name;
	}
}
