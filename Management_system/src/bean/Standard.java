package bean;
import java.sql.Date;

public class Standard {
	private int standard_id;
	private String standard_name;
	private String standard_level;
	private Date standard_time;
	private String standard_proof;
	
    public Standard(int standard_id, String standard_name, String standard_level, Date standard_time, String standard_proof) {
        this.standard_id = standard_id;
        this.standard_name = standard_name;
        this.standard_level = standard_level;
        this.standard_time = standard_time;
        this.standard_proof = standard_proof;
    }

    public Standard() {
    }

    @Override
    public String toString() {
        return "标准{" +
                "名称='" + standard_name + '\'' +
                ", 级别='" + standard_level + '\'' +
                ", 发布时间='" + standard_time + '\'' +
                ", 佐证材料='" + standard_proof + '\'' +
                '}';
    }

	public int getStandard_id() {
		return standard_id;
	}

	public void setStandard_id(int standard_id) {
		this.standard_id = standard_id;
	}

	public String getStandard_name() {
		return standard_name;
	}

	public void setStandard_name(String standard_name) {
		this.standard_name = standard_name;
	}

	public String getStandard_level() {
		return standard_level;
	}

	public void setStandard_level(String standard_level) {
		this.standard_level = standard_level;
	}

	public Date getStandard_time() {
		return standard_time;
	}

	public void setStandard_time(Date standard_time) {
		this.standard_time = standard_time;
	}

	public String getStandard_proof() {
		return standard_proof;
	}

	public void setStandard_proof(String standard_proof) {
		this.standard_proof = standard_proof;
	}
}