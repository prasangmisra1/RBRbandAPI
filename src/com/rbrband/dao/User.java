package com.rbrband.dao;

public class User {
	   private Integer id;
	   private String name;
	   private Integer state_id;
	   private Integer country_id;
	   private Integer age;
	   private String email;
	   
	   public void setEmail(String email)
	   {
		   this.email=email;
	   }

	   public String getEmail()
	   {
		   return email;
	   }
	   public void setId(Integer id) {
		      this.id = id;
		   }
		   public Integer getId() {
		      return id;
		   }
		   public void setName(String name) {
			      this.name = name;
			   }
			   public String getName() {
			      return name;
			   }
			   
		public void setState_id(Integer state_id){
				   this.state_id=state_id;
			   }
			   public Integer getState_id()
			   {
				   return state_id;
			   }
			   
			   public void setCountry_id(Integer country_id){
				   this.country_id=country_id;
			   }
			   public Integer getCountry_id()
			   {
				   return country_id;
			   }
	   public void setAge(Integer age) {
	      this.age = age;
	   }
	   public Integer getAge() {
	      return age;
	   }

	   

	   
	}