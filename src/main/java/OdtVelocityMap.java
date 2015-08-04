import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

import java.io.*;
import java.util.Map;

import static model.ProjectMapProvider.getProjectMap;

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
