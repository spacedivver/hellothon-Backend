package com.kb.audio.controller;

import com.kb.audio.dto.AudioDTO;
import com.kb.audio.service.AudioService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/audio")
@RequiredArgsConstructor
@Slf4j
@Api(value = "AudioController", tags = "오디오")
@PropertySource({"classpath:/application.properties"})
public class AudioController {

    private final AudioService audioService;

    @PostMapping
    public ResponseEntity<String> insertAudio(@RequestBody AudioDTO audioFile) {
        log.info("filename: {}", audioFile.getFilename());
        log.info("audioData: {}", audioFile.getAudioData());

        audioService.saveAudioFile(audioFile);
        return ResponseEntity.ok("Audio file uploaded successfully");
    }

    @GetMapping("/{filename}")
    public ResponseEntity<AudioDTO> getAudio(@PathVariable String filename) {
        AudioDTO audioFile = audioService.getAudioByFilename(filename);
        return ResponseEntity.ok(audioFile);
    }

}
