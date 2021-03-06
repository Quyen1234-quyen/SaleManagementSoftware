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

import controller.XuLy_NhanVien;
import controller.XuLy_TaiKhoan;
import entity.NhanVien;
import entity.TaiKhoan;

public class Gui_QuanLyNhanVien extends JFrame implements ActionListener,MouseListener {
	private JPanel pNorth,pCen;
	private JMenuBar menuBar;
	private JMenu mHeThong,mQuanLy,mThongKe,mXuLyDonHang;
	private JMenuItem miDangNhap,miDangXuat,
					  miQuanLyNhanVien,miQuanLyKhachHang,miQuanLySanPham,
					  miTKDoanhThu,miTKSanPham,
					  miTaoDonHang,miXemDonHang;
	private JLabel lblTieuDe,lblTenNV,lblCMND,lblDiacChi,lblGioiTinh,lblSDT,lblNoiDung;
	private JTextField txtTenNV,txtCMND,txtDiaChi,txtGioiTinh,txtSDT,txtTimKiem;
	private JButton btnThem,btnXoa,btnSua,btnLamMoi,btnTimKiem;
	private JTable table;
	private ButtonGroup btngroup;
	private JRadioButton raTen,raCMND,raSDT;
	private DefaultTableModel dataModel;
	private XuLy_NhanVien xlNV;
	private XuLy_TaiKhoan xlTK;
	private TaiKhoan tk;
	public Gui_QuanLyNhanVien() {
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
	private void Main_GUI() {
		JPanel pNorth;
		add(pNorth=new JPanel(),BorderLayout.NORTH);
		lblTieuDe=new JLabel("Quản Lý Nhân Viên");
		pNorth.add(lblTieuDe);
		JPanel pCen;
		add(pCen=new JPanel(),BorderLayout.CENTER);
		pCen.setLayout(null);
		// THONG TIN NHAN VIEN
		JPanel pRight,pLeft;	
		pCen.add(pLeft=new JPanel());
		pLeft.setBorder(BorderFactory.createTitledBorder("Thông Tin Nhân Viên"));
		pLeft.setBounds(10, 20,500,270);
		pLeft.setLayout(null);
		
		pLeft.add(lblTenNV=new JLabel("Tên Nhân Viên :"));
		pLeft.add(lblCMND=new JLabel("CMND Nhân Viên :"));
		pLeft.add(lblDiacChi=new JLabel("Địa Chỉ Nhân Viên :"));
		pLeft.add(lblGioiTinh=new JLabel("Giới Tính :"));
		pLeft.add(lblSDT=new JLabel("Số Điện Thoại :"));
		
		pLeft.add(txtTenNV=new JTextField());
		pLeft.add(txtCMND=new JTextField());
		pLeft.add(txtDiaChi=new JTextField());
		pLeft.add(txtGioiTinh=new JTextField());
		pLeft.add(txtSDT=new JTextField());
		
		lblTenNV.setBounds(20, 20, 150, 30);                    
		lblCMND.setBounds(20, 60, 150, 30); 
		lblDiacChi.setBounds(20, 100, 150, 30); 
		lblGioiTinh.setBounds(20, 140, 150, 30);
		lblSDT.setBounds(20,180,150,30);
		
		txtTenNV.setBounds(190,20,150,30);
		txtCMND.setBounds(190,60,150,30);
		txtDiaChi.setBounds(190,100,150,30);
		txtGioiTinh.setBounds(190,140,150,30);
		txtSDT.setBounds(190,180,150,30);
		
		//TIM KIEM NHAN VIEN
		pCen.add(pRight=new JPanel());
		pRight.setLayout(null);
		pRight.setBorder(BorderFactory.createTitledBorder("Tìm Kiếm Nhân Viên"));
		pRight.setBounds(520, 20,500,270);
		
		btngroup=new ButtonGroup();
		raTen=new JRadioButton("Tìm Theo Tên");
		raTen.setSelected(true);
		raTen.setBounds(20, 20,150, 30);
		pRight.add(raTen);
		btngroup.add(raTen);
		
		raCMND=new JRadioButton("Tim Theo CMND");
		raCMND.setBounds(180, 20,150, 30);
    	pRight.add(raCMND);
    	btngroup.add(raCMND);
		
    	raSDT=new JRadioButton("Tim Theo SDT");
    	raSDT.setBounds(340, 20,150, 30);
    	pRight.add(raSDT);
    	btngroup.add(raSDT);
    	
    	pRight.add(lblNoiDung=new JLabel("Nhập Nội Dung Cần Tìm"));
		lblNoiDung.setBounds(30, 60, 300, 30);
		pRight.add(txtTimKiem=new JTextField());
		txtTimKiem.setBounds(30, 100, 150, 30);
		pRight.add(btnTimKiem=new JButton("Tìm Kiếm"));
		btnTimKiem.setBounds(190, 100, 100, 30);
    	
		pCen.add(btnThem=new JButton("Thêm") );
		btnThem.setBounds(300,300,100,30);
		pCen.add(btnSua=new JButton("Sửa") );
		btnSua.setBounds(405,300,100,30);
		pCen.add(btnXoa=new JButton("Xoa") );
		btnXoa.setBounds(510,300,100,30);
		pCen.add(btnLamMoi=new JButton("Làm Mới") );
		btnLamMoi.setBounds(615,300,100,30);
		//DANH SACH NHAN VIEN
		JPanel pSouth=new JPanel();
		pCen.add(pSouth);
		pSouth.setLayout(null);
		pSouth.setBorder(BorderFactory.createTitledBorder("Danh Sách Nhân Viên"));
		pSouth.setBounds(20, 340, 990, 200);
		String header[]={"Tên Nhân Viên","CMND Nhân Viên","Địa Chỉ","Giới Tính","Số Điện Thoại"};
    	dataModel=new DefaultTableModel(header,0);
    	JScrollPane scroll=new JScrollPane(table=new JTable(dataModel),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll.setBounds(20, 20, 950, 150);
    	pSouth.add(scroll);
    	
    	xlNV=new XuLy_NhanVien();
    	UpdateNhanVienTable(xlNV.getAllNhanVien());
    	btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLamMoi.addActionListener(this);
		table.addMouseListener(this);
		btnTimKiem.addActionListener(this);
	}
	
	public void UpdateNhanVienTable(List<NhanVien> list) {
		XoaTableData();
		for(NhanVien nv:list) {
			String ten=nv.getTenNhanVien().getTenTaiKhoan();
			String cmnd=String.valueOf(nv.getCmndNV());
			String dc=nv.getDiaChi();
			String gt=nv.getGioiTinh();
			String sdt=String.valueOf(nv.getSoDienThoai());
			String rowData[]= {
					ten,cmnd,dc,gt,sdt
			};
			dataModel.addRow(rowData);
			table.setModel(dataModel);
		}
	}
	private void XoaTableData() {
		if(dataModel.getRowCount()>0) {
			for(int i=dataModel.getRowCount()-1;i>-1;i--) {
				dataModel.removeRow(i);
			}
		}
	}
	//nhap nhan vien vao text field
	public void NhapNhanVienVaoTextField() {
		int row=table.getSelectedRow();
		if(row!=-1) {
			txtTenNV.setText((String)table.getValueAt(row,0));
			txtCMND.setText((String)table.getValueAt(row, 1));
			txtDiaChi.setText((String)table.getValueAt(row, 2));
			txtGioiTinh.setText((String)table.getValueAt(row, 3));
			txtSDT.setText((String)table.getValueAt(row, 4));
		}
	}
	//xoa rong text field
	public void XoaRongTextField() {
		txtTenNV.setText("");
		txtCMND.setText("");
		txtDiaChi.setText("");
		txtGioiTinh.setText("");
		txtSDT.setText("");
		txtTimKiem.setText("");
		txtTenNV.requestFocus();
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
		if(o.equals(btnLamMoi)) {
			XoaRongTextField();
			UpdateNhanVienTable(xlNV.getAllNhanVien());
			txtTenNV.setEditable(true);
		}
		if(o.equals(btnThem)) {
			String ten=txtTenNV.getText();
			String cmnd=txtCMND.getText();
			String dc= txtDiaChi.getText();
			String gt=txtGioiTinh.getText();
			String sdt=txtSDT.getText();
			if(ten.equals("")||cmnd.equals("")||dc.equals("")||gt.equals("")||sdt.equals("")) {
				JOptionPane.showMessageDialog(this,"Vui Long Nhap Du Lieu");
				
			}else {
				try {
					int cmnd1=Integer.valueOf(cmnd);
					int sdt1=Integer.valueOf(sdt);
					xlTK=new XuLy_TaiKhoan();
					tk=new TaiKhoan(ten);
					if(xlTK.themTaiKhoan(tk)) {
						System.out.println("Thêm Tài Khoản Thành Công");
					}else {
						System.out.println("Thêm Tài Khoản Không Thành Công");
					}
					NhanVien nv=new NhanVien(tk,cmnd1,gt,dc,sdt1);
					if(xlNV.themNhanVien(nv)) {
						JOptionPane.showMessageDialog(this,"Thêm Nhân Viên Thành Công");
						UpdateNhanVienTable(xlNV.getAllNhanVien());
						XoaRongTextField();
						Gui_TaoTaiKhoan guiTK=new Gui_TaoTaiKhoan(ten);
						guiTK.setVisible(true);
						
					}else {
						JOptionPane.showMessageDialog(this,"Thêm Nhân Viên Không Thành Công");
					}
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(this,"Nhap Du Lieu Sai");
				}
			}
			
		}
		if(o.equals(btnXoa)) {
			try {
				String ten=txtTenNV.getText();
				if(xlNV.xoaNhanVien(xlNV.timNhanVienTheoTen(ten))) {
					JOptionPane.showMessageDialog(this, "Xóa Thanh Cong");
					UpdateNhanVienTable(xlNV.getAllNhanVien());
					XoaRongTextField();
				}else {
					JOptionPane.showMessageDialog(this, "Xóa Không Thanh Cong");
					XoaRongTextField();
				}
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this, "Xóa Không Thanh Cong");
			}
		}
		if(o.equals(btnSua)) {
			String ten=txtTenNV.getText();
			String cmnd=txtCMND.getText();
			String dc= txtDiaChi.getText();
			String gt=txtGioiTinh.getText();
			String sdt=txtSDT.getText();
			if(ten.equals("")||cmnd.equals("")||dc.equals("")||gt.equals("")||sdt.equals("")) {
				JOptionPane.showMessageDialog(this,"Vui Long Nhap Du Lieu");
				
			}else {
				try {
					int cmnd1=Integer.valueOf(cmnd);
					int sdt1=Integer.valueOf(sdt);
					xlTK=new XuLy_TaiKhoan();
					NhanVien nv=new NhanVien(xlTK.timTheoTen(ten),cmnd1,gt,gt,sdt1);
					if(xlNV.suaNhanVien(nv)) {
						JOptionPane.showMessageDialog(this, "Sửa Thanh Cong");
						UpdateNhanVienTable(xlNV.getAllNhanVien());
						XoaRongTextField();
					}
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(this,"Nhap Du Lieu Sai");
				}
			}
		}
		
		if(o.equals(btnTimKiem)) {
			String dulieu=txtTimKiem.getText();
			if(dulieu.equals("") || dulieu==null) {
				JOptionPane.showMessageDialog(this,"Chua Nhap Noi Dung Tim Kiem");
			}else {
				if(raTen.isSelected()) {
					try {
						if(xlNV.timNhanVienTheoTen(dulieu)!=null) {
							List<NhanVien> list=new ArrayList();
							list.add(xlNV.timNhanVienTheoTen(dulieu));
							JOptionPane.showMessageDialog(this,"Da Tim Thay ");
							UpdateNhanVienTable(list);
							
						}else {
							JOptionPane.showMessageDialog(this,"Không Tim Thay ");
							UpdateNhanVienTable(xlNV.getAllNhanVien());
						}
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(this,"Loi Nhap Du Lieu");
					}
				}
				if(raCMND.isSelected()) {
					 try {
						 int cmnd=Integer.valueOf(dulieu);
						 String cmnd1=String.valueOf(cmnd);
						 if(xlNV.timNhanVienTheoCMND(cmnd1)!=null) {
							 List<NhanVien> list=xlNV.timNhanVienTheoCMND(cmnd1);
							 JOptionPane.showMessageDialog(this,"Da Tim Thay ");
							 UpdateNhanVienTable(list);
						 }else {
							 JOptionPane.showMessageDialog(this,"Không Tim Thay ");
							 UpdateNhanVienTable(xlNV.getAllNhanVien());
						 }
					 }catch(Exception e1) {
						 JOptionPane.showMessageDialog(this,"Loi Nhap Du Lieu");
					 }
				}
				if(raSDT.isSelected()) {
					try {
						 int sdt=Integer.valueOf(dulieu);
						 String sdt1=String.valueOf(sdt);
						 if(xlNV.timNhanVienThoSDT(sdt1)!=null) {
							 List<NhanVien> list=xlNV.timNhanVienThoSDT(sdt1);
							 JOptionPane.showMessageDialog(this,"Da Tim Thay ");
							 UpdateNhanVienTable(list);
						 }else {
							 JOptionPane.showMessageDialog(this,"Không Tim Thay ");
							 UpdateNhanVienTable(xlNV.getAllNhanVien());
						 }
						
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(this,"Loi Nhap Du Lieu");
					}
				}
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent a) {
		// TODO Auto-generated method stub
		Object o=a.getSource();
		if(o.equals(table)) {
			txtTenNV.setEditable(false);
			XoaRongTextField();
			NhapNhanVienVaoTextField();
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
