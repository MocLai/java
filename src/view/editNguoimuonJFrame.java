package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.editNguoimuon_Listener;
import model.Nguoimuon;
import model.NguoimuonService;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class editNguoimuonJFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NguoimuonService nguoimuonService;
	public Nguoimuon nguoimuon;
	private JPanel contentPane;
	public JTextField manguoimuontextField;
	public JTextField tennguoimuontextField;
	public JTextField diachitextField;
	public JTextField sdttextField;
 
	public editNguoimuonJFrame(String manm) {
		nguoimuonService = new NguoimuonService(null);
		nguoimuon = nguoimuonService.getNguoimuonBymanm(manm);
		this.init();
		this.setLocationRelativeTo(null);
		manguoimuontextField.setText(String.valueOf(nguoimuon.getManm()));
		tennguoimuontextField.setText(nguoimuon.getTennm());
		diachitextField.setText(nguoimuon.getDiachi());
		sdttextField.setText(nguoimuon.getSdt());
		this.setVisible(true);
	}
	public void init() {
		this.setTitle("Sửa người mượn");
		setBounds(100, 100, 450, 375);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener ac = new editNguoimuon_Listener(this);
		JLabel manguoimuonLabel = new JLabel("Mã Người mượn");
		manguoimuonLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		manguoimuonLabel.setBounds(29, 93, 134, 19);
		contentPane.add(manguoimuonLabel);
		
		manguoimuontextField = new JTextField();
		manguoimuontextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		manguoimuontextField.setBackground(new Color(255, 255, 255));
		manguoimuontextField.setEditable(false);
		manguoimuontextField.setBounds(196, 87, 198, 30);
		contentPane.add(manguoimuontextField);
		manguoimuontextField.setColumns(10);
		
		JLabel tennguoimuonLabel = new JLabel("Tên người mượn");
		tennguoimuonLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tennguoimuonLabel.setBounds(29, 127, 134, 21);
		contentPane.add(tennguoimuonLabel);
		
		tennguoimuontextField = new JTextField();
		tennguoimuontextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tennguoimuontextField.setHorizontalAlignment(SwingConstants.LEFT);
		tennguoimuontextField.setBounds(196, 122, 198, 30);
		contentPane.add(tennguoimuontextField);
		tennguoimuontextField.setColumns(10);
		
		diachitextField = new JTextField();
		diachitextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		diachitextField.setBounds(196, 157, 198, 30);
		contentPane.add(diachitextField);
		diachitextField.setColumns(10);
		
		JLabel diachiLabel = new JLabel("Địa chỉ");
		diachiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		diachiLabel.setBounds(29, 163, 119, 19);
		contentPane.add(diachiLabel);
		
		sdttextField = new JTextField();
		sdttextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		sdttextField.setColumns(10);
		sdttextField.setBounds(196, 192, 198, 30);
		contentPane.add(sdttextField);
		
		JLabel sdtLabel = new JLabel("SĐT");
		sdtLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		sdtLabel.setBounds(29, 198, 119, 19);
		contentPane.add(sdtLabel);
		
		JButton SuaButton = new JButton("Cập nhật");
		SuaButton.setBackground(new Color(0, 0, 255));
		SuaButton.setForeground(new Color(255, 255, 255));
		SuaButton.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		SuaButton.setBounds(137, 259, 140, 40);
		SuaButton.addActionListener(ac);
		contentPane.add(SuaButton);

		JLabel lblSaNgiMn = new JLabel("Sửa người mượn");
		lblSaNgiMn.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblSaNgiMn.setBounds(107, 10, 206, 35);
		contentPane.add(lblSaNgiMn);
		
		JButton huyButton = new JButton("Hủy");
		huyButton.setForeground(new Color(255, 255, 255));
		huyButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		huyButton.setBackground(Color.GRAY);
		huyButton.setBounds(341, 307, 85, 21);
		huyButton.addActionListener(ac);
		contentPane.add(huyButton);
		
	}
}
