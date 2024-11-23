package com.kb.report.controller;

import com.kb.report.dto.ReportDTO;
import com.kb.report.service.ReportService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
@Slf4j
@Api(value = "ReportController", tags = "리포트")
@PropertySource({"classpath:/application.properties"})
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/{rno}")
    public ReportDTO generateReport(
            @PathVariable int rno,
            @RequestParam String scriptPath
    ) {
        return reportService.generateReport(rno, scriptPath);
    }
}
