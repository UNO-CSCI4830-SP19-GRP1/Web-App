package app.attractionfinder.webapp.common.model;

public class Tag {
	private final Long id;
	private final String name;

	public Tag(final Long id, final String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
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
