package 学生;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.*;

public class StudentUserInterface extends JFrame{
	
	
	JTabbedPane tabbedPane;
	PersonalBasicInformationQueryOfStudent personalBasicInformationQueryOfStudent;
	PersonalDisciplinaryInquiry personalDisciplinaryInquiry;
	RoommateInformationQuery roommateInformationQuery;
	StudentChangesPassword studentChangesPassword;
	
	public StudentUserInterface(String number) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		tabbedPane = new JTabbedPane();
		personalBasicInformationQueryOfStudent=new PersonalBasicInformationQueryOfStudent(number);
		personalDisciplinaryInquiry=new PersonalDisciplinaryInquiry(number);
		roommateInformationQuery=new RoommateInformationQuery(number);
		studentChangesPassword=new StudentChangesPassword(number);
		
		tabbedPane.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));

		tabbedPane.addTab("个人基本信息查询", null, personalBasicInformationQueryOfStudent, "Frst");
		tabbedPane.addTab("个人违纪信息查询", null, personalDisciplinaryInquiry, "Second");
		tabbedPane.addTab("舍友信息查询", null, roommateInformationQuery, "Third");
		tabbedPane.addTab("修改密码", null, studentChangesPassword, "Fourth");

		this.add(tabbedPane);
		this.setTitle("学生宿舍管理系统");
		this.setSize(1200,600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	

	

}
