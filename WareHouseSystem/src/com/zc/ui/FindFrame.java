package com.zc.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.zc.model.Product;
import com.zc.service.ProductService;


public class FindFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Product temp=null;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindFrame frame = new FindFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public FindFrame(Product temp) {
		super("货品查询'");
		this.temp=temp;
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"\u4EA7\u54C1\u7F16\u53F7", "\u4EA7\u54C1\u540D\u79F0", "\u4EA7\u54C1\u5355\u4EF7", "\u4EA7\u54C1\u6570\u91CF", "\u4EA7\u54C1\u603B\u4EF7"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(78);
		table.getColumnModel().getColumn(0).setMinWidth(18);
		table.getColumnModel().getColumn(0).setMaxWidth(2147483646);
		scrollPane.setViewportView(table);
		ProductService.readFindQuery(table, temp);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindFrame.this.setVisible(false);
				MainFrame mf=new MainFrame();
				mf.setVisible(true);
				 
				
			}
		});
		btnNewButton.setBounds(262, 235, 110, 23);
		contentPane.add(btnNewButton);
	}
}
