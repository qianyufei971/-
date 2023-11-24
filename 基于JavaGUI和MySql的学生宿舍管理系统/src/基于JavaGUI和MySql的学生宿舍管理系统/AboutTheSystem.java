package 基于JavaGUI和MySql的学生宿舍管理系统;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutTheSystem extends JPanel{

	JLabel label1,label2;
	public AboutTheSystem() {
		label1=new JLabel("本系统是一个学生宿舍管理系统，");
		label2=new JLabel("通过该系统可是实现对学生的宿舍管理工作。");
		
		label1.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,30));
		label2.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,30));
	
		Box vBox=Box.createVerticalBox();
		vBox.add(Box.createVerticalStrut(200));
		vBox.add(label1);
		vBox.add(label2);

		this.add(vBox);
	}
}
