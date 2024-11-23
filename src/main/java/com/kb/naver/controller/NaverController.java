package com.kb.naver.controller;

import com.kb.naver.service.NaverService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/naver")
@RequiredArgsConstructor
@Slf4j
@Api(value = "네이버API", tags = "TTS")
@PropertySource({"classpath:/application.properties"})
public class NaverController {
    private final NaverService naverService;

    @GetMapping
    public ResponseEntity naverStt(@RequestParam String speaker,@RequestParam String text) {
        byte[] result = naverService.getTtsFile(speaker, text);
        return ResponseEntity.ok(result);
    }
}
