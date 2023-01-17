package dto;

public class acount {
	private int id;
	private String name;
	private int age;
	private String gen;
	private int phon;
	private String mail;
	private String salt;
	private String password;
	private String hashedPassword;
	
	public acount(int id, String name, int age, String gen, int phon, String mail, String salt, String password,
			String hashedPassword) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gen = gen;
		this.phon = phon;
		this.mail = mail;
		this.salt = salt;
		this.password = password;
		this.hashedPassword = hashedPassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public int getPhon() {
		return phon;
	}
	public void setPhon(int phon) {
		this.phon = phon;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHashedPassword() {
		return hashedPassword;
	}
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
	
}