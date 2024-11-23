package com.kb.report.service;


import com.kb.report.dto.ReportDTO;
import com.kb.report.mapper.ReportMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

@Log4j
@Service
@RequiredArgsConstructor
@PropertySource({"classpath:/application.properties"})
public class ReportService {

    private final ReportMapper reportMapper;
    @Value("${ai.execute.path}")
    private String aiDirectoryPath;

    public String generateReport(String createdAt) {
        try {

            File workingDirectory = new File(aiDirectoryPath);
            String pythonScriptPath = "report.py";

            ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath, createdAt);
            processBuilder.directory(workingDirectory);
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            process.waitFor();

            return output.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error occurred while executing the Python script.");
        }
    }

    public ReportDTO getReportByCreatedAt(String createdAt) {
        return reportMapper.getReportsByCreatedAt(createdAt);
    }
}

