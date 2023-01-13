package DAO;

import bean.Achievement;

public interface AchievementDao {
    void addAchievement(Achievement achievement);
    void upAchievement(Achievement achievement);
    void deleteAchievement(int id);
    int getAchievementId();
    Achievement getAchievement(int id);
}

