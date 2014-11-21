package com.cassandra.learning;


import com.datastax.driver.core.Session;

public class CassandraMaster {

	public static void main(String[] args){
		final Connector client = new Connector();
		final String node = args.length > 0 ? args[0] : "localhost";
		final int port = args.length > 1? Integer.parseInt(args[1]) : 9042;
		final String keyspace = args.length > 2 ? args[2] : "testkeyspace";
		
		client.connect(node, port, keyspace);
		Session session = client.getSession();
		
		final ReadData robj = new ReadData(session);
		robj.read();
		int length = robj.numberOfRows();
		
		
		final WriteData wobj = new WriteData(session);
		wobj.write(length+1, "firstname"+length, "lastname" + length, length+3, "firstname"+length+"@gmail.com", 987456321+length);
		
		client.close();
	}
}
