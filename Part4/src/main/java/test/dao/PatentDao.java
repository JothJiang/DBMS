package test.dao;

import test.entity.Patent;

public interface PatentDao {
    void addPatent(Patent patent);
    void updatePatent(Patent patent);
    void deletePatent(int patent_id);
    int getPatentId();
    Patent getPatent(int getPatent_id);

}
