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

import controlador.ArregloAlumno;
import entidades.Alumno;
import modulo.Metodos;

public class mantEditAlumno extends JFrame implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JTextField txtCodEditAlum;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txtNameEditAlum;
	private JTextField txtApellEditAlum;
	private JTextField txtDniEditAlum;
	private JTextField txtEdadEditAlum;
	private JTextField txtCelEditAlum;
	private JButton btnCancelEditAlum;
	private JButton btnSaveEditAlum;
	private JButton btnEliminarNewAlum;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JTable tblEditAlumno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mantEditAlumno frame = new mantEditAlumno();
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
	private JButton btnListar;
	private JLabel lblNewLabel_7;
	private JTextField txtFiltroAlumno;
	private TableRowSorter<DefaultTableModel> sorter;
	private JLabel lblModificarYEliminar_1;

	/**
	 * Create the frame.
	 */
	public mantEditAlumno() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Eliminar - Modificar | Mantenimiento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 495);
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
		
		txtCodEditAlum = new JTextField();
		txtCodEditAlum.setEditable(false);
		txtCodEditAlum.setBounds(161, 62, 109, 20);
		contentPane.add(txtCodEditAlum);
		txtCodEditAlum.setColumns(10);
		
		txtNameEditAlum = new JTextField();
		txtNameEditAlum.setBounds(161, 97, 157, 20);
		contentPane.add(txtNameEditAlum);
		txtNameEditAlum.setColumns(10);
		
		txtApellEditAlum = new JTextField();
		txtApellEditAlum.setColumns(10);
		txtApellEditAlum.setBounds(161, 130, 157, 20);
		contentPane.add(txtApellEditAlum);
		
		txtDniEditAlum = new JTextField();
		txtDniEditAlum.setEditable(false);
		txtDniEditAlum.setColumns(10);
		txtDniEditAlum.setBounds(413, 62, 77, 20);
		contentPane.add(txtDniEditAlum);
		
		txtEdadEditAlum = new JTextField();
		txtEdadEditAlum.setColumns(10);
		txtEdadEditAlum.setBounds(413, 97, 77, 20);
		contentPane.add(txtEdadEditAlum);
		
		txtCelEditAlum = new JTextField();
		txtCelEditAlum.setColumns(10);
		txtCelEditAlum.setBounds(413, 130, 77, 20);
		contentPane.add(txtCelEditAlum);
		
		btnSaveEditAlum = new JButton("Grabar");
		btnSaveEditAlum.setBackground(Color.WHITE);
		btnSaveEditAlum.setBorder(null);
		btnSaveEditAlum.addActionListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 222, 488, 184);
		contentPane.add(scrollPane);
		
		tblEditAlumno = new JTable();
		tblEditAlumno.addMouseListener(this);
		tblEditAlumno.setFillsViewportHeight(true);

		dataTbl.addColumn("Codigo");
		dataTbl.addColumn("Nombre");
		dataTbl.addColumn("Apellido");
		dataTbl.addColumn("DNI");
		dataTbl.addColumn("Edad");
		dataTbl.addColumn("Celular");
		dataTbl.addColumn("Estado");
		tblEditAlumno.setModel(dataTbl);
		
		tblEditAlumno.setAutoCreateRowSorter(true);
		
		sorter = new TableRowSorter<>(dataTbl);
		tblEditAlumno.setRowSorter(sorter);
		
		Metodos.listarAlumnos(dataTbl, arAlumno);
		
		
		scrollPane.setViewportView(tblEditAlumno);
		btnSaveEditAlum.setToolTipText("Editar alumno");
		btnSaveEditAlum.setBounds(296, 417, 89, 25);
		contentPane.add(btnSaveEditAlum);
		
		btnCancelEditAlum = new JButton("Cancelar");
		btnCancelEditAlum.setBackground(Color.WHITE);
		btnCancelEditAlum.setBorder(null);
		btnCancelEditAlum.addActionListener(this);
		btnCancelEditAlum.setToolTipText("Cancelar la edición");
		btnCancelEditAlum.setBounds(421, 417, 89, 25);
		contentPane.add(btnCancelEditAlum);
		
		btnEliminarNewAlum = new JButton("Eliminar");
		btnEliminarNewAlum.setBorder(null);
		btnEliminarNewAlum.setBackground(Color.WHITE);
		btnEliminarNewAlum.addActionListener(this);
		btnEliminarNewAlum.setBounds(169, 417, 89, 25);
		contentPane.add(btnEliminarNewAlum);
		
		separator = new JSeparator();
		separator.setBounds(22, 164, 488, 9);
		contentPane.add(separator);
		
		btnListar = new JButton("Listar / Limpiar");
		btnListar.addActionListener(this);
		btnListar.setBorder(null);
		btnListar.setBackground(Color.WHITE);
		btnListar.setBounds(22, 417, 89, 23);
		contentPane.add(btnListar);
		
		lblNewLabel_7 = new JLabel("Busqueda por cualquier campo:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(42, 184, 176, 18);
		contentPane.add(lblNewLabel_7);
		
		txtFiltroAlumno = new JTextField();
		txtFiltroAlumno.addKeyListener(this);
		txtFiltroAlumno.setBounds(228, 184, 109, 20);
		contentPane.add(txtFiltroAlumno);
		txtFiltroAlumno.setColumns(10);
		
		lblModificarYEliminar_1 = new JLabel("MODIFICAR Y ELIMINAR ALUMNO");
		lblModificarYEliminar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarYEliminar_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblModificarYEliminar_1.setBounds(119, 11, 312, 35);
		contentPane.add(lblModificarYEliminar_1);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnEliminarNewAlum) {
			actionPerformedBtnEliminarNewAlum(e);
		}
		if (e.getSource() == btnCancelEditAlum) {
			actionPerformedBtnCancelEditAlum(e);
		}
		if (e.getSource() == btnSaveEditAlum) {
			actionPerformedBtnSaveEditAlum(e);
		}
	}
	protected void actionPerformedBtnSaveEditAlum(ActionEvent e) {
		
		int i = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea grabar?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (i == 0) {
				try {
					
					int codigo = Metodos.getEntero(txtCodEditAlum);
					String nom = Metodos.getTexto(txtNameEditAlum);
					String ape = Metodos.getTexto(txtApellEditAlum);
					int edad   = Metodos.getEntero(txtEdadEditAlum);
					int telef  = Metodos.getEntero(txtCelEditAlum);
					
					if (nom.length() < 3) {
						Metodos.mensajeError("Ingrese un NOMBRE válido,\nse requiere como mínimo 3 caracteres", "Error en el nombre!");
					}else if (ape.length() < 2) {
						Metodos.mensajeError("Ingrese un APELLIDO válido,\nse requiere como mínimo 2 caracteres", "Error en el Apellido!");
					}else if (edad < 6) {
						Metodos.mensajeError("EDAD incorrecta", "Error!");
					}else if ((Integer.toString(telef)).length() < 9) {
						Metodos.mensajeError("Ingrese un CELULAR válido,\nse requiere 9 caracteres", "Error!");
					}else {
					
						Alumno alum = arAlumno.buscarAlumno(codigo);
						alum.setNombres(nom);
						alum.setApellidos(ape);
						alum.setEdad(edad);
						alum.setCelular(telef);
						
						Metodos.listarAlumnos(dataTbl, arAlumno);
						arAlumno.exportarAlumno();
						Metodos.limpiarConsultar(txtApellEditAlum, txtCelEditAlum, txtCodEditAlum, txtDniEditAlum, txtEdadEditAlum, txtNameEditAlum, txtApellEditAlum, txtApellEditAlum, txtNameEditAlum, txtEdadEditAlum, txtDniEditAlum, txtCodEditAlum, txtCelEditAlum, txtApellEditAlum);
						JOptionPane.showMessageDialog(this, "El alumno ha sido modificado exitosamente!", "Guardado Exitoso!", JOptionPane.INFORMATION_MESSAGE, null);
					}
				}catch (Exception e2) {
					Metodos.mensajeError("Revisar campos a guardar", "Error en campos");
					System.out.println(e2);
				}
		}
		
	}
	protected void actionPerformedBtnCancelEditAlum(ActionEvent e) {
		
		int i = JOptionPane.showConfirmDialog(this, "¿Está seguro de cancelar?", "Alerta!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		if (i == 0) {
			mantenimiento verMant = new mantenimiento();
			verMant.setVisible(true);
			verMant.setLocationRelativeTo(null);
			dispose();
		}
	}
	protected void actionPerformedBtnEliminarNewAlum(ActionEvent e) {
		
		int i = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar al Alumno?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (i == 0) {
			try {
				int codAlum = Metodos.getEntero(txtCodEditAlum);
				Alumno al = arAlumno.buscarAlumno(codAlum);
				if(al.getEstado() == 0) {
					JOptionPane.showMessageDialog(this, "El Alumno ha sido eliminado exitosamente!", "Eliminación Exitosa!", JOptionPane.INFORMATION_MESSAGE, null);
					arAlumno.delAlumno(codAlum);
					arAlumno.exportarAlumno();
					Metodos.listarAlumnos(dataTbl, arAlumno);
					Metodos.limpiarConsultar(txtApellEditAlum, txtCelEditAlum, txtCodEditAlum, txtDniEditAlum, txtEdadEditAlum, txtNameEditAlum, txtApellEditAlum, txtApellEditAlum, txtNameEditAlum, txtEdadEditAlum, txtDniEditAlum, txtCodEditAlum, txtCelEditAlum, txtApellEditAlum);
				}else {
					Metodos.mensajeError("Solo se puede eliminar alumnos con estado Registrado", "Error al procesar la solicitud");
				}
			}
			catch (Exception e2) {
				Metodos.mensajeError("Debe seleccionar un alumno.", "Error al procesar la solicitud");
				System.out.println(e2);
			}
			
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblEditAlumno) {
			mouseClickedTblEditAlumno(e);
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
	protected void mouseClickedTblEditAlumno(MouseEvent e) {
		int i = JOptionPane.showConfirmDialog(null, "¿Desea modificar este registro?","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
		if (i == 0) {
			try {
				int seleccion = tblEditAlumno.getSelectedRow();
				txtCodEditAlum.setText(String.valueOf(tblEditAlumno.getValueAt(seleccion, 0)));
				txtNameEditAlum.setText(String.valueOf(tblEditAlumno.getValueAt(seleccion, 1)));
				txtApellEditAlum.setText(String.valueOf(tblEditAlumno.getValueAt(seleccion, 2)));
				txtDniEditAlum.setText(String.valueOf(tblEditAlumno.getValueAt(seleccion, 3)));
				txtEdadEditAlum.setText(String.valueOf(tblEditAlumno.getValueAt(seleccion, 4)));
				txtCelEditAlum.setText(String.valueOf(tblEditAlumno.getValueAt(seleccion, 5)));
			}catch(Exception e2) {
				Metodos.mensajeError("Debe seleccionar una fila", "Error de selección");
			}
			
		}
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		Metodos.limpiarConsultar(txtApellEditAlum, txtCelEditAlum, txtCodEditAlum, txtDniEditAlum, txtEdadEditAlum, txtNameEditAlum, txtApellEditAlum, txtApellEditAlum, txtNameEditAlum, txtEdadEditAlum, txtDniEditAlum, txtCodEditAlum, txtCelEditAlum, txtApellEditAlum);
		Metodos.listarAlumnos(dataTbl, arAlumno);
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtFiltroAlumno) {
			keyReleasedTxtFiltroAlumno(e);
		}
	}
	
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtFiltroAlumno(KeyEvent e) {
		filtrar();
	}
	
	private void filtrar() {
		sorter.setRowFilter(RowFilter.regexFilter("(?i)"+txtFiltroAlumno.getText()));
	}
	
	
}
