package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.NhanVien;
import service.NhanVienService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class FormQLNV extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtGioiTinh;
	private JTextField txtDiaChi;
	private JPasswordField txtPassword;
	private JTable table;
	private DefaultTableModel model;
	private NhanVienService service = new NhanVienService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormQLNV frame = new FormQLNV();
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
	public FormQLNV() {
		setTitle("Quản Lý Nhân Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1037, 733);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(33, 89, 958, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(30, 28, 149, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(30, 99, 149, 28);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giới tính");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(30, 179, 149, 28);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Địa chỉ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(527, 28, 149, 28);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Password");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(527, 99, 149, 28);
		panel.add(lblNewLabel_1_4);
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaNV.setBounds(177, 28, 285, 28);
		panel.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(177, 99, 285, 28);
		panel.add(txtTenNV);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(177, 179, 285, 28);
		panel.add(txtGioiTinh);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(635, 28, 285, 28);
		panel.add(txtDiaChi);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setBounds(635, 99, 285, 28);
		panel.add(txtPassword);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(352, 10, 314, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (check()) {
					JOptionPane.showMessageDialog(contentPane, service.Add(getModel()));
					service.setArray();
					fillTable();
					Reset();
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(171, 362, 123, 42);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (check()) {
					JOptionPane.showMessageDialog(contentPane, service.Update(getModel()));
					service.setArray();
					fillTable();
					Reset();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.setBounds(424, 362, 123, 42);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMaNV.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập mã NV cần xóa");
				}else {
					JOptionPane.showMessageDialog(contentPane, service.Delete(txtMaNV.getText()));
					service.setArray();
					fillTable();
					Reset();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBounds(708, 362, 123, 42);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 430, 951, 234);
		contentPane.add(scrollPane);
		
		model = new DefaultTableModel();
		String[] cols = new String[] {"Mã nhân viên","Tên nhân viên","Giới tính","Địa chỉ","Mật khẩu"};
		model.setColumnIdentifiers(cols);
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				setModel(service.listNV.get(index));
			}
		});
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		service.setArray();
		fillTable();
	}
	
	public void fillTable() {
		model.setRowCount(0);
		for (NhanVien nhanVien : service.listNV) {
			Object[] rows = new Object[] {
				nhanVien.getMaNhanVien(),
				nhanVien.getHoTen(),
				nhanVien.getGioiTinh(),
				nhanVien.getDiaChi(),
				nhanVien.getPassword()
			};
			model.addRow(rows);
		}
	}
	
	public void setModel(NhanVien nhanVien) {
		txtMaNV.setText(nhanVien.getMaNhanVien());
		txtTenNV.setText(nhanVien.getHoTen());
		txtGioiTinh.setText(nhanVien.getGioiTinh());
		txtDiaChi.setText(nhanVien.getDiaChi());
		txtPassword.setText(nhanVien.getPassword());
	}
	
	public boolean check() {
		if (txtMaNV.getText().trim().isEmpty() || txtTenNV.getText().trim().isEmpty() || txtGioiTinh.getText().trim().isEmpty() || txtDiaChi.getText().trim().isEmpty() || String.valueOf(txtPassword.getPassword()).trim().isEmpty()) {
			JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập đầy đủ dữ liệu");
			return false;
		}
		return true;
	}
	
	public NhanVien getModel() {
		String maNV = txtMaNV.getText();
		String hoTen = txtTenNV.getText();
		String gioiTinh = txtGioiTinh.getText();
		String diaChi = txtDiaChi.getText();
		String password = String.valueOf(txtPassword.getPassword());
		NhanVien nhanVien = new NhanVien(maNV, hoTen, diaChi, gioiTinh, password);
		return nhanVien;
	}
	
	public void Reset() {
		txtMaNV.setText(null);
		txtTenNV.setText(null);
		txtGioiTinh.setText(null);
		txtDiaChi.setText(null);
		txtPassword.setText(null);
	}
}
