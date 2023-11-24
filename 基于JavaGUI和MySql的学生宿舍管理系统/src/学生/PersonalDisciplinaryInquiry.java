package 学生;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import 基于JavaGUI和MySql的学生宿舍管理系统.GetDBConnect;

public class PersonalDisciplinaryInquiry extends JPanel implements ActionListener{
	
	
	DefaultTableModel tModel;
	JTable table;
	String columnname[];
	String record[][];
	
	JButton button1,button2;
	JSplitPane jSplitPane;
	JPanel p1,p2;
	
	String number;
	
	public PersonalDisciplinaryInquiry(String number) {
		
		this.number=number;
		p1=new JPanel();
		p2=new JPanel();

		
		button1=new JButton("刷新");
		button2=new JButton("退出");
		button1.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));
		button2.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));
		button1.addActionListener(this);
		button2.addActionListener(this);
		
        Connection con=GetDBConnect.connectDB("学生宿舍管理系统","root","123456");//连接代码
        String sql="select * from 学生违纪 where 学号='"
        		+ number+"'";
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
	    
	    
	    
	    
		 // 创建一个表格，指定 所有行数据 和 表头
        table = new JTable(tModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFont(new Font("宋体",Font.BOLD,15));
        table.getTableHeader().setFont(new Font("宋体",Font.BOLD,15));
        JScrollPane scrollPane=new JScrollPane(table);
        p1.setLayout(new BorderLayout());
        p1.add(scrollPane);
        
        
        Box hBox=Box.createHorizontalBox();
        hBox.add(button1);
        hBox.add(Box.createHorizontalStrut(50));
        hBox.add(button2);
        
        p2.add(hBox);
        
        
        jSplitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		jSplitPane.setTopComponent(p1);
		jSplitPane.setBottomComponent(p2);
		jSplitPane.setDividerLocation(450);
		jSplitPane.setContinuousLayout(true);// 设置拖动分隔条时是否连续重绘组件
		this.setLayout(new BorderLayout()); 
		this.add(jSplitPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource()==button1) {
			Connection con=GetDBConnect.connectDB("学生宿舍管理系统","root","123456");//连接代码
	        String sql="select * from 学生违纪 where 学号='"
	        		+ this.number+"'";
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
		}else if (e.getSource()==button2) {
			
			int n = JOptionPane.showConfirmDialog(this, "你确定要退出码？", "",JOptionPane.YES_NO_OPTION); 
			if (n==JOptionPane.YES_OPTION) {
				System.exit(0);
			}else {
				
			}
		}
		
	}

}
