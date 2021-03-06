package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.XuLy_TaiKhoan;
import entity.TaiKhoan;

public class Gui_TaoTaiKhoan extends JFrame implements ActionListener {
	private JLabel lblTieuDe,lblTenTaiKhoan,lblMatKhau;
	private JTextField txtTenTK,txtMatKhau;
	private JButton btnTao;
	private XuLy_TaiKhoan xlTK;
	public Gui_TaoTaiKhoan(String ten) {
		setTitle("Tạo Tài Khoản");
		setSize(300,300);
    	setLocationRelativeTo(null);
    	setResizable(false);
    	Build_GUI(ten);
	}
	public void Build_GUI(String ten) {
		JPanel pNorth;
		add(pNorth=new JPanel(),BorderLayout.NORTH);
		lblTieuDe=new JLabel("TẠO TÀI KHOẢN NHÂN VIÊN");
		pNorth.add(lblTieuDe);
		
		JPanel pCen;
		add(pCen=new JPanel(),BorderLayout.CENTER);
		pCen.setLayout(null);
		
		pCen.add(lblTenTaiKhoan=new JLabel("Tên Tài Khoản :"));
		pCen.add(lblMatKhau=new JLabel("Mật Khẩu :"));
		
		lblTenTaiKhoan.setBounds(20, 40, 100, 30);
		lblMatKhau.setBounds(20, 80, 100, 30);
		
		pCen.add(txtTenTK=new JTextField());
		pCen.add(txtMatKhau=new JTextField());
		
		txtTenTK.setBounds(130, 40, 150, 30);
		txtMatKhau.setBounds(130, 80, 150, 30);
		
		txtTenTK.setText(ten);
		txtTenTK.setEditable(false);
		
		pCen.add(btnTao=new JButton("Tạo Tài Khoản"));
		btnTao.setBounds(50,180, 200, 30);
		
		btnTao.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnTao)) {
			String mk=txtMatKhau.getText();
			if(mk.equals("")) {
				JOptionPane.showMessageDialog(this,"Vui Lòng Nhập Mật Khẩu");
			}
			if(mk.length()<8) {
				JOptionPane.showMessageDialog(this,"Vui Lòng Nhập Mật Khẩu Lớn Hơn 8");
			}
			if(mk.length()>8) {
				TaiKhoan tk=new TaiKhoan(txtTenTK.getText(),txtMatKhau.getText(),"0","2");
				xlTK=new XuLy_TaiKhoan();
				if(xlTK.suaTaiKhoan(tk)) {
					JOptionPane.showMessageDialog(this,"Tạo Tài Khoản Thành Công");
					this.dispose();
					
				}else {
					JOptionPane.showMessageDialog(this,"Tạo Tài Khoản Không Thành Công");
				}
			}
			
		}
		
	}

}
