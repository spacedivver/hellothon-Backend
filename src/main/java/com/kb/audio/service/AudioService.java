package com.kb.audio.service;

import com.kb.audio.dto.AudioDTO;
import com.kb.audio.mapper.AudioMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Log4j
@Service
@RequiredArgsConstructor
@PropertySource({"classpath:/application.properties"})
public class AudioService {

    private final AudioMapper audioFileMapper;

    public void saveAudioFile(AudioDTO audioFile) {
        audioFileMapper.insertAudioFile(audioFile);
    }

    public AudioDTO getAudioByFilename(String filename) {
        return audioFileMapper.getAudioByFilename(filename);
    }

}
