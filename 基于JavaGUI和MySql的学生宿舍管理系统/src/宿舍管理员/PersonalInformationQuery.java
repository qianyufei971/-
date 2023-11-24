package 宿舍管理员;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import 基于JavaGUI和MySql的学生宿舍管理系统.GetDBConnect;

public class PersonalInformationQuery extends JPanel implements ActionListener{
	JLabel label1,label2,label3,label4,label5,label6,label7;
	JLabel label101,label201,label301,label401,label501,label601,label701;
	JButton button1,button2;
	String number;
	
	public PersonalInformationQuery(String number) {
		this.number=number;
		label1=new JLabel("编号:");
		label2=new JLabel("姓名:");
		label3=new JLabel("性别:");
		label4=new JLabel("管理楼号:");
		label5=new JLabel("联系方式:");
		label6=new JLabel("备注:");
		label7=new JLabel("密码:");
		
		label1.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label2.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label3.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label4.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label5.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label6.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label7.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		
		button1=new JButton("刷 新");
		button2=new JButton("退 出");
		
		
		Connection con=GetDBConnect.connectDB("学生宿舍管理系统","root","123456");//连接代码
		String sql="select * from 宿舍管理员 where 编号='"+number+"'";
		Statement statement=null;
		ResultSet rs=null;
		try {
			statement=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=statement.executeQuery(sql);
			rs.last();
			
			label101=new JLabel(rs.getString(1));
			label201=new JLabel(rs.getString(2));
			label301=new JLabel(rs.getString(3));
			label401=new JLabel(rs.getString(4));
			label501=new JLabel(rs.getString(5));
			label601=new JLabel(rs.getString(6));
			label701=new JLabel(rs.getString(7));
			
			
		}catch(Exception e)
		{System.out.println(e);}
		
		label101.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label201.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label301.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label401.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label501.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label601.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label701.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		
		button1.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));
		button2.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		Box hBox1=Box.createHorizontalBox();
		Box hBox2=Box.createHorizontalBox();
		Box hBox3=Box.createHorizontalBox();
		Box hBox4=Box.createHorizontalBox();
		Box hBox5=Box.createHorizontalBox();
		Box hBox6=Box.createHorizontalBox();
		Box hBox7=Box.createHorizontalBox();
		Box hBox8=Box.createHorizontalBox();
		
		
		Box vBox=Box.createVerticalBox();
		
		
		hBox1.add(label1); hBox1.add(label101);
		hBox2.add(label2); hBox2.add(label201);
		hBox3.add(label3); hBox3.add(label301);
		hBox4.add(label4); hBox4.add(label401);
		hBox5.add(label5); hBox5.add(label501);
		hBox6.add(label6); hBox6.add(label601);
		hBox7.add(label7); hBox7.add(label701);
		hBox8.add(button1); hBox8.add(Box.createHorizontalStrut(50));hBox8.add(button2);

		vBox.add(Box.createVerticalStrut(100));
		vBox.add(hBox1);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(hBox2);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(hBox3);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(hBox4);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(hBox5);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(hBox6);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(hBox7);
		vBox.add(Box.createVerticalStrut(50));
		vBox.add(hBox8);
		
		
		this.add(vBox);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==button1) {
			Connection con=GetDBConnect.connectDB("学生宿舍管理系统","root","123456");//连接代码
			String sql="select * from 宿舍管理员 where 编号='"+this.number+"'";
			System.out.println(sql);
			Statement statement=null;
			ResultSet rs=null;
			try {
				statement=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				rs=statement.executeQuery(sql);
				rs.last();
				
				label101.setText(rs.getString(1));
				label201.setText(rs.getString(2));
				label301.setText(rs.getString(3));
				label401.setText(rs.getString(4));
				label501.setText(rs.getString(5));
				label601.setText(rs.getString(6));
				label701.setText(rs.getString(7));
			}catch(Exception e1)
			{System.out.println(e1);}
		}else if (e.getSource()==button2) {
			int n = JOptionPane.showConfirmDialog(this, "你确定要退出码？", "",JOptionPane.YES_NO_OPTION); 
			if (n==JOptionPane.YES_OPTION) {
				System.exit(0);
			}else {
				
			}
		}
		
	}

}
