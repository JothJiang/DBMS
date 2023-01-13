package bean;

public class Student {
    private String sno;
    private String sname;
    private String sdepart;
    private String stype;
    private String pwd;
    public Student(String sno, String sname, String sdepart, String stype, String pwd) {
        this.sno = sno;
        this.sname = sname;
        this.sdepart = sdepart;
        this.stype = stype;
        this.pwd = pwd;
    }

    public Student() {
        super();
    }

    public String getsno() {
        return sno;
    }

    public void setsno(String sno) {
        this.sno = sno;
    }

    public String getsname() {
        return sname;
    }

    public void setsname(String sname) {
        this.sname = sname;
    }

    public String getsdepart() { return sdepart; }

    public void setsdepart(String sdepart) {
        this.sdepart = sdepart;
    }

    public String getstype() {
        return stype;
    }

    public void setstype(String stype) { this.stype = stype; }

    public String getpwd() {
        return pwd;
    }

    public void setpwd(String pwd) { this.pwd = pwd; }
    @Override
    public String toString() {
        return "student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sdepart='" + sdepart + '\'' +
                ", stype='" + stype + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}