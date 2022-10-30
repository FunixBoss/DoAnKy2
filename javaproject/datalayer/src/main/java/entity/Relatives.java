package entity;

public class Relatives extends Entity {
	private String word;
	private Integer vocabularyId;

	public Relatives() {
		super();
	}

	public Relatives(Integer id, String word, Integer vocabularyId) {
		super(id);
		this.word = word;
		this.vocabularyId = vocabularyId;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Integer getVocabularyId() {
		return vocabularyId;
	}

	public void setVocabularyId(Integer vocabularyId) {
		this.vocabularyId = vocabularyId;
	}

	@Override
	public String toString() {
		return "Relatives [id=" + id + ", word=" + word + ", vocabularyId=" + vocabularyId + "]";
	}

}
