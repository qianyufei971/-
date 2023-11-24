package 宿舍管理员;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class LeftJPanelofDormitoryAdministrator extends JPanel{
	
	//定义root节点
	DefaultMutableTreeNode root;
	//定义子节点
	DefaultMutableTreeNode node1;
	DefaultMutableTreeNode node2; 
	DefaultMutableTreeNode node3;
	DefaultMutableTreeNode node4;
	DefaultMutableTreeNode node5;
	DefaultMutableTreeNode node6;
	DefaultMutableTreeNode node7;
	DefaultMutableTreeNode node8;
	DefaultMutableTreeNode node9;
	DefaultMutableTreeNode node10;
	DefaultMutableTreeNode node11;
	DefaultMutableTreeNode node12;
	
	//定义孙子辈的节点
//	DefaultMutableTreeNode A1;
//	DefaultMutableTreeNode A2;
//	DefaultMutableTreeNode A3; 
//	DefaultMutableTreeNode A4; 
//	
//	
//	DefaultMutableTreeNode B1;
//	DefaultMutableTreeNode B2; 
//	DefaultMutableTreeNode B3; 
//	DefaultMutableTreeNode B4; 
	

	JTree tree;
	JScrollPane scrollPane;
	
	DefaultTreeCellRenderer render;
	
	public LeftJPanelofDormitoryAdministrator() {
		root= new DefaultMutableTreeNode("学生宿舍管理系统");
		tree=new JTree(root);//绑定root节点
		scrollPane= new JScrollPane(tree);
		
		render= new DefaultTreeCellRenderer();
		render.setFont(new Font("宋体", Font.BOLD|Font.ITALIC,15));
		render.setTextSelectionColor(Color.BLUE);
		tree.setCellRenderer(render);
		tree.setShowsRootHandles(true);
		
		node1= new DefaultMutableTreeNode("学生信息管理");
		node2= new DefaultMutableTreeNode("宿舍信息管理");
		node3= new DefaultMutableTreeNode("学生违纪信息管理");
		node4= new DefaultMutableTreeNode("来访信息管理");
		node5= new DefaultMutableTreeNode("个人信息查询");
		node6= new DefaultMutableTreeNode("欢迎");
		node7= new DefaultMutableTreeNode("关于系统");
		node8= new DefaultMutableTreeNode("检查更新");
		node9= new DefaultMutableTreeNode("提示和技巧");
		node10= new DefaultMutableTreeNode("帮助");
		node11= new DefaultMutableTreeNode("修改密码");
		node12= new DefaultMutableTreeNode("退出系统");
		
		
		//将子节点添加到root节点
		root.add(node1);
		root.add(node2);
		root.add(node3);
		root.add(node4);
		root.add(node5);
		root.add(node6);
		root.add(node7);
		root.add(node8);
		root.add(node9);
		root.add(node10);
		root.add(node11);
		root.add(node12);
		
		
		this.setLayout(new GridLayout(1,1));
		this.add(scrollPane); 
	}


}
