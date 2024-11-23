package com.kb.conversation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ConvDTO {

    private int cno;
    private String question;
    private String answer;
    private Date createdAt;
}
