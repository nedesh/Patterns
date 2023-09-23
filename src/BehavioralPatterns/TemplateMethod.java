package BehavioralPatterns;
//Позволяет определить основу алгоритма и позволяющий подклассам переопределять определенные шаги алгоритма, не изменяя его структуру в целом.

public class TemplateMethod {
    public static void main(String[] args) {
        ReportGenerator pdf = new PdfReportGenerator();
        pdf.generateReport();
        System.out.println();
        ReportGenerator doc = new DocReportGenerator();
        doc.generateReport();
    }
}

abstract class ReportGenerator {
    protected abstract void generateHeader();

    protected abstract void generateBody();

    protected abstract void generateFooter();

    public void generateReport() {
        generateHeader();
        generateBody();
        generateFooter();
    }
}

class PdfReportGenerator extends ReportGenerator {

    @Override
    protected void generateHeader() {
        System.out.println("Header");
    }

    @Override
    protected void generateBody() {
        System.out.println("Body");
    }

    @Override
    protected void generateFooter() {
    }
}

class DocReportGenerator extends ReportGenerator {

    @Override
    protected void generateFooter() {
        System.out.println("Footer");
    }

    @Override
    protected void generateHeader() {
        System.out.println("Header");
    }

    @Override
    protected void generateBody() {
    }
}