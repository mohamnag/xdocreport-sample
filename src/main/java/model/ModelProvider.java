package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple abstract class that provides sample POJOs filled up.
 *
 * Created by mohamnag on 04/08/15.
 */
public abstract class ModelProvider {

    public static List<Developer> getDevelopers() {
        List<Developer> developers = new ArrayList<>();
        developers.add(new Developer("ZERR", "Angelo", "angelo.zerr@gmail.com"));
        developers.add(new Developer("Leclercq", "Pascal", "pascal.leclercq@gmail.com"));
        return developers;
    }

    public static Project getProject() {
        return new Project("Test Project Name", "http://www.testproject.com", "you!");
    }

}
