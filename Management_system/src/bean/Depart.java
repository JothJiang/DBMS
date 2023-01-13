package bean;

public class Depart {
    private String dno;     //学科编号
    private String dname;   //学科名称
    private int dask;   //学科是否可以选课

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getDask() {
        return dask;
    }

    public void setDask(int dask) {
        this.dask = dask;
    }
}
