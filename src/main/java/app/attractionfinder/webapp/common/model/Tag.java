package app.attractionfinder.webapp.common.model;

public class Tag {
	private final String id;
	private final String name;

	public Tag(final String id, final String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Tag{" + "id='" + this.id + '\'' + ", name='" + this.name + '\'' + '}';
	}
}
