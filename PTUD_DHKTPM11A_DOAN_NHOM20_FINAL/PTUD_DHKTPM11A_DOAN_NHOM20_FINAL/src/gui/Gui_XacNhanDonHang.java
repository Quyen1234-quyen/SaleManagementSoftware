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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.XuLy_ChiTietDonDatHang;
import controller.XuLy_DonDatHang;
import controller.XuLy_KhachHang;
import controller.XuLy_SanPham;
import entity.ChiTietDonDatHang;
import entity.DonDatHang;
import entity.KhachHang;

public class Gui_XacNhanDonHang extends JFrame implements ActionListener {
	private JLabel lblTieuDe,lblMaKH,lblTenKH,lblCmndKH,lblDiaChi,lblSDT,lblGioiTinh,lblNoiDung,lblMaDDH;
	private JTextField txtMaKH,txtTenKH,txtCmndKH,txtDiaChi,txtSDT,txtGioiTinh,txtTimKiem;
	private JButton btnXacNhan,btnHuyBo,btnTimKiem;
	private ButtonGroup btngroup;
	private JRadioButton raTen,raMa,raCmnd,raSDT;
	private XuLy_DonDatHang xlDDH=new XuLy_DonDatHang();
	private XuLy_KhachHang xlKH=new XuLy_KhachHang();
	private XuLy_ChiTietDonDatHang xlCTDH=new XuLy_ChiTietDonDatHang();
	private XuLy_SanPham xlSP=new  XuLy_SanPham();
	public Gui_XacNhanDonHang(int idMaDDH) {
		setTitle("Xac Nhan Don Hang");
		setSize(500,600);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE) ;
    	setLocationRelativeTo(null);
    	setResizable(false);
    	Build_GUI(idMaDDH);
	}
	public void Build_GUI(int idMaDDH) {
		JPanel pNorth;
		add(pNorth=new JPanel(),BorderLayout.NORTH);
		lblTieuDe=new JLabel("Xac Nhan Mua Hang");
		pNorth.add(lblTieuDe);
		
		JPanel pCen,pLeft,pRight;
		add(pCen=new JPanel(),BorderLayout.CENTER);
		pCen.setLayout(null);
		pCen.add(pLeft=new JPanel());
		pLeft.setBorder(BorderFactory.createTitledBorder("Tim Kiem Khách Hàng"));
		pLeft.setBounds(10, 20,480,180);
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
    	
    	raCmnd=new JRadioButton("Tìm Theo CMND");
    	raCmnd.setBounds(20, 60,150, 30);
    	pLeft.add(raCmnd);
		btngroup.add(raCmnd);
		
		raSDT=new JRadioButton("Tim Theo SDT");
		raSDT.setBounds(180, 60,150, 30);
		pLeft.add(raSDT);
    	btngroup.add(raSDT);
    	
    	pLeft.add(lblNoiDung=new JLabel("Nhập Nội Dung Cần Tìm"));
		lblNoiDung.setBounds(30, 100, 300, 30);
		pLeft.add(txtTimKiem=new JTextField());
		txtTimKiem.setBounds(30, 140, 150, 30);
		pLeft.add(btnTimKiem=new JButton("Tìm Kiếm"));
		btnTimKiem.setBounds(190, 140, 100, 30);
		
		pCen.add(pRight=new JPanel());
		pRight.setLayout(null);
		pRight.setBorder(BorderFactory.createTitledBorder("Thong Tin Khách Hàng"));
		pRight.setBounds(10, 180,480,270);
		
		pRight.add(lblMaKH=new JLabel("Mã Khách Hàng :"));
		pRight.add(lblTenKH=new JLabel("Tên Khách Hàng :"));
		pRight.add(lblCmndKH=new JLabel("Chứng Minh Nhân Dân :"));
		pRight.add(lblDiaChi=new JLabel("Địa Chỉ :"));
		pRight.add(lblGioiTinh=new JLabel("Giới Tính :"));
		pRight.add(lblSDT=new JLabel("Số Điện Thoại :"));
		
		lblMaKH.setBounds(20, 20, 150, 30);                    
		lblTenKH.setBounds(20, 60, 150, 30); 
		lblCmndKH.setBounds(20, 100, 150, 30); 
		lblDiaChi.setBounds(20, 140, 150, 30);
		lblGioiTinh.setBounds(20,180,150,30);
		lblSDT.setBounds(20, 220, 150, 30);
		
		pRight.add(txtMaKH=new JTextField());
		pRight.add(txtTenKH=new JTextField());
		pRight.add(txtCmndKH=new JTextField());
		pRight.add(txtDiaChi=new JTextField());
		pRight.add(txtGioiTinh=new JTextField());
		pRight.add(txtSDT=new JTextField());
		
		txtMaKH.setBounds(190,20,150,30);
		txtTenKH.setBounds(190,60,150,30);
		txtCmndKH.setBounds(190,100,150,30);
		txtDiaChi.setBounds(190,140,150,30);
		txtGioiTinh.setBounds(190,180,150,30);
		txtSDT.setBounds(190,220,150,30);
		
		pCen.add(btnXacNhan=new JButton("Xac Nhan Mua Hang"));
		btnXacNhan.setBounds(100, 470, 150, 30);
		pCen.add(btnHuyBo=new JButton("Huy Bo"));
		btnHuyBo.setBounds(270, 470, 100, 30);
		pCen.add(lblMaDDH=new JLabel());
		lblMaDDH.setText(idMaDDH+"");
		lblMaDDH.setVisible(false);
		
		
		
		btnHuyBo.addActionListener(this);
		btnXacNhan.addActionListener(this);
		btnTimKiem.addActionListener(this);
	}
	public void UpdateTableKhacHang(KhachHang kh) {
		if(kh!=null) {
			txtMaKH.setText(kh.getMaKhachHang());
			txtTenKH.setText(kh.getTenKH());
			txtCmndKH.setText(kh.getCmndKH()+"");
			txtDiaChi.setText(kh.getDaiChi());
			txtGioiTinh.setText(kh.getGioiTinh());
			txtSDT.setText(kh.getSoDienThoai()+"");
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
	public boolean KiemTraDuLieu() {
		try {
			String ma=txtMaKH.getText();
			String ten=txtTenKH.getText();
			int cmnd=Integer.valueOf(txtCmndKH.getText());
			String dc=txtDiaChi.getText();
			int sdt =Integer.valueOf(txtSDT.getText());
			String cmnd1=String.valueOf(cmnd);
			String sdt1=String.valueOf(sdt);
			if(ma.equals("") ||ten.equals("") || cmnd1.equals("")|| dc.equals("")|| sdt1.equals("")) {
				JOptionPane.showMessageDialog(this,"Vui Lòng Nhập Dữ Liệu");
				return false;
			}else {
				return true;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this,"Loi Nhap Du Lieu");
			return false;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnHuyBo)) {
			System.out.println("lolo");
			int click=JOptionPane.showConfirmDialog(this,"Ban Co Muon Tao Don Hang","Xac Nhan",JOptionPane.YES_NO_OPTION);
			if(click==JOptionPane.YES_OPTION) {
				List<ChiTietDonDatHang> list=xlCTDH.getALLChiTietDonDatHangTheoMaDDH(Integer.valueOf(lblMaDDH.getText()));
				for(ChiTietDonDatHang ctdh:list) {
					xlCTDH.xoaChiTietDonDatHang(ctdh);
				}
				xlDDH.xoaDonDatHang(xlDDH.timDonDatHangTheoMa(Integer.valueOf(lblMaDDH.getText())));
				this.dispose();
			}
		}
		if(o.equals(btnXacNhan)) {
			if(KiemTraDuLieu()) {
				String maKH=txtMaKH.getText();
				String tenKH=txtTenKH.getText();
				int cmndKH=Integer.valueOf(txtCmndKH.getText());
				String gtKH=txtGioiTinh.getText();
				int sdtKH=Integer.valueOf(txtSDT.getText());
				int TongTien=xlCTDH.tongTienDonDatHang(Integer.valueOf(lblMaDDH.getText()));
				String diachi=txtDiaChi.getText();
				KhachHang kh=new KhachHang(maKH,tenKH,cmndKH,diachi,gtKH,sdtKH);
				if(xlKH.timKhachHangTheoMa(txtMaKH.getText())==null) {
					xlKH.themKhachHang(kh);
				}
				DonDatHang ddh=xlDDH.timDonDatHangTheoMa(Integer.valueOf(lblMaDDH.getText()));
				ddh.setKhachHang(xlKH.timKhachHangTheoMa(txtMaKH.getText()));
				ddh.setTongTien(TongTien);
				ddh.setDiaChiNhanHang(diachi);
				if(xlDDH.suaDonDatHang(ddh)) {
					JOptionPane.showMessageDialog(this,"Hoàn Thành Đơn Hàng");
					List<ChiTietDonDatHang> ls=xlCTDH.getAllChiTietDonDatHang();
					for(ChiTietDonDatHang ct:ls) {
						if(xlSP.UpdateSoLuongSanPham(ct.getSoLuong(), ct.getSanPham().getMaSanPham())) {
							System.out.println("update thanh cong");
						}else {
							System.out.println("sua khong thanh cong");
						}
					}
					XoaRongTextField();
					this.dispose();
					
				}else {
					JOptionPane.showMessageDialog(this,"Đơn Hàng Không Hoàn Thành");
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
							UpdateTableKhacHang(list.get(0));
						}else {
							JOptionPane.showMessageDialog(this,"Không Tim Thay ");
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
							UpdateTableKhacHang(list.get(0));
						}else {
							JOptionPane.showMessageDialog(this,"Không Tim Thay ");
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
							UpdateTableKhacHang(list.get(0));
						}else {
							JOptionPane.showMessageDialog(this,"Không Tim Thay ");
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
							UpdateTableKhacHang(list.get(0));
						}else {
							JOptionPane.showMessageDialog(this,"Không Tim Thay ");
						}
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(this,"Loi Nhap Du Lieu");
					}
				}
			}
			
		}
		
	}

}
