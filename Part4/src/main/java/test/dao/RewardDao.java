package test.dao;

import test.entity.Reward;

public interface RewardDao {
    void addReward(Reward reward);
    void upReward(Reward reward);
    void deleteReward(int reward_id);
    int getRewardId();
    Reward getReward(int reward_id);
}
