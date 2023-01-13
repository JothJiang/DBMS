package bean;
import java.sql.Date;

public class Other {
	private int other_id;
	private String other_name;
	private String other_type;
	private Date other_time;
	private String other_contribution;
	private String other_proof;
	
    public Other(int other_id, String other_name, String other_type, Date other_time, String other_contribution, String other_proof) {
        this.other_id = other_id;
        this.other_name = other_name;
        this.other_type = other_type;
        this.other_time = other_time;
        this.other_contribution = other_contribution;
        this.other_proof = other_proof;
    }

    public Other() {
    }

    @Override
    public String toString() {
        return "其他成果{" +
                "名称='" + other_name + '\'' +
                ", 类型='" + other_type + '\'' +
                ", 发表时间='" + other_time + '\'' +
                ", 贡献度='" + other_contribution + '\'' +
                ", 佐证材料='" + other_proof + '\'' +
                '}';
    }

	public int getOther_id() {
		return other_id;
	}

	public void setOther_id(int other_id) {
		this.other_id = other_id;
	}

	public String getOther_name() {
		return other_name;
	}

	public void setOther_name(String other_name) {
		this.other_name = other_name;
	}

	public String getOther_type() {
		return other_type;
	}

	public void setOther_type(String other_type) {
		this.other_type = other_type;
	}

	public Date getOther_time() {
		return other_time;
	}

	public void setOther_time(Date other_time) {
		this.other_time = other_time;
	}

	public String getOther_contribution() {
		return other_contribution;
	}

	public void setOther_contribution(String other_contribution) {
		this.other_contribution = other_contribution;
	}

	public String getOther_proof() {
		return other_proof;
	}

	public void setOther_proof(String other_proof) {
		this.other_proof = other_proof;
	}
}
