package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.NguoimuonJFrame;
import view.QuanlymuontraJFrame;
import view.Trangchu;

import view.phanloaithietbiJFrame;
import view.thietbiJFrame;
import view.thongkebaocaoJFrame;

public class Trangchu_Listener implements ActionListener {
	private Trangchu tc;
	public Trangchu_Listener(Trangchu tc) {
		this.tc = tc;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Quản lý người mượn")) {
			new NguoimuonJFrame();
			tc.dispose();
		}else if(actionCommand.equals("Quản lý thiết bị")) {
			new thietbiJFrame();
			tc.dispose();
		}else if(actionCommand.equals("Quản lý phân loại thiết bị")) {
			new phanloaithietbiJFrame();
			tc.dispose();
		}else if(actionCommand.equals("Quản lý mượn - trả")) {
			new QuanlymuontraJFrame();
			tc.dispose();
		}else if(actionCommand.equals("Thống kê báo cáo")) {
			new thongkebaocaoJFrame();
			tc.dispose();
		}else if(actionCommand.equals("Thoát")) {
			tc.dispose();
		}
	}
}
