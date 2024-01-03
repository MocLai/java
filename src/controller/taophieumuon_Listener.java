package controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.Thietbi;
import model.ThietbiService;
import view.QuanlymuontraJFrame;
import view.taophieumuonJFrame;

public class taophieumuon_Listener implements ActionListener {
	private  taophieumuonJFrame tpmjf;
	private Thietbi thietbi;
	private ThietbiService thietbiService;
	public taophieumuon_Listener(taophieumuonJFrame tpmjf) {
		this.tpmjf = tpmjf;
		this.thietbiService = new ThietbiService(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Tạo phiếu")) {
			boolean kiemtra = tpmjf.kiemtrasopm(tpmjf.phieumuonService.getSopmBySopm(),tpmjf.sophieutextField.getText());
			int row = tpmjf.table.getSelectedRow();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			if(row == -1) {
				JOptionPane.showMessageDialog(tpmjf, "Vui lòng chọn thiết bị trước","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else if(kiemtra == true) {
				JOptionPane.showMessageDialog(tpmjf, "Số phiếu mượn này đã tồn tại","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else if(tpmjf.kiemtrasonguyen(tpmjf.soluongmuontextField.getText())==false) {
				JOptionPane.showMessageDialog(tpmjf, "Dữ liệu của số lượng nhập vào phải là số nguyên");
			}
			else {
				thietbiService.getThietbiBymatb(String.valueOf(tpmjf.table.getValueAt(row, 0)));
				tpmjf.thietbi.setSoluong(Integer.valueOf(String.valueOf(tpmjf.table.getValueAt(row, 3))));
				if(tpmjf.sophieutextField.getText().isEmpty()&&tpmjf.soluongmuontextField.getText().isEmpty()&&tpmjf.ngaymuontextField.getText().isEmpty()){
					JOptionPane.showMessageDialog(tpmjf, "Bạn chưa nhập các thông tin của phiếu mượn","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(tpmjf.sophieutextField.getText().isEmpty()||tpmjf.soluongmuontextField.getText().isEmpty()||tpmjf.ngaymuontextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(tpmjf, "Vui lòng nhập đủ các thông tin của phiếu mượn","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(String.valueOf(tpmjf.thietbi.getTrangthai()).equals("Hỏng")) {
					JOptionPane.showMessageDialog(tpmjf, "Thiết bị hiện đang hỏng không thể cho mượn","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(Integer.valueOf(tpmjf.thietbi.getSoluong()) - Integer.valueOf(tpmjf.soluongmuontextField.getText()) < 0) {
					JOptionPane.showMessageDialog(tpmjf, "Số lượng thiết bị không đủ để cho mượn","Lỗi",JOptionPane.ERROR_MESSAGE);
				}else if(tpmjf.sophieutextField.getText().length()>8||tpmjf.soluongmuontextField.getText().length()>255) {
					if(tpmjf.sophieutextField.getText().length()>8) {
						JOptionPane.showMessageDialog(tpmjf, "Độ dài ký tự của số phiếu mượn vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
					}else if(tpmjf.soluongmuontextField.getText().length()>255) {
						JOptionPane.showMessageDialog(tpmjf, "Độ dài ký tự của số lượng mượn vượt quá số lượng cho phép","Lỗi",JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					int soluong = Integer.valueOf(tpmjf.thietbi.getSoluong()) - Integer.valueOf(tpmjf.soluongmuontextField.getText());
					dateFormat.setLenient(false);
					String nguoimuonManm = String.valueOf(tpmjf.table.getValueAt(row, 0));
					thietbiService = new ThietbiService(null);
					thietbi = thietbiService.getThietbiBymatb(nguoimuonManm); 
					
						try {
							java.util.Date date = dateFormat.parse(tpmjf.ngaymuontextField.getText());
							java.sql.Date sqlDate = new java.sql.Date(date.getTime());
							tpmjf.phieumuon.setSopm(tpmjf.sophieutextField.getText());
							tpmjf.phieumuon.setNgaymuon(sqlDate);		
							tpmjf.phieumuon.setManm(tpmjf.nguoimuon.getManm());
							tpmjf.phieumuon.setSoluongmuon(Integer.valueOf(tpmjf.soluongmuontextField.getText()));
							tpmjf.phieumuon.setMatb(thietbi.getMatb());
							tpmjf.phieumuon.setDvt(thietbi.getDvt());
							tpmjf.phieumuon.setSoluong(thietbi.getSoluong());
							tpmjf.phieumuonService.addPhieumuon(tpmjf.phieumuon);
							thietbiService.updatesoluongthietbi(thietbi.getMatb(), soluong);
							JOptionPane.showMessageDialog(tpmjf, "Đã tạo phiếu mượn thành công!");
							new QuanlymuontraJFrame();
							tpmjf.dispose();
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(tpmjf, "Dữ liệu của số lượng nhập vào phải là số nguyên");
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(tpmjf, "Nhập sai định dạng ngày tháng\nVui lòng nhập lại theo định dạng dd-MM-yyyy","Lỗi",JOptionPane.ERROR_MESSAGE);
						}
						
					
				}
			}
		}
		else if(actionCommand.equals("Quay lại")) {
				new QuanlymuontraJFrame();
				tpmjf.dispose();
			}
		}
}
	

