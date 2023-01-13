package bean;

import java.sql.Date;

public class Report {
	private int report_id;
	private String report_name;
	private String report_type;
	private String report_company;
	private Date report_time;
	private int report_contribution;
	private String report_proof;
	
    public Report(int report_id, String report_name, String report_type, String report_company, Date report_time, int report_contribution, String report_proof) {
        this.report_id = report_id;
        this.report_name = report_name;
        this.report_type = report_type;
        this.report_company = report_company;
        this.report_time = report_time;
        this.report_contribution = report_contribution;
        this.report_proof = report_proof;
    }

    public Report() {
    }

    @Override
    public String toString() {
        return "报告{" +
                "名称='" + report_name + '\'' +
                ", 类型='" + report_type + '\'' +
                ", 服务单位='" + report_company + '\'' +
                ", 报告时间='" + report_time + '\'' +
                ", 贡献度排名='" + report_contribution + '\'' +
                ", 佐证材料='" + report_proof + '\'' +
                '}';
    }

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

	public String getReport_name() {
		return report_name;
	}

	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}

	public String getReport_type() {
		return report_type;
	}

	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}

	public String getReport_company() {
		return report_company;
	}

	public void setReport_company(String report_company) {
		this.report_company = report_company;
	}

	public Date getReport_time() {
		return report_time;
	}

	public void setReport_time(Date report_time) {
		this.report_time = report_time;
	}

	public int getReport_contribution() {
		return report_contribution;
	}

	public void setReport_contribution(int report_contribution) {
		this.report_contribution = report_contribution;
	}

	public String getReport_proof() {
		return report_proof;
	}

	public void setReport_proof(String report_proof) {
		this.report_proof = report_proof;
	}
}