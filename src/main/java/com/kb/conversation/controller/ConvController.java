package com.kb.conversation.controller;

import com.kb.conversation.dto.ConvDTO;
import com.kb.conversation.service.ConvService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/conversations")
@RequiredArgsConstructor
@Slf4j
@Api(value = "ConvController", tags = "채팅")
@PropertySource({"classpath:/application.properties"})
public class ConvController {

    private final ConvService convService;

    @PostMapping
    public ResponseEntity<String> saveConversation(@RequestBody ConvDTO convDTO) {
        log.info("request:{}", convDTO.getAnswer());
        convService.saveConversation(convDTO);
        return ResponseEntity.ok("채팅 기록이 저장되었습니다.");
    }

    @GetMapping("/{createdAt}")
    public ResponseEntity<List<ConvDTO>> getConversationsByCreatedAt(@PathVariable String createdAt) {
        List<ConvDTO> conversations = convService.getConversationsByCreatedAt(createdAt);
        return ResponseEntity.ok(conversations);
    }

    @DeleteMapping("/{createAt}")
    public ResponseEntity<String> deleteConversationsByCreatedAt(@PathVariable String createAt) {
        convService.deleteConversationsByCreatedAt(createAt);
        return ResponseEntity.ok("채팅 기록이 삭제되었습니다.");
    }
}
