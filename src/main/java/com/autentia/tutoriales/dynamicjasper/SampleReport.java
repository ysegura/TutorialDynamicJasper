package com.autentia.tutoriales.dynamicjasper;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;

import com.autentia.tutoriales.dynamicjasper.datasource.SampleDatasource;
import com.autentia.tutoriales.dynamicjasper.exporter.ReportExporter;

public class SampleReport {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleReport.class);

    private static Report report;

    private static JasperPrint jasperPrint;

    private static JasperReport jasperReport;

    private static Map parameters = new HashMap();

    private static DynamicReport dynamicReport;

    public static void main(String[] args) throws Exception {
        report = new Report();
        dynamicReport = report.buildReport();

        JRDataSource dataSource = SampleDatasource.getDatasource(dynamicReport.getColumns());

        jasperReport = DynamicJasperHelper.generateJasperReport(dynamicReport, new ClassicLayoutManager(), parameters);

        jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        ReportExporter.exportReport(jasperPrint, "/opt/DynamicJasper/report.pdf");

        DynamicJasperHelper.generateJRXML(dynamicReport, new ClassicLayoutManager(), parameters, "UTF-8",
                "/opt/DynamicJasper/report.jrxml");

    }

}
