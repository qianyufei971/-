package 系统管理员;

import javax.swing.Box;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import 基于JavaGUI和MySql的学生宿舍管理系统.GetDBConnect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class StudentManagementInterface extends JPanel implements ActionListener,MouseListener{
	Connection con=GetDBConnect.connectDB("学生宿舍管理系统","root","123456");//连接代码
	
	
	JSplitPane jSplitPane;
	JPanel p1,p2;
	JButton button1,button2,button3,button4,button5,button6;
	JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11;
	JTextField textField1,textField2,textField4,textField5,textField6,textField7,textField8,textField9,textField10;
	JRadioButton radioButton01,radioButton02;
	ButtonGroup buttonGroup;
	
	DefaultTableModel tModel;
	JTable table;
	String columnname[];
	String record[][];
	
	
	public StudentManagementInterface() {
		p1=new JPanel();
		p2=new JPanel();
		
		button1=new JButton("添加");
		button2=new JButton("删除");
		button3=new JButton("修改");
		button4=new JButton("查询");
		button5=new JButton("清空");
		button6=new JButton("刷新");
		
		button1.setFont(new Font("宋体",Font.BOLD,15));
		button2.setFont(new Font("宋体",Font.BOLD,15));
		button3.setFont(new Font("宋体",Font.BOLD,15));
		button4.setFont(new Font("宋体",Font.BOLD,15));
		button5.setFont(new Font("宋体",Font.BOLD,15));
		button6.setFont(new Font("宋体",Font.BOLD,15));
		
		
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		
		label1=new JLabel("学 号  ");
		label2=new JLabel("姓 名  ");
		label3=new JLabel("性  别   ");
		label4=new JLabel("楼 号  ");
		label5=new JLabel("宿舍号  ");
		label6=new JLabel("学 院  ");
		label7=new JLabel("班 级  ");
		label8=new JLabel("政治面貌 ");
		label9=new JLabel("联系方式 ");
		label10=new JLabel("备 注  ");
		
		
		
		
		label1.setFont(new Font("宋体",Font.BOLD,15));
		label2.setFont(new Font("宋体",Font.BOLD,15));
		label3.setFont(new Font("宋体",Font.BOLD,15));
		label4.setFont(new Font("宋体",Font.BOLD,15));
		label5.setFont(new Font("宋体",Font.BOLD,15));
		label6.setFont(new Font("宋体",Font.BOLD,15));
		label7.setFont(new Font("宋体",Font.BOLD,15));
		label8.setFont(new Font("宋体",Font.BOLD,15));
		label9.setFont(new Font("宋体",Font.BOLD,15));
		label10.setFont(new Font("宋体",Font.BOLD,15));
		
		
		textField1=new JTextField(15);
		textField2=new JTextField(15);
		textField4=new JTextField(15);
		textField5=new JTextField(15);
		textField6=new JTextField(15);
		textField7=new JTextField(15);
		textField8=new JTextField(15);
		textField9=new JTextField(15);
		textField10=new JTextField(15);
		// 创建两个单选按钮
        radioButton01 = new JRadioButton("男");
        radioButton02 = new JRadioButton("女");

        // 创建按钮组，把两个单选按钮添加到该组
        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton01);
        buttonGroup.add(radioButton02);

        radioButton01.setFont(new Font("宋体",Font.BOLD,15));
        radioButton02.setFont(new Font("宋体",Font.BOLD,15));
        
        radioButton01.setSelected(true);
        
        
	
		
		textField1.setFont(new Font("宋体",Font.BOLD,15));
		textField2.setFont(new Font("宋体",Font.BOLD,15));
//		textField3.setFont(new Font("宋体",Font.BOLD,15));
		textField4.setFont(new Font("宋体",Font.BOLD,15));
		textField5.setFont(new Font("宋体",Font.BOLD,15));
		textField6.setFont(new Font("宋体",Font.BOLD,15));
		textField7.setFont(new Font("宋体",Font.BOLD,15));
		textField8.setFont(new Font("宋体",Font.BOLD,15));
		textField9.setFont(new Font("宋体",Font.BOLD,15));
		textField10.setFont(new Font("宋体",Font.BOLD,15));
		
		

		
		
		
		Box hBox1 = Box.createHorizontalBox();
		Box hBox2 = Box.createHorizontalBox();
		Box hBox3 = Box.createHorizontalBox();
		Box hBox4 = Box.createHorizontalBox();
		Box hBox5 = Box.createHorizontalBox();
		Box hBox6 = Box.createHorizontalBox();
		Box hBox7 = Box.createHorizontalBox();
		Box hBox8 = Box.createHorizontalBox();
		Box hBox9 = Box.createHorizontalBox();
		Box hBox10= Box.createHorizontalBox();
		Box hBox11= Box.createHorizontalBox();
		Box hBox12= Box.createHorizontalBox();
		Box hBox13= Box.createHorizontalBox();
		Box hBox14= Box.createHorizontalBox();
		Box hBox15= Box.createHorizontalBox();
		Box hBox16= Box.createHorizontalBox();
		
		
		Box vBox = Box.createVerticalBox();
		
		
		p2.setLayout(new FlowLayout());
		
		defaultdisplay();
		
		
        // 创建一个表格，指定 所有行数据 和 表头
        table = new JTable(tModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setFont(new Font("宋体",Font.BOLD,10));
        table.getTableHeader().setFont(new Font("宋体",Font.BOLD,15));
        table.addMouseListener(this);
        JScrollPane scrollPane=new JScrollPane(table);
        p1.setLayout(new BorderLayout());
        p1.add(scrollPane);


		
		hBox1.add(label1);
		hBox1.add(textField1);
		hBox2.add(label2);
		hBox2.add(textField2);
		hBox3.add(label3);
		hBox3.add(radioButton01);
		hBox3.add(radioButton02);
		hBox4.add(label4);
		hBox4.add(textField4);
		hBox5.add(label5);
		hBox5.add(textField5);
		hBox6.add(label6);
		hBox6.add(textField6);
		hBox7.add(label7);
		hBox7.add(textField7);
		hBox8.add(label8);
		hBox8.add(textField8);
		hBox9.add(label9);
		hBox9.add(textField9);
		hBox10.add(label10);
		hBox10.add(textField10);
		hBox11.add(button1);
		hBox12.add(button2);
		hBox13.add(button3);
		hBox14.add(button4);
		hBox15.add(button5);
		hBox16.add(button6);
		
		
		
		
		vBox.add(hBox1);
		vBox.add(Box.createVerticalStrut(15));
		vBox.add(hBox2);
		vBox.add(Box.createVerticalStrut(15));
		vBox.add(hBox3);
		vBox.add(Box.createVerticalStrut(15));
		vBox.add(hBox4);
		vBox.add(Box.createVerticalStrut(15));
		vBox.add(hBox5);
		vBox.add(Box.createVerticalStrut(15));
		vBox.add(hBox6);
		vBox.add(Box.createVerticalStrut(15));
		vBox.add(hBox7);
		vBox.add(Box.createVerticalStrut(15));
		vBox.add(hBox8);
		vBox.add(Box.createVerticalStrut(15));
		vBox.add(hBox9);
		vBox.add(Box.createVerticalStrut(15));
		vBox.add(hBox10);
		vBox.add(Box.createVerticalStrut(15));
		vBox.add(hBox11);
		vBox.add(Box.createVerticalStrut(15));
		vBox.add(hBox12);
		vBox.add(Box.createVerticalStrut(15));
		vBox.add(hBox13);
		vBox.add(Box.createVerticalStrut(15));
		vBox.add(hBox14);
		vBox.add(Box.createVerticalStrut(15));
		vBox.add(hBox15);
		vBox.add(Box.createVerticalStrut(15));
		vBox.add(hBox16);
		
		
		p2.add(vBox);
		
		
		
		
		
		jSplitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		jSplitPane.setTopComponent(p1);
		jSplitPane.setBottomComponent(p2);
		jSplitPane.setDividerLocation(600);
		jSplitPane.setContinuousLayout(true);// 设置拖动分隔条时是否连续重绘组件
		this.setLayout(new BorderLayout()); 
		this.add(jSplitPane);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource()==button1) {
			PreparedStatement preSql;
			String sqlString="insert into 学生(学号,姓名,性别,楼号,宿舍号,学院,班级,政治面貌,联系方式,备注) values(?,?,?,?,?,?,?,?,?,?)";
			try {
				preSql = con.prepareStatement(sqlString);
				preSql.setString(1,textField1.getText());
				preSql.setString(2, textField2.getText());
				preSql.setString(3,(radioButton01.isSelected()?radioButton01.getText():radioButton02.getText()) );
				preSql.setString(4, textField4.getText());
				preSql.setString(5, textField5.getText());
				preSql.setString(6, textField6.getText());
				preSql.setString(7, textField7.getText());
				preSql.setString(8, textField8.getText());
				preSql.setString(9, textField9.getText());
				preSql.setString(10, textField10.getText());
				if(preSql.executeUpdate()>0)
				{
					JOptionPane.showMessageDialog(this,"添加成功！！！","恭喜",JOptionPane.PLAIN_MESSAGE);
					clean();
				}
				else {
					JOptionPane.showMessageDialog(this,"添加失败！！！","警告",JOptionPane.WARNING_MESSAGE);
				}
			}catch(Exception e1)
			{
				JOptionPane.showMessageDialog(this,"添加失败！！！","警告",JOptionPane.WARNING_MESSAGE);
				System.out.println(e1);
			}
			reFresh();
			
		}else if (e.getSource()==button2) {
			int index = table.getSelectedRow();//获取选中的行
			if(index<0)
			{
				JOptionPane.showMessageDialog(this,"请选择你要删除的内容！！！","警告",JOptionPane.WARNING_MESSAGE);
			}
			else {
				String m= table.getValueAt(index, 0).toString();
				try {
					String sql="delete from 学生 where 学号='"
							+ m+"'";
					Statement statement = con.createStatement();
					int a=statement.executeUpdate(sql);
					if(a>0)
					{
						JOptionPane.showMessageDialog(this,"删除成功！！！","警告",JOptionPane.PLAIN_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
			reFresh();
			
		}else if (e.getSource()==button3) {
			PreparedStatement preSql;
			String sqlString="update 学生 set 姓名=?,性别=?,楼号=?,宿舍号=?,学院=?,班级=?,政治面貌=?,联系方式=?,备注=? where 学号=?";
			try {
				preSql = con.prepareStatement(sqlString);
				preSql.setString(1,textField2.getText());
				preSql.setString(2, (radioButton01.isSelected()?radioButton01.getText():radioButton02.getText()));
				preSql.setString(3, textField4.getText());
				preSql.setString(4, textField5.getText());
				preSql.setString(5, textField6.getText());
				preSql.setString(6, textField7.getText());
				preSql.setString(7, textField8.getText());
				preSql.setString(8, textField9.getText());
				preSql.setString(9, textField10.getText());
				preSql.setString(10, textField1.getText());
				if(preSql.executeUpdate()>0)
				{
					JOptionPane.showMessageDialog(this,"学生信息修改成功！！！","恭喜",JOptionPane.PLAIN_MESSAGE);
					clean();
				}
				else {
					JOptionPane.showMessageDialog(this,"学生信息修改失败！！！","警告",JOptionPane.WARNING_MESSAGE);
				}
			}catch(Exception e1)
			{
				JOptionPane.showMessageDialog(this,"学生信息修改失败！！！","警告",JOptionPane.WARNING_MESSAGE);
				System.out.println(e1);
			}
			reFresh();
			
			
		}else if (e.getSource()==button4) {
			String sql="select * from 学生 ";
			if (!textField1.getText().trim().equals("")) {
				sql=sql+"where 学号="
						+ "'"
						+ textField1.getText()+"'";
				if (!textField2.getText().trim().equals("")) {
					sql=sql+"and 姓名="
							+ "'"
							+ textField2.getText()+"'";
				}
				if (!(radioButton01.isSelected()?radioButton01.getText():radioButton02.getText()).equals("")) {
					sql=sql+"and 性别="
							+ "'"
							+ (radioButton01.isSelected()?radioButton01.getText():radioButton02.getText())+"'";
				}
				if (!textField4.getText().equals("")) {
					sql=sql+"and 楼号="
							+ "'"
							+ textField4.getText()+"'";
				}
				if (!textField5.getText().equals("")) {
					sql=sql+"and 宿舍号="
							+ "'"
							+ textField5.getText()+"'";
				}if (!textField6.getText().equals("")) {
					sql=sql+"and 学院="
							+ "'"
							+ textField6.getText()+"'";
				}
				if (!textField7.getText().equals("")) {
					sql=sql+"and 班级="
							+ "'"
							+ textField7.getText()+"'";
				}
				if (!textField8.getText().equals("")) {
					sql=sql+"and 政治面貌="
							+ "'"
							+ textField8.getText()+"'";
				}
				if (!textField9.getText().equals("")) {
					sql=sql+"and 联系方式="
							+ "'"
							+ textField9.getText()+"'";
				}
				if (!textField10.getText().equals("")) {
					sql=sql+"and 备注="
							+ "'"
							+ textField10.getText()+"'";
				}
			}else if (!textField2.getText().equals("")) {
				sql=sql+"where 姓名="
						+ "'"
						+ textField2.getText()+"'";
				if (!(radioButton01.isSelected()?radioButton01.getText():radioButton02.getText()).equals("")) {
					sql=sql+"and 性别="
							+ "'"
							+ (radioButton01.isSelected()?radioButton01.getText():radioButton02.getText())+"'";
				}
				if (!textField4.getText().equals("")) {
					sql=sql+"and 楼号="
							+ "'"
							+ textField4.getText()+"'";
				}
				if (!textField5.getText().equals("")) {
					sql=sql+"and 宿舍号="
							+ "'"
							+ textField5.getText()+"'";
				}if (!textField6.getText().equals("")) {
					sql=sql+"and 学院="
							+ "'"
							+ textField6.getText()+"'";
				}
				if (!textField7.getText().equals("")) {
					sql=sql+"and 班级="
							+ "'"
							+ textField7.getText()+"'";
				}
				if (!textField8.getText().equals("")) {
					sql=sql+"and 政治面貌="
							+ "'"
							+ textField8.getText()+"'";
				}
				if (!textField9.getText().equals("")) {
					sql=sql+"and 联系方式="
							+ "'"
							+ textField9.getText()+"'";
				}
				if (!textField10.getText().equals("")) {
					sql=sql+"and 备注="
							+ "'"
							+ textField10.getText()+"'";
				}
			}else if (!(radioButton01.isSelected()?radioButton01.getText():radioButton02.getText()).equals("")) {
				sql=sql+"where 性别="
						+ "'"
						+ (radioButton01.isSelected()?radioButton01.getText():radioButton02.getText())+"'";
				if (!textField4.getText().equals("")) {
					sql=sql+"and 楼号="
							+ "'"
							+ textField4.getText()+"'";
				}
				if (!textField5.getText().equals("")) {
					sql=sql+"and 宿舍号="
							+ "'"
							+ textField5.getText()+"'";
				}if (!textField6.getText().equals("")) {
					sql=sql+"and 学院="
							+ "'"
							+ textField6.getText()+"'";
				}
				if (!textField7.getText().equals("")) {
					sql=sql+"and 班级="
							+ "'"
							+ textField7.getText()+"'";
				}
				if (!textField8.getText().equals("")) {
					sql=sql+"and 政治面貌="
							+ "'"
							+ textField8.getText()+"'";
				}
				if (!textField9.getText().equals("")) {
					sql=sql+"and 联系方式="
							+ "'"
							+ textField9.getText()+"'";
				}
				if (!textField10.getText().equals("")) {
					sql=sql+"and 备注="
							+ "'"
							+ textField10.getText()+"'";
				}
			}else if (!textField4.getText().equals("")) {
				sql=sql+"where 楼号="
						+ "'"
						+ textField4.getText()+"'";
				if (!textField5.getText().equals("")) {
					sql=sql+"and 宿舍号="
							+ "'"
							+ textField5.getText()+"'";
				}if (!textField6.getText().equals("")) {
					sql=sql+"and 学院="
							+ "'"
							+ textField6.getText()+"'";
				}
				if (!textField7.getText().equals("")) {
					sql=sql+"and 班级="
							+ "'"
							+ textField7.getText()+"'";
				}
				if (!textField8.getText().equals("")) {
					sql=sql+"and 政治面貌="
							+ "'"
							+ textField8.getText()+"'";
				}
				if (!textField9.getText().equals("")) {
					sql=sql+"and 联系方式="
							+ "'"
							+ textField9.getText()+"'";
				}
				if (!textField10.getText().equals("")) {
					sql=sql+"and 备注="
							+ "'"
							+ textField10.getText()+"'";
				}
			}else if (!textField5.getText().equals("")) {
				sql=sql+"where 宿舍号="
						+ "'"
						+ textField5.getText()+"'";
				if (!textField6.getText().equals("")) {
					sql=sql+"and 学院="
							+ "'"
							+ textField6.getText()+"'";
				}
				if (!textField7.getText().equals("")) {
					sql=sql+"and 班级="
							+ "'"
							+ textField7.getText()+"'";
				}
				if (!textField8.getText().equals("")) {
					sql=sql+"and 政治面貌="
							+ "'"
							+ textField8.getText()+"'";
				}
				if (!textField9.getText().equals("")) {
					sql=sql+"and 联系方式="
							+ "'"
							+ textField9.getText()+"'";
				}
				if (!textField10.getText().equals("")) {
					sql=sql+"and 备注="
							+ "'"
							+ textField10.getText()+"'";
				}
				
			}else if (!textField6.getText().equals("")) {
				sql=sql+"where 学院="
						+ "'"
						+ textField6.getText()+"'";
				if (!textField7.getText().equals("")) {
					sql=sql+"and 班级="
							+ "'"
							+ textField7.getText()+"'";
				}
				if (!textField8.getText().equals("")) {
					sql=sql+"and 政治面貌="
							+ "'"
							+ textField8.getText()+"'";
				}
				if (!textField9.getText().equals("")) {
					sql=sql+"and 联系方式="
							+ "'"
							+ textField9.getText()+"'";
				}
				if (!textField10.getText().equals("")) {
					sql=sql+"and 备注="
							+ "'"
							+ textField10.getText()+"'";
				}
			}else if (!textField7.getText().equals("")) {
				sql=sql+"where 班级="
						+ "'"
						+ textField7.getText()+"'";
				
				
				if (!textField8.getText().equals("")) {
					sql=sql+"and 政治面貌="
							+ "'"
							+ textField8.getText()+"'";
				}
				if (!textField9.getText().equals("")) {
					sql=sql+"and 联系方式="
							+ "'"
							+ textField9.getText()+"'";
				}
				if (!textField10.getText().equals("")) {
					sql=sql+"and 备注="
							+ "'"
							+ textField10.getText()+"'";
				}
			}else if (!textField8.getText().equals("")) {
				sql=sql+"where 政治面貌="
						+ "'"
						+ textField8.getText()+"'";
				if (!textField9.getText().equals("")) {
					sql=sql+"and 联系方式="
							+ "'"
							+ textField9.getText()+"'";
				}
				if (!textField10.getText().equals("")) {
					sql=sql+"and 备注="
							+ "'"
							+ textField10.getText()+"'";
				}
			}else if (!textField9.getText().equals("")) {
				sql=sql+"where 联系方式="
						+ "'"
						+ textField9.getText()+"'";
				if (!textField10.getText().equals("")) {
					sql=sql+"and 备注="
							+ "'"
							+ textField10.getText()+"'";
				}
			}else if (!textField10.getText().equals("")) {
				sql=sql+"where 备注="
						+ "'"
						+ textField10.getText()+"'";
			}
			
			System.out.println(sql);
			Statement statement=null;
			ResultSet rs=null;
			try {
				statement=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				rs=statement.executeQuery(sql);
				ResultSetMetaData metaData=(ResultSetMetaData) rs.getMetaData();
				int columncount=metaData.getColumnCount();//获取字段数目
				columnname=new String[columncount];
				for(int i=1;i<=columncount;i++)
				{
					columnname[i-1]=metaData.getColumnName(i);//将字段名称添加到数组中
				}
				rs.last();
				int recordcount =rs.getRow();
				record=new String[recordcount][columncount];
				rs.beforeFirst();
				int m=0;
				while(rs.next())
				{
					for(int j=1;j<=columncount;j++)
					{
						record[m][j-1]=rs.getString(j);
					}
					m++;
				}
			}catch(Exception e1)
			{System.out.println(e1);}
			tModel.setDataVector(record,columnname);
			
		}else if (e.getSource()==button5) {
			clean();
		}else if (e.getSource()==button6) {
			reFresh();
		}
		
		
	}
	
	public void defaultdisplay() {
		String sql="select * from 学生";
		Statement statement=null;
		ResultSet rs=null;
		try {
			statement=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=statement.executeQuery(sql);
			ResultSetMetaData metaData=(ResultSetMetaData) rs.getMetaData();
			int columncount=metaData.getColumnCount();//获取字段数目
			columnname=new String[columncount];
			for(int i=1;i<=columncount;i++)
			{
				columnname[i-1]=metaData.getColumnName(i);//将字段名称添加到数组中
			}
			rs.last();
			int recordcount =rs.getRow();
			record=new String[recordcount][columncount];
			rs.beforeFirst();
			int m=0;
			while(rs.next())
			{
				for(int j=1;j<=columncount;j++)
				{
					record[m][j-1]=rs.getString(j);
				}
				m++;
			}
		}catch(Exception e)
		{System.out.println(e);}
	    tModel = new DefaultTableModel(record,columnname); 

	}
	public void reFresh() {
		String sql="select * from 学生";
		Statement statement=null;
		ResultSet rs=null;
		try {
			statement=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=statement.executeQuery(sql);
			ResultSetMetaData metaData=(ResultSetMetaData) rs.getMetaData();
			int columncount=metaData.getColumnCount();//获取字段数目
			columnname=new String[columncount];
			for(int i=1;i<=columncount;i++)
			{
				columnname[i-1]=metaData.getColumnName(i);//将字段名称添加到数组中
			}
			rs.last();
			int recordcount =rs.getRow();
			record=new String[recordcount][columncount];
			rs.beforeFirst();
			int m=0;
			while(rs.next())
			{
				for(int j=1;j<=columncount;j++)
				{
					record[m][j-1]=rs.getString(j);
				}
				m++;
			}
		}catch(Exception e1)
		{System.out.println(e1);}
		tModel.setDataVector(record,columnname);
		
	}
	public void clean() {
		textField1.setText("");
		textField2.setText("");
		radioButton01.setSelected(true);
		textField4.setText("");
		textField5.setText("");
		textField6.setText("");
		textField7.setText("");
		textField8.setText("");
		textField9.setText("");
		textField10.setText("");
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==table) 
		{
		int index = table.getSelectedRow();//获取选中的行
		String a=table.getValueAt(index,0).toString();
		String c=table.getValueAt(index, 1).toString();
		String d=table.getValueAt(index, 2).toString();
		String f=table.getValueAt(index, 3).toString();
		String g=table.getValueAt(index, 4).toString();
		String h=table.getValueAt(index, 5).toString();
		String i=table.getValueAt(index, 6).toString();
		String j=table.getValueAt(index, 7).toString();
		String k=table.getValueAt(index, 8).toString();
		String l=table.getValueAt(index, 9).toString();
		
		
		
		textField1.setText(a);
		textField2.setText(c);
		if (d.equals("男")) {
			radioButton01.setSelected(true);
		}else {
			radioButton02.setSelected(true);
		}
		textField4.setText(f);
		textField5.setText(g);
		textField6.setText(h);
		textField7.setText(i);
		textField8.setText(j);
		textField9.setText(k);
		textField10.setText(l);
		
		}
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	
}

