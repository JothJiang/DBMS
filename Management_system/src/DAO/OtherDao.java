package DAO;

import bean.Other;

public interface OtherDao {
	void addOther(Other other);
    void upOther(Other other);
    void deleteOther(int other_id);
    int getOtherId();
    Other getOther(int other_id);

}
