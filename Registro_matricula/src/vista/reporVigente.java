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
import entidades.Alumno;

public class reporVigente extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnConsultar;
	private JButton btnVolver;
	private JButton btnInicio;
	private JLabel lblAlumnosConMatrcula;
	private JScrollPane scrollPane;
	private JTable tblMatriVigente;

	//Modelo de la tabla
		private DefaultTableModel modelo = new DefaultTableModel();
		//objetos para los arreglos
		ArregloAlumno arAlumno = new ArregloAlumno();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reporVigente frame = new reporVigente();
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
	public reporVigente() {
		setResizable(false);
		setTitle("Reporte- Alumnos con matrícula vigente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(243, 226, 200));
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBorder(null);
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConsultar.setBounds(427, 219, 89, 23);
		contentPane.add(btnConsultar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBorder(null);
		btnVolver.addActionListener(this);
		btnVolver.setBounds(10, 219, 89, 23);
		contentPane.add(btnVolver);
		
		btnInicio = new JButton("Inicio");
		btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnInicio.setBorder(null);
		btnInicio.setBackground(Color.WHITE);
		btnInicio.addActionListener(this);
		btnInicio.setBounds(109, 219, 89, 23);
		contentPane.add(btnInicio);
		
		lblAlumnosConMatrcula = new JLabel("ALUMNOS CON MATRÍCULA VIGENTE");
		lblAlumnosConMatrcula.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumnosConMatrcula.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblAlumnosConMatrcula.setBounds(113, 16, 305, 24);
		contentPane.add(lblAlumnosConMatrcula);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 506, 150);
		contentPane.add(scrollPane);
		
		tblMatriVigente = new JTable();
		tblMatriVigente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMatriVigente);
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("DNI");
		modelo.addColumn("Edad");
		modelo.addColumn("Celular");
		modelo.addColumn("Estado");
		tblMatriVigente.setModel(modelo);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnVolver) {
			actionPerformedBtnVolver(e);
		}
		if (e.getSource() == btnInicio) {
			actionPerformedBtnInicio(e);
		}
	}
	
	protected void actionPerformedBtnInicio(ActionEvent e) {
		//volviendo al menu principal
		menuPrincipal verMenu = new menuPrincipal();
		verMenu.setVisible(true);
		verMenu.setLocationRelativeTo(null);
		dispose();
	}
	protected void actionPerformedBtnVolver(ActionEvent e) {

		//abriendo el menu reporte
				reporte verReporte = new reporte();
				verReporte.setVisible(true);
				verReporte.setLocationRelativeTo(null);
				dispose();
	}

	protected void actionPerformedBtnConsultar(ActionEvent e) {
		modelo.setRowCount(0);
		for(int i=0; i< arAlumno.tamanoListaAlumnos(); i++){
			Alumno a = arAlumno.getAlumno(i);
			if(a.getEstado()==1){
				Object fila[] = {a.getCodAlumno(),
						 a.getNombres(),
						 a.getApellidos(),
						 a.getDni(),
						 a.getEdad(),
						 a.getCelular(),
						 a.estado()
				};
				modelo.addRow(fila);		
				
			}
		}
	}
}
