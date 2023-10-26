package br.com.geolocalization.application.config;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.List;

@Configuration
public class CorsConfig {
    @Value("${base.cors.config.address}")
    private String address;

    @Bean
    CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setMaxAge(3600L);
        config.setAllowedOrigins( makeAddress(address) );

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }

    private List<String> makeAddress(String address) {
        int occurrence = StringUtils.countOccurrencesOf(address, ",");

        List<String> addresses = new ArrayList<>();

        if(occurrence > 0) {
            int index = 0;

            while(index != occurrence) {
                String substring = address.substring(address.lastIndexOf(",") + 1, address.length());

                addresses.add("http://" + substring);
                addresses.add("https://" + substring);

                address = address.substring(0, address.lastIndexOf(","));

                index++;

                if(index == occurrence) {
                    addresses.add("http://" + address);
                    addresses.add("https://" + address);
                }
            }
        }

        return addresses;
    }
}