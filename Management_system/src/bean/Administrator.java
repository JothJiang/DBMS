package bean;

public class Administrator {
    private String tano;
    private String pwd;
    private String taname;
    public Administrator(String tano, String pwd, String taname) {
        this.tano = tano;
        this.pwd = pwd;
        this.taname = taname;
    }

    public Administrator() {
        super();
    }

    public String gettano() {
        return tano;
    }

    public void settano(String tano) {
        this.tano = tano;
    }

    public String getpwd() {
        return pwd;
    }

    public void setpwd(String sname) {
        this.pwd = pwd;
    }

    public String gettaname() { return taname; }

    public void settaname(String tname) {
        this.taname = taname;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "tano='" + tano + '\'' +
                ", pwd='" + pwd + '\'' +
                ", taname='" + taname + '\'' +
                '}';
    }
}