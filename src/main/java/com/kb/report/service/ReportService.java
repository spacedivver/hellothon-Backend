package com.kb.report.service;


import com.kb.report.dto.ReportDTO;
import com.kb.report.mapper.ReportMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Log4j
@Service
@RequiredArgsConstructor
@PropertySource({"classpath:/application.properties"})
public class ReportService {

    private ReportMapper reportMapper;

    public ReportDTO generateReport(int rno, String scriptPath) {
        ReportDTO report = reportMapper.getReportById(rno);

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "python", scriptPath, String.valueOf(rno), report.getLife(), report.getHealth(),
                    report.getFood(),report.getHobby(), report.getEtc()
            );
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                report.setLife(output.toString().trim());
                report.setHealth(output.toString().trim());
                report.setFood(output.toString().trim());
                report.setHobby(output.toString().trim());
                report.setEtc(output.toString().trim());
            } else {
                report.setLife("Failed to generate report.");
                report.setHealth("Failed to generate report.");
                report.setFood("Failed to generate report.");
                report.setHobby("Failed to generate report.");
                report.setEtc("Failed to generate report.");
            }

            reportMapper.updateReport(report);

        } catch (Exception e) {
            e.printStackTrace();
            report.setLife("Error occurred while generating report.");
            report.setHealth("Error occurred while generating report.");
            report.setFood("Error occurred while generating report.");
            report.setHobby("Error occurred while generating report.");
            report.setEtc("Error occurred while generating report.");
            reportMapper.updateReport(report);
        }

        return report;
    }

}
