package app.attractionfinder.webapp.common.model;

public class Match {

    private final long id;
    private final long attraction_id;
    private final long tag_id;

    public Match(long id, long attraction_id, long tag_id) {
        this.id = id;
        this.attraction_id = attraction_id;
        this.tag_id = tag_id;
    }

    public long getId() {
        return this.id;
    }

    public long getAttractionId() {
        return this.attraction_id;
    }

    public long getTag() {
        return this.tag_id;
    }



}
