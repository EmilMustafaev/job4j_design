package ru.job4j.ocp.violation;

public class ReportGenerator {
    /* Нарушение : жесткая привязка к конкретным классам отсуствие гибкости,
    для добавления нового типа отчета придется изменять существующий код.
     */
    public void generateReport(String reportType) {
        if (reportType.equals("PDF")) {
            System.out.println("Generating PDF report");
        } else if (reportType.equals("Excel")) {
            System.out.println("Generating Excel report");
        }
    }
}
