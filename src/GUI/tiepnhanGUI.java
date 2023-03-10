package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.text.ParseException;

import BLL.bacsiBLL;
import BLL.benhnhanBLL;
import BLL.bienlaiBLL;
import BLL.dichvuBLL;
import BLL.khambenhBLL;
import DTO.tester;
import DTO.bacsi;
import DTO.benhnhan;
import DTO.khambenh;
import DTO.bienlai;
import DTO.dichvu;

import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;

public class tiepnhanGUI extends JFrame {
	List<khambenh> khamBenhList = new ArrayList<khambenh>();
	khambenhBLL kbBLL = new khambenhBLL();
	bacsiBLL bsBLL = new bacsiBLL();
	List<benhnhan> benhnhanList1 = new ArrayList<benhnhan>();
	benhnhanBLL bnBLL = new benhnhanBLL();
	dichvuBLL dvBLL = new dichvuBLL();
	bienlaiBLL blBLL = new bienlaiBLL();
	
	

	private JPanel contentPane;
	private JTextField tfTrieutrung;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	private JComboBox cbBenhnhan;
	List<String> benhnhanList = kbBLL.getbenhnhanList();
	private JTextField tfsophieukham;
	private JComboBox cbBacsi;
	List<String> bacsiList = kbBLL.getbacsiList();
	List<String> maBenhList = kbBLL.getMabenh();
	private JComboBox cbMaDv;
	List<String> dichvuList = dvBLL.getdichvuList();
	private JDateChooser dcngaykham;
	Date dateCurrent = new Date(System.currentTimeMillis());
	private JTextField tftenBenh;
	private JComboBox cbfind;
	private JButton btnThanhToan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tiepnhanGUI frame = new tiepnhanGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tiepnhanGUI() {
		setTitle("Kh??m b???nh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 1283, 696);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(144, 238, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 47, 1269, 47);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("TI???P NH???N");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(249, 8, 121, 32);
		panel.add(lblNewLabel);
		
		JButton btnThanhToan = new JButton("Thanh to??n");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnThanhToan_actionPerformed(e);
			}
		});
		btnThanhToan.setBackground(new Color(250, 250, 210));
		btnThanhToan.setBounds(1136, 8, 111, 32);
		panel.add(btnThanhToan);
		
		cbfind = new JComboBox(benhnhanList.toArray());
		cbfind.setBounds(636, 7, 299, 33);
		panel.add(cbfind);
		
		JButton btnSearch = new JButton("T??m ki???m");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSearch_actionPerformed(e);
			}
		});
		btnSearch.setBackground(new Color(250, 250, 210));
		btnSearch.setBounds(954, 8, 97, 32);
		panel.add(btnSearch);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(144, 238, 144));
		panel_1.setBounds(0, 95, 493, 568);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("S??? phi???u kh??m");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(26, 34, 108, 42);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Ng??y kh??m");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(26, 86, 108, 42);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Tri???u ch???ng");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(26, 138, 97, 42);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("B??c s??");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(26, 200, 97, 31);
		panel_1.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("B???nh nh??n");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(26, 250, 97, 42);
		panel_1.add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_3 = new JLabel("T??n b???nh");
		lblNewLabel_1_2_3.setForeground(Color.BLACK);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_3.setBounds(26, 319, 97, 31);
		panel_1.add(lblNewLabel_1_2_3);

		tfTrieutrung = new JTextField();
		tfTrieutrung.setColumns(10);
		tfTrieutrung.setBounds(157, 138, 299, 32);
		panel_1.add(tfTrieutrung);

		cbBenhnhan = new JComboBox(benhnhanList.toArray());
		cbBenhnhan.setBounds(157, 248, 299, 33);
		panel_1.add(cbBenhnhan);

		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(250, 250, 210));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReset_actionPerformed(e);
			}
		});
		btnReset.setBounds(26, 464, 85, 42);
		panel_1.add(btnReset);

		JButton btnRemove = new JButton("X??a");
		btnRemove.setBackground(new Color(250, 250, 210));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRemove_actionPerformed(e);
			}
		});
		btnRemove.setBounds(140, 464, 85, 42);
		panel_1.add(btnRemove);

		JButton btnEdit = new JButton("S???a ");
		btnEdit.setBackground(new Color(250, 250, 210));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnEdit_actionPerformed(e);
			}
		});
		btnEdit.setBounds(254, 464, 85, 42);
		panel_1.add(btnEdit);

		JButton btnAdd = new JButton("Th??m");
		btnAdd.setBackground(new Color(250, 250, 210));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		btnAdd.setBounds(371, 464, 85, 42);
		panel_1.add(btnAdd);

		cbBacsi = new JComboBox(bacsiList.toArray());
		cbBacsi.setBounds(157, 190, 299, 33);
		panel_1.add(cbBacsi);

		JLabel lblNewLabel_1_2_3_1 = new JLabel("D???ch v???");
		lblNewLabel_1_2_3_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_3_1.setBounds(26, 381, 97, 29);
		panel_1.add(lblNewLabel_1_2_3_1);

		tfsophieukham = new JTextField();
		tfsophieukham.setEditable(false);
		tfsophieukham.setColumns(10);
		tfsophieukham.setBounds(157, 34, 299, 32);
		panel_1.add(tfsophieukham);
		tfsophieukham.setText(String.valueOf(kbBLL.getSPKMAX()));

		cbMaDv = new JComboBox(dichvuList.toArray());
		cbMaDv.setBounds(157, 370, 299, 33);
		panel_1.add(cbMaDv);

		dcngaykham = new JDateChooser();
		dcngaykham.setBounds(157, 86, 299, 29);
		panel_1.add(dcngaykham);
		dcngaykham.setDate(dateCurrent);
		
		tftenBenh = new JTextField();
		tftenBenh.setColumns(10);
		tftenBenh.setBounds(157, 308, 299, 32);
		panel_1.add(tftenBenh);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(492, 95, 777, 568);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_table_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);

		table.setModel(model);

		JButton btnGoBack = new JButton("");
		btnGoBack.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\return-24-48.png"));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnGoBack_actionPerformed(e);
			}
		});
		btnGoBack.setBounds(0, 0, 106, 48);
		contentPane.add(btnGoBack);
		model.addColumn("STT");
		model.addColumn("S??? phi???u kh??m");
		model.addColumn("Ng??y kh??m");
		model.addColumn("Tri???u ch???ng");
		model.addColumn("M?? b??c s??");
		model.addColumn("M?? b???nh nh??n");
		model.addColumn("T??n b???nh");
		model.addColumn("M?? d???ch v???");
		model.addColumn("Tr???ng th??i");
		model.addColumn("Gi?? Ti???n");
		displayList();
	}

	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		int maBenhNhan = cbfind.getSelectedIndex()+1;
		if (maBenhNhan >= 0) {
			khamBenhList = kbBLL.searchkhambenhs(maBenhNhan);

			if (khamBenhList.size() == 0) {
				JOptionPane.showMessageDialog(null, "Kh??ng c?? phi???u kh??m c???a b???nh nh??n n??y!");
				displayList();
			}

			else {
				model.setRowCount(0);
				int i = 0;
				while (i < khamBenhList.size()) {
					khambenh p = khamBenhList.get(i);
					String trangthai;
					if(p.getThanhtoan()==0) trangthai = "ch??a thanh to??n";
					else trangthai = "???? thanh to??n";
					model.addRow(new Object[] { model.getRowCount() + 1, p.getSophieukham(), p.getNgaykham(), p.getTrieutrung(),
							p.getMabs(), p.getMabn(), p.getTenbenh(), p.getMadv(), trangthai, p.getGia()});
					i++;
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Vui l??ng nh???p s??? phi???u kh??m ????? t??m ki???m");
		}
		
	}

	protected void do_btnThanhToan_actionPerformed(ActionEvent e) {
		int maBenhNhan = cbfind.getSelectedIndex()+1;
		
		int prince = kbBLL.prince(maBenhNhan);
		
		String tenBenhNhan = cbfind.getSelectedItem().toString();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		String ngaykham = dateFormat.format(dateCurrent);
		
		int blmax = blBLL.getblmax();
		
		bienlai p = new bienlai(blmax,ngaykham,prince,tenBenhNhan);
		
		int option = JOptionPane.showConfirmDialog(null, "T???ng chi ph?? l??: " + prince , "Question",
				JOptionPane.YES_NO_OPTION);

		if (option == JOptionPane.YES_OPTION && prince > 0) {
			JOptionPane.showMessageDialog(null, kbBLL.thanhtoan(p,maBenhNhan));
		}
		
		do_btnReset_actionPerformed(e);
		
	}

	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		if (!tfsophieukham.getText().trim().equals("") && !tfTrieutrung.getText().trim().equals("")) {
			try {
				int sophieukham = Integer.parseInt(tfsophieukham.getText());
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String ngaykham = dateFormat.format(dcngaykham.getDate());
				String tenBenh = tftenBenh.getText();
				tester t = new tester();
				if(!t.day(ngaykham)) {
					JOptionPane.showMessageDialog(null, "Ng??y kh??m kh??ng h???p l???");
					return ;
				}

				String tenBn = String.valueOf(cbBenhnhan.getSelectedItem().toString());
				int mabn = kbBLL.getData("benhnhan", "MABN", tenBn, "TENBN");

				String tenBs = String.valueOf(cbBacsi.getSelectedItem().toString());
				int mabs = kbBLL.getData("bacsi", "MABS", tenBs, "TENBS");

				String trieutrung = tfTrieutrung.getText();
				String tenDv = String.valueOf(cbMaDv.getSelectedItem());
				int maDV = kbBLL.getData("dichvu", "MADV", tenDv, "TENDV");
				khambenh kb = new khambenh(sophieukham, ngaykham, trieutrung, mabs, mabn, tenBenh, maDV, 0);
				JOptionPane.showMessageDialog(null, kbBLL.addkhambenh(kb));
				displayList();
				do_btnReset_actionPerformed(e);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "B???n ???? nh???p sai d??? li???u. Vui l??ng th??? l???i");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui l??ng nh???p ?????y ????? th??ng tin c???a phi???u kh??m");
		}
	}

	protected void do_btnReset_actionPerformed(ActionEvent e) {
		tfsophieukham.setText(String.valueOf(kbBLL.getSPKMAX()));
		dcngaykham.setDate(dateCurrent);
		tfTrieutrung.setText("");
		cbBacsi.setSelectedIndex(0);
		cbBenhnhan.setSelectedIndex(0);
		tftenBenh.setText("");
		cbMaDv.setSelectedIndex(0);
		displayList();
	}

	protected void do_btnEdit_actionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if (index >= 0 && !tfsophieukham.getText().trim().equals("") && !tfTrieutrung.getText().trim().equals("")) {
				khambenh p = new khambenh();

				p.setSophieukham(Integer.parseInt(tfsophieukham.getText()));
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String ngaykham = dateFormat.format(dcngaykham.getDate());
				p.setNgaykham(ngaykham);
				p.setTrieutrung(tfTrieutrung.getText());

				String tenBenh = tftenBenh.getText();
				p.setTenbenh(tenBenh);
				
				String tenBenhNhan = String.valueOf(cbBenhnhan.getSelectedItem().toString());
				int mabn = kbBLL.getData("benhnhan", "MABN", tenBenhNhan, "TENBN");
				p.setMabn(mabn);

				String tenBs = String.valueOf(cbBacsi.getSelectedItem().toString());
				int mabs = kbBLL.getData("bacsi", "MABS", tenBs, "TENBS");
				p.setMabs(mabs);

				String tenDichvu = String.valueOf(cbMaDv.getSelectedItem().toString());
				int maDV = kbBLL.getData("dichvu", "MADV", tenDichvu, "TENDV");
				p.setMadv(maDV);

				JOptionPane.showMessageDialog(null, kbBLL.editkhambenh(p));
				displayList();
				do_btnReset_actionPerformed(e);
			} else {
				JOptionPane.showMessageDialog(null, "Vui l??ng ch???n phi???u kh??m ????? s???a");
			}

		} catch (InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui l??ng nh???p ?????y ????? th??ng tin c???a phi???u kh??m");
		}
	}

	protected void do_btnRemove_actionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
		if (selectedIndex >= 0 && !tfsophieukham.getText().equals("")) {
			int sophieu = Integer.parseInt(tfsophieukham.getText());

			int option = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n x??a phi???u kh??m n??y kh??ng?", "Question",
					JOptionPane.YES_NO_OPTION);

			if (option == JOptionPane.YES_OPTION) {
				int sure = JOptionPane.showConfirmDialog(null, "B???n c?? ch???c ch???n mu???n x??a phi???u kh??m n??y kh??ng?",
						"Question", JOptionPane.YES_NO_OPTION);
				if (sure == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, kbBLL.deletekhambenh(sophieu));
					displayList();
					do_btnReset_actionPerformed(e);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui l??ng ch???n phi???u kh??m ????? x??a");
		}
	}

	protected void do_btnGoBack_actionPerformed(ActionEvent e) {
		if (loginGUI.permission.equals("Admin")) {
			adminGUI p = new adminGUI();
			p.setVisible(true);
		} 
		else if (loginGUI.permission.equals("B??c s??")) {
			doctorGUI p = new doctorGUI();
			p.setVisible(true);
		} 
		else {
			employeeGUI p = new employeeGUI();
			p.setVisible(true);
		}
		this.setVisible(false);
	}

	private void displayList() {
		model.setRowCount(0);
		khamBenhList = kbBLL.getAllkhambenh();
		int i = 0;
		while (i < khamBenhList.size()) {
			khambenh p = khamBenhList.get(i);
			String trangthai;
			if(p.getThanhtoan()==0) trangthai = "ch??a thanh to??n";
			else trangthai = "???? thanh to??n";
			model.addRow(new Object[] { model.getRowCount() + 1, p.getSophieukham(), p.getNgaykham(), p.getTrieutrung(),
					p.getMabs(), p.getMabn(), p.getTenbenh(), p.getMadv(), trangthai, p.getGia()});
			i++;
		}

	}

	protected void do_table_mouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
		if (selectedIndex >= 0) {
			tfsophieukham.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
			String dd = String.valueOf(model.getValueAt(selectedIndex, 2));
			String pattern = "dd/mm/yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			simpleDateFormat.setLenient(false);
			try {
				java.util.Date date = simpleDateFormat.parse(dd);
				dcngaykham.setDate(date);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			tfTrieutrung.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));

			String maBs = model.getValueAt(selectedIndex, 4).toString();
			String tenBs = kbBLL.getData1("bacsi", "TENBS", maBs, "MABS");
			cbBacsi.setSelectedItem(tenBs.toString());

			String maBn = model.getValueAt(selectedIndex, 5).toString();
			String tenBn = kbBLL.getData1("benhnhan", "TENBN", maBn, "MABN");
			cbBenhnhan.setSelectedItem(tenBn.toString());

			tftenBenh.setText(String.valueOf(model.getValueAt(selectedIndex, 6)));

			String maDv = model.getValueAt(selectedIndex, 7).toString();
			String tenDv = kbBLL.getData1("dichvu", "TENDV", maDv, "MADV");
			cbMaDv.setSelectedItem(tenDv.toString());
		}
	}

	private Date SimpleDateFormat(String string) {
		return null;
	}
}
