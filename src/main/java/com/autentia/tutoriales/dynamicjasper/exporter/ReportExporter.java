package com.autentia.tutoriales.dynamicjasper.exporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportExporter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportExporter.class);

    public static void exportReport(JasperPrint jp, String path) throws JRException, FileNotFoundException {
        LOGGER.debug("Exporing report to: " + path);
        JRPdfExporter exporter = new JRPdfExporter();

        File outputFile = new File(path);
        File parentFile = outputFile.getParentFile();
        if (parentFile != null) parentFile.mkdirs();
        FileOutputStream fos = new FileOutputStream(outputFile);

        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);

        exporter.exportReport();

        LOGGER.debug("Report exported: " + path);
    }

}