package com.inabif.model;



	import java.io.Serializable;
	import java.sql.Timestamp;

	public class UsuarioModel implements Serializable {

	    private String idusuario = null;
	    private String usunombre = null;
	    private String usuldap = null;
	    private String usuclave = null;
	    private String usupersona = null;
	    private String usuestado = null;
	    private String usuregistra = null;
	    private Timestamp usufecregistra = null;
	    private String usuactualiza = null;
	    private Timestamp usufecactualiza = null;
	    private String usuelimina = null;
	    private Timestamp usufecelimina = null;

	    public UsuarioModel() {
	    }

	    public String getIdusuario() {
	        return idusuario;
	    }

	    public void setIdusuario(String idusuario) {
	        this.idusuario = idusuario;
	    }

	    public String getUsunombre() {
	        return usunombre;
	    }

	    public void setUsunombre(String usunombre) {
	        this.usunombre = usunombre;
	    }

	    public String getUsuldap() {
	        return usuldap;
	    }

	    public void setUsuldap(String usuldap) {
	        this.usuldap = usuldap;
	    }

	    public String getUsuclave() {
	        return usuclave;
	    }

	    public void setUsuclave(String usuclave) {
	        this.usuclave = usuclave;
	    }

	    public String getUsupersona() {
	        return usupersona;
	    }

	    public void setUsupersona(String usupersona) {
	        this.usupersona = usupersona;
	    }

	    public String getUsuestado() {
	        return usuestado;
	    }

	    public void setUsuestado(String usuestado) {
	        this.usuestado = usuestado;
	    }

	    public String getUsuregistra() {
	        return usuregistra;
	    }

	    public void setUsuregistra(String usuregistra) {
	        this.usuregistra = usuregistra;
	    }

	    public Timestamp getUsufecregistra() {
	        return usufecregistra;
	    }

	    public void setUsufecregistra(Timestamp usufecregistra) {
	        this.usufecregistra = usufecregistra;
	    }

	    public String getUsuactualiza() {
	        return usuactualiza;
	    }

	    public void setUsuactualiza(String usuactualiza) {
	        this.usuactualiza = usuactualiza;
	    }

	    public Timestamp getUsufecactualiza() {
	        return usufecactualiza;
	    }

	    public void setUsufecactualiza(Timestamp usufecactualiza) {
	        this.usufecactualiza = usufecactualiza;
	    }

	    public String getUsuelimina() {
	        return usuelimina;
	    }

	    public void setUsuelimina(String usuelimina) {
	        this.usuelimina = usuelimina;
	    }

	    public Timestamp getUsufecelimina() {
	        return usufecelimina;
	    }

	    public void setUsufecelimina(Timestamp usufecelimina) {
	        this.usufecelimina = usufecelimina;
	    }

	    
	    
	

}
