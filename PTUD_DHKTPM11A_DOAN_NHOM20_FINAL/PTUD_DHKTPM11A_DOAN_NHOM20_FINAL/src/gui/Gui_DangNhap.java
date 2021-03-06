package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.XuLy_DangNhap;
import controller.XuLy_TaiKhoan;

public class Gui_DangNhap extends JFrame implements ActionListener {
	private JPanel pNorth,pCen;
	private JMenuBar menuBar;
	private JMenu mHeThong,mQuanLy,mThongKe,mXuLyDonHang;
	private JMenuItem miDangNhap,miDangXuat,
					  miQuanLyNhanVien,miQuanLyKhachHang,miQuanLySanPham,
					  miTKDoanhThu,miTKSanPham,
					  miTaoDonHang,miXemDonHang;
	private JLabel lblTieuDe,lblTenDangNhap,lblMatKhau;
	private JTextField txtTenDangNhap,txtMatKhau;
	private JButton btnDangNhap;
	private XuLy_DangNhap xlDN;
	private XuLy_TaiKhoan xlTK;
	public Gui_DangNhap() {
		setTitle("Phan Mem Quan Ly Linh Kien Dien Tu");
    	setSize(700, 550);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
    	setResizable(false);
    	Build_GUI();
    	Main_GUI();
	}
	private void Build_GUI() {
		menuBar=new  JMenuBar();
		// menu chinh
		mHeThong=new JMenu("Hệ Thống");
		mQuanLy=new JMenu("Quản Lý");
		mXuLyDonHang=new JMenu("Xử Lý Đơn Hàng");
		mThongKe=new JMenu("Thống Kê");
		//menu con
		mHeThong.add(miDangNhap=new JMenuItem("Đăng Nhập"));
		mHeThong.add(miDangXuat=new JMenuItem("Đăng Xuất"));
		mQuanLy.add(miQuanLyKhachHang=new  JMenuItem("Quản Lý Khách Hàng"));
		mQuanLy.add(miQuanLyNhanVien=new JMenuItem("Quản Lý Nhân Viên"));
		mQuanLy.add(miQuanLySanPham=new JMenuItem("Quản Lý Sản Phẩm"));
		mXuLyDonHang.add(miTaoDonHang=new JMenuItem("Tạo Đơn Hàng"));
		mXuLyDonHang.add(miXemDonHang=new JMenuItem("Xem Đơn Hàng"));
		mThongKe.add(miTKDoanhThu=new JMenuItem("Thống Kê Doanh Thu"));
		mThongKe.add(miTKSanPham=new JMenuItem("Thống Kê Sản Phẩm"));
		// add menu
		menuBar.add(mHeThong);
		menuBar.add(mQuanLy);
		menuBar.add(mXuLyDonHang);
		menuBar.add(mThongKe);
		this.setJMenuBar(menuBar);
		miDangNhap.addActionListener(this);
		miDangXuat.addActionListener(this);
		miQuanLyNhanVien.addActionListener(this);
		miQuanLyKhachHang.addActionListener(this);
		miQuanLySanPham.addActionListener(this);
		miTaoDonHang.addActionListener(this);
		miTKDoanhThu.addActionListener(this);
		miXemDonHang.addActionListener(this);
		
	}
	private void Main_GUI() {
		pCen=new JPanel();
		add(pCen,BorderLayout.CENTER);
		pCen.setLayout(null);
		pCen.add(lblTieuDe=new JLabel("ĐĂNG NHẬP"));
		lblTieuDe.setBounds(310, 100, 100, 40);		
		
		pCen.add(lblTenDangNhap=new JLabel("Tên Đăng Nhập :"));
		pCen.add(txtTenDangNhap=new JTextField(10));
		pCen.add(lblMatKhau=new JLabel("Mật Khẩu :"));
		pCen.add(txtMatKhau=new JTextField(10));
		
		lblTenDangNhap.setBounds(200, 200, 100, 40);
		txtTenDangNhap.setBounds(320, 200, 200, 30);
		lblMatKhau.setBounds(200, 250, 100, 40);
		txtMatKhau.setBounds(320, 250, 200, 30);
		
		pCen.add(btnDangNhap=new JButton("Đăng Nhập"));
		btnDangNhap.setBounds(310, 300, 100, 40);
		
		btnDangNhap.addActionListener(this);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		String  ten=txtTenDangNhap.getText();
		String matkhau=txtMatKhau.getText();
		if(o.equals(miDangNhap)) {
			Gui_DangNhap guidn=new Gui_DangNhap();
			guidn.setVisible(true);
			this.dispose();
		}
		if(o.equals(miDangXuat)) {
			System.exit(0);
		}
		if(o.equals(miQuanLyKhachHang)) {
			Gui_QuanLyKhachHang guikh=new Gui_QuanLyKhachHang();
			guikh.setVisible(true);
			this.dispose();
		}
		if(o.equals(miQuanLySanPham)) {
			Gui_QuanLySanPham guisp=new  Gui_QuanLySanPham();
			guisp.setVisible(true);
			this.dispose();
		}
		if(o.equals(miQuanLyNhanVien)) {
			Gui_QuanLyNhanVien guinv=new Gui_QuanLyNhanVien();
			guinv.setVisible(true);
			this.dispose();
		}
		if(o.equals(miXemDonHang)) {
			Gui_XemDonHang guixdh=new Gui_XemDonHang();
			guixdh.setVisible(true);
			this.dispose();
		}
		if(o.equals(miTaoDonHang)) {
			Gui_TaoDonHang guitdh=new Gui_TaoDonHang();
			guitdh.setVisible(true);
			this.dispose();
		}
		if(o.equals(miTKDoanhThu)) {
			Gui_ThongKe guitk=new Gui_ThongKe();
			guitk.setVisible(true);
			this.dispose();
		}
		if(o.equals(btnDangNhap)) {
			if(ten.equals("")) {
				JOptionPane.showMessageDialog(this,"Bạn chưa nhập tên đăng  nhập");
				txtTenDangNhap.selectAll();
				txtTenDangNhap.requestFocus();
			}
			if(matkhau.equals("")) {
				JOptionPane.showMessageDialog(this,"Bạn chưa nhập mật khẩu");
				txtMatKhau.selectAll();
				txtMatKhau.requestFocus();
			}
			if(!ten.equals("") && !matkhau.equals("")) {
				xlDN=new XuLy_DangNhap();
				if(xlDN.dangNhap(ten, matkhau).equalsIgnoreCase("0")) {
					JOptionPane.showMessageDialog(this,"Sai ten hoặc mật khẩu vui lòng nhập lại");
				}else {
					JOptionPane.showMessageDialog(this,"Đăng Nhập Thành Công");
					xlTK=new XuLy_TaiKhoan();
					if(xlTK.timTheoTen(ten).getPhanQuyen().equals("1")) {
						Gui_Admin guiAD=new Gui_Admin(ten);
						guiAD.setVisible(true);
						this.dispose();
					}
					if(xlTK.timTheoTen(ten).getPhanQuyen().equals("2")) {
						Gui_NhanVien guiNV=new Gui_NhanVien(ten);
						guiNV.setVisible(true);
						this.dispose();
					}
				}
			}
		}
		
	}
	

}
