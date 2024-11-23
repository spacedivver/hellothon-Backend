package com.kb.report.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReportDTO {
    private int rno;
    private String life;
    private String health;
    private String food;
    private String hobby;
    private String etc;
    private Date createdAt;
}
