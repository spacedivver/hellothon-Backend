package com.kb.audio.mapper;

import com.kb.audio.dto.AudioDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AudioMapper {
    void insertAudioFile(AudioDTO audioFile);
    AudioDTO getAudioByFilename(String filename); // 특정 ID 조회
}
