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
import javax.swing.JComboBox;
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

import controller.XuLy_ChiTietDonDatHang;
import controller.XuLy_SanPham;
import entity.ChiTietDonDatHang;
import entity.SanPham;

public class Gui_QuanLySanPham extends JFrame implements ActionListener,MouseListener {
	private JMenuBar menuBar;
	private JMenu mHeThong,mQuanLy,mThongKe,mXuLyDonHang;
	private JMenuItem miDangNhap,miDangXuat,
					  miQuanLyNhanVien,miQuanLyKhachHang,miQuanLySanPham,
					  miTKDoanhThu,miTKSanPham,
					  miTaoDonHang,miXemDonHang;
	private JLabel lblTieuDe,lblMaSP,lblTenSP,lblGiaSP,lblTonKho,lblXuatXu,lblNoiDung;
	private JTextField txtMaSP,txtTenSP,txtGiaSP,txtTonKho,txtXuatXu,txtTimKiem;
	private JComboBox<String> cboXuatXu;
	private JButton btnThem,btnXoa,btnSua,btnLamMoi,btnTimKiem;
	private JTable table;
	private ButtonGroup btngroup;
	private JRadioButton raTen,raMa,raXuatXu;
	private DefaultTableModel dataModel;
	private XuLy_SanPham xlSP;
	private XuLy_ChiTietDonDatHang xlCTDDH=new XuLy_ChiTietDonDatHang();
	public Gui_QuanLySanPham() {
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
		lblTieuDe=new JLabel("Quản Lý Sản Phẩm");
		pNorth.add(lblTieuDe);
		
		
		JPanel pCen;
		add(pCen=new JPanel(),BorderLayout.CENTER);
		pCen.setLayout(null);
		
		JPanel pRight,pLeft;
		//Pleft
		pCen.add(pLeft=new JPanel());
		pLeft.setBorder(BorderFactory.createTitledBorder("Thông Tin Sản Phẩm"));
		pLeft.setBounds(10, 20,500,230);
		pLeft.setLayout(null);
		
		pLeft.add(lblMaSP=new JLabel("Mã Sản Phẩm :"));
		pLeft.add(lblTenSP=new JLabel("Tên Sản Phẩm :"));
		pLeft.add(lblGiaSP=new JLabel("Gía Sản Phẩm :"));
		pLeft.add(lblTonKho=new JLabel("Tồn Kho Sản Phẩm :"));
		pLeft.add(lblXuatXu=new JLabel("Xuất Xứ Sản Phẩm :"));
		
		pLeft.add(txtMaSP=new JTextField());
		pLeft.add(txtTenSP=new JTextField());
		pLeft.add(txtGiaSP=new JTextField());
		pLeft.add(txtTonKho=new JTextField());
		pLeft.add(txtXuatXu=new JTextField());
		
		
		
		lblMaSP.setBounds(20, 20, 150, 30);                    
		lblTenSP.setBounds(20, 60, 150, 30); 
		lblGiaSP.setBounds(20, 100, 150, 30); 
		lblTonKho.setBounds(20, 140, 150, 30);
		lblXuatXu.setBounds(20,180,150,30);
		
		txtMaSP.setBounds(190,20,150,30);
		txtTenSP.setBounds(190,60,150,30);
		txtGiaSP.setBounds(190,100,150,30);
		txtTonKho.setBounds(190,140,150,30);
		txtXuatXu.setBounds(190,180,150,30);
		
		
		
		
		//pRight
		pCen.add(pRight=new JPanel());
		pRight.setLayout(null);
		pRight.setBorder(BorderFactory.createTitledBorder("Tìm Kiếm Sản Phẩm"));
		pRight.setBounds(520, 20,500,230);
		
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
    	
    	raXuatXu=new JRadioButton("Tim Theo Xuất Xứ");
    	raXuatXu.setBounds(340, 20,150, 30);
    	pRight.add(raXuatXu);
    	btngroup.add(raXuatXu);
    	
    	
    	
		
		pRight.add(lblNoiDung=new JLabel("Nhập Nội Dung Cần Tìm"));
		lblNoiDung.setBounds(30, 60, 300, 30);
		pRight.add(txtTimKiem=new JTextField());
		txtTimKiem.setBounds(30, 100, 150, 30);
		pRight.add(btnTimKiem=new JButton("Tìm Kiếm"));
		btnTimKiem.setBounds(190, 100, 100, 30);
		
		pCen.add(btnThem=new JButton("Thêm") );
		btnThem.setBounds(300,260,100,30);
		pCen.add(btnSua=new JButton("Sửa") );
		btnSua.setBounds(405,260,100,30);
		pCen.add(btnXoa=new JButton("Xoa") );
		btnXoa.setBounds(510,260,100,30);
		pCen.add(btnLamMoi=new JButton("Làm Mới") );
		btnLamMoi.setBounds(615,260,100,30);
		
		
		JPanel pSouth=new JPanel();
    	pCen.add(pSouth);
    	pSouth.setLayout(null);
    	pSouth.setBorder(BorderFactory.createTitledBorder("Danh Sách Sản Phẩm"));
    	pSouth.setBounds(20, 300, 990, 200);
    	
    	String header[]={"Mã Sản Phẩm","Gía Sản Phẩm","Tên Sản Phẩm","Tồn Kho","Xuất Xứ"};
    	dataModel=new DefaultTableModel(header,0);
    	JScrollPane scroll=new JScrollPane(table=new JTable(dataModel),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll.setBounds(20, 20, 950, 150);
    	pSouth.add(scroll);
    	xlSP=new XuLy_SanPham();
    	UpdateSanPhamTable(xlSP.getAllSanPham());
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLamMoi.addActionListener(this);
		table.addMouseListener(this);
		btnTimKiem.addActionListener(this);
		
	}
	private void UpdateSanPhamTable(List<SanPham> list) {
		XoaTableData();
		for(SanPham sp:list) {
			String ma=String.valueOf(sp.getMaSanPham());
			String gia=String.valueOf(sp.getGiaSanPham());
			String ten=sp.getTenSanPham();
			String tonkho=String.valueOf(sp.getTonKhoSanPham());
			String xuatXu=sp.getXuatXuSanPham();
			String rowData[]= {
					ma,gia,ten,tonkho,xuatXu
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
	public void NhapSanPhamVaoTextField() {
		int row=table.getSelectedRow();
		if(row!=-1){
			txtMaSP.setText((String)table.getValueAt(row,0));
			txtGiaSP.setText((String)table.getValueAt(row, 1));
			txtTenSP.setText((String)table.getValueAt(row, 2));
			txtTonKho.setText((String)table.getValueAt(row, 3));
			txtXuatXu.setText((String)table.getValueAt(row, 4));
			
		}
	}
	public void XoaRongTextField() {
		txtMaSP.setText("");
		txtTenSP.setText("");
		txtGiaSP.setText("");
		txtTonKho.setText("");
		txtXuatXu.setText("");
		txtTimKiem.setText("");
		txtMaSP.requestFocus();
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
			this.dispose();
			guikh.setVisible(true);
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
			UpdateSanPhamTable(xlSP.getAllSanPham());
			txtMaSP.setEditable(true);
		}
		if(o.equals(btnThem)) {
			String ma=txtMaSP.getText();
			String gia=txtGiaSP.getText();
			String ten=txtTenSP.getText();
			String xuatXu=txtXuatXu.getText();
			String tonKho=txtTonKho.getText();
			if(gia.equals("") || ten.equals("") ||xuatXu.equals("") || tonKho.equals(""))  {
				JOptionPane.showMessageDialog(this,"Vui Lòng Nhập Dữ Liệu");
			}else {
				try {
					int maSP=Integer.valueOf(ma);
					int giaSP=Integer.valueOf(gia);
					int tonKhoSP=Integer.valueOf(tonKho);
					SanPham sp= new SanPham(maSP,ten, giaSP, xuatXu, tonKhoSP);
					if(xlSP.themSanPham(sp)) {
						JOptionPane.showMessageDialog(this, "Thêm Thành Công");
						UpdateSanPhamTable(xlSP.getAllSanPham());
					}else {
						JOptionPane.showMessageDialog(this, "Thêm Không Thành Công");
					}
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(this,"Nhập Sai Dữ Liệu");
				}
			}
		}
		if(o.equals(btnXoa)) {
			try {
				int k=0;
				int ma=Integer.valueOf(txtMaSP.getText());
				List<ChiTietDonDatHang> listct=xlCTDDH.getAllChiTietDonDatHang();
				for(ChiTietDonDatHang ctddh:listct) {
					if(ctddh.getSanPham().getMaSanPham()==ma) {
						k++;
					}
				}
				if(k>0) {
					JOptionPane.showMessageDialog(this, "Sản Phẩm Đang Nằm Trong Đơn Hàng");
				}else {
					int click=JOptionPane.showConfirmDialog(this,"Bạn Có Muốn Xóa Sản Phẩm Này Không","Xác Nhận",JOptionPane.YES_NO_OPTION);
					if(click==JOptionPane.YES_OPTION) {
						if(xlSP.xoaSanPham(xlSP.timSanPhamTheoMa(ma))) {
							JOptionPane.showMessageDialog(this, "Xóa Thành Công");
							UpdateSanPhamTable(xlSP.getAllSanPham());
							XoaRongTextField();
						}else {
							JOptionPane.showMessageDialog(this, "Xóa Không Thành Công");
							XoaRongTextField();
						}
					}
					
				}
				
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this, "Xóa Không Thành Công");
			}
			
		}
		if(o.equals(btnSua)) {
			String ma=txtMaSP.getText();
			String gia=txtGiaSP.getText();
			String ten=txtTenSP.getText();
			String xuatXu=txtXuatXu.getText();
			String tonKho=txtTonKho.getText();
			if(gia==null || ten==null ||xuatXu==null || tonKho==null)  {
				JOptionPane.showMessageDialog(this,"Vui Long Nhap Du Lieu");
			}else {
				try {
					int maSP=Integer.valueOf(ma);
					int giaSP=Integer.valueOf(gia);
					int tonKhoSP=Integer.valueOf(tonKho);
					SanPham sp= new SanPham(maSP,ten, giaSP, xuatXu, tonKhoSP);
					if(xlSP.suaSanPham(sp)) {
						JOptionPane.showMessageDialog(this, "Sửa Thanh Cong");
						UpdateSanPhamTable(xlSP.getAllSanPham());
						XoaRongTextField();
					}else {
						JOptionPane.showMessageDialog(this, "Sửa Không Thanh Cong");
					}
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(this,"Nhap Du Lieu Sai");
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
						int ma=Integer.valueOf(dulieu);
						if(xlSP.timSanPhamTheoMa(ma)!=null) {
							List<SanPham> list=new ArrayList();
							list.add(xlSP.timSanPhamTheoMa(ma));
							JOptionPane.showMessageDialog(this,"Da Tim Thay ");
							UpdateSanPhamTable(list);
						}
						else {
							JOptionPane.showMessageDialog(this,"Không Tim Thay ");
							UpdateSanPhamTable(xlSP.getAllSanPham());
						}
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(this,"Loi Nhap Du Lieu");
					}
				}
				if(raTen.isSelected()) {
					if(xlSP.timSanPhamTheoTen(dulieu)!=null) {
						List<SanPham> list=new ArrayList();
						list=xlSP.timSanPhamTheoTen(dulieu);
						JOptionPane.showMessageDialog(this,"Da Tim Thay ");
						UpdateSanPhamTable(list);
						
					}else {
						JOptionPane.showMessageDialog(this,"Không Tim Thay ");
						UpdateSanPhamTable(xlSP.getAllSanPham());
					}
				}
				if(raXuatXu.isSelected()) {
					if(xlSP.timSanPhamTheoXuatXu(dulieu)!=null) {
						List<SanPham> list=new ArrayList();
						list=xlSP.timSanPhamTheoXuatXu(dulieu);
						JOptionPane.showMessageDialog(this,"Da Tim Thay ");
						UpdateSanPhamTable(list);
					}else {
						JOptionPane.showMessageDialog(this,"Không Tim Thay ");
						UpdateSanPhamTable(xlSP.getAllSanPham());
					}
				}
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent a) {
		// TODO Auto-generated method stub
		Object o=a.getSource();
		if(o.equals(table)){
			txtMaSP.setEditable(false);
			XoaRongTextField();
			NhapSanPhamVaoTextField();
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
