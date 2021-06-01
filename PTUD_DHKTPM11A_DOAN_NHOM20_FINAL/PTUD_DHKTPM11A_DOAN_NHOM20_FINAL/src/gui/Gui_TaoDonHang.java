package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

import controller.XuLy_ChiTietDonDatHang;
import controller.XuLy_DonDatHang;
import controller.XuLy_SanPham;
import entity.ChiTietDonDatHang;
import entity.DonDatHang;
import entity.SanPham;

public class Gui_TaoDonHang extends JFrame implements ActionListener,MouseListener {
	private JPanel pNorth,pCen;
	private JMenuBar menuBar;
	private JMenu mHeThong,mQuanLy,mThongKe,mXuLyDonHang;
	private JMenuItem miDangNhap,miDangXuat,
					  miQuanLyNhanVien,miQuanLyKhachHang,miQuanLySanPham,
					  miTKDoanhThu,miTKSanPham,
					  miTaoDonHang,miXemDonHang;
	private JLabel lblTieuDe,lblNoiDung,lblTongTien,lblThanhTien,lblma,lblSoLuong;
	private JTextField txtTimKiem;
	private JButton btnTimKiem,btnThemGioHang,btnXoaSpGioHang,btnCapNhatGioHang,btnTaoDonHang,btnLamMoi;
	private JTable table,table1;
	private ButtonGroup btngroup;
	private JRadioButton raTen,raMa,raXuatXu;
	private DefaultTableModel dataModel,dataModel1;
	private XuLy_SanPham xlSP=new XuLy_SanPham();
	private XuLy_DonDatHang xlDDH=new XuLy_DonDatHang();
	private XuLy_ChiTietDonDatHang xlCTDDH=new XuLy_ChiTietDonDatHang();
	Gui_XacNhanDonHang gui_XNDH;
	public Gui_TaoDonHang() {
		setTitle("Phan Mem Quan Ly Linh Kien Dien Tu");
		setSize(1035,600);
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
		lblTieuDe=new JLabel("Tạo Đơn Hàng");
		pNorth.add(lblTieuDe);
		
		
		JPanel pCen;
		add(pCen=new JPanel(),BorderLayout.CENTER);
		pCen.setLayout(null);
		//THÔNG TIN SẢN PHẨM
		JPanel pRight,pLeft;	
		pCen.add(pLeft=new JPanel());
		pLeft.setBorder(BorderFactory.createTitledBorder("Sản Phẩm"));
		pLeft.setBounds(10, 20,500,370);
		pLeft.setLayout(null);
		
		btngroup=new ButtonGroup();
		raMa=new JRadioButton("Tìm Theo Mã");
		raMa.setSelected(true);
		raMa.setBounds(20, 20,150, 30);
		pLeft.add(raMa);
		btngroup.add(raMa);
		
		raTen=new JRadioButton("Tim Theo Tên");
    	raTen.setBounds(180, 20,150, 30);
    	pLeft.add(raTen);
    	btngroup.add(raTen);
    	
    	raXuatXu=new JRadioButton("Tim Theo Xuất Xứ");
    	raXuatXu.setBounds(340, 20,150, 30);
    	pLeft.add(raXuatXu);
    	btngroup.add(raXuatXu);
    	
    	
    	
    	
    	
		
    	pLeft.add(lblNoiDung=new JLabel("Nhập Nội Dung Cần Tìm"));
		lblNoiDung.setBounds(30, 60, 300, 30);
		pLeft.add(txtTimKiem=new JTextField());
		txtTimKiem.setBounds(30, 100, 150, 30);
		pLeft.add(btnTimKiem=new JButton("Tìm Kiếm"));
		btnTimKiem.setBounds(190, 100, 100, 30);
		pLeft.add(btnLamMoi=new JButton("Lam Moi"));
		btnLamMoi.setBounds(320, 100, 100, 30);
		
		JPanel pLeft_Table=new JPanel();
    	pLeft.add(pLeft_Table);
    	pLeft_Table.setLayout(null);
    	pLeft_Table.setBorder(BorderFactory.createTitledBorder("Thông Tin Sản Phẩm"));
    	pLeft_Table.setBounds(30,150,440,150);
    	
    	String header[]={"Mã Sản Phẩm","Gía Sản Phẩm","Tên Sản Phẩm","Tồn Kho","Xuất Xứ"};
    	dataModel=new DefaultTableModel(header,0);
    	JScrollPane scroll=new JScrollPane(table=new JTable(dataModel),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll.setBounds(5, 30, 430, 100);
    	pLeft_Table.add(scroll);
    	
    	pLeft.add(btnThemGioHang=new  JButton("Thêm Sản Phẩm Vào Giỏ Hàng"));
    	btnThemGioHang.setBounds(130, 320, 240, 30);
		
		
		//GIỎ HÀNG
		pCen.add(pRight=new JPanel());
		pRight.setLayout(null);
		pRight.setBorder(BorderFactory.createTitledBorder("Giỏ Hàng"));
		pRight.setBounds(520, 20,500,370);
		String header1[]={"Mã Sản Phẩm","Gía Sản Phẩm","Tên Sản Phẩm","Số Lượng","Thành Tiền"};
    	dataModel1=new DefaultTableModel(header1,0);
    	JScrollPane scroll1=new JScrollPane(table1=new JTable(dataModel1),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll1.setBounds(20, 30, 460, 170);
    	pRight.add(scroll1);
    	
    	// button right
    	pRight.add(btnCapNhatGioHang=new JButton("Cập Nhật Số Lượng"));
    	pRight.add(btnXoaSpGioHang=new JButton("Xóa Sản Phẩm"));
    	btnCapNhatGioHang.setBounds(20, 250, 200, 30);
    	btnXoaSpGioHang.setBounds(280, 250, 200, 30);
    	
    	pRight.add(lblTongTien=new JLabel("Tổng Tiền Giỏ Hàng :"));
    	lblTongTien.setBounds(260, 340,120, 30);
    	
    	pRight.add(lblThanhTien=new JLabel("0 VND"));
    	lblThanhTien.setBounds(390, 340, 100, 30);
		
		//button tao don hang
		pCen.add(btnTaoDonHang=new JButton("Tạo Đơn Hàng"));
		btnTaoDonHang.setBounds(450, 450, 135, 40);
		
		
		
		btnTimKiem.addActionListener(this);
		btnThemGioHang.addActionListener(this);
		btnTaoDonHang.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnXoaSpGioHang.addActionListener(this);
		btnCapNhatGioHang.addActionListener(this);
		table.addMouseListener(this);
		table1.addMouseListener(this);
		
		
		pCen.add(lblma=new JLabel());
		lblma.setVisible(false);
		pCen.add(lblSoLuong=new JLabel());
		lblSoLuong.setVisible(false);
		
	}
	public void UpdateSanPhamTimKiem(List<SanPham> list) {
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
	public void UpdateSanPhamGioHang(SanPham sp) {
		String ma=String.valueOf(sp.getMaSanPham());
		String gia=String.valueOf(sp.getGiaSanPham());
		String ten=sp.getTenSanPham();
		String soluong=String.valueOf("1");
		String thanhTien=String.valueOf(Integer.valueOf(soluong)*Integer.valueOf(gia));
		String rowData[]= {
				ma,gia,ten,soluong,thanhTien
		};
		if(dataModel1.getRowCount()==0) {
			dataModel1.addRow(rowData);
			table1.setModel(dataModel1);
		}else {
			int k=0;
			for(int j=0;j<dataModel1.getRowCount();j++) {
				if(dataModel1.getValueAt(j,0).equals(ma)) {
					String soluong1=String.valueOf(Integer.valueOf((String) dataModel1.getValueAt(j, 3))+1);
					String thanhTien1=String.valueOf(Integer.valueOf(soluong1)*Integer.valueOf(gia));
					dataModel1.setValueAt(soluong1, j, 3);
					dataModel1.setValueAt(thanhTien1, j, 4);
					table1.setModel(dataModel1);
					k++;
				}
			}

			if(k==0) {
				dataModel1.addRow(rowData);
				table1.setModel(dataModel1);
			}
		}
		TongTien();
	}
	public void TongTien() {
		int TongTien=0;
		for(int h=0;h<dataModel1.getRowCount();h++) {
			TongTien =TongTien+ Integer.valueOf((String) dataModel1.getValueAt(h, 4));
		}
		lblThanhTien.setText(TongTien+",000 VND");
	}
	private void XoaTableData() {
		if(dataModel.getRowCount()>0) {
			for(int i=dataModel.getRowCount()-1;i>-1;i--) {
				dataModel.removeRow(i);
			}
		}
	}
	private void XoaTableDataGioHang() {
		if(dataModel1.getRowCount()>0) {
			for(int i=dataModel1.getRowCount()-1;i>-1;i--) {
				dataModel1.removeRow(i);
			}
		}
	}
	//xoa san pham ra gio hang
	private boolean XoaSanPhamRaGioHang(int row) {
		dataModel1.removeRow(row);
		TongTien();
		lblma.setText("");
		return true;
	}
	// lam moi
	private void LamMoi() {
		txtTimKiem.setText("");
		XoaTableData();
		lblma.setText("");
	}
	@SuppressWarnings("deprecation")
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
							UpdateSanPhamTimKiem(list);
						}
						else {
							JOptionPane.showMessageDialog(this,"Không Tim Thay ");
							
						}
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(this,"Loi Nhap Du Lieu");
					}
				}
				if(raTen.isSelected()) {
					System.out.println();
					if(xlSP.timSanPhamTheoTen(dulieu)!=null) {
						List<SanPham> list=new ArrayList();
						list=xlSP.timSanPhamTheoTen(dulieu);
						JOptionPane.showMessageDialog(this,"Da Tim Thay ");
						UpdateSanPhamTimKiem(list);
						
					}else {
						JOptionPane.showMessageDialog(this,"Không Tim Thay ");
					}
				}
				if(raXuatXu.isSelected()) {
					if(xlSP.timSanPhamTheoXuatXu(dulieu)!=null) {
						List<SanPham> list=new ArrayList();
						list=xlSP.timSanPhamTheoXuatXu(dulieu);
						JOptionPane.showMessageDialog(this,"Da Tim Thay ");
						UpdateSanPhamTimKiem(list);
					}else {
						JOptionPane.showMessageDialog(this,"Không Tim Thay ");
						XoaTableData();
						
					}
				}
			}
		}
		if(o.equals(btnLamMoi)) {
			LamMoi();
		}
		if(o.equals(btnThemGioHang)) {
			if(lblma.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"Vui Lòng Chọn Sản Phẩm ");
			}else {
				int ma=Integer.valueOf(lblma.getText());
				SanPham sp=xlSP.timSanPhamTheoMa(ma);
				if(sp.getTonKhoSanPham()>=1) {
					UpdateSanPhamGioHang(sp);
					lblma.setText("");
					LamMoi();
				}else {
					JOptionPane.showMessageDialog(this,"Sản Phẩm Hết Hàng ");
				}
				
			}
			
		}
		if(o.equals(btnXoaSpGioHang)) {
			int click=JOptionPane.showConfirmDialog(this,"Bạn Có Muốn Xóa Nó Ra Giỏ Hàng","Xac Nhan",JOptionPane.YES_NO_OPTION);
			if(click==JOptionPane.YES_OPTION) {
				if(!lblma.getText().equals("")) {
					int row=Integer.valueOf(lblma.getText());
					if(XoaSanPhamRaGioHang(row)) {
						JOptionPane.showMessageDialog(this,"Xóa Thành Công");
					}else {
						JOptionPane.showMessageDialog(this,"Xóa Không Thành Công");
					}
				}else {
					JOptionPane.showMessageDialog(this,"Vui Lòng Chọn Sản Phẩm Trong Giỏ Hàng Muốn Xóa ");
				}
			}
			
		}
		if(o.equals(btnCapNhatGioHang)) {
			if(!lblma.getText().equals("")) {
				String s=JOptionPane.showInputDialog(this,"Nhập Số Lượng:",JOptionPane.WARNING_MESSAGE);
				lblSoLuong.setText(s);
				try {
					Integer SoLuong=Integer.valueOf(lblSoLuong.getText());
					int row1=Integer.valueOf(lblma.getText());
					int maSPinrow=Integer.valueOf((String)dataModel1.getValueAt(row1, 0));
					SanPham sp=xlSP.timSanPhamTheoMa(maSPinrow);
					if(sp.getTonKhoSanPham()>=Integer.valueOf(SoLuong)) {
						dataModel1.setValueAt(SoLuong,row1, 3);
						String thanhTien1=String.valueOf(Integer.valueOf(SoLuong)*Integer.valueOf((String) dataModel1.getValueAt(row1, 1)));
						dataModel1.setValueAt(thanhTien1, row1, 4);
						TongTien();
					}else {
						JOptionPane.showMessageDialog(this,"Số Lượng Sản Phẩm Không Đủ ");
					}
					
				}catch(Exception a) {
					JOptionPane.showMessageDialog(this,"Nhập Dữ Liệu Sai ");
				}
			}else {
				JOptionPane.showMessageDialog(this,"Vui Long Chon San Pham ");
			}
		}
		if(o.equals(btnTaoDonHang)) {
			int click=JOptionPane.showConfirmDialog(this,"Ban Co Muon Tao Don Hang","Xac Nhan",JOptionPane.YES_NO_OPTION);
			if(click==JOptionPane.YES_OPTION) {
				if(dataModel1.getRowCount()>0) {
					xlCTDDH=new XuLy_ChiTietDonDatHang();
//					SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
//					Date dateToday=new Date();
//					String date=sdf.format(dateToday);
					Date ngayDatHang=new Date();
//					Date ngayTest=null;
//					try {
//						 ngayTest=sdf.parse("02/09/1997 12:23:34:0000");
//					} catch (ParseException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					System.out.println("ngay hom nay "+ngayDatHang);
//					try {
//						ngayDatHang=sdf.parse(date);
//					} catch (ParseException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					Random rd = new Random();
//					int number = rd.nextInt(1000000000);
//					String number1=String.valueOf(number);
//					int maDDH;
//					if(number1.length()<9) {
//						 for(int g=0;g<=9-number1.length();g++) {
//							 System.out.println("g"+g);
//							 number1=number1+"0";
//						 }
//						 maDDH=Integer.valueOf(number1);
//					}else {
//						maDDH=number;
//					}
					DonDatHang ddh=new DonDatHang();
					ddh.setNgayDatHang(ngayDatHang);
					if(xlDDH.themDonDatHang(ddh)) {
						System.out.println("them thanh cong");
					}else {
						System.out.println("them that bai");
					}
					for(int y=0;y<dataModel1.getRowCount();y++) {
						int maSP=Integer.valueOf((String) dataModel1.getValueAt(y,0));
						int giaSP=Integer.valueOf((String) dataModel1.getValueAt(y, 1));
						int slSP=Integer.valueOf((String) dataModel1.getValueAt(y, 3));
						ChiTietDonDatHang ctddh=new ChiTietDonDatHang();
						ctddh.setDonDatHang(ddh);
						ctddh.setSanPham(xlSP.timSanPhamTheoMa(maSP));
						ctddh.setSoLuong(slSP);
						ctddh.setGiaSanPham(giaSP);
						System.out.println(ctddh.toString());
						xlCTDDH.themChiTietDonDatHang(ctddh);
					}
					gui_XNDH=new Gui_XacNhanDonHang(ddh.getMaDonDatHang());
					gui_XNDH.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(this,"Khong Co San Pham Trong Gio Hang");
				}
				
			}
			
			
		}
	}
	@Override
	public void mouseClicked(MouseEvent a) {
		// TODO Auto-generated method stub
		Object o=a.getSource();
		if(o.equals(table)){
			int row=table.getSelectedRow();
			if(row!=-1){
				int id=Integer.valueOf((String)table.getValueAt(row,0));
				lblma.setText(id+"");
			}
		}
		if(o.equals(table1)) {
			int row=table1.getSelectedRow();
			if(row!=-1){
				lblma.setText(row+"");
			}
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