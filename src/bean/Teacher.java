package bean;

public class Teacher {
    private String tno;
    private String pwd;
    private String tname;
    public Teacher(String tno, String pwd, String tname) {
        this.tno = tno;
        this.pwd = pwd;
        this.tname = tname;
    }

    public Teacher() {
        super();
    }

    public String gettno() {
        return tno;
    }

    public void settno(String tno) {
        this.tno = tno;
    }

    public String getpwd() {
        return pwd;
    }

    public void setpwd(String sname) {
        this.pwd = pwd;
    }

    public String gettname() { return tname; }

    public void settname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "tno='" + tno + '\'' +
                ", pwd='" + pwd + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }
}