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

public class reporPendiente extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnConsultar;
	private JButton btnVolver;
	private JScrollPane scrollPane;
	private JButton btnInicio;
	private JLabel lblAlumnosConMatrcula;
	private JTable tblMatriPendiente;

	
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
					reporPendiente frame = new reporPendiente();
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
	public reporPendiente() {
		setResizable(false);
		setTitle("Reporte- Alumnos con matrícula pendiente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 286);
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
		btnConsultar.setBounds(421, 214, 89, 23);
		contentPane.add(btnConsultar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBorder(null);
		btnVolver.addActionListener(this);
		btnVolver.setBounds(10, 214, 89, 23);
		contentPane.add(btnVolver);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 500, 147);
		contentPane.add(scrollPane);
		
		tblMatriPendiente = new JTable();
		tblMatriPendiente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMatriPendiente);
		
		btnInicio = new JButton("Inicio");
		btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnInicio.setBorder(null);
		btnInicio.setBackground(Color.WHITE);
		btnInicio.addActionListener(this);
		btnInicio.setBounds(109, 214, 89, 23);
		contentPane.add(btnInicio);
		
		lblAlumnosConMatrcula = new JLabel("ALUMNOS CON MATRÍCULA PENDIENTE");
		lblAlumnosConMatrcula.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumnosConMatrcula.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblAlumnosConMatrcula.setBounds(116, 21, 305, 24);
		contentPane.add(lblAlumnosConMatrcula);
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("DNI");
		modelo.addColumn("Edad");
		modelo.addColumn("Celular");
		modelo.addColumn("Estado");
		tblMatriPendiente.setModel(modelo);
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
		
		modelo.setRowCount(0);
		for(int i=0; i< arAlumno.tamanoListaAlumnos(); i++){
			Alumno a = arAlumno.getAlumno(i);
			if(a.getEstado()==0){
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
