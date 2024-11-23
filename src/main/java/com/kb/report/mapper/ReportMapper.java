package com.kb.report.mapper;

import com.kb.conversation.dto.ConvDTO;
import com.kb.report.dto.ReportDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportMapper {
    void insertReport(ReportDTO report);
    List<ReportDTO> getReportsByCreatedAt(@Param("createdAt") String createdAt);
    void updateReport(ReportDTO report);
}
