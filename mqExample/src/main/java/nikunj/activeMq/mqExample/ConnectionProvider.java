package nikunj.activeMq.mqExample;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.TopicConnection;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ConnectionProvider {
	public static Connection getQueueConnetion() {
		// creates a connection and returns it .
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		// Create a Connection
		Connection connection = null;
		try {
			connection = connectionFactory.createConnection();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static TopicConnection getTopicConnetion() {
		// creates a connection and returns it .
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		TopicConnection connection = null;
		// Create a Connection
		try {
			connection = connectionFactory.createTopicConnection();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
