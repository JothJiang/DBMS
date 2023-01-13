package DAO;

import bean.Activity;

import java.sql.SQLException;
import java.util.List;

public interface ActivityDAO {
    void addActivity(Activity activity);
    int deleteActivity(Integer id) throws SQLException;
    List<Activity> queryActivityById(String gid);
    List<Activity> queryActivityByDepart(String depart);
    void updateStateById(String id, String note);
}
