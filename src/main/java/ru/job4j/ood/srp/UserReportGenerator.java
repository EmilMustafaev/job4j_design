package ru.job4j.ood.srp;

public class UserReportGenerator {
    /* Нарушение: Класс отвечает и за генерацию отчёта, и за его вывод */
    public String generateReport() {
        /* Логика генерации отчета */
        return "User report";
    }

    public void printReport(String report) {
        /* Логика вывода отчета на консоль */
        System.out.println(report);
    }
}
