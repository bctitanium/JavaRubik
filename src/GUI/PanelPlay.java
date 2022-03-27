package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import BLL.InteractBLL;
import BLL.ModifyBLL;
import DTO.Method;
import DTO.Account;
import DTO.Records;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PanelPlay extends JPanel 
{
	private InteractBLL inteBLL;
	private ModifyBLL modBLL;
	public Account accDTO;
	private Method methodDTO;
	private Records recordDTO;
	
	private int randomScrambleNumber;
	private int min;
	private int max;
	private int[] MinMaxScramble;
	private String BestRecord;
	
	private Boolean isStopped = true;
	
	private JLabel lbScrambles;
	private JPanel pnPlay;
	private JButton btnSpace;
	private JLabel lbTimer;
	private JLabel lbPlayerName;
	private JLabel lbPic;
	private JComboBox<Object> cbMethod;
	private JButton btnReady;
	public JButton btnStop;
	private JLabel lbBestRecord;
	
	/**
	 * Create the panel.
	 */
	public PanelPlay() 
	{
		setBackground(new Color(0, 0, 153));
		setLayout(null);
		setSize(1164,683);
		
		inteBLL = new InteractBLL();
		modBLL = new ModifyBLL();
		accDTO = new Account();
		
		randomScrambleNumber = 0;
		MinMaxScramble = inteBLL.GetMinMaxOfScrambles();
		min = MinMaxScramble[0];
		max = MinMaxScramble[1];
		
		pnPlay = new JPanel();
		pnPlay.setBackground(new Color(204, 255, 204));
		pnPlay.setBounds(10, 11, 1144, 661);
		add(pnPlay);
		pnPlay.setLayout(null);
		
		lbPic = new JLabel("");
		lbPic.setHorizontalAlignment(SwingConstants.CENTER);
		lbPic.setBounds(352, 63, 434, 323);
		pnPlay.add(lbPic);
		
		lbScrambles = new JLabel(randomScramblesText());
		lbScrambles.setBounds(10, 11, 1124, 41);
		pnPlay.add(lbScrambles);
		lbScrambles.setHorizontalAlignment(SwingConstants.CENTER);
		lbScrambles.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		btnReady = new JButton("Sẵn sàng");
		btnReady.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				btnSpace.requestFocusInWindow();
				
				setState(true);
			}
		});
		btnReady.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReady.setBounds(10, 557, 103, 41);
		pnPlay.add(btnReady);
		
		btnStop = new JButton("Dừng");
		btnStop.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				pnPlay.requestFocusInWindow();
				
				setState(false);
			}
		});
		btnStop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnStop.setBounds(10, 609, 103, 41);
		pnPlay.add(btnStop);
		
		btnSpace = new JButton("Nhấn giữ SPACE_BAR");
		btnSpace.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent e) 
			{
				if (e.getKeyCode() == KeyEvent.VK_SPACE) 
				{
					if (isTimerRunning())
					{
		                stopTimer();
		                
		                lbTimer.setForeground(Color.BLUE);
		                
		                saveRecord();
		                
		                lbScrambles.setText(randomScramblesText());
		                
		                btnSpace.setText("Nhấn giữ SPACE_BAR");
		                
		                setBestRecord();
		                lbBestRecord.setText("Kỷ lục: " + BestRecord);
		            } 
					else 
					{
		                startTimer();
		                
		                lbTimer.setForeground(Color.RED);
		                
		                btnSpace.setText("Lẹ lên :)))");
		            }
				}
			}
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if (e.getKeyCode() == KeyEvent.VK_SPACE) 
				{
					lbTimer.setForeground(Color.GREEN);
					
					btnSpace.setText("Nhả ra là bắt đầu!!");
				}
			}
		});
		btnSpace.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSpace.setBounds(123, 557, 899, 93);
		pnPlay.add(btnSpace);
		
		lbTimer = new JLabel("0:0.000");
		lbTimer.setVisible(false);
		lbTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lbTimer.setFont(new Font("Tahoma", Font.PLAIN, 80));
		lbTimer.setBounds(10, 379, 1124, 167);
		pnPlay.add(lbTimer);
		
		lbPlayerName = new JLabel("");
		lbPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		lbPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbPlayerName.setBounds(10, 505, 1124, 41);
		pnPlay.add(lbPlayerName);
		
		cbMethod = new JComboBox<Object>(inteBLL.getComboBoxMethod().toArray());
		cbMethod.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				btnSpace.requestFocusInWindow();
			}
		});
		cbMethod.setBounds(1032, 598, 102, 22);
		pnPlay.add(cbMethod);
		
		JLabel lbMethod = new JLabel("Phương pháp");
		lbMethod.setHorizontalAlignment(SwingConstants.CENTER);
		lbMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbMethod.setBounds(1032, 557, 102, 30);
		pnPlay.add(lbMethod);
		
		lbBestRecord = new JLabel("");
		lbBestRecord.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbBestRecord.setBounds(10, 505, 349, 41);
		pnPlay.add(lbBestRecord);
	}
	
	/**
	 * ẩn hiện label đồng hồ và label tên
	 * @param isReady true thì hiện đồng hồ và tên, false thì ẩn đồng hồ và tên
	 */
	private void setState(boolean isReady)
	{
		setBestRecord();
		
		lbTimer.setVisible(isReady);
		
		if (isReady) 
		{
			lbPlayerName.setText("Đang chơi: " + accDTO.get_UserName());
			
			lbBestRecord.setText("Kỷ lục: " + BestRecord);
		}
		else
		{
			lbPlayerName.setText("");
		}
	}
	
	private void setBestRecord()
	{
		BestRecord = inteBLL.GetBestRecord(accDTO.get_UserId());
	}
	
	//[min; max)
	private String randomScramblesText()
	{
		randomScrambleNumber = ThreadLocalRandom.current().nextInt(min, max + 1); //lấy ra ngẫu nhiên 1 trường hợp, vd: [min; max + 1)
		
		changeScrambleImage(randomScrambleNumber); //lấy hình của trường hợp đó
		
		return randomScrambleNumber + ". " + inteBLL.GetScramblesFromRandomNumber(randomScrambleNumber);
	}
	
	private void stopTimer()
	{
	    synchronized(isStopped)
	    {
	        isStopped = true;
	    }
	}

	private boolean isTimerRunning()
	{
	    boolean result = false;
	    
	    synchronized(isStopped)
	    {
	        result = !isStopped;
	    }
	    
	    return result;
	}
	
	private void startTimer() 
	{
	    new Thread()
	    {
	        public void run()
	        {
	            long timeStart = new GregorianCalendar().getTimeInMillis();
	            
	            synchronized(isStopped)
	            {
	                isStopped = false;
	            }
	            
	            while(isTimerRunning())
	            {
	                long timeNow = new GregorianCalendar().getTimeInMillis() - timeStart;
	                long milliseconds = (timeNow % 1000);
	                timeNow = (long)Math.floor(timeNow * 0.001f);
	                long seconds = (timeNow % 60);
	                timeNow = (long)Math.floor((float)timeNow / 60f);
	                long minutes = timeNow;

	                lbTimer.setText(minutes + ":" + seconds + "." + milliseconds);
	            }
	        }
	    }.start();
	}
	
	private void changeScrambleImage(int randomScrambleId)
	{
		BufferedImage BfImg = null;
		
		try 
		{
			BfImg = ImageIO.read(new File(inteBLL.GetImgPathFromScrambleId(randomScrambleId)));
		} 
		catch (IOException ioex) 
		{
			ioex.printStackTrace();
		}
		Image dimg = BfImg.getScaledInstance(lbPic.getWidth(), lbPic.getHeight(), Image.SCALE_SMOOTH);
		
		lbPic.setIcon(new ImageIcon(dimg));
	}
	
	private void saveRecord()
	{
		methodDTO = new Method(inteBLL.GetIdOfMethod(cbMethod.getSelectedItem().toString()), cbMethod.getSelectedItem().toString());
		recordDTO = new Records(lbTimer.getText(), randomScrambleNumber);
		
		System.out.println("Timer: " + recordDTO.get_RecordTime());
		System.out.println("Scramble Id: " + recordDTO.get_ScrambleId());
		System.out.println("User Id: " + accDTO.get_UserId());
		System.out.println("Method Id: " + methodDTO.get_MethodId());
		
		modBLL.AddRecords(recordDTO.get_RecordTime(), recordDTO.get_ScrambleId(), accDTO.get_UserId(), methodDTO.get_MethodId());
	}
	
	private void playSound()
	{
		
	}
}
