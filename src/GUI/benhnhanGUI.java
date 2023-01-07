package GUI;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BLL.benhnhanBLL;
import DTO.benhnhan;
import DTO.tester;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;

public class benhnhanGUI extends JFrame {
	List<benhnhan> benhnhanList = new ArrayList<benhnhan>();
	benhnhanBLL bnBLL = new benhnhanBLL();
	
	private JPanel contentPane;
	private JTextField tfmaBenhNhan;
	private JTextField tftenBenhNhan;
	private JTextField tfdiaChi;
	private JTextField tfsdt;
	private JTextField tfFind;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	private JComboBox cbgioiTinh;
	private JComboBox cbsoGiuong;
	private JPanel panel_1;
	private JComboBox cbsoPhong;
	
	String[] gioiTinhList = {"","Nam", "Nữ"};
	String[] sogiuongList = {"", "1", "2", "3", "4"};
	String[] soPhongList = {"", "1", "2", "3", "4", "5", "6"};
	private JDateChooser dcngaySinh;
	Date dateCurrent = new Date(System.currentTimeMillis());
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					benhnhanGUI frame = new benhnhanGUI();
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
	public benhnhanGUI() {
		setTitle("Bệnh  nhân");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 695);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(144, 238, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 47, 1022, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH BỆNH NHÂN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(377, 8, 264, 32);
		panel.add(lblNewLabel);
		
		tfFind = new JTextField();
		tfFind.setBounds(715, 10, 201, 30);
		panel.add(tfFind);
		tfFind.setColumns(10);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setBackground(new Color(250, 250, 210));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSearch_actionPerformed(e);
			}
		});
		btnSearch.setBounds(925, 10, 96, 31);
		panel.add(btnSearch);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(144, 238, 144));
		panel_1.setBounds(0, 369, 1022, 302);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã bệnh nhân");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(26, 34, 114, 42);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên bệnh nhân");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(26, 86, 108, 42);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ngày sinh");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(26, 138, 97, 42);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(26, 190, 97, 42);
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Giới tính");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(532, 34, 97, 42);
		panel_1.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Số giường");
		lblNewLabel_1_2_3.setForeground(Color.BLACK);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_3.setBounds(532, 138, 97, 42);
		panel_1.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Số phòng");
		lblNewLabel_1_2_4.setForeground(Color.BLACK);
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_4.setBounds(532, 190, 97, 42);
		panel_1.add(lblNewLabel_1_2_4);
		
		tfmaBenhNhan = new JTextField();
		tfmaBenhNhan.setEditable(false);
		tfmaBenhNhan.setBounds(157, 34, 299, 32);
		panel_1.add(tfmaBenhNhan);
		tfmaBenhNhan.setColumns(10);
		tfmaBenhNhan.setText(String.valueOf(bnBLL.getMaBNMax()));
		
		tftenBenhNhan = new JTextField();
		tftenBenhNhan.setColumns(10);
		tftenBenhNhan.setBounds(157, 86, 299, 32);
		panel_1.add(tftenBenhNhan);
		
		tfdiaChi = new JTextField();
		tfdiaChi.setColumns(10);
		tfdiaChi.setBounds(157, 190, 299, 32);
		panel_1.add(tfdiaChi);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(238, 232, 170));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReset_actionPerformed(e);
			}
		});
		btnReset.setBounds(186, 233, 85, 42);
		panel_1.add(btnReset);
		
		JButton btnRemove = new JButton("Xóa");
		btnRemove.setBackground(new Color(238, 232, 170));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRemove_actionPerformed(e);
			}
		});
		btnRemove.setBounds(337, 233, 85, 42);
		panel_1.add(btnRemove);
		
		JButton btnEdit = new JButton("Sửa");
		btnEdit.setBackground(new Color(238, 232, 170));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnEdit_actionPerformed(e);
			}
		});
		btnEdit.setBounds(503, 233, 85, 42);
		panel_1.add(btnEdit);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBackground(new Color(238, 232, 170));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		btnAdd.setBounds(669, 233, 85, 42);
		panel_1.add(btnAdd);
		
		cbgioiTinh = new JComboBox(gioiTinhList);
		cbgioiTinh.setBounds(639, 34, 299, 33);
		panel_1.add(cbgioiTinh);
		
		cbsoGiuong = new JComboBox(sogiuongList);
		cbsoGiuong.setBounds(639, 137, 299, 33);
		panel_1.add(cbsoGiuong);
		
		cbsoPhong = new JComboBox(soPhongList);
		cbsoPhong.setBounds(639, 190, 299, 33);
		panel_1.add(cbsoPhong);
		
		dcngaySinh = new JDateChooser();
		dcngaySinh.setBounds(157, 138, 299, 32);
		panel_1.add(dcngaySinh);
		dcngaySinh.setDate(dateCurrent);
		
		tfsdt = new JTextField();
		tfsdt.setColumns(10);
		tfsdt.setBounds(639, 92, 299, 32);
		panel_1.add(tfsdt);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_2_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_2_1.setBounds(532, 86, 97, 42);
		panel_1.add(lblNewLabel_1_2_2_1);
		
		JButton btnxuat = new JButton("Xuất");
		btnxuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnxuat_actionPerformed(e);
			}
		});
		
		
		btnxuat.setBackground(new Color(238, 232, 170));
		btnxuat.setBounds(819, 233, 85, 42);
		panel_1.add(btnxuat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 93, 1022, 276);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_table_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnGoBack = new JButton("");
		btnGoBack.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\return-24-48.png"));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnGoBack_actionPerformed(e);
			}
		});
		btnGoBack.setBounds(0, 0, 106, 48);
		contentPane.add(btnGoBack);
		
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Mã bệnh nhân");
		model.addColumn("Tên bệnh nhân");
		model.addColumn("Ngày sinh");
		model.addColumn("Địa chỉ");
		model.addColumn("Giới tính");
		model.addColumn("Số điện thoại");
		model.addColumn("Số giường");
		model.addColumn("Số phòng");
		displayList();
	}
	protected void do_btnxuat_actionPerformed(ActionEvent e) {
		try {
			JOptionPane.showMessageDialog(null, "Xuất thành công");
			XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet spreadsheet = workbook.createSheet("Benh nhan");

	        XSSFRow row = null;
	        Cell cell = null;

	        row = spreadsheet.createRow((short) 2);
	        row.setHeight((short) 500);
	        cell = row.createCell(0, CellType.STRING);
	        cell.setCellValue("DANH SÁCH BỆNH NHÂN");

	        row = spreadsheet.createRow((short) 3);
	        row.setHeight((short) 1000);
	        cell = row.createCell(0, CellType.STRING);
	        cell.setCellValue("STT");
	        cell = row.createCell(1, CellType.STRING);
	        cell.setCellValue("Mã bệnh nhân");
	        cell = row.createCell(2, CellType.STRING);
	        cell.setCellValue("Họ và tên");
	        cell = row.createCell(3, CellType.STRING);
	        cell.setCellValue("Ngày sinh");
	        cell = row.createCell(4, CellType.STRING);
	        cell.setCellValue("Địa chỉ");
	        cell = row.createCell(5, CellType.STRING);
	        cell.setCellValue("Giới tính");
	        cell = row.createCell(6, CellType.STRING);
	        cell.setCellValue("Số điện thoại");
	        cell = row.createCell(7, CellType.STRING);
	        cell.setCellValue("Số phòng");
	        cell = row.createCell(8, CellType.STRING);
	        cell.setCellValue("Số giường");
	        cell = row.createCell(9, CellType.STRING);
	        
	        
	        List<benhnhan> listItem = bnBLL.getAllbenhnhan();

	        for (int i = 0; i < listItem.size(); i++) {
	            benhnhan bn = listItem.get(i);
	            row = spreadsheet.createRow((short) 4 + i);
	            row.setHeight((short) 400);
	            row.createCell(0).setCellValue(i + 1);
	            row.createCell(1).setCellValue(bn.getMabn());
	            row.createCell(2).setCellValue(bn.getTenbn());
	            row.createCell(3).setCellValue(bn.getNgaysinh());
	            row.createCell(4).setCellValue(bn.getDiachi());
	            row.createCell(5).setCellValue(bn.getSdt());
	            row.createCell(6).setCellValue(bn.getGioitinh());
	            row.createCell(7).setCellValue(bn.getSophong());
	            row.createCell(8).setCellValue(bn.getSogiuong());
	        }
	        FileOutputStream out = new FileOutputStream(new File("D:/benhnhan.xlsx"));
	        workbook.write(out);
	        out.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	private void displayList() {
		model.setRowCount(0);
		benhnhanList = bnBLL.getAllbenhnhan();
    	int i = 0;
		while(i < benhnhanList.size()) {
			benhnhan p = benhnhanList.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getMabn(), p.getTenbn(), p.getNgaysinh(), p.getDiachi(),p.getSdt(), p.getGioitinh(), p.getSogiuong() ,p.getSophong()
			});
			i++;
		}
		
	}
	protected void do_btnReset_actionPerformed(ActionEvent e) {
		tftenBenhNhan.setText("");
		tfdiaChi.setText("");
		tfsdt.setText("");
		cbgioiTinh.setSelectedIndex(0);
		cbsoGiuong.setSelectedIndex(0);
		cbsoPhong.setSelectedIndex(0);
		dcngaySinh.setDate(dateCurrent);
		tfmaBenhNhan.setText(String.valueOf(bnBLL.getMaBNMax()));
		displayList();
	}
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		if(!tfmaBenhNhan.getText().trim().equals("") && !tftenBenhNhan.getText().trim().equals("") && !tfdiaChi.getText().trim().equals("")) {
			try {
				int code =  Integer.parseInt(tfmaBenhNhan.getText());
				String name = tftenBenhNhan.getText();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String birth = dateFormat.format(dcngaySinh.getDate());
				String address = tfdiaChi.getText();
				String sdt = tfsdt.getText();
				String gioitinh = cbgioiTinh.getSelectedItem().toString();
				int sogiuong =  Integer.parseInt(cbsoGiuong.getSelectedItem().toString());
				int sophong =  Integer.parseInt(cbsoPhong.getSelectedItem().toString());
				tester t = new tester();
				if(!t.day(birth)) {
					JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ");
					return ;
				}
				if(!t.numberPhone(sdt)) {
					JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
					return ;
				}
				
				benhnhan s=new benhnhan(code,name,birth,address,gioitinh,sdt,sogiuong,sophong);				
				JOptionPane.showMessageDialog(null,bnBLL.addbenhnhan(s));
				displayList();
				do_btnReset_actionPerformed(e);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai dữ liệu. Vui lòng thử lại");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của bệnh nhân");
		}
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {            
            tfmaBenhNhan.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tftenBenhNhan.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		String dd = String.valueOf(model.getValueAt(selectedIndex, 3));
			String pattern = "dd/mm/yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			simpleDateFormat.setLenient(false);
			try {
				java.util.Date date = simpleDateFormat.parse(dd);
				dcngaySinh.setDate(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		tfdiaChi.setText(String.valueOf(model.getValueAt(selectedIndex, 4)));
    		cbgioiTinh.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 5)));
    		tfsdt.setText(String.valueOf(model.getValueAt(selectedIndex, 6)));
    		cbsoGiuong.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 7)));
    		cbsoPhong.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 8)));
        }
	}
	protected void do_btnEdit_actionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if(index>=0 && !tfmaBenhNhan.getText().trim().equals("") && !tftenBenhNhan.getText().trim().equals("") && !tfdiaChi.getText().trim().equals("")) {
				benhnhan p = new benhnhan();
				p.setMabn(Integer.parseInt(tfmaBenhNhan.getText()));
				p.setTenbn(tftenBenhNhan.getText());
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String ngaysinh = dateFormat.format(dcngaySinh.getDate());
				p.setNgaysinh(ngaysinh);
				p.setDiachi(tfdiaChi.getText());
				p.setSdt(tfsdt.getText());
				p.setGioitinh(cbgioiTinh.getSelectedItem().toString());
				p.setSogiuong(Integer.parseInt(cbsoGiuong.getSelectedItem().toString()));
				p.setSophong(Integer.parseInt(cbsoPhong.getSelectedItem().toString()));
				if(!tester.day(p.getNgaysinh())) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng của ngày");
					return;
				}
				JOptionPane.showMessageDialog(null, bnBLL.editbenhnhan(p));
				displayList();
				do_btnReset_actionPerformed(e);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân để sửa");
			}
			
		}catch(InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của bệnh nhân");
		}
	}
	protected void do_btnRemove_actionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0 && !tfmaBenhNhan.getText().equals("")) {
        	int code =  Integer.parseInt(tfmaBenhNhan.getText());
//            Product p = productList.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa bệnh nhân này không?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa bệnh nhân này không?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
            		JOptionPane.showMessageDialog(null,bnBLL.deletebenhnhan(code));
	                displayList();
	                do_btnReset_actionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân để xóa");
        }
	}
	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		String benhnhanName = tfFind.getText();
        if(benhnhanName != null && benhnhanName.length() > 0) {
            benhnhanList = bnBLL.searchbenhnhanByName(benhnhanName);
            
            if(benhnhanList.size()==0) {
            	JOptionPane.showMessageDialog(null, "Không có bệnh nhân bạn cần tìm");
            	displayList();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < benhnhanList.size()) {
	    			benhnhan p = benhnhanList.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getMabn(), p.getTenbn(), p.getNgaysinh(), p.getDiachi(), p.getSdt() ,p.getGioitinh(), p.getSogiuong() ,p.getSophong()
	    			});
	    			i++;
	    		}
            }
            
        } 
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng nhập tên bệnh nhân cấp để tìm kiếm");
        }
	}
	protected void do_btnGoBack_actionPerformed(ActionEvent e) {
		if(loginGUI.permission.equals("Admin")) {
			adminGUI p = new adminGUI();
			p.setVisible(true);
		}
		else if(loginGUI.permission.equals("Bác sĩ")) {
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
