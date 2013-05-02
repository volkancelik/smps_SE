package model;

public class Employee {
    private int ssn;
    private String name;
    private int age;
    private String gender; // persons gender .. female or male
    private int classification; //classify the employee (administrator or user)
	
	//constructor
    public Employee(int ssn, String name, int age, String gender, int classification){
    	setSsn(ssn);
    	setName(name);
    	setAge(age);
    	setGender(gender);
    	setClassification(classification);
    }

	
	public Role getClassification() {
		if(this.classification==1) return Role.USER;
		if(this.classification==2) return Role.ADMIN;
		//default Role
		return Role.USER;
	}
	
	public void setClassification(int classification) {
		this.classification = classification;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
