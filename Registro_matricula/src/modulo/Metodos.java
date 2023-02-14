package modulo;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloAlumno;
import controlador.ArregloCurso;
import entidades.Alumno;
import entidades.Curso;





public class Metodos {
		
		// captura un texto de un cuadro de texto
		public static String getTexto(JTextField x) {
			return x.getText();
		}
		
		// captura un entero de un cuadro de texto
		public static int getEntero(JTextField x) {
			return Integer.parseInt(x.getText());
		}
		
		// captura un double de un cuadro de texto
		public static double getDouble(JTextField x) {
			return Double.parseDouble(x.getText());
		}
		
		// envía un texto a un cuadro de texto
		public static void setTexto(JTextField cuadro, String cadena) {
			cuadro.setText(cadena);
		}
		
		// envía un entero a un cuadro de texto
		public static void setEntero(JTextField cuadro, int entero) {
			cuadro.setText(Integer.toString(entero));
		}
		
		// envía un double a un cuadro de texto
		public static void setDouble(JTextField cuadro, double numDouble) {
			cuadro.setText(Double.toString(numDouble));
		}
		
		
		public static void limpiarCuadrosTxt(JTextField a,JTextField b,JTextField c,JTextField d,JTextField e) {
			a.setText("");
			b.setText("");
			c.setText("");
			d.setText("");
			e.setText("");
		}
		
		//Limpiar cuadro de consultar
		public static void limpiarConsultar(JTextField a,JTextField b,JTextField c,JTextField d,JTextField e,
				JTextField f,JTextField g,JTextField h,JTextField i,JTextField j,JTextField k,JTextField l, JTextField m, JTextField p) {
			a.setText("");
			b.setText("");
			c.setText("");
			d.setText("");
			e.setText("");
			f.setText("");
			g.setText("");
			h.setText("");
			i.setText("");
			j.setText("");
			k.setText("");
			l.setText("");
			m.setText("");
			p.setText("");
	
		}
		
		
		
		// listar alumnos en la tabla
		public static void listarAlumnos(DefaultTableModel model, ArregloAlumno lista) {
			// limpiar tabla
			model.setRowCount(0);
			// recorrer la lista de alumnos
			for (int i = 0; i < lista.tamanoListaAlumnos(); i++) {
				// almacenar el objeto alumno en una variable
				Alumno a = lista.getAlumno(i);			
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
		
		
		
		// listar cursos en tabla
		public static void ListarCursos(DefaultTableModel model,ArregloCurso lista) {
			// limpiar tabla
			model.setRowCount(0);
			//recorrer lista de cursos
			for (int i = 0; i < lista.tamanoListaCursos(); i++) {
				// almacenar el objeto curso en una variable
				Curso c = lista.getCurso(i);
				// crear arreglo linear con las propiedades del objeto curso
				Object fila[] = {c.getCodCurso(),
								 c.getAsignatura(),
								 c.nombreCiclo(),
								 c.getCreditos(),
								 c.getHoras()
						};
				// agregar datos a la tabla
				model.addRow(fila);
				
			}	
		}
		
		
		
		
		// validar duplicidad del codigo
		public static boolean validarCodCurso(ArregloCurso lista, int codCurso) {
			// recorrer lista de cursos
			for (int i = 0; i < lista.tamanoListaCursos(); i++) {
				// almaceno el objeto curso en una variable
				Curso c = lista.getCurso(i);
				if(c.getCodCurso() == codCurso)		return false;
			}
			return true;
		}
		
		
		//mensaje de error editable
		public static int mensajeError(String mensaje, String titulo) {
			return JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
		}
		
		
		public static int obtenerCodiAlumno(JTextField z) {
			return Metodos.getEntero(z);
		}
		public static void limpiarCuadrosCuatro(JTextField a,JTextField b,JTextField c,JTextField d) {
			a.setText("");
			b.setText("");
			c.setText("");
			d.setText("");
		}
		
		
		// numero de ciclo en entero
		public static int numCiclo(JTextField j) {
			switch (j.getText()) {
				case "Primero":
					return 0;
				case "Segundo":
					return 1;
				case "Tercero":
					return 2;
				case "Cuarto":
					return 3;
				case "Quinto":
					return 4;
				default:
					return 5;
			}
		}
		
}
