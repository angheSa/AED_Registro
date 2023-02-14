package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class menuPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnMantenimiento;
	private JButton btnRegistro;
	private JButton btnReporte;
	private JButton btnConsulta;
	private JTextField txtRegistroYMatrcula;
	private JTextField txtMantenimiento;
	private JTextField txtReporte;
	private JTextField txtConsulta;
	private JTextField txtRegistro;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal frame = new menuPrincipal();
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
	public menuPrincipal() {
		setResizable(false);
		setTitle("Registro y matrícula de Alumnos   v. 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 355);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnMantenimiento = new JButton("");
		btnMantenimiento.setIcon(new ImageIcon(menuPrincipal.class.getResource("/iconos/m2.png")));
		
		btnMantenimiento.setToolTipText("Mantenimiento");
		
		btnMantenimiento.setBackground(Color.WHITE);
		btnMantenimiento.addActionListener(this);
		btnMantenimiento.setBounds(132, 101, 96, 71);
		btnMantenimiento.setBorder(null);
		contentPane.add(btnMantenimiento);
		
		btnRegistro = new JButton("");
		btnRegistro.setBackground(Color.WHITE);
		btnRegistro.setIcon(new ImageIcon(menuPrincipal.class.getResource("/iconos/rg.png")));
		btnRegistro.setToolTipText("Registro");
	
		btnRegistro.addActionListener(this);
		btnRegistro.setBounds(238, 101, 96, 71);
		btnRegistro.setBorder(null);
		contentPane.add(btnRegistro);
		
		btnReporte = new JButton("");
		btnReporte.setBackground(new Color(255, 255, 255));
		btnReporte.setToolTipText("Reporte");
		btnReporte.setIcon(new ImageIcon(menuPrincipal.class.getResource("/iconos/r1.png")));
		btnReporte.addActionListener(this);
		btnReporte.setBorder(null);
		btnReporte.setBounds(238, 193, 96, 71);
		contentPane.add(btnReporte);
		
		btnConsulta = new JButton("");
		btnConsulta.setBackground(Color.WHITE);
		btnConsulta.setToolTipText("Consulta");
		btnConsulta.setIcon(new ImageIcon(menuPrincipal.class.getResource("/iconos/c1.png")));
		btnConsulta.addActionListener(this);
		btnConsulta.setBounds(132, 193, 96, 71);
		contentPane.add(btnConsulta);
		btnConsulta.setBorder(null);
		
		txtRegistroYMatrcula = new JTextField();
		txtRegistroYMatrcula.setBorder(null);
		txtRegistroYMatrcula.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegistroYMatrcula.setEditable(false);
		txtRegistroYMatrcula.setBackground(Color.WHITE);
		txtRegistroYMatrcula.setForeground(new Color(0, 51, 102));
		txtRegistroYMatrcula.setFont(new Font("Century Gothic", Font.BOLD, 24));
		txtRegistroYMatrcula.setText("Registro y Matrícula de Alumnos");
		txtRegistroYMatrcula.setBounds(0, 0, 474, 71);
		contentPane.add(txtRegistroYMatrcula);
		txtRegistroYMatrcula.setColumns(10);
		
		txtMantenimiento = new JTextField();
		txtMantenimiento.setBorder(null);
		txtMantenimiento.setHorizontalAlignment(SwingConstants.CENTER);
		txtMantenimiento.setBackground(new Color(72, 209, 204));
		txtMantenimiento.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtMantenimiento.setText("MANTENIMIENTO");
		txtMantenimiento.setForeground(new Color(0, 51, 102));
		txtMantenimiento.setEditable(false);
		txtMantenimiento.setBounds(0, 125, 122, 36);
		contentPane.add(txtMantenimiento);
		txtMantenimiento.setColumns(10);
		
		txtReporte = new JTextField();
		txtReporte.setBorder(null);
		txtReporte.setHorizontalAlignment(SwingConstants.CENTER);
		txtReporte.setBackground(new Color(72, 209, 204));
		txtReporte.setText("REPORTE");
		txtReporte.setForeground(new Color(0, 51, 102));
		txtReporte.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtReporte.setEditable(false);
		txtReporte.setColumns(10);
		txtReporte.setBounds(344, 215, 130, 37);
		contentPane.add(txtReporte);
		
		txtConsulta = new JTextField();
		txtConsulta.setBorder(null);
		txtConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		txtConsulta.setText("CONSULTA");
		txtConsulta.setForeground(new Color(0, 51, 102));
		txtConsulta.setBackground(new Color(72, 209, 204));
		txtConsulta.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtConsulta.setEditable(false);
		txtConsulta.setColumns(10);
		txtConsulta.setBounds(0, 215, 122, 37);
		contentPane.add(txtConsulta);
		
		txtRegistro = new JTextField();
		txtRegistro.setBorder(null);
		txtRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegistro.setBackground(new Color(72, 209, 204));
		txtRegistro.setText("REGISTRO");
		txtRegistro.setForeground(new Color(0, 51, 102));
		txtRegistro.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtRegistro.setEditable(false);
		txtRegistro.setColumns(10);
		txtRegistro.setBounds(344, 125, 130, 36);
		contentPane.add(txtRegistro);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(menuPrincipal.class.getResource("/iconos/fondo2.jpg")));
		lblNewLabel.setBounds(0, 72, 474, 254);
		contentPane.add(lblNewLabel);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
		if (e.getSource() == btnConsulta) {
			actionPerformedBtnConsulta(e);
		}
		if (e.getSource() == btnRegistro) {
			actionPerformedBtnRegistro(e);
		}
		if (e.getSource() == btnMantenimiento) {
			actionPerformedBtnMantenimiento(e);
		}
	}

	protected void actionPerformedBtnMantenimiento(ActionEvent e) {
		
		// Abriendo mantenimiento
		mantenimiento verMantenimiento = new mantenimiento();
		verMantenimiento.setVisible(true);
		// Centrar la ventana mantenimiento
		verMantenimiento.setLocationRelativeTo(null);
		dispose();
		
	}
	protected void actionPerformedBtnRegistro(ActionEvent e) {
		// Abriendo Registro
		registro verReg = new registro();
		verReg.setVisible(true);
		verReg.setLocationRelativeTo(null);
		dispose();
		
	}
	protected void actionPerformedBtnConsulta(ActionEvent e) {
				consulta verConsulta = new consulta();
				verConsulta.setVisible(true);
				verConsulta.setLocationRelativeTo(null);
				dispose();
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		reporte verReporte = new reporte ();
		verReporte.setVisible (true);
		verReporte.setLocationRelativeTo(null);
		dispose();
		}
}





