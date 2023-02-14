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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloAlumno;
import controlador.ArregloCurso;
import controlador.ArregloMatricula;
import controlador.ArregloRetiro;
import entidades.Alumno;
import entidades.Curso;
import entidades.Matricula;
import entidades.Retiro;
import modulo.Metodos;

public class consultMatRet extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtConsultaDos;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JButton btnAtras;
	private JButton btnInicio;
	//modelo de la tabla
		DefaultTableModel modelo = new  DefaultTableModel();
		private JPanel panel;
		private JLabel lblCdigoAlumno;
		private JTextField txtCodiAlumno;
		private JLabel lblNombres;
		private JTextField txtNombres;
		private JLabel lblApellidos;
		private JTextField txtApellidos;
		private JTextField txtDni;
		private JLabel lblDni;
		private JLabel lblNewLabel;
		private JTextField txtEdad;
		private JTextField txtEstado;
		private JLabel lblEstado;
		private JTextField txtCelular;
		private JLabel lblCelular;
		private JPanel panel_1;
		private JLabel lblCodAlum;
		private JTextField txtCodiCurso;
		private JLabel lblAsignatura;
		private JTextField txtAsignatura;
		private JLabel lblCiclo;
		private JTextField txtCiclo;
		private JLabel lblCreditos;
		private JTextField txtCreditos;
		private JLabel lblHoras;
		private JTextField txtHoras;

	/**
	 * Launch the application.
	 */
		//Crear objetos para los arreglos
		ArregloAlumno arAlumno = new ArregloAlumno();	
		ArregloCurso arCurso = new ArregloCurso();
		ArregloMatricula arMatricula = new ArregloMatricula();
		ArregloRetiro arRetiro = new ArregloRetiro();
		private JLabel lblNMatrcula;
		private JLabel lblNRetiro;
		private JTextField txtConsultaTres;
		private JButton btnProcesarRetiro;
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultMatRet frame = new consultMatRet();
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
	@SuppressWarnings({ })
	public consultMatRet() {
		setForeground(new Color(51, 102, 255));
		setResizable(false);
		setTitle("Consulta de matriculas y retiros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(243, 226, 200));
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtConsultaDos = new JTextField();
		txtConsultaDos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtConsultaDos.setBounds(138, 11, 99, 23);
		contentPane.add(txtConsultaDos);
		txtConsultaDos.setColumns(10);
		
		btnProcesar = new JButton("Consultar Matricula");
		btnProcesar.addActionListener(this);
		btnProcesar.setBorder(null);
		btnProcesar.setBackground(Color.WHITE);
		btnProcesar.setForeground(new Color(102, 102, 102));
		btnProcesar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnProcesar.setBounds(343, 11, 158, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBorder(null);
		btnBorrar.setBackground(Color.WHITE);
		btnBorrar.setForeground(new Color(102, 102, 102));
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBorrar.setBounds(401, 389, 100, 23);
		contentPane.add(btnBorrar);
		
		btnAtras = new JButton("Volver");
		btnAtras.setBorder(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setForeground(Color.DARK_GRAY);
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtras.addActionListener(this);
		btnAtras.setBounds(10, 389, 89, 23);
		contentPane.add(btnAtras);
		
		btnInicio = new JButton("Inicio");
		btnInicio.setBorder(null);
		btnInicio.setBackground(Color.WHITE);
		btnInicio.setForeground(Color.DARK_GRAY);
		btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnInicio.addActionListener(this);
		btnInicio.setBounds(119, 389, 89, 23);
		contentPane.add(btnInicio);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "DATOS DEL ALUMNO", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, Color.DARK_GRAY));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 74, 491, 146);
		contentPane.add(panel);
		
		lblCdigoAlumno = new JLabel("Código Alumno:");
		lblCdigoAlumno.setBounds(10, 32, 89, 14);
		panel.add(lblCdigoAlumno);
		
		txtCodiAlumno = new JTextField();
		txtCodiAlumno.setEditable(false);
		txtCodiAlumno.setColumns(10);
		txtCodiAlumno.setBounds(109, 29, 123, 20);
		panel.add(txtCodiAlumno);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 57, 89, 14);
		panel.add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setEditable(false);
		txtNombres.setColumns(10);
		txtNombres.setBounds(109, 54, 123, 20);
		panel.add(txtNombres);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(258, 57, 61, 14);
		panel.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(329, 54, 123, 20);
		panel.add(txtApellidos);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setColumns(10);
		txtDni.setBounds(109, 82, 73, 20);
		panel.add(txtDni);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 85, 40, 14);
		panel.add(lblDni);
		
		lblNewLabel = new JLabel("Edad:");
		lblNewLabel.setBounds(258, 85, 40, 14);
		panel.add(lblNewLabel);
		
		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setColumns(10);
		txtEdad.setBounds(329, 82, 46, 20);
		panel.add(txtEdad);
		
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBounds(329, 107, 73, 20);
		panel.add(txtEstado);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(258, 110, 46, 14);
		panel.add(lblEstado);
		
		txtCelular = new JTextField();
		txtCelular.setEditable(false);
		txtCelular.setColumns(10);
		txtCelular.setBounds(109, 113, 73, 20);
		panel.add(txtCelular);
		
		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(10, 110, 58, 14);
		panel.add(lblCelular);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DATOS DEL CURSO", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(64, 64, 64)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 231, 491, 136);
		contentPane.add(panel_1);
		
		lblCodAlum = new JLabel("Código Curso:");
		lblCodAlum.setBounds(10, 35, 89, 14);
		panel_1.add(lblCodAlum);
		
		txtCodiCurso = new JTextField();
		txtCodiCurso.setEditable(false);
		txtCodiCurso.setColumns(10);
		txtCodiCurso.setBounds(109, 32, 123, 20);
		panel_1.add(txtCodiCurso);
		
		lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setBounds(10, 60, 89, 14);
		panel_1.add(lblAsignatura);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setEditable(false);
		txtAsignatura.setColumns(10);
		txtAsignatura.setBounds(109, 57, 123, 20);
		panel_1.add(txtAsignatura);
		
		lblCiclo = new JLabel("Ciclo:");
		lblCiclo.setBounds(10, 85, 58, 14);
		panel_1.add(lblCiclo);
		
		txtCiclo = new JTextField();
		txtCiclo.setEditable(false);
		txtCiclo.setColumns(10);
		txtCiclo.setBounds(109, 82, 123, 20);
		panel_1.add(txtCiclo);
		
		lblCreditos = new JLabel("Créditos:");
		lblCreditos.setBounds(291, 35, 68, 14);
		panel_1.add(lblCreditos);
		
		txtCreditos = new JTextField();
		txtCreditos.setEditable(false);
		txtCreditos.setColumns(10);
		txtCreditos.setBounds(358, 32, 46, 20);
		panel_1.add(txtCreditos);
		
		lblHoras = new JLabel("Horas:");
		lblHoras.setBounds(291, 60, 46, 14);
		panel_1.add(lblHoras);
		
		txtHoras = new JTextField();
		txtHoras.setEditable(false);
		txtHoras.setColumns(10);
		txtHoras.setBounds(358, 57, 46, 20);
		panel_1.add(txtHoras);
		
		lblNMatrcula = new JLabel("N° Matricula:");
		lblNMatrcula.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNMatrcula.setBounds(10, 11, 99, 21);
		contentPane.add(lblNMatrcula);
		
		lblNRetiro = new JLabel("N° Retiro:");
		lblNRetiro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNRetiro.setBounds(10, 44, 99, 21);
		contentPane.add(lblNRetiro);
		
		txtConsultaTres = new JTextField();
		txtConsultaTres.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtConsultaTres.setColumns(10);
		txtConsultaTres.setBounds(138, 41, 99, 23);
		contentPane.add(txtConsultaTres);
		
		btnProcesarRetiro = new JButton("Consultar Retiro");
		btnProcesarRetiro.addActionListener(this);
		btnProcesarRetiro.setForeground(new Color(102, 102, 102));
		btnProcesarRetiro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnProcesarRetiro.setBorder(null);
		btnProcesarRetiro.setBackground(Color.WHITE);
		btnProcesarRetiro.setBounds(343, 45, 158, 23);
		contentPane.add(btnProcesarRetiro);
		
		//columnas para la tabla
		modelo.addColumn("Cod.Curso");
		modelo.addColumn("Asignatura");
		modelo.addColumn("Ciclo");
		modelo.addColumn("Créditos");
		modelo.addColumn("Horas");

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesarRetiro) {
			actionPerformedBtnProcesarRetiro(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
		if (e.getSource() == btnInicio) {
			actionPerformedBtnInicio(e);
		}
		if (e.getSource() == btnAtras) {
			actionPerformedBtnAtras(e);
		}
	}
	protected void actionPerformedBtnAtras(ActionEvent e) {
				//abriendo el menu consulta
				consulta verConsulta = new consulta();
				verConsulta.setVisible(true);
				// Centrar el Menu consulta
				verConsulta.setLocationRelativeTo(null);
				dispose();
	}
	protected void actionPerformedBtnInicio(ActionEvent e) {
				//volviendo al menu principal
				menuPrincipal verMenu = new menuPrincipal();
				verMenu.setVisible(true);
				verMenu.setLocationRelativeTo(null);
				dispose();
		
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		Metodos.limpiarConsultar(txtEdad, txtNombres, txtCelular, txtCreditos, txtConsultaTres, txtConsultaDos, txtAsignatura, 
				txtHoras, txtCodiCurso, txtCiclo, txtAsignatura, txtCelular, txtCodiAlumno, txtApellidos);
		txtDni.setText("");
		txtEstado.setText("");
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		try {
			listarMatricula();
		}
		catch (Exception e2) {
			Metodos.mensajeError("Número de Matrícula incorrecto", "Error en número de matrícula");
		}
		
	}
	void listarRetiro() {
		int codigo = Metodos.getEntero(txtConsultaTres);
	 	Retiro r = arRetiro.buscarRetiro(codigo);
	 	Matricula m = arMatricula.buscarMatricula(r.getNumMatricula());
		Alumno a = arAlumno.buscarAlumno(m.getCodAlumno());
		Curso c = arCurso.buscarCurso(m.getCodCurso());
			if(codigo==r.getNumRetiro()) {
				
				//Declarar variables
				int codiAlumno,edad,celular,codiCurso,cicloCurso,creditosCurso,horasCurso;
				String nomAlumno,apelliAlum,estadoAlum,dni,asignaturaCurso;
				//Obtener datos
				codiAlumno = a.getCodAlumno();
				dni		   = a.getDni();
				edad       = a.getEdad();
				celular    = a.getCelular();
				nomAlumno  = a.getNombres();
				apelliAlum = a.getApellidos();
				estadoAlum = a.estado();
				
				codiCurso 		= c.getCodCurso();
				asignaturaCurso = c.getAsignatura();
				cicloCurso 		= c.getCiclo();
				creditosCurso 	= c.getCreditos();
				horasCurso 		= c.getHoras();
				//Enviar Datos
				Metodos.setEntero(txtCodiAlumno, codiAlumno);
				Metodos.setTexto(txtDni, dni);
				Metodos.setEntero(txtEdad, edad);
				Metodos.setEntero(txtCelular, celular);
				Metodos.setTexto(txtApellidos, apelliAlum);
				Metodos.setTexto(txtNombres, nomAlumno);
				Metodos.setTexto(txtEstado, estadoAlum);
				
				Metodos.setEntero(txtCodiCurso, codiCurso);
				Metodos.setTexto(txtAsignatura, asignaturaCurso);
				Metodos.setEntero(txtCiclo, cicloCurso);
				Metodos.setEntero(txtCreditos, creditosCurso);
				Metodos.setEntero(txtHoras, horasCurso);
				}
			
			
	}
	
	void listarMatricula(){
		
		int codigo = Metodos.getEntero(txtConsultaDos);
	 	Matricula m = arMatricula.buscarMatricula(codigo);
		Alumno a = arAlumno.buscarAlumno(m.getCodAlumno());
		Curso c = arCurso.buscarCurso(m.getCodCurso());
			
		//Declarar variables
		int codiAlumno,edad,celular,codiCurso,cicloCurso,creditosCurso,horasCurso;
		String nomAlumno,apelliAlum,estadoAlum,dni,asignaturaCurso;
		//Obtener datos
		codiAlumno = a.getCodAlumno();
		dni		   = a.getDni();
		edad       = a.getEdad();
		celular    = a.getCelular();
		nomAlumno  = a.getNombres();
		apelliAlum = a.getApellidos();
		estadoAlum = a.estado();
		
		codiCurso 		= c.getCodCurso();
		asignaturaCurso = c.getAsignatura();
		cicloCurso 		= c.getCiclo();
		creditosCurso 	= c.getCreditos();
		horasCurso 		= c.getHoras();
		//Enviar Datos
		Metodos.setEntero(txtCodiAlumno, codiAlumno);
		Metodos.setTexto(txtDni, dni);
		Metodos.setEntero(txtEdad, edad);
		Metodos.setEntero(txtCelular, celular);
		Metodos.setTexto(txtApellidos, apelliAlum);
		Metodos.setTexto(txtNombres, nomAlumno);
		Metodos.setTexto(txtEstado, estadoAlum);
		
		Metodos.setEntero(txtCodiCurso, codiCurso);
		Metodos.setTexto(txtAsignatura, asignaturaCurso);
		Metodos.setEntero(txtCiclo, cicloCurso);
		Metodos.setEntero(txtCreditos, creditosCurso);
		Metodos.setEntero(txtHoras, horasCurso);
				
	}
									
			
	protected void actionPerformedBtnProcesarRetiro(ActionEvent e) {
		try {
			listarRetiro();
		}
		catch (Exception e2) {
			Metodos.mensajeError("Número de Retiro incorrecto", "Error en número de retiro");
		}
		
	}
}



