package 系统管理员;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import 基于JavaGUI和MySql的学生宿舍管理系统.AboutTheSystem;
import 基于JavaGUI和MySql的学生宿舍管理系统.CheckForUpdates;
import 基于JavaGUI和MySql的学生宿舍管理系统.Help;
import 基于JavaGUI和MySql的学生宿舍管理系统.TipsAndTricks;
import 基于JavaGUI和MySql的学生宿舍管理系统.Welcome;

import java.awt.*;
import java.nio.channels.NonWritableChannelException;

public class ManagerInterfaceOfDormitory extends JFrame implements TreeSelectionListener{
	LeftJPanel leftJPanel;//左边导航栏
	JPanel rightJPanel;//右边工作区
	StudentManagementInterface studentManagementInterface;
	DormitoryManagementInterface dormitoryManagementInterface;
	DormitoryAdministratorManagementInterface dormitoryAdministratorManagementInterface;
	DisciplineViolationInformationManagementInterface disciplineViolationInformationManagementInterface;
	VisitingInformationManagementInterface visitingInformationManagementInterface;
	Welcome welcome;
	AboutTheSystem aboutTheSystem;
	TipsAndTricks tipsAndTricks;
	Help help;
	CheckForUpdates checkForUpdates;
	SystemAdministratorChangePassword systemAdministratorChangePassword;
	PersonalBasicInformationQuery personalBasicInformationQuery;
//	DormitoryAdministratorPermissionManagementInterface dormitoryAdministratorPermissionManagementInterface;  //宿舍管理员权限管理
	JSplitPane jSplitPane;
	CardLayout cardLayout;
	public ManagerInterfaceOfDormitory(String number) {

		 try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		
		leftJPanel=new LeftJPanel();
		rightJPanel=new JPanel();
		welcome=new Welcome();
		aboutTheSystem=new AboutTheSystem();
		studentManagementInterface=new StudentManagementInterface();
		dormitoryManagementInterface=new DormitoryManagementInterface();
		dormitoryAdministratorManagementInterface=new DormitoryAdministratorManagementInterface();
		disciplineViolationInformationManagementInterface=new DisciplineViolationInformationManagementInterface();
		visitingInformationManagementInterface=new VisitingInformationManagementInterface();
		tipsAndTricks=new TipsAndTricks(); 
		help=new Help();
		checkForUpdates=new CheckForUpdates();
		systemAdministratorChangePassword=new SystemAdministratorChangePassword(number);
		personalBasicInformationQuery=new PersonalBasicInformationQuery(number);
//		dormitoryAdministratorPermissionManagementInterface=new DormitoryAdministratorPermissionManagementInterface();  //宿舍管理员权限管理
		cardLayout=new CardLayout();
		
		rightJPanel.setLayout(cardLayout); 
		rightJPanel.add("welcome",welcome);
		rightJPanel.add("aboutsystem",aboutTheSystem);
		rightJPanel.add("student",studentManagementInterface);
		rightJPanel.add("dormitory",dormitoryManagementInterface);
		rightJPanel.add("dormitoryadministrator",dormitoryAdministratorManagementInterface);
		rightJPanel.add("disciplineViolation",disciplineViolationInformationManagementInterface);
		rightJPanel.add("visitinginformation",visitingInformationManagementInterface);
		rightJPanel.add("tips",tipsAndTricks);
		rightJPanel.add("help",help);
		rightJPanel.add("update",checkForUpdates);
		rightJPanel.add("changepassword",systemAdministratorChangePassword);
		rightJPanel.add("personalinformation",personalBasicInformationQuery);
//		rightJPanel.add("permisson",dormitoryAdministratorPermissionManagementInterface);       //宿舍管理员权限管理
		
		
		
		
		jSplitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftJPanel,rightJPanel);
		
		
		
		jSplitPane.setDividerLocation(180);
		jSplitPane.setContinuousLayout(true);// 设置拖动分隔条时是否连续重绘组件
		
		//组件添加监听器
		leftJPanel.tree.addTreeSelectionListener(this);
		
		this.add(jSplitPane);
		this.setTitle("学生宿舍管理系统");
		this.setSize(1100,700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO 自动生成的方法存根
		DefaultMutableTreeNode node=(DefaultMutableTreeNode) leftJPanel.tree.getLastSelectedPathComponent();
		if (node==leftJPanel.node1) {
			cardLayout.show(rightJPanel,"student");
		}else if (node==leftJPanel.node2) {
			cardLayout.show(rightJPanel,"dormitoryadministrator");
		}else if (node==leftJPanel.node3) {
			cardLayout.show(rightJPanel,"dormitory");
		}else if (node==leftJPanel.node4) {
			cardLayout.show(rightJPanel,"disciplineViolation");
		}else if (node==leftJPanel.node5) {
			cardLayout.show(rightJPanel,"visitinginformation");
		}
//		else if (node==leftJPanel.node6) {    //宿舍管理员权限管理
//			cardLayout.show(rightJPanel,"permisson");
//		}
		else if (node==leftJPanel.node7) {
			cardLayout.show(rightJPanel,"personalinformation");
		}else if (node==leftJPanel.node8) {
			cardLayout.show(rightJPanel,"welcome");
		}else if (node==leftJPanel.node9) {
			cardLayout.show(rightJPanel,"aboutsystem");
		}else if (node==leftJPanel.node10) {
			cardLayout.show(rightJPanel,"update");
		}else if (node==leftJPanel.node11) {
			cardLayout.show(rightJPanel,"tips");
		}else if (node==leftJPanel.node12) {
			cardLayout.show(rightJPanel,"help");
		}else if (node==leftJPanel.node13) {
			cardLayout.show(rightJPanel,"changepassword");
		}else if (node==leftJPanel.node14) {
			int n = JOptionPane.showConfirmDialog(this, "你确定要退出码？", "",JOptionPane.YES_NO_OPTION); 
			if (n==JOptionPane.YES_OPTION) {
				System.exit(0);
			}else {
				
			}
		}
		
	}

}
