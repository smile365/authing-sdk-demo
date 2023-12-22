package cn.sxy21.authingsdkdemo.config;


import cn.authing.sdk.java.model.AuthenticationClientOptions;
import cn.authing.sdk.java.model.ManagementClientOptions;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "sdk.config")
public class ClientProperties {
    private ManagementClientOptions management;
    private AuthenticationClientOptions authentication;

}
