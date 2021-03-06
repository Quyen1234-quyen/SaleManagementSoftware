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
		mHeThong=new JMenu("H??? Th???ng");
		mQuanLy=new JMenu("Qu???n L??");
		mXuLyDonHang=new JMenu("X??? L?? ????n H??ng");
		mThongKe=new JMenu("Th???ng K??");
		//menu con
		mHeThong.add(miDangNhap=new JMenuItem("????ng Nh???p"));
		mHeThong.add(miDangXuat=new JMenuItem("????ng Xu???t"));
		mQuanLy.add(miQuanLyKhachHang=new  JMenuItem("Qu???n L?? Kh??ch H??ng"));
		mQuanLy.add(miQuanLyNhanVien=new JMenuItem("Qu???n L?? Nh??n Vi??n"));
		mQuanLy.add(miQuanLySanPham=new JMenuItem("Qu???n L?? S???n Ph???m"));
		mXuLyDonHang.add(miTaoDonHang=new JMenuItem("T???o ????n H??ng"));
		mXuLyDonHang.add(miXemDonHang=new JMenuItem("Xem ????n H??ng"));
		mThongKe.add(miTKDoanhThu=new JMenuItem("Th???ng K?? Doanh Thu"));
		mThongKe.add(miTKSanPham=new JMenuItem("Th???ng K?? S???n Ph???m"));
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
		lblTieuDe=new JLabel("T???o ????n H??ng");
		pNorth.add(lblTieuDe);
		
		
		JPanel pCen;
		add(pCen=new JPanel(),BorderLayout.CENTER);
		pCen.setLayout(null);
		//TH??NG TIN S???N PH???M
		JPanel pRight,pLeft;	
		pCen.add(pLeft=new JPanel());
		pLeft.setBorder(BorderFactory.createTitledBorder("S???n Ph???m"));
		pLeft.setBounds(10, 20,500,370);
		pLeft.setLayout(null);
		
		btngroup=new ButtonGroup();
		raMa=new JRadioButton("T??m Theo M??");
		raMa.setSelected(true);
		raMa.setBounds(20, 20,150, 30);
		pLeft.add(raMa);
		btngroup.add(raMa);
		
		raTen=new JRadioButton("Tim Theo T??n");
    	raTen.setBounds(180, 20,150, 30);
    	pLeft.add(raTen);
    	btngroup.add(raTen);
    	
    	raXuatXu=new JRadioButton("Tim Theo Xu???t X???");
    	raXuatXu.setBounds(340, 20,150, 30);
    	pLeft.add(raXuatXu);
    	btngroup.add(raXuatXu);
    	
    	
    	
    	
    	
		
    	pLeft.add(lblNoiDung=new JLabel("Nh???p N???i Dung C???n T??m"));
		lblNoiDung.setBounds(30, 60, 300, 30);
		pLeft.add(txtTimKiem=new JTextField());
		txtTimKiem.setBounds(30, 100, 150, 30);
		pLeft.add(btnTimKiem=new JButton("T??m Ki???m"));
		btnTimKiem.setBounds(190, 100, 100, 30);
		pLeft.add(btnLamMoi=new JButton("Lam Moi"));
		btnLamMoi.setBounds(320, 100, 100, 30);
		
		JPanel pLeft_Table=new JPanel();
    	pLeft.add(pLeft_Table);
    	pLeft_Table.setLayout(null);
    	pLeft_Table.setBorder(BorderFactory.createTitledBorder("Th??ng Tin S???n Ph???m"));
    	pLeft_Table.setBounds(30,150,440,150);
    	
    	String header[]={"M?? S???n Ph???m","G??a S???n Ph???m","T??n S???n Ph???m","T???n Kho","Xu???t X???"};
    	dataModel=new DefaultTableModel(header,0);
    	JScrollPane scroll=new JScrollPane(table=new JTable(dataModel),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll.setBounds(5, 30, 430, 100);
    	pLeft_Table.add(scroll);
    	
    	pLeft.add(btnThemGioHang=new  JButton("Th??m S???n Ph???m V??o Gi??? H??ng"));
    	btnThemGioHang.setBounds(130, 320, 240, 30);
		
		
		//GI??? H??NG
		pCen.add(pRight=new JPanel());
		pRight.setLayout(null);
		pRight.setBorder(BorderFactory.createTitledBorder("Gi??? H??ng"));
		pRight.setBounds(520, 20,500,370);
		String header1[]={"M?? S???n Ph???m","G??a S???n Ph???m","T??n S???n Ph???m","S??? L?????ng","Th??nh Ti???n"};
    	dataModel1=new DefaultTableModel(header1,0);
    	JScrollPane scroll1=new JScrollPane(table1=new JTable(dataModel1),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll1.setBounds(20, 30, 460, 170);
    	pRight.add(scroll1);
    	
    	// button right
    	pRight.add(btnCapNhatGioHang=new JButton("C???p Nh???t S??? L?????ng"));
    	pRight.add(btnXoaSpGioHang=new JButton("X??a S???n Ph???m"));
    	btnCapNhatGioHang.setBounds(20, 250, 200, 30);
    	btnXoaSpGioHang.setBounds(280, 250, 200, 30);
    	
    	pRight.add(lblTongTien=new JLabel("T???ng Ti???n Gi??? H??ng :"));
    	lblTongTien.setBounds(260, 340,120, 30);
    	
    	pRight.add(lblThanhTien=new JLabel("0 VND"));
    	lblThanhTien.setBounds(390, 340, 100, 30);
		
		//button tao don hang
		pCen.add(btnTaoDonHang=new JButton("T???o ????n H??ng"));
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
							JOptionPane.showMessageDialog(this,"Kh??ng Tim Thay ");
							
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
						JOptionPane.showMessageDialog(this,"Kh??ng Tim Thay ");
					}
				}
				if(raXuatXu.isSelected()) {
					if(xlSP.timSanPhamTheoXuatXu(dulieu)!=null) {
						List<SanPham> list=new ArrayList();
						list=xlSP.timSanPhamTheoXuatXu(dulieu);
						JOptionPane.showMessageDialog(this,"Da Tim Thay ");
						UpdateSanPhamTimKiem(list);
					}else {
						JOptionPane.showMessageDialog(this,"Kh??ng Tim Thay ");
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
				JOptionPane.showMessageDialog(this,"Vui L??ng Ch???n S???n Ph???m ");
			}else {
				int ma=Integer.valueOf(lblma.getText());
				SanPham sp=xlSP.timSanPhamTheoMa(ma);
				if(sp.getTonKhoSanPham()>=1) {
					UpdateSanPhamGioHang(sp);
					lblma.setText("");
					LamMoi();
				}else {
					JOptionPane.showMessageDialog(this,"S???n Ph???m H???t H??ng ");
				}
				
			}
			
		}
		if(o.equals(btnXoaSpGioHang)) {
			int click=JOptionPane.showConfirmDialog(this,"B???n C?? Mu???n X??a N?? Ra Gi??? H??ng","Xac Nhan",JOptionPane.YES_NO_OPTION);
			if(click==JOptionPane.YES_OPTION) {
				if(!lblma.getText().equals("")) {
					int row=Integer.valueOf(lblma.getText());
					if(XoaSanPhamRaGioHang(row)) {
						JOptionPane.showMessageDialog(this,"X??a Th??nh C??ng");
					}else {
						JOptionPane.showMessageDialog(this,"X??a Kh??ng Th??nh C??ng");
					}
				}else {
					JOptionPane.showMessageDialog(this,"Vui L??ng Ch???n S???n Ph???m Trong Gi??? H??ng Mu???n X??a ");
				}
			}
			
		}
		if(o.equals(btnCapNhatGioHang)) {
			if(!lblma.getText().equals("")) {
				String s=JOptionPane.showInputDialog(this,"Nh???p S??? L?????ng:",JOptionPane.WARNING_MESSAGE);
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
						JOptionPane.showMessageDialog(this,"S??? L?????ng S???n Ph???m Kh??ng ????? ");
					}
					
				}catch(Exception a) {
					JOptionPane.showMessageDialog(this,"Nh???p D??? Li???u Sai ");
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
