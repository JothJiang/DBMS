package Main;

import DAO.DAOFactory;
import bean.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import DAO.DAOFactory;
import bean.Achievement;
import bean.Other;
import bean.Paper;
import bean.Patent;
import bean.Report;
import bean.Reward;
import bean.SoftwareHardwarePlatform;
import bean.Standard;
import bean.Student_Achievement;
import bean.TeachingBooks;

public class Main {
    public static void main(String[] args) throws SQLException, ParseException {
        System.out.println("--------欢迎来到研究生培养环节和成果认定综合管理系统--------");
        while(true){
            System.out.println("请根据您需要的业务选择进入对应的子系统");
            System.out.println( "1.研究生助教子系统\n" +
                    "2.学术交流活动子系统\n" +
                    "3.项目参与子系统\n" +
                    "4.成果认定子系统");
            Scanner input=new Scanner(System.in);
            int select=input.nextInt();
            if(select==1){
                System.out.println( "1.教师登陆\n" +
                        "2.学生登陆\n" +
                        "3.学科管理员登录\n" +
                        "4.退出系统\n" +
                        "请选择登陆身份序号:");
                Scanner sc00 = new Scanner(System.in);
                int xx = sc00.nextInt();
                while(true) {
                    if (xx == 1) {      //教师登陆
                        System.out.println(
                                "-----------------------------------教师登陆-----------------------------------\n" +
                                        "请输入教师号:");
                        Scanner sc0 = new Scanner(System.in);
                        String tno = sc0.next();
                        System.out.println("请输入密码:");
                        sc0 = new Scanner(System.in);
                        String pwd = sc0.next();
                        String p1 = DAOFactory.getInstance().getteacherDAO().getPwdByTno(tno);
                        if (pwd.equals(p1)) {
                            System.out.println(
                                    "-----------------------------------欢迎使用助教子系统-----------------------------------\n" +
                                            "1.批阅研究生选课\n" +
                                            "2.教师评价\n" +
                                            "3.课程录入\n" +
                                            "4.退出系统\n" +
                                            "请输入您要选择的功能序号:"
                            );
                            Scanner sc1 = new Scanner(System.in);
                            int no1 = sc1.nextInt();
                            while (true) {
                                if (no1 == 1) {
                                    List<Request> requestList = DAOFactory.getRequestDao().getRequestsByTno(tno);
                                    System.out.println("--------------选课请求列表----------------");
                                    System.out.println("序号\t\t学号\t\t课程号");
                                    for (int i = 0; i < requestList.size(); i++) {
                                        System.out.println(i + 1 + "\t\t" + requestList.get(i).getSno() + "\t\t" + requestList.get(i).getCno());
                                    }
                                    System.out.println("请填写您要选择的学生请求序号:");
                                    Scanner sc = new Scanner(System.in);
                                    int no = sc.nextInt();
                                    if (no < 1 || no > requestList.size()) {
                                        System.out.println("警告！选择错误");
                                        break;
                                    }
                                    if (DAOFactory.getGCDao().courseOccupied(requestList.get(no - 1).getCno())) {
                                        System.out.println("该课程已有助教老师");
                                        break;
                                    }
                                    GC gc = new GC(requestList.get(no - 1).getSno(), requestList.get(no - 1).getCno(), null, null);
                                    DAOFactory.getGCDao().insertGC(gc);
                                    DAOFactory.getRequestDao().setAgreeBySnoCno(requestList.get(no - 1).getSno(), requestList.get(no - 1).getCno());
                                    System.out.println("操作完成!");
                                } else if (no1 == 2) {
                                    List<GC> gcList = DAOFactory.getGCDao().getGCsByTno(tno);
                                    System.out.println("序号\t\t学号\t\t课程名称\t\t研究生评价\t\t教师评价");
                                    for (int i = 0; i < gcList.size(); i++) {
                                        String cname = DAOFactory.getCourseDao().getcnames(gcList.get(i).getCno());
                                        System.out.println(i + 1 + "\t\t" + gcList.get(i).getSno() + "\t\t" + cname + "\t\t" + gcList.get(i).getGstate() + "\t\t" + gcList.get(i).getTevaluate());
                                    }
                                    System.out.println("请选择您想要的功能:\n" +
                                            "1.填写课程评价\n" +
                                            "2.回到主界面");
                                    Scanner sc3 = new Scanner(System.in);
                                    int x3 = sc3.nextInt();
                                    if (x3 == 1) {
                                        System.out.println("请选择评价序号:");
                                        sc3 = new Scanner(System.in);
                                        x3 = sc3.nextInt();
                                        if (x3 > gcList.size()) {
                                            System.out.println("错误代码选择\n");
                                        } else {
                                            String sno = gcList.get(x3 - 1).getSno();
                                            String cno = gcList.get(x3 - 1).getCno();
                                            System.out.println("请输入评价:");
                                            sc3 = new Scanner(System.in);
                                            String pj = sc3.next();
                                            DAOFactory.getGCDao().insertpj1(sno, cno, pj);
                                            System.out.println("评价成功！");
                                        }

                                    }
                                    else if(x3!=2){
                                        System.out.println("错误代码选择\n");
                                    }
                                }
                                else if (no1 == 3) {
                                    Scanner sc3 = new Scanner(System.in);
                                    System.out.println("请输入课程名:");
                                    String cname = sc3.next();
                                    System.out.println("请选择课程性质");
                                    System.out.println("1.必修");
                                    System.out.println("2.选修");
                                    int type_choice = sc3.nextInt();
                                    if (type_choice < 1 || type_choice > 2) {
                                        System.out.println("错误代码选择\n");
                                        break;
                                    }
                                    System.out.println("请选择课程对象");
                                    System.out.println("1.本科生");
                                    System.out.println("2.研究生");
                                    int stu_choice = sc3.nextInt();
                                    if (stu_choice < 1 || stu_choice > 2) {
                                        System.out.println("错误代码选择\n");
                                        break;
                                    }
                                    System.out.println("请输入课程学时数:");
                                    int ctime = sc3.nextInt();
                                    System.out.println("请输入课程学生人数:");
                                    int stunum = sc3.nextInt();
                                    String ctype = (type_choice == 1) ? "必修" : "选修";
                                    String cstu = (stu_choice == 1) ? "本科生" : "研究生";
                                    int course_num = DAOFactory.getCourseDao().getNum() + 1;
                                    String cno = "";
                                    if (course_num < 10) cno = "C00" + course_num + "";
                                    else if (course_num < 100) cno = "C0" + course_num + "";
                                    else cno = "C" + course_num + "";
                                    Course course = new Course();
                                    course.setCno(cno);
                                    course.setCname(cname);
                                    course.setCtype(ctype);
                                    course.setCstu(cstu);
                                    course.setCteacher(tno);
                                    course.setCtime(ctime);
                                    course.setCnum(0);
                                    course.setStunum(stunum);
                                    DAOFactory.getCourseDao().addCourse(course);
                                    System.out.println("成功新增一门课程!");
                                    try {
                                        Thread.sleep(1000);
                                    }catch (InterruptedException ex)
                                    {
                                        System.out.println("出现异常");
                                    }
                                }
                                else if (no1 == 4) {
                                    System.out.println("教师账号退出成功！");
                                    break;
                                } else {
                                    System.out.println("错误代码选择\n");
                                }
                                System.out.println(
                                        "-----------------------------------欢迎使用助教子系统-----------------------------------\n" +
                                                "1.批阅研究生选课\n" +
                                                "2.教师评价\n" +
                                                "3.课程录入\n" +
                                                "4.退出系统\n" +
                                                "请输入您要选择的功能序号:"
                                );
                                no1 = sc1.nextInt();
                            }
                        } else {
                            System.out.println("密码错误");
                        }
                    }
                    else if (xx == 2) {     //助教登陆
                        System.out.println(
                                "-----------------------------------学生登陆-----------------------------------\n" +
                                        "请输入学号:");
                        Scanner sc0 = new Scanner(System.in);
                        String sno = sc0.next();
                        System.out.println("请输入密码:");
                        sc0 = new Scanner(System.in);
                        String pwd = sc0.next();
                        String p1 = DAOFactory.getInstance().getstudentDAO().getPwdBySno(sno);
                        if (pwd.equals(p1)) {
                            System.out.println(
                                    "-----------------------------------欢迎使用助教子系统-----------------------------------\n" +
                                            "1.研究生选课\n" +
                                            "2.查看已选课程申请\n" +
                                            "3.查看助教课程评价\n" +
                                            "4.退出系统\n" +
                                            "请输入您要选择的功能序号:"
                            );
                            Scanner sc1 = new Scanner(System.in);
                            int no1 = sc1.nextInt();
                            while (true) {
                                if (no1 == 1) {
                                    if(DAOFactory.getDeaprtDao().getask(DAOFactory.getInstance().getstudentDAO().getDepartBySno(sno))==1){
                                        System.out.println("所在学科选课未开启！");
                                    }
                                    else if (DAOFactory.getGCDao().getGCNumBySno(sno) >= 2) {
                                        System.out.println("您最多成为两门课程的助教老师!");
                                    }
                                    else{
                                        List<Course> courseList = DAOFactory.getCourseDao().getCourses();
                                        System.out.println("-----------------------------------选课列表-----------------------------------");
                                        System.out.println("序号\t\t课程编号\t\t课程名称\t\t课程性质\t\t课程对象\t\t授课教师\t\t学时\t\t课程学生人数\t\t选课人数\t\t助教情况");
                                        for (int i = 0; i < courseList.size(); i++) {
                                            if(DAOFactory.getRequestDao().getagree(courseList.get(i).getCno())==1){
                                                System.out.println(i + 1 + "\t\t" + courseList.get(i).getCno() + "\t\t" + courseList.get(i).getCname()
                                                        + "\t\t" + courseList.get(i).getCtype() + "\t\t" + courseList.get(i).getCstu()
                                                        + "\t\t" + courseList.get(i).getCteacher() + "\t\t" + courseList.get(i).getCtime()
                                                        + "\t\t" + courseList.get(i).getStunum() + "\t\t" + courseList.get(i).getCnum()+"\t\t"+"已有助教");
                                                continue;
                                            }
                                            System.out.println(i + 1 + "\t\t" + courseList.get(i).getCno() + "\t\t" + courseList.get(i).getCname()
                                                    + "\t\t" + courseList.get(i).getCtype() + "\t\t" + courseList.get(i).getCstu()
                                                    + "\t\t" + courseList.get(i).getCteacher() + "\t\t" + courseList.get(i).getCtime()
                                                    + "\t\t" + courseList.get(i).getStunum() + "\t\t" + courseList.get(i).getCnum()+"\t\t"+"暂无助教");
                                        }
                                        System.out.println("温馨提示：已有助教的课程选择后一定不会中，请谨慎选择");
                                        System.out.println("请填写您要选择的课程序号:");
                                        Scanner sc = new Scanner(System.in);
                                        int no = sc.nextInt();
                                        if (no < 1 || no > courseList.size()) {
                                            System.out.println("警告！选择错误");
                                        }
                                        if (DAOFactory.getRequestDao().requestExisted(sno, courseList.get(no - 1).getCno())) {
                                            System.out.println("此课程已选择");
                                        } else if (DAOFactory.getRequestDao().getRequestNumBySno(sno) >= 2) {  //助教课程数量小于2时，志愿数量最大不能超过2
                                            System.out.println("志愿数量已达上限!");
                                        } else {
                                            Request request = new Request(sno, courseList.get(no - 1).getCno(), "0");
                                            DAOFactory.getRequestDao().insertRequest(request);
                                            System.out.println("选课成功!");
                                        }
                                    }
                                }
                                else if (no1 == 2) {
                                    List<Request> agreeList = DAOFactory.getRequestDao().getAgrees(sno);
                                    System.out.println("序号\t\t课程名称\t\t选课结果");
                                    for (int i = 0; i < agreeList.size(); i++) {
                                        String jg;
                                        if (agreeList.get(i).getAgree().equals("0"))
                                            jg = "暂未中";
                                        else jg = "已中";
                                        String cname = DAOFactory.getCourseDao().getcnames(agreeList.get(i).getCno());
                                        System.out.println(i + 1 + "\t\t" + cname + "\t\t" + jg);
                                    }
                                    System.out.println("请选择您想要的功能:\n" +
                                            "1.退选\n" +
                                            "2.回到主界面");
                                    Scanner sc3 = new Scanner(System.in);
                                    int x3 = sc3.nextInt();
                                    if (x3 == 1) {
                                        System.out.println("请选择退选序号:");
                                        sc3 = new Scanner(System.in);
                                        x3 = sc3.nextInt();
                                        if (x3 > agreeList.size()) {
                                            System.out.println("警告！选择错误");
                                        } else if (agreeList.get(x3 - 1).getAgree().equals("1")) {
                                            System.out.println("警告！该课程已中选，不可退选");
                                        } else {
                                            String cno = agreeList.get(x3 - 1).getCno();
                                            DAOFactory.getRequestDao().deleteRequest(sno, cno);
                                            System.out.println("退选成功！");
                                        }
                                    }
                                    else if(x3!=2){
                                        System.out.println("错误代码选择\n");
                                    }
                                }
                                else if (no1 == 3) {
                                    List<GC> gcList = DAOFactory.getGCDao().getGCs(sno);
                                    System.out.println("序号\t\t课程编号\t\t研究生评价\t\t教师评价");
                                    for (int i = 0; i < gcList.size(); i++) {
                                        String cname = DAOFactory.getCourseDao().getcnames(gcList.get(i).getCno());
                                        System.out.println(i + 1 + "\t\t" + cname + "\t\t" + gcList.get(i).getGstate() + "\t\t" + gcList.get(i).getTevaluate());
                                    }
                                    System.out.println("请选择您想要的功能:\n" +
                                            "1.填写课程评价\n" +
                                            "2.回到主界面");
                                    Scanner sc3 = new Scanner(System.in);
                                    int x3 = sc3.nextInt();
                                    if (x3 == 1) {
                                        System.out.println("请选择评价序号:");
                                        sc3 = new Scanner(System.in);
                                        x3 = sc3.nextInt();
                                        if (x3 > gcList.size()) {
                                            System.out.println("警告！选择错误");
                                        } else {
                                            String cno = gcList.get(x3 - 1).getCno();
                                            System.out.println("请输入评价:");
                                            sc3 = new Scanner(System.in);
                                            String pj = sc3.next();
                                            DAOFactory.getGCDao().insertpj(sno, cno, pj);
                                            System.out.println("评价成功！");
                                        }

                                    }
                                    else if(x3!=2){
                                        System.out.println("错误代码选择\n");
                                    }
                                }
                                else if (no1 == 4) {
                                    System.out.println("学生账号退出成功！");
                                    break;
                                }
                                else {
                                    System.out.println("错误代码选择\n");
                                }
                                System.out.println(
                                        "-----------------------------------欢迎使用助教子系统-----------------------------------\n" +
                                                "1.研究生选课\n" +
                                                "2.查看已选课程申请\n" +
                                                "3.查看助教课程评价\n" +
                                                "4.退出系统\n" +
                                                "请输入您要选择的功能序号:"
                                );
                                sc1 = new Scanner(System.in);
                                no1 = sc1.nextInt();
                            }

                        }
                        else {
                            System.out.println("密码错误！");
                        }

                    }
                    else if (xx == 3) {
                        System.out.println(
                                "-----------------------------------学科管理员登陆-----------------------------------\n" +
                                        "请输入工号:");
                        Scanner sc0 = new Scanner(System.in);
                        String mno = sc0.next();
                        System.out.println("请输入密码:");
                        sc0 = new Scanner(System.in);
                        String pwd = sc0.next();
                        String p1 = DAOFactory.getInstance().getManagerDAO().getPwdByMno(mno);
                        if (pwd.equals(p1)) {
                            System.out.println(
                                    "-----------------------------------欢迎使用助教子系统-----------------------------------" );
                            System.out.println("1.查看导师信息");
                            System.out.println("2.查看研究生信息");
                            System.out.println("3.管理学科选课");
                            System.out.println("4.退出系统");
                            System.out.println("请输入您要选择的功能序号:");
                            Scanner sc1 = new Scanner(System.in);
                            int choice = sc1.nextInt();
                            while (true) {
                                if (choice == 1) {
                                    List<Teacher> teacherList = DAOFactory.getInstance().getteacherDAO().getTeachers();
                                    System.out.println("序号\t\t教师号\t\t教师姓名\t\t教授的课程");
                                    int j=0;
                                    for (int i = 0; i < teacherList.size(); i++) {
                                        if(!DAOFactory.getInstance().getteacherDAO().getDepartByTno(teacherList.get(i).gettno()).equals(DAOFactory.getInstance().getManagerDAO().getDepartByMno(mno))){
                                            continue;
                                        }
                                        j++;
                                        String courses = DAOFactory.getCourseDao().getCoursesByTno(teacherList.get(i).gettno());
                                        System.out.println(j + "\t\t" + teacherList.get(i).gettno() + "\t\t" + teacherList.get(i).gettname() + "\t\t" + courses);
                                    }
                                    try {
                                        Thread.sleep(1000);
                                    }catch (InterruptedException ex)
                                    {
                                        System.out.println("出现异常");
                                    }
                                }
                                else if (choice == 2) {
                                    List<Student> studentList = DAOFactory.getInstance().getstudentDAO().getStudents();
                                    System.out.println("序号\t\t学号\t\t学生姓名\t\t学生类别\t\t助教课程");
                                    int j=1;
                                    for (int i = 0; i < studentList.size(); i++) {
                                        if(!studentList.get(i).getsdepart().equals(DAOFactory.getInstance().getManagerDAO().getDepartByMno(mno))){
                                            continue;
                                        }
                                        String courses = DAOFactory.getGCDao().getCoursesBySno(studentList.get(i).getsno());
                                        if (courses == null || courses.equals("")) courses = "无";
                                        System.out.println(j+ "\t\t" + studentList.get(i).getsno() + "\t\t" + studentList.get(i).getsname()
                                                + "\t\t"  + studentList.get(i).getstype() + "\t\t" + courses);
                                        j++;
                                    }
                                    try {
                                        Thread.sleep(1000);
                                    }catch (InterruptedException ex)
                                    {
                                        System.out.println("出现异常");
                                    }

                                }
                                else if(choice == 3){
                                    String aws="已开启";
                                    if(DAOFactory.getDeaprtDao().getask(DAOFactory.getInstance().getManagerDAO().getDepartByMno(mno))==1)
                                        aws="已关闭";
                                    System.out.println("学科编号\t\t学科名称\t\t助教选课系统");
                                    System.out.println(DAOFactory.getInstance().getManagerDAO().getDepartByMno(mno)+"\t\t"+
                                            DAOFactory.getDeaprtDao().getdnames(DAOFactory.getInstance().getManagerDAO().getDepartByMno(mno))+"\t\t"+aws);
                                    System.out.println("1.开启系统\n" +
                                            "2.关闭系统\n" +
                                            "3.回到主页面\n");
                                    System.out.println("请输入您要选择的功能序号:");
                                    Scanner sc12 = new Scanner(System.in);
                                    int x12 = sc12.nextInt();
                                    if(x12==1){
                                        DAOFactory.getDeaprtDao().updatesak(0,DAOFactory.getInstance().getManagerDAO().getDepartByMno(mno));
                                        System.out.println("助教选课系统已开启！");
                                    }
                                    else if(x12==2){
                                        DAOFactory.getDeaprtDao().updatesak(1,DAOFactory.getInstance().getManagerDAO().getDepartByMno(mno));
                                        System.out.println("助教选课系统已关闭！");
                                    }
                                    else if(x12==3){}
                                    else{
                                        System.out.println("错误代码选择\n");
                                    }
                                }
                                else if (choice == 4) {
                                    System.out.println("学科管理员账号退出成功！");
                                    break;
                                }
                                else{
                                    System.out.println("错误代码选择\n");
                                }
                                System.out.println(
                                        "-----------------------------------欢迎使用助教子系统-----------------------------------" );
                                System.out.println("1.查看导师信息");
                                System.out.println("2.查看研究生信息");
                                System.out.println("3.管理学科选课");
                                System.out.println("4.退出系统");
                                System.out.println("请输入您要选择的功能序号:");
                                choice = sc1.nextInt();
                            }

                        } else {
                            System.out.println("密码错误！");
                        }
                    }
                    else if(xx==4){
                        break;
                    }
                    else {
                        System.out.println("警告！错误选择\n");
                    }
                    System.out.println( "1.教师登陆\n" +
                            "2.学生登陆\n" +
                            "3.学科管理员登录\n" +
                            "4.退出系统\n" +
                            "请选择登陆身份序号:");
                    sc00 = new Scanner(System.in);
                    xx = sc00.nextInt();
                }
            }
            else if(select==2){
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
                        String name = DAOFactory.getInstance().getstudentDAO().checkSnoAndPwd(no, pwd);
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
                        String name = DAOFactory.getInstance().getteacherDAO().checkTnoAndPwd(no, pwd);
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
                        String depart = DAOFactory.getInstance().getManagerDAO().checkMnoAndPwd(no, pwd);
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
            else if(select==3) {
                System.out.println("--------欢迎来到项目认定子系统--------");
                System.out.println("--------登录--------");
                System.out.println("请选择您的身份");
                System.out.println("1.研究生培养管理员 2.学科负责人 3.导师 4.研究生 5.退出该系统");
                int identity_int = input.nextInt();
                while (true) {
                    if (identity_int == 1) {//1.研究生培养管理员
                        System.out.println("请输入您的研究生培养管理员编号：");
                        String tano = input.next();
                        System.out.println("请输入密码：");
                        String pwd = input.next();
                        if (DAOFactory.getInstance().getAdministratorDAO().login_search(tano, pwd) == 2) {
                            System.out.println("登录成功\n");
                            while (true) {
                                System.out.println("请选择您需要的业务：");
                                System.out.println("1.导入项目 2.查看所有项目 3.检索项目 4.修改项目信息 5.后退");
                                int administer_business = input.nextInt();
                                if (administer_business == 1) {//导入项目情况
                                    System.out.print("请输入项目编号：");
                                    String pnum = input.next();
                                    System.out.print("请输入项目类型：");
                                    String ptype = input.next();
                                    System.out.print("请输入项目名称：");
                                    String pname = input.next();
                                    System.out.print("请输入参与项目时间：");
                                    String ptime = input.next();
                                    System.out.print("请输入项目中承担的工作：");
                                    String pwork = input.next();
                                    System.out.print("请输入项目参与的学生学号：");
                                    String sno = input.next();
                                    System.out.print("请输入项目指导教师的编号：");
                                    String tno = input.next();
                                    String confirms = "未确认";
                                    Project project = new Project();
                                    project.setpnum(pnum);
                                    project.setptype(ptype);
                                    project.setpname(pname);
                                    project.setptime(ptime);
                                    project.setpwork(pwork);
                                    project.setconfirms(confirms);
                                    project.setsno(sno);
                                    project.settno(tno);
                                    Add(project);
                                } else if (administer_business == 2) {//查看所有项目
                                    List<Project> show_projects = DAOFactory.getInstance().getProjectDAO().showProjects();
                                    System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                                    for (int i = 0; i < show_projects.size(); i++) {
                                        System.out.println(show_projects.get(i).getpid() + "\t" + show_projects.get(i).getpnum()
                                                + "\t\t" + show_projects.get(i).getptype() + "\t\t" + show_projects.get(i).getpname()
                                                + "\t\t" + show_projects.get(i).getptime() + "\t\t" + show_projects.get(i).getpwork()
                                                + "\t\t" + show_projects.get(i).getpbudget() + "\t\t\t" + show_projects.get(i).getconfirms()
                                                + "\t\t\t\t" + show_projects.get(i).getsno() + "\t\t\t\t" + show_projects.get(i).gettno());
                                    }
                                    System.out.println("共" + show_projects.size() + "个项目\n");
                                } else if (administer_business == 3) {//检索项目
                                    System.out.print("请输入需要查询的项目编号：");
                                    String pnum = input.next();
                                    Project project1 = Get(pnum);
                                    System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                                    System.out.println("  " + project1.getpid() + "\t" + project1.getpnum()
                                            + "\t\t" + project1.getptype() + "\t\t" + project1.getpname()
                                            + "\t\t" + project1.getptime() + "\t\t" + project1.getpwork()
                                            + "\t\t" + project1.getpbudget() + "\t\t\t" + project1.getconfirms()
                                            + "\t\t\t\t" + project1.getsno() + "\t\t\t\t" + project1.gettno());
                                } else if (administer_business == 4) {//修改项目信息
                                    System.out.print("请输入需要修改的项目编号：");
                                    String pnum = input.next();
                                    Project project1 = DAOFactory.getInstance().getProjectDAO().getProject(pnum);
                                    while (true) {
                                        System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                                        System.out.println("  " + project1.getpid() + "\t" + project1.getpnum()
                                                + "\t\t" + project1.getptype() + "\t\t" + project1.getpname()
                                                + "\t\t" + project1.getptime() + "\t\t" + project1.getpwork()
                                                + "\t\t" + project1.getpbudget() + "\t\t\t" + project1.getconfirms()
                                                + "\t\t\t\t" + project1.getsno() + "\t\t\t\t" + project1.gettno());
                                        System.out.print("您需要修改？");
                                        System.out.println("1.项目编号  2.项目类型  3.项目名称  4.参与项目时间  5.承担工作  6.承担工作的折合经费  7.参与项目的学生学号 8.指导教师编号 9.结束修改");
                                        int up = input.nextInt();
                                        if (up == 1) {
                                            System.out.print("请输入修改后的项目编号：");
                                            pnum = input.next();
                                            project1.setpnum(pnum);
                                        } else if (up == 2) {
                                            System.out.print("请输入修改后的项目类型：");
                                            String ptype = input.next();
                                            project1.setptype(ptype);
                                        } else if (up == 3) {
                                            System.out.print("请输入修改后的项目名称：");
                                            String pname = input.next();
                                            project1.setpname(pname);
                                        } else if (up == 4) {
                                            System.out.print("请输入修改后的参与项目时间：");
                                            String ptime = input.next();
                                            project1.setptime(ptime);
                                        } else if (up == 5) {
                                            System.out.print("请输入修改后的您在项目中承担的工作：");
                                            String pwork = input.next();
                                            project1.setpwork(pwork);
                                        } else if (up == 6) {
                                            System.out.print("请输入修改后的承担工作的折合经费：");
                                            String pbudget = input.next();
                                            project1.setpbudget(pbudget);
                                        } else if (up == 7) {
                                            System.out.print("请输入修改后的参与项目的学生学号：");
                                            String sno = input.next();
                                            project1.setsno(sno);
                                        } else if (up == 8) {
                                            System.out.print("请输入修改后的指导教师编号：");
                                            String tno = input.next();
                                            project1.settno(tno);
                                        } else if (up == 9) {
                                            break;
                                        } else {
                                            System.out.print("输入错误，请重新输入");
                                        }
                                        if (up > 0 && up < 7) {
                                            Update(project1);
                                        }
                                    }
                                } else if (administer_business == 5) {//后退
                                    break;
                                } else {
                                    System.out.println("输入错误，请重新输入");
                                }
                            }
                            break;
                        } else {
                            System.out.println("编号或密码输入错误，请重新输入");
                        }
                    } else if (identity_int == 2) {//2.学科负责人
                        while (true) {
                            System.out.println("请输入您的学科负责人编号：");
                            String mno = input.next();
                            System.out.println("请输入密码：");
                            String pwd = input.next();
                            if (DAOFactory.getInstance().getManagerDAO().login_search(mno, pwd) == 2) {
                                System.out.println("登录成功\n");
                                while (true) {
                                    System.out.println("请选择您需要的业务：");
                                    System.out.println("1.查看所有项目 2.确认导师已填报经费的项目 3.检索项目 4.修改参与项目的经费要求 5.后退");
                                    int manager_business = input.nextInt();
                                    if (manager_business == 1) {//查看所有项目
                                        List<Project> show_projects = DAOFactory.getInstance().getProjectDAO().showProjects();
                                        System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                                        for (int i = 0; i < show_projects.size(); i++) {
                                            System.out.println(show_projects.get(i).getpid() + "\t" + show_projects.get(i).getpnum()
                                                    + "\t\t" + show_projects.get(i).getptype() + "\t\t" + show_projects.get(i).getpname()
                                                    + "\t\t" + show_projects.get(i).getptime() + "\t\t" + show_projects.get(i).getpwork()
                                                    + "\t\t" + show_projects.get(i).getpbudget() + "\t\t\t" + show_projects.get(i).getconfirms()
                                                    + "\t\t\t\t" + show_projects.get(i).getsno() + "\t\t\t\t" + show_projects.get(i).gettno());
                                        }
                                        System.out.println("共" + show_projects.size() + "个项目\n");
                                    } else if (manager_business == 2) {//确认导师已填报的项目经费
                                        List<Project> confirm_projects = DAOFactory.getInstance().getProjectDAO().confirmProjects();
                                        System.out.println("指导教师已确认的项目如下：");
                                        System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                                        for (int i = 0; i < confirm_projects.size(); i++) {
                                            System.out.println(confirm_projects.get(i).getpid() + "\t" + confirm_projects.get(i).getpnum()
                                                    + "\t\t" + confirm_projects.get(i).getptype() + "\t\t" + confirm_projects.get(i).getpname()
                                                    + "\t\t" + confirm_projects.get(i).getptime() + "\t\t" + confirm_projects.get(i).getpwork()
                                                    + "\t\t" + confirm_projects.get(i).getpbudget() + "\t\t\t" + confirm_projects.get(i).getconfirms()
                                                    + "\t\t\t\t" + confirm_projects.get(i).getsno() + "\t\t\t\t" + confirm_projects.get(i).gettno());
                                        }
                                        System.out.println("请输入您想确认的项目的序号：");
                                        int confirm_num = input.nextInt();
                                        DAOFactory.getInstance().getProjectDAO().update_confirm(confirm_num);
                                        System.out.println("操作成功！");

                                    } else if (manager_business == 3) {//检索项目
                                        System.out.print("请输入需要查询的项目编号：");
                                        String pnum = input.next();
                                        Project project1 = Get(pnum);
                                        System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                                        System.out.println("  " + project1.getpid() + "\t" + project1.getpnum()
                                                + "\t\t" + project1.getptype() + "\t\t" + project1.getpname()
                                                + "\t\t" + project1.getptime() + "\t\t" + project1.getpwork()
                                                + "\t\t" + project1.getpbudget() + "\t\t\t" + project1.getconfirms()
                                                + "\t\t\t\t" + project1.getsno() + "\t\t\t\t" + project1.gettno());

                                    } else if (manager_business == 4) {//修改参与项目的经费要求
                                        List<Project> confirm_projects = DAOFactory.getInstance().getProjectDAO().confirmProjects();
                                        System.out.println("指导教师已确认的项目如下：");
                                        System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                                        for (int i = 0; i < confirm_projects.size(); i++) {
                                            System.out.println(confirm_projects.get(i).getpid() + "\t" + confirm_projects.get(i).getpnum()
                                                    + "\t\t" + confirm_projects.get(i).getptype() + "\t\t" + confirm_projects.get(i).getpname()
                                                    + "\t\t" + confirm_projects.get(i).getptime() + "\t\t" + confirm_projects.get(i).getpwork()
                                                    + "\t\t" + confirm_projects.get(i).getpbudget() + "\t\t\t" + confirm_projects.get(i).getconfirms()
                                                    + "\t\t\t\t" + confirm_projects.get(i).getsno() + "\t\t\t\t" + confirm_projects.get(i).gettno());
                                        }
                                        System.out.print("请输入需要修改的项目编号：");
                                        String pnum = input.next();
                                        Project project1 = DAOFactory.getInstance().getProjectDAO().getProject(pnum);
                                        System.out.print("请输入修改后的经费：");
                                        String pbudget = input.next();
                                        project1.setpbudget(pbudget);
                                        Update(project1);
                                    } else if (manager_business == 4) {//后退
                                        break;
                                    } else {
                                        System.out.println("输入错误，请重新输入");
                                    }
                                }
                                break;
                            } else {
                                System.out.println("编号或密码输入错误，请重新输入");
                            }
                        }
                    } else if (identity_int == 3) {//3.导师
                        while (true) {
                            System.out.println("请输入您的导师编号：");
                            String tno = input.next();
                            System.out.println("请输入密码：");
                            String pwd = input.next();
                            if (DAOFactory.getInstance().getteacherDAO().login_search(tno, pwd) == 2) {
                                System.out.println("登录成功\n");
                                while (true) {
                                    System.out.println("请选择您需要的业务：");
                                    System.out.println("1.查看您指导的项目 2.填报项目经费 3.后退");
                                    int teacher_business = input.nextInt();
                                    if (teacher_business == 1) {//查看您指导的项目
                                        List<Project> teacher_projects = DAOFactory.getInstance().getProjectDAO().teacher_Project(tno);
                                        System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                                        for (int i = 0; i < teacher_projects.size(); i++) {
                                            System.out.println(teacher_projects.get(i).getpid() + "\t" + teacher_projects.get(i).getpnum()
                                                    + "\t\t" + teacher_projects.get(i).getptype() + "\t\t" + teacher_projects.get(i).getpname()
                                                    + "\t\t" + teacher_projects.get(i).getptime() + "\t\t" + teacher_projects.get(i).getpwork()
                                                    + "\t\t" + teacher_projects.get(i).getpbudget() + "\t\t\t" + teacher_projects.get(i).getconfirms()
                                                    + "\t\t\t\t" + teacher_projects.get(i).getsno() + "\t\t\t" + teacher_projects.get(i).gettno());
                                        }
                                    } else if (teacher_business == 2) {//填报项目经费
                                        List<Project> teacher_projects = DAOFactory.getInstance().getProjectDAO().teacher_Project(tno);
                                        System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                                        for (int i = 0; i < teacher_projects.size(); i++) {
                                            System.out.println(teacher_projects.get(i).getpid() + "\t" + teacher_projects.get(i).getpnum()
                                                    + "\t\t" + teacher_projects.get(i).getptype() + "\t\t" + teacher_projects.get(i).getpname()
                                                    + "\t\t" + teacher_projects.get(i).getptime() + "\t\t" + teacher_projects.get(i).getpwork()
                                                    + "\t\t" + teacher_projects.get(i).getpbudget() + "\t\t\t" + teacher_projects.get(i).getconfirms()
                                                    + "\t\t\t\t" + teacher_projects.get(i).getsno() + "\t\t\t" + teacher_projects.get(i).gettno());
                                        }
                                        System.out.println("请输入您需要填报经费的项目编号：");
                                        String pnum = input.next();
                                        Project project1 = DAOFactory.getInstance().getProjectDAO().getProject(pnum);
                                        System.out.print("请输入项目经费：");
                                        String pbudget = input.next();
                                        project1.setpbudget(pbudget);
                                        Update(project1);
                                    } else if (teacher_business == 3) {//后退
                                        break;
                                    } else {
                                        System.out.println("输入错误，请重新输入");
                                    }
                                }
                                break;
                            } else {
                                System.out.println("导师编号或密码输入错误，请重试");
                            }
                        }

                    } else if (identity_int == 4) {//4.研究生
                        System.out.println("请输入学号：");
                        String sno = input.next();
                        System.out.println("请输入密码：");
                        String pwd = input.next();
                        if (DAOFactory.getInstance().getstudentDAO().login_search(sno, pwd) == 2) {
                            System.out.println("登录成功\n");
                            System.out.println("您参与的项目如下");
                            List<Project> teacher_projects = DAOFactory.getInstance().getProjectDAO().student_Project(sno);
                            System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                            for (int i = 0; i < teacher_projects.size(); i++) {
                                System.out.println(teacher_projects.get(i).getpid() + "\t" + teacher_projects.get(i).getpnum()
                                        + "\t\t" + teacher_projects.get(i).getptype() + "\t\t" + teacher_projects.get(i).getpname()
                                        + "\t\t" + teacher_projects.get(i).getptime() + "\t\t" + teacher_projects.get(i).getpwork()
                                        + "\t\t" + teacher_projects.get(i).getpbudget() + "\t\t\t" + teacher_projects.get(i).getconfirms()
                                        + "\t\t\t\t" + teacher_projects.get(i).getsno() + "\t\t\t" + teacher_projects.get(i).gettno());
                            }
                            System.out.println("如有疑问，请联系导师或项目负责人");
                            System.out.println("如需退出，请输入“1”");
                            while (true) {
                                int student_operate = input.nextInt();
                                if (student_operate == 1) {
                                    break;
                                } else {
                                    System.out.println("输入错误，请重试");
                                }
                            }
                            break;
                        } else {
                            System.out.println("研究生学号或密码输入错误，请重试");
                        }
                    }
                    else if (identity_int == 5){
                        break;
                    } else {//填写错误
                        System.out.println("输入错误，请重新输入");
                    }
                }
                System.out.println("退出成功,感谢您的使用");

            }
            else if(select==4){
                while (true) {
                    System.out.println("请选择您的身份：a.研究生 b.导师 c.管理人员 d.退出");
                    Scanner scanner1 = new Scanner(System.in);
                    String input1 = scanner1.nextLine();

                    if (input1.equals("a")) {// a.研究生 b.导师 c.管理人员 d.退出
                        System.out.println("-----------------------------------学生登陆-----------------------------------");
                        System.out.println("请输入您的学号：");
                        Scanner sno = new Scanner(System.in);
                        String sid = sno.nextLine();
                        System.out.println("请输入密码:");
                        Scanner sc0 = new Scanner(System.in);
                        String pwd = sc0.next();

                        String p1 = DAOFactory.getInstance().getstudentDAO().getPwdBySno(sid);
                        if (pwd.equals(p1)) {
                            String stype = DAOFactory.getInstance().getstudentDAO().checkIdentity(sid);
                            String sname = DAOFactory.getInstance().getstudentDAO().checkSnoAndPwd(sid,p1);
                            if (stype.equals("硕士研究生")) {// a.硕士 b.博士
                                System.out.println(sname + "同学您好！您是：硕士研究生");
                                System.out.println("请选择以下操作：a.申请成果认证 b.查看目前成果认证进度");
                                Scanner scanner5 = new Scanner(System.in);
                                String input5 = scanner5.nextLine();
                                if (input5.equals("a")) {// a.申请成功认证 b.查看目前成果认证进度
                                    while (true) {
                                        System.out.println("请选择您要提交的成果类型：a.论文 b.教材 c.标准 d.专利 e.报告 f.软硬件平台开发证明 g.退出");
                                        Scanner scanner3 = new Scanner(System.in);
                                        String input3 = scanner3.nextLine();
                                        if (input3.equals("a")) {// a.论文 b.教材 c.标准 d.专利 e.报告 f.软硬件平台开发证明
                                            inputPaper(sid);

                                        } else if (input3.equals("b")) {// a.论文 b.教材 c.标准 d.专利 e.报告 f.软硬件平台开发证明
                                            inputTeachingBooks(sid);

                                        } else if (input3.equals("c")) {// a.论文 b.教材 c.标准 d.专利 e.报告 f.软硬件平台开发证明
                                            inputStandard(sid);

                                        } else if (input3.equals("d")) {// a.论文 b.教材 c.标准 d.专利 e.报告 f.软硬件平台开发证明
                                            inputPatent(sid);

                                        } else if (input3.equals("e")) {// a.论文 b.教材 c.标准 d.专利 e.报告 f.软硬件平台开发证明
                                            inputReport(sid);

                                        } else if (input3.equals("f")) {// a.论文 b.教材 c.标准 d.专利 e.报告 f.软硬件平台开发证明
                                            inputPlatform(sid);

                                        } else if (input3.equals("g")) {// a.论文 b.教材 c.标准 d.专利 e.报告 f.软硬件平台开发证明
                                            break;
                                        }
                                    }
                                } else if (input5.equals("b")) {// a.申请成果认证 b.查看目前成果认证进度
                                    System.out.println(sname + "您好！目前您已申请的成果认证有：");
                                    ClassifyAchievement(sid);
                                }
                            } else if (stype.equals("博士研究生")) {// a.硕士 b.博士
                                System.out.println(sname + "同学您好！您是：博士研究生");
                                System.out.println("请选择以下操作：a.申请成果认证 b.查看目前成果认证进度");
                                Scanner scanner5 = new Scanner(System.in);
                                String input5 = scanner5.nextLine();
                                if (input5.equals("a")) {// a.申请成功认证 b.查看目前成果认证进度
                                    while (true) {
                                        System.out.println("请选择您要提交的成果类型：a.论文 b.奖励 c.标准 d.其他成果 e.退出");
                                        Scanner scanner4 = new Scanner(System.in);
                                        String input4 = scanner4.nextLine();
                                        if (input4.equals("a")) {// a.论文 b.奖励 c.标准 d.其他成果
                                            inputPaper(sid);
                                        } else if (input4.equals("b")) {// a.论文 b.奖励 c.标准 d.其他成果
                                            inputReward(sid);

                                        } else if (input4.equals("c")) {// a.论文 b.奖励 c.标准 d.其他成果
                                            inputStandard(sid);

                                        } else if (input4.equals("d")) {// a.论文 b.奖励 c.标准 d.其他成果
                                            inputOther(sid);

                                        } else if (input4.equals("e")) {
                                            break;
                                        }
                                    }
                                } else if (input5.equals("b")) {// a.申请成果认证 b.查看目前成果认证进度
                                    System.out.println(sname + "同学您好！目前您已申请的成果认证有：");
                                    ClassifyAchievement(sid);
                                }
                            }
                        }
                        else {
                            System.out.println("账号或密码错误，登录失败！请按回车键重新选择！");
                            input1 = scanner1.nextLine();
                        }

                    } else if (input1.equals("b")) {// a.研究生 b.导师 c.管理人员 d.退出

                        System.out.println("-----------------------------------导师登陆-----------------------------------");
                        Scanner scanner2 = new Scanner(System.in);// a.是 b.否 c.停止审核

                        System.out.println("请输入您的工号：");
                        Scanner gno = new Scanner(System.in);
                        String gid = gno.nextLine();

                        System.out.println("请输入密码:");
                        Scanner sc0 = new Scanner(System.in);
                        String pwd = sc0.next();
                        String p1 = DAOFactory.getInstance().getteacherDAO().getPwdByTno(gid);

                        if (pwd.equals(p1)) {
                            // 这一块展示该导师管理的学生提交的未审批的成果
                            int flag = 0;
                            String tname = DAOFactory.getInstance().getteacherDAO().checkTnoAndPwd(gid,p1);//此时的教师名
                            System.out.println(tname+"老师您好！您的学生的待审核成果如下：");
                            List<Student_Achievement> list = DAOFactory.getInstance().getStudentAchievementDao()
                                    .getAllStudentAchievement();
                            for (Student_Achievement stu_ach : list) {
                                String mentor = DAOFactory.getInstance().getstudentDAO().findMentor(stu_ach.getSid());//该成果记录对应的学生的导师名
                                if(mentor.equals(tname)) {
                                    if (stu_ach.getTeacher_result().equals("待审核")) {
                                        flag=1;
                                        Achievement achievement = DAOFactory.getInstance().getAchievementDao()
                                                .getAchievement(stu_ach.getAchievement_id());
                                        showAchievement(achievement.getType(), achievement.getDetail_id());
                                        System.out.println("是否通过：a.是 b.否 c.停止审核");
                                        String input2 = scanner2.nextLine();
                                        if (input2.equals("a")) {// a.是 b.否 c.停止审核
                                            stu_ach.setTeacher_result("通过");
                                            DAOFactory.getInstance().getStudentAchievementDao().upStudentAchievement(stu_ach);
                                            System.out.println("已通过！");
                                        } else if (input2.equals("b")) {
                                            stu_ach.setTeacher_result("不通过");
                                            DAOFactory.getInstance().getStudentAchievementDao().upStudentAchievement(stu_ach);
                                            System.out.println("已拒绝！");
                                        } else if (input2.equals("c")) {
                                            break;
                                        }
                                    }
                                }
                            }
                            if(flag==0) {
                                System.out.println("无");
                            }
                            System.out.println("审核完成！");
                        }
                        else {
                            System.out.println("账号或密码错误，登录失败！请按回车键重新选择！");
                            input1 = scanner1.nextLine();
                        }

                    } else if (input1.equals("c")) {// a.研究生 b.导师 c.管理人员 d.退出

                        System.out.println("----------------------------------管理员登陆----------------------------------");
                        Scanner scanner2 = new Scanner(System.in);// a.是 b.否 c.停止审核

                        System.out.println("请输入您的工号：");
                        Scanner gno = new Scanner(System.in);
                        String gid = gno.nextLine();

                        System.out.println("请输入密码:");
                        Scanner sc0 = new Scanner(System.in);
                        String pwd = sc0.next();
                        String p1 = DAOFactory.getInstance().getManagerDAO().getPwdByMno(gid);

                        if (pwd.equals(p1)) {
                            // 这一块展示导师通过的，但管理员未审批的成果,需要和管理员同一个系
                            int flag = 0;
                            String depName = DAOFactory.getInstance().getManagerDAO().getDepartByMno(gid);//管理员所在的系
                            System.out.println(gid+"您好！您管理的系的学生的待审核成果如下：");
                            List<Student_Achievement> list = DAOFactory.getInstance().getStudentAchievementDao()
                                    .getAllStudentAchievement();
                            for (Student_Achievement stu_ach : list) {
                                String stuDepName = DAOFactory.getInstance().getstudentDAO().getDepartBySno(stu_ach.getSid());//成果对应的学生所在的系
                                if(stuDepName.equals(depName)) {
                                    if (stu_ach.getManager_result().equals("待审核") && stu_ach.getTeacher_result().equals("通过")) {
                                        flag=1;
                                        Achievement achievement = DAOFactory.getInstance().getAchievementDao()
                                                .getAchievement(stu_ach.getAchievement_id());
                                        showAchievement(achievement.getType(), achievement.getDetail_id());
                                        System.out.println("是否通过：a.是 b.否 c.停止审核");
                                        String input2 = scanner2.nextLine();
                                        if (input2.equals("a")) {// a.是 b.否 c.停止审核
                                            stu_ach.setManager_result("通过");
                                            DAOFactory.getInstance().getStudentAchievementDao().upStudentAchievement(stu_ach);
                                            System.out.println("已通过！");
                                        } else if (input2.equals("b")) {
                                            stu_ach.setManager_result("不通过");
                                            DAOFactory.getInstance().getStudentAchievementDao().upStudentAchievement(stu_ach);
                                            System.out.println("已拒绝！");
                                        } else if (input2.equals("c")) {
                                            break;
                                        }
                                    }
                                }
                            }
                            if(flag==0) {
                                System.out.println("无");
                            }
                            System.out.println("审核完成！");
                        }
                        else {
                            System.out.println("账号或密码错误，登录失败！请按回车键重新选择！");
                            input1 = scanner1.nextLine();
                        }

                    } else if (input1.equals("d")) {// a.研究生 b.导师 c.管理人员 d.退出
                        System.out.println("已退出！");
                        break;
                    }
                }
            }
            else{
                System.out.println("输入错误，请重新输入");
            }
        }
    }
    private static void Add(Project project) {
        DAOFactory.getInstance().getProjectDAO().addProject(project);
        System.out.println("增加成功");
        System.out.println();
    }

    private static void Update(Project project) {
        DAOFactory.getInstance().getProjectDAO().updateProject(project);
        System.out.println("修改成功");
    }


    private static Project Get(String pnum) {
        Project project1 = DAOFactory.getInstance().getProjectDAO().getProject(pnum);
        return project1;
    }

    private static void Find(String ptype) {
        List<Project> find_projects = DAOFactory.getInstance().getProjectDAO().findProjects(ptype);
        //System.out.println(projects);
        for (int i = 0; i < find_projects.size(); i++) {
            System.out.println(i + 1 + "\t\t" + find_projects.get(i).getpid() + "\t\t" + find_projects.get(i).getpnum()
                    + "\t\t" + find_projects.get(i).getptype() + "\t\t" + find_projects.get(i).getpname()
                    + "\t\t" + find_projects.get(i).getptime() + "\t\t" + find_projects.get(i).getpwork()
                    + "\t\t" + find_projects.get(i).getpbudget());
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
    public static java.sql.Date inputDate() throws ParseException {// string类型转为sql.date类型
        Scanner input = new Scanner(System.in);
        String time = input.nextLine();
        String rexp = "^([1-9]\\d{3}-)(([0]{0,1}[1-9]-)|([1][0-2]-))(([0-3]{0,1}[0-9]))$";
        while (time.equals("") || !Pattern.matches(rexp, time)) {
            System.out.println("输入为空或不符合要求，请重新输入：");
            time = input.nextLine();
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // 使用给定模式yyyy-MM-dd
        java.util.Date udate = format.parse(time); // 从字符串中解析文本以产生一个java.util.Date
        java.sql.Date sdate = new java.sql.Date(udate.getTime()); // getTime()获取时间戳，再用构造方法构造
        return sdate;
    }

    public static String inputNotNull() {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        while (str.equals("")) {
            System.out.println("输入为空，请重新输入：");
            str = input.nextLine();
        }
        return str;
    }

    public static int inputIsInt() {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        Pattern pattern = Pattern.compile("[0-9]*");
        while (str.equals("") || !pattern.matcher(str).matches()) {
            System.out.println("输入为空或不为整数，请重新输入：");
            str = input.nextLine();
        }
        return Integer.valueOf(str);
    }

    public static void inputPaper(String sid) throws ParseException {// 论文输入
        Scanner paper_input = new Scanner(System.in);
        Paper paper = new Paper();

        System.out.println("请输入论文名称：");
        String paper_name = inputNotNull();
        paper.setPaper_name(paper_name);

        System.out.println("请输入论文发表刊物名称：");
        String journal_name = inputNotNull();
        paper.setJournal_name(journal_name);

        System.out.println("请输入论文状态（录用未发表、已发表）：");
        String paper_status = paper_input.nextLine();
        while (!(paper_status.equals("录用未发表") || paper_status.equals("已发表"))) {
            System.out.println("输入为空或不符合要求，请重新输入：");
            paper_status = paper_input.nextLine();
        }
        paper.setPaper_status(paper_status);

        System.out.println("请输入论文发表时间（yyyy-MM-dd）：");
        java.sql.Date paper_time = inputDate();
        paper.setPaper_time(paper_time);

        System.out.println("请输入索引类型：");
        String index_type = inputNotNull();
        paper.setIndex_type(index_type);

        System.out.println("请输入论文归属库情况（学院高质量论文库或学院核心论文库）：");
        String paper_library = paper_input.nextLine();
        while ((!(paper_library.equals("学院高质量论文库"))) && (!(paper_library.equals("学院核心论文库")))) {
            System.out.println("输入为空或不符合要求，请重新输入：");
            paper_library = paper_input.nextLine();
        }
        paper.setPaper_library(paper_library);

        System.out.println("请输入论文扫描或PDF材料：");
        String paper_proof = inputNotNull();
        paper.setPaper_proof(paper_proof);

        int id = DAOFactory.getInstance().getPaperDao().getPaperId() + 1;
        String type = "Paper";
        paper.setPaper_id(id);

        DAOFactory.getInstance().getPaperDao().addPaper(paper);// 加入paper

        System.out.println("您输入的论文材料为：");
        System.out.println(paper);
        bindAchievement(id, type, sid);
    }

    public static void inputTeachingBooks(String sid) throws ParseException {// 教材输入
        Scanner report_input = new Scanner(System.in);
        TeachingBooks tb = new TeachingBooks();

        System.out.println("请输入教材名称：");
        String tb_name = inputNotNull();
        tb.setTb_name(tb_name);

        System.out.println("请输入教材教材出版社：");
        String tb_publisher = inputNotNull();
        tb.setTb_publisher(tb_publisher);

        System.out.println("请输入教材出版时间（yyyy-MM-dd）：");
        java.sql.Date tb_time = inputDate();
        tb.setTb_publicationtime(tb_time);

        System.out.println("请输入教材贡献度排名（整数）：");
        int tb_contribution = inputIsInt();
        tb.setTb_contribution(tb_contribution);

        System.out.println("请输入佐证材料：");
        String tb_proof = inputNotNull();
        tb.setTb_proof(tb_proof);

        int id = DAOFactory.getInstance().getTeachingBooksDao().getTeachingBooksId() + 1;
        String type = "TeachingBooks";
        tb.setTb_id(id);

        DAOFactory.getInstance().getTeachingBooksDao().addTeachingBooks(tb);// 加入TeachingBooks

        System.out.println("您输入的教材材料为：");
        System.out.println(tb);
        bindAchievement(id, type, sid);
    }

    public static void inputReward(String sid) throws ParseException {// 奖励输入
        Scanner reward_input = new Scanner(System.in);
        Reward reward = new Reward();

        System.out.println("请输入奖励名称：");
        String reward_name = inputNotNull();
        reward.setReward_name(reward_name);

        System.out.println("请输入奖励等级（国家级、省部级、市级、其他）：");
        String reward_level = reward_input.nextLine();
        while ((!(reward_level.equals("国家级"))) && (!(reward_level.equals("省部级"))) && (!(reward_level.equals("市级")))
                && (!(reward_level.equals("其他")))) {
            System.out.println("输入为空或不符合要求，请重新输入：");
            reward_level = reward_input.nextLine();
        }
        reward.setReward_level(reward_level);

        System.out.println("请输入获奖等级（特等奖、一等奖、二等奖、三等奖）：");
        String award_level = reward_input.nextLine();
        while ((!(award_level.equals("特等奖"))) && (!(award_level.equals("一等奖"))) && (!(award_level.equals("二等奖")))
                && (!(award_level.equals("三等奖")))) {
            System.out.println("输入为空或不符合要求，请重新输入：");
            award_level = reward_input.nextLine();
        }
        reward.setAward_level(award_level);

        System.out.println("请输入排名：");
        String reward_rank = inputNotNull();
        reward.setReward_rank(reward_rank);

        System.out.println("请输入获奖时间（yyyy-MM-dd）：");
        java.sql.Date reward_time = inputDate();
        reward.setReward_time(reward_time);

        System.out.println("请输入佐证材料：");
        String reward_proof = inputNotNull();
        reward.setReward_proof(reward_proof);

        int id = DAOFactory.getInstance().getRewardDao().getRewardId() + 1;
        String type = "Reward";
        reward.setReward_id(id);

        DAOFactory.getInstance().getRewardDao().addReward(reward);// 加入Reward

        System.out.println("您输入的奖励材料为：");
        System.out.println(reward);
        bindAchievement(id, type, sid);
    }

    public static void inputPatent(String sid) throws ParseException {// 专利输入
        Scanner patent_input = new Scanner(System.in);
        Patent patent = new Patent();

        System.out.println("请输入专利名称：");
        String patent_name = inputNotNull();
        patent.setPatent_name(patent_name);

        System.out.println("请输入专利类型（发明专利、实用新型专利）：");
        String patent_type = patent_input.nextLine();
        while (!(patent_type.equals("发明专利") || patent_type.equals("实用新型专利"))) {
            System.out.println("输入为空或不符合要求，请重新输入：");
            patent_type = patent_input.nextLine();
        }
        patent.setPatent_type(patent_type);

        System.out.println("请输入专利号：");
        String patent_number = inputNotNull();
        patent.setPatent_number(patent_number);

        System.out.println("请输入专利发布时间（yyyy-MM-dd）：");
        java.sql.Date patent_time = inputDate();
        patent.setPatent_deliverytime(patent_time);

        System.out.println("请输入专利状态：");
        String patent_status = inputNotNull();
        patent.setPatent_status(patent_status);

        System.out.println("请输入专利贡献度排名（整数）：");
        int patent_contribution = inputIsInt();
        patent.setPatent_contribution(patent_contribution);

        System.out.println("请输入佐证材料：");
        String patent_proof = inputNotNull();
        patent.setPatent_proof(patent_proof);

        int id = DAOFactory.getInstance().getPatentDao().getPatentId() + 1;
        String type = "Patent";
        patent.setPatent_id(id);

        DAOFactory.getInstance().getPatentDao().addPatent(patent);// 加入Patent

        System.out.println("您输入的专利材料为：");
        System.out.println(patent);
        bindAchievement(id, type, sid);
    }

    public static void inputReport(String sid) throws ParseException {// 报告输入
        Scanner report_input = new Scanner(System.in);
        Report report = new Report();

        System.out.println("请输入报告名称：");
        String report_name = inputNotNull();
        report.setReport_name(report_name);

        System.out.println("请输入报告类型（规划类、设计类、服务类、其他）：");
        String report_type = report_input.nextLine();
        while (!(report_type.equals("规划类") || report_type.equals("设计类") || report_type.equals("服务类")
                || report_type.equals("其他"))) {
            System.out.println("输入为空或不符合要求，请重新输入：");
            report_type = report_input.nextLine();
        }
        report.setReport_type(report_type);

        System.out.println("请输入报告时间（yyyy-MM-dd）：");
        java.sql.Date report_time = inputDate();
        report.setReport_time(report_time);

        System.out.println("请输入报告服务单位：");
        String report_company = inputNotNull();
        report.setReport_company(report_company);

        System.out.println("请输入报告贡献度排名（整数）：");
        int report_contribution = inputIsInt();
        report.setReport_contribution(report_contribution);

        System.out.println("请输入佐证材料：");
        String report_proof = inputNotNull();
        report.setReport_proof(report_proof);

        int id = DAOFactory.getInstance().getReportDao().getReportId() + 1;
        String type = "Report";
        report.setReport_id(id);

        DAOFactory.getInstance().getReportDao().addReport(report);// 加入Report

        System.out.println("您输入的报告材料为：");
        System.out.println(report);
        bindAchievement(id, type, sid);
    }

    public static void inputPlatform(String sid) throws ParseException {// 软硬件平台开发证明输入
        Scanner platform_input = new Scanner(System.in);
        SoftwareHardwarePlatform platform = new SoftwareHardwarePlatform();

        System.out.println("请输入平台名称：");
        String platform_name = inputNotNull();
        platform.setSoftware_name(platform_name);

        System.out.println("请输入平台上线时间（yyyy-MM-dd）：");
        java.sql.Date platform_time = inputDate();
        platform.setSoftware_time(platform_time);

        System.out.println("请输入平台服务单位：");
        String platform_company = inputNotNull();
        platform.setSoftware_company(platform_company);

        System.out.println("请输入平台贡献度排名（整数）：");
        int platform_contribution = inputIsInt();
        platform.setSoftware_contribution(platform_contribution);

        System.out.println("请输入佐证材料：");
        String platform_proof = inputNotNull();
        platform.setSoftware_proof(platform_proof);

        int id = DAOFactory.getInstance().getSoftwareHardwarePlatformDao().getSoftwareHardwarePlatformId() + 1;
        String type = "SoftwareHardwarePlatform";
        platform.setSoftware_id(id);

        DAOFactory.getInstance().getSoftwareHardwarePlatformDao().addSoftwareHardwarePlatform(platform);// 加入SoftwareHardwarePlatform

        System.out.println("您输入的软硬件平台开发证明材料为：");
        System.out.println(platform);
        bindAchievement(id, type, sid);
    }

    public static void inputStandard(String sid) throws ParseException {// 标准输入
        Scanner standard_input = new Scanner(System.in);
        Standard standard = new Standard();

        System.out.println("请输入标准名称：");
        String standard_name = inputNotNull();
        standard.setStandard_name(standard_name);

        System.out.println("请输入标准级别（国家标准、省部级地方标准、行业标准、团队标准）：");
        String standard_level = standard_input.nextLine();
        while ((!(standard_level.equals("国家标准"))) && (!(standard_level.equals("省部级地方标准")))
                && (!(standard_level.equals("行业标准"))) && (!(standard_level.equals("团队标准")))) {
            System.out.println("输入为空或不符合要求，请重新输入：");
            standard_level = standard_input.nextLine();
        }
        standard.setStandard_level(standard_level);

        System.out.println("请输入标准发布发表时间（yyyy-MM-dd）：");
        java.sql.Date standard_time = inputDate();
        standard.setStandard_time(standard_time);

        System.out.println("请输入佐证材料：");
        String standard_proof = inputNotNull();
        standard.setStandard_proof(standard_proof);

        int id = DAOFactory.getInstance().getStandardDao().getStandardId() + 1;
        String type = "Standard";
        standard.setStandard_id(id);

        DAOFactory.getInstance().getStandardDao().addStandard(standard);// 加入Standard

        System.out.println("您输入的标准材料为：");
        System.out.println(standard);
        bindAchievement(id, type, sid);
    }

    public static void inputOther(String sid) throws ParseException {// 其他成果输入
        Other other = new Other();

        System.out.println("请输入其他成果名称：");
        String other_name = inputNotNull();
        other.setOther_name(other_name);

        System.out.println("请输入其他成果类型：");
        String other_type = inputNotNull();
        other.setOther_type(other_type);

        System.out.println("请输入其他成果发布发表时间（yyyy-MM-dd）：");
        java.sql.Date other_time = inputDate();
        other.setOther_time(other_time);

        System.out.println("请输入佐证材料：");
        String other_proof = inputNotNull();
        other.setOther_proof(other_proof);

        int id = DAOFactory.getInstance().getOtherDao().getOtherId() + 1;
        String type = "Other";
        other.setOther_id(id);

        DAOFactory.getInstance().getOtherDao().addOther(other);// 加入Other

        System.out.println("您输入的其他成果材料为：");
        System.out.println(other);
        bindAchievement(id, type, sid);
    }

    public static void bindAchievement(int id, String type, String sid) {
        // 以下为将成果记录的类型和id提交到成果汇总表中
        Achievement achievement = new Achievement();
        achievement.setDetail_id(id);
        achievement.setType(type);
        id = DAOFactory.getInstance().getAchievementDao().getAchievementId() + 1;
        achievement.setId(id);
        DAOFactory.getInstance().getAchievementDao().addAchievement(achievement);// 加入Achievement
        // 以下为将成果记录id与学生id绑定后提交到学生成果表中
        Student_Achievement stu_achievement = new Student_Achievement();
        stu_achievement.setAchievement_id(id);
        stu_achievement.setSid(sid);
        DAOFactory.getInstance().getStudentAchievementDao().addStudentAchievement(stu_achievement);// 加入Student_Achievement
        System.out.println("提交成功！");
    }

    public static void showAchievement(String type, int id) {
        if (type.equals("Paper")) {
            Paper paper = DAOFactory.getInstance().getPaperDao().getPaper(id);
            System.out.println(paper);
        } else if (type.equals("Patent")) {
            Patent patent = DAOFactory.getInstance().getPatentDao().getPatent(id);
            System.out.println(patent);
        } else if (type.equals("Report")) {
            Report report = DAOFactory.getInstance().getReportDao().getReport(id);
            System.out.println(report);
        } else if (type.equals("Reward")) {
            Reward reward = DAOFactory.getInstance().getRewardDao().getReward(id);
            System.out.println(reward);
        } else if (type.equals("SoftwareHardwarePlatform")) {
            SoftwareHardwarePlatform platform = DAOFactory.getInstance().getSoftwareHardwarePlatformDao()
                    .getSoftwareHardwarePlatform(id);
            System.out.println(platform);
        } else if (type.equals("Standard")) {
            Standard standard = DAOFactory.getInstance().getStandardDao().getStandard(id);
            System.out.println(standard);
        } else if (type.equals("Other")) {
            Other other = DAOFactory.getInstance().getOtherDao().getOther(id);
            System.out.println(other);
        } else if (type.equals("TeachingBooks")) {
            TeachingBooks tb = DAOFactory.getInstance().getTeachingBooksDao().getTeachingBooks(id);
            System.out.println(tb);
        }
    }
    public static void ClassifyAchievement(String sid) {
        // 先找student_achievement表中的学生学号的所有记录，得到achievement表中的id,再到achievement表中找到id对应的类型和具体id，
        //再去具体类型表中根据id输出目前的成果详情，以及成果认证进度
        List<Student_Achievement> list = DAOFactory.getInstance().getStudentAchievementDao().getStudentAchievement(sid);
        List<Achievement> list_ok = new ArrayList<Achievement>();
        List<Achievement> list_wait = new ArrayList<Achievement>();
        List<Achievement> list_no = new ArrayList<Achievement>();
        for (Student_Achievement stu_ach : list) {
            if (stu_ach.getTeacher_result().equals("通过")&&stu_ach.getManager_result().equals("通过")) {
                Achievement achievement = DAOFactory.getInstance().getAchievementDao().getAchievement(stu_ach.getAchievement_id());
                list_ok.add(achievement);
            }else if (stu_ach.getTeacher_result().equals("待审核")||stu_ach.getManager_result().equals("待审核")) {
                Achievement achievement = DAOFactory.getInstance().getAchievementDao().getAchievement(stu_ach.getAchievement_id());
                list_wait.add(achievement);
            }else if (stu_ach.getTeacher_result().equals("不通过")||stu_ach.getManager_result().equals("不通过")) {
                Achievement achievement = DAOFactory.getInstance().getAchievementDao().getAchievement(stu_ach.getAchievement_id());
                list_no.add(achievement);
            }
        }
        System.out.println("终审通过：");
        for (Achievement achievement : list_ok) {
            showAchievement(achievement.getType(), achievement.getDetail_id());
        }
        System.out.println("审核中：");
        for (Achievement achievement : list_wait) {
            showAchievement(achievement.getType(), achievement.getDetail_id());
        }
        System.out.println("未通过：");
        for (Achievement achievement : list_no) {
            showAchievement(achievement.getType(), achievement.getDetail_id());
        }
    }
}
