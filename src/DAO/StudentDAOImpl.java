package DAO;

import bean.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAOImpl extends DAOBase implements StudentDAO {
    /*private static final String PROJECT_INSERT_SQL = "insert into Project_identification(pnum,ptype,pname,ptime,pwork,pbudget) values(?,?,?,?,?,?) ";
    private static final String PROJECT_SELECT_SQL = "select * from Project_identification where pnum=?";
    private static final String PROJECT_SELECT_list_SQL = "select pid,pnum,ptype,pname,ptime,pwork,pbudget from Project_identification where ptype=?";
    private static final String PROJECT_SHOW_list_SQL = "select * from Project_identification";
    private static final String PROJECT_UPDATE_SQL = "update Project_identification set ptype= ? , pname=? , ptime=? , pwork=? , pbudget=? where pnum = ?";
    private static final String PROJECT_DELETE_SQL = "delete from Project_identification where pname = ?";*/

    private static final String PROJECT_SELECT_SQL = "select pwd from student where sno=?";

    @Override
    public int login_search(String sno, String pwd) {
        Connection con = null;
        Student student_ = new Student();
        int flag=0;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PROJECT_SELECT_SQL);
            psmt.setString(1, sno);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                /*student_.setsno(rs.getString("pid"));
                student_.setsname(rs.getString("sname"));
                student_.setsdepart(rs.getString("sdepart"));
                student_.setstype(rs.getString("stype"));*/
                if(rs.getString("pwd").equals(pwd)){
                    flag=1;
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
        if(flag==1){
            return 2;
        }
        else {
            return 1;
        }
    }
    /*@Override
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
            psmt.setString(6, project.getpnum());
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
    }*/

}