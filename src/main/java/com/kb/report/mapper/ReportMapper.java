package com.kb.report.mapper;

import com.kb.report.dto.ReportDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportMapper {
    void insertReport(ReportDTO report);

    ReportDTO getReportById(int rno);

    void updateReport(ReportDTO report);
}
