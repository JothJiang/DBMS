package edu;

import edu.domain.Activity;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        while (true){
            System.out.println("----------------------");
            System.out.println("欢迎访问学术交流活动登报系统！");
            System.out.println("请选择你的身份：");
            System.out.println("1.研究生");
            System.out.println("2.导师");
            System.out.println("3.学科负责人");
            System.out.println("4.退出系统");
            System.out.println("请选择：(输入序号数字)");
            Scanner sc = new Scanner(System.in);
            int ch0 = 4;
            try {
                ch0 = sc.nextInt();
            }catch (Exception e) {
                System.out.println("请输入正确的数字序号！");
            }
            if (ch0 == 4) break;
            System.out.println("请输入您的账号（学号/工号）：1");
            String no = sc.next();
            System.out.println("请输入您的密码：");
            String pwd = sc.next();
            if(ch0 == 1){
                String name = DAOFactory.getInstance().getStudentDAO().checkSnoAndPwd(no, pwd);
                if(name != null){
                    System.out.println("\n\n"+name+"同学您好，您已成功登录系统");
                    while (true){
                        System.out.println("----------------------");
                        System.out.println("1.登报学术交流活动");
                        System.out.println("2.查看我的学术交流活动");
                        System.out.println("3.返回上一级");
                        System.out.println("请选择：(输入序号数字)");
                        int ch1 = 3;
                        try {
                            ch1 = sc.nextInt();
                        }catch (Exception e) {
                            System.out.println("请输入正确的数字序号！");
                        }
                        if(ch1 == 1){
                            Activity activity = new Activity();
                            activity.setGid(no); //自动填充该生的学号
                            activity.setState("待审核"); //刚登报的活动状态为未审核，等待导师审核
                            System.out.println("请输入活动名称：");
                            activity.setName(sc.next());
                            System.out.println("请输入活动地点（具体位置）：");
                            activity.setAddr(sc.next());
                            System.out.println("请输入活动时间：");
                            activity.setDate(sc.next());
                            System.out.println("请输入报告中英文名称：");
                            activity.setReport(sc.next());
                            System.out.println("请输入参会证明图片（存储地址）：");
                            activity.setPicture(sc.next());
                            System.out.println("请输入备注：");
                            activity.setNote(sc.next());
                            DAOFactory.getInstance().getActivityDAO().addActivity(activity);
                        }
                        else if (ch1 == 2) {
                            getActivity(no);
                            while (true){
                                System.out.println("-----------------------");
                                System.out.println("1.删除学术交流活动");
                                System.out.println("2.返回上一级");
                                int ch2 = sc.nextInt();
                                if (ch2 == 1) {
                                    System.out.println("请输入需要删除的活动的id：");
                                    Integer aid = sc.nextInt();
                                    int res = DAOFactory.getInstance().getActivityDAO().deleteActivity(aid);
                                    if(res > 0) System.out.println("删除成功！");
                                    else System.out.println("删除失败！没有该活动");
                                }else if (ch2 == 2){break;}
                                else {System.out.println("请输入正确的数字！");}
                            }
                        }
                        else if (ch1 == 3)break;
                        else {System.out.println("请输入正确的数字序号！");}
                    }
                }else System.out.println("账号或密码错误，登录失败！");
                
            }
            else if (ch0 == 2) {
                String name = DAOFactory.getInstance().getTeacherDao().checkTnoAndPwd(no, pwd);
                if(name != null){
                    System.out.println("\n\n"+name+"老师您好，您已成功登录系统");
                    while (true){
                        System.out.println("----------------------");
                        System.out.println("1.查看学生学术交流活动");
                        System.out.println("2.审核学生学术交流活动");
                        System.out.println("3.返回上一级");
                        System.out.println("请选择：(输入序号数字)");
                        int ch1 = 3;
                        try {
                            ch1 = sc.nextInt();
                        }catch (Exception e) {
                            System.out.println("请输入正确的数字序号！");
                        }
                        if(ch1 == 1){
                            System.out.println("请输入学生学号：");
                            String sno = sc.next();
                            getActivity(sno);
                        }
                        else if (ch1 == 2) {
                            System.out.println("请输入审核通过的活动id：");
                            String id = sc.next();
                            DAOFactory.getInstance().getActivityDAO().updateStateById(id, "导师审核通过");
                            System.out.println("操作成功！");
                        }
                        else if (ch1 == 3)break;
                        else System.out.println("请输入正确的数字序号！");
                    }
                }else System.out.println("账号或密码错误，登录失败！");
            }
            else if (ch0 == 3) {
                String depart = DAOFactory.getInstance().getManagerDao().checkMnoAndPwd(no, pwd);
                if (depart != null){
                    System.out.println("\n\n"+depart+"学科负责人您好，您已成功登录系统");
                    while (true){
                        System.out.println("----------------------");
                        System.out.println("1.查看已通过导师审核学术交流活动");
                        System.out.println("2.审核学生学术交流活动");
                        System.out.println("3.返回上一级");
                        System.out.println("请选择：(输入序号数字)");
                        int ch1 = 3;
                        try {
                            ch1 = sc.nextInt();
                        }catch (Exception e) {
                            System.out.println("请输入正确的数字序号！");
                        }
                        if(ch1 == 1){
                            List<Activity> activities = DAOFactory.getInstance().getActivityDAO().queryActivityByDepart(depart);
                            System.out.println("活动id | 活动地点 | 活动名称 | 活动时间 | 报告中英文名称 | 参会证明图片地址 | 备注 | 审核状态");
                            for(Activity activity:activities){
                                System.out.println(activity.getId()+" | "+
                                        activity.getName()+" | "+
                                        activity.getAddr()+" | "+
                                        activity.getDate()+" | "+
                                        activity.getReport()+" | "+
                                        activity.getPicture()+" | "+
                                        activity.getNote()+" | "+
                                        activity.getState()
                                );
                            }
                        }
                        else if (ch1 == 2) {
                            System.out.println("请输入审核通过的活动id：");
                            String id = sc.next();
                            DAOFactory.getInstance().getActivityDAO().updateStateById(id, "已通过");
                            System.out.println("操作成功！");
                        }
                        else if (ch1 == 3)break;
                        else System.out.println("请输入正确的数字序号！");
                    }
                }else System.out.println("账号或密码错误，登录失败！");
            }
            else System.out.println("请输入正确的数字序号！");
        }
    }

    private static void getActivity(String sno) {
        List<Activity> activities = DAOFactory.getInstance().getActivityDAO().queryActivityById(sno);
        System.out.println("活动id | 活动地点 | 活动名称 | 活动时间 | 报告中英文名称 | 参会证明图片地址 | 备注 | 审核状态");
        for(Activity activity:activities){
            System.out.println(activity.getId()+" | "+
                    activity.getName()+" | "+
                    activity.getAddr()+" | "+
                    activity.getDate()+" | "+
                    activity.getReport()+" | "+
                    activity.getPicture()+" | "+
                    activity.getNote()+" | "+
                    activity.getState()
            );
        }
    }
}
