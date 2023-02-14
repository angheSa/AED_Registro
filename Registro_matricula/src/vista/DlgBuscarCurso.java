package vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controlador.ArregloCurso;
import entidades.Curso;
import modulo.Metodos;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgBuscarCurso extends JDialog implements ItemListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tblBuscarCurso;

	@SuppressWarnings("rawtypes")
	private JComboBox cboCiclo;
	private JButton btnEnviarDatos;
	
	
	//modelo de la tabla
		DefaultTableModel modelo = new  DefaultTableModel();
		
		//Crear un objeto de la clase Alumno
		ArregloCurso arCurso = new ArregloCurso();
		
		
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgBuscarCurso dialog = new DlgBuscarCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DlgBuscarCurso() {
		setBounds(100, 100, 450, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblBuscarCurso = new JLabel("Buscar Curso");
			lblBuscarCurso.setBackground(new Color(51, 204, 255));;
			lblBuscarCurso.setOpaque(true);
			lblBuscarCurso.setHorizontalAlignment(SwingConstants.CENTER);
			lblBuscarCurso.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblBuscarCurso.setBounds(90, 11, 248, 35);
			contentPanel.add(lblBuscarCurso);
		}
		{
			JLabel lblCiclo = new JLabel("Ciclo:");
			lblCiclo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCiclo.setBounds(10, 60, 46, 14);
			contentPanel.add(lblCiclo);
		}
		{
			cboCiclo = new JComboBox();
			cboCiclo.addItemListener(this);
			cboCiclo.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Ciclo", "Primer Ciclo", "Segundo Ciclo", "Tercer Ciclo", "Cuarto Ciclo", "Quinto Ciclo", "Sexto Ciclo"}));
			cboCiclo.setBounds(66, 57, 145, 22);
			contentPanel.add(cboCiclo);
		}
		{
			btnEnviarDatos = new JButton("Enviar datos");
			btnEnviarDatos.addActionListener(this);
			btnEnviarDatos.setForeground(Color.DARK_GRAY);
			btnEnviarDatos.setBackground(Color.WHITE);
			btnEnviarDatos.setBounds(315, 57, 109, 23);
			contentPanel.add(btnEnviarDatos);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 90, 414, 130);
			contentPanel.add(scrollPane);
			{
				tblBuscarCurso = new JTable();
				tblBuscarCurso.setForeground(new Color(255, 255, 255));
				tblBuscarCurso.setBackground(new Color(105, 105, 105));
				tblBuscarCurso.setFillsViewportHeight(true);
				scrollPane.setViewportView(tblBuscarCurso);
			}
			
		}
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
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCiclo) {
			itemStateChangedCboCiclo(e);
		}
	}
	protected void itemStateChangedCboCiclo(ItemEvent e) {
		buscarCurso(cboCiclo.getSelectedIndex());
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviarDatos) {
			actionPerformedBtnEnviarDatos(e);
		}
	}
	protected void actionPerformedBtnEnviarDatos(ActionEvent e) {
		
		try {
			//Declaramos variables
			String cod,asig;
			int fila;
			
			//Obtener valores
			fila  = tblBuscarCurso.getSelectedRow();
			cod   = tblBuscarCurso.getValueAt(fila, 0).toString();
			asig  = tblBuscarCurso.getValueAt(fila, 1).toString();
				
			//Mostrar los valores obtenidos
			regisAdicMatri.txtCurso.setText(cod);
			regisAdicMatri.txtAsignatura.setText(asig);
			
			//cerrar
			setVisible(false);
		}catch(Exception e2) {
			Metodos.mensajeError("Debe seleccionar un curso", "Error de selección");
		}
		
	}
}
