package entity;

public class ExampleSentences extends Entity {
	private String content;

	public ExampleSentences() {
		super();
	}

	public ExampleSentences(Integer id, String content) {
		super(id);
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ExampleSentences [id=" + id + ", content=" + content + "]";
	}

}
