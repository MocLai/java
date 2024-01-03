package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.NguoimuonJFrame;
import view.Trangchu;
import view.editNguoimuonJFrame;
import view.taophieumuonJFrame;
import view.taophieutraJFrame;
public class Danhmucnguoimuon_Listener implements ActionListener{
	private  NguoimuonJFrame dmnmjf;
	public Danhmucnguoimuon_Listener(NguoimuonJFrame dmnmjf) {
		super();
		this.dmnmjf = dmnmjf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub 
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Lưu")) {
			boolean kiemtra = dmnmjf.kiemtramanm(dmnmjf.nguoimuonService.getAllNguoimuons(),dmnmjf.manguoimuontextField.getText());
			
			if(kiemtra==true) {
				JOptionPane.showMessageDialog(dmnmjf, "Mã người mượn này đã tồn tại","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else if (!isValidPhoneNumber(dmnmjf.dienthoaitextField.getText())&&!dmnmjf.dienthoaitextField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(dmnmjf, "Số điện thoại không hợp lệ","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else if(dmnmjf.manguoimuontextField.getText().isEmpty()&&dmnmjf.tennguoimuontextField.getText().isEmpty()&&dmnmjf.diachitextField.getText().isEmpty()&&dmnmjf.dienthoaitextField.getText().isEmpty()){
		    	 JOptionPane.showMessageDialog(dmnmjf, "Bạn chưa nhập các thông tin của người mượn","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else if(dmnmjf.manguoimuontextField.getText().isEmpty()||dmnmjf.tennguoimuontextField.getText().isEmpty()||dmnmjf.diachitextField.getText().isEmpty()||dmnmjf.dienthoaitextField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(dmnmjf, "Vui lòng nhập đủ các thông tin của người mượn","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else if(dmnmjf.manguoimuontextField.getText().length()>8||dmnmjf.tennguoimuontextField.getText().length()>50||dmnmjf.diachitextField.getText().length()>50||dmnmjf.dienthoaitextField.getText().length()>10) {
				if(dmnmjf.manguoimuontextField.getText().length()>8) {
					JOptionPane.showMessageDialog(dmnmjf, "Độ dài ký tự của mã người mượn vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(dmnmjf.tennguoimuontextField.getText().length()>50) {
					JOptionPane.showMessageDialog(dmnmjf, "Độ dài ký tự của tên người mượn vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(dmnmjf.diachitextField.getText().length()>50) {
					JOptionPane.showMessageDialog(dmnmjf, "Độ dài ký tự của địa chỉ vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
				}
			}else {
				dmnmjf.nguoimuon.setManm(dmnmjf.manguoimuontextField.getText());
				dmnmjf.nguoimuon.setTennm(dmnmjf.tennguoimuontextField.getText());
				dmnmjf.nguoimuon.setDiachi(dmnmjf.diachitextField.getText());
				dmnmjf.nguoimuon.setSdt(dmnmjf.dienthoaitextField.getText());
				dmnmjf.nguoimuonService.addNguoimuon(dmnmjf.nguoimuon);
				dmnmjf.defaultTableModel.setRowCount(0);
				dmnmjf.settableData(dmnmjf.nguoimuonService.getAllNguoimuons());
				dmnmjf.xoafrom();
				JOptionPane.showMessageDialog(dmnmjf, "Đã tạo người mượn thành công!");
	       	}
		}
		else if(actionCommand.equals("Làm mới")) {
			dmnmjf.defaultTableModel.setRowCount(0);
			dmnmjf.settableData(dmnmjf.nguoimuonService.getAllNguoimuons());
		}else if(actionCommand.equals("Xóa")) {
			int row = dmnmjf.table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(dmnmjf, "Vui lòng chọn người mượn trước","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else {
				int confirm = JOptionPane.showConfirmDialog(dmnmjf, "Bạn chắc chắn muốn xóa không?");
				if(confirm == JOptionPane.YES_OPTION) {
					String nguoimuonManm = String.valueOf(dmnmjf.table.getValueAt(row, 0));
					dmnmjf.nguoimuonService.deleteNguoimuon(nguoimuonManm);
					dmnmjf.defaultTableModel.setRowCount(0);
					dmnmjf.settableData(dmnmjf.nguoimuonService.getAllNguoimuons());
				}
			}
		}else if(actionCommand.equals("Sửa")) { 
			int row = dmnmjf.table.getSelectedRow();	
			if(row == -1) {
				JOptionPane.showMessageDialog(dmnmjf, "Vui lòng chọn người mượn trước","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else {
				String nguoimuonManm = String.valueOf(dmnmjf.table.getValueAt(row, 0));
				new editNguoimuonJFrame(nguoimuonManm);
				dmnmjf.dispose();
				}
		}else if(actionCommand.equals("Bỏ qua")) {
			dmnmjf.xoafrom();
		}else if(actionCommand.equals("Ghi mượn nhanh")) {
			int row = dmnmjf.table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(dmnmjf, "Vui lòng chọn người mượn trước","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else {
				String nguoimuonManm = String.valueOf(dmnmjf.table.getValueAt(row, 0));
				new taophieumuonJFrame(nguoimuonManm);
				dmnmjf.dispose();
				}
		}
		else if(actionCommand.equals("Tạo phiếu trả")) {
			int row = dmnmjf.table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(dmnmjf, "Vui lòng chọn người mượn trước","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else {
				String nguoimuonManm = String.valueOf(dmnmjf.table.getValueAt(row, 0));
				new taophieutraJFrame(nguoimuonManm);
				dmnmjf.dispose();
				}
		}else if(actionCommand.equals("")) {
			new Trangchu();
			dmnmjf.dispose();
		}else if(actionCommand.equals("Tìm")){
			if(dmnmjf.timtextField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(dmnmjf, "Vui lòng nhập mã thiết bị cần tìm","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else {
				dmnmjf.defaultTableModel.setRowCount(0);
				String manm = dmnmjf.timtextField.getText();
				dmnmjf.settableData(dmnmjf.nguoimuonService.TimKiem(manm));
			}
		}else if(actionCommand.equals("Thoát")) {
			dmnmjf.dispose();
		}else if(actionCommand.equals("Thêm")) {
			dmnmjf.xoafrom();
		}
	}
	public static boolean isValidPhoneNumber(String phoneNumber) {
		String regex = "((09|03|07|08|05)+([0-9]{8})\\b)";
		return phoneNumber.matches(regex);
    }
}