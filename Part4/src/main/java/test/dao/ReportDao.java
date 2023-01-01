package test.dao;

import test.entity.Report;

public interface ReportDao {
    void addReport(Report report);
    void upReport(Report report);
    void deleteReport(int report_id);
    int getReportId();
    Report getReport(int report_id);
}
