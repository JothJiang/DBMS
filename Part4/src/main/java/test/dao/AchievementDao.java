package test.dao;

import test.entity.Achievement;

public interface AchievementDao {
    void addAchievement(Achievement achievement);
    void upAchievement(Achievement achievement);
    void deleteAchievement(int id);
    int getAchievementId();
    Achievement getAchievement(int id);
}

