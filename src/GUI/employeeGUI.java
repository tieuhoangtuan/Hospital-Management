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

public class employeeGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeeGUI frame = new employeeGUI();
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
	public employeeGUI() {
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
		

		JLabel lblNewLabel_1 = new JLabel("Xin ch\u00E0o nh\u00E2n vi\u00EAn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(412, 134, 227, 52);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\worker-3-256.png"));
		lblNewLabel_2.setBounds(412, 220, 248, 255);
		contentPane.add(lblNewLabel_2);
		
		JButton btnlogout = new JButton("Đăng xuất");
		btnlogout.setForeground(Color.RED);
		btnlogout.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnlogout.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\icons8_Logout_Rounded_32.png"));
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnlogout_actionPerformed(e);
			}
		});
		btnlogout.setBounds(721, 0, 165, 30);
		contentPane.add(btnlogout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Java\\QuanLyBenhVien\\Image\\hospital-28-128.png"));
		lblNewLabel.setBounds(438, 23, 128, 93);
		contentPane.add(lblNewLabel);
		
		JButton btndichVu = new JButton("Dịch vụ");
		btndichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btndichvu_actionPerformed(e);
			}
		});
		btndichVu.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\icons8_service_tips_32.png"));
		btndichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btndichVu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btndichVu.setBackground(new Color(152, 251, 152));
		btndichVu.setBounds(0, 151, 214, 58);
		contentPane.add(btndichVu);
		
		JButton btnvienPhi = new JButton("Biên lai");
		btnvienPhi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBienlai_actionPerformed(e);
			}
		});
		btnvienPhi.setIcon(new ImageIcon("D:\\Java\\QLBV\\Image\\money-48-32.png"));
		btnvienPhi.setHorizontalAlignment(SwingConstants.LEFT);
		btnvienPhi.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnvienPhi.setBackground(new Color(152, 251, 152));
		btnvienPhi.setBounds(0, 209, 214, 58);
		contentPane.add(btnvienPhi);
	}

	protected void do_btnBienlai_actionPerformed(ActionEvent e) {
		bienlaiGUI bienlaiGUI = new bienlaiGUI();
		bienlaiGUI.setVisible(true);
		this.setVisible(false);
	}

	protected void do_btndichvu_actionPerformed(ActionEvent e) {
		dichvuGUI dichvuGUI = new dichvuGUI();
		dichvuGUI.setVisible(true);
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
