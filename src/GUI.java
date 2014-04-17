import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class GUI extends JFrame {

	private JPanel cpMain;
	private final ButtonGroup bgKnowLicense = new ButtonGroup();
	private final ButtonGroup bgChooseLicense = new ButtonGroup();
	private JTextField tfProjectPath;
	private final ButtonGroup bgAgain = new ButtonGroup();
	private String licenseName = "";
	private File destFile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setTitle("License Chooser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		cpMain = new JPanel();
		cpMain.setBackground(SystemColor.desktop);
		cpMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cpMain);
		cpMain.setLayout(null);	

		
		final JButton btnNext = new JButton("Next  >");
		final JButton btnBack = new JButton("<  Back");
		final JButton btnCancel = new JButton("Cancel");
		
		final JPanel cpChooseProjectFolder = new JPanel();
		cpChooseProjectFolder.setBackground(SystemColor.desktop);
		cpChooseProjectFolder.setBounds(0, 0, 340, 279);
		cpMain.add(cpChooseProjectFolder);
		cpChooseProjectFolder.setLayout(null);
		
		final JLabel lblChooseProjectFolder = new JLabel("Choose a project folder!");
		lblChooseProjectFolder.setForeground(SystemColor.activeCaptionText);
		lblChooseProjectFolder.setBackground(SystemColor.desktop);
		lblChooseProjectFolder.setBounds(22, 11, 135, 14);
		cpChooseProjectFolder.add(lblChooseProjectFolder);
		
		tfProjectPath = new JTextField();
		tfProjectPath.setEditable(false);
		tfProjectPath.setForeground(SystemColor.windowText);
		tfProjectPath.setBackground(SystemColor.desktop);
		tfProjectPath.setBounds(22, 42, 209, 20);
		cpChooseProjectFolder.add(tfProjectPath);
		tfProjectPath.setColumns(10);
		
		final JButton btnBrowse = new JButton("Browse");
		btnBrowse.setForeground(SystemColor.menuText);
		btnBrowse.setBackground(SystemColor.desktop);
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser openFile = new JFileChooser();
				openFile.setCurrentDirectory(new java.io.File("."));
				openFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				openFile.setAcceptAllFileFilterUsed(false);				
				if (openFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		            tfProjectPath.setText(openFile.getSelectedFile().toString());
		            destFile = openFile.getSelectedFile();
		            btnNext.setEnabled(true);
		        } else {
		        }
			}
		});
		btnBrowse.setBounds(241, 41, 89, 23);
		cpChooseProjectFolder.add(btnBrowse);
		
		final JPanel cpKnowLicenseChoice = new JPanel();
		cpKnowLicenseChoice.setBounds(0, 0, 340, 279);
		cpMain.add(cpKnowLicenseChoice);
		cpKnowLicenseChoice.setLayout(null);
		final JRadioButton rbKnowLicense = new JRadioButton("I know which license I want");
		rbKnowLicense.setBounds(20, 33, 188, 23);
		cpKnowLicenseChoice.add(rbKnowLicense);
		
		//rbKnowLicense
		rbKnowLicense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext.setEnabled(true);
			}
		});
		bgKnowLicense.add(rbKnowLicense);
		rbKnowLicense.setForeground(SystemColor.activeCaptionText);
		rbKnowLicense.setBackground(SystemColor.desktop);
		final JRadioButton rbDoNotKnowLicense = new JRadioButton("I do not know which license I want");
		rbDoNotKnowLicense.setBounds(20, 64, 224, 23);
		cpKnowLicenseChoice.add(rbDoNotKnowLicense);
		
		//rbDoNotKnowLicense
		rbDoNotKnowLicense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext.setEnabled(true);
			}
		});
		bgKnowLicense.add(rbDoNotKnowLicense);
		rbDoNotKnowLicense.setForeground(SystemColor.activeCaptionText);
		rbDoNotKnowLicense.setBackground(SystemColor.desktop);
		
		final JPanel cpDidNotChooseLicense = new JPanel();
		cpDidNotChooseLicense.setBounds(0, 0, 340, 279);
		cpMain.add(cpDidNotChooseLicense);
		cpDidNotChooseLicense.setLayout(null);
		
		final JPanel cpChooseLicense = new JPanel();
		cpChooseLicense.setBounds(0, 0, 340, 279);
		cpMain.add(cpChooseLicense);
		cpChooseLicense.setLayout(null);
		
		final JLabel lblPickLicense = new JLabel("Please pick a license!");
		lblPickLicense.setBounds(20, 11, 158, 14);
		cpChooseLicense.add(lblPickLicense);
		final JRadioButton rbGPLv2 = new JRadioButton("GPLv2");		
		rbGPLv2.setBounds(20, 33, 109, 23);
		cpChooseLicense.add(rbGPLv2);
		
		//rbGPLv2
		rbGPLv2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext.setEnabled(true);
			}
		});
		rbGPLv2.setForeground(SystemColor.activeCaptionText);
		rbGPLv2.setBackground(SystemColor.desktop);
		bgChooseLicense.add(rbGPLv2);
		final JRadioButton rbGPLv3 = new JRadioButton("GPLv3");
		rbGPLv3.setBounds(20, 64, 109, 23);
		cpChooseLicense.add(rbGPLv3);
		
		//rbGPLv3
		rbGPLv3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext.setEnabled(true);
			}
		});
		rbGPLv3.setForeground(SystemColor.activeCaptionText);
		rbGPLv3.setBackground(SystemColor.desktop);
		bgChooseLicense.add(rbGPLv3);
		final JRadioButton rbMIT = new JRadioButton("MIT");
		rbMIT.setBounds(20, 95, 109, 23);
		cpChooseLicense.add(rbMIT);
		
		//rbMIT
		rbMIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext.setEnabled(true);
			}
		});
		rbMIT.setForeground(SystemColor.activeCaptionText);
		rbMIT.setBackground(SystemColor.desktop);
		bgChooseLicense.add(rbMIT);
		final JRadioButton rbApache = new JRadioButton("Apache");
		rbApache.setBounds(20, 126, 109, 23);
		cpChooseLicense.add(rbApache);
		
		//rbApache
		rbApache.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext.setEnabled(true);
			}
		});
		rbApache.setForeground(SystemColor.activeCaptionText);
		rbApache.setBackground(SystemColor.desktop);
		bgChooseLicense.add(rbApache);
		
		final JRadioButton rbBSD2Clause = new JRadioButton("BSD 2-Clause");
		rbBSD2Clause.setBounds(20, 157, 109, 23);
		cpChooseLicense.add(rbBSD2Clause);
		
		//rbBSD2Clause
		rbBSD2Clause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext.setEnabled(true);
			}
		});
		rbBSD2Clause.setForeground(SystemColor.activeCaptionText);
		rbBSD2Clause.setBackground(SystemColor.desktop);
		bgChooseLicense.add(rbBSD2Clause);
		final JRadioButton rbBSD3Clause = new JRadioButton("BSD 3-Clause");
		rbBSD3Clause.setBounds(20, 188, 109, 23);
		cpChooseLicense.add(rbBSD3Clause);
		
		//rbBSD3Clause
		rbBSD3Clause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext.setEnabled(true);
			}
		});
		rbBSD3Clause.setForeground(SystemColor.activeCaptionText);
		rbBSD3Clause.setBackground(SystemColor.desktop);
		bgChooseLicense.add(rbBSD3Clause);
		final JRadioButton rbWTFPL = new JRadioButton("WTFPL");
		rbWTFPL.setBounds(20, 219, 109, 23);
		cpChooseLicense.add(rbWTFPL);
		
		//rbWTFPL
		rbWTFPL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext.setEnabled(true);
			}
		});
		rbWTFPL.setForeground(SystemColor.activeCaptionText);
		rbWTFPL.setBackground(SystemColor.desktop);
		bgChooseLicense.add(rbWTFPL);	
		
		final JPanel cpFinish = new JPanel();
		cpFinish.setForeground(SystemColor.windowText);
		cpFinish.setBackground(SystemColor.window);
		cpFinish.setBounds(0, 0, 340, 279);
		cpMain.add(cpFinish);
		cpFinish.setLayout(null);
		
		final JLabel lblAgain = new JLabel("Would you like to add a license to another project?");
		lblAgain.setForeground(SystemColor.windowText);
		lblAgain.setBackground(SystemColor.window);
		lblAgain.setBounds(20, 11, 310, 14);
		cpFinish.add(lblAgain);
		
		final JRadioButton rbAgain = new JRadioButton("Yes");
		rbAgain.setForeground(SystemColor.windowText);
		rbAgain.setBackground(SystemColor.window);
		rbAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext.setEnabled(true);
			}
		});
		bgAgain.add(rbAgain);
		rbAgain.setBounds(20, 33, 109, 23);
		cpFinish.add(rbAgain);
		
		final JRadioButton rbNotAgain = new JRadioButton("No and exit");
		rbNotAgain.setForeground(SystemColor.windowText);
		rbNotAgain.setBackground(SystemColor.window);
		rbNotAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext.setEnabled(true);
			}
		});
		bgAgain.add(rbNotAgain);
		rbNotAgain.setBounds(20, 55, 109, 23);
		cpFinish.add(rbNotAgain);
		
		cpKnowLicenseChoice.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				rbKnowLicense.setVisible(false);
				rbDoNotKnowLicense.setVisible(false);
			}
		});
		cpDidNotChooseLicense.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				
			}
		});
		cpChooseProjectFolder.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				lblChooseProjectFolder.setVisible(false);
				tfProjectPath.setVisible(false);
				btnBrowse.setVisible(false);
			}
		});
		cpChooseLicense.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				lblPickLicense.setVisible(false);
				rbGPLv2.setVisible(false);
				rbGPLv3.setVisible(false);
				rbMIT.setVisible(false);
				rbApache.setVisible(false);
				rbBSD2Clause.setVisible(false);
				rbBSD3Clause.setVisible(false);
				rbWTFPL.setVisible(false);
			}
		});
		cpFinish.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				lblAgain.setVisible(false);
				rbAgain.setVisible(false);
				rbNotAgain.setVisible(false);
			}
		});
		
		cpKnowLicenseChoice.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				rbKnowLicense.setVisible(true);
				rbDoNotKnowLicense.setVisible(true);
				bgKnowLicense.clearSelection();
			}
		});
		cpDidNotChooseLicense.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
			}
		});
		cpChooseProjectFolder.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				lblChooseProjectFolder.setVisible(true);
				tfProjectPath.setVisible(true);
				btnBrowse.setVisible(true);
				bgChooseLicense.clearSelection();
				tfProjectPath.setText(null);
			}
		});
		cpChooseLicense.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				lblPickLicense.setVisible(true);
				rbGPLv2.setVisible(true);
				rbGPLv3.setVisible(true);
				rbMIT.setVisible(true);
				rbApache.setVisible(true);
				rbBSD2Clause.setVisible(true);
				rbBSD3Clause.setVisible(true);
				rbWTFPL.setVisible(true);
			}
		});
		cpFinish.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				lblAgain.setVisible(true);
				rbAgain.setVisible(true);
				rbNotAgain.setVisible(true);
				bgAgain.clearSelection();
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean noBack = false;
				if (cpKnowLicenseChoice.isVisible() && rbKnowLicense.isSelected())
				{
					cpKnowLicenseChoice.setVisible(false);
					cpChooseLicense.setVisible(true);
				}
				else if (cpKnowLicenseChoice.isVisible() && rbDoNotKnowLicense.isSelected())
				{
					cpKnowLicenseChoice.setVisible(false);
					cpDidNotChooseLicense.setVisible(true);
				}
				else if (cpChooseLicense.isVisible())
				{
					ButtonModel buttonModel = bgKnowLicense.getSelection();
					if (buttonModel != null)
					{
						for (Enumeration<AbstractButton> buttons = bgChooseLicense.getElements(); buttons.hasMoreElements();) {
				            AbstractButton button = buttons.nextElement();

				            if (button.isSelected()) {
				                licenseName = button.getText();
				            }
				        }
						cpChooseLicense.setVisible(false);
						cpChooseProjectFolder.setVisible(true);
					}
				}
				else if(cpChooseProjectFolder.isVisible())
				{					
					if (tfProjectPath.getText() != null)
					{//+ licenseName
						FileHandler file = new FileHandler(licenseName,destFile);
						try {
							file.addLicenseToProject();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						cpChooseProjectFolder.setVisible(false);
						cpFinish.setVisible(true);
					}
				}
				else if(cpFinish.isVisible() && rbAgain.isSelected())
				{
					cpFinish.setVisible(false);
					cpKnowLicenseChoice.setVisible(true);
					noBack = true;
				}
				else if(cpFinish.isVisible() && rbNotAgain.isSelected())
				{
					System.exit(0);
				}
				if (noBack)
				{
					btnBack.setEnabled(false);
				}
				else
				{
					btnBack.setEnabled(true);
				}
				btnNext.setEnabled(false);
			}
		});
		
		
		btnNext.setBounds(142, 285, 89, 23);
		cpMain.add(btnNext);
		btnNext.setForeground(SystemColor.windowText);
		btnNext.setBackground(SystemColor.desktop);
		btnNext.setEnabled(false);
		
		//btnBack
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (cpKnowLicenseChoice.isVisible())
				{
					btnBack.setEnabled(false);					
				}
				else if (cpChooseLicense.isVisible() || cpDidNotChooseLicense.isVisible())
				{
					cpDidNotChooseLicense.setVisible(false);
					cpChooseLicense.setVisible(false);
					cpKnowLicenseChoice.setVisible(true);
					btnNext.setEnabled(false);
				}
				
				//
				else if(cpChooseProjectFolder.isVisible())
				{
					cpChooseProjectFolder.setVisible(false);
					cpChooseLicense.setVisible(true);
					btnNext.setEnabled(false);
				}
				
				else if (cpFinish.isVisible())
				{
					cpFinish.setVisible(false);
					cpChooseProjectFolder.setVisible(true);
					btnNext.setEnabled(false);
				}
				
				
			}
		});
		btnBack.setBounds(43, 285, 89, 23);
		cpMain.add(btnBack);
		btnBack.setForeground(SystemColor.windowText);
		btnBack.setBackground(SystemColor.desktop);
		btnBack.setEnabled(false);
		
		//btnCancel
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(241, 285, 89, 23);
		cpMain.add(btnCancel);
		btnCancel.setForeground(SystemColor.windowText);
		btnCancel.setBackground(SystemColor.desktop);
		
		cpKnowLicenseChoice.setVisible(true);
		cpDidNotChooseLicense.setVisible(false);
		cpChooseLicense.setVisible(false);
		cpChooseProjectFolder.setVisible(false);
		cpFinish.setVisible(false);
	}
}
