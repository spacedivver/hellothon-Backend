package com.kb.conversation.service;

import com.kb.conversation.dto.ConvDTO;
import com.kb.conversation.mapper.ConvMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConvService {

    private final ConvMapper convMapper;

    public void saveConversation(ConvDTO convDTO) {
        convMapper.insertConversation(convDTO);
    }

    public List<ConvDTO> getConversationsByCreatedAt(Date createdAt) {
        return convMapper.getConversationsByMno(createdAt);
    }

    public void deleteConversationsByCreatedAt(Date createdAt) {
        convMapper.deleteConversationsByMno(createdAt);
    }
}
