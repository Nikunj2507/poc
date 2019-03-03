package nikunj.activeMq.mqExample.topic;

import javax.jms.JMSException;

public class topicDemo {
	public static void main(String[] args) throws JMSException {
		new Thread(new Publisher()).start();
		new Thread(new SubScriber()).start();
		new Thread(new SubScriber()).start();
	}
}
