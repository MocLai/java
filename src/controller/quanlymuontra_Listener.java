package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.QuanlymuontraJFrame;
import view.Trangchu;
import view.taophieumuonJFrame;
import view.taophieutraJFrame;

public class quanlymuontra_Listener implements ActionListener {
	private QuanlymuontraJFrame qlmtjf;
	public quanlymuontra_Listener(QuanlymuontraJFrame qlmtjf) {
		this.qlmtjf = qlmtjf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Tạo ghi mượn nhanh")) {
			int row = qlmtjf.table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(qlmtjf, "Vui lòng chọn người mượn trước","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else {
				String nguoimuonManm = String.valueOf(qlmtjf.table.getValueAt(row, 0));
				new taophieumuonJFrame(nguoimuonManm);
				qlmtjf.dispose();
				}
		}
		else if(actionCommand.equals("Tạo phiếu trả")) {
			int row = qlmtjf.table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(qlmtjf, "Vui lòng chọn người trả trước","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else {
				String Manm = String.valueOf(qlmtjf.table.getValueAt(row, 0));
				System.out.println(Manm);
				new taophieutraJFrame(Manm);
				qlmtjf.dispose();
				}
		}else if(actionCommand.equals("Tìm")){
			if(qlmtjf.timtextField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(qlmtjf, "Vui lòng nhập mã người mượn trước");
			}else {
				qlmtjf.defaultTableModel.setRowCount(0);
				String manm = qlmtjf.timtextField.getText ();
				qlmtjf.settableData(qlmtjf.nguoimuonService.TimKiem(manm));
			}
		}else if(actionCommand.equals("")) {
			new Trangchu();
			qlmtjf.dispose();
		}else if(actionCommand.equals("Làm mới")) {
			qlmtjf.defaultTableModel.setRowCount(0);
			qlmtjf.settableData(qlmtjf.nguoimuonService.getAllNguoimuons());
		}
	}
}
