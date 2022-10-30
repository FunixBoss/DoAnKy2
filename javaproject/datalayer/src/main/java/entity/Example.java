package entity;

public class Example extends Entity {
	private String content;
	private String meaning;
	private Integer vocabularyId;

	public Example() {
		super();
	}

	public Example(Integer id, String content, String meaning, Integer vocabularyId) {
		super(id);
		this.content = content;
		this.meaning = meaning;
		this.vocabularyId = vocabularyId;
	}

	public Example(String content, String meaning, Integer vocabularyId) {
		super();
		this.content = content;
		this.meaning = meaning;
		this.vocabularyId = vocabularyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public Integer getVocabularyId() {
		return vocabularyId;
	}

	public void setVocabularyId(Integer vocabularyId) {
		this.vocabularyId = vocabularyId;
	}

	@Override
	public String toString() {
		return "Example [id=" + id + ", content=" + content + ", meaning=" + meaning + ", vocabularyId=" + vocabularyId
				+ "]";
	}
}
