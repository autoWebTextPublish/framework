package com.hbasesoft.framework.message.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import com.hbasesoft.framework.common.ErrorCodeDef;
import com.hbasesoft.framework.common.GlobalConstants;
import com.hbasesoft.framework.common.utils.Assert;
import com.hbasesoft.framework.common.utils.UtilException;
import com.hbasesoft.framework.common.utils.logger.Logger;
import com.hbasesoft.framework.message.core.MessagePublisher;
import com.hbasesoft.framework.message.rocketmq.factory.RocketmqFactory;

/**
 * 
 * <Description> <br>
 * 
 * @author 大刘杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年6月25日 <br>
 * @since V1.0<br>
 * @see com.hbasesoft.framework.message.rocketmq <br>
 */
public class RocketmqMessagePublisher implements MessagePublisher {

	private static final Logger log = new Logger(RocketmqMessagePublisher.class);

	@Override
	public String getName() {
		return RocketmqFactory.ROCKET_MQ_NAME;
	}

	@Override
	public void publish(String channel, byte[] data) {
		// 默认使用普通消费
		publish(channel, data, RocketmqFactory.ROCKET_MQ_DEFAULT_PUBLISH_TYPE, channel, 0L);
	}

	public void publish(String channel, byte[] data, Long delayTime) {
		// 默认使用普通消费
		publish(channel, data, RocketmqFactory.ROCKET_MQ_DEFAULT_PUBLISH_TYPE, channel, delayTime);
	}

	/**
	 * 
	 * publish:. <br/>
	 * 
	 * @author 大刘杰
	 * @param channel
	 * @param data
	 * @param produceModel
	 * @param producerGroup
	 * @since JDK 1.8
	 * @produceModel: RocketmqAutoConfiguration.ROCKET_MQ_DEFAULT_PUBLISH_TYPE
	 *                RocketmqAutoConfiguration.ROCKET_MQ_DEFAULT_PUBLISH_TYPE
	 *                RocketmqAutoConfiguration.ROCKET_MQ_DEFAULT_PUBLISH_TYPE
	 */
	public void publish(String channel, byte[] data, String produceModel, String producerGroup, Long delayTime) {

		Assert.notEmpty(producerGroup, ErrorCodeDef.MESSAGE_MODEL_EMPTY_P_GROUP_NAME);

		DefaultMQProducer defaultMQProducer = RocketmqFactory.getDefaultProducer(producerGroup);

		// Create a message instance, specifying topic, tag and message body.
		Message msg = new Message(channel, GlobalConstants.BLANK, data);

		// Set delay level
		if (delayTime > 0L) {
			msg.setDelayTimeLevel(RocketmqFactory.calculationLevel(delayTime));
		}

		try {
			switch (produceModel) {
			case RocketmqFactory.ROCKET_MQ_PUBLISH_TYPE_ORDERLY:
				// 顺序消费
				// defaultMQProducer.send(msg, mq)
				break;
			case RocketmqFactory.ROCKET_MQ_PUBLISH_TYPE_TRANSACTION:
				// 事务消费
				// transactionMQProducer.sendMessageInTransaction(msg, tranExecuter, arg);
				break;
			default:
				// 普通消费
				SendResult send = defaultMQProducer.send(msg);
				log.info("发送结果 " + send.toString());
				break;
			}
		} catch (Exception e) {
			throw new UtilException(ErrorCodeDef.MESSAGE_MODEL_P_SEND_ERROR, e);
		}

	}
}
