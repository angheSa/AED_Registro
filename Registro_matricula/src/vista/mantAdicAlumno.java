package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloAlumno;
import entidades.Alumno;
import modulo.Metodos;

public class mantAdicAlumno extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JTextField txtCodNewAlum;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txtNameNewAlum;
	private JTextField txtApellNewAlum;
	private JTextField txtDniNewAlum;
	private JTextField txtEdadNewAlum;
	private JTextField txtCelNewAlum;
	private JButton btnCancelNewAlum;
	private JButton btnSaveNewAlum;
	private JScrollPane scrollPane;
	private JTable tblAdicAlumno;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mantAdicAlumno frame = new mantAdicAlumno();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private DefaultTableModel dataTbl = new DefaultTableModel();
	
	
	ArregloAlumno arAlumno = new ArregloAlumno();
	int codAlum = arAlumno.codMayor()+1;
	private JLabel lblRegistrarAlumno;

	/**
	 * Create the frame.
	 */
	public mantAdicAlumno() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Adicionar Alumno - Mantenimiento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(200, 232, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Código de Alumno:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(42, 64, 109, 18);
		contentPane.add(lblNewLabel_1);
		
		
		txtCodNewAlum = new JTextField(Integer.toString(codAlum));
		txtCodNewAlum.setEditable(false);
		txtCodNewAlum.setBounds(161, 62, 77, 20);
		contentPane.add(txtCodNewAlum);
		txtCodNewAlum.setColumns(10);
		
		
		lblNewLabel_2 = new JLabel("Nombres:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(42, 97, 109, 18);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Apellidos:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(42, 130, 109, 18);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("DNI:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(344, 64, 59, 18);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Edad:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(344, 97, 59, 18);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Celular:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(344, 130, 59, 18);
		contentPane.add(lblNewLabel_6);
		
		txtNameNewAlum = new JTextField();
		txtNameNewAlum.setBounds(161, 97, 157, 20);
		contentPane.add(txtNameNewAlum);
		txtNameNewAlum.setColumns(10);
		
		txtApellNewAlum = new JTextField();
		txtApellNewAlum.setColumns(10);
		txtApellNewAlum.setBounds(161, 130, 157, 20);
		contentPane.add(txtApellNewAlum);
		
		txtDniNewAlum = new JTextField();
		txtDniNewAlum.setColumns(10);
		txtDniNewAlum.setBounds(413, 62, 77, 20);
		contentPane.add(txtDniNewAlum);
		
		txtEdadNewAlum = new JTextField();
		txtEdadNewAlum.setColumns(10);
		txtEdadNewAlum.setBounds(413, 97, 77, 20);
		contentPane.add(txtEdadNewAlum);
		
		txtCelNewAlum = new JTextField();
		txtCelNewAlum.setColumns(10);
		txtCelNewAlum.setBounds(413, 130, 77, 20);
		contentPane.add(txtCelNewAlum);
		
		btnSaveNewAlum = new JButton("Grabar");
		btnSaveNewAlum.setBorder(null);
		btnSaveNewAlum.setBackground(Color.WHITE);
		btnSaveNewAlum.addActionListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 179, 488, 166);
		contentPane.add(scrollPane);
		
		
		
		tblAdicAlumno = new JTable();
		tblAdicAlumno.setFillsViewportHeight(true);
		
		dataTbl.addColumn("Codigo");
		dataTbl.addColumn("Nombre");
		dataTbl.addColumn("Apellido");
		dataTbl.addColumn("DNI");
		dataTbl.addColumn("Edad");
		dataTbl.addColumn("Celular");
		dataTbl.addColumn("Estado");
		tblAdicAlumno.setModel(dataTbl);

		Metodos.listarAlumnos(dataTbl, arAlumno);
		
		
		scrollPane.setViewportView(tblAdicAlumno);
		btnSaveNewAlum.setToolTipText("Registrar alumno");
		btnSaveNewAlum.setBounds(294, 356, 89, 25);
		contentPane.add(btnSaveNewAlum);
		
		
		btnCancelNewAlum = new JButton("Cancelar");
		btnCancelNewAlum.setBorder(null);
		btnCancelNewAlum.setBackground(Color.WHITE);
		btnCancelNewAlum.addActionListener(this);
		btnCancelNewAlum.setToolTipText("Cancelar el registro");
		btnCancelNewAlum.setBounds(421, 356, 89, 25);
		contentPane.add(btnCancelNewAlum);
		
		separator = new JSeparator();
		separator.setBounds(22, 164, 488, 9);
		contentPane.add(separator);
		
		lblRegistrarAlumno = new JLabel("REGISTRAR ALUMNO");
		lblRegistrarAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarAlumno.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblRegistrarAlumno.setBounds(116, 20, 312, 35);
		contentPane.add(lblRegistrarAlumno);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelNewAlum) {
			actionPerformedBtnCancelNewAlum(e);
		}
		if (e.getSource() == btnSaveNewAlum) {
			actionPerformedBtnSaveNewAlum(e);
		}
	}
	protected void actionPerformedBtnSaveNewAlum(ActionEvent e) {
		
		
			
		try {
			String nombre = Metodos.getTexto(txtNameNewAlum);
			String apell  = Metodos.getTexto(txtApellNewAlum);
			String dni    = Metodos.getTexto(txtDniNewAlum);
			int edad      = Metodos.getEntero(txtEdadNewAlum);
			int celu      = Metodos.getEntero(txtCelNewAlum);
			
			// validar campos con valores incorrectos
			if (nombre.length() < 3) {
				Metodos.mensajeError("Ingrese un NOMBRE válido,\nse requiere como mínimo 3 caracteres", "Error en el nombre!");
			}else if (apell.length() < 2) {
				Metodos.mensajeError("Ingrese un APELLIDO válido,\nse requiere como mínimo 2 caracteres", "Error en el Apellido!");
			}else if (dni.length() != 8) {
				Metodos.mensajeError("DNI inválido,\nse requiere 8 digitos", "Error!");
			}else if (edad < 6) {
				Metodos.mensajeError("EDAD incorrecta", "Error!");
			}else if ((Integer.toString(celu)).length() < 9) {
				Metodos.mensajeError("Ingrese un CELULAR válido,\nse requiere 9 caracteres", "Error!");
			}else {
				
	
				int i = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea grabar?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (i == 0) {
					
					// insertando datos al arreglo
					
					arAlumno.addAlumno(new Alumno(codAlum, nombre, apell, dni, edad, celu, 0));
					Metodos.listarAlumnos(dataTbl, arAlumno);
					Metodos.limpiarCuadrosTxt(txtNameNewAlum,txtApellNewAlum,txtDniNewAlum,txtEdadNewAlum,txtCelNewAlum);

					codAlum++;
					txtCodNewAlum.setText(Integer.toString(codAlum));
					arAlumno.exportarAlumno();
					JOptionPane.showMessageDialog(this, "El alumno ha sido creado exitosamente!", "Guardado Exitoso!", JOptionPane.INFORMATION_MESSAGE, null);
				}
			}
				
		}
		catch (Exception e2) {
			 Metodos.mensajeError("Tomar en cuenta lo siguiente:\n1. No se permite campos vacíos.\n2. Verificar el tipo de dato ingresado.", "Error!");
		}
		
		
		
	}
	protected void actionPerformedBtnCancelNewAlum(ActionEvent e) {
		
		int i = JOptionPane.showConfirmDialog(null, "¿Está seguro de cancelar?", "Alerta!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		if (i == 0) {
			mantenimiento verMant = new mantenimiento();
			verMant.setVisible(true);
			verMant.setLocationRelativeTo(null);
			dispose();
		}
	}
	
	
	
}
