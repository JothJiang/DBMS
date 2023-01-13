package DAO;

import bean.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl extends DAOBase implements ProjectDAO {
    private static final String PROJECT_INSERT_SQL = "insert into Project_identification(pnum,ptype,pname,ptime,pwork,pbudget,confirms,sno,tno) values(?,?,?,?,?,?,?,?,?) ";
    private static final String PROJECT_SELECT_SQL = "select * from Project_identification where pnum=?";
    private static final String PROJECT_SELECT_confirms_SQL = "select * from Project_identification where confirms=?";
    private static final String PROJECT_SELECT_teacher_SQL = "select * from Project_identification where tno=?";
    private static final String PROJECT_SELECT_student_SQL = "select * from Project_identification where sno=?";
    private static final String PROJECT_SELECT_list_SQL = "select * from Project_identification where ptype=?";
    private static final String PROJECT_SHOW_list_SQL = "select * from Project_identification";
    private static final String PROJECT_UPDATE_SQL = "update Project_identification set ptype= ? , pname=? , ptime=? , pwork=? , pbudget=? , sno=? , tno=? where pnum = ?";
    private static final String PROJECT_UPDATE_confirm_SQL = "update Project_identification set confirms=? where pid = ?";
    private static final String PROJECT_DELETE_SQL = "delete from Project_identification where pname = ?";

    @Override
    public void addProject(Project project) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PROJECT_INSERT_SQL);
            //psmt.setString(1, String.valueOf(project.getpid()));
            psmt.setString(1, project.getpnum());
            psmt.setString(2, project.getptype());
            psmt.setString(3, project.getpname());
            psmt.setString(4, project.getptime());
            psmt.setString(5, project.getpwork());
            psmt.setString(6, project.getpbudget());
            psmt.setString(7, project.getconfirms());
            psmt.setString(8, project.getsno());
            psmt.setString(9, project.gettno());
            psmt.executeUpdate();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public Project getProject(String pnum) {
        Connection con = null;
        Project project = new Project();
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PROJECT_SELECT_SQL);
            psmt.setString(1, pnum);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                project.setpid(Integer.parseInt(rs.getString("pid")));
                project.setpnum(rs.getString("pnum"));
                project.setptype(rs.getString("ptype"));
                project.setpname(rs.getString("pname"));
                project.setptime(rs.getString("ptime"));
                project.setpwork(rs.getString("pwork"));
                project.setpbudget(rs.getString("pbudget"));
                project.setconfirms(rs.getString("confirms"));
                project.setsno(rs.getString("sno"));
                project.settno(rs.getString("tno"));
            }
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return project;
    }

   @Override
    public void updateProject(Project project) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PROJECT_UPDATE_SQL);
            psmt.setString(1, project.getptype());
            psmt.setString(2, project.getpname());
            psmt.setString(3, project.getptime());
            psmt.setString(4, project.getpwork());
            psmt.setString(5, project.getpbudget());
            psmt.setString(6, project.getsno());
            psmt.setString(7, project.gettno());
            psmt.setString(8, project.getpnum());
            psmt.executeUpdate();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void update_confirm(int pid) {
        Connection con = null;
        try{
            String confirms="已确认";
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PROJECT_UPDATE_confirm_SQL);
            psmt.setString(1, confirms);
            psmt.setString(2, String.valueOf(pid));
            psmt.executeUpdate();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteProject(String pname) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PROJECT_DELETE_SQL);
            psmt.setString(1, pname);
            psmt.executeUpdate();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    @Override
    public List<Project> findProjects(String ptype) {
        Connection con = null;
        List<Project> projects= new ArrayList<Project>();
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PROJECT_SELECT_list_SQL);
            psmt.setString(1, ptype);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                Project project = new Project();
                project.setpid(Integer.parseInt(rs.getString("pid")));
                project.setpnum(rs.getString("pnum"));
                project.setptype(rs.getString("ptype"));
                project.setpname(rs.getString("pname"));
                project.setptime(rs.getString("ptime"));
                project.setpwork(rs.getString("pwork"));
                project.setpbudget(rs.getString("pbudget"));
                projects.add(project);
            }
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return projects;
    }

    @Override
    public List<Project> confirmProjects() {
        Connection con = null;
        List<Project> projects= new ArrayList<Project>();
        try{
            String confirms="未确认";
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PROJECT_SELECT_confirms_SQL);
            psmt.setString(1, confirms);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                if(rs.getString("pbudget")!=null){
                    Project project = new Project();
                    project.setpid(Integer.parseInt(rs.getString("pid")));
                    project.setpnum(rs.getString("pnum"));
                    project.setptype(rs.getString("ptype"));
                    project.setpname(rs.getString("pname"));
                    project.setptime(rs.getString("ptime"));
                    project.setpwork(rs.getString("pwork"));
                    project.setpbudget(rs.getString("pbudget"));
                    project.setconfirms(rs.getString("confirms"));
                    project.setsno(rs.getString("sno"));
                    project.settno(rs.getString("tno"));
                    projects.add(project);
                }
            }
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return projects;
    }
    public List<Project> teacher_Project(String tno) {
        Connection con = null;
        List<Project> projects= new ArrayList<Project>();
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PROJECT_SELECT_teacher_SQL);
            psmt.setString(1, tno);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                if(rs.getString("pbudget")!=null){
                    Project project = new Project();
                    project.setpid(Integer.parseInt(rs.getString("pid")));
                    project.setpnum(rs.getString("pnum"));
                    project.setptype(rs.getString("ptype"));
                    project.setpname(rs.getString("pname"));
                    project.setptime(rs.getString("ptime"));
                    project.setpwork(rs.getString("pwork"));
                    project.setpbudget(rs.getString("pbudget"));
                    project.setconfirms(rs.getString("confirms"));
                    project.setsno(rs.getString("sno"));
                    project.settno(rs.getString("tno"));
                    projects.add(project);
                }
            }
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return projects;
    }
    public List<Project> student_Project(String sno) {
        Connection con = null;
        List<Project> projects= new ArrayList<Project>();
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PROJECT_SELECT_student_SQL);
            psmt.setString(1, sno);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                if(rs.getString("pbudget")!=null){
                    Project project = new Project();
                    project.setpid(Integer.parseInt(rs.getString("pid")));
                    project.setpnum(rs.getString("pnum"));
                    project.setptype(rs.getString("ptype"));
                    project.setpname(rs.getString("pname"));
                    project.setptime(rs.getString("ptime"));
                    project.setpwork(rs.getString("pwork"));
                    project.setpbudget(rs.getString("pbudget"));
                    project.setconfirms(rs.getString("confirms"));
                    project.setsno(rs.getString("sno"));
                    project.settno(rs.getString("tno"));
                    projects.add(project);
                }
            }
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return projects;
    }

    @Override
    public List<Project> showProjects() {
        Connection con = null;
        //Project project = new Project();
        List<Project> projects= new ArrayList<Project>();
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PROJECT_SHOW_list_SQL);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                Project project = new Project();
                project.setpid(Integer.parseInt(rs.getString("pid")));
                project.setpnum(rs.getString("pnum"));
                project.setptype(rs.getString("ptype"));
                project.setpname(rs.getString("pname"));
                project.setptime(rs.getString("ptime"));
                project.setpwork(rs.getString("pwork"));
                project.setpbudget(rs.getString("pbudget"));
                project.setconfirms(rs.getString("confirms"));
                project.setsno(rs.getString("sno"));
                project.settno(rs.getString("tno"));
                projects.add(project);
            }
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return projects;
    }

}