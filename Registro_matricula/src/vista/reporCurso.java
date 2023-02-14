package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloAlumno;
import controlador.ArregloCurso;
import controlador.ArregloMatricula;
import entidades.Alumno;
import entidades.Curso;
import entidades.Matricula;

public class reporCurso extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnConsultar;
	private JButton btnVolver;
	private JButton btnInicio;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable tblMatriCurso;

	//Modelo de la tabla
	private DefaultTableModel modelo = new DefaultTableModel();
	//objetos para los arreglos
	ArregloAlumno arAlumno = new ArregloAlumno();
	ArregloMatricula arMatricula = new ArregloMatricula();
	ArregloCurso arCurso = new ArregloCurso();
/**
 * Launch the application.
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reporCurso frame = new reporCurso();
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
	public reporCurso() {
		setResizable(false);
		setTitle("Reporte- Alumnos matriculados por curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(200, 232, 242));
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConsultar.setBorder(null);
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setBounds(472, 270, 89, 23);
		contentPane.add(btnConsultar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBorder(null);
		btnVolver.addActionListener(this);
		btnVolver.setBounds(10, 270, 89, 23);
		contentPane.add(btnVolver);
		
		btnInicio = new JButton("Inicio");
		btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnInicio.setBorder(null);
		btnInicio.setBackground(Color.WHITE);
		btnInicio.addActionListener(this);
		btnInicio.setBounds(114, 270, 89, 23);
		contentPane.add(btnInicio);
		
		lblNewLabel = new JLabel("ALUMNOS MATRICULADOS POR CURSO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel.setBounds(137, 21, 305, 24);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 551, 190);
		contentPane.add(scrollPane);
		
		tblMatriCurso = new JTable();
		tblMatriCurso.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMatriCurso);
		
		modelo.addColumn("Matricula");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Cod.Curso");
		modelo.addColumn("Asignatura");
		modelo.addColumn("Ciclo");
		tblMatriCurso.setModel(modelo);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnInicio) {
			actionPerformedBtnInicio(e);
		}
		if (e.getSource() == btnVolver) {
			actionPerformedBtnVolver(e);
		}
	}
	protected void actionPerformedBtnVolver(ActionEvent e) {
		//abriendo el menu reporte
				reporte verReporte = new reporte();
				verReporte.setVisible(true);
				verReporte.setLocationRelativeTo(null);
				dispose();
	}
	protected void actionPerformedBtnInicio(ActionEvent e) {
		//volviendo al menu principal
		menuPrincipal verMenu = new menuPrincipal();
		verMenu.setVisible(true);
		verMenu.setLocationRelativeTo(null);
		dispose();
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		Matricula m;
		Alumno a;
		Curso c;
		
		modelo.setRowCount(0);
		//Recorrer la lista de las matrículas
		for (int i = 0; i < arMatricula.tamanoListaMatriculas(); i++) {
			// almacenar  el objeto matricula en una variable
			 m= arMatricula.getMatriculas(i); 
			 a= arAlumno.buscarAlumno(m.getCodAlumno());
			 c= arCurso.buscarCurso(m.getCodCurso());
			Object data [] = {
							m.getNumMatricula(),
							a.getNombres(),
							a.getApellidos(),
							c.getCodCurso(),
							c.getAsignatura(),
							c.getCiclo()							
			};
			
			modelo.addRow(data);
		}	
	}		
}
