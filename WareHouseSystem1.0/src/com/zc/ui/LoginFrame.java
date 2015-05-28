package com.zc.ui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.zc.service.LoginService;




public class LoginFrame extends JFrame {

	private JPanel contentPane=null;
	private JPasswordField passwordField=null;
	private JComboBox comboBox=new JComboBox();
	//LoginService loginService=new LoginService();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	@SuppressWarnings("rawtypes")
	public LoginFrame() {
		super("用户登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
		lblNewLabel.setBounds(58, 96, 54, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(58, 136, 54, 24);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(113, 138, 203, 23);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 10, 54, 15);
		contentPane.add(label);
		
		JButton button = new JButton("\u767B\u5F55");
		button.setBounds(302, 229, 93, 23);
		contentPane.add(button);
		comboBox = new JComboBox();
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String id=(String)comboBox.getSelectedItem();
				String password=new String(passwordField.getPassword());
				boolean flag =LoginService.checkUser(id,password);
				if(!flag){
					JOptionPane.showMessageDialog(null, "请输入用户名和密码！");
				}
				
				boolean flag2=LoginService.isUser(id, password);
				if(!flag2){
					
					JOptionPane.showMessageDialog(null,"密码错误，请输入正确的密码！");
					}
			
				else{
					LoginFrame.this.setVisible(false);
					 MainFrame frame=new MainFrame();
					 
					frame.setVisible(true);
					 
				}	
		  }
		
		
		
		
		
		});
	
		
		
		Panel panel = new Panel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(0, 0, 434, 69);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("\u5C0A\u656C\u7684\u7528\u6237\uFF0C\u6B22\u8FCE\u6765\u5230\u4ED3\u5E93\u7BA1\u7406\u7CFB\u7EDF");
		panel.add(lblNewLabel_2);
		
		//JComboBox comboBox = new JComboBox();
		LoginService.readUser(comboBox);
		comboBox.setBounds(113, 98, 203, 23);
		contentPane.add(comboBox);
		
	}
}
