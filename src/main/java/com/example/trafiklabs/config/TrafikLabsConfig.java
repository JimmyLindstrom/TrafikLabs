package com.example.trafiklabs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class TrafikLabsConfig {

    @Value("${app.base-url}")
    private String baseUrl;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(clientCodecConfigurer ->
                                clientCodecConfigurer.defaultCodecs().maxInMemorySize(5000000))
                        .build())
                .build();
    }
}
