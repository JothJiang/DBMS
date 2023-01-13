package Main;

import DAO.DAOFactory;
import bean.Project;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println("--------欢迎来到项目认定子系统--------");
        System.out.println("--------登录--------");
        System.out.println("请选择您的身份");
        System.out.println("1.研究生培养管理员 2.学科负责人 3.导师 4.研究生");
        Scanner input=new Scanner(System.in);
        int identity_int=input.nextInt();
       while(true){
           if(identity_int==1){//1.研究生培养管理员
               System.out.println("请输入您的研究生培养管理员编号：");
               String tano=input.next();
               System.out.println("请输入密码：");
               String pwd=input.next();
               if(DAOFactory.getInstance().getAdministratorDAO().login_search(tano,pwd)==2){
                   System.out.println("登录成功\n");
                   while(true){
                       System.out.println("请选择您需要的业务：");
                       System.out.println("1.导入项目 2.查看所有项目 3.检索项目 4.修改项目信息 5.后退");
                       int administer_business=input.nextInt();
                       if(administer_business==1){//导入项目情况
                           System.out.print("请输入项目编号：");
                           String pnum=input.next();
                           System.out.print("请输入项目类型：");
                           String ptype=input.next();
                           System.out.print("请输入项目名称：");
                           String pname=input.next();
                           System.out.print("请输入参与项目时间：");
                           String ptime=input.next();
                           System.out.print("请输入项目中承担的工作：");
                           String pwork=input.next();
                           System.out.print("请输入项目参与的学生学号：");
                           String sno=input.next();
                           System.out.print("请输入项目指导教师的编号：");
                           String tno=input.next();
                           String confirms="未确认";
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
                       }
                       else if(administer_business==2){//查看所有项目
                           List<Project> show_projects = DAOFactory.getInstance().getProjectDAO().showProjects();
                           System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                           for (int i = 0; i < show_projects.size(); i++) {
                               System.out.println(show_projects.get(i).getpid() + "\t" + show_projects.get(i).getpnum()
                                       + "\t\t" + show_projects.get(i).getptype() + "\t\t" + show_projects.get(i).getpname()
                                       + "\t\t" + show_projects.get(i).getptime() + "\t\t" + show_projects.get(i).getpwork()
                                       + "\t\t" + show_projects.get(i).getpbudget()+ "\t\t\t" + show_projects.get(i).getconfirms()
                                       + "\t\t\t\t" + show_projects.get(i).getsno()+ "\t\t\t\t" + show_projects.get(i).gettno());
                           }
                           System.out.println("共"+show_projects.size()+"个项目\n");
                       }
                       else if(administer_business==3){//检索项目
                           System.out.print("请输入需要查询的项目编号：");
                           String pnum=input.next();
                           Project project1 = Get(pnum);
                           System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                           System.out.println("  " + project1.getpid() + "\t" + project1.getpnum()
                                   + "\t\t" + project1.getptype() + "\t\t" + project1.getpname()
                                   + "\t\t" + project1.getptime() + "\t\t" + project1.getpwork()
                                   + "\t\t" + project1.getpbudget()+ "\t\t\t" + project1.getconfirms()
                                   + "\t\t\t\t" + project1.getsno()+ "\t\t\t\t" + project1.gettno());
                       }
                       else if(administer_business==4){//修改项目信息
                           System.out.print("请输入需要修改的项目编号：");
                           String pnum=input.next();
                           Project project1 = DAOFactory.getInstance().getProjectDAO().getProject(pnum);
                           while(true) {
                               System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                               System.out.println("  " + project1.getpid() + "\t" + project1.getpnum()
                                       + "\t\t" + project1.getptype() + "\t\t" + project1.getpname()
                                       + "\t\t" + project1.getptime() + "\t\t" + project1.getpwork()
                                       + "\t\t" + project1.getpbudget()+ "\t\t\t" + project1.getconfirms()
                                       + "\t\t\t\t" + project1.getsno()+ "\t\t\t\t" + project1.gettno());
                               System.out.print("您需要修改？");
                               System.out.println("1.项目编号  2.项目类型  3.项目名称  4.参与项目时间  5.承担工作  6.承担工作的折合经费  7.参与项目的学生学号 8.指导教师编号 9.结束修改");
                               int up=input.nextInt();
                               if(up==1){
                                   System.out.print("请输入修改后的项目编号：");
                                   pnum=input.next();
                                   project1.setpnum(pnum);
                               }
                               else if(up==2){
                                   System.out.print("请输入修改后的项目类型：");
                                   String ptype=input.next();
                                   project1.setptype(ptype);
                               }
                               else if(up==3){
                                   System.out.print("请输入修改后的项目名称：");
                                   String pname=input.next();
                                   project1.setpname(pname);
                               }
                               else if(up==4){
                                   System.out.print("请输入修改后的参与项目时间：");
                                   String ptime=input.next();
                                   project1.setptime(ptime);
                               }
                               else if(up==5){
                                   System.out.print("请输入修改后的您在项目中承担的工作：");
                                   String pwork=input.next();
                                   project1.setpwork(pwork);
                               }
                               else if(up==6){
                                   System.out.print("请输入修改后的承担工作的折合经费：");
                                   String pbudget=input.next();
                                   project1.setpbudget(pbudget);
                               }
                               else if(up==7){
                                   System.out.print("请输入修改后的参与项目的学生学号：");
                                   String sno=input.next();
                                   project1.setsno(sno);
                               }
                               else if(up==8){
                                   System.out.print("请输入修改后的指导教师编号：");
                                   String tno=input.next();
                                   project1.settno(tno);
                               }
                               else if(up==9){
                                   break;
                               }
                               else{
                                   System.out.print("输入错误，请重新输入");
                               }
                               if(up>0 && up<7){
                                   Update(project1);
                               }
                           }
                       }
                       else if(administer_business==5){//后退
                           break;
                       }
                       else{
                           System.out.println("输入错误，请重新输入");
                       }
                   }
                   break;
               }
               else{
                   System.out.println("编号或密码输入错误，请重新输入");
               }
           }
           else if(identity_int==2){//2.学科负责人
               while(true){
                   System.out.println("请输入您的学科负责人编号：");
                   String mno=input.next();
                   System.out.println("请输入密码：");
                   String pwd=input.next();
                   if(DAOFactory.getInstance().getManagerDAO().login_search(mno,pwd)==2){
                       System.out.println("登录成功\n");
                       while(true){
                           System.out.println("请选择您需要的业务：");
                           System.out.println("1.查看所有项目 2.确认导师已填报经费的项目 3.检索项目 4.修改参与项目的经费要求 5.后退");
                           int manager_business=input.nextInt();
                           if(manager_business==1){//查看所有项目
                               List<Project> show_projects = DAOFactory.getInstance().getProjectDAO().showProjects();
                               System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                               for (int i = 0; i < show_projects.size(); i++) {
                                   System.out.println(show_projects.get(i).getpid() + "\t" + show_projects.get(i).getpnum()
                                           + "\t\t" + show_projects.get(i).getptype() + "\t\t" + show_projects.get(i).getpname()
                                           + "\t\t" + show_projects.get(i).getptime() + "\t\t" + show_projects.get(i).getpwork()
                                           + "\t\t" + show_projects.get(i).getpbudget()+ "\t\t\t" + show_projects.get(i).getconfirms()
                                           + "\t\t\t\t" + show_projects.get(i).getsno()+ "\t\t\t\t" + show_projects.get(i).gettno());
                               }
                               System.out.println("共"+show_projects.size()+"个项目\n");
                           }
                           else if(manager_business==2){//确认导师已填报的项目经费
                               List<Project> confirm_projects = DAOFactory.getInstance().getProjectDAO().confirmProjects();
                               System.out.println("指导教师已确认的项目如下：");
                               System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                               for (int i = 0; i < confirm_projects.size(); i++) {
                                   System.out.println(confirm_projects.get(i).getpid() + "\t" + confirm_projects.get(i).getpnum()
                                           + "\t\t" + confirm_projects.get(i).getptype() + "\t\t" + confirm_projects.get(i).getpname()
                                           + "\t\t" + confirm_projects.get(i).getptime() + "\t\t" + confirm_projects.get(i).getpwork()
                                           + "\t\t" + confirm_projects.get(i).getpbudget()+ "\t\t\t" + confirm_projects.get(i).getconfirms()
                                           + "\t\t\t\t" + confirm_projects.get(i).getsno()+ "\t\t\t\t" + confirm_projects.get(i).gettno());
                               }
                               System.out.println("请输入您想确认的项目的序号：");
                               int confirm_num=input.nextInt();
                               DAOFactory.getInstance().getProjectDAO().update_confirm(confirm_num);
                               System.out.println("操作成功！");

                           }
                           else if(manager_business==3){//检索项目
                               System.out.print("请输入需要查询的项目编号：");
                               String pnum=input.next();
                               Project project1 = Get(pnum);
                               System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                               System.out.println("  " + project1.getpid() + "\t" + project1.getpnum()
                                       + "\t\t" + project1.getptype() + "\t\t" + project1.getpname()
                                       + "\t\t" + project1.getptime() + "\t\t" + project1.getpwork()
                                       + "\t\t" + project1.getpbudget()+ "\t\t\t" + project1.getconfirms()
                                       + "\t\t\t\t" + project1.getsno()+ "\t\t\t\t" + project1.gettno());

                           }
                           else if(manager_business==4){//修改参与项目的经费要求
                               List<Project> confirm_projects = DAOFactory.getInstance().getProjectDAO().confirmProjects();
                               System.out.println("指导教师已确认的项目如下：");
                               System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                               for (int i = 0; i < confirm_projects.size(); i++) {
                                   System.out.println(confirm_projects.get(i).getpid() + "\t" + confirm_projects.get(i).getpnum()
                                           + "\t\t" + confirm_projects.get(i).getptype() + "\t\t" + confirm_projects.get(i).getpname()
                                           + "\t\t" + confirm_projects.get(i).getptime() + "\t\t" + confirm_projects.get(i).getpwork()
                                           + "\t\t" + confirm_projects.get(i).getpbudget()+ "\t\t\t" + confirm_projects.get(i).getconfirms()
                                           + "\t\t\t\t" + confirm_projects.get(i).getsno()+ "\t\t\t\t" + confirm_projects.get(i).gettno());
                               }
                               System.out.print("请输入需要修改的项目编号：");
                               String pnum=input.next();
                               Project project1 = DAOFactory.getInstance().getProjectDAO().getProject(pnum);
                               System.out.print("请输入修改后的经费：");
                               String pbudget=input.next();
                               project1.setpbudget(pbudget);
                               Update(project1);
                           }
                           else if(manager_business==4){//后退
                               break;
                           }
                           else{
                               System.out.println("输入错误，请重新输入");
                           }
                       }
                       break;
                   }
                   else{
                       System.out.println("编号或密码输入错误，请重新输入");
                   }
               }
           }
           else if(identity_int==3){//3.导师
               while(true){
                   System.out.println("请输入您的导师编号：");
                   String tno=input.next();
                   System.out.println("请输入密码：");
                   String pwd=input.next();
                   if(DAOFactory.getInstance().getteacherDAO().login_search(tno,pwd)==2){
                       System.out.println("登录成功\n");
                       while(true){
                           System.out.println("请选择您需要的业务：");
                           System.out.println("1.查看您指导的项目 2.填报项目经费 3.后退");
                           int teacher_business=input.nextInt();
                           if(teacher_business==1) {//查看您指导的项目
                               List<Project> teacher_projects = DAOFactory.getInstance().getProjectDAO().teacher_Project(tno);
                               System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                               for (int i = 0; i < teacher_projects.size(); i++) {
                                   System.out.println(teacher_projects.get(i).getpid() + "\t" + teacher_projects.get(i).getpnum()
                                           + "\t\t" + teacher_projects.get(i).getptype() + "\t\t" + teacher_projects.get(i).getpname()
                                           + "\t\t" + teacher_projects.get(i).getptime() + "\t\t" + teacher_projects.get(i).getpwork()
                                           + "\t\t" + teacher_projects.get(i).getpbudget()+ "\t\t\t" + teacher_projects.get(i).getconfirms()
                                           + "\t\t\t\t" + teacher_projects.get(i).getsno()+ "\t\t\t" + teacher_projects.get(i).gettno());
                               }
                           }
                           else if(teacher_business==2) {//填报项目经费
                               List<Project> teacher_projects = DAOFactory.getInstance().getProjectDAO().teacher_Project(tno);
                               System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                               for (int i = 0; i < teacher_projects.size(); i++) {
                                   System.out.println(teacher_projects.get(i).getpid() + "\t" + teacher_projects.get(i).getpnum()
                                           + "\t\t" + teacher_projects.get(i).getptype() + "\t\t" + teacher_projects.get(i).getpname()
                                           + "\t\t" + teacher_projects.get(i).getptime() + "\t\t" + teacher_projects.get(i).getpwork()
                                           + "\t\t" + teacher_projects.get(i).getpbudget()+ "\t\t\t" + teacher_projects.get(i).getconfirms()
                                           + "\t\t\t\t" + teacher_projects.get(i).getsno()+ "\t\t\t" + teacher_projects.get(i).gettno());
                               }
                               System.out.println("请输入您需要填报经费的项目编号：");
                               String pnum=input.next();
                               Project project1 = DAOFactory.getInstance().getProjectDAO().getProject(pnum);
                               System.out.print("请输入项目经费：");
                               String pbudget=input.next();
                               project1.setpbudget(pbudget);
                               Update(project1);
                           }
                           else if(teacher_business==3) {//后退
                               break;
                           }
                           else{
                               System.out.println("输入错误，请重新输入");
                           }
                       }
                       break;
                   }
                    else{
                       System.out.println("导师编号或密码输入错误，请重试");
                   }
               }

           }
           else if(identity_int==4){//4.研究生while(true){
               System.out.println("请输入学号：");
               String sno=input.next();
               System.out.println("请输入密码：");
               String pwd=input.next();
               if(DAOFactory.getInstance().getstudentDAO().login_search(sno,pwd)==2){
                   System.out.println("登录成功\n");
                   System.out.println("您参与的项目如下");
                   List<Project> teacher_projects = DAOFactory.getInstance().getProjectDAO().student_Project(sno);
                   System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）\t项目负责人确认情况\t参与项目的学生学号\t指导教师编号");
                   for (int i = 0; i < teacher_projects.size(); i++) {
                       System.out.println(teacher_projects.get(i).getpid() + "\t" + teacher_projects.get(i).getpnum()
                               + "\t\t" + teacher_projects.get(i).getptype() + "\t\t" + teacher_projects.get(i).getpname()
                               + "\t\t" + teacher_projects.get(i).getptime() + "\t\t" + teacher_projects.get(i).getpwork()
                               + "\t\t" + teacher_projects.get(i).getpbudget()+ "\t\t\t" + teacher_projects.get(i).getconfirms()
                               + "\t\t\t\t" + teacher_projects.get(i).getsno()+ "\t\t\t" + teacher_projects.get(i).gettno());
                   }
                   System.out.println("如有疑问，请联系导师或项目负责人");
                   System.out.println("如需退出，请输入“1”");
                   while(true){
                       int student_operate=input.nextInt();
                       if(student_operate==1){
                           break;
                       }
                       else{
                           System.out.println("输入错误，请重试");
                       }
                   }
                    break;
               }
               else{
                   System.out.println("导师编号或密码输入错误，请重试");
               }

           }
           else{//填写错误
               System.out.println("输入错误，请重新输入");
           }
       }
        System.out.println("退出成功,感谢您的使用");


        /*int p_flag=0;
        System.out.println("请选择您需要执行的业务：");
        while(p_flag==0){
            System.out.println("1.新增项目：");
            System.out.println("2.修改项目信息：");
            System.out.println("3.查询项目：");
            System.out.println("4.查看所有项目：");
            System.out.println("5.删除项目：");
            System.out.println("6.查询目的项目类型的所有项目：");
            System.out.println("7.退出：");
            int n=input.nextInt();
            if(n==1){
                System.out.print("请输入项目编号：");
                String pnum=input.next();
                System.out.print("请输入项目类型：");
                String ptype=input.next();
                System.out.print("请输入项目名称：");
                String pname=input.next();
                System.out.print("请输入参与项目时间：");
                String ptime=input.next();
                System.out.print("请输入您在项目中承担的工作：");
                String pwork=input.next();
                System.out.print("请输入承担工作的折合经费：");
                String pbudget=input.next();
                Project project = new Project();
                project.setpnum(pnum);
                project.setptype(ptype);
                project.setpname(pname);
                project.setptime(ptime);
                project.setpwork(pwork);
                project.setpbudget(pbudget);
                Add(project);
            }
            else if(n==2){
                System.out.print("请需要修改的项目编号：");
                String pnum=input.next();
                Project project1 = DAOFactory.getInstance().getProjectDAO().getProject(pnum);
                while(true) {
                    System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）");
                    System.out.println("  " + project1.getpid() + "\t\t" + project1.getpnum()
                            + "\t\t" + project1.getptype() + "\t\t" + project1.getpname()
                            + "\t\t" + project1.getptime() + "\t\t" + project1.getpwork()
                            + "\t\t" + project1.getpbudget());
                    System.out.print("您需要修改？");
                    System.out.println("1.项目编号  2.项目类型  3.项目名称  4.参与项目时间  5.承担工作  6.承担工作的折合经费  7.结束修改");
                    int up=input.nextInt();
                    if(up==1){
                        System.out.print("请输入修改后的项目编号：");
                        pnum=input.next();
                        project1.setpnum(pnum);
                    }
                    else if(up==2){
                        System.out.print("请输入修改后的项目类型：");
                        String ptype=input.next();
                        project1.setptype(ptype);
                    }
                    else if(up==3){
                        System.out.print("请输入修改后的项目名称：");
                        String pname=input.next();
                        project1.setpname(pname);
                    }
                    else if(up==4){
                        System.out.print("请输入修改后的参与项目时间：");
                        String ptime=input.next();
                        project1.setptime(ptime);
                    }
                    else if(up==5){
                        System.out.print("请输入修改后的您在项目中承担的工作：");
                        String pwork=input.next();
                        project1.setpwork(pwork);
                    }
                    else if(up==6){
                        System.out.print("请输入修改后的承担工作的折合经费：");
                        String pbudget=input.next();
                        project1.setpbudget(pbudget);
                    }
                    else if(up==7){
                        break;
                    }
                    else{
                        System.out.print("输入错误，请重新输入");
                    }
                    if(up>0 && up<7){
                        Update(project1);
                    }
                }
            }
            else if(n==3){
                System.out.print("请输入需要查询的项目编号：");
                String pnum=input.next();
                Project project1 = Get(pnum);
                System.out.println("序号\t项目编号\t\t\t项目类型\t\t\t\t\t\t项目名称\t\t\t\t\t\t参与项目时间\t\t\t 承担工作\t承担工作的折合经费（万元）");
                System.out.println("  " + project1.getpid() + "\t\t" + project1.getpnum()
                        + "\t\t" + project1.getptype() + "\t\t" + project1.getpname()
                        + "\t\t" + project1.getptime() + "\t\t" + project1.getpwork()
                        + "\t\t" + project1.getpbudget());
            }
            else if(n==4){
                List<Project> show_projects = DAOFactory.getInstance().getProjectDAO().showProjects();
                for (int i = 0; i < show_projects.size(); i++) {
                    System.out.println("\t"+i + 1 + "\t" + show_projects.get(i).getpid() + "\t\t" + show_projects.get(i).getpnum()
                            + "\t\t" + show_projects.get(i).getptype() + "\t\t" + show_projects.get(i).getpname()
                            + "\t\t" + show_projects.get(i).getptime() + "\t\t" + show_projects.get(i).getpwork()
                            + "\t\t" + show_projects.get(i).getpbudget());
                }
            }
            else if(n==5){//删除项目
                System.out.print("请输入需要删除的项目名称：");
                String pname=input.next();
                DAOFactory.getInstance().getProjectDAO().deleteProject(pname);
            }
            else if(n==6){//查询目的项目类型的所有项目
                System.out.print("请输入想要查找的项目类型：");
                String ptype=input.next();
                Find(ptype);
            }
            else if(n==7){
                p_flag=1;
            }
            else{
                System.out.print("输入错误，请重新输入：");
            }
        }
        System.out.print("退出成功");*/

        /*String pnum="KC00002";
        String ptype="国家软科学研究计划项目";
        String pname="jspm高校校园图书馆座位预约系统研究";
        String ptime="2020.6-2021.6";
        String pwork="关键算法研究";
        String pbudget="1.1";
        Project project = new Project();
        project.setpnum(pnum);
        project.setptype(ptype);
        project.setpname(pname);
        project.setptime(ptime);
        project.setpwork(pwork);
        project.setpbudget(pbudget);
        //DAOFactory.getInstance().getProjectDAO().addProject(project);
        DAOFactory.getInstance().getProjectDAO().updateProject(project);
        Project project1 = DAOFactory.getInstance().getProjectDAO().getProject(pnum);
        //System.out.println(project1);
        //DAOFactory.getInstance().getProjectDAO().deleteProject(pname);
        List<Project> show_projects = DAOFactory.getInstance().getProjectDAO().showProjects();
        //List<Course> courseList = DAOFactory.getCourseDao().getCourses();

        for (int i = 0; i < show_projects.size(); i++) {
            System.out.println(“\t”+i + 1 + "\t" + show_projects.get(i).getpid() + "\t\t" + show_projects.get(i).getpnum()
                    + "\t\t" + show_projects.get(i).getptype() + "\t\t" + show_projects.get(i).getpname()
                    + "\t\t" + show_projects.get(i).getptime() + "\t\t" + show_projects.get(i).getpwork()
                    + "\t\t" + show_projects.get(i).getpbudget());
        }
        //System.out.println(show_projects);
        //查找类型
        List<Project> find_projects = DAOFactory.getInstance().getProjectDAO().findProjects(ptype);
        //System.out.println(projects);
        for (int i = 0; i < find_projects.size(); i++) {
            System.out.println(i + 1 + "\t\t" + show_projects.get(i).getpid() + "\t\t" + show_projects.get(i).getpnum()
                    + "\t\t" + show_projects.get(i).getptype() + "\t\t" + show_projects.get(i).getpname()
                    + "\t\t" + show_projects.get(i).getptime() + "\t\t" + show_projects.get(i).getpwork()
                    + "\t\t" + show_projects.get(i).getpbudget());
        }*/
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
}

