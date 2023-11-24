package 基于JavaGUI和MySql的学生宿舍管理系统;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import 学生.StudentUserInterface;
import 宿舍管理员.DormitoryAdministratorInterface;
import 系统管理员.ManagerInterfaceOfDormitory;

import java.awt.*;
import java.awt.event.*;

public class LoginAndRegistrationInterface extends JFrame implements ActionListener{
	Connection con=GetDBConnect.connectDB("学生宿舍管理系统","root","123456");//连接代码
	
	
	
	JLabel label1,label2,labelTitle;
	JTextField jTextField;
	JPasswordField jPasswordField;
	JButton button;
	ButtonGroup buttonGroup;
	JRadioButton radioButton01,radioButton02,radioButton03;
	public LoginAndRegistrationInterface() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		label1=new JLabel("用户名");
		label2=new JLabel("密  码");
		labelTitle=new JLabel("欢迎登陆学生宿舍管理系统！");
		jTextField=new JTextField(15);
		jPasswordField=new JPasswordField(15);
		buttonGroup=new ButtonGroup();
		button=new JButton("    登 录    ");
		radioButton01=new JRadioButton("超管");
		radioButton02=new JRadioButton("宿管");
		radioButton03=new JRadioButton("学生");
		
		buttonGroup.add(radioButton01);
		buttonGroup.add(radioButton02);
		buttonGroup.add(radioButton03);
		
		
		radioButton02.setSelected(true);
		
		
		
		label1.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));
		label2.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));
		labelTitle.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));
		
		radioButton01.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));
		radioButton02.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));
		radioButton03.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));
		
		
		button.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));
		button.addActionListener(this);
		
		
		jTextField.setFont(new Font("宋体",Font.BOLD,15));
		jPasswordField.setFont(new Font("宋体",Font.BOLD,15));
		
		
		
		Box hBoxTitle=Box.createHorizontalBox();
		Box hBox1=Box.createHorizontalBox();
		Box hBox2=Box.createHorizontalBox();
		Box hBox3=Box.createHorizontalBox();
		Box hBox4=Box.createHorizontalBox();
		
		
		hBoxTitle.add(labelTitle);
		hBox1.add(label1);
		hBox1.add(jTextField);
		hBox2.add(label2);
		hBox2.add(jPasswordField);
		hBox3.add(button);
		hBox4.add(radioButton01);
		hBox4.add(radioButton02);
		hBox4.add(radioButton03);
		
		
		Box vBox=Box.createVerticalBox();
		
		
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(hBoxTitle);
		vBox.add(Box.createVerticalStrut(60));
		vBox.add(hBox1);
		vBox.add(Box.createVerticalStrut(30));
		vBox.add(hBox2);
		vBox.add(Box.createVerticalStrut(30));
		vBox.add(hBox3);
		vBox.add(Box.createVerticalStrut(30));
		vBox.add(hBox4);
		
		this.add(vBox);
		
		
		this.setLayout(new FlowLayout());
		this.setTitle("用户登录");
		this.setSize(450,350);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
		
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new LoginAndRegistrationInterface();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource()==button) {
			if (jTextField.getText().equals("")&&jPasswordField.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"用户名和密码不能为空","警告！！！",JOptionPane.WARNING_MESSAGE);
			}else if (!jTextField.getText().equals("")&&jPasswordField.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"密码不能为空","警告！！！",JOptionPane.WARNING_MESSAGE);
			}else if (jTextField.getText().equals("")&&!jPasswordField.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"用户名不能为空","警告！！！",JOptionPane.WARNING_MESSAGE);
			}else {
				if (radioButton01.isSelected()) {
					
					String sql="select * from 系统管理员 where 编号="
							+ "'"
							+ jTextField.getText()+"'";
					Statement statement=null;
					ResultSet rs=null;
					try {
						statement=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
						rs=statement.executeQuery(sql);
						rs.last();
						int recordcount =rs.getRow();
						if (recordcount>0) {
							if(jPasswordField.getText().equals(rs.getString(5))) {
								
								new ManagerInterfaceOfDormitory(jTextField.getText());
								this.dispose();
							}
							else {
								JOptionPane.showMessageDialog(this,"密码错误！！！","警告",JOptionPane.WARNING_MESSAGE);
								jPasswordField.setText("");
							}
						}else {
							JOptionPane.showMessageDialog(this,"不存在该用户！！！","警告",JOptionPane.WARNING_MESSAGE);
							jTextField.setText("");
							jPasswordField.setText("");
						}
					}catch(Exception e1)
					{System.out.println(e1);}
					
					
				}else if (radioButton02.isSelected()) {
					String sql="select * from 宿舍管理员 where 编号="
							+ "'"
							+ jTextField.getText()+"'";
					Statement statement=null;
					ResultSet rs=null;
					try {
						statement=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
						rs=statement.executeQuery(sql);
						rs.last();
						int recordcount =rs.getRow();
						if (recordcount>0) {
							if(jPasswordField.getText().equals(rs.getString(7))) {
								
//								if (rs.getString(8).equals("有")) {					//判断有无权限
//									new DormitoryAdministratorInterface(jTextField.getText());
//									this.dispose();
//								}else {
//									JOptionPane.showMessageDialog(this,"无权限使用该系统！！！","警告",JOptionPane.WARNING_MESSAGE);
//								}
								
								new DormitoryAdministratorInterface(jTextField.getText());
								this.dispose();
								
							}
							else {
								JOptionPane.showMessageDialog(this,"密码错误！！！","警告",JOptionPane.WARNING_MESSAGE);
								jPasswordField.setText("");
							}
						}else {
							JOptionPane.showMessageDialog(this,"不存在该用户！！！","警告",JOptionPane.WARNING_MESSAGE);
							jTextField.setText("");
							jPasswordField.setText("");
						}
					}catch(Exception e1)
					{System.out.println(e1);}
					
				}else if (radioButton03.isSelected()) {
					String sql="select * from 学生 where 学号="
							+ "'"
							+ jTextField.getText()+"'";
					Statement statement=null;
					ResultSet rs=null;
					try {
						statement=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
						rs=statement.executeQuery(sql);
						rs.last();
						int recordcount =rs.getRow();
						if (recordcount>0) {
							if(jPasswordField.getText().equals(rs.getString(11))) {
								
								new StudentUserInterface(jTextField.getText());
								this.dispose();
							}
							else {
								JOptionPane.showMessageDialog(this,"密码错误！！！","警告",JOptionPane.WARNING_MESSAGE);
								jPasswordField.setText("");
							}
						}else {
							JOptionPane.showMessageDialog(this,"不存在该用户！！！","警告",JOptionPane.WARNING_MESSAGE);
							jTextField.setText("");
							jPasswordField.setText("");
						}
					}catch(Exception e1)
					{System.out.println(e1);}
				}
			}
			
		}
		
	}

}
