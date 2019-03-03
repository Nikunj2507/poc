package nikunj.activeMq.mqExample.topic;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import nikunj.activeMq.mqExample.ConnectionProvider;

public class SubScriber implements Runnable, MessageListener {

	public void run() {
		try {
			TopicConnection connection = ConnectionProvider.getTopicConnetion();
			connection.start();
			TopicSession session = connection.createTopicSession(false, 1);
			Topic destination = session.createTopic("HelloTopic");
			MessageConsumer sub = session.createConsumer(destination);
			sub.setMessageListener(this);

		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				System.out.println(((TextMessage) message).getText());
				System.out.println("message received");
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
