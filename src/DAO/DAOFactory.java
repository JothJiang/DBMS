package DAO;

public class DAOFactory {
    private static DAOFactory daoFactory;
    static {
        daoFactory = new DAOFactory();
    }
    private DAOFactory(){
    }
    public static DAOFactory getInstance(){ return daoFactory; }
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
}