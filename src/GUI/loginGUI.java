package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import BLL.accountBLL;
import Startup.Startup;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class loginGUI extends JFrame {
	accountBLL accBLL = new accountBLL();
	Connection connection = null;
	
	private JPanel contentPane;
	private JTextField tfAccountName;
	private JLabel lblMtKhu;
	private JPasswordField tfPass;

	static String code = null;
	static String permission = null;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginGUI frame = new loginGUI();
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
	public loginGUI() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 490, 437);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAcountName = new JLabel("T\u00EAn \u0110\u0103ng Nh\u1EADp");
		lblAcountName.setForeground(new Color(0, 0, 0));
		lblAcountName.setBackground(Color.WHITE);
		lblAcountName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAcountName.setBounds(115, 118, 139, 38);
		contentPane.add(lblAcountName);
		
		tfAccountName = new JTextField();
		tfAccountName.setBounds(115, 155, 235, 38);
		contentPane.add(tfAccountName);
		tfAccountName.setColumns(10);
		
		lblMtKhu = new JLabel("M\u1EADt Kh\u1EA9u");
		lblMtKhu.setForeground(new Color(0, 0, 0));
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMtKhu.setBackground(Color.WHITE);
		lblMtKhu.setBounds(115, 204, 139, 38);
		contentPane.add(lblMtKhu);
		
		tfPass = new JPasswordField();
		tfPass.setBounds(115, 243, 235, 38);
		contentPane.add(tfPass);
		
		JButton btnDangNhap = new JButton("\u0110\u0103ng Nh\u1EADp");
		btnDangNhap.setBackground(new Color(245, 245, 220));
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDangNhap_actionPerformed(e);
			}
		});
		btnDangNhap.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDangNhap.setBounds(118, 321, 232, 45);
		contentPane.add(btnDangNhap);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\hospital-28-128.png"));
		lblNewLabel_1.setBounds(164, 11, 139, 96);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\308155980_851177416319243_2165810310332019320_n.jpg"));
		lblNewLabel.setBounds(0, 0, 476, 400);
		contentPane.add(lblNewLabel);
	}
	protected void do_btnDangNhap_actionPerformed(ActionEvent e) {
		if(tfAccountName.getText().equals("") || String.valueOf(tfPass.getPassword()).equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin đăng nhập"); 
		}
		else {
			try {
				connection = Startup.getConnection();
				String sql = "SELECT * FROM account WHERE ACCOUNT_NAME = ? AND PASS = ?";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, tfAccountName.getText());
				ps.setString(2, String.valueOf(tfPass.getPassword()));
				
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
					code = String.valueOf(accBLL.getId(tfAccountName.getText().toString()));
					permission = accBLL.getPermission(Integer.parseInt(code));
					if(permission.equals("Admin")) {
						adminGUI index = new adminGUI();
						index.setVisible(true);
					}

					else if(permission.equals("Bác sĩ")) {
						doctorGUI bacsi = new doctorGUI();
						bacsi.setVisible(true);
					}
					else {
						employeeGUI nhanvien = new employeeGUI();
						nhanvien.setVisible(true);
					}
					this.setVisible(false);			
				}
				else {
					JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
