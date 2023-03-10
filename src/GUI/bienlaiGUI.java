package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

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

import com.toedter.calendar.JDateChooser;

import BLL.benhnhanBLL;
import BLL.bienlaiBLL;
import BLL.dichvuBLL;
import BLL.khambenhBLL;
import DTO.benhnhan;
import DTO.bienlai;
import DTO.khambenh;
import javax.swing.ImageIcon;

public class bienlaiGUI extends JFrame {
	List<bienlai> bienlaiList = new ArrayList<bienlai>();
	List<benhnhan> benhnhanList1 = new ArrayList<benhnhan>();
	khambenhBLL kbBLL = new khambenhBLL();
	dichvuBLL dvBLL = new dichvuBLL();
	bienlaiBLL blBLL = new bienlaiBLL();
	benhnhanBLL bnBLL = new benhnhanBLL();

	private JPanel contentPane;
	private JTextField tfgiatien;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	List<String> benhnhanList = kbBLL.getbenhnhanList();
	private JTextField tfsobienlai;
	List<String> bacsiList = kbBLL.getbacsiList();
	List<String> maBenhList = kbBLL.getMabenh();
	List<String> dichvuList = dvBLL.getdichvuList();
	private JDateChooser dcngaythanhtoan;
	Date dateCurrent = new Date(System.currentTimeMillis());
	private JTextField tftenBenhNhan;
	private JTextField tffind;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bienlaiGUI frame = new bienlaiGUI();
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
	public bienlaiGUI() {
		setTitle("Bi??n lai");
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

		JLabel lblNewLabel = new JLabel("BI??N LAI");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(464, 8, 203, 32);
		panel.add(lblNewLabel);

		JButton btnSearch = new JButton("T??m ki???m");
		btnSearch.setBackground(new Color(250, 250, 210));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSearch_actionPerformed(e);
			}
		});

		btnSearch.setBounds(1148, 7, 97, 32);
		panel.add(btnSearch);
		
		tffind = new JTextField();
		tffind.setBounds(881, 8, 243, 30);
		panel.add(tffind);
		tffind.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(144, 238, 144));
		panel_1.setBounds(0, 95, 493, 568);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("S??? bi??n lai");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(26, 34, 108, 42);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Ng??y thanh to??n");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(26, 86, 121, 42);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Gi?? ti???n");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(26, 138, 97, 42);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("T??n b???nh nh??n");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(26, 190, 121, 42);
		panel_1.add(lblNewLabel_1_2_1);

		tfgiatien = new JTextField();
		tfgiatien.setColumns(10);
		tfgiatien.setBounds(157, 138, 299, 32);
		panel_1.add(tfgiatien);

		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(250, 250, 210));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReset_actionPerformed(e);
			}
		});
		btnReset.setBounds(26, 262, 85, 42);
		panel_1.add(btnReset);

		JButton btnRemove = new JButton("X??a");
		btnRemove.setBackground(new Color(250, 250, 210));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRemove_actionPerformed(e);
			}
		});
		btnRemove.setBounds(371, 262, 85, 42);
		panel_1.add(btnRemove);

		JButton btnEdit = new JButton("S???a ");
		btnEdit.setBackground(new Color(250, 250, 210));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnEdit_actionPerformed(e);
			}
		});
		btnEdit.setBounds(201, 262, 85, 42);
		panel_1.add(btnEdit);

		tfsobienlai = new JTextField();
		tfsobienlai.setEditable(false);
		tfsobienlai.setColumns(10);
		tfsobienlai.setBounds(157, 34, 299, 32);
		panel_1.add(tfsobienlai);

		dcngaythanhtoan = new JDateChooser();
		dcngaythanhtoan.setBounds(157, 86, 299, 29);
		panel_1.add(dcngaythanhtoan);
		dcngaythanhtoan.setDate(dateCurrent);
		
		tftenBenhNhan = new JTextField();
		tftenBenhNhan.setColumns(10);
		tftenBenhNhan.setBounds(157, 190, 299, 32);
		panel_1.add(tftenBenhNhan);

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
		model.addColumn("S??? bi??n lai");
		model.addColumn("T??n b???nh nh??n");
		model.addColumn("Ng??y thanh to??n");
		model.addColumn("Gi?? ti???n");
		
		
		displayList();
	}
	
	
	private void displayList() {
		model.setRowCount(0);
		bienlaiList = blBLL.getAllbienlai();
		int i = 0;
		while (i < bienlaiList.size()) {
			bienlai p = bienlaiList.get(i);
			model.addRow(new Object[] { model.getRowCount() + 1, p.getSoBienLai(),p.getTenBenhNhan(), p.getNgayThanhToan(), p.getTongTien()});
			i++;
		}

	}
	
	@SuppressWarnings("deprecation")
	protected void do_table_mouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
		if (selectedIndex >= 0) {
			tfsobienlai.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
			String dd = String.valueOf(model.getValueAt(selectedIndex, 3));
			String pattern = "dd/mm/yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			simpleDateFormat.setLenient(false);
			try {
				java.util.Date date = simpleDateFormat.parse(dd);
				
				dcngaythanhtoan.setDate(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			tfgiatien.setText(String.valueOf(model.getValueAt(selectedIndex, 4)));
			tftenBenhNhan.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
		}
	}
	
	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		String tenBenhNhan = tffind.getText();
		if (!tffind.getText().trim().equals("")) {
			bienlaiList = blBLL.getbyName(tenBenhNhan);

			if (bienlaiList.size() == 0) {
				JOptionPane.showMessageDialog(null, "Kh??ng c?? bi??n lai c???a b???nh nh??n n??y!");
				displayList();
			}

			else {
				model.setRowCount(0);
				int i = 0;
				while (i < bienlaiList.size()) {
					bienlai p = bienlaiList.get(i);
					model.addRow(new Object[] { model.getRowCount() + 1, p.getSoBienLai(), p.getNgayThanhToan(), p.getTongTien(),
							p.getTenBenhNhan()});
					i++;
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Vui l??ng nh???p t??n b???nh nh??n ????? t??m ki???m");
		}
	}
	
	protected void do_btnRemove_actionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
		if (selectedIndex >= 0 && !tfsobienlai.getText().equals("")) {
			int sobl = Integer.parseInt(tfsobienlai.getText());

			int option = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n x??a bi??n lai n??y kh??ng?", "Question",
					JOptionPane.YES_NO_OPTION);

			if (option == JOptionPane.YES_OPTION) {
				int sure = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n x??a bi??n lai n??y kh??ng?",
						"Question", JOptionPane.YES_NO_OPTION);
				if (sure == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, blBLL.delete(sobl));
					displayList();
					do_btnReset_actionPerformed(e);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui l??ng ch???n phi???u kh??m ????? x??a");
		}
	}
	
	protected void do_btnEdit_actionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if (index >= 0 && !tfgiatien.getText().trim().equals("") && !tfgiatien.getText().trim().equals("") && !tftenBenhNhan.getText().trim().equals("") ) {
				bienlai p = new bienlai();

				p.setSoBienLai(Integer.parseInt(tfsobienlai.getText()));
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String ngaykham = dateFormat.format(dcngaythanhtoan.getDate());
				p.setNgayThanhToan(ngaykham);
				p.setTongTien(Integer.parseInt(tfgiatien.getText()));
				p.setTenBenhNhan(tftenBenhNhan.getText());

				JOptionPane.showMessageDialog(null, blBLL.editbienlai(p));
				displayList();
				do_btnReset_actionPerformed(e);
			} else {
				JOptionPane.showMessageDialog(null, "Vui l??ng ch???n bi??n lai v?? nh???p ????? th??ng tin ????? s???a");
			}

		} catch (InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui l??ng nh???p ?????y ????? th??ng tin c???a bi??n lai");
		}
	}
	
	protected void do_btnReset_actionPerformed(ActionEvent e) {
		tfsobienlai.setText(String.valueOf(blBLL.getblmax()));
		dcngaythanhtoan.setDate(dateCurrent);
		tfgiatien.setText("");
		tffind.setText("");
		tftenBenhNhan.setText("");
		displayList();
	}
	
	protected void do_btnGoBack_actionPerformed(ActionEvent e) {
		if(loginGUI.permission.equals("Admin")) {
			adminGUI p = new adminGUI();
			p.setVisible(true);
		}
		else if(loginGUI.permission.equals("B??c s??")) {
			doctorGUI p = new doctorGUI();
			p.setVisible(true);
		}
		else {
			employeeGUI p = new employeeGUI();
			p.setVisible(true);;
		}
		this.setVisible(false);
	}
	
}
