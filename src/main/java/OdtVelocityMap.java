import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import model.ProjectMapProvider;

import java.io.*;

/**
 * This generates the report from a ODT source document and using Velocity
 * templates setting values using a Map object.
 *
 * Created by mohamnag on 04/08/15.
 */
public class OdtVelocityMap {

    public static void main(String[] args) {
        try {
            // 1) Load ODT file by filling Velocity template engine and cache it to the registry
            InputStream in = OdtVelocityMap.class.getResourceAsStream("template.odt");
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
            context.put("project", ProjectMapProvider.getProjectMap());
            // Register developers list
            context.put("developers", ProjectMapProvider.getDevelopers());

            // 3) Generate report by merging Map with the ODT
            OutputStream out = new FileOutputStream(new File("output-velocity-map.odt"));
            report.process(context, out);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XDocReportException e) {
            e.printStackTrace();
        }
    }

}
