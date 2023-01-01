package test.entity;

import java.sql.Date;

public class SoftwareHardwarePlatform {
    private int software_id;
    private String software_name;
    private String software_company;
    private Date software_time;
    private int software_contribution;
    private String software_proof;

    public SoftwareHardwarePlatform(int software_id, String software_name, String software_company, Date software_time, int software_contribution, String software_proof) {
        this.software_id = software_id;
        this.software_name = software_name;
        this.software_company = software_company;
        this.software_time = software_time;
        this.software_contribution = software_contribution;
        this.software_proof = software_proof;
    }

    public SoftwareHardwarePlatform() {
    }

    @Override
    public String toString() {
        return "软硬件平台{" +
                "名称='" + software_name + '\'' +
                ", 服务单位='" + software_company + '\'' +
                ", 上线时间=" + software_time +
                ", 贡献度='" + software_contribution + '\'' +
                ", 佐证材料='" + software_proof + '\'' +
                '}';
    }

    public int getSoftware_id() {
        return software_id;
    }

    public void setSoftware_id(int software_id) {
        this.software_id = software_id;
    }

    public String getSoftware_name() {
        return software_name;
    }

    public void setSoftware_name(String software_name) {
        this.software_name = software_name;
    }

    public String getSoftware_company() {
        return software_company;
    }

    public void setSoftware_company(String software_company) {
        this.software_company = software_company;
    }

    public Date getSoftware_time() {
        return software_time;
    }

    public void setSoftware_time(Date software_time) {
        this.software_time = software_time;
    }

    public int getSoftware_contribution() {
        return software_contribution;
    }

    public void setSoftware_contribution(int platform_contribution) {
        this.software_contribution = platform_contribution;
    }

    public String getSoftware_proof() {
        return software_proof;
    }

    public void setSoftware_proof(String software_proof) {
        this.software_proof = software_proof;
    }
}
