package com.capgemini.pocelasticsearch.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.capgemini.pocelasticsearch.database")
@ComponentScan(basePackages = {"com.capgemini.pocelasticsearch"})
public class Config  {
    @Value("${elasticsearch.host}")
    private String host;
    @Value("${elasticsearch.url}")
    private String url;
    @Value("${elasticsearch.username}")
    private String username;
    @Value("${elasticsearch.password}")
    private String password;

    @Bean
    public RestHighLevelClient client() {
        final var clientConfiguration
                = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .withBasicAuth("elastic","Q=vwras2gh-e0IF2Axuu")
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }
}
