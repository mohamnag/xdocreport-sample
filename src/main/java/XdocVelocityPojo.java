import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import model.Project;

import java.io.*;

/**
 * This generates the report from a XDOC source document and using Velocity
 * templates setting values using a POJO object.
 *
 * Created by mohamnag on 04/08/15.
 */
public class XdocVelocityPojo {

    public static void main(String[] args) {
        try {
            // 1) Load Docx file by filling Velocity template engine and cache it to the registry
            InputStream in = XdocVelocityPojo.class.getResourceAsStream("template.docx");
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

            // 2) Create context Java model
            IContext context = report.createContext();

            Project project = new Project("Test Project Name", "http://www.testproject.com", "you!");

            context.put("project", project);

            // 3) Generate report by merging Java model with the Docx
            OutputStream out = new FileOutputStream(new File("output-velocity-pojo.docx"));
            report.process(context, out);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XDocReportException e) {
            e.printStackTrace();
        }
    }

}
