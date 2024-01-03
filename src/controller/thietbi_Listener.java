package controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.Trangchu;
import view.editThietbiJFrame;
import view.thietbiJFrame;
public class thietbi_Listener implements ActionListener {
	private  thietbiJFrame tbjf;
	public thietbi_Listener(thietbiJFrame tbjf) {
			this.tbjf = tbjf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Lưu")) {
			boolean kiemtra = tbjf.kiemtramatb(tbjf.thietbiService.getAllThietbis(),tbjf.mathietbitextField.getText());
			if(kiemtra==true) {
				JOptionPane.showMessageDialog(tbjf, "Mã thiết bị này đã tồn tại","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else if(tbjf.mathietbitextField.getText().isEmpty()&&tbjf.tenthietbitextField.getText().isEmpty()&&tbjf.dvttextField.getText().isEmpty()&&tbjf.soluongtextField.getText().isEmpty()){
		    	 JOptionPane.showMessageDialog(tbjf, "Bạn chưa nhập các thông tin của thiết bị","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else if(tbjf.mathietbitextField.getText().isEmpty()||tbjf.tenthietbitextField.getText().isEmpty()||tbjf.dvttextField.getText().isEmpty()||tbjf.soluongtextField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(tbjf, "Vui lòng nhập đủ các thông tin của thiết bị","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else if(tbjf.mathietbitextField.getText().length()>12||tbjf.tenthietbitextField.getText().length()>50||tbjf.dvttextField.getText().length()>6||tbjf.soluongtextField.getText().length()>255) {
				if(tbjf.mathietbitextField.getText().length()>12) {
					JOptionPane.showMessageDialog(tbjf, "Độ dài ký tự của mã thiết bị vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(tbjf.tenthietbitextField.getText().length()>50) {
					JOptionPane.showMessageDialog(tbjf, "Độ dài ký tự của tên tên thiết bị vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(tbjf.dvttextField.getText().length()>6) {
					JOptionPane.showMessageDialog(tbjf, "Độ dài ký tự của đơn vị tính vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(tbjf.soluongtextField.getText().length()>255) {
					JOptionPane.showMessageDialog(tbjf, "Độ dài ký tự của số lượng vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				
		       	try {
					tbjf.thietbi.setMatb(tbjf.mathietbitextField.getText());
					tbjf.thietbi.setTentb(tbjf.tenthietbitextField.getText());
					tbjf.thietbi.setDvt(tbjf.dvttextField.getText());
					tbjf.thietbi.setSoluong(Integer.valueOf(tbjf.soluongtextField.getText()));
					String trangthai = "";
					if(tbjf.binhthuongRadioButton.isSelected()) {
						trangthai = "Bình thường";
					}else {trangthai = "Hỏng";}
					tbjf.thietbi.setTrangthai(trangthai);
					tbjf.thietbiService.addThietbi(tbjf.thietbi);
					tbjf.defaultTableModel.setRowCount(0);
					tbjf.settableData(tbjf.thietbiService.getAllThietbis());
					tbjf.xoafrom();
					JOptionPane.showMessageDialog(tbjf, "Đã tạo thiết bị thành công!");
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Dữ liệu của số lượng nhập vào phải là số nguyên");
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		       }
		}
		else if(actionCommand.equals("Làm mới")) {
			tbjf.defaultTableModel.setRowCount(0);
			tbjf.settableData(tbjf.thietbiService.getAllThietbis());
		}else if(actionCommand.equals("Xóa")) {
			int row = tbjf.table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(tbjf, "Vui lòng chọn thiết bị trước","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else {
				int confirm = JOptionPane.showConfirmDialog(tbjf, "Bạn chắc chắn muốn xóa không?");
				if(confirm == JOptionPane.YES_OPTION) {
					String nhanvienMatb = String.valueOf(tbjf.table.getValueAt(row, 0));
					tbjf.thietbiService.deleteThietbi(nhanvienMatb);
					tbjf.defaultTableModel.setRowCount(0);
					tbjf.settableData(tbjf.thietbiService.getAllThietbis());
				}
			}
		}else if(actionCommand.equals("Sửa")) {
			int row = tbjf.table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(tbjf, "Vui lòng chọn thiết bị trước","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else {
				String nhanvienMatb = String.valueOf(tbjf.table.getValueAt(row, 0));
				new editThietbiJFrame(nhanvienMatb);
				tbjf.dispose();
				}
		}else if(actionCommand.equals("Bỏ qua")) { 
			tbjf.xoafrom();
		}else if(actionCommand.equals("")) { 
			new Trangchu();
			tbjf.dispose();
		}else if(actionCommand.equals("Thoát")) {
			tbjf.dispose();
		}else if(actionCommand.equals("Tìm")) {
			if(tbjf.timtextField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(tbjf, "Vui lòng mã thiết bị cần tìm","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else {
			tbjf.defaultTableModel.setRowCount(0);
			String matb = tbjf.timtextField.getText();
			tbjf.settableData(tbjf.thietbiService.TimKiem(matb));
			}
		}else if(actionCommand.equals("Thêm")) {
			tbjf.xoafrom();
		}
	}
}

