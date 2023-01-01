package test.entity;

import java.sql.Date;

public class Paper {
	private int paper_id;
	private String paper_name;
	private String journal_name;
	private String paper_status;
	private Date paper_time;
	private String index_type;
	private String paper_library;
	private String paper_proof;
	
    public Paper(int paper_id, String paper_name, String journal_name, String paper_status, Date paper_time, String index_type, String paper_library, String paper_proof) {
        this.paper_id = paper_id;
        this.paper_name = paper_name;
        this.journal_name = journal_name;
        this.paper_status = paper_status;
        this.index_type = index_type;
        this.paper_time = paper_time;
        this.paper_library = paper_library;
        this.paper_proof = paper_proof;
    }

    public Paper() {
    }

    @Override
    public String toString() {
        return "论文{" +
                "论文名称='" + paper_name + '\'' +
                ", 发表刊物名称='" + journal_name + '\'' +
                ", 状态='" + paper_status + '\'' +
                ", 发表时间='" + paper_time + '\'' +
                ", 索引类型='" + index_type + '\'' +
                ", 归属库情况='" + paper_time + '\'' +
                ", 佐证材料='" + paper_proof + '\'' +
                '}';
    }

	public int getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(int paper_id) {
		this.paper_id = paper_id;
	}

	public String getPaper_name() {
		return paper_name;
	}

	public void setPaper_name(String paper_name) {
		this.paper_name = paper_name;
	}

	public String getJournal_name() {
		return journal_name;
	}

	public void setJournal_name(String journal_name) {
		this.journal_name = journal_name;
	}

	public String getPaper_status() {
		return paper_status;
	}

	public void setPaper_status(String paper_status) {
		this.paper_status = paper_status;
	}

	public Date getPaper_time() {
		return paper_time;
	}

	public void setPaper_time(Date paper_time) {
		this.paper_time = paper_time;
	}

	public String getIndex_type() {
		return index_type;
	}

	public void setIndex_type(String index_type) {
		this.index_type = index_type;
	}

	public String getPaper_library() {
		return paper_library;
	}

	public void setPaper_library(String paper_library) {
		this.paper_library = paper_library;
	}

	public String getPaper_proof() {
		return paper_proof;
	}

	public void setPaper_proof(String paper_proof) {
		this.paper_proof = paper_proof;
	}
}