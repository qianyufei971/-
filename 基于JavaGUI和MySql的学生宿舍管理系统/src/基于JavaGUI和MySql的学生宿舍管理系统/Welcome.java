package 基于JavaGUI和MySql的学生宿舍管理系统;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Welcome extends JPanel{
	JLabel label;
	
	public Welcome() {
		label=new JLabel("欢迎使用学生宿舍管理系统!");
		label.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,30));
		Box vBox=Box.createVerticalBox();
		vBox.add(Box.createVerticalStrut(200));
		vBox.add(label);
		this.add(vBox);
	}
}
