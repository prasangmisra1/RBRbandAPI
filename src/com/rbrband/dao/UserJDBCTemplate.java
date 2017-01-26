package com.rbrband.dao;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate implements UserDAO {
   @SuppressWarnings("unused")
private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   public void create(String name, Integer age) {
      String SQL = "insert into user (name, age) values (?, ?)";
      
      jdbcTemplateObject.update( SQL, name, age);
      System.out.println("Created Record Name = " + name + " Age = " + age);
      return;
   }

   public User getUser(Integer id) {
	   try{
      String SQL = "select * from user where id = ?";
      User student = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{id}, new UserMapper());
      return student;
	   }
	   catch(EmptyResultDataAccessException  e)
	   {
		   System.out.println("Data out of bound");
		   return null;
	   }
   }

   public List<User> listUsers() {
      String SQL = "select * from user";
      List <User> students = jdbcTemplateObject.query(SQL, 
                                new UserMapper());
      return students;
   }

   public void delete(Integer id){
      String SQL = "delete from user where id = ?";
      jdbcTemplateObject.update(SQL, id);
      System.out.println("Deleted Record with ID = " + id );
      return;
   }

   public void update(Integer id, Integer age){
      String SQL = "update user set age = ? where id = ?";
      jdbcTemplateObject.update(SQL, age, id);
      System.out.println("Updated Record with ID = " + id );
      return;
   }


@Override
public void create(String name, Integer age, Integer state_id, Integer country_id, String email) {
	
}



}