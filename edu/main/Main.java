package edu.main;

import edu.bean.*;
import edu.dao.DAOFactory;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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
                String p1 = DAOFactory.getTeacherDao().getPwdByTno(tno);
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
                            Thread.sleep(1000);
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
                String p1 = DAOFactory.getStudentDao().getPwdBySno(sno);
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
                            if(DAOFactory.getDeaprtDao().getask(DAOFactory.getStudentDao().getDepartBySno(sno))==1){
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
                String p1 = DAOFactory.getManagerDao().getPwdByMno(mno);
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
                            List<Teacher> teacherList = DAOFactory.getTeacherDao().getTeachers();
                            System.out.println("序号\t\t教师号\t\t教师姓名\t\t教授的课程");
                            int j=0;
                            for (int i = 0; i < teacherList.size(); i++) {
                                if(!DAOFactory.getTeacherDao().getDepartByTno(teacherList.get(i).getTno()).equals(DAOFactory.getManagerDao().getDepartByMno(mno))){
                                    continue;
                                }
                                j++;
                                String courses = DAOFactory.getCourseDao().getCoursesByTno(teacherList.get(i).getTno());
                                System.out.println(j + "\t\t" + teacherList.get(i).getTno() + "\t\t" + teacherList.get(i).getTname() + "\t\t" + courses);
                            }
                            Thread.sleep(1000);
                        }
                        else if (choice == 2) {
                            List<Student> studentList = DAOFactory.getStudentDao().getStudents();
                            System.out.println("序号\t\t学号\t\t学生姓名\t\t学生类别\t\t助教课程");
                            int j=1;
                            for (int i = 0; i < studentList.size(); i++) {
                                if(!studentList.get(i).getSdepart().equals(DAOFactory.getManagerDao().getDepartByMno(mno))){
                                    continue;
                                }
                                String courses = DAOFactory.getGCDao().getCoursesBySno(studentList.get(i).getSno());
                                if (courses == null || courses.equals("")) courses = "无";
                                System.out.println(j+ "\t\t" + studentList.get(i).getSno() + "\t\t" + studentList.get(i).getSname()
                                        + "\t\t"  + studentList.get(i).getStype() + "\t\t" + courses);
                                j++;
                            }
                            Thread.sleep(1000);

                        }
                        else if(choice == 3){
                            String aws="已开启";
                            if(DAOFactory.getDeaprtDao().getask(DAOFactory.getManagerDao().getDepartByMno(mno))==1)
                                aws="已关闭";
                            System.out.println("学科编号\t\t学科名称\t\t助教选课系统");
                            System.out.println(DAOFactory.getManagerDao().getDepartByMno(mno)+"\t\t"+
                                    DAOFactory.getDeaprtDao().getdnames(DAOFactory.getManagerDao().getDepartByMno(mno))+"\t\t"+aws);
                            System.out.println("1.开启系统\n" +
                                    "2.关闭系统\n" +
                                    "3.回到主页面\n");
                            System.out.println("请输入您要选择的功能序号:");
                            Scanner sc12 = new Scanner(System.in);
                            int x12 = sc12.nextInt();
                            if(x12==1){
                                DAOFactory.getDeaprtDao().updatesak(0,DAOFactory.getManagerDao().getDepartByMno(mno));
                                System.out.println("助教选课系统已开启！");
                            }
                            else if(x12==2){
                                DAOFactory.getDeaprtDao().updatesak(1,DAOFactory.getManagerDao().getDepartByMno(mno));
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
}
