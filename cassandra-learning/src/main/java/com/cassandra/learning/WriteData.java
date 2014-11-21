package com.cassandra.learning;

import java.util.List;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class WriteData {

Session session;
	
	public WriteData(Session session){
		this.session = session;
	}
	public void write(int user_id, String fname, String lname, int age, String email, long phone){
		final ResultSet result = session.execute("insert into testkeyspace.users (user_id, fname, lname, age, email, phone) values (?,?,?,?,?,?)", user_id, lname, fname, age, email, phone);
		final List<Row> row = result.all();
		
		for(Row r : row){
			System.out.println("User Id : " + r.getInt("user_id") + "   First Name : " + r.getString("fname") + "   Last Name : " + r.getString("lname") + "   Age : " + r.getInt("age") + "   Email : " + r.getString("email") + "   Phone : " + r.getLong("phone"));
		}
	}
}
