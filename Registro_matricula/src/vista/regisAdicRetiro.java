package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import controlador.ArregloRetiro;
import entidades.Alumno;
import entidades.Matricula;
import entidades.Retiro;
import modulo.Metodos;
import javax.swing.ImageIcon;

public class regisAdicRetiro extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAdicionarRetiro;
	private JButton btnNuevoRetiro;
	private JButton btnAdicRetiro;
	private JLabel lblNumRetiro;
	private JTextField txtNumRetiro;
	private JPanel panel;
	private JLabel lblCodMatricula;
	public static JTextField txtCodMatricula;
	private JLabel lblFecha;
	private JTextField txtFecha;
	private JLabel lblHora;
	private JScrollPane scrollPane;
	private JTable tblAdicRetiro;
	private JButton btnVolver;
	private JButton btnInicio;

	/**
	 * Launch the application.
	 */
	
	 DefaultTableModel modelo = new DefaultTableModel();
	 
	 ArregloRetiro arRetiro = new ArregloRetiro();
	 ArregloAlumno arAlumno = new ArregloAlumno();
	 ArregloMatricula arMatricula= new ArregloMatricula();
	 
	 
	 private JTextField txtHora;
	 private JButton btnBuscarAlumno;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regisAdicRetiro frame = new regisAdicRetiro();
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
	public regisAdicRetiro() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Adicionar Retiro - Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 404);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 226, 200));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAdicionarRetiro = new JLabel("ADICIONAR RETIRO");
		lblAdicionarRetiro.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarRetiro.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblAdicionarRetiro.setBounds(152, 11, 248, 35);
		contentPane.add(lblAdicionarRetiro);
		
		btnNuevoRetiro = new JButton("Nuevo");
		btnNuevoRetiro.addActionListener(this);
		btnNuevoRetiro.setToolTipText("Registrar nuevo alumno");
		btnNuevoRetiro.setForeground(Color.DARK_GRAY);
		btnNuevoRetiro.setBackground(Color.WHITE);
		btnNuevoRetiro.setBounds(348, 57, 89, 25);
		contentPane.add(btnNuevoRetiro);
		
		btnAdicRetiro = new JButton("Adicionar");
		btnAdicRetiro.addActionListener(this);
		btnAdicRetiro.setToolTipText("Registrar alumno");
		btnAdicRetiro.setForeground(Color.DARK_GRAY);
		btnAdicRetiro.setBackground(Color.WHITE);
		btnAdicRetiro.setBounds(447, 57, 89, 25);
		contentPane.add(btnAdicRetiro);
		
		lblNumRetiro = new JLabel("N° Retiro:");
		lblNumRetiro.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumRetiro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumRetiro.setBounds(21, 59, 101, 18);
		contentPane.add(lblNumRetiro);
		
		txtNumRetiro = new JTextField();
		txtNumRetiro.setEditable(false);
		txtNumRetiro.setColumns(10);
		txtNumRetiro.setBounds(121, 57, 101, 21);
		contentPane.add(txtNumRetiro);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPLETAR DATOS:", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(20, 93, 520, 80);
		contentPane.add(panel);
		
		lblCodMatricula = new JLabel("Cod. Matricula");
		lblCodMatricula.setForeground(Color.BLACK);
		lblCodMatricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodMatricula.setBounds(10, 41, 90, 15);
		panel.add(lblCodMatricula);
		
		txtCodMatricula = new JTextField();
		txtCodMatricula.setColumns(10);
		txtCodMatricula.setBounds(97, 39, 90, 20);
		panel.add(txtCodMatricula);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha.setBounds(256, 41, 36, 15);
		panel.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(302, 39, 75, 20);
		panel.add(txtFecha);
		
		lblHora = new JLabel("Hora:");
		lblHora.setForeground(Color.BLACK);
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHora.setBackground(Color.WHITE);
		lblHora.setBounds(387, 41, 46, 14);
		panel.add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setColumns(10);
		txtHora.setBounds(443, 39, 67, 20);
		panel.add(txtHora);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 184, 520, 116);
		contentPane.add(scrollPane);
		
		tblAdicRetiro = new JTable();
		tblAdicRetiro.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblAdicRetiro);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setToolTipText("Registrar nuevo alumno");
		btnVolver.setForeground(Color.DARK_GRAY);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(21, 332, 89, 25);
		contentPane.add(btnVolver);
		
		btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(this);
		btnInicio.setToolTipText("Registrar nuevo alumno");
		btnInicio.setForeground(Color.DARK_GRAY);
		btnInicio.setBackground(Color.WHITE);
		btnInicio.setBounds(121, 332, 89, 25);
		contentPane.add(btnInicio);
		
		//columnas para la tabla
		modelo.addColumn("Cod.Retiro");
		modelo.addColumn("Cod.Matricula");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		
		//Asignar el modelo a la tabla
		tblAdicRetiro.setModel(modelo);
		
		//Para fecha y hora
		txtFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		txtHora.setText(new SimpleDateFormat("hh:mm:ss").format(new Date()));
		
		btnBuscarAlumno = new JButton("");
		btnBuscarAlumno.addActionListener(this);
		btnBuscarAlumno.setIcon(new ImageIcon(regisAdicRetiro.class.getResource("/iconos/lupa2.png")));
		btnBuscarAlumno.setBackground(Color.WHITE);
		btnBuscarAlumno.setBounds(197, 38, 28, 28);
		panel.add(btnBuscarAlumno);
		
		listarRetiros();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarAlumno) {
			actionPerformedBtnBuscarAlumno(e);
		}
		if (e.getSource() == btnNuevoRetiro) {
			actionPerformedBtnNuevoRetiro(e);
		}
		if (e.getSource() == btnAdicRetiro) {
			actionPerformedBtnAdicRetiro(e);
		}

		if (e.getSource() == btnInicio) {
			actionPerformedBtnInicio(e);
		}
		if (e.getSource() == btnVolver) {
			actionPerformedBtnVolver(e);
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

	protected void actionPerformedBtnNuevoRetiro(ActionEvent e) {
		txtCodMatricula.setText("");
		txtNumRetiro.setText("" + arRetiro.generarCodigo());
	}
	protected void actionPerformedBtnAdicRetiro(ActionEvent e) {
		try {
			Matricula m	= arMatricula.buscarMatricula(Metodos.getEntero(txtCodMatricula));
			Alumno a = arAlumno.buscarAlumno(m.getCodAlumno());
			Retiro r = arRetiro.buscarMatricula(Metodos.getEntero(txtCodMatricula));
			//Declaramos las variables y obtenemos los datos en ellas.
			String codigoRetiro 	= txtNumRetiro.getText();
			String codigoMatricula	= txtCodMatricula.getText();
			String fecha			= Metodos.getTexto(txtFecha);
			String hora				= new SimpleDateFormat("hh:mm:ss").format(new Date());
				
			if(r==null){
				int i = JOptionPane.showConfirmDialog(this, "¿Está seguro de realizar el retiro?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (i == 0) {	
					Retiro reti = new Retiro(Integer.parseInt(codigoRetiro), Integer.parseInt(codigoMatricula), fecha, hora);
					arRetiro.addRetiro(reti);
					a.setEstado(2);
					arRetiro.exportarRetiro();
					listarRetiros();
					arAlumno.exportarAlumno();
					arMatricula.exportarMatriculas();
					JOptionPane.showMessageDialog(this, "El retiro ha sido creado exitosamente!", "Guardado Exitoso!", JOptionPane.INFORMATION_MESSAGE, null);
				}
			}
			else{
				Metodos.mensajeError("El alumno ya fue retirado", "Alerta!");
			}
		}catch(Exception e2) {
			Metodos.mensajeError("Debe considerar lo siguiente: \n1. Seleccionar el boton Nuevo.\n2. Seleccionar una Matrícula.", "Error en solicitud");
		}
	}

	
	
	void listarRetiros() {
		modelo.setRowCount(0);			
		for (int i = 0; i < arRetiro.tamanoListaRetiro(); i++) {
			Retiro re= arRetiro.getRetiros(i); 
			Object data [] = {
							re.getNumRetiro(),
							re.getNumMatricula(),
							re.getFecha(),
							re.getHora()
			};
			modelo.addRow(data);
		}
	}

	protected void actionPerformedBtnBuscarAlumno(ActionEvent e) {
		DlgBuscarMatricula buscarMatricula = new DlgBuscarMatricula();
		buscarMatricula.setLocationRelativeTo(this);
		buscarMatricula.setVisible(true);
	}
}

