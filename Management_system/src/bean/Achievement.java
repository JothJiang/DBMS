package bean;

public class Achievement {
	private int id;
	private String type;
	private int detail_id;
	
    public Achievement(int detail_id, String type) {
        this.type = type;
        this.detail_id = detail_id;
    }

    public Achievement() {
    }

    @Override
    public String toString() {
        return "Standard{" +
                "type='" + type + '\'' +
                ", detail_id='" + detail_id + '\'' +
                '}';
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(int detail_id) {
		this.detail_id = detail_id;
	}
}
