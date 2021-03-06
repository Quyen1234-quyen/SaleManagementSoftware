package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.XuLy_KhachHang;
import entity.KhachHang;

public class Gui_QuanLyKhachHang extends JFrame implements ActionListener,MouseListener {
	private JPanel pNorth,pCen;
	private JMenuBar menuBar;
	private JMenu mHeThong,mQuanLy,mThongKe,mXuLyDonHang;
	private JMenuItem miDangNhap,miDangXuat,
					  miQuanLyNhanVien,miQuanLyKhachHang,miQuanLySanPham,
					  miTKDoanhThu,miTKSanPham,
					  miTaoDonHang,miXemDonHang;
	private JLabel lblTieuDe,lblMaKH,lblTenKH,lblCmndKH,lblDiaChi,lblSDT,lblGioiTinh,lblNoiDung;
	private JTextField txtMaKH,txtTenKH,txtCmndKH,txtDiaChi,txtSDT,txtGioiTinh,txtTimKiem;
	private JButton btnThem,btnXoa,btnSua,btnLamMoi,btnTimKiem;
	private JTable table;
	private ButtonGroup btngroup;
	private JRadioButton raTen,raMa,raCmnd,raSDT;
	private DefaultTableModel dataModel;
	private XuLy_KhachHang xlKH;
	public Gui_QuanLyKhachHang() {
		setTitle("Phan Mem Quan Ly Linh Kien Dien Tu");
		setSize(1035,600);
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
	
	public void Main_GUI() {
		JPanel pNorth;
		add(pNorth=new JPanel(),BorderLayout.NORTH);
		lblTieuDe=new JLabel("Quản Lý Khách Hàng");
		pNorth.add(lblTieuDe);
		
		
		JPanel pCen;
		add(pCen=new JPanel(),BorderLayout.CENTER);
		pCen.setLayout(null);
		
		// THONG TIN KHACH HANG
		JPanel pRight,pLeft;
		
		pCen.add(pLeft=new JPanel());
		pLeft.setBorder(BorderFactory.createTitledBorder("Thông Tin Khách Hàng"));
		pLeft.setBounds(10, 20,500,270);
		pLeft.setLayout(null);
		
		pLeft.add(lblMaKH=new JLabel("Mã Khách Hàng :"));
		pLeft.add(lblTenKH=new JLabel("Tên Khách Hàng :"));
		pLeft.add(lblCmndKH=new JLabel("Chứng Minh Nhân Dân :"));
		pLeft.add(lblDiaChi=new JLabel("Địa Chỉ :"));
		pLeft.add(lblGioiTinh=new JLabel("Giới Tính :"));
		pLeft.add(lblSDT=new JLabel("Số Điện Thoại :"));
		
		lblMaKH.setBounds(20, 20, 150, 30);                    
		lblTenKH.setBounds(20, 60, 150, 30); 
		lblCmndKH.setBounds(20, 100, 150, 30); 
		lblDiaChi.setBounds(20, 140, 150, 30);
		lblGioiTinh.setBounds(20,180,150,30);
		lblSDT.setBounds(20, 220, 150, 30);
		
		pLeft.add(txtMaKH=new JTextField());
		pLeft.add(txtTenKH=new JTextField());
		pLeft.add(txtCmndKH=new JTextField());
		pLeft.add(txtDiaChi=new JTextField());
		pLeft.add(txtGioiTinh=new JTextField());
		pLeft.add(txtSDT=new JTextField());
		
		txtMaKH.setBounds(190,20,150,30);
		txtTenKH.setBounds(190,60,150,30);
		txtCmndKH.setBounds(190,100,150,30);
		txtDiaChi.setBounds(190,140,150,30);
		txtGioiTinh.setBounds(190,180,150,30);
		txtSDT.setBounds(190,220,150,30);
		//TIM KIEM KHACH HANG
		
		pCen.add(pRight=new JPanel());
		pRight.setLayout(null);
		pRight.setBorder(BorderFactory.createTitledBorder("Tìm Kiếm Khách Hàng"));
		pRight.setBounds(520, 20,500,270);
		
		btngroup=new ButtonGroup();
		
		raMa=new JRadioButton("Tìm Theo Mã");
		raMa.setSelected(true);
		raMa.setBounds(20, 20,150, 30);
		pRight.add(raMa);
		btngroup.add(raMa);
		

		raTen=new JRadioButton("Tim Theo Tên");
    	raTen.setBounds(180, 20,150, 30);
    	pRight.add(raTen);
    	btngroup.add(raTen);
    	
    	raCmnd=new JRadioButton("Tìm Theo CMND");
    	raCmnd.setBounds(20, 60,150, 30);
		pRight.add(raCmnd);
		btngroup.add(raCmnd);
		
		raSDT=new JRadioButton("Tim Theo SDT");
		raSDT.setBounds(180, 60,150, 30);
    	pRight.add(raSDT);
    	btngroup.add(raSDT);
		
    	pRight.add(lblNoiDung=new JLabel("Nhập Nội Dung Cần Tìm"));
		lblNoiDung.setBounds(30, 100, 300, 30);
		pRight.add(txtTimKiem=new JTextField());
		txtTimKiem.setBounds(30, 140, 150, 30);
		pRight.add(btnTimKiem=new JButton("Tìm Kiếm"));
		btnTimKiem.setBounds(190, 140, 100, 30);
		
		pCen.add(btnThem=new JButton("Thêm") );
		btnThem.setBounds(300,300,100,30);
		pCen.add(btnSua=new JButton("Sửa") );
		btnSua.setBounds(405,300,100,30);
		pCen.add(btnXoa=new JButton("Xoa") );
		btnXoa.setBounds(510,300,100,30);
		pCen.add(btnLamMoi=new JButton("Làm Mới") );
		btnLamMoi.setBounds(615,300,100,30);
		
		//DANH SACH KHACH HANG
		JPanel pSouth=new JPanel();
    	pCen.add(pSouth);
    	pSouth.setLayout(null);
    	pSouth.setBorder(BorderFactory.createTitledBorder("Danh Sách Khách Hàng"));
    	pSouth.setBounds(20, 340, 990, 200);
    	
    	String header[]={"Mã Khách Hàng","Tên Khách Hàng","CMND Khách Hàng","Địa Chỉ","Giới Tính","Số Điện Thoại"};
    	dataModel=new DefaultTableModel(header,0);
    	JScrollPane scroll=new JScrollPane(table=new JTable(dataModel),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll.setBounds(20, 20, 950, 150);
    	pSouth.add(scroll);
    	xlKH=new XuLy_KhachHang();
    	UpdateTableKhacHang(xlKH.getAllKhachHang());
    	
    	btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLamMoi.addActionListener(this);
		table.addMouseListener(this);
		btnTimKiem.addActionListener(this);
		
	}
	public void UpdateTableKhacHang(List<KhachHang> list) {
		XoaDataTable();
		for(KhachHang kh:list) {
			String ma=kh.getMaKhachHang();
			String ten=kh.getTenKH();
			String cmnd=String.valueOf(kh.getCmndKH());
			String dc=kh.getDaiChi();
			String gt=kh.getGioiTinh();
			String sdt=String.valueOf(kh.getSoDienThoai());
			String rowData[]= {
					ma,ten,cmnd,dc,gt,sdt
			};
			dataModel.addRow(rowData);
			table.setModel(dataModel);
		}
	}
	public void XoaDataTable() {
		if(dataModel.getRowCount()>0) {
			for(int i=dataModel.getRowCount()-1;i>-1;i--) {
				dataModel.removeRow(i);
			}
		}
	}
	public void NhapKhachHangVaoTextField() {
		int row=table.getSelectedRow();
		if(row!=-1) {
			txtMaKH.setText((String)table.getValueAt(row,0));
			txtTenKH.setText((String)table.getValueAt(row,1));
			txtCmndKH.setText((String)table.getValueAt(row,2));
			txtDiaChi.setText((String)table.getValueAt(row,3));
			txtGioiTinh.setText((String)table.getValueAt(row,4));
			txtSDT.setText((String)table.getValueAt(row,5));
		}
	}
	public void XoaRongTextField() {
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtCmndKH.setText("");
		txtDiaChi.setText("");
		txtGioiTinh.setText("");
		txtSDT.setText("");
		txtTimKiem.setText("");
		txtMaKH.requestFocus();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		
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
		if(o.equals(btnLamMoi)){
			XoaRongTextField();
			UpdateTableKhacHang(xlKH.getAllKhachHang());
			txtMaKH.setEditable(true);
		}
		if(o.equals(btnThem)) {
			String ma=txtMaKH.getText();
			String ten=txtTenKH.getText();
			String cmnd=txtCmndKH.getText();
			String dc=txtDiaChi.getText();
			String gt=txtGioiTinh.getText();
			String sdt=txtSDT.getText();
			if(ma.equals("")|| ten.equals("")||cmnd.equals("")|| dc.equals("")|| gt.equals("")||sdt.equals("")) {
				JOptionPane.showMessageDialog(this,"Vui Long Nhap Du Lieu");
			}else {
				try {
					int cmnd1=Integer.valueOf(cmnd);
					int sdt1=Integer.valueOf(sdt);
					
					KhachHang kh=new KhachHang(ma, ten, cmnd1, dc, gt, sdt1);
					if(xlKH.themKhachHang(kh)) {
						JOptionPane.showMessageDialog(this, "Them Thanh Cong");
						UpdateTableKhacHang(xlKH.getAllKhachHang());
						XoaRongTextField();
					}else {
						JOptionPane.showMessageDialog(this, "Them Không Thanh Cong");
					}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(this,"Nhap Du Lieu Sai");
				}
			}
		}
		if(o.equals(btnXoa)) {
			try {
				String ma=txtMaKH.getText();
				if(ma.equals("")) {
					JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Mã Cần Xóa");
				}else {
					if(xlKH.xoaKhachHang(xlKH.timKhachHangTheoMa(ma))) {
						JOptionPane.showMessageDialog(this, "Xóa Thanh Cong");
						if(xlKH.getAllKhachHang().size()>0) {
							UpdateTableKhacHang(xlKH.getAllKhachHang());
							XoaRongTextField();
						}
					}
				}
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this, "Xóa Không Thanh Cong");
			}
		}
		if(o.equals(btnSua)) {
			String ma=txtMaKH.getText();
			String ten=txtTenKH.getText();
			String cmnd=txtCmndKH.getText();
			String dc=txtDiaChi.getText();
			String gt=txtGioiTinh.getText();
			String sdt=txtSDT.getText();
			if(ma.equals("")|| ten.equals("")||cmnd.equals("")|| dc.equals("")|| gt.equals("")||sdt.equals("")) {
				JOptionPane.showMessageDialog(this,"Vui Long Nhap Du Lieu");
			}else {
				int cmnd1=Integer.valueOf(cmnd);
				int sdt1=Integer.valueOf(sdt);
				KhachHang kh=new KhachHang(ma, ten, cmnd1, dc, gt, sdt1);
				if(xlKH.suaKhachHang(kh)) {
					JOptionPane.showMessageDialog(this, "Sửa Thanh Cong");
					UpdateTableKhacHang(xlKH.getAllKhachHang());
					XoaRongTextField();
				}else {
					JOptionPane.showMessageDialog(this, "Sửa Không Thanh Cong");
					XoaRongTextField();
				}
			}
		}
		if(o.equals(btnTimKiem)) {
			String dulieu=txtTimKiem.getText();
			if(dulieu==null || dulieu.equals("")) {
				JOptionPane.showMessageDialog(this,"Chua Nhap Noi Dung Tim Kiem");
			}else {
				if(raMa.isSelected()) {
					try {
						if(xlKH.timKhachHangTheoMa(dulieu)!=null) {
							List<KhachHang> list=new ArrayList();
							list.add(xlKH.timKhachHangTheoMa(dulieu));
							JOptionPane.showMessageDialog(this,"Da Tim Thay ");
							UpdateTableKhacHang(list);
						}else {
							JOptionPane.showMessageDialog(this,"Không Tim Thay ");
							UpdateTableKhacHang(xlKH.getAllKhachHang());
						}
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(this,"Loi Nhap Du Lieu");
					}
				}
				if(raTen.isSelected()) {
					try {
						if(xlKH.timKhachHangTheoTen(dulieu)!=null) {
							List<KhachHang> list=xlKH.timKhachHangTheoTen(dulieu);
							JOptionPane.showMessageDialog(this,"Da Tim Thay ");
							UpdateTableKhacHang(list);
						}else {
							JOptionPane.showMessageDialog(this,"Không Tim Thay ");
							UpdateTableKhacHang(xlKH.getAllKhachHang());
						}
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(this,"Loi Nhap Du Lieu");
					}
				}
				if(raCmnd.isSelected()) {
					try {
						int cmnd=Integer.valueOf(dulieu);
						String cmnd1=String.valueOf(cmnd);
						if(xlKH.timKhachHangTheoCMND(cmnd1)!=null) {
							List<KhachHang> list=xlKH.timKhachHangTheoCMND(cmnd1);
							JOptionPane.showMessageDialog(this,"Da Tim Thay ");
							UpdateTableKhacHang(list);
						}else {
							JOptionPane.showMessageDialog(this,"Không Tim Thay ");
							UpdateTableKhacHang(xlKH.getAllKhachHang());
						}
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(this,"Loi Nhap Du Lieu");
					}
				}
				if(raSDT.isSelected()) {
					try {
						int sdt1=Integer.valueOf(dulieu);
						String sdt2= String.valueOf(sdt1);
						if(xlKH.timKhachHangTheoSDT(sdt2)!=null) {
							List<KhachHang> list=xlKH.timKhachHangTheoSDT(sdt2);
							JOptionPane.showMessageDialog(this,"Da Tim Thay ");
							UpdateTableKhacHang(list);
						}else {
							JOptionPane.showMessageDialog(this,"Không Tim Thay ");
							UpdateTableKhacHang(xlKH.getAllKhachHang());
						}
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(this,"Loi Nhap Du Lieu");
					}
				}
			}
			
		}
	}
	@Override
	public void mouseClicked(MouseEvent a1) {
		// TODO Auto-generated method stub
		Object o=a1.getSource();
		if(o.equals(table)){
			txtMaKH.setEditable(false);
			XoaRongTextField();
			NhapKhachHangVaoTextField();
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
