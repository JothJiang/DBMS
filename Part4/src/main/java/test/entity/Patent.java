package test.entity;

import java.sql.Date;

public class Patent {
    private int patent_id;
    private String patent_name;
    private String patent_type;
    private String patent_number;
    private Date patent_deliverytime;
    private String patent_status;
    private int patent_contribution;
    private String patent_proof;

    public Patent(int patent_id, String patent_name, String patent_type, String patent_number, Date patent_deliverytime, String patent_status, int patent_contribution, String patent_proof) {
        this.patent_id = patent_id;
        this.patent_name = patent_name;
        this.patent_type = patent_type;
        this.patent_number = patent_number;
        this.patent_deliverytime = patent_deliverytime;
        this.patent_status = patent_status;
        this.patent_contribution = patent_contribution;
        this.patent_proof = patent_proof;
    }

    public Patent() {
    }

    @Override
    public String toString() {
        return "专利{" +
                "名称='" + patent_name + '\'' +
                ", 类型='" + patent_type + '\'' +
                ", 专利号='" + patent_number + '\'' +
                ", 发布时间=" + patent_deliverytime +
                ", 状态='" + patent_status + '\'' +
                ", 贡献度排名=" + patent_contribution +
                ", 佐证材料='" + patent_proof + '\'' +
                '}';
    }

    public String getPatent_name() {
        return patent_name;
    }

    public void setPatent_name(String patent_name) {
        this.patent_name = patent_name;
    }

    public String getPatent_type() {
        return patent_type;
    }

    public void setPatent_type(String patent_type) {
        this.patent_type = patent_type;
    }

    public Date getPatent_deliverytime() {
        return patent_deliverytime;
    }

    public void setPatent_deliverytime(Date patent_deliverytime) {
        this.patent_deliverytime = patent_deliverytime;
    }

    public String getPatent_status() {
        return patent_status;
    }

    public void setPatent_status(String patent_status) {
        this.patent_status = patent_status;
    }

    public String getPatent_proof() {
        return patent_proof;
    }

    public void setPatent_proof(String patent_proof) {
        this.patent_proof = patent_proof;
    }

	public int getPatent_id() {
		return patent_id;
	}

	public void setPatent_id(int patent_id) {
		this.patent_id = patent_id;
	}

	public String getPatent_number() {
		return patent_number;
	}

	public void setPatent_number(String patent_number) {
		this.patent_number = patent_number;
	}

	public int getPatent_contribution() {
		return patent_contribution;
	}

	public void setPatent_contribution(int patent_contribution) {
		this.patent_contribution = patent_contribution;
	}
}
