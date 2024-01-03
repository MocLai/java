package view;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.quanlymuontra_Listener;
import model.Nguoimuon;
import model.NguoimuonService;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class QuanlymuontraJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public Nguoimuon nguoimuon;
	public NguoimuonService nguoimuonService;
	public JTable table;
	public JLabel lblQunLMntr;
	public JTextField timtextField;
	public JButton taophieumuonButton;
	public JButton taophieutraButton;
	public DefaultTableModel defaultTableModel;
	public QuanlymuontraJFrame() {
		nguoimuonService = new NguoimuonService(null);
		nguoimuon = new Nguoimuon();
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
		
		
		
		defaultTableModel.addColumn("Mã người mượn");
		defaultTableModel.addColumn("Tên người mượn");
		defaultTableModel.addColumn("Địa chỉ");
		defaultTableModel.addColumn("SĐT");
		settableData(nguoimuonService.getAllNguoimuons());
		this.setVisible(true);
	}
	public void settableData(List<Nguoimuon> nguoimuons) {
		for (Nguoimuon nguoimuon : nguoimuons) {
			defaultTableModel.addRow(new Object[] {nguoimuon.getManm(), nguoimuon.getTennm(),nguoimuon.getDiachi(),nguoimuon.getSdt()});
		}
	}
	public void init() {
		this.setTitle("Quản lý mượn-trả");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(13, 162, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Mã người mượn", "Tên người mượn", "Địa chỉ", "Sđt"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(58, 141, 659, 175);
		contentPane.add(scrollPane);
		ActionListener ac = new quanlymuontra_Listener(this);
		lblQunLMntr = new JLabel("Quản lý mượn-trả");
		lblQunLMntr.setForeground(Color.WHITE);
		lblQunLMntr.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblQunLMntr.setBackground(Color.WHITE);
		lblQunLMntr.setBounds(258, 10, 238, 33);
		contentPane.add(lblQunLMntr);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(58, 85, 659, 13);
		contentPane.add(separator);
		
		timtextField = new JTextField();
		timtextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		timtextField.setColumns(10);
		timtextField.setBounds(483, 108, 164, 23);
		contentPane.add(timtextField);
		
		JButton timButton = new JButton("Tìm");
		timButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		timButton.setBounds(657, 108, 60, 23);
		timButton.addActionListener(ac);
		contentPane.add(timButton);
		
		JLabel bangnguoimuonLabel = new JLabel("Bảng người mượn");
		bangnguoimuonLabel.setForeground(Color.WHITE);
		bangnguoimuonLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		bangnguoimuonLabel.setBounds(58, 92, 199, 39);
		contentPane.add(bangnguoimuonLabel);
		java.net.URL urlthem = NguoimuonJFrame.class.getResource("/icon/add.png");
		ImageIcon iconthem = new ImageIcon(urlthem);
		Image imagethem = iconthem.getImage();
		int maxWidth = 20; // chiều rộng tối đa của biểu tượng
		int maxHeight = 20; // chiều cao tối đa của biểu tượng
		int widththem = imagethem.getWidth(null);
		int heightthem = imagethem.getHeight(null);
		double scalethem = Math.min((double) maxWidth / widththem, (double) maxHeight / heightthem);
		int Widththem = (int) (widththem * scalethem);
		int Heightthem = (int) (heightthem * scalethem);
		BufferedImage Imagethem = new BufferedImage(Widththem, Heightthem, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gthem = Imagethem.createGraphics();
		gthem.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		gthem.drawImage(imagethem, 0, 0, Widththem, Heightthem, null);
		gthem.dispose();
		ImageIcon Iconthem = new ImageIcon(Imagethem);
		taophieumuonButton = new JButton("Tạo ghi mượn nhanh", Iconthem);
		taophieumuonButton.setHorizontalAlignment(SwingConstants.LEFT);
		taophieumuonButton.setForeground(Color.WHITE);
		taophieumuonButton.setBackground(Color.BLUE);
		taophieumuonButton.setBounds(58, 327, 183, 33);
		taophieumuonButton.addActionListener(ac);
		contentPane.add(taophieumuonButton);
		
		taophieutraButton = new JButton("Tạo phiếu trả", Iconthem);
		taophieutraButton.setHorizontalAlignment(SwingConstants.LEFT);
		taophieutraButton.setForeground(Color.WHITE);
		taophieutraButton.setBackground(Color.BLUE);
		taophieutraButton.setBounds(251, 327, 151, 33);
		taophieutraButton.addActionListener(ac);
		contentPane.add(taophieutraButton);
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
		JButton TrangchuButton = new JButton("",IconTrangchu);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		TrangchuButton.setBorder(emptyBorder);
		TrangchuButton.setForeground(Color.WHITE);
		TrangchuButton.setBackground(new Color(13, 162, 242));
		TrangchuButton.setBounds(10, 10, 60, 60);
		TrangchuButton.addActionListener(ac);
		contentPane.add(TrangchuButton);
		java.net.URL urllammoi = NguoimuonJFrame.class.getResource("/icon/refresh.png");
		ImageIcon iconlammoi = new ImageIcon(urllammoi);
		Image imagelammoi = iconlammoi.getImage();
		int maxWidthlammoi = 20; // chiều rộng tối đa của biểu tượng
		int maxHeightlammoi = 20; // chiều cao tối đa của biểu tượng
		int widthlammoi = imagelammoi.getWidth(null);
		int heightlammoi = imagelammoi.getHeight(null);
		double scalelammoi = Math.min((double) maxWidthlammoi / widthlammoi, (double) maxHeightlammoi / heightlammoi);
		int Widthlammoi = (int) (widthlammoi * scalelammoi);
		int Heightlammoi = (int) (heightlammoi * scalelammoi);
		BufferedImage Imagelammoi = new BufferedImage(Widthlammoi, Heightlammoi, BufferedImage.TYPE_INT_ARGB);
		Graphics2D glammoi = Imagelammoi.createGraphics();
		glammoi.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		glammoi.drawImage(imagelammoi, 0, 0, Widthlammoi, Heightlammoi, null);
		glammoi.dispose();
		ImageIcon Iconlammoi = new ImageIcon(Imagelammoi);
		JButton lammoiButton = new JButton("Làm mới",Iconlammoi);
		lammoiButton.setForeground(Color.WHITE);
		lammoiButton.setBackground(Color.BLUE);
		lammoiButton.setBounds(412, 327, 117, 33);
		lammoiButton.addActionListener(ac);
		contentPane.add(lammoiButton);
		
	}
}
