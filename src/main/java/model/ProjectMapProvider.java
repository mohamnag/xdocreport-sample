package model;

import java.util.HashMap;
import java.util.Map;

/**
 * This sample class provides the model data as a Map.
 *
 * Created by mohamnag on 04/08/15.
 */
public abstract class ProjectMapProvider {

    public static Map<String, String> getProjectMap() {
        Map<String, String> project = new HashMap<String, String>();
        project.put("Name", "Test Project");
        project.put("HomePage", "http://test.project.com");
        project.put("Developer", "angelo.zerr@gmail.com");
        return project;
    }

}
