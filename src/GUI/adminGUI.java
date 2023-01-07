package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class adminGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminGUI frame = new adminGUI();
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
	public adminGUI() {
		setTitle("Trang chủ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 900, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnbenhNhan = new JButton("Bệnh nhân");
		btnbenhNhan.setBackground(new Color(152, 251, 152));
		btnbenhNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnbenhNhan_actionPerformed(e);
			}
		});
		btnbenhNhan.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnbenhNhan.setHorizontalAlignment(SwingConstants.LEFT);
		btnbenhNhan.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\icons8_headache_32.png"));
		btnbenhNhan.setBounds(0, 135, 214, 58);
		contentPane.add(btnbenhNhan);

		JButton btnbacSi = new JButton("Bác sĩ");
		btnbacSi.setBackground(new Color(152, 251, 152));
		btnbacSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnbacSi_actionPerformed(e);
			}
		});
		btnbacSi.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\icons8_Medical_Doctor_32.png"));
		btnbacSi.setHorizontalAlignment(SwingConstants.LEFT);
		btnbacSi.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnbacSi.setBounds(0, 192, 214, 58);
		contentPane.add(btnbacSi);

		JButton btnnhanVien = new JButton("Nhân viên");
		btnnhanVien.setBackground(new Color(152, 251, 152));
		btnnhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnnhanVien_actionPerformed(e);
			}
		});
		btnnhanVien.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\icons8_person_32.png"));
		btnnhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnnhanVien.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnnhanVien.setBounds(0, 248, 214, 65);
		contentPane.add(btnnhanVien);

		JButton btntaiKhoan = new JButton("Tài khoản");
		btntaiKhoan.setBackground(new Color(152, 251, 152));
		btntaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btntaiKhoan_actionPerformed(e);
			}
		});
		btntaiKhoan.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\account-25-32.png"));
		btntaiKhoan.setHorizontalAlignment(SwingConstants.LEFT);
		btntaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 13));
		btntaiKhoan.setBounds(0, 313, 214, 58);
		contentPane.add(btntaiKhoan);

		JButton btntiepNhan = new JButton("Tiếp nhận");
		btntiepNhan.setBackground(new Color(152, 251, 152));
		btntiepNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btntiepNhan_actionPerformed(e);
			}
		});
		btntiepNhan.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\create-1-32.png"));
		btntiepNhan.setHorizontalAlignment(SwingConstants.LEFT);
		btntiepNhan.setFont(new Font("Tahoma", Font.BOLD, 13));
		btntiepNhan.setBounds(0, 365, 214, 58);
		contentPane.add(btntiepNhan);

		JButton btndichVu = new JButton("Dịch vụ");
		btndichVu.setBackground(new Color(152, 251, 152));
		btndichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btndichVu_actionPerformed(e);
			}
		});
		btndichVu.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\icons8_service_tips_32.png"));
		btndichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btndichVu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btndichVu.setBounds(0, 423, 214, 58);
		contentPane.add(btndichVu);

		JButton btnbienLai = new JButton("Biên lai");
		btnbienLai.setBackground(new Color(152, 251, 152));
		btnbienLai.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\money-48-32.png"));
		btnbienLai.setHorizontalAlignment(SwingConstants.LEFT);
		btnbienLai.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnbienLai.setBounds(0, 537, 214, 58);
		btnbienLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnbienLai(e);
				
			}
		});
		contentPane.add(btnbienLai);

		JButton btnhoSo = new JButton("Hồ sơ");
		btnhoSo.setBackground(new Color(152, 251, 152));
		btnhoSo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnhoSo_actionPerformed(e);
			}
		});
		btnhoSo.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\icons8_book_32.png"));
		btnhoSo.setHorizontalAlignment(SwingConstants.LEFT);
		btnhoSo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnhoSo.setBounds(0, 480, 214, 58);
		contentPane.add(btnhoSo);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\facilities-manager.jpg"));
		lblNewLabel_2.setBounds(320, 161, 468, 338);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\hospital-28-128.png"));
		lblNewLabel.setBounds(39, 11, 128, 117);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BỆNH VIỆN THE HUNTER");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setBounds(377, 86, 349, 58);
		contentPane.add(lblNewLabel_1);
		
		JButton btnlogout = new JButton("Đăng xuất");
		btnlogout.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\icons8_Logout_Rounded_32.png"));
		btnlogout.setForeground(Color.RED);
		btnlogout.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnlogout_actionPerformed(e);
			}
		});
		btnlogout.setBounds(746, 0, 140, 30);
		contentPane.add(btnlogout);
	}
	protected void do_btnbienLai(ActionEvent e) {
		bienlaiGUI bienlaiGUI = new bienlaiGUI();
		bienlaiGUI.setVisible(true);
		this.setVisible(false);
	}
	protected void do_btnhoSo_actionPerformed(ActionEvent e) {
		hsbaGUI hsbaGUI = new hsbaGUI();
		hsbaGUI.setVisible(true);
		this.setVisible(false);
	}

	protected void do_btnbacSi_actionPerformed(ActionEvent e) {
		bacsiGUI bacsiGUI = new bacsiGUI();
		bacsiGUI.setVisible(true);
		this.setVisible(false);
	}

	protected void do_btnbenhNhan_actionPerformed(ActionEvent e) {
		benhnhanGUI benhnhanGUI = new benhnhanGUI();
		benhnhanGUI.setVisible(true);
		this.setVisible(false);
	}

	protected void do_btnnhanVien_actionPerformed(ActionEvent e) {
		nhanvienGUI nhanvienGUI = new nhanvienGUI();
		nhanvienGUI.setVisible(true);
		this.setVisible(false);
	}

	protected void do_btntaiKhoan_actionPerformed(ActionEvent e) {
		accountGUI accountGUI = new accountGUI();
		accountGUI.setVisible(true);
		this.setVisible(false);
	}

	protected void do_btntiepNhan_actionPerformed(ActionEvent e) {
		tiepnhanGUI tiepnhanGUI = new tiepnhanGUI();
		tiepnhanGUI.setVisible(true);
		this.setVisible(false);
	}

	protected void do_btndichVu_actionPerformed(ActionEvent e) {
		dichvuGUI dichvuGUI = new dichvuGUI();
		dichvuGUI.setVisible(true);
		this.setVisible(false);

	}
	protected void do_btnlogout_actionPerformed(ActionEvent e) {
		int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất ko?", "Question",
				JOptionPane.YES_NO_OPTION);

		if (option == JOptionPane.YES_OPTION) {
			loginGUI loginGUI = new loginGUI();
			loginGUI.setVisible(true);
			this.setVisible(false);
		}

	}
}
