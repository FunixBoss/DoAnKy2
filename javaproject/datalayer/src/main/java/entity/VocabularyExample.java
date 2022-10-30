package entity;

public class VocabularyExample extends Entity {
	private Integer vocabularyId;
	private Integer exampleSentenceId;

	public VocabularyExample() {
		super();
	}

	public VocabularyExample(Integer id, Integer vocabularyId, Integer exampleSentenceId) {
		super(id);
		this.vocabularyId = vocabularyId;
		this.exampleSentenceId = exampleSentenceId;
	}

	public Integer getVocabularyId() {
		return vocabularyId;
	}

	public void setVocabularyId(Integer vocabularyId) {
		this.vocabularyId = vocabularyId;
	}

	public Integer getExampleSentenceId() {
		return exampleSentenceId;
	}

	public void setExampleSentenceId(Integer exampleSentenceId) {
		this.exampleSentenceId = exampleSentenceId;
	}

	@Override
	public String toString() {
		return "VocabularyExample [id=" + id + ", vocabularyId=" + vocabularyId + ", exampleSentenceId="
				+ exampleSentenceId + "]";
	}

}
