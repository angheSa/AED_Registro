package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controlador.ArregloAlumno;
import entidades.Alumno;
import modulo.Metodos;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class DlgBuscarAlumno extends JDialog implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoAlumno;
	private JTable tblBuscarAlumno;
	private JButton btnBuscarAlumno;
	

	private TableRowSorter<DefaultTableModel> sorter;
	//modelo de la tabla
	DefaultTableModel modelo = new  DefaultTableModel();
	
	//Crear un objeto de la clase Alumno
	ArregloAlumno arAlumno = new ArregloAlumno();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgBuscarAlumno dialog = new DlgBuscarAlumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgBuscarAlumno() {
		setBounds(100, 100, 594, 301);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblBuscarAlumno = new JLabel("Buscar Alumno");
			lblBuscarAlumno.setBackground(new Color(51, 204, 255));
			lblBuscarAlumno.setOpaque(true);
			lblBuscarAlumno.setHorizontalAlignment(SwingConstants.CENTER);
			lblBuscarAlumno.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblBuscarAlumno.setBounds(167, 11, 248, 35);
			contentPanel.add(lblBuscarAlumno);
		}
		{
			JLabel lblCodigoAlumno = new JLabel("Código Alumno:");
			lblCodigoAlumno.setBackground(new Color(255, 255, 255));
			lblCodigoAlumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCodigoAlumno.setBounds(10, 67, 95, 14);
			contentPanel.add(lblCodigoAlumno);
		}
		{
			txtCodigoAlumno = new JTextField();
			txtCodigoAlumno.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtCodigoAlumno.addKeyListener(this);
			txtCodigoAlumno.setBounds(124, 65, 112, 20);
			contentPanel.add(txtCodigoAlumno);
			txtCodigoAlumno.setColumns(10);
		}
		{
			btnBuscarAlumno = new JButton("Enviar datos");
			btnBuscarAlumno.addActionListener(this);
			btnBuscarAlumno.setIcon(null);
			btnBuscarAlumno.setForeground(Color.DARK_GRAY);
			btnBuscarAlumno.setBackground(Color.WHITE);
			btnBuscarAlumno.setBounds(448, 65, 120, 20);
			contentPanel.add(btnBuscarAlumno);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 98, 558, 132);
			contentPanel.add(scrollPane);
			
			tblBuscarAlumno = new JTable();
			tblBuscarAlumno.setForeground(new Color(255, 255, 255));
			tblBuscarAlumno.setBackground(new Color(102, 102, 102));
			tblBuscarAlumno.setFillsViewportHeight(true);
			scrollPane.setViewportView(tblBuscarAlumno);
			
		}
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		modelo.addColumn("DNI");
		modelo.addColumn("Edad");
		modelo.addColumn("Celular");
		modelo.addColumn("Estado");
		tblBuscarAlumno.setModel(modelo);
		
		tblBuscarAlumno.setAutoCreateRowSorter(true);
		
		sorter = new TableRowSorter<>(modelo);
		tblBuscarAlumno.setRowSorter(sorter);
		Metodos.listarAlumnos(modelo, arAlumno);
		
	}
	
	/*BUSCAR ALUMNO*/
	void listarAlumnos(DefaultTableModel model, ArregloAlumno lista) {
		// limpiar tabla
		model.setRowCount(0);
		// recorrer la lista de alumnos
		for (int i = 0; i < lista.tamanoListaAlumnos(); i++) {
			// almacenar el objeto alumno en una variable
			Alumno a = lista.getAlumno(i);	
			if (a.getEstado() == 1) {
				// crear un arreglo lineal con las propiedades del objeto alumno
				Object fila[] = {a.getCodAlumno(),
								 a.getNombres(),
								 a.getApellidos(),
								 a.getDni(),
								 a.getEdad(),
								 a.getCelular(),
								 a.estado()
						};
				// agregar datos a la tabla
				model.addRow(fila);		
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtCodigoAlumno) {
			keyReleasedTxtCodigoAlumno(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtCodigoAlumno(KeyEvent e) {
		filtrar();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarAlumno) {
			actionPerformedBtnBuscarAlumno(e);
		}
	}
	protected void actionPerformedBtnBuscarAlumno(ActionEvent e) {
		
		try {
			//Declarar las variables
			String cod,nombre,apellido;
			int fila ;
			//Obtener los valores
			fila=tblBuscarAlumno.getSelectedRow();
			
			cod=tblBuscarAlumno.getValueAt(fila, 0).toString();
			nombre=tblBuscarAlumno.getValueAt(fila, 1).toString();
			apellido=tblBuscarAlumno.getValueAt(fila, 2).toString();
			
			//Mostrar los datos
			regisAdicMatri.txtCodAlumno.setText(cod);
			regisAdicMatri.txtNombreAlumno.setText(nombre);
			regisAdicMatri.txtApellidos.setText(apellido);
			
			//cerrar
			dispose();		
			
			
		}
		catch (Exception e2) {
			Metodos.mensajeError("Debe seleccionar un alumno", "Error de selección");
		}
		
		
	}
	private void filtrar() {
		sorter.setRowFilter(RowFilter.regexFilter("(?i)"+txtCodigoAlumno.getText()));
	}
	
}
