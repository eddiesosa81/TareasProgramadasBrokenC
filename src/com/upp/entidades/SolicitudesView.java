package com.upp.entidades;


public class SolicitudesView {
	private String NUM; 
	private String  SOLICITUD_ID; 
	private String  NM_EMPRESA; 
	private String  REPORTA; 
	private String  ASIGNADO; 
	private String  PROBLEMA; 
	private String  DETALLE_PROBLEMA; 
	private String  SOLUCION_TECNICA; 
	private String  ESTADO; 
	private String  ESTADOS_ID; 
	private String  FECHA; 
	private String  FECHA_ASIGNADA; 
	private String  UBICACION_ADJUNTO; 
	private String  TECNICO_ASIGNADO; 
	private String  TECNICO_REPORTA; 
	private String  FECHA_SOLUCION; 
	private String  ALMACEN_ID; 
	private String  CLIENTE_ID; 
	private String  CLIENTE_NOMBRE; 
	private String  ID_PADRE; 
	private String  NO_CASO; 
	private String  FECHA_ASIGNADA_ORIGINAL; 
	private String  APLAZADA; 
	private String  SUPERVISA; 
	private String  COMITE; 
	private String  SUB_COMITE;
	public SolicitudesView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SolicitudesView(String nUM, String sOLICITUD_ID, String nM_EMPRESA, String rEPORTA, String aSIGNADO,
			String pROBLEMA, String dETALLE_PROBLEMA, String sOLUCION_TECNICA, String eSTADO, String eSTADOS_ID,
			String fECHA, String fECHA_ASIGNADA, String uBICACION_ADJUNTO, String tECNICO_ASIGNADO,
			String tECNICO_REPORTA, String fECHA_SOLUCION, String aLMACEN_ID, String cLIENTE_ID, String cLIENTE_NOMBRE,
			String iD_PADRE, String nO_CASO, String fECHA_ASIGNADA_ORIGINAL, String aPLAZADA, String sUPERVISA,
			String cOMITE, String sUB_COMITE) {
		super();
		NUM = nUM;
		SOLICITUD_ID = sOLICITUD_ID;
		NM_EMPRESA = nM_EMPRESA;
		REPORTA = rEPORTA;
		ASIGNADO = aSIGNADO;
		PROBLEMA = pROBLEMA;
		DETALLE_PROBLEMA = dETALLE_PROBLEMA;
		SOLUCION_TECNICA = sOLUCION_TECNICA;
		ESTADO = eSTADO;
		ESTADOS_ID = eSTADOS_ID;
		FECHA = fECHA;
		FECHA_ASIGNADA = fECHA_ASIGNADA;
		UBICACION_ADJUNTO = uBICACION_ADJUNTO;
		TECNICO_ASIGNADO = tECNICO_ASIGNADO;
		TECNICO_REPORTA = tECNICO_REPORTA;
		FECHA_SOLUCION = fECHA_SOLUCION;
		ALMACEN_ID = aLMACEN_ID;
		CLIENTE_ID = cLIENTE_ID;
		CLIENTE_NOMBRE = cLIENTE_NOMBRE;
		ID_PADRE = iD_PADRE;
		NO_CASO = nO_CASO;
		FECHA_ASIGNADA_ORIGINAL = fECHA_ASIGNADA_ORIGINAL;
		APLAZADA = aPLAZADA;
		SUPERVISA = sUPERVISA;
		COMITE = cOMITE;
		SUB_COMITE = sUB_COMITE;
	}
	public String getNUM() {
		return NUM;
	}
	public void setNUM(String nUM) {
		NUM = nUM;
	}
	public String getSOLICITUD_ID() {
		return SOLICITUD_ID;
	}
	public void setSOLICITUD_ID(String sOLICITUD_ID) {
		SOLICITUD_ID = sOLICITUD_ID;
	}
	public String getNM_EMPRESA() {
		return NM_EMPRESA;
	}
	public void setNM_EMPRESA(String nM_EMPRESA) {
		NM_EMPRESA = nM_EMPRESA;
	}
	public String getREPORTA() {
		return REPORTA;
	}
	public void setREPORTA(String rEPORTA) {
		REPORTA = rEPORTA;
	}
	public String getASIGNADO() {
		return ASIGNADO;
	}
	public void setASIGNADO(String aSIGNADO) {
		ASIGNADO = aSIGNADO;
	}
	public String getPROBLEMA() {
		return PROBLEMA;
	}
	public void setPROBLEMA(String pROBLEMA) {
		PROBLEMA = pROBLEMA;
	}
	public String getDETALLE_PROBLEMA() {
		return DETALLE_PROBLEMA;
	}
	public void setDETALLE_PROBLEMA(String dETALLE_PROBLEMA) {
		DETALLE_PROBLEMA = dETALLE_PROBLEMA;
	}
	public String getSOLUCION_TECNICA() {
		return SOLUCION_TECNICA;
	}
	public void setSOLUCION_TECNICA(String sOLUCION_TECNICA) {
		SOLUCION_TECNICA = sOLUCION_TECNICA;
	}
	public String getESTADO() {
		return ESTADO;
	}
	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}
	public String getESTADOS_ID() {
		return ESTADOS_ID;
	}
	public void setESTADOS_ID(String eSTADOS_ID) {
		ESTADOS_ID = eSTADOS_ID;
	}
	public String getFECHA() {
		return FECHA;
	}
	public void setFECHA(String fECHA) {
		FECHA = fECHA;
	}
	public String getFECHA_ASIGNADA() {
		return FECHA_ASIGNADA;
	}
	public void setFECHA_ASIGNADA(String fECHA_ASIGNADA) {
		FECHA_ASIGNADA = fECHA_ASIGNADA;
	}
	public String getUBICACION_ADJUNTO() {
		return UBICACION_ADJUNTO;
	}
	public void setUBICACION_ADJUNTO(String uBICACION_ADJUNTO) {
		UBICACION_ADJUNTO = uBICACION_ADJUNTO;
	}
	public String getTECNICO_ASIGNADO() {
		return TECNICO_ASIGNADO;
	}
	public void setTECNICO_ASIGNADO(String tECNICO_ASIGNADO) {
		TECNICO_ASIGNADO = tECNICO_ASIGNADO;
	}
	public String getTECNICO_REPORTA() {
		return TECNICO_REPORTA;
	}
	public void setTECNICO_REPORTA(String tECNICO_REPORTA) {
		TECNICO_REPORTA = tECNICO_REPORTA;
	}
	public String getFECHA_SOLUCION() {
		return FECHA_SOLUCION;
	}
	public void setFECHA_SOLUCION(String fECHA_SOLUCION) {
		FECHA_SOLUCION = fECHA_SOLUCION;
	}
	public String getALMACEN_ID() {
		return ALMACEN_ID;
	}
	public void setALMACEN_ID(String aLMACEN_ID) {
		ALMACEN_ID = aLMACEN_ID;
	}
	public String getCLIENTE_ID() {
		return CLIENTE_ID;
	}
	public void setCLIENTE_ID(String cLIENTE_ID) {
		CLIENTE_ID = cLIENTE_ID;
	}
	public String getCLIENTE_NOMBRE() {
		return CLIENTE_NOMBRE;
	}
	public void setCLIENTE_NOMBRE(String cLIENTE_NOMBRE) {
		CLIENTE_NOMBRE = cLIENTE_NOMBRE;
	}
	public String getID_PADRE() {
		return ID_PADRE;
	}
	public void setID_PADRE(String iD_PADRE) {
		ID_PADRE = iD_PADRE;
	}
	public String getNO_CASO() {
		return NO_CASO;
	}
	public void setNO_CASO(String nO_CASO) {
		NO_CASO = nO_CASO;
	}
	public String getFECHA_ASIGNADA_ORIGINAL() {
		return FECHA_ASIGNADA_ORIGINAL;
	}
	public void setFECHA_ASIGNADA_ORIGINAL(String fECHA_ASIGNADA_ORIGINAL) {
		FECHA_ASIGNADA_ORIGINAL = fECHA_ASIGNADA_ORIGINAL;
	}
	public String getAPLAZADA() {
		return APLAZADA;
	}
	public void setAPLAZADA(String aPLAZADA) {
		APLAZADA = aPLAZADA;
	}
	public String getSUPERVISA() {
		return SUPERVISA;
	}
	public void setSUPERVISA(String sUPERVISA) {
		SUPERVISA = sUPERVISA;
	}
	public String getCOMITE() {
		return COMITE;
	}
	public void setCOMITE(String cOMITE) {
		COMITE = cOMITE;
	}
	public String getSUB_COMITE() {
		return SUB_COMITE;
	}
	public void setSUB_COMITE(String sUB_COMITE) {
		SUB_COMITE = sUB_COMITE;
	}
	
	
}
