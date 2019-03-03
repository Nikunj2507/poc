package nikunj.activeMq.mqExample.queue;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import nikunj.activeMq.mqExample.ConnectionProvider;

public class Consumer implements Runnable {

	public void run() {

		try {
			Connection connection = ConnectionProvider.getQueueConnetion();
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = session.createQueue("TEST.HelloQueue");

			// Create a MessageConsumer from the Session to the Topic or Queue
			MessageConsumer consumer = session.createConsumer(destination);
			Message message = consumer.receive();

			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				String text = textMessage.getText();
				System.out.println("Received: " + text);
			} else {
				System.out.println("Received: " + message);
			}
			consumer.close();
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
}
