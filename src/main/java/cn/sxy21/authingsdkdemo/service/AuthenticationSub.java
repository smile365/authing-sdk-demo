package cn.sxy21.authingsdkdemo.service;

import cn.authing.sdk.java.client.AuthenticationClient;
import cn.authing.sdk.java.model.Receiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationSub {

    public AuthenticationSub(AuthenticationClient authenticationClient) {
        authenticationClient.subEvent("authing.user.logout", new Receiver() {
            @Override
            public void onReceiverMessage(String s) {
                System.out.println(s);
            }
        });
    }
}
