package 系统管理员;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
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

public class DormitoryAdministratorManagementInterface extends JPanel implements ActionListener,MouseListener{
	Connection con=GetDBConnect.connectDB("学生宿舍管理系统","root","123456");//连接代码
	
	
	JSplitPane jSplitPane1,jSplitPane2;
	JPanel p1,p2,p3;
	JButton button1,button2,button3,button4,button5,button6;
	JLabel label1,label2,label3,label4,label5,label6,label7;
	JTextField textField1,textField2,textField4,textField5,textField6,textField7;
	JRadioButton radioButton01,radioButton02;
	ButtonGroup buttonGroup;
	
	DefaultTableModel tModel;
	JTable table;
	String columnname[];
	String record[][];
	
	public DormitoryAdministratorManagementInterface() {
		
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		
		button1=new JButton("添加");
		button2=new JButton("删除");
		button3=new JButton("修改");
		button4=new JButton("查询");
		button5=new JButton("清空");
		button6=new JButton("刷新");
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		
		
		button1.setFont(new Font("宋体",Font.BOLD,15));
		button2.setFont(new Font("宋体",Font.BOLD,15));
		button3.setFont(new Font("宋体",Font.BOLD,15));
		button4.setFont(new Font("宋体",Font.BOLD,15));
		button5.setFont(new Font("宋体",Font.BOLD,15));
		button6.setFont(new Font("宋体",Font.BOLD,15));
		
		
		label1=new JLabel("编  号");
		label2=new JLabel("姓  名");
		label3=new JLabel("性  别");
		label4=new JLabel("管理楼号");
		label5=new JLabel("联系方式");
		label6=new JLabel("备  注");
		label7=new JLabel("密  码");
		
		
		

		
		label1.setFont(new Font("宋体",Font.BOLD,15));
		label2.setFont(new Font("宋体",Font.BOLD,15));
		label3.setFont(new Font("宋体",Font.BOLD,15));
		label4.setFont(new Font("宋体",Font.BOLD,15));
		label5.setFont(new Font("宋体",Font.BOLD,15));
		label6.setFont(new Font("宋体",Font.BOLD,15));
		label7.setFont(new Font("宋体",Font.BOLD,15));
		
		
		
		textField1=new JTextField(15);
		textField2=new JTextField(15);
		textField4=new JTextField(15);
		textField5=new JTextField(15);
		textField6=new JTextField(15);
		textField7=new JTextField(15);
		
		
		textField1.setHorizontalAlignment(JTextField.CENTER);
		textField2.setHorizontalAlignment(JTextField.CENTER);
		textField4.setHorizontalAlignment(JTextField.CENTER);
		textField5.setHorizontalAlignment(JTextField.CENTER);
		textField6.setHorizontalAlignment(JTextField.CENTER);
		textField7.setHorizontalAlignment(JTextField.CENTER);
		
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
		
		
		
		
		
		Box hBox=Box.createHorizontalBox();
		hBox.add(button1);
		hBox.add(Box.createHorizontalStrut(50));
		hBox.add(button2);
		hBox.add(Box.createHorizontalStrut(50));
		hBox.add(button3);
		hBox.add(Box.createHorizontalStrut(50));
		hBox.add(button4);
		hBox.add(Box.createHorizontalStrut(50));
		hBox.add(button5);
		hBox.add(Box.createHorizontalStrut(50));
		hBox.add(button6);
		
		
		Box hBox1=Box.createHorizontalBox();
		Box hBox2=Box.createHorizontalBox();
		Box hBox3=Box.createHorizontalBox();
		Box hBox4=Box.createHorizontalBox();
		Box hBox5=Box.createHorizontalBox();
		Box hBox6=Box.createHorizontalBox();
		Box hBox7=Box.createHorizontalBox();
		Box hBoxsex=Box.createHorizontalBox();
		
		
		hBox1.add(label1);
		hBox2.add(label2);
		hBox3.add(label3);
		hBox4.add(label4);
		hBox5.add(label5);
		hBox6.add(label6);
		hBox7.add(label7);
		hBoxsex.add(radioButton01);
		hBoxsex.add(radioButton02);
		
		Box vBox=Box.createVerticalBox();
		vBox.add(hBox1);
		vBox.add(textField1);
		vBox.add(Box.createVerticalStrut(45));
		vBox.add(hBox2);
		vBox.add(textField2);
		vBox.add(Box.createVerticalStrut(45));
		vBox.add(hBox3);
		vBox.add(hBoxsex);
		vBox.add(Box.createVerticalStrut(45));
		vBox.add(hBox4);
		vBox.add(textField4);
		vBox.add(Box.createVerticalStrut(45));
		vBox.add(hBox5);
		vBox.add(textField5);
		vBox.add(Box.createVerticalStrut(45));
		vBox.add(hBox6);
		vBox.add(textField6);
		vBox.add(Box.createVerticalStrut(45));
		vBox.add(hBox7);
		vBox.add(textField7);
		vBox.add(Box.createVerticalStrut(50));
		
		p2.add(vBox);
		
		p3.add(hBox);
		
		defaultDisplay();
		
        // 创建一个表格，指定 所有行数据 和 表头
        table = new JTable(tModel);
        table.addMouseListener(this);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFont(new Font("宋体",Font.BOLD,15));
        table.getTableHeader().setFont(new Font("宋体",Font.BOLD,15));
        JScrollPane scrollPane=new JScrollPane(table);
        p1.setLayout(new BorderLayout());
        p1.add(scrollPane);
		
		
		jSplitPane1=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		jSplitPane2=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		jSplitPane1.setTopComponent(jSplitPane2);
		jSplitPane1.setBottomComponent(p3);
		jSplitPane2.setTopComponent(p1);
		jSplitPane2.setBottomComponent(p2);
		jSplitPane1.setDividerLocation(600);
		jSplitPane1.setContinuousLayout(true);// 设置拖动分隔条时是否连续重绘组件
		jSplitPane2.setDividerLocation(700);
		jSplitPane2.setContinuousLayout(true);// 设置拖动分隔条时是否连续重绘组件
		this.setLayout(new BorderLayout()); 
		this.add(jSplitPane1);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==table) 
		{
		int index = table.getSelectedRow();//获取选中的行
		System.out.println(index);
		String a=table.getValueAt(index,0).toString();
		String c=table.getValueAt(index, 1).toString();
		String d=table.getValueAt(index, 2).toString();
		String f=table.getValueAt(index, 3).toString();
		String g=table.getValueAt(index, 4).toString();
		String h=table.getValueAt(index, 5).toString();
		String i=table.getValueAt(index, 6).toString();
		
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource()==button1) {   //增加
			PreparedStatement preSql;
			String sqlString="insert into 宿舍管理员(编号,姓名,性别,管理楼号,联系方式,备注,密码) values(?,?,?,?,?,?,?)";
			try {
				preSql = con.prepareStatement(sqlString);
				preSql.setString(1,textField1.getText());
				preSql.setString(2, textField2.getText());
				preSql.setString(3,(radioButton01.isSelected()?radioButton01.getText():radioButton02.getText()) );
				preSql.setString(4, textField4.getText());
				preSql.setString(5, textField5.getText());
				preSql.setString(6, textField6.getText());
				preSql.setString(7, textField7.getText());
				if(preSql.executeUpdate()>0)
				{
					JOptionPane.showMessageDialog(this,"添加成功！！！","恭喜 ",JOptionPane.PLAIN_MESSAGE);
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
		}else if (e.getSource()==button2) {    		//删除
			int index = table.getSelectedRow();//获取选中的行
			if(index<0)
			{
				JOptionPane.showMessageDialog(this,"请选择你要删除的内容！！！","警告",JOptionPane.WARNING_MESSAGE);
			}
			else {
				String m= table.getValueAt(index, 0).toString();
				try {
					String sql="delete from 宿舍管理员 where 编号='"
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
			
		}else if (e.getSource()==button3) {          //修改
			PreparedStatement preSql;
			String sqlString="update 宿舍管理员 set 姓名=?,性别=?,管理楼号=?,联系方式=?,备注=?,密码=? where 编号=?";
			try {
				preSql = con.prepareStatement(sqlString);
				preSql.setString(1,textField2.getText());
				preSql.setString(2, (radioButton01.isSelected()?radioButton01.getText():radioButton02.getText()));
				preSql.setString(3, textField4.getText());
				preSql.setString(4, textField5.getText());
				preSql.setString(5, textField6.getText());
				preSql.setString(6, textField7.getText());
				preSql.setString(7, textField1.getText());
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
			
		}else if (e.getSource()==button4) {            //查询
			String sql="select * from 宿舍管理员 ";
			if (!textField1.getText().trim().equals("")) {
				sql=sql+"where 编号="
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
					sql=sql+"and 管理楼号="
							+ "'"
							+ textField4.getText()+"'";
				}
				if (!textField5.getText().equals("")) {
					sql=sql+"and 联系方式="
							+ "'"
							+ textField5.getText()+"'";
				}if (!textField6.getText().equals("")) {
					sql=sql+"and 备注="
							+ "'"
							+ textField6.getText()+"'";
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
					sql=sql+"and 管理楼号="
							+ "'"
							+ textField4.getText()+"'";
				}
				if (!textField5.getText().equals("")) {
					sql=sql+"and 联系方式="
							+ "'"
							+ textField5.getText()+"'";
				}if (!textField6.getText().equals("")) {
					sql=sql+"and 备注="
							+ "'"
							+ textField6.getText()+"'";
				}
				if (!textField7.getText().equals("")) {
					sql=sql+"and 密码="
							+ "'"
							+ textField7.getText()+"'";
				}
			}else if (!(radioButton01.isSelected()?radioButton01.getText():radioButton02.getText()).equals("")) {
				sql=sql+"where 性别="
						+ "'"
						+ (radioButton01.isSelected()?radioButton01.getText():radioButton02.getText())+"'";
				if (!textField4.getText().equals("")) {
					sql=sql+"and 管理楼号="
							+ "'"
							+ textField4.getText()+"'";
				}
				if (!textField5.getText().equals("")) {
					sql=sql+"and 联系方式="
							+ "'"
							+ textField5.getText()+"'";
				}if (!textField6.getText().equals("")) {
					sql=sql+"and 备注="
							+ "'"
							+ textField6.getText()+"'";
				}
				if (!textField7.getText().equals("")) {
					sql=sql+"and 密码="
							+ "'"
							+ textField7.getText()+"'";
				}
			}else if (!textField4.getText().equals("")) {
				sql=sql+"where 管理楼号="
						+ "'"
						+ textField4.getText()+"'";
				if (!textField5.getText().equals("")) {
					sql=sql+"and 联系方式="
							+ "'"
							+ textField5.getText()+"'";
				}if (!textField6.getText().equals("")) {
					sql=sql+"and 备注="
							+ "'"
							+ textField6.getText()+"'";
				}
				if (!textField7.getText().equals("")) {
					sql=sql+"and 密码="
							+ "'"
							+ textField7.getText()+"'";
				}
			}else if (!textField5.getText().equals("")) {
				sql=sql+"where 联系方式="
						+ "'"
						+ textField5.getText()+"'";
				if (!textField6.getText().equals("")) {
					sql=sql+"and 备注="
							+ "'"
							+ textField6.getText()+"'";
				}
				if (!textField7.getText().equals("")) {
					sql=sql+"and 密码="
							+ "'"
							+ textField7.getText()+"'";
				}
				
			}else if (!textField6.getText().equals("")) {
				sql=sql+"where 备注="
						+ "'"
						+ textField6.getText()+"'";
				if (!textField7.getText().equals("")) {
					sql=sql+"and 密码="
							+ "'"
							+ textField7.getText()+"'";
				}
			}else if (!textField7.getText().equals("")) {
				sql=sql+"where 密码="
						+ "'"
						+ textField7.getText()+"'";
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
			
		}else if (e.getSource()==button5) {            //清空
			clean();
		}else if (e.getSource()==button6) {            //刷新
			reFresh();
		}
		
	}
	public void clean() {
		textField1.setText("");
		textField2.setText("");
		textField4.setText("");
		textField5.setText("");
		textField6.setText("");
		textField7.setText("");
		
		radioButton01.setSelected(true);
		
	}
	
	
	
	public void reFresh() {
		String sql="select * from 宿舍管理员";
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
	public void defaultDisplay() {
		String sql="select * from 宿舍管理员";
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


}
