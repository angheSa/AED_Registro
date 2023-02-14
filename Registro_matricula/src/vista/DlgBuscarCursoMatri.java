package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloCurso;
import entidades.Curso;

public class DlgBuscarCursoMatri extends JDialog implements ActionListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	
	//modelo de la tabla
			DefaultTableModel modelo = new  DefaultTableModel();
			
			//Crear un objeto de la clase Alumno
			ArregloCurso arCurso = new ArregloCurso();
			private JLabel lblCiclo;
			private JLabel lblBuscarCurso;
			@SuppressWarnings("rawtypes")
			private JComboBox cboCiclo;
			private JButton btnEnviarDatos;
			private JScrollPane scrollPane;
			private JTable tblBuscarCurso;

	/**
	 * Launch the application.
	 */
			
			
	public static void main(String[] args) {
		try {
			DlgBuscarCursoMatri dialog = new DlgBuscarCursoMatri();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DlgBuscarCursoMatri() {
		setBounds(100, 100, 529, 268);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblCiclo = new JLabel("Ciclo:");
		lblCiclo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCiclo.setBounds(10, 60, 46, 14);
		contentPanel.add(lblCiclo);
		
		lblBuscarCurso = new JLabel("Buscar Curso");
		lblBuscarCurso.setOpaque(true);
		lblBuscarCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarCurso.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBuscarCurso.setBackground(new Color(51, 204, 255));
		lblBuscarCurso.setBounds(119, 11, 248, 35);
		contentPanel.add(lblBuscarCurso);
		
		cboCiclo = new JComboBox();
		cboCiclo.addItemListener(this);
		cboCiclo.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Ciclo", "Primer Ciclo", "Segundo Ciclo", "Tercer Ciclo", "Cuarto Ciclo", "Quinto Ciclo", "Sexto Ciclo"}));
		cboCiclo.setBounds(66, 57, 145, 22);
		contentPanel.add(cboCiclo);
		
		btnEnviarDatos = new JButton("Enviar datos");
		btnEnviarDatos.addActionListener(this);
		btnEnviarDatos.setForeground(Color.DARK_GRAY);
		btnEnviarDatos.setBackground(Color.WHITE);
		btnEnviarDatos.setBounds(377, 57, 109, 23);
		contentPanel.add(btnEnviarDatos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 476, 122);
		contentPanel.add(scrollPane);
		
		tblBuscarCurso = new JTable();
		tblBuscarCurso.setForeground(Color.WHITE);
		tblBuscarCurso.setFillsViewportHeight(true);
		tblBuscarCurso.setBackground(new Color(105, 105, 105));
		scrollPane.setViewportView(tblBuscarCurso);
		
		modelo.addColumn("Código");
		modelo.addColumn("Asignatura");
		modelo.addColumn("Ciclo");
		modelo.addColumn("Créditos");
		modelo.addColumn("Horas");
		
		tblBuscarCurso.setModel(modelo);
	}
	/*BUSCAR CURSO*/
	void buscarCurso( int ciclo) {
		modelo.setRowCount(0);
		for (int i = 0; i < arCurso.tamanoListaCursos(); i++) {
			Curso c = arCurso.getCurso(i);
			if(c.getCiclo()==ciclo-1){
				Object data[] = {c.getCodCurso(),
								 c.getAsignatura(),
								 c.nombreCiclo(),
								 c.getCreditos(),
								 c.getHoras()
								};
			modelo.addRow(data);
			}
		}	
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviarDatos) {
			actionPerformedBtnEnviarDatos(e);
		}
	}
	protected void actionPerformedBtnEnviarDatos(ActionEvent e) {
		//Declaramos variables
				String cod;
				int fila;
				
				//Obtener valores
				fila= tblBuscarCurso.getSelectedRow();
				cod   = tblBuscarCurso.getValueAt(fila, 0).toString();
					
				//Mostrar los valores obtenidos
				regisEditMatri.txtCodCurso.setText(cod);
				
				//cerrar
				dispose();
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCiclo) {
			itemStateChangedCboCiclo(e);
		}
	}
	protected void itemStateChangedCboCiclo(ItemEvent e) {
		buscarCurso(cboCiclo.getSelectedIndex());
	}
}
