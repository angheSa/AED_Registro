package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import controlador.ArregloCurso;
import controlador.ArregloMatricula;
import entidades.Alumno;
import entidades.Matricula;
import modulo.Metodos;

public class regisEditMatri extends JFrame implements ActionListener, KeyListener, MouseListener{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

			//modelo de la tabla
			DefaultTableModel modelo = new  DefaultTableModel();

	/**
	 * Launch the application.
	 */
	
	//Creamos objetos para las clases.
	ArregloMatricula arMatricula = new ArregloMatricula();
	ArregloAlumno arAlumno= new ArregloAlumno();
	ArregloCurso arCurso = new ArregloCurso();
	

	private JPanel contentPane;
	private JLabel lblAdicionarMatrcula;
	private JLabel lblConsultePor;
	private JTextField txtNumMatricula;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JPanel panel;
	private JLabel lblNMatrcula;
	private JLabel lblCodAlumno;
	private JTextField txtCodMatri;
	private JTextField txtCodAlumno;
	private JLabel lblFecha;
	private JTextField txtFecha;
	private JLabel lblCodCurso;
	private JLabel lblHora;
	public static JTextField txtCodCurso;
	private JTextField txtHora;
	private JScrollPane scrollPane;
	private JTable tblModiMatri;
	private JButton btnVolver;
	private JButton btnInicio;
	private JButton btnConsultMatri;
	private JButton btnBuscarCurso;
	private JButton btnListarMatriculas;
	private JLabel lblEstadoMatricula;
	private JTextField txtEstMatri;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regisEditMatri frame = new regisEditMatri();
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
	public regisEditMatri() {
		setTitle("Consultar - Modificar - Eliminar | Matricula | Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 425);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(200, 232, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAdicionarMatrcula = new JLabel("MODIFICAR Y ELIMINAR MATRICULA");
		lblAdicionarMatrcula.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarMatrcula.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblAdicionarMatrcula.setBounds(109, 11, 312, 35);
		contentPane.add(lblAdicionarMatrcula);
		
		lblConsultePor = new JLabel("N° Matrícula:");
		lblConsultePor.setHorizontalAlignment(SwingConstants.LEFT);
		lblConsultePor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConsultePor.setBounds(10, 68, 101, 18);
		contentPane.add(lblConsultePor);
		
		txtNumMatricula = new JTextField();
		txtNumMatricula.setColumns(10);
		txtNumMatricula.setBounds(109, 68, 101, 21);
		contentPane.add(txtNumMatricula);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setToolTipText("Registrar nuevo alumno");
		btnModificar.setForeground(Color.DARK_GRAY);
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(332, 66, 89, 25);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setToolTipText("Registrar alumno");
		btnEliminar.setForeground(Color.DARK_GRAY);
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(431, 66, 89, 25);
		contentPane.add(btnEliminar);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DATOS DE LA MATR\u00CDCULA", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 102, 510, 120);
		contentPane.add(panel);
		
		lblNMatrcula = new JLabel("N° Matrícula:");
		lblNMatrcula.setForeground(Color.BLACK);
		lblNMatrcula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNMatrcula.setBounds(26, 37, 90, 15);
		panel.add(lblNMatrcula);
		
		lblCodAlumno = new JLabel("Cod. Alumno:");
		lblCodAlumno.setForeground(Color.BLACK);
		lblCodAlumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodAlumno.setBounds(26, 66, 90, 15);
		panel.add(lblCodAlumno);
		
		txtCodMatri = new JTextField();
		txtCodMatri.setEditable(false);
		txtCodMatri.setColumns(10);
		txtCodMatri.setBounds(114, 33, 90, 20);
		panel.add(txtCodMatri);
		
		txtCodAlumno = new JTextField();
		txtCodAlumno.setEditable(false);
		txtCodAlumno.setColumns(10);
		txtCodAlumno.setBounds(114, 61, 120, 20);
		panel.add(txtCodAlumno);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha.setBackground(Color.WHITE);
		lblFecha.setBounds(26, 91, 68, 15);
		panel.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(114, 89, 68, 20);
		panel.add(txtFecha);
		
		lblCodCurso = new JLabel("Cod. Curso:");
		lblCodCurso.setForeground(Color.BLACK);
		lblCodCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodCurso.setBounds(270, 66, 90, 15);
		panel.add(lblCodCurso);
		
		lblHora = new JLabel("Hora:");
		lblHora.setForeground(Color.BLACK);
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHora.setBounds(270, 91, 83, 15);
		panel.add(lblHora);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setColumns(10);
		txtCodCurso.setBounds(363, 64, 86, 20);
		panel.add(txtCodCurso);
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setColumns(10);
		txtHora.setBounds(363, 89, 61, 20);
		panel.add(txtHora);
		
		btnBuscarCurso = new JButton("");
		btnBuscarCurso.addActionListener(this);
		btnBuscarCurso.setIcon(new ImageIcon(regisEditMatri.class.getResource("/iconos/lupa2.png")));
		btnBuscarCurso.setBackground(Color.WHITE);
		btnBuscarCurso.setBounds(459, 53, 28, 28);
		panel.add(btnBuscarCurso);
		
		lblEstadoMatricula = new JLabel("Estado Matricula:");
		lblEstadoMatricula.setForeground(Color.BLACK);
		lblEstadoMatricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstadoMatricula.setBounds(270, 37, 104, 15);
		panel.add(lblEstadoMatricula);
		
		txtEstMatri = new JTextField();
		txtEstMatri.setEditable(false);
		txtEstMatri.setBounds(363, 35, 86, 20);
		panel.add(txtEstMatri);
		txtEstMatri.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 241, 510, 95);
		contentPane.add(scrollPane);
		
		tblModiMatri = new JTable();
		tblModiMatri.addMouseListener(this);
		tblModiMatri.addKeyListener(this);

		tblModiMatri.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblModiMatri);
		
		//columnas para la tabla
				modelo.addColumn("Matricula");
				modelo.addColumn("Cod.Alumno");
				modelo.addColumn("Cod.Curso");
				modelo.addColumn("Fecha");
				modelo.addColumn("Hora");
				
				//Asignar el modelo a la tabla
				tblModiMatri.setModel(modelo);
				
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setToolTipText("Registrar nuevo alumno");
		btnVolver.setForeground(Color.DARK_GRAY);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(10, 347, 89, 25);
		contentPane.add(btnVolver);
		
		btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(this);
		btnInicio.setToolTipText("Registrar alumno");
		btnInicio.setForeground(Color.DARK_GRAY);
		btnInicio.setBackground(Color.WHITE);
		btnInicio.setBounds(109, 347, 89, 25);
		contentPane.add(btnInicio);
		
		btnConsultMatri = new JButton("Consultar");
		btnConsultMatri.addActionListener(this);
		btnConsultMatri.setForeground(Color.DARK_GRAY);
		btnConsultMatri.setBackground(Color.WHITE);
		btnConsultMatri.setBounds(234, 67, 89, 23);
		contentPane.add(btnConsultMatri);
		
		btnListarMatriculas = new JButton("Listar Matriculas");
		btnListarMatriculas.addActionListener(this);
		btnListarMatriculas.setForeground(Color.DARK_GRAY);
		btnListarMatriculas.setBackground(Color.WHITE);
		btnListarMatriculas.setBounds(371, 348, 149, 23);
		contentPane.add(btnListarMatriculas);
		
		listarMatriculas();

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListarMatriculas) {
			actionPerformedBtnListarMatriculas(e);
		}
		if (e.getSource() == btnConsultMatri) {
			actionPerformedBtnConsultMatri(e);
		}
		if (e.getSource() == btnBuscarCurso) {
			actionPerformedBtnBuscarCurso(e);
		}
		if (e.getSource() == btnInicio) {
			actionPerformedBtnInicio(e);
		}
		if (e.getSource() == btnVolver) {
			actionPerformedBtnVolver(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
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
	protected void actionPerformedBtnBuscarCurso(ActionEvent e) {
		DlgBuscarCursoMatri buscarCursoMatri = new DlgBuscarCursoMatri();
		buscarCursoMatri.setLocationRelativeTo(this);
		buscarCursoMatri.setVisible(true);
	}

	private void actionPerformedBtnConsultMatri(ActionEvent e) {
		consultarMatri();		
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
			modificarMatri();
		
		
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarMatri();
	}
	
	private void consultarMatri(){
		try {
			int numMatricula = Metodos.getEntero(txtNumMatricula);
			Matricula m = arMatricula.buscarMatricula(numMatricula);
			if ((Integer.toString(numMatricula)).length()!=6){
				Metodos.mensajeError("El código debe tener 6 dígitos", "Alerta!");
			}else {
				if(m== null) {
					Metodos.mensajeError("El código de matrícula no existe", "Alerta!");
				}
				else {
					modelo.setRowCount(0);			
					for (int i = 0; i < arMatricula.tamanoListaMatriculas(); i++) {
						Matricula ma= arMatricula.getMatriculas(i); 
						if(m== ma){
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
			}
		}
		catch (Exception e) {
			Metodos.mensajeError("Tomar en cuenta lo siguiente:\n1. El código debe tener 6 dígitos.\n2. No se acepta letras.", "Alerta!");
		}			
}
	
	private void modificarMatri() {
		try {
			Matricula ma = arMatricula.buscarMatricula(Metodos.getEntero(txtNumMatricula));
			int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro de modificar la matricula?","Aviso",JOptionPane.YES_NO_OPTION);
			if(opcion == 0) { 
				
				if(ma!= null) {
					ma.setCodCurso(Metodos.getEntero(txtCodCurso));
					listarMatriculas();
					arMatricula.exportarMatriculas();
					Metodos.limpiarCuadrosTxt(txtHora, txtCodMatri, txtCodCurso, txtCodAlumno, txtFecha);
					txtNumMatricula.setText("");	
				}else {
					Metodos.mensajeError("La matricula está desactivada","Alerta!");
				}
				
			}
		}
		catch (Exception e2) {
			Metodos.mensajeError("Debe seleccionar una Matrícula","Error en solicitud!");
			System.out.println(e2);
		}
		
		
	}

	
	
	private void eliminarMatri() {
				try {
					Matricula ma = arMatricula.buscarMatricula(Metodos.getEntero(txtNumMatricula));
					int i = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (i == 0) {
						try {
							
							Alumno al= arAlumno.buscarAlumno(ma.getCodAlumno());
							if(al.getEstado()==0 || al.getEstado() ==1) {
								JOptionPane.showMessageDialog(this, "La Matricula ha sido eliminada!", "Eliminación Exitosa!", JOptionPane.INFORMATION_MESSAGE, null);
								al.setEstado(0);
								arMatricula.eliminarMatricula(ma);
								arAlumno.exportarAlumno();
								listarMatriculas();
								arMatricula.exportarMatriculas();
								Metodos.limpiarCuadrosTxt(txtHora, txtCodMatri, txtCodCurso, txtCodAlumno, txtFecha);
								txtNumMatricula.requestFocus();
							}
						}
						catch (Exception e) {
							Metodos.mensajeError("El alumno se encuentra retirado", "Alerta!");
						}
							
					}
				}
				catch (Exception e) {
					Metodos.mensajeError("Debe seleccionar una Matrícula", "Error en la solicitud");					
				}
			
						
					
	}
    	
	void mostrarDatos(int fila) {
		if(fila != -1) {
			//Obtener los datos de la tabla
			String codMatri,codAlumno,codCurso,fecha,hora;
			codMatri 	= tblModiMatri.getValueAt(fila, 0).toString();
			codAlumno 	= tblModiMatri.getValueAt(fila, 1).toString();
			codCurso	= tblModiMatri.getValueAt(fila, 2).toString();
			fecha		= tblModiMatri.getValueAt(fila, 3).toString();
			hora		= tblModiMatri.getValueAt(fila, 4).toString();
			int codigoAlumno = Integer.parseInt(codAlumno);
			int estadoAlumno = arAlumno.buscarAlumno(codigoAlumno).getEstado();
			
			// Enviar los datos de la tabla a los cuadros de texto
			Metodos.setTexto(txtCodMatri, codMatri);
			Metodos.setTexto(txtCodAlumno, codAlumno);
			Metodos.setTexto(txtCodCurso, codCurso);
			Metodos.setTexto(txtFecha, fecha);
			Metodos.setTexto(txtHora, hora);
			Metodos.setTexto(txtNumMatricula, codMatri);
			Metodos.setTexto(txtEstMatri, estadoMatri(estadoAlumno));
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
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblModiMatri) {
			keyReleasedTblModiMatri(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblModiMatri(KeyEvent e) {
		int fila;
		fila = tblModiMatri.getSelectedRow();
		mostrarDatos(fila);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblModiMatri) {
			mouseClickedTblModiMatri(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTblModiMatri(MouseEvent e) {
		int fila;
		fila = tblModiMatri.getSelectedRow();
		mostrarDatos(fila);
	}
	protected void actionPerformedBtnListarMatriculas(ActionEvent e) {
		listarMatriculas();
	}
	
	public String estadoMatri(int estado) {
		switch (estado) {
			case 1:
				return "Activo";
			default:
				return "Inactivo";
		}
	}
}

