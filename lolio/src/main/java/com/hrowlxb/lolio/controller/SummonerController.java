package com.hrowlxb.lolio.controller;

import com.hrowlxb.lolio.dto.SummonerDto;
import com.hrowlxb.lolio.service.SummonerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/summoner")
@RequiredArgsConstructor
public class SummonerController {

    private final SummonerService summonerService;

    @GetMapping("/{name}")
    public ResponseEntity<SummonerDto> getSummoner(@PathVariable String name) {
        return ResponseEntity.ok(summonerService.getSummonerInfo(name));
    }
}
