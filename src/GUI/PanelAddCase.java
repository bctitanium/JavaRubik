package GUI;

import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import BLL.AccountBLL;
import BLL.InteractBLL;
import BLL.ModifyBLL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class PanelAddCase extends JPanel 
{
	AccountBLL accBLL;
	ModifyBLL mBLL;
	InteractBLL inteBLL;
	
	private JTextField txtCaseName;
	private JTextField txtAlgorithm;
	private JComboBox<Object> cbType;
	private String picCover;
	private JTextArea txtMoTa;

	/**
	 * Create the panel.
	 */
	public PanelAddCase() 
	{
		setBackground(new Color(204, 204, 255));
		accBLL = new AccountBLL();
		mBLL = new ModifyBLL();
		inteBLL = new InteractBLL();
		
		setLayout(null);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (txtCaseName.getText().isEmpty()) 
				{
					JOptionPane.showMessageDialog(btnThem, "Hãy nhập đủ thông tin");
					return;
				}
				
				if (mBLL.AddCase(txtCaseName.getText(), picCover, txtAlgorithm.getText(), txtMoTa.getText(), inteBLL.GetIdOfTypeCase(cbType.getSelectedItem().toString())))
				{
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Thêm không thành công?");
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(110, 412, 100, 23);
		add(btnThem);
		
		JLabel lbCaseName = new JLabel("Case Name:");
		lbCaseName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbCaseName.setBounds(21, 54, 89, 33);
		add(lbCaseName);
		
		JLabel lblPicCover = new JLabel("Pic Cover:");
		lblPicCover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPicCover.setBounds(21, 98, 89, 33);
		add(lblPicCover);
		
		JLabel lblAlgorithm = new JLabel("Algorithm:");
		lblAlgorithm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlgorithm.setBounds(21, 220, 89, 33);
		add(lblAlgorithm);
		
		JLabel lbMota = new JLabel("M\u00F4 t\u1EA3:");
		lbMota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbMota.setBounds(21, 264, 89, 33);
		add(lbMota);
		
		JLabel lbLoai = new JLabel("Lo\u1EA1i:");
		lbLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbLoai.setBounds(21, 352, 89, 33);
		add(lbLoai);
		
		JLabel lbPic = new JLabel("");
		lbPic.setBounds(110, 109, 100, 100);
		add(lbPic);
		
		JLabel lblNewLabel = new JLabel("Th\u00EAm Case");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(143, 11, 106, 38);
		add(lblNewLabel);
		
		txtCaseName = new JTextField();
		txtCaseName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCaseName.setBounds(110, 60, 236, 20);
		add(txtCaseName);
		txtCaseName.setColumns(10);
		
		txtAlgorithm = new JTextField();
		txtAlgorithm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAlgorithm.setColumns(10);
		txtAlgorithm.setBounds(110, 228, 236, 20);
		add(txtAlgorithm);
		
		txtMoTa = new JTextArea();
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMoTa.setBounds(110, 276, 236, 73);
		add(txtMoTa);
		
		JButton btnChonHinh = new JButton("Ch\u1ECDn h\u00ECnh");
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
						picCover = "imgSrc/" + file.getName();
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
		btnChonHinh.setBounds(220, 105, 126, 23);
		add(btnChonHinh);
		
		cbType = new JComboBox<Object>(inteBLL.getComboBoxType().toArray());
		cbType.setBounds(110, 359, 236, 22);
		add(cbType);
	}
}

class ImageFilter extends FileFilter 
{
	   public final static String JPEG = "jpeg";
	   public final static String JPG = "jpg";
	   public final static String GIF = "gif";
	   public final static String TIFF = "tiff";
	   public final static String TIF = "tif";
	   public final static String PNG = "png";
	   
	   @Override
	   public boolean accept(File f) {
	      if (f.isDirectory()) {
	         return true;
	      }

	      String extension = getExtension(f);
	      if (extension != null) {
	         if (extension.equals(TIFF) ||
	            extension.equals(TIF) ||
	            extension.equals(GIF) ||
	            extension.equals(JPEG) ||
	            extension.equals(JPG) ||
	            extension.equals(PNG)) {
	            return true;
	         } else {
	            return false;
	         }
	      }
	      return false;
	   }

	   @Override
	   public String getDescription() {
	      return "Image Only";
	   }

	   String getExtension(File f) {
	      String ext = null;
	      String s = f.getName();
	      int i = s.lastIndexOf('.');
	   
	      if (i > 0 &&  i < s.length() - 1) {
	         ext = s.substring(i+1).toLowerCase();
	      }
	      return ext;
	   } 
	}