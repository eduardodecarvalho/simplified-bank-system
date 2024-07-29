package com.eduardodecarvalho.simplifiedbankssytem.notification;

import org.springframework.kafka.annotation.KafkaListener;

import com.eduardodecarvalho.simplifiedbankssytem.transaction.Transaction;

public class NotificationConsumer {

    @KafkaListener(topics = "transaction-notification", groupId = "simplified-bank-system")
    public void receiveNotification(Transaction transaction) {
        System.out.println("Consumer" + transaction);
    }
}
