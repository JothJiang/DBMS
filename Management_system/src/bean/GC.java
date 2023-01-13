package bean;

public class GC {
    private String sno;         //研究生学号
    private String cno;         //课程编号
    private String gstate;      //助教自述
    private String tevaluate;   //导师评价

    public GC() {}

    public GC(String sno, String cno, String gstate, String tevaluate) {
        this.sno = sno;
        this.cno = cno;
        this.gstate = gstate;
        this.tevaluate = tevaluate;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getGstate() {
        return gstate;
    }

    public void setGstate(String gstate) {
        this.gstate = gstate;
    }

    public String getTevaluate() {
        return tevaluate;
    }

    public void setTevaluate(String tevaluate) {
        this.tevaluate = tevaluate;
    }
}
