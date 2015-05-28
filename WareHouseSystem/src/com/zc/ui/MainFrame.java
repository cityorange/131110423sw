package com.zc.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.zc.control.ProductControl;
import com.zc.model.Product;
import com.zc.service.ProductService;
import javax.swing.JLabel;
import javax.swing.JTextField;







public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		super("货品管理界面'");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 435,225);
		contentPane.add(tabbedPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane_1.addTab("存货表", null, scrollPane, null);
		
		table = new JTable();
		
		List<?> product1=ProductControl.getControl().getProductAll();
		int size=product1.size();
		table.setModel(new DefaultTableModel(
				
			new String[] {
				"\u4EA7\u54C1\u7F16\u53F7", "\u4EA7\u54C1\u540D\u79F0", "\u4EA7\u54C1\u5355\u4EF7", "\u4EA7\u54C1\u6570\u91CF", "\u4EA7\u54C1\u603B\u4EF7"
			},size
		));
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(78);
		table.getColumnModel().getColumn(0).setMinWidth(18);
		table.getColumnModel().getColumn(0).setMaxWidth(2147483646);
		scrollPane.setViewportView(table);
		ProductService.readProduct(table);
		JButton button = new JButton("添加商品");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				MainFrame.this.setVisible(false);
				AddFrame addFrame=new AddFrame();
				addFrame.setVisible(true);
			}
		});
		button.setBounds(73, 235, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("修改货品");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				int i=table.getSelectedRow();
				if(i==-1){
					
					JOptionPane.showMessageDialog(null, "请选中表格！");
					return;
				
				
				}
				ProductService.update(i);
				MainFrame.this.setVisible(false);
				UpdateFrame updateFrame=new UpdateFrame(ProductService.update(i));
				updateFrame.setVisible(true);
				Product temp=ProductService.update(i);
				
				updateFrame.getTextField().setText(String.valueOf(temp.getPid()));
				
				
				
				
				
				
				
				
			}
		});
		button_1.setBounds(176, 235, 93, 23);
		contentPane.add(button_1);
		
		JButton btnNewButton = new JButton("删除货品");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				
				int i=table.getSelectedRow();
				if(i==-1){
					
					JOptionPane.showMessageDialog(null, "请选中表格！");
					return;
				}		
				
				
				
						
				boolean flag=ProductService.deleteProduct(i);
				int m=JOptionPane.showConfirmDialog(null, "您确认要删除您的数据吗？");
				ProductService.readProduct(table);
				if(!flag){
					
					JOptionPane.showMessageDialog(null, "出错啦！");
					return;
				}
				
				else if(m==JOptionPane.CANCEL_OPTION){
					
					return;
				}
				else{
					MainFrame.this.setVisible(false);
			   MainFrame a=new MainFrame();
			   a.setVisible(true);
				}
			    
			
			}
			
			
			
		});
		btnNewButton.setBounds(279, 235, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("\u6309\u4EA7\u54C1\u7F16\u53F7\u67E5\u627E");
		label.setBounds(73, 291, 93, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(176, 287, 108, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u6309\u4EA7\u54C1\u540D\u79F0\u67E5\u627E");
		lblNewLabel.setBounds(73, 324, 93, 15);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 320, 108, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4E00\u952E\u67E5\u627E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Product temp=null;
				String id=textField.getText();
				String pname=textField_1.getText();
				
				/*boolean flag=ProductControl.getControl().findByID(id);
				boolean flag1=ProductControl.getControl().findByPName(pname);
				 if(!flag){
					 
					 JOptionPane.showMessageDialog(null,"没有查到相关的商品！请确认产品编号是否正确！");
				 }
				 else if(!flag1){
					 
					 JOptionPane.showMessageDialog(null,"没有查到相关的商品！请确认产品名称是否正确！");
				 }
				 else */
				
				
				
				
				
				
				
				
				
				if(!"".equals(textField.getText())&&"".equals(textField_1.getText()))
				   
					
					
				  
				{	
					temp=ProductControl.getControl().findById(id);
						MainFrame.this.setVisible(false);
						FindFrame f=new FindFrame(temp);
						f.setVisible(true);
						
				    }
				 else if("".equals(textField.getText())&&!"".equals(textField_1.getText()))
				 {
						
						
					    List<?> t=ProductControl.getControl().findByPname(pname);
					    temp=(Product)t.get(0);
					    MainFrame.this.setVisible(false);
						FindFrame f=new FindFrame(temp);
						f.setVisible(true);
						
						
					}
					
				 else if("".equals(textField.getText())&&"".equals(textField_1.getText()))
					{
						JOptionPane.showMessageDialog(null,"请输入内容！");
						
						
					}
					
					
					else if(!"".equals(textField.getText())&&!"".equals(textField_1.getText()))
					{
						JOptionPane.showMessageDialog(null,"只能按照其中的一项进行输入，请重新输入！");
					
					}
					
				
			}
		});
		btnNewButton_1.setBounds(320, 287, 93, 48);
		contentPane.add(btnNewButton_1);
		
	}
}
