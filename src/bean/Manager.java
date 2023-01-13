package bean;

public class Manager {
    private String mno;
    private String pwd;
    private String mdepart;
    public Manager(String mno, String pwd, String mdepart) {
        this.mno = mno;
        this.pwd = pwd;
        this.mdepart = mdepart;
    }

    public Manager() {
        super();
    }

    public String getmno() {
        return mno;
    }

    public void setmno(String mno) {
        this.mno = mno;
    }

    public String getpwd() {
        return pwd;
    }

    public void setpwd(String sname) {
        this.pwd = pwd;
    }

    public String getmdepart() { return mdepart; }

    public void setmdepart(String mdepart) {
        this.mdepart = mdepart;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mno='" + mno + '\'' +
                ", pwd='" + pwd + '\'' +
                ", mdepart='" + mdepart + '\'' +
                '}';
    }
}