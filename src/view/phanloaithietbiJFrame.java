package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.loaithietbi_Listener;
import model.Thietbi;
import model.ThietbiService;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class phanloaithietbiJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable table;
	public JTextField loaithietbitextField;
	public DefaultTableModel defaultTableModel;
	public ThietbiService thietbiService;
	public Thietbi thietbi;
	public JTextField timtextField;
	public phanloaithietbiJFrame() {
		thietbiService = new ThietbiService(null);
		thietbi = new Thietbi();
		this.init();
		this.setLocationRelativeTo(null);
		defaultTableModel = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		table.setModel(defaultTableModel);

		defaultTableModel.addColumn("Mã thiết bị");
		defaultTableModel.addColumn("Tên thiết bị");
		defaultTableModel.addColumn("Loại thiết bị");
		defaultTableModel.addColumn("Đơn vị tính");
		defaultTableModel.addColumn("Số lượng");
		defaultTableModel.addColumn("Trạng thái");
		
		settableData(thietbiService.getAllThietbis());
		this.setVisible(true);
	}
	public void settableData(List<Thietbi> thietbis) {
		for (Thietbi thietbi : thietbis) {
			defaultTableModel.addRow(new Object[] {thietbi.getMatb(), thietbi.getTentb(),thietbi.getLoaitb(), thietbi.getDvt(),thietbi.getSoluong(),thietbi.getTrangthai()});
		}
	}
	public void init() {
		this.setTitle("Quản lý phân loại thiết bị");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(13, 162, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQunLLoi = new JLabel("Quản lý phân loại thiết bị");
		lblQunLLoi.setForeground(Color.WHITE);
		lblQunLLoi.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblQunLLoi.setBackground(Color.WHITE);
		lblQunLLoi.setBounds(324, 10, 247, 33);
		contentPane.add(lblQunLLoi);
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
				"Mã thiết bị", "Tên thiết bị", "Loại thiết bị", "Đơn vị tính", "Số lượng", "Trạng thái"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(76, 157, 752, 175);
		contentPane.add(scrollPane);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(39, 76, 813, 2);
		contentPane.add(separator);
		ActionListener ac = new loaithietbi_Listener(this);
		JLabel lblNewLabel = new JLabel("Bảng thiết bị");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(76, 120, 122, 24);
		contentPane.add(lblNewLabel);

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
		JButton thoatButton = new JButton("Thoát", Iconexit);
		thoatButton.setHorizontalAlignment(SwingConstants.LEFT);
		thoatButton.setFocusable(false);
		thoatButton.setFocusPainted(false);
		thoatButton.setBackground(Color.WHITE);
		thoatButton.setBounds(777, 419, 99, 34);
		thoatButton.addActionListener(ac);
		contentPane.add(thoatButton);
		
		JLabel loaithietbiLabel = new JLabel("Nhập loại thiết bị");
		loaithietbiLabel.setForeground(Color.WHITE);
		loaithietbiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		loaithietbiLabel.setBounds(76, 342, 152, 26);
		contentPane.add(loaithietbiLabel);
		
		loaithietbitextField = new JTextField();
		loaithietbitextField.setColumns(10);
		loaithietbitextField.setBounds(238, 342, 179, 25);
		contentPane.add(loaithietbitextField);
		
		JButton luuButton = new JButton("Lưu");
		luuButton.setBackground(new Color(0, 0, 255));
		luuButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		luuButton.setForeground(new Color(255, 255, 255));
		luuButton.addActionListener(ac);
		luuButton.setBounds(448, 342, 85, 26);
		contentPane.add(luuButton);
		timtextField = new JTextField();
		timtextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		timtextField.setColumns(10);
		timtextField.setBounds(594, 124, 164, 23);
		contentPane.add(timtextField);
		
		JButton timButton = new JButton("Tìm");
		timButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		timButton.setBounds(768, 124, 60, 23);
		timButton.addActionListener(ac);
		contentPane.add(timButton);
		java.net.URL urlTrangchu = NguoimuonJFrame.class.getResource("/icon/homepage.png");
		ImageIcon iconTrangchu = new ImageIcon(urlTrangchu);
		Image imageTrangchu = iconTrangchu.getImage();
		int maxWidthTrangchu = 60; // chiều rộng tối đa của biểu tượng
		int maxHeightTrangchu = 60; // chiều cao tối đa của biểu tượng
		int widthTrangchu = imageTrangchu.getWidth(null);
		int heightTrangchu = imageTrangchu.getHeight(null);
		double scaleTrangchu = Math.min((double) maxWidthTrangchu / widthTrangchu, (double) maxHeightTrangchu / heightTrangchu);
		int WidthTrangchu = (int) (widthTrangchu * scaleTrangchu);
		int HeightTrangchu = (int) (heightTrangchu * scaleTrangchu);
		BufferedImage ImageTrangchu = new BufferedImage(WidthTrangchu, HeightTrangchu, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gTrangchu = ImageTrangchu.createGraphics();
		gTrangchu.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		gTrangchu.drawImage(imageTrangchu, 0, 0, WidthTrangchu, HeightTrangchu, null);
		gTrangchu.dispose();
		ImageIcon IconTrangchu = new ImageIcon(ImageTrangchu);
		JButton TrangchuButton = new JButton("", IconTrangchu);
		TrangchuButton.setForeground(Color.WHITE);
		TrangchuButton.setBackground(new Color(13, 162, 242));
		TrangchuButton.setBounds(10, 10, 60, 60);
		TrangchuButton.addActionListener(ac);
		contentPane.add(TrangchuButton);
		
		JButton lammoiButton = new JButton("Làm mới");
		lammoiButton.setForeground(Color.WHITE);
		lammoiButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lammoiButton.setBackground(Color.BLUE);
		lammoiButton.setBounds(543, 342, 113, 26);
		lammoiButton.addActionListener(ac);
		contentPane.add(lammoiButton);
	}
}
