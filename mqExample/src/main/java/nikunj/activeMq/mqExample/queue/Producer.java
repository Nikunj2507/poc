package nikunj.activeMq.mqExample.queue;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import nikunj.activeMq.mqExample.ConnectionProvider;

public class Producer implements Runnable {

	public void run() {

		try {
			// get connection
			Connection connection = ConnectionProvider.getQueueConnetion();

			// start connection
			connection.start();

			// create Session
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// create a queue
			Destination destination = session.createQueue("TEST.HelloQueue");

			// create a producer
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			String message = "Hellow world from " + Thread.currentThread().getName();
			TextMessage msg = session.createTextMessage(message);
			System.out.println("sending Message :" + message);

			// send the message to producer
			producer.send(msg);

			// close connection
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
