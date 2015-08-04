import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

import java.io.*;

/**
 * Created by mohamnag on 04/08/15.
 */
public class Main {

    public static class Project {

        private final String name;

        public Project(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
//        testXdoc();
        testOdt();
    }

    private static void testXdoc() {
        try {
            // 1) Load Docx file by filling Velocity template engine and cache it to the registry
            InputStream in = Main.class.getResourceAsStream("template.docx");
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

            // 2) Create context Java model
            IContext context = report.createContext();

//            Map<String,String> project = new HashMap<String, String>();
//            project.put("Name", "Test Project");
//            project.put("Mail", "angelo.zerr@gmail.com");

            Project project = new Project("Test Project Name");

            context.put("project", project);

            // 3) Generate report by merging Java model with the Docx
            OutputStream out = new FileOutputStream(new File("output.docx"));
            report.process(context, out);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XDocReportException e) {
            e.printStackTrace();
        }
    }

    private static void testOdt() {
        try {
            // 1) Load Docx file by filling Velocity template engine and cache it to the registry
            InputStream in = Main.class.getResourceAsStream("template.odt");
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

            // 2) Create context Java model
            IContext context = report.createContext();

//            Map<String,String> project = new HashMap<String, String>();
//            project.put("Name", "Test Project");
//            project.put("Mail", "angelo.zerr@gmail.com");

            Project project = new Project("Test Project Name");

            context.put("project", project);

            // 3) Generate report by merging Java model with the Docx
            OutputStream out = new FileOutputStream(new File("output.odt"));
            report.process(context, out);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XDocReportException e) {
            e.printStackTrace();
        }
    }

}
