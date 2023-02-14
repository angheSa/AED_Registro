package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


import controlador.ArregloAlumno;
import controlador.ArregloCurso;
import controlador.ArregloMatricula;
import entidades.Alumno;
import entidades.Curso;
import entidades.Matricula;
import modulo.Metodos;

public class consultAlumCurs extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtConsultaUno;
	private JButton btnProcesar;
	private JButton btnAtras;
	private JButton btnInicio;
	private JLabel lblAlumno;
	private JLabel lblAsignatura;
	private JLabel lblCiclo;
	private JLabel lblCreditos;
	private JLabel lblHoras;
	private JLabel lblCodAlum;
	private JTextField txtCodCurso;
	private JTextField txtAsignatura;
	private JTextField txtCiclo;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	@SuppressWarnings("rawtypes")
	private JComboBox cboConsultaAlum;
	
	//Crear objetos para los arreglos
	ArregloAlumno arAlumno = new ArregloAlumno();	
	ArregloCurso arCurso = new ArregloCurso();
	ArregloMatricula arMatricula = new ArregloMatricula();
	
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnBorrar;
	private JLabel lblCdigoAlumno;
	private JTextField txtCodigoAlumno;
	private JLabel lblNombres;
	private JTextField txtNombres;
	private JLabel lblCelular;
	private JTextField txtCelular;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JLabel lblDni;
	private JLabel lblNewLabel;
	private JTextField txtEdad;
	private JTextField txtEstado;
	private JLabel lblEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultAlumCurs frame = new consultAlumCurs();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public consultAlumCurs() {
		setResizable(false);
		setTitle("Consulta de Alumnos ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 447);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(200, 232, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtConsultaUno = new JTextField();
		txtConsultaUno.setBounds(255, 31, 115, 21);
		contentPane.add(txtConsultaUno);
		txtConsultaUno.setColumns(10);
		
		btnProcesar = new JButton("Consultar");
		btnProcesar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnProcesar.setBorder(null);
		btnProcesar.setBackground(Color.WHITE);
		btnProcesar.setForeground(Color.DARK_GRAY);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(412, 30, 89, 23);
		contentPane.add(btnProcesar);
		
		btnAtras = new JButton("Volver");
		btnAtras.setToolTipText("Volver a consulta");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtras.setBorder(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setForeground(Color.DARK_GRAY);
		btnAtras.addActionListener(this);
		btnAtras.setBounds(10, 373, 89, 23);
		contentPane.add(btnAtras);
		
		btnInicio = new JButton("Inicio");
		btnInicio.setToolTipText("Ir al Menú Principal");
		btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnInicio.setBorder(null);
		btnInicio.setForeground(Color.DARK_GRAY);
		btnInicio.setBackground(Color.WHITE);
		btnInicio.addActionListener(this);
		btnInicio.setBounds(137, 373, 89, 23);
		contentPane.add(btnInicio);
		
		lblAlumno = new JLabel("Consulte por:");
		lblAlumno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAlumno.setBounds(10, 30, 133, 21);
		contentPane.add(lblAlumno);
		
		cboConsultaAlum = new JComboBox();
		cboConsultaAlum.setBorder(null);
		cboConsultaAlum.setForeground(Color.BLACK);
		cboConsultaAlum.setBackground(Color.WHITE);
		cboConsultaAlum.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Código de Curso", "Código de Alumno"}));
		cboConsultaAlum.setSelectedIndex(0);
		cboConsultaAlum.setBounds(112, 30, 133, 22);
		contentPane.add(cboConsultaAlum);
	
				
				panel = new JPanel();
				panel.setBackground(Color.WHITE);
				panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DATOS DEL CURSO", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(64, 64, 64)));
				panel.setBounds(10, 226, 491, 136);
				contentPane.add(panel);
				panel.setLayout(null);
				
				lblCodAlum = new JLabel("Código Curso:");
				lblCodAlum.setBounds(10, 35, 89, 14);
				panel.add(lblCodAlum);
				
				txtCodCurso = new JTextField();
				txtCodCurso.setBounds(109, 32, 123, 20);
				panel.add(txtCodCurso);
				txtCodCurso.setEditable(false);
				txtCodCurso.setColumns(10);
				
				lblAsignatura = new JLabel("Asignatura:");
				lblAsignatura.setBounds(10, 60, 89, 14);
				panel.add(lblAsignatura);
				
				txtAsignatura = new JTextField();
				txtAsignatura.setBounds(109, 57, 209, 20);
				panel.add(txtAsignatura);
				txtAsignatura.setEditable(false);
				txtAsignatura.setColumns(10);
				
				lblCiclo = new JLabel("Ciclo:");
				lblCiclo.setBounds(10, 85, 58, 14);
				panel.add(lblCiclo);
				
				txtCiclo = new JTextField();
				txtCiclo.setBounds(109, 82, 123, 20);
				panel.add(txtCiclo);
				txtCiclo.setEditable(false);
				txtCiclo.setColumns(10);
				
				lblCreditos = new JLabel("Créditos:");
				lblCreditos.setBounds(347, 38, 68, 14);
				panel.add(lblCreditos);
				
				txtCreditos = new JTextField();
				txtCreditos.setBounds(414, 35, 46, 20);
				panel.add(txtCreditos);
				txtCreditos.setEditable(false);
				txtCreditos.setColumns(10);
				
				lblHoras = new JLabel("Horas:");
				lblHoras.setBounds(347, 63, 46, 14);
				panel.add(lblHoras);
				
				txtHoras = new JTextField();
				txtHoras.setBounds(414, 60, 46, 20);
				panel.add(txtHoras);
				txtHoras.setEditable(false);
				txtHoras.setColumns(10);
				
				panel_1 = new JPanel();
				panel_1.setBackground(Color.WHITE);
				panel_1.setBorder(new TitledBorder(null, "DATOS DEL ALUMNO", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, Color.DARK_GRAY));
				panel_1.setBounds(10, 69, 491, 146);
				contentPane.add(panel_1);
				panel_1.setLayout(null);
				
				lblCdigoAlumno = new JLabel("Código Alumno:");
				lblCdigoAlumno.setBounds(10, 32, 89, 14);
				panel_1.add(lblCdigoAlumno);
				
				txtCodigoAlumno = new JTextField();
				txtCodigoAlumno.setEditable(false);
				txtCodigoAlumno.setColumns(10);
				txtCodigoAlumno.setBounds(109, 29, 123, 20);
				panel_1.add(txtCodigoAlumno);
				
				lblNombres = new JLabel("Nombres:");
				lblNombres.setBounds(10, 57, 89, 14);
				panel_1.add(lblNombres);
				
				txtNombres = new JTextField();
				txtNombres.setEditable(false);
				txtNombres.setColumns(10);
				txtNombres.setBounds(109, 54, 123, 20);
				panel_1.add(txtNombres);
				
				lblApellidos = new JLabel("Apellidos:");
				lblApellidos.setBounds(258, 57, 61, 14);
				panel_1.add(lblApellidos);
				
				txtApellidos = new JTextField();
				txtApellidos.setEditable(false);
				txtApellidos.setColumns(10);
				txtApellidos.setBounds(329, 54, 123, 20);
				panel_1.add(txtApellidos);
				
				txtDni = new JTextField();
				txtDni.setEditable(false);
				txtDni.setColumns(10);
				txtDni.setBounds(109, 82, 73, 20);
				panel_1.add(txtDni);
				
				lblDni = new JLabel("DNI:");
				lblDni.setBounds(10, 85, 40, 14);
				panel_1.add(lblDni);
				
				lblNewLabel = new JLabel("Edad:");
				lblNewLabel.setBounds(258, 85, 40, 14);
				panel_1.add(lblNewLabel);
				
				txtEdad = new JTextField();
				txtEdad.setEditable(false);
				txtEdad.setColumns(10);
				txtEdad.setBounds(329, 82, 46, 20);
				panel_1.add(txtEdad);
				
				txtEstado = new JTextField();
				txtEstado.setEditable(false);
				txtEstado.setColumns(10);
				txtEstado.setBounds(329, 107, 73, 20);
				panel_1.add(txtEstado);
				
				lblEstado = new JLabel("Estado:");
				lblEstado.setBounds(258, 110, 46, 14);
				panel_1.add(lblEstado);
				
				txtCelular = new JTextField();
				txtCelular.setBounds(109, 113, 73, 20);
				panel_1.add(txtCelular);
				txtCelular.setEditable(false);
				txtCelular.setColumns(10);
				
				lblCelular = new JLabel("Celular:");
				lblCelular.setBounds(10, 110, 58, 14);
				panel_1.add(lblCelular);
				
				btnBorrar = new JButton("Borrar");
				btnBorrar.addActionListener(this);
				btnBorrar.setToolTipText("Ir al Menú Principal");
				btnBorrar.setForeground(Color.DARK_GRAY);
				btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
				btnBorrar.setBorder(null);
				btnBorrar.setBackground(Color.WHITE);
				btnBorrar.setBounds(412, 373, 89, 23);
				contentPane.add(btnBorrar);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
		if (e.getSource() == btnInicio) {
			actionPerformedBtnInicio(e);
		}
		if (e.getSource() == btnAtras) {
			actionPerformedBtnAtras(e);
		}
	}
	protected void actionPerformedBtnAtras(ActionEvent e) {
		//Abriendo el Menu consulta
		consulta verConsulta = new consulta();
		verConsulta.setVisible(true);
		//centrar el menu consulta
		verConsulta.setLocationRelativeTo(null);
		dispose();
	}
	protected void actionPerformedBtnInicio(ActionEvent e) {
		//volver al menuPrincipal
		menuPrincipal verMenu = new menuPrincipal();
		verMenu.setVisible(true);
		verMenu.setLocationRelativeTo(null);
		dispose();
	}
	
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		try {
			//Invocamos al método consultar e inicializamos las variables.
			int tipo = cboConsultaAlum.getSelectedIndex();
			int dato= Metodos.getEntero(txtConsultaUno);
			
			
			if (tipo == 0) {
				
				Metodos.mensajeError("Seleccione una opción", "Alerta!");
			}
			else {
			
			consultar(tipo,dato);
			}			
		}
		catch (Exception e2) {
			Metodos.mensajeError("Debe Ingresar un valor numerico", "Error en solicitud");
			System.out.println(e2);
		}
				
		
	}
	
	 int leerCodigo(){
		return Metodos.getEntero(txtConsultaUno);
	}
	
	void consultar(int tipo, int dato) {
		//Asignación de las variables
		 
				
			/*Consulta de codigo de curso*/
		 try {
			 int codigoCurso = leerCodigo();
				Curso c = arCurso.buscarCurso(codigoCurso);
				
				
				if(tipo ==1) {
					if(c.getCodCurso()==dato) {
						int codiCurso,cicloCurso,creditosCurso,horasCurso;
						String asignaturaCurso;
						
							
						codiCurso 		= c.getCodCurso();
						asignaturaCurso = c.getAsignatura();
						cicloCurso 		= c.getCiclo();
						creditosCurso 	= c.getCreditos();
						horasCurso 		= c.getHoras();
						
						Metodos.setEntero(txtCodCurso, codiCurso);
						Metodos.setTexto(txtAsignatura, asignaturaCurso);
						Metodos.setEntero(txtCiclo, cicloCurso);
						Metodos.setEntero(txtCreditos, creditosCurso);
						Metodos.setEntero(txtHoras, horasCurso);
						
					}
					else {
						Metodos.mensajeError("El código del curso no existe", "Alerta!");
					}
				}else if (tipo ==2) {
					
					/*Consulta de codigo alumno*/
					 try {
						 int codigoAlumno = leerCodigo();
							Alumno a = arAlumno.buscarAlumno(codigoAlumno);
							if(tipo ==2) {
								if(a.getCodAlumno()==dato) {
									//Declarar variables
									int codiAlumno,edad,celular;
									String nomAlumno,apelliAlum,estadoAlum,dni;
									//Obtener datos
									codiAlumno = a.getCodAlumno();
									dni		   = a.getDni();
									edad       = a.getEdad();
									celular    = a.getCelular();
									nomAlumno  = a.getNombres();
									apelliAlum = a.getApellidos();
									estadoAlum = a.estado();
									//Enviar Datos
									Metodos.setEntero(txtCodigoAlumno, codiAlumno);
									Metodos.setTexto(txtDni, dni);
									Metodos.setEntero(txtEdad, edad);
									Metodos.setEntero(txtCelular, celular);
									Metodos.setTexto(txtApellidos, apelliAlum);
									Metodos.setTexto(txtNombres, nomAlumno);
									Metodos.setTexto(txtEstado, estadoAlum);
								}else {
									Metodos.mensajeError("El código del alumno no existe", "Alerta!");
								}
							}
							
								//Si el alumno está matriculado, mostrar los datos del curso
								int codigoAlumMatri = leerCodigo();
								if(a.getEstado()==1) {
									Matricula m = arMatricula.buscarAlumno(codigoAlumMatri);
									Curso cu = arCurso.buscarCurso(m.getCodCurso());
									//Declarar variables
									int codiCurso,cicloCurso,creditosCurso,horasCurso;
									String asignaturaCurso;
									
										
									codiCurso 		= cu.getCodCurso();
									asignaturaCurso = cu.getAsignatura();
									cicloCurso 		= cu.getCiclo();
									creditosCurso 	= cu.getCreditos();
									horasCurso 		= cu.getHoras();
									
									Metodos.setEntero(txtCodCurso, codiCurso);
									Metodos.setTexto(txtAsignatura, asignaturaCurso);
									Metodos.setEntero(txtCiclo, cicloCurso);
									Metodos.setEntero(txtCreditos, creditosCurso);
									Metodos.setEntero(txtHoras, horasCurso);
								}else {
									Metodos.mensajeError("El alumno no está matriculado", "Alerta!");
								}
					}
					catch (Exception e) {
						Metodos.mensajeError("Ingrese un código existente", "Alerta!");
						System.out.println(e);
					}
					
				}
		}
			catch (Exception e) {
				Metodos.mensajeError("Ingrese un código existente", "Alerta!");
				System.out.println(e);
			}
		 		
							
		
				
	}	

	


	
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		Metodos.limpiarConsultar(txtEdad, txtNombres, txtConsultaUno, txtDni, txtCreditos, txtCodCurso, txtAsignatura, txtHoras, txtCiclo, txtCelular, txtAsignatura, txtApellidos, txtCodigoAlumno,txtEstado);
		
	}
}
