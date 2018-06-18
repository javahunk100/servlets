package com.servlet.model;

public class Profile {

	private int pid;
	private String name;
	private String email;
	private String mobile;
	private String gender;
	private String address;
	private String image;
	
	
	public Profile(){
		
	}


	public Profile(int pid, String name, String email, String mobile, String gender, String address, String image) {
		this.pid = pid;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.address = address;
		this.image = image;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Profile [pid=" + pid + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", gender="
				+ gender + ", address=" + address + ", image=" + image + "]";
	}

}
