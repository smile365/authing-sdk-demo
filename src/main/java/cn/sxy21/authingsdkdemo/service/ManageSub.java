package cn.sxy21.authingsdkdemo.service;

import cn.authing.sdk.java.client.ManagementClient;
import cn.authing.sdk.java.model.Receiver;

//@Service
public class ManageSub {

    public ManageSub(ManagementClient managementClient) {
        managementClient.subEvent("authing.department.deleted", new Receiver() {
            @Override
            public void onReceiverMessage(String msg) {
                if (msg != null) {
                    System.out.println("ReceiverMessage: "+msg);
                }
            }
        });
    }
}
