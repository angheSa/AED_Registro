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
import controlador.ArregloRetiro;
import entidades.Alumno;
import entidades.Matricula;
import entidades.Retiro;
import modulo.Metodos;
import javax.swing.ImageIcon;

public class regisEditRetiro extends JFrame implements ActionListener, KeyListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblModificarYEliminar;
	private JLabel lblNumMatricula;
	private JTextField txtNumRetiros;
	private JButton btnConsultRetiro;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVolver;
	private JButton btnInicio;
	private JButton btnListarRetiros;
	private JPanel panel;
	private JLabel lblCodMatricula;
	private JTextField txtCodMatri;
	private JLabel lblFecha;
	private JTextField txtFecha;
	private JLabel lblHora;
	private JTextField txtHora;
	private JScrollPane scrollPane;
	private JTable tblModiRetiro;

	/**
	 * Launch the application.
	 */
	//modelo de la tabla
	DefaultTableModel modelo = new  DefaultTableModel();



	//Creamos objetos para las clases.
	ArregloMatricula arMatricula = new ArregloMatricula();
	ArregloAlumno arAlumno= new ArregloAlumno();
	ArregloCurso arCurso = new ArregloCurso();
	ArregloRetiro arRetiro = new ArregloRetiro();
	
	private JLabel lblNRetiro;
	private JTextField txtRetiro;
	private JLabel lblCodCurso;
	public static JTextField txtCurso;
	private JButton btnBuscarCurso;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regisEditRetiro frame = new regisEditRetiro();
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
	public regisEditRetiro() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Consultar - Eliminar | Retiros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 226, 200));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblModificarYEliminar = new JLabel("CONSULTAR Y ELIMINAR RETIROS");
		lblModificarYEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarYEliminar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblModificarYEliminar.setBounds(119, 11, 312, 35);
		contentPane.add(lblModificarYEliminar);
		
		lblNumMatricula = new JLabel("N° Retiro:");
		lblNumMatricula.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumMatricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumMatricula.setBounds(20, 68, 101, 18);
		contentPane.add(lblNumMatricula);
		
		txtNumRetiros = new JTextField();
		txtNumRetiros.setColumns(10);
		txtNumRetiros.setBounds(119, 68, 101, 21);
		contentPane.add(txtNumRetiros);
		
		btnConsultRetiro = new JButton("Consultar");
		btnConsultRetiro.addActionListener(this);
		btnConsultRetiro.setForeground(Color.DARK_GRAY);
		btnConsultRetiro.setBackground(Color.WHITE);
		btnConsultRetiro.setBounds(244, 67, 89, 23);
		contentPane.add(btnConsultRetiro);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setToolTipText("Registrar nuevo alumno");
		btnModificar.setForeground(Color.DARK_GRAY);
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(342, 66, 89, 25);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setToolTipText("Registrar alumno");
		btnEliminar.setForeground(Color.DARK_GRAY);
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(441, 66, 89, 25);
		contentPane.add(btnEliminar);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setToolTipText("Registrar nuevo alumno");
		btnVolver.setForeground(Color.DARK_GRAY);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(10, 381, 89, 25);
		contentPane.add(btnVolver);
		
		btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(this);
		btnInicio.setToolTipText("Registrar alumno");
		btnInicio.setForeground(Color.DARK_GRAY);
		btnInicio.setBackground(Color.WHITE);
		btnInicio.setBounds(119, 381, 89, 25);
		contentPane.add(btnInicio);
		
		btnListarRetiros = new JButton("Listar Retiros");
		btnListarRetiros.addActionListener(this);
		btnListarRetiros.setForeground(Color.DARK_GRAY);
		btnListarRetiros.setBackground(Color.WHITE);
		btnListarRetiros.setBounds(381, 382, 149, 23);
		contentPane.add(btnListarRetiros);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPLETAR DATOS:", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 102, 520, 137);
		contentPane.add(panel);
		
		lblCodMatricula = new JLabel("Cod. Matricula");
		lblCodMatricula.setForeground(Color.BLACK);
		lblCodMatricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodMatricula.setBounds(256, 68, 90, 15);
		panel.add(lblCodMatricula);
		
		txtCodMatri = new JTextField();
		txtCodMatri.setEditable(false);
		txtCodMatri.setColumns(10);
		txtCodMatri.setBounds(345, 66, 90, 20);
		panel.add(txtCodMatri);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha.setBounds(10, 41, 36, 15);
		panel.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(99, 39, 75, 20);
		panel.add(txtFecha);
		
		lblHora = new JLabel("Hora:");
		lblHora.setForeground(Color.BLACK);
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHora.setBackground(Color.WHITE);
		lblHora.setBounds(258, 41, 46, 14);
		panel.add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setColumns(10);
		txtHora.setBounds(346, 39, 75, 20);
		panel.add(txtHora);
		
		lblNRetiro = new JLabel("N° Retiro:");
		lblNRetiro.setForeground(Color.BLACK);
		lblNRetiro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNRetiro.setBounds(10, 67, 90, 15);
		panel.add(lblNRetiro);
		
		txtRetiro = new JTextField();
		txtRetiro.setEditable(false);
		txtRetiro.setColumns(10);
		txtRetiro.setBounds(99, 65, 90, 21);
		panel.add(txtRetiro);
		
		lblCodCurso = new JLabel("Cod. Curso");
		lblCodCurso.setForeground(Color.BLACK);
		lblCodCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodCurso.setBounds(256, 101, 90, 15);
		panel.add(lblCodCurso);
		
		txtCurso = new JTextField();
		txtCurso.setEditable(false);
		txtCurso.setColumns(10);
		txtCurso.setBounds(345, 99, 60, 20);
		panel.add(txtCurso);
		
		btnBuscarCurso = new JButton("");
		btnBuscarCurso.addActionListener(this);
		btnBuscarCurso.setIcon(new ImageIcon(regisEditRetiro.class.getResource("/iconos/lupa2.png")));
		btnBuscarCurso.setBackground(Color.WHITE);
		btnBuscarCurso.setBounds(415, 91, 28, 28);
		panel.add(btnBuscarCurso);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 261, 523, 102);
		contentPane.add(scrollPane);
		
		tblModiRetiro = new JTable();
		tblModiRetiro.addMouseListener(this);
		tblModiRetiro.addKeyListener(this);
		tblModiRetiro.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblModiRetiro);
		modelo.addColumn("Cod.Retiro");
		modelo.addColumn("Cod.Matricula");
		modelo.addColumn("Cod. Curso");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		
		//Asignar el modelo a la tabla
		tblModiRetiro.setModel(modelo);
		
		//Para fecha y hora
		//txtFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		//txtHora.setText(new SimpleDateFormat("hh:mm:ss").format(new Date()));
		
		listarRetiros();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarCurso) {
			actionPerformedBtnBuscarCurso(e);
		}
		if (e.getSource() == btnConsultRetiro) {
			actionPerformedBtnConsultRetiro(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnVolver) {
			actionPerformedBtnVolver(e);
		}
		if (e.getSource() == btnInicio) {
			actionPerformedBtnInicio(e);
		}
		if (e.getSource() == btnListarRetiros) {
			actionPerformedBtnListarRetiros(e);
		}
	}
	protected void actionPerformedBtnListarRetiros(ActionEvent e) {
		listarRetiros();
	}
	protected void actionPerformedBtnConsultRetiro(ActionEvent e) {
		consultarRetiro();
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		try {
			modificarRetiro();
		}
		catch (Exception e2) {
			Metodos.mensajeError("Debe seleccionar un código de retiro", "Error de solicitud!");
		}
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarRetiro();
	}
	protected void actionPerformedBtnInicio(ActionEvent e) {
		//volver al menuPrincipal
				menuPrincipal verMenu = new menuPrincipal();
				verMenu.setVisible(true);
				verMenu.setLocationRelativeTo(null);
				dispose();
	}
	protected void actionPerformedBtnVolver(ActionEvent e) {
		//Abriendo el Menu registro
				registro verRegistro = new registro();
				verRegistro.setVisible(true);
				//centrar el menu consulta
				verRegistro.setLocationRelativeTo(null);
				dispose();
	}
	
	private void eliminarRetiro() {
		/*try {
			int i = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar ?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (i == 0) {
				Retiro re = arRetiro.buscarRetiro(Metodos.getEntero(txtNumRetiros));
				Matricula ma = arMatricula.buscarMatricula(re.getNumMatricula());
				Alumno al= arAlumno.buscarAlumno(ma.getCodAlumno());
				if(al.getEstado()==2) {
					
						JOptionPane.showMessageDialog(this, "La Matricula ha sido eliminada!", "Eliminación Exitosa!", JOptionPane.INFORMATION_MESSAGE, null);
						al.setEstado(0); 
						arRetiro.eliminarRetiro(re);
						arAlumno.exportarAlumno();
						ma.setEstado(1);
						arMatricula.exportarMatriculas();
						listarRetiros();
						arRetiro.exportarRetiro();
						Metodos.limpiarCuadrosCuatro(txtCodMatri, txtHora, txtFecha, txtRetiro);
						txtNumRetiros.requestFocus();
					}
				else {
						Metodos.mensajeError("El alumno no está retirado", "Alerta!");
					}
			}
		}
		catch (Exception e) {
			
		}*/
		try {
    		int numRetiro = Metodos.getEntero(txtNumRetiros);
    		Retiro re = arRetiro.buscarRetiro(numRetiro);
    		if(re != null){
    			int ok = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar ?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    			if(ok == 0){
    				Matricula ma = arMatricula.buscarMatricula(re.getNumMatricula());
    				Alumno al= arAlumno.buscarAlumno(ma.getCodAlumno());
    				al.setEstado(0); 
					arRetiro.eliminarRetiro(re);
					arAlumno.exportarAlumno();
					arMatricula.exportarMatriculas();
					listarRetiros();
					arRetiro.exportarRetiro();
					Metodos.limpiarCuadrosCuatro(txtCodMatri, txtHora, txtFecha, txtRetiro);
					txtNumRetiros.requestFocus();
    			}
    		}
    		else
    			Metodos.mensajeError("El código de retiro no existe", "Alerta!");
			
		} 
    	catch (Exception ex) {
    		Metodos.mensajeError("Ingrese un codigo de retiro", "Alerta!");
			
		}
		
		
	}

	private void modificarRetiro() {
		Retiro re = arRetiro.buscarRetiro(Metodos.getEntero(txtNumRetiros));
		Matricula ma = arMatricula.buscarMatricula(Metodos.getEntero(txtCodMatri));
		int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro de modificar la matricula?","Aviso",JOptionPane.YES_NO_OPTION);
		if(opcion == 0) { 
			
			//Curso c = arCurso.buscarCurso(ma.getCodCurso());
			if(re!= null ) {
					ma.setCodCurso(Metodos.getEntero(txtCurso));
					listarRetiros();
					arRetiro.exportarRetiro();
					arMatricula.exportarMatriculas();
					Metodos.limpiarCuadrosTxt(txtCodMatri, txtHora, txtCurso, txtNumRetiros, txtFecha);
			}
		}
		
	}

	
	private void consultarRetiro() {
		try {
			int numRetiro = Metodos.getEntero(txtNumRetiros);
			Retiro r = arRetiro.buscarRetiro(numRetiro);
			if ((Integer.toString(numRetiro)).length()!=6){
				Metodos.mensajeError("El código debe tener 6 dígitos", "Alerta!");
			}else {
				if(r== null) {
					Metodos.mensajeError("El código de matrícula no existe", "Alerta!");
				}
				else {
					modelo.setRowCount(0);			
					for (int i = 0; i < arRetiro.tamanoListaRetiro(); i++) {
						Retiro re= arRetiro.getRetiros(i); 
						if(r== re){
						Object data [] = {
										re.getNumRetiro(),
										re.getNumMatricula(),
										re.getFecha(),
										re.getHora()
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

	void listarRetiros() {
		modelo.setRowCount(0);			
		for (int i = 0; i < arRetiro.tamanoListaRetiro(); i++) {
			Retiro re = arRetiro.getRetiros(i);
			Matricula ma = arMatricula.buscarMatricula(re.getNumMatricula());
			Object data [] = {
							re.getNumRetiro(),
							re.getNumMatricula(),
							ma.getCodCurso(),
							re.getFecha(),
							re.getHora()
			};
			modelo.addRow(data);
		}
	}
	void mostrarDatos(int fila) {
		if(fila != -1) {
			//Obtener los datos de la tabla
			String codReti,codMatri,fecha,hora;
		
			codReti 	= tblModiRetiro.getValueAt(fila, 0).toString();
			codMatri 	= tblModiRetiro.getValueAt(fila, 1).toString();
			fecha		= tblModiRetiro.getValueAt(fila, 2).toString();
			hora		= tblModiRetiro.getValueAt(fila, 3).toString();
			// Enviar los datos de la tabla a los cuadros de texto
			Metodos.setTexto(txtRetiro, codReti);
			Metodos.setTexto(txtCodMatri, codMatri);
			Metodos.setTexto(txtFecha, fecha);
			Metodos.setTexto(txtHora, hora);
			Metodos.setTexto(txtNumRetiros, codReti);
			
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblModiRetiro) {
			keyReleasedTblModiRetiro(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblModiRetiro(KeyEvent e) {
		int fila;
		fila = tblModiRetiro.getSelectedRow();
		mostrarDatos(fila);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblModiRetiro) {
			mouseClickedTblModiRetiro(e);
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
	protected void mouseClickedTblModiRetiro(MouseEvent e) {
		int fila;
		fila = tblModiRetiro.getSelectedRow();
		mostrarDatos(fila);
	}
	protected void actionPerformedBtnBuscarCurso(ActionEvent e) {
		DlgBuscarCursoRetiro buscarCurso = new DlgBuscarCursoRetiro();
		buscarCurso.setLocationRelativeTo(this);
		buscarCurso.setVisible(true);
	}
}