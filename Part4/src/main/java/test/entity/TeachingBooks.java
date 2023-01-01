package test.entity;

import java.sql.Date;

public class TeachingBooks {
    private int tb_id;
    private String tb_name;
    private String tb_publisher;
    private Date tb_publicationtime;
    private int tb_contribution;
    private String tb_proof;

    public TeachingBooks(int tb_id, String tb_name, String tb_publisher, Date tb_publicationtime, int tb_contribution, String tb_proof) {
        this.tb_id = tb_id;
        this.tb_name = tb_name;
        this.tb_publisher = tb_publisher;
        this.tb_publicationtime = tb_publicationtime;
        this.tb_contribution = tb_contribution;
        this.tb_proof = tb_proof;
    }

    public TeachingBooks() {
    }

    @Override
    public String toString() {
        return "教材{" +
                "名称='" + tb_name + '\'' +
                ", 出版社='" + tb_publisher + '\'' +
                ", 出版时间='" + tb_publicationtime + '\'' +
                ", 贡献度='" + tb_contribution + '\'' +
                ", 佐证材料='" + tb_proof + '\'' +
                '}';
    }

    public int getTb_id() {
        return tb_id;
    }

    public void setTb_id(int tb_id) {
        this.tb_id = tb_id;
    }

    public String getTb_name() {
        return tb_name;
    }

    public void setTb_name(String tb_name) {
        this.tb_name = tb_name;
    }

    public String getTb_publisher() {
        return tb_publisher;
    }

    public void setTb_publisher(String tb_publisher) {
        this.tb_publisher = tb_publisher;
    }

    public Date getTb_publicationtime() {
        return tb_publicationtime;
    }

    public void setTb_publicationtime(Date tb_publicationtime) {
        this.tb_publicationtime = tb_publicationtime;
    }

    public int getTb_contribution() {
        return tb_contribution;
    }

    public void setTb_contribution(int tb_contribution) {
        this.tb_contribution = tb_contribution;
    }

    public String getTb_proof() {
        return tb_proof;
    }

    public void setTb_proof(String tb_proof) {
        this.tb_proof = tb_proof;
    }
}
