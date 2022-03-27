package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JTable;
import BLL.AccountBLL;
import BLL.InteractBLL;
import BLL.LdtBLL;
import BLL.ModifyBLL;
import DTO.Account;
import javax.swing.JScrollPane;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class PanelListCase extends JPanel 
{
	private JTable tableCase;
	String casenameSelected = "";
	String algorithmSelected = "";
	String motaSelected = "";
	String pathIMG = "";
	
	public Account accDTO;
	
	AccountBLL accBLL;
	LdtBLL LDt;
	ModifyBLL mBLL;
	InteractBLL inteBLL;
	
	private JTextField txtCaseName;
	private JTextField txtAlgorithm;
	private JTextField txtPicCover;
	private JTextArea txtMoTa;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnChonHinh;
	
	/**
	 * Create the panel.
	 */
	public PanelListCase() 
	{
		accBLL = new AccountBLL();
		LDt = new LdtBLL();
		mBLL = new ModifyBLL();
		inteBLL = new InteractBLL();
		
		accDTO = new Account();
		
		addComponentListener(new ComponentAdapter() 
		{
			@Override
			public void componentShown(ComponentEvent e) 
			{
				withRole(accBLL.isAdmin(accDTO.get_UserName()));
			}
		});
		
		setBackground(new Color(0, 0, 153));
		setLayout(null);
		setSize(1164, 683);
		
		JPanel pnListCase = new JPanel();
		pnListCase.setBackground(new Color(51, 255, 204));
		pnListCase.setBounds(10, 11, 1144, 661);
		add(pnListCase);
		pnListCase.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 707, 483);
		pnListCase.add(scrollPane);
		
		tableCase = new JTable();
		scrollPane.setViewportView(tableCase);
		
		JLabel lbMoTa = new JLabel("");
		lbMoTa.setBounds(727, 160, 406, 67);
		pnListCase.add(lbMoTa);
		lbMoTa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("B1: Cross");
		btnNewButton.setBounds(727, 11, 203, 50);
		pnListCase.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				tableCase.setModel(LDt.LoadDTCross());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnLoadF2l = new JButton("B2: F2L");
		btnLoadF2l.setBounds(727, 72, 100, 57);
		pnListCase.add(btnLoadF2l);
		btnLoadF2l.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lbPic = new JLabel("");
		lbPic.setBounds(721, 238, 412, 412);
		pnListCase.add(lbPic);
		
		JButton btnLoadOll = new JButton("B3: OLL");
		btnLoadOll.setBounds(830, 72, 100, 57);
		pnListCase.add(btnLoadOll);
		btnLoadOll.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				tableCase.setModel(LDt.LoadDTOLL());
			}
		});
		btnLoadOll.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_1 = new JButton("B4: PLL");
		btnNewButton_1.setBounds(940, 4, 193, 125);
		pnListCase.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				tableCase.setModel(LDt.LoadDTPLL());
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnThem = new JButton("Th\u00EAm");
		btnThem.setBounds(10, 505, 100, 41);
		pnListCase.add(btnThem);
		btnThem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JDialog d = new JDialog();
				d.setSize(450, 510);
				d.setLocation(200, 100);
				PanelAddCase pac = new PanelAddCase();
				d.getContentPane().add(pac);
				//d.show();
				d.setVisible(true);
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnXoa = new JButton("X\u00F3a");
		btnXoa.setBounds(10, 557, 100, 41);
		pnListCase.add(btnXoa);
		btnXoa.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (mBLL.DeleteCase(casenameSelected))
				{
					JOptionPane.showMessageDialog(null, "Xóa thành công!");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Xóa không thành công!!!");
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnChonHinh = new JButton("Ch\u1ECDn");
		btnChonHinh.setBounds(120, 596, 67, 23);
		pnListCase.add(btnChonHinh);
		btnChonHinh.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser fileChooser = new JFileChooser();
	            fileChooser.addChoosableFileFilter(new ImageFilter());
	            fileChooser.setAcceptAllFileFilterUsed(false);
	            
	            int option = fileChooser.showOpenDialog(new JFrame());
	            if (option == JFileChooser.APPROVE_OPTION)
	            {
	            	File file = fileChooser.getSelectedFile();
	            	
	            	BufferedImage BfImg = null;
	            	try 
					{
						BfImg = ImageIO.read(new File("imgSrc/" + file.getName()));
						txtPicCover.setText("imgSrc/" + file.getName());
					} 
					catch (IOException ioex) 
					{
						ioex.printStackTrace();
					}
	            	Image dimg = BfImg.getScaledInstance(lbPic.getWidth(), lbPic.getHeight(), Image.SCALE_SMOOTH);
					
					lbPic.setIcon(new ImageIcon(dimg));
	            }
	            else
	            {
	            	JOptionPane.showMessageDialog(null, "Không tìm thấy hình");
	            }
			}
		});
		btnChonHinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtCaseName = new JTextField();
		txtCaseName.setBounds(120, 566, 181, 20);
		pnListCase.add(txtCaseName);
		txtCaseName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCaseName.setColumns(10);
		
		txtPicCover = new JTextField();
		txtPicCover.setBounds(197, 597, 104, 20);
		pnListCase.add(txtPicCover);
		txtPicCover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPicCover.setColumns(10);
		
		txtAlgorithm = new JTextField();
		txtAlgorithm.setBounds(120, 630, 181, 20);
		pnListCase.add(txtAlgorithm);
		txtAlgorithm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAlgorithm.setColumns(10);
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(10, 609, 100, 41);
		pnListCase.add(btnSua);
		btnSua.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (mBLL.UpdateCase(inteBLL.GetIdFromCasename(casenameSelected), txtCaseName.getText(), txtPicCover.getText(), txtAlgorithm.getText(), txtMoTa.getText()))
				{
					JOptionPane.showMessageDialog(null, "Sửa thảnh công!!");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Sửa không thảnh công!!!");
				}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtMoTa = new JTextArea();
		txtMoTa.setBounds(311, 566, 406, 84);
		pnListCase.add(txtMoTa);
		txtMoTa.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnLoadF2l.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				tableCase.setModel(LDt.LoadDTF2L());
			}
		});
		
		tableCase.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JTable table = (JTable) e.getSource();
				//int column = table.columnAtPoint(e.getPoint());
				int row = table.rowAtPoint(e.getPoint());
				//System.out.println("Column: "+column);
				//System.out.println("Row: "+row);
				
				casenameSelected = table.getValueAt(row, 0) == null ? "" : table.getValueAt(row, 0).toString();
				algorithmSelected = table.getValueAt(row, 1) == null ? "" : table.getValueAt(row, 1).toString();
				motaSelected = table.getValueAt(row, 2) == null ? "" : table.getValueAt(row, 2).toString();
				
				System.out.println(casenameSelected);
				
				lbMoTa.setText("<html>" + motaSelected + "</html>");
				
				txtCaseName.setText(casenameSelected);
				txtAlgorithm.setText(algorithmSelected);
				txtMoTa.setText(motaSelected);
				txtPicCover.setText(inteBLL.GetImgPathFromCaseName(casenameSelected));
				
				BufferedImage BfImg = null;
				
				try 
				{
					BfImg = ImageIO.read(new File(inteBLL.GetImgPathFromCaseName(casenameSelected)));
				} 
				catch (IOException ioex) 
				{
					ioex.printStackTrace();
				}
				Image dimg = BfImg.getScaledInstance(lbPic.getWidth(), lbPic.getHeight(), Image.SCALE_SMOOTH);
				
				lbPic.setIcon(new ImageIcon(dimg));
			}
		});
	}
	
	private void withRole(boolean flag)
	{
		btnThem.setVisible(flag);
		btnXoa.setVisible(flag);
		btnSua.setVisible(flag);
		btnChonHinh.setVisible(flag);
		txtCaseName.setVisible(flag);
		txtPicCover.setVisible(flag);
		txtAlgorithm.setVisible(flag);
		txtMoTa.setVisible(flag);
	}
}
