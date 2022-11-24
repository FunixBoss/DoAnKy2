package entity;

public class Lesson extends Entity {
	private String image;
	private String title;

	public Lesson() {
		super();
	}

	public Lesson(String image, String title) {
		super();
		this.image = image;
		this.title = title;
	}

	public Lesson(Integer id, String image, String title) {
		super(id);
		this.image = image;
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Lesson [id=" + id + ", image=" + image + ", title=" + title + "]";
	}

}