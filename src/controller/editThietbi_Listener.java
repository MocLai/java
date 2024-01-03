package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.editThietbiJFrame;
import view.thietbiJFrame;

public class editThietbi_Listener implements ActionListener {
	private editThietbiJFrame edtbjf;
	
	public editThietbi_Listener(editThietbiJFrame edtbjf) {
		this.edtbjf = edtbjf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Cập nhật")) {
			if(edtbjf.mathietbitextField.getText().isEmpty()&&edtbjf.tenthietbitextField.getText().isEmpty()&&edtbjf.dvttextField.getText().isEmpty()&&edtbjf.soluongtextField.getText().isEmpty()){
		    	 JOptionPane.showMessageDialog(edtbjf, "Bạn chưa nhập các thông tin của người mượn","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else if(edtbjf.mathietbitextField.getText().isEmpty()||edtbjf.tenthietbitextField.getText().isEmpty()||edtbjf.dvttextField.getText().isEmpty()||edtbjf.soluongtextField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(edtbjf, "Vui lòng nhập đủ các thông tin của người mượn","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else if(edtbjf.mathietbitextField.getText().length()>12||edtbjf.tenthietbitextField.getText().length()>50||edtbjf.dvttextField.getText().length()>6||edtbjf.soluongtextField.getText().length()>255) {
				if(edtbjf.mathietbitextField.getText().length()>12) {
					JOptionPane.showMessageDialog(edtbjf, "Độ dài ký tự của mã thiết bị vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(edtbjf.tenthietbitextField.getText().length()>50) {
					JOptionPane.showMessageDialog(edtbjf, "Độ dài ký tự của tên thiết bị vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(edtbjf.dvttextField.getText().length()>6) {
					JOptionPane.showMessageDialog(edtbjf, "Độ dài ký tự của đơn vị tính vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(edtbjf.soluongtextField.getText().length()>255) {
					JOptionPane.showMessageDialog(edtbjf, "Độ dài ký tự của số lượng vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				edtbjf.thietbi.setMatb(edtbjf.mathietbitextField.getText());
				edtbjf.thietbi.setTentb(edtbjf.tenthietbitextField.getText());
				edtbjf.thietbi.setDvt(edtbjf.dvttextField.getText());
				edtbjf.thietbi.setSoluong(Integer.valueOf(edtbjf.soluongtextField.getText()));
				String trangthai = "";
				if(edtbjf.binhthuongRadioButton.isSelected()) {
					trangthai = "Bình thường";
				}else {trangthai = "Hỏng";}
				edtbjf.thietbi.setTrangthai(trangthai);
				edtbjf.thietbiService.updateThietbi(edtbjf.thietbi);
				new thietbiJFrame();
				edtbjf.dispose();
			}
	}else if(actionCommand.equals("Hủy")) {
		new thietbiJFrame();
		edtbjf.dispose();
	}
	}
}
