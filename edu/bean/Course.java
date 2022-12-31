package edu.bean;

public class Course {
    private String cno;     //课程编号
    private String cname;   //课程名称
    private String ctype;   //课程性质
    private String cstu;    //授课对象
    private String cteacher;  //授课教师
    private int ctime;      //学时
    private int cnum;       //选课人数
    private int stunum;      //课程学生人数

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getCstu() {
        return cstu;
    }

    public void setCstu(String cstu) {
        this.cstu = cstu;
    }

    public int getCtime() {
        return ctime;
    }

    public void setCtime(int ctime) {
        this.ctime = ctime;
    }

    public String getCteacher() {
        return cteacher;
    }

    public void setCteacher(String cteacher) {
        this.cteacher = cteacher;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public int getStunum() {
        return stunum;
    }

    public void setStunum(int stunum) {
        this.stunum = stunum;
    }
}
