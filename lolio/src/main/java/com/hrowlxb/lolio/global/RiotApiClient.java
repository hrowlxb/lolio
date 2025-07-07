package com.hrowlxb.lolio.global;

import com.hrowlxb.lolio.dto.SummonerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class RiotApiClient {

    @Value("${riot.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate =  new RestTemplate();

    public SummonerDto getSummonerByName(String summonerName) {
        String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" +
                UriUtils.encode(summonerName, StandardCharsets.UTF_8);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Riot-Token", apiKey);

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<SummonerDto> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, SummonerDto.class);

        return response.getBody();
    }
}
