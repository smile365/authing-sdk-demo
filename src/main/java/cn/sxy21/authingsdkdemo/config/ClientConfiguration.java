package cn.sxy21.authingsdkdemo.config;


import cn.authing.sdk.java.client.AuthenticationClient;
import cn.authing.sdk.java.client.ManagementClient;
import cn.authing.sdk.java.dto.LoginTokenRespDto;
import cn.authing.sdk.java.dto.SignInOptionsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration()
@EnableConfigurationProperties(ClientProperties.class)
public class ClientConfiguration {

    @Autowired
    private ClientProperties properties;

    @Bean
    public ManagementClient managementClient(){
        return new ManagementClient(properties.getManagement());
    }

    @Bean
    public AuthenticationClient authenticationClient(){
        AuthenticationClient authenticationClient = null;
        try {
            authenticationClient = new AuthenticationClient(properties.getAuthentication());
            setAccessToken(authenticationClient);
        }catch (Exception e){
            log.info("{}",properties.getAuthentication());
            log.info("{}",e.getMessage());
        }
        return authenticationClient;
    }

    private void setAccessToken(AuthenticationClient authenticationClient){
        String username = "test1";
        String passwd = "123456";
        LoginTokenRespDto loginTokenRespDto = authenticationClient.signInByAccountPassword(username,
                passwd,
                new SignInOptionsDto());
        log.info("setAccessToken");

        authenticationClient.setAccessToken(loginTokenRespDto.getData().getAccessToken());
    }
}
