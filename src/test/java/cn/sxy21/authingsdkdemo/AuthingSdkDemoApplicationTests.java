package cn.sxy21.authingsdkdemo;

import cn.authing.sdk.java.client.AuthenticationClient;
import cn.authing.sdk.java.client.ManagementClient;
import cn.authing.sdk.java.dto.LoginTokenRespDto;
import cn.authing.sdk.java.dto.SignInOptionsDto;
import cn.authing.sdk.java.model.Receiver;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class AuthingSdkDemoApplicationTests {


    @Autowired
    AuthenticationClient authenticationClient;

    @Test
    void contextLoads() {
        String username = "test1";
        String passwd = "123456";
        LoginTokenRespDto loginTokenRespDto = authenticationClient.signInByAccountPassword(username,
                passwd,
                new SignInOptionsDto());
        log.info("{}",loginTokenRespDto.getData());
        authenticationClient.setAccessToken(loginTokenRespDto.getData().getAccessToken());
    }

}
