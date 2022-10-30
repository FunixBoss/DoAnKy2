package entity;

public class Category extends Entity {
	private String name;
	private String imageIcon;
	private Integer parentId;

	public Category() {
		super();
	}

	public Category(String name, String imageIcon, Integer parentId) {
		this.name = name;
		this.imageIcon = imageIcon;
		this.parentId = parentId;
	}

	public Category(Integer id, String name, String imageIcon, Integer parentId) {
		super(id);
		this.name = name;
		this.imageIcon = imageIcon;
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageIcon() {
		return imageIcon;
	}

	public void setImageIcon(String imageIcon) {
		this.imageIcon = imageIcon;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "Categories [id=" + id + ", name=" + name + ", imageIcon=" + imageIcon + ", parentId=" + parentId + "]";
	}

}
