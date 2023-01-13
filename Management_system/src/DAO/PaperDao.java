package DAO;
import bean.Paper;

public interface PaperDao {
    void addPaper(Paper paper);
    void upPaper(Paper paper);
    void deletePaper(int paper_id);
    int getPaperId();
    Paper getPaper(int paper_id);
}
