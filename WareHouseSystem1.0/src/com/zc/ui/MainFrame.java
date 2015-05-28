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







public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		setBounds(100, 100, 450, 300);
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
		
	}
}
