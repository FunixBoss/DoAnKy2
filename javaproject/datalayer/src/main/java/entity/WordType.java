package entity;

public class WordType extends Entity {
	private String type;

	public WordType(String type) {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "WordType [id=" + id + ", type=" + type + "]";
	}

}
