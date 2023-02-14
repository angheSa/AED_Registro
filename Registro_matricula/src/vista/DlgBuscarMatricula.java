package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controlador.ArregloMatricula;
import entidades.Matricula;

public class DlgBuscarMatricula extends JDialog implements KeyListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblBuscarMatrcula;
	private JLabel lblCodMatrcula;
	private JButton btnEnviarDatos;
	private JScrollPane scrollPane;
	private JTable tblBuscarMatricula;
	private JTextField txtCodMatri;

	/**
	 * Launch the application.
	 */
	private TableRowSorter<DefaultTableModel> sorter;
	//modelo de la tabla
	DefaultTableModel modelo = new  DefaultTableModel();
	
	//Crear un objeto de la clase Alumno
	ArregloMatricula arMatricula= new ArregloMatricula();
	
	public static void main(String[] args) {
		try {
			DlgBuscarMatricula dialog = new DlgBuscarMatricula();
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
	public DlgBuscarMatricula() {
		setBounds(100, 100, 516, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(255, 255, 255));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblBuscarMatrcula = new JLabel("Buscar Matrícula");
		lblBuscarMatrcula.setOpaque(true);
		lblBuscarMatrcula.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarMatrcula.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBuscarMatrcula.setBackground(new Color(51, 204, 255));
		lblBuscarMatrcula.setBounds(119, 11, 248, 35);
		contentPanel.add(lblBuscarMatrcula);
		
		lblCodMatrcula = new JLabel("Cod. Matrícula:");
		lblCodMatrcula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodMatrcula.setBounds(10, 60, 96, 14);
		contentPanel.add(lblCodMatrcula);
		
		btnEnviarDatos = new JButton("Enviar datos");
		btnEnviarDatos.addActionListener(this);
		btnEnviarDatos.setForeground(Color.DARK_GRAY);
		btnEnviarDatos.setBackground(Color.WHITE);
		btnEnviarDatos.setBounds(377, 57, 109, 23);
		contentPanel.add(btnEnviarDatos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 476, 150);
		contentPanel.add(scrollPane);
		
		tblBuscarMatricula = new JTable();
		tblBuscarMatricula.addKeyListener(this);
		tblBuscarMatricula.setOpaque(false);
		tblBuscarMatricula.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblBuscarMatricula);
		
		txtCodMatri = new JTextField();
		txtCodMatri.addKeyListener(this);
		txtCodMatri.setBounds(104, 58, 109, 20);
		contentPanel.add(txtCodMatri);
		txtCodMatri.setColumns(10);
		//columnas para la tabla
				modelo.addColumn("Matricula");
				modelo.addColumn("Cod.Alumno");
				modelo.addColumn("Cod.Curso");
				modelo.addColumn("Fecha");
				modelo.addColumn("Hora");
				
				//Asignar el modelo a la tabla
				tblBuscarMatricula.setModel(modelo);
				
				tblBuscarMatricula.setAutoCreateRowSorter(true);
				
				sorter = new TableRowSorter<>(modelo);
				tblBuscarMatricula.setRowSorter(sorter);
				listarMatriculas();
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtCodMatri) {
			keyReleasedTxtCodMatri(e);
		}

	}
	public void keyTyped(KeyEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviarDatos) {
			actionPerformedBtnEnviarDatos(e);
		}
	}
	protected void actionPerformedBtnEnviarDatos(ActionEvent e) {
		//Declarar las variables
				String cod;
				int fila ;
				//Obtener los valores
				fila=tblBuscarMatricula.getSelectedRow();
				
				cod=tblBuscarMatricula.getValueAt(fila, 0).toString();
	
				
				//Mostrar los datos
				regisAdicRetiro.txtCodMatricula.setText(cod);

				
				//cerrar
				dispose();
				
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
	protected void keyReleasedTxtCodMatri(KeyEvent e) {
		filtrar();
	}
	private void filtrar() {
		sorter.setRowFilter(RowFilter.regexFilter("(?i)"+txtCodMatri.getText()));
	}
}
