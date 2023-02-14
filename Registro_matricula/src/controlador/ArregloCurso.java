package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import entidades.Curso;

public class ArregloCurso {
	
		// declarar arreglo
		private ArrayList<Curso> listaCursos;
		
		// crear constructor
		public ArregloCurso() {
			listaCursos = new ArrayList<Curso>();
			
			// insertando data de prueba
			
			/*
			listaCursos.add(new Curso(1001, 0, 3, 58, "Algoritmia"));
			listaCursos.add(new Curso(1002, 1, 2, 48, "SQL Server"));
			listaCursos.add(new Curso(1003, 2, 2, 45, "Matemática"));
			
			
			//datos de prueba

		lista.add(new Curso(1001, "Algoritmos y Estructuras de Datos", 1, 5, 4));

		lista.add(new Curso(1001, "Desarrollo de Entornos Web", 1, 4, 3));

		lista.add(new Curso(1001, "Base de Datos", 1, 5, 8));

		lista.add(new Curso(1001, "Matemática II", 1, 3, 4));

		lista.add(new Curso(1001, "Modelado de Procesos de negocio", 1, 3, 5));

		lista.add(new Curso(1001, "Arquitectura de Entorno web", 0, 5, 8));

		lista.add(new Curso(1001, "Desarrollo Personal I", 0, 5, 8));

		lista.add(new Curso(1001, "Introducción a la Algoritmia", 0, 5, 8));

		lista.add(new Curso(1001, "Matemática I", 0, 5, 8));

		lista.add(new Curso(1001, "Tecnologías de la Información", 0, 5, 8));
			*/
			importarCursos();
		}
		
		
		// metodos necesarios
		
		public void addCurso(Curso c) {
			// agregar alumno
			listaCursos.add(c);
		}
		
		public int tamanoListaCursos() {
			// cantidad de alumnos
			return listaCursos.size();
		}
		
		public Curso getCurso(int i) {
			// retornar un objeto alumnos
			return listaCursos.get(i);
		}
		
		// eliminar Curso
		public void delCurso(int codigo) {
			for (int i = 0; i < tamanoListaCursos(); i++) {
				if(getCurso(i).getCodCurso() == codigo)
					listaCursos.remove(i);
			}
		}
		
		//validar curso con matriculas
		public boolean cursoMatriculas(int codigo) {
			ArregloMatricula arMatri = new ArregloMatricula();
			for (int i = 0; i < arMatri.tamanoListaMatriculas(); i++) {
				if (arMatri.getMatriculas(i).getCodCurso() == codigo)
					return true;
			}
			return false;
		}
		
		public Curso buscarCurso(int codigoCurso) {
			for (int i=0; i<tamanoListaCursos(); i++)
				if (getCurso(i).getCodCurso() == codigoCurso)
					return getCurso(i);
			return null;
		}
		
		// exportar cursos a cursos.txt
		public void exportarCurso() {
			
			PrintWriter pw;
			try {
				
				pw = new PrintWriter(new FileWriter("cursos.txt"));

				Curso curso;
				int cod,ciclo,cred,hrs;
				String nom;
				
				for (int i = 0; i < listaCursos.size(); i++) {
					
					curso = listaCursos.get(i);
					
					cod = curso.getCodCurso();
					ciclo = curso.getCiclo();
					cred = curso.getCreditos();
					hrs = curso.getHoras();
					nom = curso.getAsignatura();
					
					
					pw.println(cod+","+nom+","+ciclo+","+cred+","+hrs);
					
				}
				
				pw.close();
			}catch (IOException e) {
				
				e.printStackTrace();
			 }			
		}
		
		
		// importar cursos de cursos.txt
		private void importarCursos() {
			
			try {
				
				Curso curso;
				String linea, sep[];
				
				BufferedReader br = new BufferedReader(new FileReader("cursos.txt"));
				
				while ((linea = br.readLine()) != null) {
					
					sep = linea.split(",");
					
					curso = new Curso(Integer.parseInt(sep[0]), Integer.parseInt(sep[2]), Integer.parseInt(sep[3]), Integer.parseInt(sep[4]), sep[1]);
				
					listaCursos.add(curso);
				}
				
				br.close();
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
				
}
