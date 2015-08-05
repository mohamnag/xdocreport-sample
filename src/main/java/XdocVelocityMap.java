import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import model.MapProvider;

import java.io.*;

/**
 * This generates the report from a XDOC source document and using Velocity
 * templates setting values using a Map.
 *
 * Created by mohamnag on 04/08/15.
 */
public class XdocVelocityMap {

    public static void main(String[] args) {

        try {
            // 1) Load Docx file by filling Velocity template engine and cache it to the registry
            InputStream in = XdocVelocityMap.class.getResourceAsStream("template.docx");
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

            // Add meta-data for the fields who build up a list
            FieldsMetadata metadata = new FieldsMetadata();
            metadata.addFieldAsList("developers.Name");
            metadata.addFieldAsList("developers.LastName");
            metadata.addFieldAsList("developers.Mail");
            report.setFieldsMetadata(metadata);

            // 2) Create context Map
            IContext context = report.createContext();
            // Register project map
            context.put("project", MapProvider.getProjectMap());
            // Register developers list
            context.put("developers", MapProvider.getDevelopers());

            // 3) Generate report by merging Map with the Docx
            OutputStream out = new FileOutputStream(new File("output-velocity-map.docx"));
            report.process(context, out);

            // Generate PDF out of report
            OutputStream pdfOut = new FileOutputStream(new File("output-velocity-map-xdoc.pdf"));
            Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.XWPF);
            report.convert(context, options, pdfOut);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XDocReportException e) {
            e.printStackTrace();
        }

    }

}
