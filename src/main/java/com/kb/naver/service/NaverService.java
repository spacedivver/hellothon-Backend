package com.kb.naver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class NaverService {

    private final RestTemplate restTemplate;

    // application.properties에서 값을 가져옴
    @Value("${naver.api.client-id}")
    private String clientId;

    @Value("${naver.api.client-secret}")
    private String clientSecret;

    public byte[] getTtsFile(String speaker, String text) {
        // API URL
        String url = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";

        log.info("speaker: {}, text: {}", speaker, text);
        // 파라미터 설정
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("speaker", speaker);
        map.add("text", text);

        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); // x-www-form-urlencoded로 설정
        headers.set("X-NCP-APIGW-API-KEY-ID", clientId); // application.properties에서 클라이언트 ID 가져옴
        headers.set("X-NCP-APIGW-API-KEY", clientSecret); // application.properties에서 클라이언트 Secret 가져옴

        // 요청 바디 설정
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        // RestTemplate을 통해 POST 요청 보내기
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.POST, request, byte[].class);

        // 응답 코드 확인 및 처리
        return response.getBody();
    }
}
