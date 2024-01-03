package view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Trangchu_Listener;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
public class Trangchu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Trangchu() {
		this.init();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		}
	public void init() {
		this.setTitle("Quản lý thiết bị");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener ac = new Trangchu_Listener(this);
		JButton nguoimuonButton = new JButton("Quản lý người mượn");
		nguoimuonButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nguoimuonButton.setBounds(10, 113, 243, 50);
		nguoimuonButton.addActionListener(ac);
		
		JButton phanloaithietbiButton = new JButton("Quản lý phân loại thiết bị");
		phanloaithietbiButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		phanloaithietbiButton.setBounds(10, 233, 243, 50);
		phanloaithietbiButton.addActionListener(ac);
		contentPane.add(phanloaithietbiButton);
		
		JButton quanlymuontraButton = new JButton("Quản lý mượn - trả");
		quanlymuontraButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		quanlymuontraButton.setBounds(10, 293, 243, 50);
		quanlymuontraButton.addActionListener(ac);
		contentPane.add(quanlymuontraButton);
		
		JButton thoatButton = new JButton("Thoát");
		thoatButton.setBounds(641, 382, 85, 21);
		thoatButton.addActionListener(ac);
		contentPane.add(thoatButton);
		contentPane.add(nguoimuonButton);
		
		JButton thietbiButton = new JButton("Quản lý thiết bị");
		thietbiButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		thietbiButton.setBounds(10, 173, 243, 50);
		thietbiButton.addActionListener(ac);
		contentPane.add(thietbiButton);
		
		JButton thongkebaocaoButton = new JButton("Thống kê báo cáo");
		thongkebaocaoButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		thongkebaocaoButton.setBounds(10, 353, 243, 50);
		thongkebaocaoButton.addActionListener(ac);
		contentPane.add(thongkebaocaoButton);
		
		java.net.URL urlNen = NguoimuonJFrame.class.getResource("/icon/nen.jpg");
		ImageIcon iconNen = new ImageIcon(urlNen);
		Image imageNen = iconNen.getImage();
		int maxWidthNen = 790; // chiều rộng tối đa của biểu tượng
		int maxHeightNen = 460; // chiều cao tối đa của biểu tượng
		int widthNen = imageNen.getWidth(null);
		int heightNen = imageNen.getHeight(null);
		double scaleNen = Math.min((double) maxWidthNen / widthNen, (double) maxHeightNen / heightNen);
		int WidthNen = (int) (widthNen * scaleNen);
		int HeightNen = (int) (heightNen * scaleNen);
		BufferedImage ImageNen = new BufferedImage(WidthNen, HeightNen, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gNen = ImageNen.createGraphics();
		gNen.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		gNen.drawImage(imageNen, 0, 0, WidthNen, HeightNen, null);
		gNen.dispose();
		ImageIcon IconNen = new ImageIcon(ImageNen);
		JLabel lblNewLabel = new JLabel(IconNen);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(0, 0, 736, 413);
		contentPane.add(lblNewLabel);
		
	}
}
