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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloCurso;
import entidades.Curso;
import modulo.Metodos;

@SuppressWarnings("serial")
public class mantAdicCurso extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JTextField txtCodNewCurso;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtNameNewCurso;
	private JTextField txtCreditoNewCurso;
	private JTextField txtHorasNewCurso;
	private JButton btnCancelNewCurso;
	private JButton btnSaveNewCurso;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JTable tblAdicCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mantAdicCurso frame = new mantAdicCurso();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private DefaultTableModel dataTbl = new DefaultTableModel();
	ArregloCurso arCurso = new ArregloCurso();
	@SuppressWarnings("rawtypes")
	private JComboBox cmbCiclo;
	private JLabel lblAdicionarCurso;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public mantAdicCurso() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Adicionar Curso | Mantenimiento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 352);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 226, 200));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Código del Curso:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(22, 64, 109, 18);
		contentPane.add(lblNewLabel_1);
		
		txtCodNewCurso = new JTextField();
		txtCodNewCurso.setBounds(141, 62, 77, 20);
		contentPane.add(txtCodNewCurso);
		txtCodNewCurso.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Asignatura:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(258, 64, 77, 18);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Ciclo:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(22, 93, 41, 18);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Créditos:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(182, 93, 60, 18);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Horas:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(351, 93, 41, 18);
		contentPane.add(lblNewLabel_5);
		
		txtNameNewCurso = new JTextField();
		txtNameNewCurso.setBounds(345, 62, 157, 20);
		contentPane.add(txtNameNewCurso);
		txtNameNewCurso.setColumns(10);
		
		txtCreditoNewCurso = new JTextField();
		txtCreditoNewCurso.setColumns(10);
		txtCreditoNewCurso.setBounds(255, 93, 77, 20);
		contentPane.add(txtCreditoNewCurso);
		
		txtHorasNewCurso = new JTextField();
		txtHorasNewCurso.setColumns(10);
		txtHorasNewCurso.setBounds(402, 93, 77, 20);
		contentPane.add(txtHorasNewCurso);
		
		btnSaveNewCurso = new JButton("Grabar");
		btnSaveNewCurso.setBorder(null);
		btnSaveNewCurso.setBackground(Color.WHITE);
		btnSaveNewCurso.addActionListener(this);
		
		cmbCiclo = new JComboBox();
		cmbCiclo.setBackground(Color.WHITE);
		cmbCiclo.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto"}));
		cmbCiclo.setBounds(63, 93, 99, 22);
		contentPane.add(cmbCiclo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 147, 400, 152);
		contentPane.add(scrollPane);
		
		tblAdicCurso = new JTable();
		tblAdicCurso.setFillsViewportHeight(true);
		
		dataTbl.addColumn("Código");
		dataTbl.addColumn("Asignatura");
		dataTbl.addColumn("Ciclo");
		dataTbl.addColumn("Créditos");
		dataTbl.addColumn("Horas");
		tblAdicCurso.setModel(dataTbl);
		
		Metodos.ListarCursos(dataTbl, arCurso);
		
		
		scrollPane.setViewportView(tblAdicCurso);
		btnSaveNewCurso.setToolTipText("Registrar alumno");
		btnSaveNewCurso.setBounds(432, 183, 70, 25);
		contentPane.add(btnSaveNewCurso);
		
		btnCancelNewCurso = new JButton("Cancelar");
		btnCancelNewCurso.setBackground(Color.WHITE);
		btnCancelNewCurso.setBorder(null);
		btnCancelNewCurso.addActionListener(this);
		btnCancelNewCurso.setToolTipText("Cancelar el registro");
		btnCancelNewCurso.setBounds(432, 238, 70, 25);
		contentPane.add(btnCancelNewCurso);
		
		separator = new JSeparator();
		separator.setBounds(22, 134, 480, 2);
		contentPane.add(separator);
		
		lblAdicionarCurso = new JLabel("ADICIONAR CURSO");
		lblAdicionarCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarCurso.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblAdicionarCurso.setBounds(101, 11, 312, 35);
		contentPane.add(lblAdicionarCurso);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelNewCurso) {
			actionPerformedBtnCancelNewCurso(e);
		}
		if (e.getSource() == btnSaveNewCurso) {
			actionPerformedBtnSaveNewCurso(e);
		}
	}
	protected void actionPerformedBtnSaveNewCurso(ActionEvent e) {
			try {
				
					int codCurso    = Metodos.getEntero(txtCodNewCurso);
					String nomCurso = Metodos.getTexto(txtNameNewCurso);
					int ciclo 		= cmbCiclo.getSelectedIndex()-1;
					int creditos 	= Metodos.getEntero(txtCreditoNewCurso);
					int horas		= Metodos.getEntero(txtHorasNewCurso);
					
					// validar campos con valores incorrectos
					if ((Integer.toString(codCurso).length()) != 4) {
						Metodos.mensajeError("Ingrese un código de curso válido, \nsolo se admiten 4 digitos.", "Error en el código!");
					}else if (Metodos.validarCodCurso(arCurso, codCurso) == false) {
						 Metodos.mensajeError("Ya existe este código de curso, \ningrese un código diferente", "Error por duplicidad de código");
					}else if (nomCurso.length() < 5) {
						 Metodos.mensajeError("Ingrese una asignatura válida, \nse requiere como mínimo 5 caracteres.", "Error en la Asignatura!");
					}else if (ciclo < 0) {
						Metodos.mensajeError("Seleccione un ciclo de la lista.", "Error en el ciclo del curso!");
					}else if (creditos < 0) {
						Metodos.mensajeError("La cantidad de créditos debe ser mayor a 0.", "Error en el crédito del curso!");
					}else if (horas < 0) {
						Metodos.mensajeError("La cantidad de horas debe ser mayor a 0.", "Error en las horas del curso!");
						
					}else {
						
						int i = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea grabar?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (i == 0) {							
							//insertando datos al arreglo
							
							arCurso.addCurso(new Curso(codCurso, ciclo, creditos, horas, nomCurso));
							Metodos.ListarCursos(dataTbl, arCurso);
							Metodos.limpiarCuadrosTxt(txtHorasNewCurso, txtNameNewCurso, txtHorasNewCurso, txtCreditoNewCurso, txtCodNewCurso);
							arCurso.exportarCurso();
							
							JOptionPane.showMessageDialog(this, "El cruso ha sido creado exitosamente!", "Guardado Exitoso!", JOptionPane.INFORMATION_MESSAGE, null);
						}
					}
			}
			catch (Exception e2) {
				
				Metodos.mensajeError("Tomar en cuenta lo siguiente:\n1. No se permite campos vacíos.\n2. Verificar el tipo de dato ingresado.", "Error!");
			}

		
	}
	protected void actionPerformedBtnCancelNewCurso(ActionEvent e) {
		
		int i = JOptionPane.showConfirmDialog(this, "¿Está seguro de cancelar?", "Alerta!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		if (i == 0) {
			mantenimiento verMant = new mantenimiento();
			verMant.setVisible(true);
			verMant.setLocationRelativeTo(null);
			dispose();
		}
	}
}
