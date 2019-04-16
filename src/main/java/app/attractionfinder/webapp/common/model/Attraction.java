package app.attractionfinder.webapp.common.model;

public class Attraction {

    private final String id;
    private final String name;
    private final String description;

    public Attraction(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {return this.id;}

    public String getName() {return this.name;}

    public String getDescription() {return this.description;}

    @Override
    public String toString() {return "Attraction{" + "id='" + this.id + '\'' + ", name='" + this.name + '\'' + "description='" + this.description + '\'' + '}';}
}
