package edu;

import edu.dao.ActivityDAO;
import edu.dao.ManagerDao;
import edu.dao.StudentDAO;
import edu.dao.TeacherDao;
import edu.dao.impl.ActivityDaoImpl;
import edu.dao.impl.ManagerDaoImpl;
import edu.dao.impl.StudentDAOImpl;
import edu.dao.impl.TeacherDaoImpl;

public class DAOFactory {
    private static final DAOFactory daoFactory;
    static {daoFactory = new DAOFactory();}
    private DAOFactory(){
    }

    public static DAOFactory getInstance(){
        return daoFactory;
    }

    public StudentDAO getStudentDAO(){
        return new StudentDAOImpl();
    }

    public TeacherDao getTeacherDao() {return new TeacherDaoImpl();
    }

    public ManagerDao getManagerDao() {return new ManagerDaoImpl();
    }
    public ActivityDAO getActivityDAO(){return new ActivityDaoImpl();
    }
}
