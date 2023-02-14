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
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controlador.ArregloCurso;
import entidades.Curso;
import modulo.Metodos;

public class mantEditCurso extends JFrame implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JTextField txtCodEditCurso;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtNameEditCurso;
	private JTextField txtCicloEditCurso;
	private JTextField txtCreditoEditCurso;
	private JTextField txtHorasEditCurso;
	private JButton btnCancelEditCurso;
	private JButton btnSaveEditCurso;
	private JButton btnEliminarCurso;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JTable tblEditCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mantEditCurso frame = new mantEditCurso();
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
	private JButton btnListar;
	private JLabel lblNewLabel_6;
	private JTextField txtFiltroCurso;
	private TableRowSorter<DefaultTableModel> sorter;
	private JLabel lblModificarYEliminar;

	/**
	 * Create the frame.
	 */
	public mantEditCurso() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Eliminar - Modificar | Mantenimeinto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 408);
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
		
		txtCodEditCurso = new JTextField();
		txtCodEditCurso.setEditable(false);
		txtCodEditCurso.setBounds(141, 62, 77, 20);
		contentPane.add(txtCodEditCurso);
		txtCodEditCurso.setColumns(10);
		
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
		lblNewLabel_4.setBounds(172, 93, 60, 18);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Horas:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(341, 93, 41, 18);
		contentPane.add(lblNewLabel_5);
		
		txtNameEditCurso = new JTextField();
		txtNameEditCurso.setBounds(345, 62, 157, 20);
		contentPane.add(txtNameEditCurso);
		txtNameEditCurso.setColumns(10);
		
		txtCicloEditCurso = new JTextField();
		txtCicloEditCurso.setColumns(10);
		txtCicloEditCurso.setBounds(73, 93, 77, 20);
		contentPane.add(txtCicloEditCurso);
		
		txtCreditoEditCurso = new JTextField();
		txtCreditoEditCurso.setColumns(10);
		txtCreditoEditCurso.setBounds(245, 93, 77, 20);
		contentPane.add(txtCreditoEditCurso);
		
		txtHorasEditCurso = new JTextField();
		txtHorasEditCurso.setColumns(10);
		txtHorasEditCurso.setBounds(392, 93, 77, 20);
		contentPane.add(txtHorasEditCurso);
		
		btnSaveEditCurso = new JButton("Grabar");
		btnSaveEditCurso.setBorder(null);
		btnSaveEditCurso.setBackground(Color.WHITE);
		btnSaveEditCurso.addActionListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 181, 377, 172);
		contentPane.add(scrollPane);
		
		tblEditCurso = new JTable();
		tblEditCurso.addMouseListener(this);
		tblEditCurso.setFillsViewportHeight(true);

		dataTbl.addColumn("Código");
		dataTbl.addColumn("Asignatura");
		dataTbl.addColumn("Ciclo");
		dataTbl.addColumn("Créditos");
		dataTbl.addColumn("Horas");
		tblEditCurso.setModel(dataTbl);
		
		tblEditCurso.setAutoCreateRowSorter(true);
		
		sorter = new TableRowSorter<>(dataTbl);
		tblEditCurso.setRowSorter(sorter);		
		
		
		
		Metodos.ListarCursos(dataTbl, arCurso);
		
		scrollPane.setViewportView(tblEditCurso);
		btnSaveEditCurso.setToolTipText("Registrar alumno");
		btnSaveEditCurso.setBounds(413, 230, 89, 25);
		contentPane.add(btnSaveEditCurso);
		
		btnCancelEditCurso = new JButton("Cancelar");
		btnCancelEditCurso.setBackground(Color.WHITE);
		btnCancelEditCurso.setBorder(null);
		btnCancelEditCurso.addActionListener(this);
		btnCancelEditCurso.setToolTipText("Cancelar el registro");
		btnCancelEditCurso.setBounds(413, 328, 89, 25);
		contentPane.add(btnCancelEditCurso);
		
		btnEliminarCurso = new JButton("Eliminar");
		btnEliminarCurso.setBorder(null);
		btnEliminarCurso.setBackground(Color.WHITE);
		btnEliminarCurso.addActionListener(this);
		btnEliminarCurso.setBounds(413, 280, 89, 25);
		contentPane.add(btnEliminarCurso);
		
		separator = new JSeparator();
		separator.setBounds(22, 134, 480, 2);
		contentPane.add(separator);
		
		btnListar = new JButton("Listar / Limpiar");
		btnListar.addActionListener(this);
		btnListar.setBorder(null);
		btnListar.setBackground(Color.WHITE);
		btnListar.setBounds(413, 181, 89, 25);
		contentPane.add(btnListar);
		
		lblNewLabel_6 = new JLabel("Busqueda por cualquier campo:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(22, 147, 171, 23);
		contentPane.add(lblNewLabel_6);
		
		txtFiltroCurso = new JTextField();
		txtFiltroCurso.addKeyListener(this);
		txtFiltroCurso.setBounds(203, 150, 132, 20);
		contentPane.add(txtFiltroCurso);
		txtFiltroCurso.setColumns(10);
		
		lblModificarYEliminar = new JLabel("MODIFICAR Y ELIMINAR CURSO");
		lblModificarYEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarYEliminar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblModificarYEliminar.setBounds(114, 11, 312, 35);
		contentPane.add(lblModificarYEliminar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnEliminarCurso) {
			actionPerformedBtnEliminarCurso(e);
		}
		if (e.getSource() == btnCancelEditCurso) {
			actionPerformedBtnCancelEliminarCurso(e);
		}
		if (e.getSource() == btnSaveEditCurso) {
			actionPerformedBtnSaveEliminarCurso(e);
		}
	}
	protected void actionPerformedBtnSaveEliminarCurso(ActionEvent e) {
		
		int i = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea grabar?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (i == 0) {
			try {	
				
				int codCurso    = Metodos.getEntero(txtCodEditCurso);
				int ciclo 		= Metodos.numCiclo(txtCicloEditCurso);
				String nomCurso = Metodos.getTexto(txtNameEditCurso);
				int creditos 	= Metodos.getEntero(txtCreditoEditCurso);
				int horas		= Metodos.getEntero(txtHorasEditCurso);
				
				if (nomCurso.length() < 5) {
					Metodos.mensajeError("Ingrese una asignatura válida, \nse requiere como mínimo 5 caracteres.", "Error en la Asignatura!");
				}else if (ciclo < 0) {
					Metodos.mensajeError("Seleccione un ciclo de la lista.", "Error en el ciclo del curso!");
				}else if (creditos < 0) {
					Metodos.mensajeError("La cantidad de créditos debe ser mayor a 0.", "Error en el crédito del curso!");
				}else if (horas < 0) {
					Metodos.mensajeError("La cantidad de horas debe ser mayor a 0.", "Error en las horas del curso!");
					
				}else {
				
					Curso curso = arCurso.buscarCurso(codCurso);
					curso.setAsignatura(nomCurso);
					curso.setCiclo(ciclo);
					curso.setCreditos(creditos);
					curso.setHoras(horas);
					
					Metodos.ListarCursos(dataTbl, arCurso);
					arCurso.exportarCurso();
					Metodos.limpiarCuadrosTxt(txtNameEditCurso, txtHorasEditCurso, txtCreditoEditCurso, txtCodEditCurso, txtCicloEditCurso);
					JOptionPane.showMessageDialog(this, "El curso ha sido editado con éxito!", "Guardado Exitoso!", JOptionPane.INFORMATION_MESSAGE, null);
				}
			}catch (Exception e2) {
				Metodos.mensajeError("Revisar campos a guardar", "Error en campos");
				System.out.println(e2);
			}
			
		}
		
	}
	protected void actionPerformedBtnCancelEliminarCurso(ActionEvent e) {
		
		int i = JOptionPane.showConfirmDialog(this, "¿Está seguro de cancelar?", "Alerta!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		if (i == 0) {
			mantenimiento verMant = new mantenimiento();
			verMant.setVisible(true);
			verMant.setLocationRelativeTo(null);
			dispose();
		}
	}
	protected void actionPerformedBtnEliminarCurso(ActionEvent e) {
		
		int i = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el curso?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (i == 0) {
			try {
				int codCurso = Metodos.getEntero(txtCodEditCurso);
				boolean validar = arCurso.cursoMatriculas(codCurso);
				if(validar == false) {
					JOptionPane.showMessageDialog(this, "El cruso ha sido eliminado exitosamente!", "Eliminación Exitosa!", JOptionPane.INFORMATION_MESSAGE, null);
					arCurso.delCurso(codCurso);
					arCurso.exportarCurso();
					Metodos.ListarCursos(dataTbl, arCurso);
					Metodos.limpiarCuadrosTxt(txtNameEditCurso, txtHorasEditCurso, txtCreditoEditCurso, txtCodEditCurso, txtCicloEditCurso);
				}else {
					Metodos.mensajeError("No se puede eliminar cursos con matriculas", "Error al procesar la solicitud");
				}
			}
			catch (Exception e2) {
				Metodos.mensajeError("Debe seleccionar un curso directamente de la tabla.", "Error al procesar la solicitud");
				System.out.println(e2);
			}
			
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblEditCurso) {
			mouseClickedTblEditCurso(e);
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
	protected void mouseClickedTblEditCurso(MouseEvent e) {
		
		int i = JOptionPane.showConfirmDialog(null, "¿Desea modificar este registro?","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
		if (i == 0) {
			try {
				int seleccion = tblEditCurso.getSelectedRow();
				txtCodEditCurso.setText(String.valueOf(tblEditCurso.getValueAt(seleccion, 0)));
				txtNameEditCurso.setText(String.valueOf(tblEditCurso.getValueAt(seleccion, 1)));
				txtCicloEditCurso.setText(String.valueOf(tblEditCurso.getValueAt(seleccion, 2)));
				txtCreditoEditCurso.setText(String.valueOf(tblEditCurso.getValueAt(seleccion, 3)));
				txtHorasEditCurso.setText(String.valueOf(tblEditCurso.getValueAt(seleccion, 4)));
			}catch(Exception e2) {
				Metodos.mensajeError("Debe seleccionar una fila", "Error de selección");
			}
			
		}
	}
	
	
	
	
	
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtFiltroCurso) {
			keyReleasedTxtFiltroCurso(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtFiltroCurso(KeyEvent e) {
		filtrar();
	}
	
	private void filtrar() {
		sorter.setRowFilter(RowFilter.regexFilter("(?i)"+txtFiltroCurso.getText()));
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		Metodos.ListarCursos(dataTbl, arCurso);
		Metodos.limpiarCuadrosTxt(txtHorasEditCurso, txtNameEditCurso, txtCreditoEditCurso, txtCicloEditCurso, txtCodEditCurso);
	}
}
