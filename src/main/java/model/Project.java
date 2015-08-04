package model;

/**
 * A sample POJO used as model source.
 *
 * Created by mohamnag on 04/08/15.
 */
public class Project {
    private final String name;
    private String homePage;
    private String developer;

    public Project(String name, String homePage, String developer) {
        this.name = name;
        this.homePage = homePage;
        this.developer = developer;
    }

    public String getName() {
        return name;
    }

    public String getHomePage() {
        return homePage;
    }

    public String getDeveloper() {
        return developer;
    }
}
