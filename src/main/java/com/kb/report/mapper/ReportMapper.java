package com.kb.report.mapper;

import com.kb.report.dto.ReportDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ReportMapper {
    void insertReport(ReportDTO report);
    ReportDTO getReportsByCreatedAt(@Param("createdAt") String createdAt);
    void updateReport(ReportDTO report);
}
