package 宿舍管理员;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import 基于JavaGUI和MySql的学生宿舍管理系统.GetDBConnect;

public class DormitoryAdministerChangePassword extends JPanel implements ActionListener{

	JLabel label1,label2,label3;
	JTextField textField;
	JPasswordField passwordField1,passwordField2;
	JButton button1,button2;
	
	String number;
	
	public DormitoryAdministerChangePassword(String number) {
		
		
		this.number=number;
		
		label1=new JLabel("    请输入原密码");
		label2=new JLabel("    请输入新密码");
		label3=new JLabel("请再次输入新密码");
		
		
		label1.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,30));
		label2.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,30));
		label3.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,30));
		
		textField=new JTextField(30);
		passwordField1=new JPasswordField(30);
		passwordField2=new JPasswordField(30);
		button1=new JButton("修改");
		button2=new JButton("清空");
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		
		button1.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,30));
		button2.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,30));
		
		
		textField.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,30));
		passwordField1.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,30));
		passwordField2.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,30));
		
		Box hBox1=Box.createHorizontalBox();
		Box hBox2=Box.createHorizontalBox();
		Box hBox3=Box.createHorizontalBox();
		Box hBox4=Box.createHorizontalBox();
		
		
		hBox1.add(label1); hBox1.add(textField);
		hBox2.add(label2); hBox2.add(passwordField1);
		hBox3.add(label3); hBox3.add(passwordField2);
		hBox4.add(button1);hBox4.add(Box.createHorizontalStrut(50));hBox4.add(button2);
		
		
		Box vBox=Box.createVerticalBox();
		
		
		vBox.add(Box.createVerticalStrut(80));
		vBox.add(hBox1);
		vBox.add(Box.createVerticalStrut(80));
		vBox.add(hBox2);
		vBox.add(Box.createVerticalStrut(80));
		vBox.add(hBox3);
		vBox.add(Box.createVerticalStrut(80));
		vBox.add(hBox4);
		this.add(vBox);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource()==button1) {
			if (textField.getText().equals("")||passwordField1.getText().equals("")||passwordField2.equals("")) {
				JOptionPane.showMessageDialog(this,"所填内容不能为空！","警告！！！",JOptionPane.WARNING_MESSAGE);
			}else {
				String sql="select * from 宿舍管理员 where 编号="
						+ "'"
						+ number+"'";
				Connection con=GetDBConnect.connectDB("学生宿舍管理系统","root","123456");//连接代码
				Statement statement=null;
				ResultSet rs=null;
				try {
					statement=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					rs=statement.executeQuery(sql);
					rs.last();
					if (rs.getString(7).equals(textField.getText())) {
						if (passwordField1.getText().equals(passwordField2.getText())) {
							PreparedStatement preSql;
							String sqlString="update 宿舍管理员 set 密码=? where 编号=?";
							try {
								preSql = con.prepareStatement(sqlString);
								preSql.setString(1,passwordField1.getText());
								preSql.setString(2,number);
								if(preSql.executeUpdate()>0)
								{
									JOptionPane.showMessageDialog(this,"密码修改成功！！！","恭喜",JOptionPane.PLAIN_MESSAGE);
									textField.setText("");
									passwordField1.setText("");
									passwordField2.setText("");
								}
								else {
									JOptionPane.showMessageDialog(this,"密码修改失败！！！","警告",JOptionPane.WARNING_MESSAGE);
									textField.setText("");
									passwordField1.setText("");
									passwordField2.setText("");
								}
							}catch(Exception e1)
							{
								JOptionPane.showMessageDialog(this,"密码修改失败！！！","警告",JOptionPane.WARNING_MESSAGE);
								textField.setText("");
								passwordField1.setText("");
								passwordField2.setText("");
								System.out.println(e1);
							}
						}else {
							JOptionPane.showMessageDialog(this,"两次密码输入不一致！","警告！！！",JOptionPane.WARNING_MESSAGE);
							textField.setText("");
							passwordField1.setText("");
							passwordField2.setText("");
						}
					}else {
						JOptionPane.showMessageDialog(this,"原密码错误！","警告！！！",JOptionPane.WARNING_MESSAGE);
						textField.setText("");
						passwordField1.setText("");
						passwordField2.setText("");
					}
				}catch(Exception e1)
				{System.out.println(e1);}
			}
			
		}else if (e.getSource()==button2) {
			textField.setText("");
			passwordField1.setText("");
			passwordField2.setText("");
		}
		
	}
}
