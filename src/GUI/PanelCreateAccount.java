package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import BLL.AccountBLL;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelCreateAccount extends JPanel 
{
	AccountBLL accBLL;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtPasswordC;
	private JButton btnCreateAccount;

	/**
	 * Create the panel.
	 */
	public PanelCreateAccount() 
	{
		setBackground(new Color(0, 0, 153));
		accBLL = new AccountBLL();
		setSize(1164, 683);
		setLayout(null);
		
		JPanel pnCreateAccount = new JPanel();
		pnCreateAccount.setBackground(new Color(204, 255, 255));
		pnCreateAccount.setBounds(10, 11, 1144, 661);
		add(pnCreateAccount);
		pnCreateAccount.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u1EA1o t\u00E0i kho\u1EA3n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1124, 29);
		pnCreateAccount.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lbUsername = new JLabel("T\u00EAn t\u00E0i kho\u1EA3n:");
		lbUsername.setBounds(455, 100, 95, 14);
		pnCreateAccount.add(lbUsername);
		lbUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtUsername = new JTextField();
		txtUsername.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				TaoTaiKhoan();
			}
		});
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setBounds(560, 97, 162, 20);
		pnCreateAccount.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lbPassword = new JLabel("M\u1EADt kh\u1EA9u:");
		lbPassword.setBounds(484, 148, 66, 19);
		pnCreateAccount.add(lbPassword);
		lbPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtPassword = new JPasswordField();
		txtPassword.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				TaoTaiKhoan();
			}
		});
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setBounds(560, 147, 162, 20);
		pnCreateAccount.add(txtPassword);
		
		JLabel lbPasswordC = new JLabel("X\u00E1c nh\u1EADn m\u1EADt kh\u1EA9u:");
		lbPasswordC.setBounds(417, 199, 133, 17);
		pnCreateAccount.add(lbPasswordC);
		lbPasswordC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtPasswordC = new JPasswordField();
		txtPasswordC.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				TaoTaiKhoan();
			}
		});
		txtPasswordC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPasswordC.setBounds(560, 197, 162, 20);
		pnCreateAccount.add(txtPasswordC);
		
		btnCreateAccount = new JButton("T\u1EA1o");
		btnCreateAccount.setBounds(575, 246, 89, 29);
		pnCreateAccount.add(btnCreateAccount);
		btnCreateAccount.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				TaoTaiKhoan();
			}
		});
		btnCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));

	}
	
	private void TaoTaiKhoan()
	{
		if (txtUsername.getText().length() == 0 || 
				txtPassword.getPassword().length == 0 || 
				txtPasswordC.getPassword().length == 0) 
		{
			JOptionPane.showMessageDialog(btnCreateAccount, "Không được để trống thông tin!!");
			return;
		}
		
		if (true)
		{
			
		}
		
		if (!accBLL.CheckUsername(txtUsername.getText())) 
		{					
			if ((Arrays.equals(txtPassword.getPassword(), txtPasswordC.getPassword()))) 
			{
				if (accBLL.CreateAccount(txtUsername.getText(), txtPassword.getText())) 
				{
					JOptionPane.showMessageDialog(btnCreateAccount, "Tạo tài khoản thành công!!!");
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(btnCreateAccount, "Tạo tài khoản không thành công :|");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(btnCreateAccount, "Tạo tài khoản không thành công do không khớp 2 mật khẩu :|");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(btnCreateAccount, "Tạo tài khoản không thành công do trùng username :|");
		}
	}
}
