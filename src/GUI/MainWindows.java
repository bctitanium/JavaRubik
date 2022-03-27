package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MainWindows 
{
	private JFrame frame;
	private PanelLogin pl;
	private PanelListCase plc;
	private PanelCreateAccount pca;
	private PanelPlay pp;
	private PanelChangePassword pcp;
	private JButton btnLogin;
	private JButton btnCase;
	private JButton btnLogout;
	private JButton btnCreateAccount;
	private JButton btnPlay;
	private JButton btnChangePass;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainWindows window = new MainWindows();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public MainWindows() 
	{
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 153));
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		pl = new PanelLogin();
		pl.addComponentListener(new ComponentAdapter() 
		{
			@Override
			public void componentHidden(ComponentEvent e) 
			{
				if (pl.trcdlt.get_FlagLogin()) //khi đăng nhập thành công
				{
					plc.setVisible(true);
					
					btnCase.setVisible(true);
					btnPlay.setVisible(true);
					btnLogout.setVisible(true);
					btnChangePass.setVisible(true);
					
					btnCreateAccount.setVisible(false);
					btnLogin.setVisible(false);
					
					//thao tác giữa PanelPlay và PanelLogin
					pp.accDTO.set_UserId(pl.accDTO.get_UserId());
					pp.accDTO.set_UserName(pl.accDTO.get_UserName());
					
					pcp.accDTO.set_UserId(pl.accDTO.get_UserId());
					pcp.accDTO.set_UserName(pl.accDTO.get_UserName());
					
					plc.accDTO.set_UserName(pl.accDTO.get_UserName());
				}
			}
		});
		pl.setBounds(10, 11, 1164, 683);
		frame.getContentPane().add(pl);
		pl.setLayout(null);
		pl.setSize(1164, 683);
		pl.setVisible(true);
		
		plc = new PanelListCase();
		plc.setBounds(10, 11, 1164, 683);
		frame.getContentPane().add(plc);
		plc.setLayout(null);
		plc.setSize(1164, 683);
		plc.setVisible(false);
		
		pp = new PanelPlay();
		pp.setBounds(10, 11, 1164, 683);
		frame.getContentPane().add(pp);
		pp.setLayout(null);
		pp.setSize(1164, 683);
		pp.setVisible(false);
		
		pca = new PanelCreateAccount();
		pca.addComponentListener(new ComponentAdapter() 
		{
			@Override
			public void componentHidden(ComponentEvent e) 
			{
				pl.setVisible(true);
			}
		});
		pca.setBounds(10, 11, 1164, 683);
		frame.getContentPane().add(pca);
		pca.setLayout(null);
		pca.setSize(1164, 683);
		pca.setVisible(false);
		
		pcp = new PanelChangePassword();
		pcp.setBounds(10, 11, 1164, 683);
		frame.getContentPane().add(pcp);
		pcp.setLayout(null);
		pcp.setSize(1164, 683);
		pcp.setVisible(false);
		
		JPanel pnBtn = new JPanel();
		pnBtn.setBounds(20, 705, 1144, 45);
		frame.getContentPane().add(pnBtn);
		pnBtn.setLayout(null);
		
		btnLogout = new JButton("Đăng xuất");
		btnLogout.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				btnLogout.setVisible(false);
				btnLogin.setVisible(true);
				btnCase.setVisible(false);
				btnPlay.setVisible(false);
				btnCreateAccount.setVisible(true);
				btnChangePass.setVisible(false);
				
				pl.setVisible(true);
				
				plc.setVisible(false);
				pca.setVisible(false);
				pp.setVisible(false);
				
				pp.btnStop.doClick();
			}
		});
		btnLogout.setBounds(1037, 0, 97, 45);
		pnBtn.add(btnLogout);
		btnLogout.setVisible(false);
		
		btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				pl.setVisible(true);
				
				plc.setVisible(false);
				pca.setVisible(false);
				pp.setVisible(false);
			}
		});
		btnLogin.setBounds(10, 0, 97, 45);
		pnBtn.add(btnLogin);
		
		btnCase = new JButton("CFOP");
		btnCase.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				plc.setVisible(true);
				
				pl.setVisible(false);
				pca.setVisible(false);
				pp.setVisible(false);
				pcp.setVisible(false);
			}
		});
		btnCase.setBounds(216, 0, 97, 45);
		pnBtn.add(btnCase);
		
		btnCreateAccount = new JButton("Tạo Acc");
		btnCreateAccount.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				pca.setVisible(true);
				
				pl.setVisible(false);
				plc.setVisible(false);
				pp.setVisible(false);
			}
		});
		btnCreateAccount.setBounds(117, 0, 89, 45);
		pnBtn.add(btnCreateAccount);
		
		btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				pp.setVisible(true);
				
				plc.setVisible(false);
				pl.setVisible(false);
				pca.setVisible(false);
				pcp.setVisible(false);
			}
		});
		btnPlay.setBounds(323, 0, 89, 45);
		pnBtn.add(btnPlay);
		
		btnChangePass = new JButton("Đổi mật khẩu");
		btnChangePass.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				pcp.setVisible(true);
				
				pp.setVisible(false);
				plc.setVisible(false);
				pl.setVisible(false);
				pca.setVisible(false);
			}
		});
		btnChangePass.setBounds(906, 0, 121, 45);
		pnBtn.add(btnChangePass);
		btnChangePass.setVisible(false);
		
		btnCase.setVisible(false);
		btnPlay.setVisible(false);
	}
}
