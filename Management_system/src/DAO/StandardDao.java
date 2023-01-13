package DAO;
import bean.Standard;

public interface StandardDao {
    void addStandard( Standard standard);
    void upStandard(Standard standard);
    void deleteStandard(int standard_id);
    int getStandardId();
    Standard getStandard(int standard_id);
}
