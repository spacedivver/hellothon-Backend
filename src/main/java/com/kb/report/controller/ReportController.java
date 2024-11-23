package com.kb.report.controller;

import com.kb.report.dto.ReportDTO;
import com.kb.report.service.ReportService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
@Slf4j
@Api(value = "ReportController", tags = "리포트")
@PropertySource({"classpath:/application.properties"})
public class ReportController {

    private final ReportService reportService;

    @PostMapping("")
    public ResponseEntity<String> generateReport(@RequestBody String createdAt) {
        try {
            String result = reportService.generateReport(createdAt);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred while processing the report.");
        }
    }

    @GetMapping("/{createdAt}")
    public ResponseEntity<ReportDTO> getReportByCreatedAt(@PathVariable String createdAt) {
        ReportDTO reports = reportService.getReportByCreatedAt(createdAt);
        return ResponseEntity.ok(reports);
    }
}
