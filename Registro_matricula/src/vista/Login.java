package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnIngresar;
	private JTextField txtUsuario;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JLabel lblNewLabel_1;
	private JPasswordField JpasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Iniciar Sesión");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 479);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/iconos/logui8.jpg")));
		lblNewLabel.setBounds(0, 0, 291, 440);
		contentPane.add(lblNewLabel);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(this);
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setBackground(new Color(0, 51, 102));
		btnIngresar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnIngresar.setBounds(325, 288, 209, 31);
		contentPane.add(btnIngresar);
		
		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("");
		txtUsuario.setBorder(null);
		txtUsuario.setMargin(new Insets(0, 0, 0, 0));
		txtUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		txtUsuario.setForeground(Color.BLACK);
		txtUsuario.setBackground(new Color(51, 204, 255));
		txtUsuario.setBounds(365, 132, 169, 31);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblUsuario = new JLabel("");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setIcon(new ImageIcon(Login.class.getResource("/iconos/usuario3.png")));
		lblUsuario.setBounds(314, 132, 44, 32);
		contentPane.add(lblUsuario);
		
		lblContrasena = new JLabel("");
		lblContrasena.setIcon(new ImageIcon(Login.class.getResource("/iconos/candado3.png")));
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasena.setBounds(311, 215, 44, 32);
		contentPane.add(lblContrasena);
		
		lblNewLabel_1 = new JLabel("¡BIENVENIDO A CIBERTEC!");
		lblNewLabel_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_1.setBounds(301, 46, 252, 47);
		contentPane.add(lblNewLabel_1);
		
		JpasswordField = new JPasswordField();
		JpasswordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JpasswordField.setBorder(null);
		JpasswordField.setBounds(365, 215, 169, 32);
		contentPane.add(JpasswordField);
		JpasswordField.setBackground(new Color(51, 204, 255));
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	@SuppressWarnings("deprecation")
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		String usuario, contra;
		
		usuario=txtUsuario.getText();
		contra=JpasswordField.getText();
		
		
		if(usuario.equals("Cibertec2021") && contra.equals("1234")) {
			JOptionPane.showMessageDialog(null, "!Los datos son correctos! Bienvenido.", "Confirmación",JOptionPane.INFORMATION_MESSAGE);
				menuPrincipal verMenu = new menuPrincipal();
					verMenu.setVisible(true);
					verMenu.setLocationRelativeTo(null);
					dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos.", "Error" ,JOptionPane.ERROR_MESSAGE);
			txtUsuario.setText("");
			JpasswordField.setText("");
			txtUsuario.requestFocus();
		}
		
	
	}
	
}
