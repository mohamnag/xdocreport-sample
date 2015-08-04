import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import model.Project;

import java.io.*;
import java.util.Map;

import static model.ProjectMapProvider.getProjectMap;

/**
 * A very basic sample of using XDocReport library to generate reports from
 * XDoc and ODT sources.
 *
 * Created by mohamnag on 04/08/15.
 */
public class Main {

    public static void main(String[] args) {
        xdocVelocityPojo();
        xdocVelocityMap();

        odtVelocityPojo();
        OdtVelocityMap();
    }

    /**
     * This generates the report from a XDOC source document and using Velocity
     * templates setting values using a POJO object.
     */
    private static void xdocVelocityPojo() {
        try {
            // 1) Load Docx file by filling Velocity template engine and cache it to the registry
            InputStream in = Main.class.getResourceAsStream("template.docx");
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

    /**
     * This generates the report from a XDOC source document and using Velocity
     * templates setting values using a Map.
     */
    private static void xdocVelocityMap() {
        try {
            // 1) Load Docx file by filling Velocity template engine and cache it to the registry
            InputStream in = Main.class.getResourceAsStream("template.docx");
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

            // 2) Create context Map
            IContext context = report.createContext();
            Map<String, String> project = getProjectMap();
            context.put("project", project);

            // 3) Generate report by merging Map with the Docx
            OutputStream out = new FileOutputStream(new File("output-velocity-map.docx"));
            report.process(context, out);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XDocReportException e) {
            e.printStackTrace();
        }
    }

    /**
     * This generates the report from a ODT source document and using Velocity
     * templates setting values using a POJO object.
     */
    private static void odtVelocityPojo() {
        try {
            // 1) Load Docx file by filling Velocity template engine and cache it to the registry
            InputStream in = Main.class.getResourceAsStream("template.odt");
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

            // 2) Create context Java model
            IContext context = report.createContext();

            Project project = new Project("Test Project Name", "http://www.testproject.com", "you!");

            context.put("project", project);

            // 3) Generate report by merging Java model with the Docx
            OutputStream out = new FileOutputStream(new File("output-velocity-pojo.odt"));
            report.process(context, out);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XDocReportException e) {
            e.printStackTrace();
        }
    }

    /**
     * This generates the report from a ODT source document and using Velocity
     * templates setting values using a Map object.
     */
    private static void OdtVelocityMap() {
        try {
            // 1) Load ODT file by filling Velocity template engine and cache it to the registry
            InputStream in = Main.class.getResourceAsStream("template.odt");
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

            // 2) Create context Map
            IContext context = report.createContext();
            Map<String, String> project = getProjectMap();
            context.put("project", project);

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
