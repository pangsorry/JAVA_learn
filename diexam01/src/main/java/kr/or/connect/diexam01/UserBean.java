package kr.or.connect.diexam01;

public class UserBean {
/*
 * bean의 특징
 * 1.  기본생성자를 가지고 있다
 * 2. 필드는 private로 선언한다
 * 3. getter, setter 메소드를 가지고 있어야한다.  ex) getName(), setName() 을 name property라고 한다.(중요한 용어)
 * 
 */
	
	private String name;
	private String age;
	private boolean male;
	
	public UserBean() {}
	public UserBean(String name, String age, boolean male) {
		super();
		this.name = name;
		this.age = age;
		this.male = male;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	
	
}
