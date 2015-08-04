package model;

/**
 * A sample POJO used as data source.
 *
 * Created by mohamnag on 04/08/15.
 */
public class Developer {
    private final String name;
    private final String lastName;
    private final String mail;

    public Developer(String name, String lastName, String mail) {
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }
}
