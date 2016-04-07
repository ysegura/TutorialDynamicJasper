package com.autentia.tutoriales.dynamicjasper;

import java.util.Date;

import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;

public class Report {

    public DynamicReport buildReport() throws ClassNotFoundException {
        FastReportBuilder fastReportBuilder = new FastReportBuilder();

        fastReportBuilder.addColumn("ID", "id", Long.class.getName(), 50)
                .addColumn("Nombre", "firstname", String.class.getName(), 200)
                .addColumn("Apellidos", "surname", String.class.getName(), 200)
                .addColumn("Fecha Incorporación", "startDate", String.class.getName(), 120)
                .addColumn("Salario", "salary", String.class.getName(), 120)
                .addColumn("Departamento", "department", String.class.getName(), 180)
                .setTitle("Mi primer Informe con DynamicJasper").setSubtitle("Generado el " + new Date())
                .setPrintBackgroundOnOddRows(true).setUseFullPageWidth(true);

        return fastReportBuilder.build();
    }

}
