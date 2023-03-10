package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BLL.accountBLL;
import BLL.bacsiBLL;
import DTO.bacsi;
import DTO.benhnhan;
import DTO.tester;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
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

public class bacsiGUI extends JFrame {
	List<bacsi> bacsiList = new ArrayList<bacsi>();
	bacsiBLL bsBLL = new bacsiBLL();
	accountBLL aBLL = new accountBLL();
	
	private JPanel contentPane;
	private JTextField tfbacsiCode;
	private JTextField tfbacsiName;
	private JTextField tfDienthoai;
	private JTextField tfbacsiAddress;
	private JTextField tfFind;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	private JComboBox cbGioiTinh;
	Date dateCurrent = new Date(System.currentTimeMillis());
	private JDateChooser DCNGAYSINH;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bacsiGUI frame = new bacsiGUI();
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
	public bacsiGUI() {
		setTitle("B??c s??");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 100, 1076, 695);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(144, 238, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 47, 1220, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH S??CH B??C S??");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(406, 8, 221, 32);
		panel.add(lblNewLabel);
		
		tfFind = new JTextField();
		tfFind.setBounds(713, 10, 221, 30);
		panel.add(tfFind);
		tfFind.setColumns(10);
		
		JButton btnSearch = new JButton("T??m ki???m");
		btnSearch.setBackground(new Color(250, 250, 210));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSearch_actionPerformed(e);
			}
		});
		btnSearch.setBounds(953, 8, 95, 31);
		panel.add(btnSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(144, 238, 144));
		panel_1.setBounds(0, 383, 1062, 275);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("M?? b??c s?? ");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(26, 34, 97, 42);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("T??n b??c s??");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(26, 86, 108, 42);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("S??? ??i???n tho???i");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(26, 138, 97, 42);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("?????a ch???");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(587, 34, 97, 42);
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Gi???i t??nh");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(587, 86, 97, 42);
		panel_1.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Ng??y sinh");
		lblNewLabel_1_2_3.setForeground(Color.BLACK);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_3.setBounds(587, 138, 97, 42);
		panel_1.add(lblNewLabel_1_2_3);
		
		tfbacsiCode = new JTextField();
		tfbacsiCode.setEditable(false);
		tfbacsiCode.setBounds(157, 34, 299, 32);
		panel_1.add(tfbacsiCode);
		tfbacsiCode.setColumns(10);
		tfbacsiCode.setText(String.valueOf(bsBLL.getMaBSMax()));
		
		tfbacsiName = new JTextField();
		tfbacsiName.setColumns(10);
		tfbacsiName.setBounds(157, 86, 299, 32);
		panel_1.add(tfbacsiName);
		
		tfDienthoai = new JTextField();
		tfDienthoai.setColumns(10);
		tfDienthoai.setBounds(157, 138, 299, 32);
		panel_1.add(tfDienthoai);
		
		tfbacsiAddress = new JTextField();
		tfbacsiAddress.setColumns(10);
		tfbacsiAddress.setBounds(667, 34, 299, 32);
		panel_1.add(tfbacsiAddress);
		
		cbGioiTinh = new JComboBox();
		cbGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"", "Nam", "N???"}));
		cbGioiTinh.setBounds(667, 86, 299, 33);
		panel_1.add(cbGioiTinh);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(238, 232, 170));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReset_actionPerformed(e);
			}
		});
		btnReset.setBounds(195, 213, 85, 42);
		panel_1.add(btnReset);
		
		JButton btnRemove = new JButton("X??a");
		btnRemove.setBackground(new Color(238, 232, 170));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRemove_actionPerformed(e);
			}
		});
		btnRemove.setBounds(347, 213, 85, 42);
		panel_1.add(btnRemove);
		
		JButton btnEdit = new JButton("S???a ");
		btnEdit.setBackground(new Color(238, 232, 170));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnEdit_actionPerformed(e);
			}
		});
		btnEdit.setBounds(703, 213, 85, 42);
		panel_1.add(btnEdit);
		
		JButton btnAdd = new JButton("Th??m");
		btnAdd.setBackground(new Color(238, 232, 170));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		btnAdd.setBounds(859, 213, 85, 42);
		panel_1.add(btnAdd);
		
		DCNGAYSINH = new JDateChooser();
		DCNGAYSINH.setBounds(667, 138, 299, 32);
		panel_1.add(DCNGAYSINH);
		DCNGAYSINH.setDate(dateCurrent);
		
		JButton btnXuat = new JButton("Xu???t");
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnXuat_actionPerformed(e);
			}
		});
		btnXuat.setBackground(new Color(238, 232, 170));
		btnXuat.setBounds(527, 213, 85, 42);
		panel_1.add(btnXuat);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 93, 1062, 289);
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
		model.addColumn("M?? b??c s??");
		model.addColumn("T??n b??c s??");
		model.addColumn("S??? ??i???n tho???i");
		model.addColumn("?????a ch???");
		model.addColumn("Gi???i t??nh");
		model.addColumn("Ng??y sinh");
		
		displayList();
	}
	
	private void displayList() {
		model.setRowCount(0);
		bacsiList = bsBLL.getAllbacsi();
		
    	int i = 0;
		while(i < bacsiList.size()) {
			bacsi p = bacsiList.get(i);
//			System.out.print(p.getMabs());
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getMabs(), p.getTenbs(), p.getDienthoai(), p.getDiachi(),p.getGioitinh(),p.getNgaysinh()
			});
			i++;
		}
		
	}
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		if(!tfbacsiCode.getText().trim().equals("") && !tfbacsiName.getText().trim().equals("") && !tfbacsiAddress.getText().trim().equals("")&& !tfDienthoai.getText().trim().equals("")) {
			try {
				int code =  Integer.parseInt(tfbacsiCode.getText());
				String name = tfbacsiName.getText();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String birth = dateFormat.format(DCNGAYSINH.getDate());				
				tester t = new tester();
				if(!t.day(birth)) {
					JOptionPane.showMessageDialog(null, "Ng??y sinh kh??ng h???p l???");
					return ;
				}
				String address = tfbacsiAddress.getText();
				String gioitinh = cbGioiTinh.getSelectedItem().toString();
				String dienthoai = tfDienthoai.getText();
				if(!t.numberPhone(dienthoai)) {
					JOptionPane.showMessageDialog(null, "S??? ??i???n tho???i kh??ng h???p l???");
					return ;
				}
				bacsi s=new bacsi(code,name,dienthoai,address,gioitinh,birth);				
				JOptionPane.showMessageDialog(null,bsBLL.addbacsi(s));
				displayList();
				do_btnReset_actionPerformed(e);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "B???n ???? nh???p sai d??? li???u. Vui l??ng th??? l???i");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui l??ng nh???p ?????y ????? th??ng tin c???a b??c s??");
		}
	}
	protected void do_btnReset_actionPerformed(ActionEvent e) {
		tfbacsiCode.setText("");
		tfbacsiName.setText("");
		tfDienthoai.setText("");
		tfbacsiAddress.setText("");
		cbGioiTinh.setSelectedIndex(0);
		DCNGAYSINH.setDate(dateCurrent);
		tfbacsiCode.setText(String.valueOf(bsBLL.getMaBSMax()));
		displayList();
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {            
            tfbacsiCode.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tfbacsiName.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		tfDienthoai.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
    		tfbacsiAddress.setText(String.valueOf(model.getValueAt(selectedIndex, 4)));
            cbGioiTinh.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 5)));
            String dd = String.valueOf(model.getValueAt(selectedIndex, 6));
			String pattern = "dd/mm/yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			simpleDateFormat.setLenient(false);
			try {
				java.util.Date date = simpleDateFormat.parse(dd);
				DCNGAYSINH.setDate(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
	}
	protected void do_btnEdit_actionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if(index>=0 && !tfbacsiCode.getText().trim().equals("") && !tfbacsiName.getText().trim().equals("") &&  !tfbacsiAddress.getText().trim().equals("")&& !tfDienthoai.getText().trim().equals("")) {
				bacsi p = new bacsi();
				p.setMabs(Integer.parseInt(tfbacsiCode.getText()));
				p.setTenbs(tfbacsiName.getText());
				p.setDienthoai(tfDienthoai.getText());
				p.setDiachi(tfbacsiAddress.getText());
				p.setGioitinh(cbGioiTinh.getSelectedItem().toString());
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String ngaykham = dateFormat.format(DCNGAYSINH.getDate());
				p.setNgaysinh(ngaykham);
				tester t = new tester();
				
				if(!t.numberPhone(tfDienthoai.getText())) {
					JOptionPane.showMessageDialog(null, "S??? ??i???n tho???i kh??ng h???p l???");
					return ;
				}
				JOptionPane.showMessageDialog(null, bsBLL.editbacsi(p));
				displayList();
				do_btnReset_actionPerformed(e);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui l??ng ch???n b??c s?? ????? s???a");
			}
			
		}catch(InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui l??ng nh???p ?????y ????? th??ng tin c???a b??c s??");
		}
	}
	protected void do_btnRemove_actionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0 && !tfbacsiCode.getText().equals("")) {
        	int code =  Integer.parseInt(tfbacsiCode.getText());
//            Product p = productList.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n x??a b??c s?? n??y kh??ng?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "B???n c?? ch???c ch???n mu???n x??a b??c s?? n??y kh??ng?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
            		JOptionPane.showMessageDialog(null,bsBLL.deletebacsi(code));
	                displayList();
	                do_btnReset_actionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui l??ng ch???n b??c s?? ????? x??a");
        }
	}
	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		String bacsiName = tfFind.getText();
        if(bacsiName != null && bacsiName.length() > 0) {
            bacsiList = bsBLL.searchbacsiByName(bacsiName);
            
            if(bacsiList.size()==0) {
            	JOptionPane.showMessageDialog(null, "Kh??ng c?? b??c s?? b???n c???n t??m");
            	displayList();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < bacsiList.size()) {
	    			bacsi p = bacsiList.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getMabs(), p.getTenbs(), p.getDienthoai(), p.getDiachi(),p.getGioitinh(), p.getNgaysinh()
	    			});
	    			i++;
	    		}
            }
            
        } else {
        	JOptionPane.showMessageDialog(null, "Vui l??ng nh???p t??n b??c s?? c???p ????? t??m ki???m");
        }
	}
	protected void do_btnGoBack_actionPerformed(ActionEvent e) {
		if(loginGUI.permission.equals("Admin")) {
			adminGUI p = new adminGUI();
			p.setVisible(true);
		}
		this.setVisible(false);
	}
	protected void do_btnXuat_actionPerformed(ActionEvent e) {
		try {
			JOptionPane.showMessageDialog(null, "Xu???t th??nh c??ng");
			XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet spreadsheet = workbook.createSheet("Bac si");

	        XSSFRow row = null;
	        Cell cell = null;

	        row = spreadsheet.createRow((short) 2);
	        row.setHeight((short) 500);
	        cell = row.createCell(0, CellType.STRING);
	        cell.setCellValue("DANH S??CH B??C S??");

	        row = spreadsheet.createRow((short) 3);
	        row.setHeight((short) 1000);
	        cell = row.createCell(0, CellType.STRING);
	        cell.setCellValue("STT");
	        cell = row.createCell(1, CellType.STRING);
	        cell.setCellValue("M?? b??c s??");
	        cell = row.createCell(2, CellType.STRING);
	        cell.setCellValue("H??? v?? t??n");
	        cell = row.createCell(3, CellType.STRING);
	        cell.setCellValue("S??? ??i???n tho???i");
	        cell = row.createCell(4, CellType.STRING);
	        cell.setCellValue("?????a ch???");
	        cell = row.createCell(5, CellType.STRING);
	        cell.setCellValue("Gi???i t??nh");
	        cell = row.createCell(6, CellType.STRING);
	        cell.setCellValue("Ng??y sinh");
	        cell = row.createCell(7, CellType.STRING);
	        
	        
	        List<bacsi> listItem = bsBLL.getAllbacsi();

	        for (int i = 0; i < listItem.size(); i++) {
	            bacsi bn = listItem.get(i);
	            row = spreadsheet.createRow((short) 4 + i);
	            row.setHeight((short) 400);
	            row.createCell(0).setCellValue(i + 1);
	            row.createCell(1).setCellValue(bn.getMabs());
	            row.createCell(2).setCellValue(bn.getTenbs());
	            row.createCell(3).setCellValue(bn.getDienthoai());
	            row.createCell(4).setCellValue(bn.getDiachi());
	       	    row.createCell(5).setCellValue(bn.getGioitinh());
	            row.createCell(6).setCellValue(bn.getNgaysinh());
	        }
	        FileOutputStream out = new FileOutputStream(new File("D:/bacsi.xlsx"));
	        workbook.write(out);
	        out.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
