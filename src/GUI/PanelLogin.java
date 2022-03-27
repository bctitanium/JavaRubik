package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import BLL.AccountBLL;
import BLL.InteractBLL;
import DTO.Account;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelLogin extends JPanel 
{	
	private AccountBLL accBLL;
	private InteractBLL inteBLL;
	public Account accDTO;
	
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	
	public TaoRaChiDeLuuTen trcdlt;
	
	/**
	 * Create the panel.
	 */
	public PanelLogin() 
	{
		setBackground(new Color(0, 0, 153));
		
		trcdlt = new TaoRaChiDeLuuTen();
		accBLL = new AccountBLL();
		inteBLL = new InteractBLL();
		accDTO = new Account();
		
		setLayout(null);
		setSize(1164, 683);
		
		JPanel pnLogin = new JPanel();
		pnLogin.setBackground(new Color(204, 255, 255));
		pnLogin.setBounds(10, 11, 1144, 661);
		add(pnLogin);
		pnLogin.setLayout(null);
		
		JLabel lbTitle = new JLabel("\u0110\u0103ng nh\u1EADp \u0111i b\u1EA1n");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setBounds(10, 11, 1124, 33);
		pnLogin.add(lbTitle);
		lbTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		txtUsername = new JTextField();
		txtUsername.setText("admin");
		txtUsername.setBounds(516, 94, 142, 20);
		pnLogin.add(txtUsername);
		txtUsername.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				DangNhap();
			}
		});
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setColumns(10);
		
		JLabel lbUsername = new JLabel("Username:");
		lbUsername.setBounds(434, 93, 72, 23);
		pnLogin.add(lbUsername);
		lbUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lbPassword = new JLabel("Password:");
		lbPassword.setBounds(440, 127, 66, 23);
		pnLogin.add(lbPassword);
		lbPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtPassword = new JPasswordField();
		txtPassword.setText("admin");
		txtPassword.setBounds(516, 128, 142, 21);
		pnLogin.add(txtPassword);
		txtPassword.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				DangNhap();
			}
		});
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(516, 160, 105, 33);
		pnLogin.add(btnLogin);
		btnLogin.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				DangNhap();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
	}
	
	private void DangNhap()
	{
		accDTO.set_UserName(txtUsername.getText());
		accDTO.set_UserId(inteBLL.GetIdOfUsername(txtUsername.getText()));
		
		if (txtUsername.getText().length() == 0 || 
				txtPassword.getPassword().length == 0) 
		{
			JOptionPane.showMessageDialog(txtPassword, "Không được để trống thông tin đăng nhập");
			return;
		}
		
		if (accBLL.CheckAccount(txtUsername.getText(), txtPassword.getText())) 
		{
			if (accBLL.isAdmin(txtUsername.getText())) 
			{
				JOptionPane.showMessageDialog(null, "Chào ADMIN!!!");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Chào " + accDTO.get_UserName() + "!!!");
			}
			
			txtPassword.setText("");
			setVisible(false);
			
			trcdlt.set_FlagLogin(true);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Đăng nhập không thành công\nTạo tài khoản chưa bạn?");
		}
	}
}
