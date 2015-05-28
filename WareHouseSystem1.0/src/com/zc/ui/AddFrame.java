package com.zc.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.zc.control.ProductControl;

public class AddFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFrame frame = new AddFrame();
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
	public AddFrame() {
		super("增加货品界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u589E\u52A0\u8D27\u54C1");
		label.setBounds(151, 20, 54, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7");
		lblNewLabel.setBounds(39, 87, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D27\u54C1 ");
		lblNewLabel_1.setBounds(39, 112, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5355\u4EF7");
		lblNewLabel_2.setBounds(39, 137, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6570\u91CF");
		lblNewLabel_3.setBounds(39, 162, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u603B\u4EF7");
		lblNewLabel_4.setBounds(39, 187, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		
		textField.setBounds(115, 84, 166, 15);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		
		textField_1.setBounds(115, 112, 166, 15);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		
		textField_2.setBounds(115, 137, 166, 15);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		
		
		
		textField_3.setBounds(115, 162, 166, 15);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		
		textField_4.setBounds(115, 190, 166, 15);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
		  textField_4.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				/*String pid=textField.getText();
				String pname=textField_1.getText();*/
				String s=textField_2.getText();
				Double price=Double.parseDouble(s);
				
				
				String n=textField_3.getText();
				int num=Integer.parseInt(n);
				Double totalPrice=num*price;
				String t=String.valueOf(totalPrice);
							
				textField_4.setText(t);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
			  
			  
		  });
			
		    
			
			
			
			
				
				
				
		
		JButton button = new JButton("\u589E\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pid=textField.getText();
				String pname=textField_1.getText();
				String s=textField_2.getText();
				Double price=Double.parseDouble(s);
				
				
				String n=textField_3.getText();
				int num=Integer.parseInt(n);
				Double totalPrice=num*price;
			
					
				boolean flag1=ProductControl.getControl().saveProduct(pid,pname,price,num,totalPrice);
				if(!flag1)
				{
					JOptionPane.showMessageDialog(null,"您输入的商品编号已存在,请重新输入!");
					return;
					
				}
				else{
					
					JOptionPane.showMessageDialog(null,"增加商品成功！");
				}
				
				
				
				
			}
		});
		button.setBounds(197, 229, 64, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFrame.this.setVisible(false);
				MainFrame mf=new MainFrame();
				mf.setVisible(true);
				
				
			}
		});
		button_1.setBounds(279, 229, 64, 23);
		contentPane.add(button_1);
	}
}
