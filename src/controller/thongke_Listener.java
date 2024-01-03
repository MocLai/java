package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import view.Trangchu;
import view.thongkebaocaoJFrame; 

public class thongke_Listener implements ActionListener {
	private thongkebaocaoJFrame tkbcjf;
	public thongke_Listener(thongkebaocaoJFrame tkbcjf) {
		
		this.tkbcjf = tkbcjf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand(); 
		if(actionCommand.equals("In thống kê")) { 	
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			if(tkbcjf.dotthongke_TextField.getText().isEmpty()||tkbcjf.bophan_textField.getText().isEmpty()||tkbcjf.ngayketthuc_textField.getText().isEmpty()||tkbcjf.ngaybatdau_textField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(tkbcjf, "Vui lòng nhập đủ thông tin thống kê báo cáo","Lỗi",JOptionPane.ERROR_MESSAGE);
			}else {
				dateFormat.setLenient(false);
				try (XSSFWorkbook wb = new XSSFWorkbook()) {
					java.util.Date dateketthuc = dateFormat.parse(tkbcjf.ngayketthuc_textField.getText());
					java.util.Date datebatdau = dateFormat.parse(tkbcjf.ngaybatdau_textField.getText());
					java.sql.Date sqlDateketthuc = new java.sql.Date(dateketthuc.getTime());
					java.sql.Date sqlDatebatdau = new java.sql.Date(datebatdau.getTime());
					if(datebatdau.compareTo(dateketthuc)>0) {
						JOptionPane.showMessageDialog(tkbcjf, "Dữ liệu ngày kết thúc không hợp lệ","Lỗi",JOptionPane.ERROR_MESSAGE);
					}else {
						XSSFSheet sheet = wb.createSheet("thongke");
						XSSFRow row = null;
						Cell cell = null;
						row = sheet.createRow(0);
						cell = row.createCell(1,CellType.STRING);
						cell.setCellValue("Đợt thống kê: " + tkbcjf.dotthongke_TextField.getText());
						cell = row.createCell(3,CellType.STRING);
						cell.setCellValue("Bộ phận: " + tkbcjf.bophan_textField.getText());
						row = sheet.createRow(1);
						cell = row.createCell(1,CellType.STRING);
						cell.setCellValue("Ngày bắt đầu: " + sqlDatebatdau);
						cell = row.createCell(3,CellType.STRING);
						cell.setCellValue("Ngày kết thúc: " + sqlDateketthuc);
						row = sheet.createRow(3);
						cell = row.createCell(0,CellType.STRING);
						cell.setCellValue("STT");
						cell = row.createCell(1,CellType.STRING);
						cell.setCellValue("Mã thiết bị");
						cell = row.createCell(2,CellType.STRING);
						cell.setCellValue("Tên thiết bị");
						cell = row.createCell(3,CellType.STRING);
						cell.setCellValue("Ngày mượn");
						cell = row.createCell(4,CellType.STRING);
						cell.setCellValue("Số lượng");
						cell = row.createCell(5,CellType.STRING);
						cell.setCellValue("Mã người mượn");
						cell = row.createCell(6,CellType.STRING);
						cell.setCellValue("Trạng thái");
						CellStyle dateCellStyle = wb.createCellStyle();
						CreationHelper createHelper = wb.getCreationHelper();
						dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));
						for(int i=0; i<tkbcjf.thongkebaocaoService.getAllThongkes().size(); i++) {
						    row = sheet.createRow(4+i);
						    cell = row.createCell(0, CellType.NUMERIC);
						    cell.setCellValue(i+1);
						    cell = row.createCell(1, CellType.STRING);
						    cell.setCellValue(tkbcjf.thongkebaocaoService.getAllThongkes().get(i).getMatb());
						    cell = row.createCell(2, CellType.STRING);
						    cell.setCellValue(tkbcjf.thongkebaocaoService.getAllThongkes().get(i).getTentb());
						    cell = row.createCell(3, CellType.STRING);
						    cell.setCellValue(tkbcjf.thongkebaocaoService.getAllThongkes().get(i).getNgaymuon());
						    cell.setCellStyle(dateCellStyle);
						    cell = row.createCell(4, CellType.STRING);
						    cell.setCellValue(tkbcjf.thongkebaocaoService.getAllThongkes().get(i).getSoluong());
						    cell = row.createCell(5, CellType.STRING);
						    cell.setCellValue(tkbcjf.thongkebaocaoService.getAllThongkes().get(i).getManm());
						    cell = row.createCell(6, CellType.STRING);
						    cell.setCellValue(tkbcjf.thongkebaocaoService.getAllThongkes().get(i).getTrangthai());
						}
					
					File f = new File("D://thongke.xlsx");
					try {
						FileOutputStream fios = new FileOutputStream(f);
						wb.write(fios);
						fios.close();
					} catch (FileNotFoundException e2) {
						e2.printStackTrace();
					}catch (IOException e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
					tkbcjf.xoafrom();
					JOptionPane.showMessageDialog(tkbcjf, "In thành công");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(tkbcjf, "Nhập sai định dạng ngày tháng\nVui lòng nhập lại theo định dạng dd-MM-yyyy","Lỗi",JOptionPane.ERROR_MESSAGE);
					JOptionPane.showMessageDialog(tkbcjf, "Lỗi mở file");
				}
			}
	}else if(actionCommand.equals("Quay lại")) {
		new Trangchu();
		tkbcjf.dispose();
	}

	}
	
}
