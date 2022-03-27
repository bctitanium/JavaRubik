package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import BLL.AccountBLL;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import DTO.Account;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class PanelChangePassword extends JPanel 
{
	public Account accDTO;
	
	private AccountBLL accBLL;
	
	private JPasswordField txtPass;
	private JPasswordField txtPassC;
	private JPasswordField txtCurrentPass;
	private JButton btnChangePass;

	/**
	 * Create the panel.
	 */
	public PanelChangePassword() 
	{
		setBackground(new Color(0, 0, 153));
		setLayout(null);
		setSize(1164,683);
		
		accDTO = new Account();
		accBLL = new AccountBLL();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(10, 11, 1144, 661);
		add(panel);
		panel.setLayout(null);
		
		JLabel lbChangePass = new JLabel("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		lbChangePass.setBounds(10, 11, 1124, 31);
		panel.add(lbChangePass);
		lbChangePass.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbChangePass.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbPassword = new JLabel("Mật khẩu mới:");
		lbPassword.setBounds(424, 132, 94, 19);
		panel.add(lbPassword);
		lbPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtPass = new JPasswordField();
		txtPass.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				DoiMatKhau();
			}
		});
		txtPass.setBounds(528, 131, 162, 20);
		panel.add(txtPass);
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lbPasswordC = new JLabel("Xác nhận mật khẩu mới:");
		lbPasswordC.setBounds(356, 183, 162, 17);
		panel.add(lbPasswordC);
		lbPasswordC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtPassC = new JPasswordField();
		txtPassC.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				DoiMatKhau();
			}
		});
		txtPassC.setBounds(528, 181, 162, 20);
		panel.add(txtPassC);
		txtPassC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnChangePass = new JButton("\u0110\u1ED5i");
		btnChangePass.setBounds(528, 223, 89, 31);
		panel.add(btnChangePass);
		btnChangePass.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				DoiMatKhau();
			}
		});
		btnChangePass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lbCurrentPass = new JLabel("Mật khẩu hiện tại:");
		lbCurrentPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbCurrentPass.setBounds(401, 80, 117, 19);
		panel.add(lbCurrentPass);
		
		txtCurrentPass = new JPasswordField();
		txtCurrentPass.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				DoiMatKhau();
			}
		});
		txtCurrentPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCurrentPass.setBounds(528, 79, 162, 20);
		panel.add(txtCurrentPass);
		
	}
	
	private void DoiMatKhau()
	{
		if (txtCurrentPass.getPassword().length == 0 || 
				txtPass.getPassword().length == 0 || 
				txtPassC.getPassword().length == 0) 
		{
			JOptionPane.showMessageDialog(btnChangePass, "Không được để trống thông tin!!");
			return;
		}
		
		if (accBLL.CheckAccount(accDTO.get_UserName(), txtCurrentPass.getText())) 
		{
			if (Arrays.equals(txtPass.getPassword(), txtPassC.getPassword())) 
			{
				if (accBLL.ChangePassword(accDTO.get_UserId(), txtPass.getText())) 
				{
					JOptionPane.showMessageDialog(btnChangePass, "Đổi mật khẩu thành công!!!\nThử đăng nhập lại đi " + accDTO.get_UserName());
				}
				else
				{
					JOptionPane.showMessageDialog(btnChangePass, "Đổi mật khẩu không thành công?!");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(btnChangePass, "Mật khẩu mới và mật khẩu xác nhận không giống!!!");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(btnChangePass, "Sai mật khẩu hiện tại!!");
		}
	}
}
