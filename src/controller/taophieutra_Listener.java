package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.Phieumuon;
import model.PhieumuonService;
import model.Thietbi;
import model.ThietbiService;
import view.QuanlymuontraJFrame;
import view.taophieutraJFrame;

public class taophieutra_Listener implements ActionListener {
	private taophieutraJFrame tptjf;
	private Thietbi thietbi;
	private ThietbiService thietbiService;
	private Phieumuon phieumuon;
	private PhieumuonService phieumuonService;
	public taophieutra_Listener(taophieutraJFrame tptjf) {
		this.tptjf = tptjf;
		this.thietbiService = new ThietbiService(null);
		this.phieumuonService = new PhieumuonService(null);
		this.phieumuon = new Phieumuon();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Tạo phiếu")) {
			boolean kiemtra = tptjf.kiemtrasopt(tptjf.phieutraService.getSoptBySopt(), tptjf.sophieutratextField.getText());
			int row = tptjf.table.getSelectedRow();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			if(row == -1) {
				JOptionPane.showMessageDialog(tptjf, "Vui lòng chọn thiết bị trước","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else if(kiemtra == true) {
				JOptionPane.showMessageDialog(tptjf, "Số phiếu mượn này đã tồn tại","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else {
				phieumuon = phieumuonService.getPhieumuonBySopm(String.valueOf(tptjf.table.getValueAt(row, 0)));
				thietbi = thietbiService.getThietbiBymatb(String.valueOf(tptjf.table.getValueAt(row, 0)));
				tptjf.thietbi.setSoluong(Integer.valueOf(String.valueOf(tptjf.table.getValueAt(row, 3))));
				if(tptjf.sophieutratextField.getText().isEmpty()&&tptjf.soluongtratextField.getText().isEmpty()&&tptjf.ngaytratextField.getText().isEmpty()){
					JOptionPane.showMessageDialog(tptjf, "Bạn chưa nhập các thông tin của phiếu trả","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(tptjf.sophieutratextField.getText().isEmpty()||tptjf.soluongtratextField.getText().isEmpty()||tptjf.ngaytratextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(tptjf, "Vui lòng nhập đủ các thông tin của phiếu trả","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(tptjf.kiemtrasonguyen(tptjf.soluongtratextField.getText())==false) {
					JOptionPane.showMessageDialog(tptjf, "Dữ liệu của số lượng trả nhập vào phải là số nguyên");
				}else if(Integer.valueOf(tptjf.thietbi.getSoluong())!= Integer.valueOf(tptjf.soluongtratextField.getText())) {
					JOptionPane.showMessageDialog(tptjf, "Số lượng thiết bị trả không phù hợp","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(tptjf.sophieutratextField.getText().length()>8||tptjf.soluongtratextField.getText().length()>255) {
					if(tptjf.sophieutratextField.getText().length()>8) {
						JOptionPane.showMessageDialog(tptjf, "Độ dài ký tự của số phiếu trả vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
					}else if(tptjf.soluongtratextField.getText().length()>255) {
						JOptionPane.showMessageDialog(tptjf, "Độ dài ký tự của số lượng trả vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					int soluong = Integer.valueOf(thietbi.getSoluong()) + Integer.valueOf(tptjf.soluongtratextField.getText());
					dateFormat.setLenient(false);
					String nguoimuonManm = String.valueOf(tptjf.table.getValueAt(row, 0));
					thietbiService = new ThietbiService(null);
					thietbi = thietbiService.getThietbiBymatb(nguoimuonManm);
					java.util.Date date;
					try {
						date = dateFormat.parse(tptjf.ngaytratextField.getText());
						java.sql.Date sqlDate = new java.sql.Date(date.getTime());
						tptjf.phieutra.setSopt(tptjf.sophieutratextField.getText());
						tptjf.phieutra.setNgaytra(sqlDate);		
						tptjf.phieutra.setManm(tptjf.nguoimuon.getManm());
						tptjf.phieutra.setSoluongtra(Integer.valueOf(tptjf.soluongtratextField.getText()));
						tptjf.phieutra.setMatb(thietbi.getMatb());
						tptjf.phieutra.setDvt(thietbi.getDvt());
						tptjf.phieutra.setSoluong(Integer.valueOf(phieumuon.getSoluong()));
						tptjf.phieutraService.addPhieutra(tptjf.phieutra);
						thietbiService.updatesoluongthietbi(thietbi.getMatb(), soluong);
						JOptionPane.showMessageDialog(tptjf, "Đã tạo phiếu trả thành công!");
						new QuanlymuontraJFrame();
						tptjf.dispose();
					
					}catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(tptjf, "Dữ liệu của số lượng trả nhập vào phải là số nguyên");
					}catch (ParseException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(tptjf, "Nhập sai định dạng ngày tháng\nVui lòng nhập lại theo định dạng dd-MM-yyyy","Lỗi",JOptionPane.ERROR_MESSAGE);
				}
			}}
		}else if(actionCommand.equals("Quay lại")) {
			new QuanlymuontraJFrame();
			tptjf.dispose();
		}
	}

}
