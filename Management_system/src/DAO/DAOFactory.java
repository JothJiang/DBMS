package DAO;

public class DAOFactory {
    private static DAOFactory daoFactory;
    static {
        daoFactory = new DAOFactory();
    }
    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return daoFactory;
    }

    public ProjectDAO getProjectDAO(){
        return new ProjectDAOImpl();
    }

    public StudentDAO getstudentDAO(){
        return new StudentDAOImpl();
    }
    public TeacherDAO getteacherDAO(){
        return new TeacherDAOImpl();
    }
    public AdministratorDAO getAdministratorDAO(){
        return new AdministratorDAOImpl();
    }
    public ManagerDAO getManagerDAO(){
        return new ManagerDAOImpl();
    }
    public ActivityDAO getActivityDAO(){return new ActivityDaoImpl(); }
    public PatentDao getPatentDao(){ return new PatentDaoImpl(); }
    public PaperDao getPaperDao(){ return new PaperDaoImpl(); }
    public SoftwareHardwarePlatformDao getSoftwareHardwarePlatformDao(){ return new SoftwareHardwarePlatformDaoImpl(); }
    public TeachingBooksDao getTeachingBooksDao(){ return new TeachingBooksDaoImpl(); }
    public StandardDao getStandardDao(){ return new StandardDaoImpl(); }
    public ReportDao getReportDao(){ return new ReportDaoImpl(); }
    public RewardDao getRewardDao(){ return new RewardDaoImpl(); }
    public AchievementDao getAchievementDao(){ return new AchievementDaoImpl(); }
    public OtherDao getOtherDao() { return new OtherDaoImpl(); }
    public StudentAchievementDao getStudentAchievementDao() {
        // TODO 自动生成的方法存根
        return new StudentAchievementDaoImpl();
    }
    public static CourseDao getCourseDao(){ return new CourseDaoImpl(); }
    public static RequestDao getRequestDao(){ return new RequestDaoImpl(); }
    public static GCDao getGCDao(){ return new GCDaoImpl(); }
    public static DepartDao getDeaprtDao(){return new DepartDaoImpl(); }
}