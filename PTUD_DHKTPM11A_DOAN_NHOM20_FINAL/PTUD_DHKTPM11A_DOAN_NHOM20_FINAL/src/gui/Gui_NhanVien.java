package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Gui_NhanVien extends JFrame implements ActionListener {
	private JPanel pNorth,pCen;
	private JMenuBar menuBar;
	private JMenu mHeThong,mQuanLy,mThongKe,mXuLyDonHang;
	private JMenuItem miDangNhap,miDangXuat,
					  miQuanLyNhanVien,miQuanLyKhachHang,miQuanLySanPham,
					  miTKDoanhThu,miTKSanPham,
					  miTaoDonHang,miXemDonHang;
	private JLabel lblTieuDe;
	public Gui_NhanVien(String ten) {
		setTitle("Phan Mem Quan Ly Linh Kien Dien Tu");
    	setSize(800, 550);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
    	setResizable(false);
    	Build_GUI();
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(miDangNhap)) {
			Gui_DangNhap guidn=new Gui_DangNhap();
			guidn.setVisible(true);
		}
		if(o.equals(miDangXuat)) {
			System.exit(0);
		}
		if(o.equals(miQuanLyKhachHang)) {
			Gui_QuanLyKhachHang guikh=new Gui_QuanLyKhachHang();
			guikh.setVisible(true);
		}
		if(o.equals(miQuanLySanPham)) {
			Gui_QuanLySanPham guisp=new  Gui_QuanLySanPham();
			guisp.setVisible(true);
		}
		if(o.equals(miQuanLyNhanVien)) {
			Gui_QuanLyNhanVien guinv=new Gui_QuanLyNhanVien();
			guinv.setVisible(true);
		}
		if(o.equals(miXemDonHang)) {
			Gui_XemDonHang guixdh=new Gui_XemDonHang();
			guixdh.setVisible(true);
		}
		if(o.equals(miTaoDonHang)) {
			Gui_TaoDonHang guitdh=new Gui_TaoDonHang();
			guitdh.setVisible(true);
		}
		if(o.equals(miTKDoanhThu)) {
			Gui_ThongKe guitk=new Gui_ThongKe();
			guitk.setVisible(true);
		}
	}

}
