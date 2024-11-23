package com.kb.conversation.mapper;

import com.kb.conversation.dto.ConvDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ConvMapper {

    void insertConversation(ConvDTO convDTO);
    List<ConvDTO> getConversationsByMno(@Param("createdAt") String createdAt);
    void deleteConversationsByMno(@Param("createdAt") String createdAt);
}
