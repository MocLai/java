package view;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controller.thietbi_Listener;
import model.Thietbi;
import model.ThietbiService;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class thietbiJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField mathietbitextField;
	public JTextField tenthietbitextField;
	public JTextField dvttextField;
	public JTextField soluongtextField;
	public JTable table;
	public ThietbiService thietbiService;
	public Thietbi thietbi;
	public DefaultTableModel defaultTableModel;
	public JButton luuButton;
	public JTextField timtextField;
	public final ButtonGroup buttonGroup = new ButtonGroup();
	public JRadioButton hongRadioButton;
	public JRadioButton binhthuongRadioButton;
	public thietbiJFrame() {
		
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
	}public boolean kiemtramatb(List<Thietbi> thietbis, String matb) {
	    for (Thietbi thietbi : thietbis) {
	        if (thietbi.getMatb().equals(matb)) {
	            return true; // nếu tìm thấy giá trị matb trùng thì trả về true
	        }
	    }
	    return false; // nếu không tìm thấy giá trị matb trùng thì trả về false
	}
	public void init() {
		this.setTitle("Danh mục thiết bị");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(13, 162, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Color c = new Color(255, 255, 255);
		Color cButton = new Color(0, 0, 255);
		JLabel tieudeLabel = new JLabel("DANH MỤC THIẾT BỊ");
		tieudeLabel.setForeground(c);
		tieudeLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		tieudeLabel.setBackground(new Color(255, 255, 255));
		tieudeLabel.setBounds(330, 10, 256, 33);
		contentPane.add(tieudeLabel);
		ActionListener ac = new thietbi_Listener(this);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 159, 828, 2);
		contentPane.add(separator);
		JLabel mathietbiLabel = new JLabel("Mã thiết bị");
		mathietbiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mathietbiLabel.setBounds(79, 65, 106, 25);
		mathietbiLabel.setForeground(c);
		contentPane.add(mathietbiLabel);
		
		mathietbitextField = new JTextField();
		mathietbitextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mathietbitextField.setBounds(195, 66, 225, 25);
		contentPane.add(mathietbitextField);
		mathietbitextField.setColumns(10);
		
		JLabel tenthietbiLabel = new JLabel("Tên thiết bị");
		tenthietbiLabel.setBounds(79, 100, 106, 25);
		tenthietbiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tenthietbiLabel.setForeground(c);
		contentPane.add(tenthietbiLabel);
		
		tenthietbitextField = new JTextField();
		tenthietbitextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tenthietbitextField.setBounds(195, 101, 225, 25);
		contentPane.add(tenthietbitextField);
		tenthietbitextField.setColumns(10);
		
		JLabel donvitinhLabel = new JLabel("Đơn vị tính");
		donvitinhLabel.setBounds(451, 65, 99, 25);
		donvitinhLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		donvitinhLabel.setForeground(c);
		contentPane.add(donvitinhLabel);
		
		dvttextField = new JTextField();
		dvttextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		dvttextField.setBounds(560, 66, 225, 25);
		contentPane.add(dvttextField);
		dvttextField.setColumns(10);
		
		JLabel soluongLabel = new JLabel("Số lượng");
		soluongLabel.setBounds(451, 100, 99, 25);
		soluongLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		soluongLabel.setForeground(c);
		contentPane.add(soluongLabel);
		
		soluongtextField = new JTextField();
		soluongtextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		soluongtextField.setBounds(560, 101, 225, 25);
		contentPane.add(soluongtextField);
		
		
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
		scrollPane.setBounds(79, 202, 752, 162);
		contentPane.add(scrollPane);
		java.net.URL urlxoa = NguoimuonJFrame.class.getResource("/icon/delete.png");
		ImageIcon iconxoa = new ImageIcon(urlxoa);
		Image imagexoa = iconxoa.getImage();
		int maxWidthxoa = 20; // chiều rộng tối đa của biểu tượng
		int maxHeightxoa = 20; // chiều cao tối đa của biểu tượng
		int widthxoa = imagexoa.getWidth(null);
		int heightxoa = imagexoa.getHeight(null);
		double scalexoa = Math.min((double) maxWidthxoa / widthxoa, (double) maxHeightxoa / heightxoa);
		int Widthxoa = (int) (widthxoa * scalexoa);
		int Heightxoa = (int) (heightxoa * scalexoa);
		BufferedImage Imagexoa = new BufferedImage(Widthxoa, Heightxoa, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gxoa = Imagexoa.createGraphics();
		gxoa.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		gxoa.drawImage(imagexoa, 0, 0, Widthxoa, Heightxoa, null);
		gxoa.dispose();
		ImageIcon Iconxoa = new ImageIcon(Imagexoa);
		java.net.URL urlsua = NguoimuonJFrame.class.getResource("/icon/edit.png");
		ImageIcon iconsua = new ImageIcon(urlsua);
		Image imagesua = iconsua.getImage();
		int maxWidthsua = 20; // chiều rộng tối đa của biểu tượng
		int maxHeightsua = 20; // chiều cao tối đa của biểu tượng
		int widthsua = imagesua.getWidth(null);
		int heightsua = imagesua.getHeight(null);
		double scalesua = Math.min((double) maxWidthsua / widthsua, (double) maxHeightsua / heightsua);
		int Widthsua = (int) (widthsua * scalesua);
		int Heightsua = (int) (heightsua * scalesua);
		BufferedImage Imagesua = new BufferedImage(Widthsua, Heightsua, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gsua = Imagesua.createGraphics();
		gsua.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		gsua.drawImage(imagesua, 0, 0, Widthsua, Heightsua, null);
		gsua.dispose();
		ImageIcon Iconsua = new ImageIcon(Imagesua);
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
		java.net.URL urlboqua = NguoimuonJFrame.class.getResource("/icon/skip.png");
		ImageIcon iconboqua = new ImageIcon(urlboqua);
		Image imageboqua = iconboqua.getImage();
		int maxWidthboqua = 20; // chiều rộng tối đa của biểu tượng
		int maxHeightboqua = 20; // chiều cao tối đa của biểu tượng
		int widthboqua = imageboqua.getWidth(null);
		int heightboqua = imageboqua.getHeight(null);
		double scaleboqua = Math.min((double) maxWidthboqua / widthboqua, (double) maxHeightboqua / heightboqua);
		int Widthboqua = (int) (widthboqua * scaleboqua);
		int Heightboqua = (int) (heightboqua * scaleboqua);
		BufferedImage Imageboqua = new BufferedImage(Widthboqua, Heightboqua, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gboqua = Imageboqua.createGraphics();
		gboqua.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		gboqua.drawImage(imageboqua, 0, 0, Widthboqua, Heightboqua, null);
		gboqua.dispose();
		ImageIcon Iconboqua = new ImageIcon(Imageboqua);
		java.net.URL urlluu = NguoimuonJFrame.class.getResource("/icon/save.png");
		ImageIcon iconluu = new ImageIcon(urlluu);
		Image imageluu = iconluu.getImage();
		int maxWidthluu = 20; // chiều rộng tối đa của biểu tượng
		int maxHeightluu = 20; // chiều cao tối đa của biểu tượng
		int widthluu = imageluu.getWidth(null);
		int heightluu = imageluu.getHeight(null);
		double scaleluu = Math.min((double) maxWidthluu / widthluu, (double) maxHeightluu / heightluu);
		int Widthluu = (int) (widthluu * scaleluu);
		int Heightluu = (int) (heightluu * scaleluu);
		BufferedImage Imageluu = new BufferedImage(Widthluu, Heightluu, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gluu = Imageluu.createGraphics();
		gluu.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		gluu.drawImage(imageluu, 0, 0, Widthluu, Heightluu, null);
		gluu.dispose();
		ImageIcon Iconluu = new ImageIcon(Imageluu);
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
		java.net.URL urlThem = NguoimuonJFrame.class.getResource("/icon/add.png");
		ImageIcon iconThem = new ImageIcon(urlThem);
		Image imageThem = iconThem.getImage();
		int maxWidthThem = 20; // chiều rộng tối đa của biểu tượng
		int maxHeightThem = 20; // chiều cao tối đa của biểu tượng
		int widthThem = imageThem.getWidth(null);
		int heightThem = imageThem.getHeight(null);
		double scaleThem = Math.min((double) maxWidthThem / widthThem, (double) maxHeightThem / heightThem);
		int WidthThem = (int) (widthThem * scaleThem);
		int HeightThem = (int) (heightThem * scaleThem);
		BufferedImage ImageThem = new BufferedImage(WidthThem, HeightThem, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gThem = ImageThem.createGraphics();
		gThem.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		gThem.drawImage(imageThem, 0, 0, WidthThem, HeightThem, null);
		gThem.dispose();
		ImageIcon IconThem = new ImageIcon(ImageThem);
		JButton themButton = new JButton("Thêm", IconThem);
		themButton.setForeground(Color.WHITE);
		themButton.setBackground(Color.BLUE);
		themButton.setBounds(79, 374, 117, 33);
		themButton.addActionListener(ac);
		contentPane.add(themButton);
		JButton xoaButton = new JButton("Xóa",Iconxoa);
		xoaButton.setBackground(cButton);
		xoaButton.setBounds(205, 374, 117, 33);
		xoaButton.setForeground(c);
		xoaButton.addActionListener(ac);
		contentPane.add(xoaButton);
		
		JButton suaButton = new JButton("Sửa",Iconsua);
		suaButton.setBackground(cButton);
		suaButton.setBounds(332, 374, 117, 33);
		suaButton.setForeground(c);
		suaButton.addActionListener(ac);
		contentPane.add(suaButton);
		
		JButton lammoiButton = new JButton("Làm mới",Iconlammoi);
		lammoiButton.setBackground(cButton);
		lammoiButton.setBounds(459, 374, 117, 33);
		lammoiButton.setForeground(c);
		lammoiButton.addActionListener(ac);
		contentPane.add(lammoiButton);
		
		JButton boquaButton = new JButton("Bỏ qua",Iconboqua);
		boquaButton.setBackground(cButton);
		boquaButton.setBounds(586, 374, 117, 33);
		boquaButton.setForeground(c);
		boquaButton.addActionListener(ac);
		contentPane.add(boquaButton);
		
		luuButton = new JButton("Lưu",Iconluu);
		luuButton.setBackground(cButton);
		luuButton.setBounds(713, 374, 117, 33);
		luuButton.setForeground(c);
		luuButton.addActionListener(ac);
		contentPane.add(luuButton);
		
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
		thoatButton.setBounds(777, 419, 99, 34);
		thoatButton.addActionListener(ac);
		contentPane.add(thoatButton);
		
		JButton TrangchuButton = new JButton("",IconTrangchu);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		TrangchuButton.setBorder(emptyBorder);
		TrangchuButton.setForeground(Color.WHITE);
		TrangchuButton.setBackground(new Color(13, 162, 242));
		TrangchuButton.setBounds(10, 10, 60, 60);
		TrangchuButton.addActionListener(ac);
		contentPane.add(TrangchuButton);
		JLabel lblBngThitB = new JLabel("Bảng thiết bị");
		lblBngThitB.setForeground(Color.WHITE);
		lblBngThitB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBngThitB.setBackground(Color.WHITE);
		lblBngThitB.setBounds(79, 164, 127, 33);
		contentPane.add(lblBngThitB);
		
		JButton timButton = new JButton("Tìm");
		timButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		timButton.setBounds(771, 169, 60, 25);
		timButton.addActionListener(ac);
		contentPane.add(timButton);
		
		timtextField = new JTextField();
		timtextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		timtextField.setColumns(10);
		timtextField.setBounds(597, 169, 164, 25);
		contentPane.add(timtextField);
		JLabel trangthaiLabel = new JLabel("Trạng thái");
		trangthaiLabel.setForeground(new Color(255, 255, 255));
		trangthaiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		trangthaiLabel.setBounds(451, 129, 88, 25);
		contentPane.add(trangthaiLabel);
		
		binhthuongRadioButton = new JRadioButton("Bình thường");
		binhthuongRadioButton.setSelected(true);
		buttonGroup.add(binhthuongRadioButton);
		binhthuongRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		binhthuongRadioButton.setBackground(Color.WHITE);
		binhthuongRadioButton.setBounds(560, 132, 103, 21);
		contentPane.add(binhthuongRadioButton);
		
		hongRadioButton = new JRadioButton("Hỏng");
		buttonGroup.add(hongRadioButton);
		hongRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		hongRadioButton.setBackground(Color.WHITE);
		hongRadioButton.setBounds(682, 132, 103, 21);
		contentPane.add(hongRadioButton);
	}
	public void xoafrom() {
		// TODO Auto-generated method stub
		mathietbitextField.setText("");
		tenthietbitextField.setText("");
		dvttextField.setText("");
		soluongtextField.setText("");
		buttonGroup.clearSelection();
	}
}
