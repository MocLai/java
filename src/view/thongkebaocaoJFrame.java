package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import controller.thongke_Listener;
import model.Thongkebaocao;
import model.ThongkebaocaoService;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class thongkebaocaoJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField dotthongke_TextField;
	public JTextField bophan_textField;
	public JTextField ngayketthuc_textField;
	public JTextField ngaybatdau_textField; 
	public JTable table;
	public JButton inthongkeButton;
	public DefaultTableModel defaultTableModel;
	public ThongkebaocaoService thongkebaocaoService;
	public Thongkebaocao thongkebaocao;

	public thongkebaocaoJFrame() {
		thongkebaocaoService = new ThongkebaocaoService();
		thongkebaocao = new Thongkebaocao();
		
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
		defaultTableModel.addColumn("Ngày mượn");
		defaultTableModel.addColumn("Số lượng");
		defaultTableModel.addColumn("Mã người mượn");
		defaultTableModel.addColumn("Trạng thái");
		
		settableData(thongkebaocaoService.getAllThongkes());
		this.setVisible(true);
	}
	public void settableData(List<Thongkebaocao> thongkebaocaos) {
		for (Thongkebaocao thongkebaocao : thongkebaocaos) {
			defaultTableModel.addRow(new Object[] {thongkebaocao.getMatb(), thongkebaocao.getTentb(),thongkebaocao.getNgaymuon(), thongkebaocao.getSoluong(),thongkebaocao.getManm(),thongkebaocao.getTrangthai()});
		}
		
	}
	public void init() {
		this.setTitle("Thống kê báo cáo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(13, 162, 242));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ActionListener ac = new thongke_Listener(this);
		JLabel dotthongke_Lable = new JLabel("Đợt thống kê: ");
		dotthongke_Lable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dotthongke_Lable.setForeground(new Color(255, 255, 255));
		dotthongke_Lable.setBounds(37, 21, 114, 29);
		contentPane.add(dotthongke_Lable);
		
		dotthongke_TextField = new JTextField();
		dotthongke_TextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dotthongke_TextField.setBounds(155, 21, 114, 26);
		contentPane.add(dotthongke_TextField);
		dotthongke_TextField.setColumns(10);
		
		JLabel lblBPhn = new JLabel("Bộ phận:");
		lblBPhn.setForeground(Color.WHITE);
		lblBPhn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblBPhn.setBounds(299, 21, 73, 29);
		contentPane.add(lblBPhn);
		
		bophan_textField = new JTextField();
		bophan_textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bophan_textField.setColumns(10);
		bophan_textField.setBounds(422, 22, 115, 26);
		contentPane.add(bophan_textField);
		
		JLabel lblNgyBtu = new JLabel("Ngày kết thúc:");
		lblNgyBtu.setForeground(Color.WHITE);
		lblNgyBtu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNgyBtu.setBounds(300, 60, 129, 29);
		contentPane.add(lblNgyBtu);
		
		ngayketthuc_textField = new JTextField();
		ngayketthuc_textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ngayketthuc_textField.setColumns(10);
		ngayketthuc_textField.setBounds(422, 61, 115, 26);
		contentPane.add(ngayketthuc_textField);
		
		JLabel lblNgyBtu_1 = new JLabel("Ngày bắt đầu:");
		lblNgyBtu_1.setForeground(Color.WHITE);
		lblNgyBtu_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNgyBtu_1.setBounds(37, 60, 114, 29);
		contentPane.add(lblNgyBtu_1);
		
		ngaybatdau_textField = new JTextField();
		ngaybatdau_textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ngaybatdau_textField.setColumns(10);
		ngaybatdau_textField.setBounds(155, 61, 114, 26);
		contentPane.add(ngaybatdau_textField);
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
				"Mã thiết bị", "Tên thiết bị", "Ngày mượn", "Số lượng", "Mã người mượn", "Trạng thái"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(38, 109, 716, 175);
		contentPane.add(scrollPane);
		JButton quaylaiButton = new JButton("Quay lại");
		quaylaiButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		quaylaiButton.setBounds(10, 324, 129, 29);
		quaylaiButton.addActionListener(ac);
		contentPane.add(quaylaiButton);
		
		inthongkeButton = new JButton("In thống kê");
		inthongkeButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inthongkeButton.setBounds(612, 294, 129, 29);
		inthongkeButton.addActionListener(ac);
		contentPane.add(inthongkeButton);
	}
	public void xoafrom() {
		dotthongke_TextField.setText("");
		bophan_textField.setText("");
		ngaybatdau_textField.setText("");
		ngayketthuc_textField.setText("");
	}
}
