package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.editThietbi_Listener;
import model.Thietbi;
import model.ThietbiService;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class editThietbiJFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Thietbi thietbi;
	public JPanel contentPane;
	public JTextField mathietbitextField;
	public JTextField tenthietbitextField;
	public JLabel tenthietbiLabel;
	public JTextField dvttextField;
	public JLabel dvtLabel;
	public JTextField soluongtextField;
	public JLabel soluongLabel;
	public ThietbiService thietbiService;
	private JLabel lblNewLabel;
	private JButton huyButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JRadioButton binhthuongRadioButton;
	public JRadioButton hongRadioButton;
	public editThietbiJFrame(String matb) {
		this.init();
		this.setLocationRelativeTo(null);
		thietbiService = new ThietbiService(null);
		thietbi = thietbiService.getThietbiBymatb(matb);
		mathietbitextField.setText(thietbi.getMatb());
		tenthietbitextField.setText(thietbi.getTentb());
		dvttextField.setText(thietbi.getDvt());
		soluongtextField.setText(String.valueOf(thietbi.getSoluong()));
		
		contentPane.add(huyButton);
		
		JLabel trangthaiLabel = new JLabel("Trạng thái");
		trangthaiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		trangthaiLabel.setBounds(21, 210, 119, 24);
		contentPane.add(trangthaiLabel);
		
		binhthuongRadioButton = new JRadioButton("Bình thường");
		binhthuongRadioButton.setSelected(true);
		buttonGroup.add(binhthuongRadioButton);
		binhthuongRadioButton.setBackground(new Color(255, 255, 255));
		binhthuongRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		binhthuongRadioButton.setBounds(176, 214, 103, 21);
		contentPane.add(binhthuongRadioButton);
		
		hongRadioButton = new JRadioButton("Hỏng");
		buttonGroup.add(hongRadioButton);
		hongRadioButton.setBackground(new Color(255, 255, 255));
		hongRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		hongRadioButton.setBounds(289, 214, 103, 21);
		contentPane.add(hongRadioButton);
		
		this.setVisible(true);
	}
	public void init() {
		this.setTitle("Sửa thết bị");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 375);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Sửa thiết bị");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(144, 10, 142, 35);
		contentPane.add(lblNewLabel);
		JLabel mathietbiLabel = new JLabel("Mã thiết bị");
		mathietbiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mathietbiLabel.setBounds(21, 68, 131, 24);
		contentPane.add(mathietbiLabel);

		mathietbitextField = new JTextField();
		mathietbitextField.setEditable(false);
		mathietbitextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mathietbitextField.setBounds(176, 68, 216, 24);
		contentPane.add(mathietbitextField);
		mathietbitextField.setColumns(10);
		ActionListener ac = new editThietbi_Listener(this);
		JButton suaButton = new JButton("Cập nhật");
		suaButton.setForeground(new Color(255, 255, 255));
		suaButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		suaButton.setBackground(new Color(0, 0, 255));
		suaButton.setBounds(144, 247, 142, 35);
		suaButton.addActionListener(ac);
		contentPane.add(suaButton);

		tenthietbitextField = new JTextField();
		tenthietbitextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tenthietbitextField.setColumns(10);
		tenthietbitextField.setBounds(176, 102, 216, 24);
		contentPane.add(tenthietbitextField);

		tenthietbiLabel = new JLabel("Tên thiết bị");
		tenthietbiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tenthietbiLabel.setBounds(21, 102, 393, 24);
		contentPane.add(tenthietbiLabel);

		dvttextField = new JTextField();
		dvttextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dvttextField.setColumns(10);
		dvttextField.setBounds(176, 139, 216, 24);
		contentPane.add(dvttextField);

		dvtLabel = new JLabel("Đơn vị tính");
		dvtLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dvtLabel.setBounds(21, 139, 393, 24);
		contentPane.add(dvtLabel);

		soluongtextField = new JTextField();
		soluongtextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		soluongtextField.setColumns(10);
		soluongtextField.setBounds(176, 176, 216, 24);
		contentPane.add(soluongtextField);

		soluongLabel = new JLabel("Số lượng");
		soluongLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		soluongLabel.setBounds(21, 176, 119, 24);
		contentPane.add(soluongLabel);
		
		huyButton = new JButton("Hủy");
		huyButton.setForeground(new Color(255, 255, 255));
		huyButton.setBackground(new Color(128, 128, 128));
		huyButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		huyButton.setBounds(341, 295, 62, 21);
		huyButton.addActionListener(ac);
		contentPane.add(huyButton);
	}
}
