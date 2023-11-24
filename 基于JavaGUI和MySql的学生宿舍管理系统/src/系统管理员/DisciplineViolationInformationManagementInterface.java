package 系统管理员;

import java.util.Date;
import java.util.Locale;
import java.awt.*;
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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.eltima.components.ui.DatePicker;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import 基于JavaGUI和MySql的学生宿舍管理系统.GetDBConnect;

public class DisciplineViolationInformationManagementInterface extends JPanel implements ActionListener,MouseListener{
	Connection con=GetDBConnect.connectDB("学生宿舍管理系统","root","123456");//连接代码
	
	DatePicker datepick;
	JSplitPane jSplitPane1,jSplitPane2;
	JPanel p1,p2,p3;
	JButton button1,button2,button3,button4,button5,button6;
	JLabel label1,label2,label3,label4,label5,label6;
	JTextField textField1,textField2,textField3,textField4,textField5;
	
	
	DefaultTableModel tModel;
	JTable table;
	String columnname[];
	String record[][];
	
 	public DisciplineViolationInformationManagementInterface() {
 		
 		datepick= this.getDatePicker();
 		
 		
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
		
		label1=new JLabel("学  号");
		label2=new JLabel("姓  名");
		label3=new JLabel("学  院");
		label4=new JLabel("班  级");
		label5=new JLabel("违纪描述");
		label6=new JLabel("登记日期");
		
		label1.setFont(new Font("宋体",Font.BOLD,15));
		label2.setFont(new Font("宋体",Font.BOLD,15));
		label3.setFont(new Font("宋体",Font.BOLD,15));
		label4.setFont(new Font("宋体",Font.BOLD,15));
		label5.setFont(new Font("宋体",Font.BOLD,15));
		label6.setFont(new Font("宋体",Font.BOLD,15));
		
		textField1=new JTextField(15);
		textField2=new JTextField(15);
		textField3=new JTextField(15);
		textField4=new JTextField(15);
		textField5=new JTextField(15);
		
		
		textField1.setFont(new Font("宋体",Font.BOLD,15));
		textField2.setFont(new Font("宋体",Font.BOLD,15));
		textField3.setFont(new Font("宋体",Font.BOLD,15));
		textField4.setFont(new Font("宋体",Font.BOLD,15));
		textField5.setFont(new Font("宋体",Font.BOLD,15));
		
		textField1.setHorizontalAlignment(JTextField.CENTER);
		textField2.setHorizontalAlignment(JTextField.CENTER);
		textField3.setHorizontalAlignment(JTextField.CENTER);
		textField4.setHorizontalAlignment(JTextField.CENTER);
		textField5.setHorizontalAlignment(JTextField.CENTER);
		
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
		
		hBox1.add(label1);
		hBox2.add(label2);
		hBox3.add(label3);
		hBox4.add(label4);
		hBox5.add(label5);
		hBox6.add(label6);
		
		
		Box vBox=Box.createVerticalBox();
		vBox.add(hBox1);
		vBox.add(textField1);
		vBox.add(Box.createVerticalStrut(60));
		vBox.add(hBox2);
		vBox.add(textField2);
		vBox.add(Box.createVerticalStrut(60));
		vBox.add(hBox3);
		vBox.add(textField3);
		vBox.add(Box.createVerticalStrut(60));
		vBox.add(hBox4);
		vBox.add(textField4);
		vBox.add(Box.createVerticalStrut(60));
		vBox.add(hBox5);
		vBox.add(textField5);
		vBox.add(Box.createVerticalStrut(60));
		vBox.add(hBox6);
		vBox.add(datepick);
		
		datepick.getInnerTextField().setHorizontalAlignment(JTextField.CENTER);
		
		p2.add(vBox);
		p3.add(hBox);
		
		defaultdisplay();
		
		
		// 创建一个表格，指定 所有行数据 和 表头
        table = new JTable(tModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFont(new Font("宋体",Font.BOLD,15));
        table.getTableHeader().setFont(new Font("宋体",Font.BOLD,15));
        table.addMouseListener(this);
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
 	
 	
 	public void defaultdisplay() {
		String sql="select * from 学生违纪";
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
 	
 	
 	private DatePicker getDatePicker() {
        DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("宋体",Font.BOLD,15);

        Dimension dimension = new Dimension(177, 24);

        int[] hilightDays = { 1, 3, 5, 7 };

        int[] disabledDays = { 4, 6, 5, 9 };
        
        //构造方法（初始时间，时间显示格式，字体，控件大小）
        datepick = new DatePicker(date, DefaultFormat, font, dimension);
        // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CHINA);
        // 设置时钟面板可见
        datepick.setTimePanleVisible(true);
        return datepick;
    }

 	
 	
 	public void reFresh() {
		String sql="select * from 学生违纪";
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
		textField4.setText("");
		textField5.setText("");
//		Date date = new Date();
//		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		datepick.getInnerTextField().setText("");
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==table) 
		{
		int index = table.getSelectedRow();//获取选中的行
		String a=table.getValueAt(index, 1).toString();
		String c=table.getValueAt(index, 2).toString();
		String d=table.getValueAt(index, 3).toString();
		String f=table.getValueAt(index, 4).toString();
		String g=table.getValueAt(index, 5).toString();
		String h=table.getValueAt(index, 6).toString();

		
		
		
		textField1.setText(a);
		textField2.setText(c);
		textField3.setText(d);
		textField4.setText(f);
		textField5.setText(g);
		datepick.getInnerTextField().setText(h);
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
		if (e.getSource()==button1) {
			PreparedStatement preSql;
			String sqlString="insert into 学生违纪(学号,姓名,学院,班级,违纪描述,登记日期) values(?,?,?,?,?,?)";
			try {
				preSql = con.prepareStatement(sqlString);
				preSql.setString(1, textField1.getText());
				preSql.setString(2, textField2.getText());
				preSql.setString(3, textField3.getText());
				preSql.setString(4, textField4.getText());
				preSql.setString(5, textField5.getText());
				preSql.setString(6, datepick.getInnerTextField().getText());
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
				int m=Integer.parseInt(table.getValueAt(index, 0).toString());
				try {
					String sql="delete from 学生违纪 where 编号="
							+ m;
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
			String sqlString="update 学生违纪 set 学号=?,姓名=?,学院=?,班级=?,违纪描述=?,登记日期=? where 编号=?";
			try {
				preSql = con.prepareStatement(sqlString);
				
				int m= Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				
				preSql.setString(1, textField1.getText());
				preSql.setString(2, textField2.getText());
				preSql.setString(3, textField3.getText());
				preSql.setString(4, textField4.getText());
				preSql.setString(5, textField5.getText());
				preSql.setString(6, datepick.getInnerTextField().getText());
				preSql.setInt(7, m);
				if(preSql.executeUpdate()>0)
				{
					JOptionPane.showMessageDialog(this,"学生违纪信息修改成功！！！","恭喜",JOptionPane.PLAIN_MESSAGE);
					clean();
				}
				else {
					JOptionPane.showMessageDialog(this,"学生违纪信息修改失败！！！","警告",JOptionPane.WARNING_MESSAGE);
				}
			}catch(Exception e1)
			{
				JOptionPane.showMessageDialog(this,"学生违纪信息修改失败！！！","警告",JOptionPane.WARNING_MESSAGE);
				System.out.println(e1);
			}
			reFresh();
			
		}else if (e.getSource()==button4) {
			String sql="select * from 学生违纪 ";
			if (!textField1.getText().trim().equals("")) {
				sql=sql+"where 学号="
						+ "'"
						+ textField1.getText()+"'";
				if (!textField2.getText().trim().equals("")) {
					sql=sql+"and 姓名="
							+ "'"
							+ textField2.getText()+"'";
				}
				if (!textField3.getText().trim().equals("")) {
					sql=sql+"and 学院="
							+ "'"
							+ textField3.getText().trim()+"'";
				}
				if (!textField4.getText().equals("")) {
					sql=sql+"and 班级="
							+ "'"
							+ textField4.getText().trim()+"'";
				}
				if (!textField5.getText().equals("")) {
					sql=sql+"and 违纪描述="
							+ "'"
							+ textField5.getText().trim()+"'";
				}
				if (!datepick.getInnerTextField().getText().equals("")) {
					sql=sql+"and 登记日期="
							+ "'"
							+ datepick.getInnerTextField().getText().trim()+"'";
				}
			}else if (!textField2.getText().equals("")) {
				sql=sql+"where 姓名="
						+ "'"
						+ textField2.getText()+"'";
				if (!textField3.getText().trim().equals("")) {
					sql=sql+"and 学院="
							+ "'"
							+ textField3.getText().trim()+"'";
				}
				if (!textField4.getText().equals("")) {
					sql=sql+"and 班级="
							+ "'"
							+ textField4.getText().trim()+"'";
				}
				if (!textField5.getText().equals("")) {
					sql=sql+"and 违纪描述="
							+ "'"
							+ textField5.getText().trim()+"'";
				}
				if (!datepick.getInnerTextField().getText().equals("")) {
					sql=sql+"and 登记日期="
							+ "'"
							+ datepick.getInnerTextField().getText().trim()+"'";
				}
			}else if (!textField3.getText().equals("")) {
				sql=sql+"where 学院="
						+ "'"
						+ textField3.getText().trim()+"'";
				if (!textField4.getText().equals("")) {
					sql=sql+"and 班级="
							+ "'"
							+ textField4.getText().trim()+"'";
				}
				if (!textField5.getText().equals("")) {
					sql=sql+"and 违纪描述="
							+ "'"
							+ textField5.getText().trim()+"'";
				}
				if (!datepick.getInnerTextField().getText().equals("")) {
					sql=sql+"and 登记日期="
							+ "'"
							+ datepick.getInnerTextField().getText().trim()+"'";
				}
			}else if (!textField4.getText().equals("")) {
				sql=sql+"where 班级="
						+ "'"
						+ textField4.getText()+"'";
				if (!textField5.getText().equals("")) {
					sql=sql+"and 违纪描述="
							+ "'"
							+ textField5.getText().trim()+"'";
				}
				if (!datepick.getInnerTextField().getText().equals("")) {
					sql=sql+"and 登记日期="
							+ "'"
							+ datepick.getInnerTextField().getText().trim()+"'";
				}
			}else if (!textField5.getText().equals("")) {
				sql=sql+"where 违纪描述="
						+ "'"
						+ textField5.getText()+"'";
				if (!datepick.getInnerTextField().getText().equals("")) {
					sql=sql+"and 登记日期="
							+ "'"
							+ datepick.getInnerTextField().getText().trim()+"'";
				}
				
			}else if (!datepick.getInnerTextField().getText().equals("")) {
				sql=sql+"where 登记日期="
						+ "'"
						+ datepick.getInnerTextField().getText().trim()+"'";
				
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

}
