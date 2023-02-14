package vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloAlumno;
import controlador.ArregloMatricula;
import entidades.Alumno;
import entidades.Matricula;
import modulo.Metodos;

public class regisAdicMatri extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAdicionarMatrcula;
	private JButton btnNuevaMatricula;
	private JButton btnAdicionarMatri;
	
			//Modelo de la tabla
			DefaultTableModel modelo = new  DefaultTableModel();
			//Creamos objetos para las clases que usaremos.
			ArregloMatricula arMatricula = new ArregloMatricula();
			ArregloAlumno arAlumno= new ArregloAlumno();	
			
	/**
	 * Launch the application.
	 */
	
	private JLabel lblFecha;
	private JLabel lblHora;
	private JTextField txtCodMatricula;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JPanel panel;
	private JLabel lblCodAlumno;
	private JLabel lblNombre;
	public static JTextField txtCodAlumno;
	public static JTextField txtNombreAlumno;
	private JLabel lblApellidos;
	public static JTextField txtApellidos;
	private JButton btnBuscarAlumno;
	private JLabel lblCodCurso;
	private JLabel lblAsignatura;
	public static JTextField txtCurso;
	public static JTextField txtAsignatura;
	private JButton btnBuscarCurso;
	private JScrollPane scrollPane;
	private JTable tblMatricula;
	private Canvas canvas;
	private JButton btnVolver;
	private JButton btnInicio;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regisAdicMatri frame = new regisAdicMatri();
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
	public regisAdicMatri() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Adicionar | Matricula | Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 577);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(200, 232, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAdicionarMatrcula = new JLabel("ADICIONAR MATRÍCULA");
		lblAdicionarMatrcula.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarMatrcula.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblAdicionarMatrcula.setBounds(159, 11, 248, 35);
		contentPane.add(lblAdicionarMatrcula);
		
		
		
		btnNuevaMatricula = new JButton("Nuevo");
		btnNuevaMatricula.setForeground(Color.DARK_GRAY);
		btnNuevaMatricula.setBackground(Color.WHITE);
		btnNuevaMatricula.addActionListener(this);
		btnNuevaMatricula.setToolTipText("Registrar nuevo alumno");
		btnNuevaMatricula.setBounds(344, 66, 89, 25);
		contentPane.add(btnNuevaMatricula);
		
		btnAdicionarMatri = new JButton("Adicionar");
		btnAdicionarMatri.setForeground(Color.DARK_GRAY);
		btnAdicionarMatri.setBackground(Color.WHITE);
		btnAdicionarMatri.addActionListener(this);
		btnAdicionarMatri.setToolTipText("Registrar alumno");
		btnAdicionarMatri.setBounds(443, 66, 89, 25);
		contentPane.add(btnAdicionarMatri);
		
		JLabel lblCodMatricula = new JLabel("Cod. Matrícula:");
		lblCodMatricula.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodMatricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodMatricula.setBounds(31, 68, 101, 18);
		contentPane.add(lblCodMatricula);
		
		txtCodMatricula = new JTextField();
		txtCodMatricula.setEditable(false);
		txtCodMatricula.setColumns(10);
		txtCodMatricula.setBounds(142, 68, 101, 21);
		contentPane.add(txtCodMatricula);
		
		panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPLETAR DATOS:", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		panel.setBounds(22, 102, 510, 190);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblCodAlumno = new JLabel("Cod. Alumno:");
		lblCodAlumno.setForeground(SystemColor.inactiveCaptionText);
		lblCodAlumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodAlumno.setBounds(10, 92, 90, 15);
		panel.add(lblCodAlumno);
		
		lblNombre = new JLabel("Nombres:");
		lblNombre.setForeground(SystemColor.inactiveCaptionText);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(10, 120, 60, 15);
		panel.add(lblNombre);
		
		txtCodAlumno = new JTextField();
		txtCodAlumno.setEditable(false);
		txtCodAlumno.setColumns(10);
		txtCodAlumno.setBounds(99, 90, 90, 20);
		panel.add(txtCodAlumno);
		
		txtNombreAlumno = new JTextField();
		txtNombreAlumno.setEditable(false);
		txtNombreAlumno.setColumns(10);
		txtNombreAlumno.setBounds(98, 118, 120, 20);
		panel.add(txtNombreAlumno);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(SystemColor.inactiveCaptionText);
		lblApellidos.setBackground(new Color(255, 255, 255));
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellidos.setBounds(10, 148, 68, 15);
		panel.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(98, 146, 120, 20);
		panel.add(txtApellidos);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(SystemColor.inactiveCaptionText);
		lblFecha.setBounds(10, 41, 36, 15);
		panel.add(lblFecha);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtFecha = new JTextField();
		txtFecha.setText("23/06/2021");
		txtFecha.setEditable(false);
		txtFecha.setBounds(99, 39, 75, 20);
		panel.add(txtFecha);
		txtFecha.setColumns(10);
		
		
		lblHora = new JLabel("Hora:");
		lblHora.setForeground(SystemColor.inactiveCaptionText);
		lblHora.setBackground(new Color(255, 255, 255));
		lblHora.setBounds(258, 41, 46, 14);
		panel.add(lblHora);
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setBounds(346, 39, 60, 20);
		panel.add(txtHora);
		txtHora.setColumns(10);
		
		btnBuscarAlumno = new JButton("");
		btnBuscarAlumno.setBackground(new Color(255, 255, 255));
		btnBuscarAlumno.addActionListener(this);
		btnBuscarAlumno.setIcon(new ImageIcon(regisAdicMatri.class.getResource("/iconos/lupa2.png")));
		btnBuscarAlumno.setBounds(199, 82, 28, 28);
		panel.add(btnBuscarAlumno);
		
		lblCodCurso = new JLabel("Cod. Curso:");
		lblCodCurso.setForeground(SystemColor.inactiveCaptionText);
		lblCodCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodCurso.setBounds(258, 89, 90, 15);
		panel.add(lblCodCurso);
		
		lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setForeground(SystemColor.inactiveCaptionText);
		lblAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAsignatura.setBounds(258, 115, 83, 15);
		panel.add(lblAsignatura);
		
		txtCurso = new JTextField();
		txtCurso.setEditable(false);
		txtCurso.setColumns(10);
		txtCurso.setBounds(346, 87, 90, 20);
		panel.add(txtCurso);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setEditable(false);
		txtAsignatura.setColumns(10);
		txtAsignatura.setBounds(346, 115, 147, 20);
		panel.add(txtAsignatura);
		
		btnBuscarCurso = new JButton("");
		btnBuscarCurso.setBackground(new Color(255, 255, 255));
		btnBuscarCurso.addActionListener(this);
		btnBuscarCurso.setIcon(new ImageIcon(regisAdicMatri.class.getResource("/iconos/lupa2.png")));
		btnBuscarCurso.setBounds(447, 79, 28, 28);
		panel.add(btnBuscarCurso);
		
		canvas = new Canvas();
		canvas.setBackground(Color.DARK_GRAY);
		canvas.setBounds(244, 82, 1, 81);
		panel.add(canvas);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 324, 510, 156);
		contentPane.add(scrollPane);
		
		tblMatricula = new JTable();
		tblMatricula.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMatricula);
		
		//columnas para la tabla
		modelo.addColumn("Matricula");
		modelo.addColumn("Cod.Alumno");
		modelo.addColumn("Cod.Curso");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		
		//Asignar el modelo a la tabla
		tblMatricula.setModel(modelo);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setForeground(Color.DARK_GRAY);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(22, 502, 89, 23);
		contentPane.add(btnVolver);
		
		btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(this);
		btnInicio.setBackground(Color.WHITE);
		btnInicio.setForeground(Color.DARK_GRAY);
		btnInicio.setBounds(124, 502, 89, 23);
		contentPane.add(btnInicio);
		
		listarMatriculas();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInicio) {
			actionPerformedBtnInicio(e);
		}
		if (e.getSource() == btnVolver) {
			actionPerformedBtnVolver(e);
		}
		if (e.getSource() == btnBuscarCurso) {
			actionPerformedBtnBuscarCurso(e);
		}
		if (e.getSource() == btnBuscarAlumno) {
			actionPerformedBtnBuscarAlumno(e);
		}
		if (e.getSource() == btnAdicionarMatri) {
			actionPerformedBtnAdicionarMatri(e);
		}
		if (e.getSource() == btnNuevaMatricula) {
			actionPerformedBtnNuevaMatricula(e);
		}
		
	}
	protected void actionPerformedBtnVolver(ActionEvent e) {
		//Abriendo el Menu registro
				registro verRegistro = new registro();
				verRegistro.setVisible(true);
				//centrar el menu consulta
				verRegistro.setLocationRelativeTo(null);
				dispose();
	}
	protected void actionPerformedBtnInicio(ActionEvent e) {
		//volver al menuPrincipal
				menuPrincipal verMenu = new menuPrincipal();
				verMenu.setVisible(true);
				verMenu.setLocationRelativeTo(null);
				dispose();
	}
	protected void actionPerformedBtnBuscarAlumno(ActionEvent e) {
		DlgBuscarAlumno buscarAlumno = new DlgBuscarAlumno();
		buscarAlumno.setLocationRelativeTo(this);
		buscarAlumno.setVisible(true);
	}
	protected void actionPerformedBtnBuscarCurso(ActionEvent e) {
		DlgBuscarCurso buscarCurso = new DlgBuscarCurso();
		buscarCurso.setLocationRelativeTo(this);
		buscarCurso.setVisible(true);
	}
	
	private void actionPerformedBtnNuevaMatricula(ActionEvent e) {
		Metodos.limpiarCuadrosTxt(txtAsignatura, txtNombreAlumno, txtCurso, txtCodAlumno, txtApellidos);
		txtCodMatricula.setText("" + arMatricula.generarCodigo());
	}
	protected void actionPerformedBtnAdicionarMatri(ActionEvent e) {
		try {
			adicionarMatricula();	
		}
		catch (Exception e2) {
			Metodos.mensajeError("Debe considerar lo siguiente: \n1. Seleccionar el boton Nuevo.\n2. Seleccionar un alumno.\n3. Seleccionar un curso.", "Error en solicitud");
		}
		
	}

	private void adicionarMatricula() {
				Alumno a = arAlumno.buscarAlumno(Metodos.getEntero(txtCodAlumno));
				Matricula m	= arMatricula.buscarAlumno(Metodos.getEntero(txtCodAlumno));
								
				if(m==null){
					//Declaramos las variables y obtenemos los datos en ellas.
					String codigoMatricula	= txtCodMatricula.getText();
					String codigoCurso		= txtCurso.getText();
					String codigoAlumno	=txtCodAlumno.getText();
					String fecha		= Metodos.getTexto(txtFecha);
					String hora			= new SimpleDateFormat("hh:mm:ss").format(new Date());
					int i = JOptionPane.showConfirmDialog(this, "¿Está seguro de crear la matrícula?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (i == 0) {	
						Matricula matri = new Matricula(Integer.parseInt(codigoMatricula),Integer.parseInt(codigoAlumno),
								Integer.parseInt(codigoCurso),fecha,hora);
						arMatricula.addMatriculas(matri);
						a.setEstado(1);
						arMatricula.exportarMatriculas();
						listarMatriculas();
						arAlumno.exportarAlumno();
						JOptionPane.showMessageDialog(this, "La matricula ha sido creado exitosamente!", "Guardado Exitoso!", JOptionPane.INFORMATION_MESSAGE, null);
					}
				}
				else{
					Metodos.mensajeError("El alumno ya fue matriculado", "Alerta!");
				}
	}
	void listarMatriculas() {
		modelo.setRowCount(0);			
		for (int i = 0; i < arMatricula.tamanoListaMatriculas(); i++) {
			Matricula ma= arMatricula.getMatriculas(i); 
			Object data [] = {
							ma.getNumMatricula(),
							ma.getCodAlumno(),
							ma.getCodCurso(),
							ma.getFecha(),
							ma.getHora()
			};
			modelo.addRow(data);
		}
		
	}
	
	
}

