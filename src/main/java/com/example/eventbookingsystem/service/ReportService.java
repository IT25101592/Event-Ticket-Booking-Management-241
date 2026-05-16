package com.example.eventbookingsystem.service;

import com.example.eventbookingsystem.model.Report;
import com.example.eventbookingsystem.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    // Create (create new report)
    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    // Read
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    // Read
    public Optional<Report> getReportById(int id) {
        return reportRepository.findById(id);
    }

    // Read
    public List<Report> getReportsByType(String type) {
        return reportRepository.findByReportType(type);
    }

    // Delete (delete report)
    public void deleteReport(int id) {
        reportRepository.deleteById(id);
    }
}