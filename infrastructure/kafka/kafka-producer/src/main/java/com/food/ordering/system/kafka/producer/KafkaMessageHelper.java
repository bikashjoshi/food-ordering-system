package com.food.ordering.system.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class KafkaMessageHelper {
    public<T> ListenableFutureCallback<SendResult<String, T>> getKafkaCallback(String responseTopicName, T avroModel, String orderId, String avroModelName) {
        return new ListenableFutureCallback<SendResult<String, T>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Error while sending " + avroModelName  +
                        "message {} to topic {}", avroModel.toString(), responseTopicName, ex);
            }

            @Override
            public void onSuccess(SendResult<String, T> result) {
                RecordMetadata metaData = result.getRecordMetadata();
                log.info("Received successful response from kafka for order id: {}"
                                + " Topic: {} Partition: {} Offset: {} Timestamp: {}",
                        orderId,
                        metaData.topic(),
                        metaData.partition(),
                        metaData.offset(),
                        metaData.timestamp());
            }
        };
    }
}
