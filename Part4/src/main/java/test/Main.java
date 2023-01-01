package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import test.dao.DAOFactory;
import test.entity.Achievement;
import test.entity.Other;
import test.entity.Paper;
import test.entity.Patent;
import test.entity.Report;
import test.entity.Reward;
import test.entity.SoftwareHardwarePlatform;
import test.entity.Standard;
import test.entity.Student_Achievement;
import test.entity.TeachingBooks;

public class Main {
	public static void main(String[] args) throws ParseException {
		while (true) {
			System.out.println("请选择您的身份：a.研究生 b.导师 c.管理人员 d.退出");
			Scanner scanner1 = new Scanner(System.in);
			String input1 = scanner1.nextLine();

			if (input1.equals("a")) {// a.研究生 b.导师 c.管理人员 d.退出
				System.out.println("您是：研究生");
				System.out.println("请选择您的身份：a.硕士 b.博士");
				Scanner scanner2 = new Scanner(System.in);
				String input2 = scanner2.nextLine();

				System.out.println("请输入您的学号：");
				Scanner sno = new Scanner(System.in);
				String sid = sno.nextLine();

				if (input2.equals("a")) {// a.硕士 b.博士
					System.out.println(sid + "您好！您是：硕士研究生");
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
						System.out.println(sid + "您好！目前您已申请的成果认证有：");
						ClassifyAchievement(sid);
					}
				} else if (input2.equals("b")) {// a.硕士 b.博士
					System.out.println(sid + "您好！您是：博士研究生");
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
						System.out.println(sid + "您好！目前您已申请的成果认证有：");
						ClassifyAchievement(sid);
					}
				}

			} else if (input1.equals("b")) {// a.研究生 b.导师 c.管理人员 d.退出
				System.out.println("您是：导师");
				Scanner scanner2 = new Scanner(System.in);// a.是 b.否 c.停止审核
				
				System.out.println("请输入您的工号：");
				Scanner gno = new Scanner(System.in);
				String gid = gno.nextLine();

				// 这一块展示所有学生提交的未审批的成果
				System.out.println("待审核成果如下：");
				List<Student_Achievement> list = DAOFactory.getInstance().getStudentAchievementDao()
						.getAllStudentAchievement();
				for (Student_Achievement stu_ach : list) {
					if (stu_ach.getTeacher_result().equals("待审核")) {
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
				System.out.println("审核完成！");

			} else if (input1.equals("c")) {// a.研究生 b.导师 c.管理人员 d.退出
				System.out.println("您是：管理人员");
				Scanner scanner2 = new Scanner(System.in);// a.是 b.否 c.停止审核
				
				System.out.println("请输入您的工号：");
				Scanner gno = new Scanner(System.in);
				String gid = gno.nextLine();
				
				// 这一块展示导师通过的，但管理员未审批的成果
				System.out.println("待审核成果如下：");
				List<Student_Achievement> list = DAOFactory.getInstance().getStudentAchievementDao()
						.getAllStudentAchievement();
				for (Student_Achievement stu_ach : list) {
					if (stu_ach.getManager_result().equals("待审核") && stu_ach.getTeacher_result().equals("通过")) {
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
				System.out.println("审核完成！");

			} else if (input1.equals("d")) {// a.研究生 b.导师 c.管理人员 d.退出
				System.out.println("已退出！");
				break;
			}
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
