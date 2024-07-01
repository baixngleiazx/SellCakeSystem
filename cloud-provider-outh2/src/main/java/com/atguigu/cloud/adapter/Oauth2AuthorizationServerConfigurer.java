package com.atguigu.cloud.adapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.annotation.Resource;

@Configuration
@EnableAuthorizationServer
public class Oauth2AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {


    @Resource
    private AuthenticationManager manager;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("webapp").secret(encoder.encode("654321")) //客户端 id/secret
                .authorizedGrantTypes("client_credentials", "password", "implicit", "authorization_code", "refresh_token") //授权妈模式
                .scopes("all")
                .autoApprove(false)
                .redirectUris("http://localhost:9528/login");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
                .passwordEncoder(encoder)    // 编码器设定为BCryptPasswordEncoder
                .allowFormAuthenticationForClients()  // 允许客户端使用表单验证，一会我们POST请求中会携带表单信息
                .checkTokenAccess("permitAll()");     // 允许所有的Token查询请求
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .authenticationManager(manager);
        // 由于SpringSecurity新版本的一些底层改动，这里需要配置一下authenticationManager，才能正常使用password模式
    }

}
