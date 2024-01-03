package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.Trangchu;
import view.phanloaithietbiJFrame;

public class loaithietbi_Listener implements ActionListener {
	private phanloaithietbiJFrame pltbjf;
	public loaithietbi_Listener(phanloaithietbiJFrame pltbjf) {
		this.pltbjf = pltbjf;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Lưu")) {
			int row = pltbjf.table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(pltbjf, "Vui lòng chọn thiết bị trước","Lỗi",JOptionPane.ERROR_MESSAGE);
			}
			else if(pltbjf.loaithietbitextField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(pltbjf, "Vui lòng nhập loại thiết bị","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else if(pltbjf.loaithietbitextField.getText().length()>50) {
				JOptionPane.showMessageDialog(pltbjf, "Độ dài ký tự của loại thiết bị vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
			}
			else {
				pltbjf.thietbi.setLoaitb(pltbjf.loaithietbitextField.getText());
				String Matb = String.valueOf(pltbjf.table.getValueAt(row, 0));
				pltbjf.thietbi.setMatb(Matb);
				pltbjf.thietbiService.addloaithietbi(pltbjf.thietbi);
				pltbjf.loaithietbitextField.setText("");
				pltbjf.defaultTableModel.setRowCount(0);
				pltbjf.settableData(pltbjf.thietbiService.getAllThietbis());
			}
		}else if(actionCommand.equals("Tìm")) {
			if(pltbjf.timtextField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(pltbjf, "Vui lòng nhập mã thiết bị","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else {
				pltbjf.defaultTableModel.setRowCount(0);
				String matb = pltbjf.timtextField.getText();
				pltbjf.settableData(pltbjf.thietbiService.TimKiem(matb));
			}
		}else if(actionCommand.equals("Thoát")) {
			pltbjf.dispose();
		}else if(actionCommand.equals("")) {
			new Trangchu();
			pltbjf.dispose();
		}else if(actionCommand.equals("Làm mới")) {
			pltbjf.defaultTableModel.setRowCount(0);
			pltbjf.settableData(pltbjf.thietbiService.getAllThietbis());
		}
	}

}
