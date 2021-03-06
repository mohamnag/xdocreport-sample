import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import model.ModelProvider;

import java.io.*;

/**
 * This generates the report from a ODT source document and using Velocity
 * templates setting values using a POJO object.
 *
 * Created by mohamnag on 04/08/15.
 */
public class OdtVelocityPojo {

    public static void main(String[] args) {
        try {
            // 1) Load Docx file by filling Velocity template engine and cache it to the registry
            InputStream in = OdtVelocityPojo.class.getResourceAsStream("template.odt");
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

            // Add meta-data for the fields who build up a list
            FieldsMetadata metadata = new FieldsMetadata();
            metadata.addFieldAsList("developers.Name");
            metadata.addFieldAsList("developers.LastName");
            metadata.addFieldAsList("developers.Mail");
            report.setFieldsMetadata(metadata);

            // 2) Create context Java model
            IContext context = report.createContext();
            // Register project model
            context.put("project", ModelProvider.getProject());
            // Register developers list
            context.put("developers", ModelProvider.getDevelopers());

            // 3) Generate report by merging Java model with the Docx
            OutputStream out = new FileOutputStream(new File("output-velocity-pojo.odt"));
            report.process(context, out);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XDocReportException e) {
            e.printStackTrace();
        }

    }

}
