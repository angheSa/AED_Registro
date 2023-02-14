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

public class mantenimiento extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Canvas canvas;
	private JButton btnAdicAlumno;
	private JButton btnEditAlumno;
	private JButton btnAdicCurso;
	private JButton btnEditCurso;
	private JButton btnMantAtras;
	private JTextField txtMantAlum;
	private JTextField txtMantCur;
	private JTextField txtMantAdi;
	private JTextField txtMantEdi;
	private Canvas canvas_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mantenimiento frame = new mantenimiento();
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
	public mantenimiento() {
		setResizable(false);
		setTitle("Mantenimiento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 369);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		canvas = new Canvas();
		canvas.setBackground(Color.GRAY);
		canvas.setBounds(205, 227, 1, 47);
		contentPane.add(canvas);
		
		btnAdicAlumno = new JButton("");
		btnAdicAlumno.setBackground(Color.WHITE);
		btnAdicAlumno.setIcon(new ImageIcon(mantenimiento.class.getResource("/iconos/aume.png")));
		btnAdicAlumno.setToolTipText("Agregar Alumno");
		btnAdicAlumno.addActionListener(this);
		btnAdicAlumno.setBounds(62, 99, 89, 71);
		btnAdicAlumno.setBorder(null);
		contentPane.add(btnAdicAlumno);
		
		btnEditAlumno = new JButton("");
		btnEditAlumno.setBackground(Color.WHITE);
		btnEditAlumno.setIcon(new ImageIcon(mantenimiento.class.getResource("/iconos/ed.png")));
		btnEditAlumno.setToolTipText("Editar Alumno");
		btnEditAlumno.addActionListener(this);
		btnEditAlumno.setBounds(62, 217, 89, 71);
		btnEditAlumno.setBorder(null);
		contentPane.add(btnEditAlumno);
		
		btnAdicCurso = new JButton("");
		btnAdicCurso.setBackground(Color.WHITE);
		btnAdicCurso.setIcon(new ImageIcon(mantenimiento.class.getResource("/iconos/aume.png")));
		btnAdicCurso.setToolTipText("Adicionar Curso");
		btnAdicCurso.addActionListener(this);
		btnAdicCurso.setBounds(259, 99, 89, 71);
		btnAdicCurso.setBorder(null);
		contentPane.add(btnAdicCurso);
		
		btnEditCurso = new JButton("");
		btnEditCurso.setBackground(Color.WHITE);
		btnEditCurso.setIcon(new ImageIcon(mantenimiento.class.getResource("/iconos/ed.png")));
		btnEditCurso.setToolTipText("Editar Curso");
		btnEditCurso.addActionListener(this);
		btnEditCurso.setBounds(259, 217, 89, 71);
		btnEditCurso.setBorder(null);
		contentPane.add(btnEditCurso);
		
		btnMantAtras = new JButton("Volver");
		btnMantAtras.setForeground(Color.DARK_GRAY);
		btnMantAtras.setBorder(null);
		btnMantAtras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMantAtras.setBackground(Color.WHITE);
		btnMantAtras.setToolTipText("Ir a Menu Principal");
		btnMantAtras.addActionListener(this);
		btnMantAtras.setBounds(161, 294, 89, 23);
		contentPane.add(btnMantAtras);
		
		txtMantAlum = new JTextField();
		txtMantAlum.setText("ALUMNOS");
		txtMantAlum.setHorizontalAlignment(SwingConstants.CENTER);
		txtMantAlum.setForeground(new Color(0, 51, 102));
		txtMantAlum.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtMantAlum.setEditable(false);
		txtMantAlum.setColumns(10);
		txtMantAlum.setBorder(null);
		txtMantAlum.setBackground(new Color(72, 209, 204));
		txtMantAlum.setBounds(25, 10, 167, 47);
		contentPane.add(txtMantAlum);
		
		txtMantCur = new JTextField();
		txtMantCur.setText("CURSOS");
		txtMantCur.setHorizontalAlignment(SwingConstants.CENTER);
		txtMantCur.setForeground(new Color(0, 51, 102));
		txtMantCur.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtMantCur.setEditable(false);
		txtMantCur.setColumns(10);
		txtMantCur.setBorder(null);
		txtMantCur.setBackground(new Color(72, 209, 204));
		txtMantCur.setBounds(221, 10, 149, 47);
		contentPane.add(txtMantCur);
		
		txtMantAdi = new JTextField();
		txtMantAdi.setText("Adicionar");
		txtMantAdi.setHorizontalAlignment(SwingConstants.CENTER);
		txtMantAdi.setForeground(new Color(0, 51, 102));
		txtMantAdi.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtMantAdi.setEditable(false);
		txtMantAdi.setColumns(10);
		txtMantAdi.setBorder(null);
		txtMantAdi.setBackground(new Color(72, 209, 204));
		txtMantAdi.setBounds(131, 72, 132, 23);
		contentPane.add(txtMantAdi);
		
		txtMantEdi = new JTextField();
		txtMantEdi.setText("Editar");
		txtMantEdi.setHorizontalAlignment(SwingConstants.CENTER);
		txtMantEdi.setForeground(new Color(0, 51, 102));
		txtMantEdi.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtMantEdi.setEditable(false);
		txtMantEdi.setColumns(10);
		txtMantEdi.setBorder(null);
		txtMantEdi.setBackground(new Color(72, 209, 204));
		txtMantEdi.setBounds(131, 181, 132, 23);
		contentPane.add(txtMantEdi);
		
		canvas_1 = new Canvas();
		canvas_1.setBackground(Color.GRAY);
		canvas_1.setBounds(205, 114, 1, 47);
		contentPane.add(canvas_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(mantenimiento.class.getResource("/iconos/fondo2.jpg")));
		lblNewLabel.setBounds(0, 0, 392, 340);
		contentPane.add(lblNewLabel);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMantAtras) {
			actionPerformedBtnMantAtras(e);
		}
		if (e.getSource() == btnEditCurso) {
			actionPerformedBtnEditCurso(e);
		}
		if (e.getSource() == btnAdicCurso) {
			actionPerformedBtnAdicCurso(e);
		}
		if (e.getSource() == btnEditAlumno) {
			actionPerformedBtnEditAlumno(e);
		}
		if (e.getSource() == btnAdicAlumno) {
			actionPerformedBtnAdicAlumno(e);
		}
	}
	protected void actionPerformedBtnAdicAlumno(ActionEvent e) {
		
		// Abriendo Adicionar Alumno
		mantAdicAlumno verAdicAlumno = new mantAdicAlumno();
		verAdicAlumno.setVisible(true);
		// Centrando la ventana de Adicionar Alumno
		verAdicAlumno.setLocationRelativeTo(null);
		dispose();				
	}
	protected void actionPerformedBtnEditAlumno(ActionEvent e) {
		
		// Abriendo la ventana editar Alumno
		mantEditAlumno verEditAlumno = new mantEditAlumno();
		verEditAlumno.setVisible(true);
		// centrar la ventana Editar Alumno
		verEditAlumno.setLocationRelativeTo(null);
		dispose();
	}
	protected void actionPerformedBtnAdicCurso(ActionEvent e) {
		
		//Abriendo la ventna Adicionar Curso
		mantAdicCurso verAdicCurso = new mantAdicCurso();
		verAdicCurso.setVisible(true);
		verAdicCurso.setLocationRelativeTo(null);
		dispose();
	}
	protected void actionPerformedBtnEditCurso(ActionEvent e) {
		
		// Abriendo la ventana editar curso
		mantEditCurso verEditCurso = new mantEditCurso();
		verEditCurso.setVisible(true);
		verEditCurso.setLocationRelativeTo(null);
		dispose();
	}
	protected void actionPerformedBtnMantAtras(ActionEvent e) {
		
		//Abriendo el Menu Principal
		menuPrincipal verMenu = new menuPrincipal();
		verMenu.setVisible(true);
		// Centrar el Menu Principal
		verMenu.setLocationRelativeTo(null);
		dispose();
	}
}
