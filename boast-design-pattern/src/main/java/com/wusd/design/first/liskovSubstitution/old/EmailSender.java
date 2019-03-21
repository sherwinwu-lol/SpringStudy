package com.wusd.design.first.liskovSubstitution.old;

public interface EmailSender {
    void send(CommonCustomer customer);

    void send(VIPCustomer customer);
}
