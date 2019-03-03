package nikunj.activeMq.mqExample.topic;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;

import nikunj.activeMq.mqExample.ConnectionProvider;

public class Publisher implements Runnable {

	public void run() {
		try {
			TopicConnection connection = ConnectionProvider.getTopicConnetion();
			TopicSession session = connection.createTopicSession(false, 1);
			Destination destination = session.createTopic("HelloTopic");
			MessageProducer prod;
			prod = session.createProducer(destination);
			Thread.sleep(5000);
			Message message = session.createTextMessage("Hope you are doindg good!");
			System.out.println("message sent ");
			prod.send(message);
			prod.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
