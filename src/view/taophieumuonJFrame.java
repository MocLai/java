package view;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.taophieumuon_Listener;
import model.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;

public class taophieumuonJFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable table;
	public ThietbiService thietbiService;
	public DefaultTableModel defaultTableModel;
	public Thietbi thietbi;
	public JTextField sophieutextField;
	public JTextField tennguoimuontextField;
	public JTextField ngaymuontextField;
	public JTextField soluongmuontextField;
	public NguoimuonService nguoimuonService;
	public Nguoimuon nguoimuon ;
	public Phieumuon phieumuon;
	public PhieumuonService phieumuonService;
	public taophieumuonJFrame(String manm) {
		phieumuonService = new PhieumuonService(null);
		phieumuon = new Phieumuon();
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
		separator.setBounds(10, 170, 866, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Bảng thiết bị");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(10, 180, 137, 39);
		contentPane.add(lblNewLabel_1);
		
		defaultTableModel.addColumn("Mã thiết bị");
		defaultTableModel.addColumn("Tên thiết bị");
		defaultTableModel.addColumn("Đơn vị tính");
		defaultTableModel.addColumn("Số lượng");
		defaultTableModel.addColumn("Trạng thái");
		settableData(thietbiService.getAllThietbis());
		
		this.setVisible(true);
		
	}
	public void settableData(List<Thietbi> thietbis) {
		for (Thietbi thietbi : thietbis) {
			defaultTableModel.addRow(new Object[] {thietbi.getMatb(), thietbi.getTentb(), thietbi.getDvt(),thietbi.getSoluong(),thietbi.getTrangthai()});
		}
	}public boolean kiemtrasopm(List<Phieumuon> phieumuons, String sopm) {
		for(Phieumuon phieumuon : phieumuons) {
			 if (phieumuon.getSopm().equals(sopm)) {
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
		this.setTitle("Tạo phiếu mượn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel sophieuLabel = new JLabel("Số phiếu mượn");
		sophieuLabel.setForeground(new Color(255, 255, 255));
		sophieuLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		sophieuLabel.setBounds(89, 83, 125, 27);
		contentPane.add(sophieuLabel);
		
		sophieutextField = new JTextField();
		sophieutextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		sophieutextField.setForeground(new Color(0, 0, 0));
		sophieutextField.setBounds(239, 84, 185, 24);
		contentPane.add(sophieutextField);
		sophieutextField.setColumns(10);
		
		tennguoimuontextField = new JTextField();
		tennguoimuontextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tennguoimuontextField.setForeground(new Color(0, 0, 0));
		tennguoimuontextField.setColumns(10);
		tennguoimuontextField.setEditable(false);
		tennguoimuontextField.setBounds(239, 118, 185, 27);
		contentPane.add(tennguoimuontextField);
		
		JLabel lblTnNgiMn = new JLabel("Tên người mượn");
		lblTnNgiMn.setForeground(new Color(255, 255, 255));
		lblTnNgiMn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTnNgiMn.setBounds(89, 118, 140, 27);
		contentPane.add(lblTnNgiMn);
		
		ngaymuontextField = new JTextField();
		ngaymuontextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ngaymuontextField.setForeground(new Color(0, 0, 0));
		ngaymuontextField.setColumns(10);
		ngaymuontextField.setBounds(653, 118, 185, 27);
		contentPane.add(ngaymuontextField);
		
		JLabel lblNgyMn = new JLabel("Ngày mượn");
		lblNgyMn.setForeground(new Color(255, 255, 255));
		lblNgyMn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNgyMn.setBounds(503, 119, 140, 27);
		contentPane.add(lblNgyMn);
		
		soluongmuontextField = new JTextField();
		soluongmuontextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		soluongmuontextField.setForeground(new Color(0, 0, 0));
		soluongmuontextField.setColumns(10);
		soluongmuontextField.setBounds(653, 83, 185, 27);
		contentPane.add(soluongmuontextField);
		ActionListener ac = new taophieumuon_Listener(this);
		JLabel soluongLabel = new JLabel("Số lượng mượn");
		soluongLabel.setForeground(new Color(255, 255, 255));
		soluongLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		soluongLabel.setBounds(503, 81, 140, 27);
		contentPane.add(soluongLabel);
		
		JButton taophieuButton = new JButton("Tạo phiếu");
		taophieuButton.setForeground(new Color(255, 255, 255));
		taophieuButton.setBackground(new Color(0, 0, 255));
		taophieuButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		taophieuButton.setBounds(384, 414, 125, 39);
		taophieuButton.addActionListener(ac);
		contentPane.add(taophieuButton);
		
		JButton quaylaiButton = new JButton("Quay lại");
		quaylaiButton.setForeground(new Color(255, 255, 255));
		quaylaiButton.setBackground(new Color(0, 0, 255));
		quaylaiButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		quaylaiButton.setBounds(751, 414, 125, 39);
		quaylaiButton.addActionListener(ac);
		contentPane.add(quaylaiButton);
		
		JLabel lblNewLabel = new JLabel("Tạo phiếu mượn");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(355, 10, 178, 44);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Mã thiết bị", "Tên thiết bị", "Đơn vị tính", "Số lượng", "Trạng thái"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 229, 866, 175);
		contentPane.add(scrollPane);
		
	}
}