package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.editNguoimuonJFrame;
import view.NguoimuonJFrame;
public class editNguoimuon_Listener implements ActionListener {
	private editNguoimuonJFrame ednmjf;
	public editNguoimuon_Listener(editNguoimuonJFrame ednmjf) {
		this.ednmjf = ednmjf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Cập nhật")) {
			if (!isValidPhoneNumber(ednmjf.sdttextField.getText())&&!ednmjf.sdttextField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(ednmjf, "Số điện thoại không hợp lệ","Lỗi",JOptionPane.ERROR_MESSAGE);
			} else if(ednmjf.manguoimuontextField.getText().isEmpty()&&ednmjf.tennguoimuontextField.getText().isEmpty()&&ednmjf.diachitextField.getText().isEmpty()&&ednmjf.sdttextField.getText().isEmpty()){
		    	 JOptionPane.showMessageDialog(ednmjf, "Bạn chưa nhập các thông tin của người mượn","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else if(ednmjf.manguoimuontextField.getText().isEmpty()||ednmjf.tennguoimuontextField.getText().isEmpty()||ednmjf.diachitextField.getText().isEmpty()||ednmjf.sdttextField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(ednmjf, "Vui lòng nhập đủ các thông tin của người mượn","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else if(ednmjf.manguoimuontextField.getText().length()>8||ednmjf.tennguoimuontextField.getText().length()>50||ednmjf.diachitextField.getText().length()>50) {
				if(ednmjf.manguoimuontextField.getText().length()>8) {
					JOptionPane.showMessageDialog(ednmjf, "Độ dài ký tự của mã người mượn vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(ednmjf.tennguoimuontextField.getText().length()>50) {
					JOptionPane.showMessageDialog(ednmjf, "Độ dài ký tự của tên người mượn vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(ednmjf.diachitextField.getText().length()>50) {
					JOptionPane.showMessageDialog(ednmjf, "Độ dài ký tự của địa chỉ vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				ednmjf.nguoimuon.setManm(ednmjf.manguoimuontextField.getText());
				ednmjf.nguoimuon.setTennm(ednmjf.tennguoimuontextField.getText());
				ednmjf.nguoimuon.setDiachi(ednmjf.diachitextField.getText());
				ednmjf.nguoimuon.setSdt(ednmjf.sdttextField.getText());
				ednmjf.nguoimuonService.updateNguoimuon(ednmjf.nguoimuon);
				new NguoimuonJFrame();
				ednmjf.dispose();
		       	}
		}else if(actionCommand.equals("Hủy")) {
			new NguoimuonJFrame();
			ednmjf.dispose();
		}
	}
	public static boolean isValidPhoneNumber(String phoneNumber) {
		String regex = "((09|03|07|08|05)+([0-9]{8})\\b)";
		return phoneNumber.matches(regex);
    }
}
