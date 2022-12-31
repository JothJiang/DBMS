package edu.dao;

public class DAOFactory {
    private static final DAOFactory daoFactory;
    static {
        daoFactory = new DAOFactory();
    }
    private DAOFactory(){}
    public static CourseDao getCourseDao(){ return new CourseDaoImpl(); }
    public static RequestDao getRequestDao(){ return new RequestDaoImpl(); }
    public static GCDao getGCDao(){ return new GCDaoImpl(); }
    public static StudentDao getStudentDao(){ return new StudentDaoImpl(); }
    public static TeacherDao getTeacherDao(){return new TeacherDaoImpl(); }
    public static ManagerDao getManagerDao(){return new ManagerDaoImpl(); }
    public static DepartDao getDeaprtDao(){return new DepartDaoImpl(); }
}
