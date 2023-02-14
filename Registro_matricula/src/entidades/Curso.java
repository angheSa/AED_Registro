package entidades;


public class Curso {
	//Atributos
	private int codCurso,ciclo,creditos,horas;
	private String asignatura;
	//Método constructor
	public Curso(int codCurso, int ciclo, int creditos, int horas, String asignatura) {
		this.codCurso = codCurso;
		this.ciclo = ciclo;
		this.creditos = creditos;
		this.horas = horas;
		this.asignatura = asignatura;
	}
	//Métodos de acceso ( get and set)
	public int getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}
	public int getCiclo() {
		return ciclo;
	}
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	
	
	public String nombreCiclo() {
		switch (ciclo) {
			case 0:
				return "Primero";
			case 1:
				return "Segundo";
			case 2:
				return "Tercero";
			case 3:
				return "Cuarto";
			case 4:
				return "Quinto";
			default:
				return "Sexto";
		}
	}
	

}
