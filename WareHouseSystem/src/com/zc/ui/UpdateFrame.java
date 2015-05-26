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
import com.zc.model.Product;

public class UpdateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Product temp;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFrame frame = new UpdateFrame();
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
	public UpdateFrame(final Product temp ) {
		super("修改货品");
		this.temp=temp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7F16\u53F7");
		label.setBounds(45, 98, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8D27\u54C1");
		label_1.setBounds(45, 123, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5355\u4EF7");
		label_2.setBounds(45, 148, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u6570\u91CF");
		label_3.setBounds(45, 173, 54, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u603B\u4EF7");
		label_4.setBounds(45, 198, 54, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u6B22\u8FCE\u6765\u5230\u4FEE\u6539\u8D27\u54C1\u754C\u9762");
		label_5.setBounds(122, 22, 149, 15);
		contentPane.add(label_5);
		
		setTextField(new JTextField());
		
		
		
		getTextField().setBounds(109, 95, 149, 18);
		contentPane.add(getTextField());
		getTextField().setColumns(10);
		
				
				
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 120, 149, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(109, 145, 149, 18);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(109, 170, 149, 18);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(109, 195, 149, 18);
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
				
			    
				
				
		
		JButton button = new JButton("修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				
				String pname=textField_1.getText();
				String p=textField_2.getText();
				Double price=Double.parseDouble(p);
				String n=textField_3.getText();
				int num=Integer.parseInt(n);
				Double totalPrice=num*price;
			

				 
					
					
					
				temp.setNum(num);
				
				temp.setPrice(price);
				
				temp.setProductName(pname);
				temp.setTotalPrice(totalPrice);
				
				boolean flag1=ProductControl.getControl().update(temp);
				if(!flag1)
				{
					JOptionPane.showMessageDialog(null,"请重新输入!");
					return;
					
				}
				int m=JOptionPane.showConfirmDialog(null, "您确认要修改您的数据吗？");
				if(m==JOptionPane.CANCEL_OPTION){
					return;	
			
			
				}
			
				
					
					JOptionPane.showMessageDialog(null,"修改商品成功！");
								
				 
				
			
			
			}
		});
		button.setBounds(139, 229, 73, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			UpdateFrame.this.setVisible(false);
			MainFrame mf=new MainFrame();
			mf.setVisible(true);
			}
		});
		button_1.setBounds(233, 229, 73, 23);
		contentPane.add(button_1);
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

}
