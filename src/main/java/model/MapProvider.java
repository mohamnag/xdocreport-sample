package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This sample class provides the model data as a Map.
 *
 * Created by mohamnag on 04/08/15.
 */
public abstract class MapProvider {

    public static Map<String, String> getProjectMap() {
        Map<String, String> project = new HashMap<String, String>();
        project.put("Name", "Test Project");
        project.put("HomePage", "http://test.project.com");
        project.put("Developer", "angelo.zerr@gmail.com");
        return project;
    }

    public static List<Map<String, String>> getDevelopers() {
        List<Map<String,String>> developers = new ArrayList<>();

        Map<String,String> developer1 = new HashMap<>();
        developer1.put("Name", "ZERR");
        developer1.put("LastName", "Angelo");
        developer1.put("Mail", "angelo.zerr@gmail.com");
        developers.add(developer1);

        Map<String,String> developer2 = new HashMap<>();
        developer2.put("Name", "Leclercq");
        developer2.put("LastName", "Pascal");
        developer2.put("Mail", "pascal.leclercq@gmail.com");
        developers.add(developer2);

        return developers;
    }
}
