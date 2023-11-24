package 系统管理员;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.AbstractCellEditor;
import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.AttributeSet.ColorAttribute;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import 基于JavaGUI和MySql的学生宿舍管理系统.GetDBConnect;

public class DormitoryAdministratorPermissionManagementInterface extends JPanel implements ActionListener,MouseListener{
	JButton button1,button2;
	
	JSplitPane jSplitPane;
	JPanel p1,p2;
	
	DefaultTableModel tModel;
	JTable table;
	String columnname[];
	Object record[][];
	static String number;
	public DormitoryAdministratorPermissionManagementInterface() {
		button1=new JButton("刷新");
		button2=new JButton("退出");
		
		p1=new JPanel();
		p2=new JPanel();
		
		
		button1.setFont(new Font("宋体",Font.BOLD,15));
		button2.setFont(new Font("宋体",Font.BOLD,15));
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		Box hBox=Box.createHorizontalBox();
		hBox.add(button1);
		hBox.add(Box.createHorizontalStrut(50));
		hBox.add(button2);
		
		p2.add(hBox);
		
		defaultdisplay();
		
		
		// 创建一个表格，指定 所有行数据 和 表头
        table = new JTable(tModel);
        table.getColumnModel().getColumn(4).setCellEditor(new CheckBoxCellEditor());
        table.getColumnModel().getColumn(4).setCellRenderer(new CWCheckBoxRenderer());
		table.setRowHeight(50);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFont(new Font("宋体",Font.BOLD,15));
        table.getTableHeader().setFont(new Font("宋体",Font.BOLD,15));
        table.addMouseListener(this);
        JScrollPane scrollPane=new JScrollPane(table);
        p1.setLayout(new BorderLayout());
        p1.add(scrollPane);
        
        
        jSplitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        jSplitPane.setTopComponent(p1);
		jSplitPane.setBottomComponent(p2);
		jSplitPane.setDividerLocation(600);
		jSplitPane.setContinuousLayout(true);// 设置拖动分隔条时是否连续重绘组件
		this.setLayout(new BorderLayout()); 
		this.add(jSplitPane);

	}

	public void defaultdisplay() {
		// TODO 自动生成的方法存根
		Connection con=GetDBConnect.connectDB("学生宿舍管理系统","root","123456");//连接代码
		String sql="select * from 宿舍管理员";
		Statement statement=null;
		ResultSet rs=null;
		try {
			statement=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=statement.executeQuery(sql);
			ResultSetMetaData metaData=(ResultSetMetaData) rs.getMetaData();
			int columncount=5;//设置字段数目
			columnname=new String[columncount];
			for(int i=1;i<=columncount-1;i++)
			{
				columnname[i-1]=metaData.getColumnName(i);//将字段名称添加到数组中
			}
			columnname[4]="管理权限";
			rs.last();
			int recordcount =rs.getRow();
			record=new Object[recordcount][columncount];
			rs.beforeFirst();
			int m=0;
			while(rs.next())//设置每一行数据
			{
				for(int j=1;j<=columncount-1;j++)
				{
					record[m][j-1]=rs.getString(j);
				}
				m++;
			}
			rs.beforeFirst();
			int i=0;
			while(rs.next())//设置每一行数据
			{
				if (rs.getString(8).equals("有")) {
					record[i][4]=new Boolean(true);
				}else {
					record[i][4]=(Object)new Boolean(false);
				}
				i++;
			}
			con.close();
		}catch(Exception e)
		{e.printStackTrace();}
	    tModel = new DefaultTableModel(record,columnname); 
	}
	
	
	
	public void reFresh() {
		Connection con=GetDBConnect.connectDB("学生宿舍管理系统","root","123456");//连接代码
		String sql="select * from 宿舍管理员";
		Statement statement=null;
		ResultSet rs=null;
		try {
			statement=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=statement.executeQuery(sql);
			ResultSetMetaData metaData=(ResultSetMetaData) rs.getMetaData();
			int columncount=5;//设置字段数目
			columnname=new String[columncount];
			for(int i=1;i<=columncount-1;i++)
			{
				columnname[i-1]=metaData.getColumnName(i);//将字段名称添加到数组中
			}
			columnname[4]="管理权限";
			rs.last();
			int recordcount =rs.getRow();
			record=new Object[recordcount][columncount];
			rs.beforeFirst();
			int m=0;
			while(rs.next())//设置每一行数据
			{
				for(int j=1;j<=columncount-1;j++)
				{
					record[m][j-1]=rs.getString(j);
				}
				m++;
			}
			rs.beforeFirst();
			int i=0;
			while(rs.next())//设置每一行数据
			{
				if (rs.getString(8).equals("有")) {
					record[i][4]=new Boolean(true);
				}else {
					record[i][4]=(Object)new Boolean(false);
				}
				i++;
			}
			con.close();
		}catch(Exception e)
		{e.printStackTrace();}
		tModel.setDataVector(record,columnname);
        table.getColumnModel().getColumn(4).setCellEditor(new CheckBoxCellEditor());
        table.getColumnModel().getColumn(4).setCellRenderer(new CWCheckBoxRenderer());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==table) 
		{
		int index = table.getSelectedRow();//获取选中的行
		System.out.println(index);
		this.number=table.getValueAt(index,0).toString();
		
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
			reFresh();
		}else if (e.getSource()==button2) {
			int n = JOptionPane.showConfirmDialog(this, "你确定要退出码？", "",JOptionPane.YES_NO_OPTION); 
			if (n==JOptionPane.YES_OPTION) {
				System.exit(0);
			}else {
				
			}
		}
		
	}

}




//编辑器
class CheckBoxCellEditor extends AbstractCellEditor implements TableCellEditor {
	private static final long serialVersionUID = 1L;
	protected JCheckBox checkBox;

	public CheckBoxCellEditor() {
		checkBox = new JCheckBox();
		checkBox.setHorizontalAlignment(SwingConstants.CENTER);		
		checkBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				PreparedStatement preSql;
				String sqlString="update 宿舍管理员 set 管理权限=? where 编号=?";
				Connection con=GetDBConnect.connectDB("学生宿舍管理系统","root","123456");//连接代码
				try {
					preSql = con.prepareStatement(sqlString);
					preSql.setString(1,checkBox.isSelected()?"有":"无");
					preSql.setString(2,DormitoryAdministratorPermissionManagementInterface.number);
					if(preSql.executeUpdate()>0)
					{
						System.out.println("权限修改成功");
					}
					else {
						System.out.println("权限修改失败");
					}
					con.close();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
			
		});
	}

	@Override
	public Object getCellEditorValue() {
		return Boolean.valueOf(checkBox.isSelected());
	}

	@Override
	public JComponent getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		checkBox.setSelected(((Boolean) value).booleanValue());
		return checkBox;
	}
}



//渲染器
class CWCheckBoxRenderer extends JCheckBox implements TableCellRenderer {
	private static final long serialVersionUID = 1L;
	Border border = new EmptyBorder(1, 2, 1, 2);
	
	public CWCheckBoxRenderer() {
		super();
		setOpaque(true);
		setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	@Override
	public JComponent getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if (value instanceof Boolean) {
			setSelected(((Boolean) value).booleanValue());
			// setEnabled(table.isCellEditable(row, column));
			setForeground(table.getForeground());
			setBackground(table.getBackground());
		}
		return this;
	}
}

