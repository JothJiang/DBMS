package test.entity;

import java.sql.Date;

public class Reward {
	private int reward_id;
	private String reward_name;
	private String reward_level;
	private String award_level;
	private String reward_rank;
	private Date reward_time;
	private String reward_proof;
	
    public Reward(int reward_id, String reward_name, String reward_level, String award_level, String reward_rank, Date reward_time, String reward_proof) {
        this.reward_id = reward_id;
        this.reward_name = reward_name;
        this.reward_level = reward_level;
        this.award_level = award_level;
        this.reward_rank = reward_rank;
        this.reward_time = reward_time;
        this.reward_proof = reward_proof;
    }

    public Reward() {
    }

    @Override
    public String toString() {
        return "奖励{" +
                "名称='" + reward_name + '\'' +
                ", 奖励等级='" + reward_level + '\'' +
                ", 获奖等级='" + award_level + '\'' +
                ", 排名='" + reward_rank + '\'' +
                ", 获奖时间='" + reward_time + '\'' +
                ", 佐证材料='" + reward_proof + '\'' +
                '}';
    }

	public int getReward_id() {
		return reward_id;
	}

	public void setReward_id(int reward_id) {
		this.reward_id = reward_id;
	}

	public String getReward_name() {
		return reward_name;
	}

	public void setReward_name(String reward_name) {
		this.reward_name = reward_name;
	}

	public String getReward_level() {
		return reward_level;
	}

	public void setReward_level(String reward_level) {
		this.reward_level = reward_level;
	}

	public String getAward_level() {
		return award_level;
	}

	public void setAward_level(String award_level) {
		this.award_level = award_level;
	}

	public String getReward_rank() {
		return reward_rank;
	}

	public void setReward_rank(String reward_rank) {
		this.reward_rank = reward_rank;
	}

	public Date getReward_time() {
		return reward_time;
	}

	public void setReward_time(Date reward_time) {
		this.reward_time = reward_time;
	}

	public String getReward_proof() {
		return reward_proof;
	}

	public void setReward_proof(String reward_proof) {
		this.reward_proof = reward_proof;
	}
}