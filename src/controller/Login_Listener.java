package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.LoginJFrame;
import view.Trangchu;

public class Login_Listener implements ActionListener {
	private LoginJFrame lgjf;
	
	 
	public Login_Listener(LoginJFrame lgjf) {
		this.lgjf = lgjf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 try {
			 String username = lgjf.usernametextField.getText();
			 String password = String.valueOf(lgjf.passwordField.getPassword());
			 String actionCommand = e.getActionCommand(); 
			    // Replace this with your authentication logic
			    if (actionCommand.equals("Đăng nhập")) {
			    	if(username.isEmpty() || password.isEmpty()){
			    		JOptionPane.showMessageDialog(null, "Vui lòng nhập tên đăng nhập và mật khẩu");
			    	}		   
			    	if (username.equals("nhanvien") && password.equals("thietbi")) {
			           new Trangchu();
			           lgjf.dispose();
			        } else {
			        	JOptionPane.showMessageDialog(lgjf, "Đăng nhập thất bại","Lỗi",JOptionPane.ERROR_MESSAGE);
			        }
			    }else if(actionCommand.equals("Thoát")) {
			    	lgjf.dispose();
			    }
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
