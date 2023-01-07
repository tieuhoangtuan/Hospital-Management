package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class doctorGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doctorGUI frame = new doctorGUI();
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
	public doctorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 900, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Bệnh nhân");
		btnNewButton.setBackground(new Color(152, 251, 152));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnbenhnhan_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\icons8_headache_32.png"));
		btnNewButton.setBounds(0, 92, 214, 58);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Xin ch\u00E0o b\u00E1c s\u0129");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(400, 128, 205, 52);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\doctor-15-256.png"));
		lblNewLabel_2.setBounds(357, 229, 248, 255);
		contentPane.add(lblNewLabel_2);
		
		JButton btnlogout = new JButton("Đăng xuất");
		btnlogout.setForeground(Color.RED);
		btnlogout.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnlogout.setIcon(new ImageIcon("D:\\Java\\QuanLyBenhVien\\Image\\logout-7-32.png"));
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnlogout_actionPerformed(e);
			}
		});
		btnlogout.setBounds(747, 0, 139, 30);
		contentPane.add(btnlogout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Java\\QuanLyBenhVien\\Image\\hospital-28-128.png"));
		lblNewLabel.setBounds(418, 11, 128, 93);
		contentPane.add(lblNewLabel);
		
		JButton btntiepNhan = new JButton("Tiếp nhận");
		btntiepNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btntiepnhan_actionPerformed(e);
			}
		});
		btntiepNhan.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\create-1-32.png"));
		btntiepNhan.setHorizontalAlignment(SwingConstants.LEFT);
		btntiepNhan.setFont(new Font("Tahoma", Font.BOLD, 13));
		btntiepNhan.setBackground(new Color(152, 251, 152));
		btntiepNhan.setBounds(0, 148, 214, 58);
		contentPane.add(btntiepNhan);
		
		JButton btnhoSo = new JButton("Hồ sơ");
		btnhoSo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnhs_actionPerformed(e);
			}
		});
		btnhoSo.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\icons8_book_32.png"));
		btnhoSo.setHorizontalAlignment(SwingConstants.LEFT);
		btnhoSo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnhoSo.setBackground(new Color(152, 251, 152));
		btnhoSo.setBounds(0, 203, 214, 58);
		contentPane.add(btnhoSo);
	}

	protected void do_btnhs_actionPerformed(ActionEvent e) {
		hsbaGUI hsbaGUI = new hsbaGUI();
		hsbaGUI.setVisible(true);
		this.setVisible(false);
	}

	protected void do_btntiepnhan_actionPerformed(ActionEvent e) {
		tiepnhanGUI tiepnhanGUI = new tiepnhanGUI();
		tiepnhanGUI.setVisible(true);
		this.setVisible(false);
	}

	protected void do_btnbenhnhan_actionPerformed(ActionEvent e) {
		benhnhanGUI benhnhanGUI = new benhnhanGUI();
		benhnhanGUI.setVisible(true);
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
