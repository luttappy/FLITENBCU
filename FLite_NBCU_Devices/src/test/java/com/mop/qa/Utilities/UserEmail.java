/**
 * Elsevier
 * This is a helper class for email address generation
 * created by @author bookere
 * @category Helper
 */
package com.mop.qa.Utilities;

public class UserEmail {
	
	public UserEmail(){
		this.setEmail(new String());
		this.setName(new String());
	}
	
	public UserEmail(String name, String email){
		this.setEmail(email);
		this.setName(name);
	}
	
	private String email;
	private String name;	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public void print(){
		System.out.println(getCanvasFormat());
	}
	
	public String getCanvasFormat(){
		return String.format("\"%s\" <%s>", this.getName(),this.getEmail());
	}

}
