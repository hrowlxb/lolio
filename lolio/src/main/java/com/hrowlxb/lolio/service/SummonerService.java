package com.hrowlxb.lolio.service;

import com.hrowlxb.lolio.dto.SummonerDto;
import com.hrowlxb.lolio.global.RiotApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SummonerService {

    private final RiotApiClient riotApiClient;

    public SummonerDto getSummonerInfo(String name) {
        return riotApiClient.getSummonerByName(name);
    }
}
