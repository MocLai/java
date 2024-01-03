package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import controller.Login_Listener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class LoginJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField usernametextField;
	public JPasswordField passwordField;

	public LoginJFrame() {
		this.init();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void init() {
		this.setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ActionListener ac = new Login_Listener(this);
		
		java.net.URL urluser = NguoimuonJFrame.class.getResource("/icon/user.png");
		ImageIcon iconuser = new ImageIcon(urluser);
		Image imageuser = iconuser.getImage();
		int maxWidthuser = 20; // chiều rộng tối đa của biểu tượng
		int maxHeightuser = 20; // chiều cao tối đa của biểu tượng
		int widthuser = imageuser.getWidth(null);
		int heightuser = imageuser.getHeight(null);
		double scaleuser = Math.min((double) maxWidthuser / widthuser, (double) maxHeightuser / heightuser);
		int Widthuser = (int) (widthuser * scaleuser);
		int Heightuser = (int) (heightuser * scaleuser);
		BufferedImage Imageuser = new BufferedImage(Widthuser, Heightuser, BufferedImage.TYPE_INT_ARGB);
		Graphics2D guser = Imageuser.createGraphics();
		guser.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		guser.drawImage(imageuser, 0, 0, Widthuser, Heightuser, null);
		guser.dispose();
		ImageIcon Iconuser = new ImageIcon(Imageuser);
		
		java.net.URL urlpassword = NguoimuonJFrame.class.getResource("/icon/password.png");
		ImageIcon iconpassword = new ImageIcon(urlpassword);
		Image imagepassword = iconpassword.getImage();
		int maxWidthpassword = 20; // chiều rộng tối đa của biểu tượng
		int maxHeightpassword = 20; // chiều cao tối đa của biểu tượng
		int widthpassword = imagepassword.getWidth(null);
		int heightpassword = imagepassword.getHeight(null);
		double scalepassword = Math.min((double) maxWidthpassword / widthpassword, (double) maxHeightpassword / heightpassword);
		int Widthpassword = (int) (widthpassword * scalepassword);
		int Heightpassword = (int) (heightpassword * scalepassword);
		BufferedImage Imagepassword = new BufferedImage(Widthpassword, Heightpassword, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gpassword = Imagepassword.createGraphics();
		gpassword.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		gpassword.drawImage(imagepassword, 0, 0, Widthpassword, Heightpassword, null);
		gpassword.dispose();
		ImageIcon Iconpassword = new ImageIcon(Imagepassword);
		
		java.net.URL urlexit = NguoimuonJFrame.class.getResource("/icon/exit.png");
		ImageIcon iconexit = new ImageIcon(urlexit);
		Image imageexit = iconexit.getImage();
		int maxWidthexit = 20; // chiều rộng tối đa của biểu tượng
		int maxHeightexit = 20; // chiều cao tối đa của biểu tượng
		int widthexit = imageexit.getWidth(null);
		int heightexit = imageexit.getHeight(null);
		double scaleexit = Math.min((double) maxWidthexit / widthexit, (double) maxHeightexit / heightexit);
		int Widthexit = (int) (widthexit * scaleexit);
		int Heightexit = (int) (heightexit * scaleexit);
		BufferedImage Imageexit = new BufferedImage(Widthexit, Heightexit, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gexit = Imageexit.createGraphics();
		gexit.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		gexit.drawImage(imageexit, 0, 0, Widthexit, Heightexit, null);
		gexit.dispose();
		
		ImageIcon Iconexit = new ImageIcon(Imageexit);
		JLabel usernameLabel = new JLabel("Username",Iconuser,0);
		usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		usernameLabel.setBounds(41, 84, 125, 24);
		contentPane.add(usernameLabel);
		
		usernametextField = new JTextField();
		usernametextField.setBounds(184, 84, 228, 24);
		contentPane.add(usernametextField);
		usernametextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password",Iconpassword,0);
		passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		passwordLabel.setBounds(41, 129, 125, 24);
		contentPane.add(passwordLabel);
		
		JButton dangnhapButton = new JButton("Đăng nhập");
		dangnhapButton.setForeground(new Color(255, 255, 255));
		dangnhapButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dangnhapButton.setBackground(new Color(0, 0, 255));
		dangnhapButton.setBounds(154, 181, 125, 34);
		dangnhapButton.addActionListener(ac);
		contentPane.add(dangnhapButton);
		
		JButton thoatButton = new JButton("Thoát",Iconexit);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		thoatButton.setBorder(emptyBorder);
		thoatButton.setHorizontalAlignment(SwingConstants.LEFT);
		thoatButton.setBackground(new Color(255, 255, 255));
		thoatButton.setBounds(327, 219, 99, 34);
		thoatButton.setFocusable(false);
		thoatButton.setFocusPainted(false);
		thoatButton.addActionListener(ac);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(184, 132, 228, 24);
		contentPane.add(passwordField);
		
		JLabel dangnhapLabel = new JLabel("Đăng nhập");
		dangnhapLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		dangnhapLabel.setBounds(147, 10, 132, 34);
		contentPane.add(dangnhapLabel);
		
	}
}
