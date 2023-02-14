package vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class registro extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAdicMatriRegis;
	private JButton btnAdicRetRegis;
	private JButton btnEditMatriRegis;
	private JButton btnEditRetRegis;
	private JButton btnRegisAtras;
	private Canvas canvas;
	private JTextField txtReMatri;
	private JTextField txtRetiros;
	private JTextField txtAdicionar;
	private JTextField txtEditar;
	private Canvas canvas_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro frame = new registro();
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
	public registro() {
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAdicMatriRegis = new JButton("");
		btnAdicMatriRegis.setBackground(Color.WHITE);
		btnAdicMatriRegis.setIcon(new ImageIcon(registro.class.getResource("/iconos/aume.png")));
		btnAdicMatriRegis.addActionListener(this);
		btnAdicMatriRegis.setToolTipText("Agregar Matricula");
		btnAdicMatriRegis.setBounds(60, 103, 82, 71);
		btnAdicMatriRegis.setBorder(null);
		contentPane.add(btnAdicMatriRegis);
		
		btnAdicRetRegis = new JButton("");
		btnAdicRetRegis.setBackground(Color.WHITE);
		btnAdicRetRegis.setIcon(new ImageIcon(registro.class.getResource("/iconos/aume.png")));
		btnAdicRetRegis.addActionListener(this);
		btnAdicRetRegis.setToolTipText("Agregar Retiro");
		btnAdicRetRegis.setBounds(288, 103, 82, 71);
		btnAdicRetRegis.setBorder(null);
		contentPane.add(btnAdicRetRegis);
		
		btnEditMatriRegis = new JButton("");
		btnEditMatriRegis.setBackground(Color.WHITE);
		btnEditMatriRegis.setIcon(new ImageIcon(registro.class.getResource("/iconos/ed.png")));
		btnEditMatriRegis.addActionListener(this);
		btnEditMatriRegis.setToolTipText("Editar Matricula");
		btnEditMatriRegis.setBounds(60, 222, 82, 71);
		btnEditMatriRegis.setBorder(null);
		contentPane.add(btnEditMatriRegis);
		
		btnEditRetRegis = new JButton("");
		btnEditRetRegis.setBackground(Color.WHITE);
		btnEditRetRegis.setIcon(new ImageIcon(registro.class.getResource("/iconos/ed.png")));
		btnEditRetRegis.addActionListener(this);
		btnEditRetRegis.setToolTipText("Editar Retiro");
		btnEditRetRegis.setBounds(288, 222, 82, 71);
		btnEditRetRegis.setBorder(null);
		contentPane.add(btnEditRetRegis);
		
		btnRegisAtras = new JButton("Atr\u00E1s");
		btnRegisAtras.setBorder(null);
		btnRegisAtras.setBackground(Color.WHITE);
		btnRegisAtras.addActionListener(this);
		btnRegisAtras.setToolTipText("Ir a Menu Principal");
		btnRegisAtras.setBounds(172, 306, 89, 23);
		contentPane.add(btnRegisAtras);
		
		canvas = new Canvas();
		canvas.setBackground(Color.GRAY);
		canvas.setBounds(209, 233, 1, 47);
		contentPane.add(canvas);
		
		txtReMatri = new JTextField();
		txtReMatri.setToolTipText("Matrículas");
		txtReMatri.setText("MATRÍCULAS");
		txtReMatri.setHorizontalAlignment(SwingConstants.CENTER);
		txtReMatri.setForeground(new Color(0, 51, 102));
		txtReMatri.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtReMatri.setEditable(false);
		txtReMatri.setColumns(10);
		txtReMatri.setBorder(null);
		txtReMatri.setBackground(new Color(72, 209, 204));
		txtReMatri.setBounds(23, 9, 167, 47);
		contentPane.add(txtReMatri);
		
		txtRetiros = new JTextField();
		txtRetiros.setToolTipText("Retiros");
		txtRetiros.setText("RETIROS");
		txtRetiros.setHorizontalAlignment(SwingConstants.CENTER);
		txtRetiros.setForeground(new Color(0, 51, 102));
		txtRetiros.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtRetiros.setEditable(false);
		txtRetiros.setColumns(10);
		txtRetiros.setBorder(null);
		txtRetiros.setBackground(new Color(72, 209, 204));
		txtRetiros.setBounds(232, 9, 167, 47);
		contentPane.add(txtRetiros);
		
		txtAdicionar = new JTextField();
		txtAdicionar.setToolTipText("Adicionar");
		txtAdicionar.setText("Adicionar");
		txtAdicionar.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdicionar.setForeground(new Color(0, 51, 102));
		txtAdicionar.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtAdicionar.setEditable(false);
		txtAdicionar.setColumns(10);
		txtAdicionar.setBorder(null);
		txtAdicionar.setBackground(new Color(72, 209, 204));
		txtAdicionar.setBounds(152, 74, 109, 28);
		contentPane.add(txtAdicionar);
		
		txtEditar = new JTextField();
		txtEditar.setText("Editar");
		txtEditar.setToolTipText("Editar");
		txtEditar.setHorizontalAlignment(SwingConstants.CENTER);
		txtEditar.setForeground(new Color(0, 51, 102));
		txtEditar.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtEditar.setEditable(false);
		txtEditar.setColumns(10);
		txtEditar.setBorder(null);
		txtEditar.setBackground(new Color(72, 209, 204));
		txtEditar.setBounds(152, 184, 109, 28);
		contentPane.add(txtEditar);
		
		canvas_1 = new Canvas();
		canvas_1.setBackground(Color.GRAY);
		canvas_1.setBounds(209, 115, 1, 47);
		contentPane.add(canvas_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(registro.class.getResource("/iconos/fondo2.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 352);
		contentPane.add(lblNewLabel);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegisAtras) {
			actionPerformedBtnRegisAtras(e);
		}
		if (e.getSource() == btnAdicMatriRegis) {
			actionPerformedBtnAdicMatriRegis(e);
		}
		if (e.getSource() == btnEditMatriRegis) {
			actionPerformedBtnEditMatriRegis(e);
		}
		if (e.getSource() == btnAdicRetRegis) {
			actionPerformedBtnAdicRetRegis(e);
		}
		if (e.getSource() == btnEditRetRegis) {
			actionPerformedBtnEditRetRegis(e);
		}
		
	}
	protected void actionPerformedBtnAdicMatriRegis(ActionEvent e) {
		//Abriendo Registro
		regisAdicMatri verAdicMatriRegis = new regisAdicMatri();
		verAdicMatriRegis.setVisible(true);
		//centrar la ventana
		verAdicMatriRegis.setLocationRelativeTo(null);
		dispose();
	}
	protected void actionPerformedBtnEditMatriRegis(ActionEvent e) {
		//Abriendo Registro
		regisEditMatri verEditMatriRegis = new regisEditMatri();
		verEditMatriRegis.setVisible(true);
		//centrar la ventana
		verEditMatriRegis.setLocationRelativeTo(null);
		dispose();
	}
	protected void actionPerformedBtnAdicRetRegis(ActionEvent e) {
		regisAdicRetiro verAdicRetRegis = new regisAdicRetiro();
		verAdicRetRegis.setVisible(true);
		verAdicRetRegis.setLocationRelativeTo(null);
		dispose();
		}
	protected void actionPerformedBtnEditRetRegis(ActionEvent e) {
		regisEditRetiro verEditRetRegis = new regisEditRetiro();
		verEditRetRegis.setVisible(true);
		verEditRetRegis.setLocationRelativeTo(null);
		dispose();
		}

	protected void actionPerformedBtnRegisAtras(ActionEvent e) {
		//abriendo el menu principal
		menuPrincipal verMenu = new menuPrincipal();
		verMenu.setVisible(true);
		verMenu.setLocationRelativeTo(null);
		dispose();
	}	
	
}

