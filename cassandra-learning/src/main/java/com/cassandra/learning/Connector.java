package com.cassandra.learning;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

//class used for connection to cassandra db
public class Connector {

	private Cluster cluster;
	private Session session;
	
	/**
	 * @author shuja
	 * Connect to cassandra cluster specified by node ipaddress and port
	 */
	public void connect(final String node, final int port, String keyspace){
		this.cluster = Cluster.builder().addContactPoints(node).withPort(port).build();
		final Metadata metadata = cluster.getMetadata();
		System.out.println("Connected to cluster: " + metadata.getClusterName());
		for(final Host host : metadata.getAllHosts()){
			System.out.println("Datacenter : " + host.getDatacenter() + " Host : " + host.getAddress() + " Rack : " + host.getRack());
		}
		session = cluster.connect(keyspace);
	}

	public Session getSession(){
		return this.session;
	}
	
	public void close(){
		cluster.close();
	}
	
}	
