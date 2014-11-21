package com.cassandra.learning;

import java.util.List;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class ReadData {
	Session session;
	
	public ReadData(Session session){
		this.session = session;
	}
	public void read(){
		final ResultSet result = session.execute("select * from users");
		final List<Row> row = result.all();
		
		for(Row r : row){
			System.out.println("User Id : " + r.getInt("user_id") + "   First Name : " + r.getString("fname") + "   Last Name : " + r.getString("lname") + "   Age : " + r.getInt("age") + "   Email : " + r.getString("email") + "   Phone : " + r.getLong("phone"));
		}
	}
	
	public int numberOfRows(){
		final ResultSet result = session.execute("select * from users");
		final List<Row> row = result.all();
		return row.size();
	}
}
