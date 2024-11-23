package com.kb.report.service;


import com.kb.conversation.dto.ConvDTO;
import com.kb.conversation.mapper.ConvMapper;
import com.kb.report.dto.ReportDTO;
import com.kb.report.mapper.ReportMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
@PropertySource({"classpath:/application.properties"})
public class ReportService {

    private final ReportMapper reportMapper;

    public String generateReport(String json) {
        try {
            // Python 스크립트 경로
            String pythonScriptPath = "report.py"; // 실제 Python 스크립트 경로로 수정

            // Python 스크립트 실행
            ProcessBuilder processBuilder = new ProcessBuilder("python3", pythonScriptPath, json);
            processBuilder.redirectErrorStream(true);

            // Python 스크립트 실행 및 결과 읽기
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // 프로세스 종료 대기
            process.waitFor();

            // Python 스크립트의 결과 반환
            return output.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error occurred while executing the Python script.");
        }
    }

    public List<ReportDTO> getReportByCreatedAt(String createdAt) {
        return reportMapper.getReportsByCreatedAt(createdAt);
    }
}

