package excepciones;

public class ExcepcionesPared extends Exception {
	
	private String codigo;

	public ExcepcionesPared (String codigo){
		super();
		this.codigo = codigo;
	}
	
	@Override
	public String getMessage(){
		return codigo;
	}
	
}
