package bean;
import java.sql.Date;

public class Student_Achievement {
	private int id;
	private String sid;
	private int achievement_id;
	private String teacher_result;
	private String manager_result;
	
    public Student_Achievement(String sid, int achievement_id, String teacher_result, String manager_result) {
        this.sid = sid;
        this.achievement_id = achievement_id;
        this.teacher_result = teacher_result;
        this.manager_result = manager_result;
    }

    public Student_Achievement() {
    }

    @Override
    public String toString() {
        return "Student_Achievement{" +
                "sid='" + sid + '\'' +
                ", achievement_id='" + achievement_id + '\'' +
                ", teacher_result='" + teacher_result + '\'' +
                ", manager_result='" + manager_result + '\'' +
                '}';
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAchievement_id() {
		return achievement_id;
	}
	public void setAchievement_id(int achievement_id) {
		this.achievement_id = achievement_id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid2) {
		this.sid = sid2;
	}
	public String getTeacher_result() {
		return teacher_result;
	}
	public void setTeacher_result(String teacher_result) {
		this.teacher_result = teacher_result;
	}
	public String getManager_result() {
		return manager_result;
	}
	public void setManager_result(String manager_result) {
		this.manager_result = manager_result;
	}
}
