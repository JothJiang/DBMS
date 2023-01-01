package test.dao;
import test.entity.Other;
import test.impl.*;

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

    public PatentDao getPatentDao(){
        return new PatentDaoImpl();
    }
    
    public PaperDao getPaperDao(){
        return new PaperDaoImpl();
    }
    
    public SoftwareHardwarePlatformDao getSoftwareHardwarePlatformDao(){
        return new SoftwareHardwarePlatformDaoImpl();
    }
    
    public TeachingBooksDao getTeachingBooksDao(){
        return new TeachingBooksDaoImpl();
    }
    
    public StandardDao getStandardDao(){
        return new StandardDaoImpl();
    }
    
    public ReportDao getReportDao(){
        return new ReportDaoImpl();
    }
    
    public RewardDao getRewardDao(){
        return new RewardDaoImpl();
    }
    
    public AchievementDao getAchievementDao(){
        return new AchievementDaoImpl();
    }

	public OtherDao getOtherDao() {
		return new OtherDaoImpl();
	}

	public StudentAchievementDao getStudentAchievementDao() {
		// TODO 自动生成的方法存根
		return new StudentAchievementDaoImpl();
	}
}