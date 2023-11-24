package 系统管理员;

import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import 基于JavaGUI和MySql的学生宿舍管理系统.GetDBConnect;

public class DormitoryManagementInterface extends JPanel implements ActionListener,MouseListener{
	Connection con=GetDBConnect.connectDB("学生宿舍管理系统","root","123456");//连接代码
	
	JSplitPane jSplitPane1,jSplitPane2;
	JPanel p1,p2,p3;
	JButton button1,button2,button3,button4,button5,button6;
	JLabel label1,label2,label3;
	JTextField textField1,textField2,textField3;
	
	DefaultTableModel tModel;
	JTable table;
	String columnname[];
	String record[][];
	
	public DormitoryManagementInterface() {
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
		
		
		Box hBox1=Box.createHorizontalBox();
		hBox1.add(button1);
		hBox1.add(Box.createHorizontalStrut(50));
		hBox1.add(button2);
		hBox1.add(Box.createHorizontalStrut(50));
		hBox1.add(button3);
		hBox1.add(Box.createHorizontalStrut(50));
		hBox1.add(button4);
		hBox1.add(Box.createHorizontalStrut(50));
		hBox1.add(button5);
		hBox1.add(Box.createHorizontalStrut(50));
		hBox1.add(button6);
		
		p3.add(hBox1);
		
		label1=new JLabel("楼 号  ");
		label2=new JLabel("宿舍号  ");
		label3=new JLabel("类 型  ");
		
		
		label1.setFont(new Font("宋体",Font.BOLD,15));
		label2.setFont(new Font("宋体",Font.BOLD,15));
		label3.setFont(new Font("宋体",Font.BOLD,15));
		
		
		textField1=new JTextField(15);
		textField2=new JTextField(15);
		textField3=new JTextField(15);
		
		
		textField1.setFont(new Font("宋体",Font.BOLD,15));
		textField2.setFont(new Font("宋体",Font.BOLD,15));
		textField3.setFont(new Font("宋体",Font.BOLD,15));
		
		Box hBox2=Box.createHorizontalBox();
		Box vBox=Box.createVerticalBox();
		
		hBox2.add(label1);
		hBox2.add(textField1);
		hBox2.add(Box.createHorizontalStrut(30));
		hBox2.add(label2);
		hBox2.add(textField2);
		hBox2.add(Box.createHorizontalStrut(30));
		hBox2.add(label3);
		hBox2.add(textField3);
		hBox2.add(Box.createHorizontalStrut(30));
		
		vBox.add(Box.createVerticalStrut(50));
		vBox.add(hBox2);
		
		p1.add(vBox);
		
		
		defaultDisplay();
		
        // 创建一个表格，指定 所有行数据 和 表头
        table = new JTable(tModel);
        table.addMouseListener(this);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFont(new Font("宋体",Font.BOLD,15));
        table.getTableHeader().setFont(new Font("宋体",Font.BOLD,15));
        JScrollPane scrollPane=new JScrollPane(table);
        p2.setLayout(new BorderLayout());
        p2.add(scrollPane);
		
		jSplitPane1=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		jSplitPane2=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		jSplitPane1.setTopComponent(p1);
		jSplitPane1.setBottomComponent(jSplitPane2);
		jSplitPane2.setTopComponent(p2);
		jSplitPane2.setBottomComponent(p3);
		jSplitPane1.setDividerLocation(150);
		jSplitPane1.setContinuousLayout(true);// 设置拖动分隔条时是否连续重绘组件
		jSplitPane2.setDividerLocation(450);
		jSplitPane2.setContinuousLayout(true);// 设置拖动分隔条时是否连续重绘组件
		this.setLayout(new BorderLayout()); 
		this.add(jSplitPane1);
	}
	
	
	
	public void defaultDisplay() {
		String sql="select * from 宿舍";
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



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource()==button1) {
			PreparedStatement preSql;
			String sqlString="insert into 宿舍(楼号,宿舍号,类型) values(?,?,?)";
			try {
				preSql = con.prepareStatement(sqlString);
				preSql.setString(1,textField1.getText());
				preSql.setString(2, textField2.getText());
				preSql.setString(3, textField3.getText());
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
			
		}else if (e.getSource()==button2) {
			
			int index = table.getSelectedRow();//获取选中的行
			if(index<0)
			{
				JOptionPane.showMessageDialog(this,"请选择你要删除的内容！！！","警告",JOptionPane.WARNING_MESSAGE);
			}
			else {
				String m= table.getValueAt(index, 0).toString();
				String n= table.getValueAt(index, 1).toString();
				try {
					String sql="delete from 宿舍 where 楼号='"
							+ m+"'"
									+ "and 宿舍号='"
									+n+"'" ;
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
			String sqlString="update 宿舍 set 类型=? where 楼号=? and 宿舍号=?";
			try {
				preSql = con.prepareStatement(sqlString);
				preSql.setString(1,textField3.getText());
				preSql.setString(2,textField1.getText());
				preSql.setString(3,textField2.getText());
				if(preSql.executeUpdate()>0)
				{
					JOptionPane.showMessageDialog(this,"学生信息修改成功！！！","恭喜 ",JOptionPane.PLAIN_MESSAGE);
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
			
			
		}else if (e.getSource()==button4) {          //查询
			String sql="select * from 宿舍 ";
			if(!textField1.getText().trim().equals("")) {
				sql=sql+"where 楼号="
						+ "'"
						+ textField1.getText().trim()+"'";
				if (!textField2.getText().trim().equals("")) {
					sql=sql+"and 宿舍号="
							+ "'"
							+ textField2.getText().trim()+"'";
				}
				if (!textField3.getText().trim().equals("")) {
					sql=sql+"and 类型="
							+ "'"
							+ textField3.getText().trim()+"'";
				}
			}else if (!textField2.getText().trim().equals("")) {
				sql=sql+"where 宿舍号="
						+ "'"
						+ textField2.getText().trim()+"'";
				if (!textField3.getText().trim().equals("")) {
					sql=sql+"and 类型="
							+ "'"
							+ textField3.getText().trim()+"'";
				}
			}else if (!textField3.getText().trim().equals("")) {
				sql=sql+"where 类型="
						+ "'"
						+ textField3.getText().trim()+"'";
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
			
		}else if (e.getSource()==button5) {          //清空
			clean();
			
		}else if (e.getSource()==button6) {          //刷新
			reFresh();
		}
		
	}
	
	
	public void reFresh() {
		String sql="select * from 宿舍";
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
		textField3.setText("");
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
		
		
		textField1.setText(a);
		textField2.setText(c);
		textField3.setText(d);
		
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
