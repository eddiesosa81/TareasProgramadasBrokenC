package entidades;

import java.util.Date;

public class polizasEmitidas {
	String num_cotizacion;         
	String cliente;
	String nombre_corto_aseguradora;
	String desc_ramo;
	String poliza;
	String factura_aseguradora;
	String anexo;
	String mensaje;
	String cd_ramo_cotizacion;
	Date fecha_emision;
	public polizasEmitidas() {
		super();
		// TODO Auto-generated constructor stub
	}
	public polizasEmitidas(String num_cotizacion, String cliente, String nombre_corto_aseguradora, String desc_ramo,
			String poliza, String factura_aseguradora, String anexo, String mensaje, String cd_ramo_cotizacion,
			Date fecha_emision) {
		super();
		this.num_cotizacion = num_cotizacion;
		this.cliente = cliente;
		this.nombre_corto_aseguradora = nombre_corto_aseguradora;
		this.desc_ramo = desc_ramo;
		this.poliza = poliza;
		this.factura_aseguradora = factura_aseguradora;
		this.anexo = anexo;
		this.mensaje = mensaje;
		this.cd_ramo_cotizacion = cd_ramo_cotizacion;
		this.fecha_emision = fecha_emision;
	}
	public String getNum_cotizacion() {
		return num_cotizacion;
	}
	public void setNum_cotizacion(String num_cotizacion) {
		this.num_cotizacion = num_cotizacion;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getNombre_corto_aseguradora() {
		return nombre_corto_aseguradora;
	}
	public void setNombre_corto_aseguradora(String nombre_corto_aseguradora) {
		this.nombre_corto_aseguradora = nombre_corto_aseguradora;
	}
	public String getDesc_ramo() {
		return desc_ramo;
	}
	public void setDesc_ramo(String desc_ramo) {
		this.desc_ramo = desc_ramo;
	}
	public String getPoliza() {
		return poliza;
	}
	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}
	public String getFactura_aseguradora() {
		return factura_aseguradora;
	}
	public void setFactura_aseguradora(String factura_aseguradora) {
		this.factura_aseguradora = factura_aseguradora;
	}
	public String getAnexo() {
		return anexo;
	}
	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getCd_ramo_cotizacion() {
		return cd_ramo_cotizacion;
	}
	public void setCd_ramo_cotizacion(String cd_ramo_cotizacion) {
		this.cd_ramo_cotizacion = cd_ramo_cotizacion;
	}
	public Date getFecha_emision() {
		return fecha_emision;
	}
	public void setFecha_emision(Date fecha_emision) {
		this.fecha_emision = fecha_emision;
	}
	
	
	
	
}
