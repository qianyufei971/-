package 学生;

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

public class PersonalBasicInformationQueryOfStudent extends JPanel implements ActionListener{

	JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11;
	JLabel label101,label201,label301,label401,label501,label601,label701,label801,label901,label1001,label1101;
	JButton button1,button2;
	String number;
	public PersonalBasicInformationQueryOfStudent(String number) {
		
		this.number=number;
		
		label1=new JLabel("学号:");
		label2=new JLabel("姓名:");
		label3=new JLabel("性别:");
		label4=new JLabel("楼号:");
		label5=new JLabel("宿舍号:");
		label6=new JLabel("学院:");
		label7=new JLabel("班级:");
		label8=new JLabel("政治面貌:");
		label9=new JLabel("联系方式:");
		label10=new JLabel("备注:");
		label11=new JLabel("密码:");
		
		label1.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label2.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label3.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label4.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label5.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label6.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label7.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label8.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label9.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label10.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label11.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		
		
		button1=new JButton("刷 新");
		button2=new JButton("退 出");
		
		Connection con=GetDBConnect.connectDB("学生宿舍管理系统","root","123456");//连接代码
		String sql="select * from 学生 where 学号='"+number+"'";
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
			label801=new JLabel(rs.getString(8));
			label901=new JLabel(rs.getString(9));
			label1001=new JLabel(rs.getString(10));
			label1101=new JLabel(rs.getString(11));
			
		}catch(Exception e)
		{System.out.println(e);}
		
		label101.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label201.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label301.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label401.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label501.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label601.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label701.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label801.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label901.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label1001.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		label1101.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
		
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
		Box hBox9=Box.createHorizontalBox();
		Box hBox10=Box.createHorizontalBox();
		Box hBox11=Box.createHorizontalBox();
		Box hBox12=Box.createHorizontalBox();

		Box vBox=Box.createVerticalBox();
		
		
		hBox1.add(label1); hBox1.add(label101);
		hBox2.add(label2); hBox2.add(label201);
		hBox3.add(label3); hBox3.add(label301);
		hBox4.add(label4); hBox4.add(label401);
		hBox5.add(label5); hBox5.add(label501);
		hBox6.add(label6); hBox6.add(label601);
		hBox7.add(label7); hBox7.add(label701);
		hBox8.add(label8); hBox8.add(label801);
		hBox9.add(label9); hBox9.add(label901);
		hBox10.add(label10); hBox10.add(label1001);
		hBox11.add(label11); hBox11.add(label1101);
		hBox12.add(button1); hBox12.add(Box.createHorizontalStrut(50));hBox12.add(button2);

		vBox.add(Box.createVerticalStrut(10));
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
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(hBox8);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(hBox9);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(hBox10);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(hBox11);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(hBox12);
		
		this.add(vBox);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==button1) {
			Connection con=GetDBConnect.connectDB("学生宿舍管理系统","root","123456");//连接代码
			String sql="select * from 学生 where 学号='"+this.number+"'";
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
				label801.setText(rs.getString(8));
				label901.setText(rs.getString(9));
				label1001.setText(rs.getString(10));
				label1101.setText(rs.getString(11));
				
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
