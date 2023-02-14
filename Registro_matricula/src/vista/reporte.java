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

	public class reporte extends JFrame implements ActionListener {
	
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtras;
	private JButton btnVigente;
	private JButton btnCurso;
	private JButton btnPendiente;
	private JTextField txtAlumnosConMatrcula;
	private JTextField txtAlumnosConMatrcula_1;
	private JTextField txtAlumnosMatriculadosPor;
	private JLabel lblNewLabel;

		 /**
		* Launch the application.
		*/
		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
		try {
		reporte frame = new reporte();
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
		public reporte() {
		 	setResizable(false);
		setTitle("Reporte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(200, 232, 242));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAtras = new JButton("Volver");
		btnAtras.setToolTipText("Volver al Menú Principal");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtras.setBorder(null);
		btnAtras.setForeground(Color.DARK_GRAY);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.addActionListener(this);
		btnAtras.setBounds(162, 316, 98, 23);
		contentPane.add(btnAtras);
		
		btnVigente = new JButton("");
		btnVigente.setToolTipText("Matrícula Vigente");
		btnVigente.setBorder(null);
		btnVigente.setBackground(Color.WHITE);
		btnVigente.setIcon(new ImageIcon(reporte.class.getResource("/iconos/flecha-izquierda.png")));
		btnVigente.addActionListener(this);
		btnVigente.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnVigente.setBounds(307, 123, 83, 62);
		contentPane.add(btnVigente);
		
		btnCurso = new JButton("");
		btnCurso.setToolTipText("Matriculados por Curso");
		btnCurso.setBorder(null);
		btnCurso.setBackground(Color.WHITE);
		btnCurso.setIcon(new ImageIcon(reporte.class.getResource("/iconos/biblioteca.png")));
		btnCurso.addActionListener(this);
		btnCurso.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnCurso.setBounds(307, 213, 83, 62);
		contentPane.add(btnCurso);
		
		btnPendiente = new JButton("");
		btnPendiente.setToolTipText("Matrícula Pendiente");
		btnPendiente.setBackground(Color.WHITE);
		btnPendiente.setBorder(null);
		btnPendiente.setIcon(new ImageIcon(reporte.class.getResource("/iconos/pendiente.png")));
		btnPendiente.addActionListener(this);
		btnPendiente.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnPendiente.setBounds(307, 31, 83, 62);
		contentPane.add(btnPendiente);
		
		txtAlumnosConMatrcula = new JTextField();
		txtAlumnosConMatrcula.setText("ALUMNOS CON MATRÍCULA PENDIENTE");
		txtAlumnosConMatrcula.setHorizontalAlignment(SwingConstants.CENTER);
		txtAlumnosConMatrcula.setForeground(new Color(0, 51, 102));
		txtAlumnosConMatrcula.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtAlumnosConMatrcula.setEditable(false);
		txtAlumnosConMatrcula.setColumns(10);
		txtAlumnosConMatrcula.setBorder(null);
		txtAlumnosConMatrcula.setBackground(new Color(72, 209, 204));
		txtAlumnosConMatrcula.setBounds(10, 42, 267, 47);
		contentPane.add(txtAlumnosConMatrcula);
		
		txtAlumnosConMatrcula_1 = new JTextField();
		txtAlumnosConMatrcula_1.setText("ALUMNOS CON MATRÍCULA VIGENTE");
		txtAlumnosConMatrcula_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtAlumnosConMatrcula_1.setForeground(new Color(0, 51, 102));
		txtAlumnosConMatrcula_1.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtAlumnosConMatrcula_1.setEditable(false);
		txtAlumnosConMatrcula_1.setColumns(10);
		txtAlumnosConMatrcula_1.setBorder(null);
		txtAlumnosConMatrcula_1.setBackground(new Color(72, 209, 204));
		txtAlumnosConMatrcula_1.setBounds(10, 134, 267, 47);
		contentPane.add(txtAlumnosConMatrcula_1);
		
		txtAlumnosMatriculadosPor = new JTextField();
		txtAlumnosMatriculadosPor.setText("ALUMNOS MATRICULADOS POR CURSO");
		txtAlumnosMatriculadosPor.setHorizontalAlignment(SwingConstants.CENTER);
		txtAlumnosMatriculadosPor.setForeground(new Color(0, 51, 102));
		txtAlumnosMatriculadosPor.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtAlumnosMatriculadosPor.setEditable(false);
		txtAlumnosMatriculadosPor.setColumns(10);
		txtAlumnosMatriculadosPor.setBorder(null);
		txtAlumnosMatriculadosPor.setBackground(new Color(72, 209, 204));
		txtAlumnosMatriculadosPor.setBounds(10, 225, 267, 47);
		contentPane.add(txtAlumnosMatriculadosPor);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(reporte.class.getResource("/iconos/fondo2.jpg")));
		lblNewLabel.setBounds(0, 0, 412, 363);
		contentPane.add(lblNewLabel);
		}
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnPendiente) {
				actionPerformedBtnPendiente(e);
			}
			if (e.getSource() == btnCurso) {
				actionPerformedBtnCurso(e);
			}
			if (e.getSource() == btnVigente) {
				actionPerformedBtnVigente(e);
			}
			
			if (e.getSource() == btnAtras) {
				actionPerformedBtnRegresar(e);
			}
		}
		protected void actionPerformedBtnRegresar(ActionEvent e) {
		menuPrincipal verMenu = new menuPrincipal();
		verMenu.setVisible(true);
		verMenu.setLocationRelativeTo(null);
		dispose();
			}
		
		protected void actionPerformedBtnVigente(ActionEvent e) {
			// Abriendo la ventana vigente
			reporVigente verVigente = new reporVigente();
			verVigente.setVisible(true);
			// centrar la ventana 
			verVigente.setLocationRelativeTo(null);
			dispose();
		}
		protected void actionPerformedBtnCurso(ActionEvent e) {
			// Abriendo la ventana Curso
			reporCurso verCurso = new reporCurso();
			verCurso.setVisible(true);
			// centrar la ventana 
			verCurso.setLocationRelativeTo(null);
			dispose();
		}
		protected void actionPerformedBtnPendiente(ActionEvent e) {
			// Abriendo la ventana Pendiente
			reporPendiente verPendiente = new reporPendiente();
			verPendiente.setVisible(true);
			// centrar la ventana 
			verPendiente.setLocationRelativeTo(null);
			dispose();
		}
	}
