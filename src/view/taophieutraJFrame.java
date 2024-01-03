package view;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controller.taophieutra_Listener;
import model.Nguoimuon;
import model.NguoimuonService;
import model.Phieutra;
import model.PhieutraService;
import model.Thietbi;
import model.ThietbiService;
import java.awt.Color;
import javax.swing.JSeparator;

public class taophieutraJFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTable table;
	public DefaultTableModel defaultTableModel;
	public JTextField sophieutratextField;
	public JTextField tennguoimuontextField;
	public JTextField ngaytratextField;
	public JTextField soluongtratextField;
	private JPanel contentPane;
	private JLabel manguoimuonLabel;
	public ThietbiService thietbiService;
	public PhieutraService phieutraService;
	public Phieutra phieutra;
	public NguoimuonService nguoimuonService;
	public Nguoimuon nguoimuon;
	public Thietbi thietbi;
	public taophieutraJFrame(String manm) {
		phieutraService = new PhieutraService(null);
		phieutra = new Phieutra();
		nguoimuonService = new NguoimuonService(null);
		nguoimuon = nguoimuonService.getNguoimuonBymanm(manm);
		thietbiService = new ThietbiService(null);
		thietbi = new Thietbi();
		this.init();
		this.setLocationRelativeTo(null);
		tennguoimuontextField.setText(nguoimuon.getTennm());
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
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 166, 866, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Bảng các thiết bị đã mượn");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(20, 180, 264, 39);
		contentPane.add(lblNewLabel_1);
		
		defaultTableModel.addColumn("Mã thiết bị");
		defaultTableModel.addColumn("Tên thiết bị");
		defaultTableModel.addColumn("Ngày mưượn");
		defaultTableModel.addColumn("Số lượng mượn");
		
		settableData(thietbiService.getThietbiChuatras(manm));
		this.setVisible(true);
	}
	public void settableData(List<Thietbi> thietbis) {
		for (Thietbi thietbi : thietbis) {
			defaultTableModel.addRow(new Object[] {thietbi.getMatb(), thietbi.getTentb(), thietbi.getNgaymuon(),thietbi.getSoluongmuon()});
		}
	}public boolean kiemtrasopt(List<Phieutra> phieutras, String sopt) {
		for(Phieutra phieutra : phieutras) {
			if(phieutra.getSopt().equals(sopt)) {
				return true;
			}
		}
		return false;
	}public boolean kiemtrasonguyen(String songuyen) {
		try {
			Integer.parseInt(songuyen);
			return true;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
public void init() {
	this.setTitle("Tạo phiếu trả");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 900, 500);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(13, 162, 242));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	JLabel sophieutraLabel = new JLabel("Số phiếu trả");
	sophieutraLabel.setForeground(new Color(255, 255, 255));
	sophieutraLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	sophieutraLabel.setBounds(79, 81, 125, 27);
	contentPane.add(sophieutraLabel);
	sophieutratextField = new JTextField();
	sophieutratextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	sophieutratextField.setBounds(236, 81, 178, 27);
	contentPane.add(sophieutratextField);
	sophieutratextField.setColumns(10);
	ActionListener ac = new taophieutra_Listener(this);
	tennguoimuontextField = new JTextField();
	tennguoimuontextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	tennguoimuontextField.setColumns(10);
	tennguoimuontextField.setEditable(false);
	tennguoimuontextField.setBounds(236, 113, 178, 30);
	contentPane.add(tennguoimuontextField);
	
	manguoimuonLabel = new JLabel("Tên người mượn");
	manguoimuonLabel.setForeground(new Color(255, 255, 255));
	manguoimuonLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	manguoimuonLabel.setBounds(79, 118, 137, 27);
	contentPane.add(manguoimuonLabel);
	
	ngaytratextField = new JTextField();
	ngaytratextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	ngaytratextField.setColumns(10);
	ngaytratextField.setBounds(653, 113, 178, 30);
	contentPane.add(ngaytratextField);
	
	JLabel ngaytraLabel = new JLabel("Ngày trả");
	ngaytraLabel.setForeground(new Color(255, 255, 255));
	ngaytraLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	ngaytraLabel.setBounds(518, 118, 125, 27);
	contentPane.add(ngaytraLabel);
	
	soluongtratextField = new JTextField();
	soluongtratextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	soluongtratextField.setColumns(10);
	soluongtratextField.setBounds(653, 81, 178, 27);
	contentPane.add(soluongtratextField);
	
	JLabel soluongtraLabel = new JLabel("Số lượng trả");
	soluongtraLabel.setForeground(new Color(255, 255, 255));
	soluongtraLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	soluongtraLabel.setBounds(518, 81, 125, 27);
	contentPane.add(soluongtraLabel);
	
	JButton taophieuButton = new JButton("Tạo phiếu");
	taophieuButton.setForeground(new Color(255, 255, 255));
	taophieuButton.setBackground(new Color(0, 0, 255));
	taophieuButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	taophieuButton.setBounds(373, 414, 125, 39);
	taophieuButton.addActionListener(ac);
	contentPane.add(taophieuButton);
	
	JButton xoaButton = new JButton("Quay lại");
	xoaButton.setForeground(new Color(255, 255, 255));
	xoaButton.setBackground(new Color(0, 0, 255));
	xoaButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	xoaButton.setBounds(751, 414, 125, 39);
	xoaButton.addActionListener(ac);
	contentPane.add(xoaButton);
	
	JLabel lblNewLabel = new JLabel("Tạo phiếu trả");
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
	lblNewLabel.setBounds(355, 10, 178, 44);
	contentPane.add(lblNewLabel);
	
	table = new JTable();
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
					"Mã thiết bị", "Tên thiết bị", "Ngày mượn", "Số lượng mượn"
			}
			));
	JScrollPane scrollPane = new JScrollPane(table);
	scrollPane.setBounds(10, 229, 866, 175);
	contentPane.add(scrollPane);
	}
}
