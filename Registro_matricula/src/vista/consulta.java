package vista;

import java.awt.Canvas;
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

public class consulta extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtras;
	private JButton btnAlumnos;
	private JButton btnMatriRet;
	private JTextField txtAlumnosYCursos;
	private JTextField txtMatrculasYRetiros;
	private JLabel lblNewLabel;
	private Canvas canvas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consulta frame = new consulta();
					frame.setVisible(true);
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
	public consulta() {
		setResizable(false);
		setTitle("Consulta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 279);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnAtras = new JButton("Volver");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtras.setToolTipText("Volver al Menú Principal");
		btnAtras.setBorder(null);
		btnAtras.setBounds(191, 201, 89, 23);
		btnAtras.setForeground(Color.DARK_GRAY);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.addActionListener(this);
		contentPane.setLayout(null);
		contentPane.add(btnAtras);
		
		btnMatriRet = new JButton("");
		btnMatriRet.setToolTipText("Matrículas y Retiros");
		btnMatriRet.setBounds(321, 90, 91, 69);
		contentPane.add(btnMatriRet);
		btnMatriRet.setBackground(Color.WHITE);
		btnMatriRet.setIcon(new ImageIcon(consulta.class.getResource("/iconos/ret.png")));
		btnMatriRet.addActionListener(this);
		btnMatriRet.setBorder(null);
		
		btnAlumnos = new JButton("");
		btnAlumnos.setToolTipText("Alumnos");
		btnAlumnos.setBounds(54, 90, 91, 69);
		contentPane.add(btnAlumnos);
		btnAlumnos.setBackground(Color.WHITE);
		btnAlumnos.setIcon(new ImageIcon(consulta.class.getResource("/iconos/matr.png")));
		btnAlumnos.addActionListener(this);
		btnAlumnos.setBorder(null);
		
		txtAlumnosYCursos = new JTextField();
		txtAlumnosYCursos.setText("ALUMNOS Y CURSOS");
		txtAlumnosYCursos.setHorizontalAlignment(SwingConstants.CENTER);
		txtAlumnosYCursos.setForeground(new Color(0, 51, 102));
		txtAlumnosYCursos.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtAlumnosYCursos.setEditable(false);
		txtAlumnosYCursos.setColumns(10);
		txtAlumnosYCursos.setBorder(null);
		txtAlumnosYCursos.setBackground(new Color(72, 209, 204));
		txtAlumnosYCursos.setBounds(0, 21, 208, 47);
		contentPane.add(txtAlumnosYCursos);
		
		txtMatrculasYRetiros = new JTextField();
		txtMatrculasYRetiros.setText("MATRÍCULAS Y RETIROS");
		txtMatrculasYRetiros.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatrculasYRetiros.setForeground(new Color(0, 51, 102));
		txtMatrculasYRetiros.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtMatrculasYRetiros.setEditable(false);
		txtMatrculasYRetiros.setColumns(10);
		txtMatrculasYRetiros.setBorder(null);
		txtMatrculasYRetiros.setBackground(new Color(72, 209, 204));
		txtMatrculasYRetiros.setBounds(252, 21, 208, 47);
		contentPane.add(txtMatrculasYRetiros);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(consulta.class.getResource("/iconos/fondo2.jpg")));
		lblNewLabel.setBounds(0, 0, 460, 250);
		contentPane.add(lblNewLabel);
		
		canvas = new Canvas();
		canvas.setBackground(Color.DARK_GRAY);
		canvas.setBounds(234, 90, 1, 69);
		contentPane.add(canvas);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMatriRet) {
			actionPerformedBtnMatriRet(e);
		}
		if (e.getSource() == btnAlumnos) {
			actionPerformedBtnAlumCur(e);
		}
		if (e.getSource() == btnAtras) {
			actionPerformedBtnAtras(e);
		}
	}
	protected void actionPerformedBtnAtras(ActionEvent e) {
				//Abriendo el Menu Principal
				menuPrincipal verMenu = new menuPrincipal();
				verMenu.setVisible(true);
				// Centrar el Menu Principal
				verMenu.setLocationRelativeTo(null);
				dispose();
	}
	protected void actionPerformedBtnAlumCur(ActionEvent e) {
				// Abriendo la ventana Alumnos 
				consultAlumCurs verAlumCurso = new consultAlumCurs();
				verAlumCurso.setVisible(true);
				// centrar la ventana Alumnos y cursos
				verAlumCurso.setLocationRelativeTo(null);
				dispose();
	}
	protected void actionPerformedBtnMatriRet(ActionEvent e) {
				// Abriendo la ventana Matriculas y retiros
				consultMatRet verMatriRet = new consultMatRet();
				verMatriRet.setVisible(true);
				// centrar la ventana Matriculas y retiros
				verMatriRet.setLocationRelativeTo(null);
				dispose();
	}
}
