package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class danhsachmuontraJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable table;
	private JTextField timtextField;
	public danhsachmuontraJFrame() {
		this.init();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void init() {
		this.setTitle("Danh sách mượn - trả");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(13, 162, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDanhSchMntr = new JLabel("DANH SÁCH MƯỢN-TRẢ");
		lblDanhSchMntr.setForeground(Color.WHITE);
		lblDanhSchMntr.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblDanhSchMntr.setBackground(Color.WHITE);
		lblDanhSchMntr.setBounds(255, 10, 265, 33);
		contentPane.add(lblDanhSchMntr);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 63, 716, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Bảng danh sách mượn - trả");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(38, 75, 224, 24);
		contentPane.add(lblNewLabel);
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Mã người mượn", "Mã thiết bị", "Ngày mượn", "Ngày trả", "Số lượng mượn", "Số lượng trả"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(38, 109, 716, 175);
		contentPane.add(scrollPane);
		
		JButton timButton = new JButton("Tìm");
		timButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		timButton.setBounds(678, 75, 60, 23);
		contentPane.add(timButton);
		
		timtextField = new JTextField();
		timtextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		timtextField.setColumns(10);
		timtextField.setBounds(504, 75, 164, 23);
		contentPane.add(timtextField);
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
		JButton thoatButton = new JButton("Thoát",Iconexit);
		thoatButton.setHorizontalAlignment(SwingConstants.LEFT);
		thoatButton.setFocusable(false);
		thoatButton.setFocusPainted(false);
		thoatButton.setBackground(Color.WHITE);
		thoatButton.setBounds(677, 369, 99, 34);
		
		contentPane.add(thoatButton);
	}
}
