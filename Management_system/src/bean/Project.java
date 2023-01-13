package bean;

public class Project {
    private int pid;
    private String pnum;
    private String ptype;
    private String pname;
    private String ptime;
    private String pwork;
    private String pbudget;
    private String confirms;
    private String sno;
    private String tno;

    public Project(int pid, String pnum, String ptype, String pname, String ptime, String pwork,String pbudget, String confirms,String sno,String tno) {
        this.pid = pid;
        this.pnum = pnum;
        this.ptype = ptype;
        this.pname = pname;
        this.ptime = ptime;
        this.pwork = pwork;
        this.pbudget = pbudget;
        this.confirms = confirms;
        this.sno = sno;
        this.tno = tno;
    }

    public Project() {
        super();
    }

    public int getpid() {
        return pid;
    }

    public void setpid(int pid) {
        this.pid = pid;
    }

    public String getpnum() {
        return pnum;
    }

    public void setpnum(String pnum) {
        this.pnum = pnum;
    }

    public String getptype() {
        return ptype;
    }

    public void setptype(String ptype) {
        this.ptype = ptype;
    }

    public String getpname() {
        return pname;
    }

    public void setpname(String pname) { this.pname = pname; }

    public String getptime() {
        return ptime;
    }

    public void setptime(String ptime) {
        this.ptime = ptime;
    }

    public String getpwork() {
        return pwork;
    }

    public void setpwork(String pwork) {
        this.pwork = pwork;
    }

    public String getpbudget() {
        return pbudget;
    }

    public void setpbudget(String pbudget) {
        this.pbudget = pbudget;
    }

    public String getconfirms() {
        return confirms;
    }

    public void setconfirms(String confirms) {
        this.confirms = confirms;
    }

    public String getsno() {
        return sno;
    }

    public void setsno(String sno) {
        this.sno = sno;
    }

    public String gettno() {
        return tno;
    }

    public void settno(String tno) {
        this.tno = tno;
    }


    @Override
    public String toString() {
        return "Project{" +
                "pid='" + pid + '\'' +
                ", pnum='" + pnum + '\'' +
                ", ptype='" + ptype + '\'' +
                ", pname='" + pname + '\'' +
                ", ptime='" + ptime + '\'' +
                ", pwork='" + pwork + '\'' +
                ", pbudget='" + pbudget + '\'' +
                ", confirms='" + confirms + '\'' +
                ", sno='" + sno + '\'' +
                ", tno='" + tno + '\'' +
                '}';
    }
}