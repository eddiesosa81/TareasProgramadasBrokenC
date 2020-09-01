package com.upp.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.upp.entidades.SolicitudesView;
import com.upp.entidades.UsuariosAsignados;

import controladores.EmailSenderService;


public class ServicioSolicitudesView {

	private EmailSenderService email;

	@SuppressWarnings("unchecked")
	public List<SolicitudesView> consSolicitudActivasxRepo(String asignado) {
		Connection conn;
		List<SolicitudesView> lstSolicitudes= new ArrayList<SolicitudesView>();
		String sql;
		try {
			conn = ConectarBaseUpp.getOracleConnection();
			sql = "select * from MSHD_SOLICITUDES_VIEW where estado = 'ACTIVO' "
					+ "and trim(asignado) = trim('"+asignado+"') "
					+ "and fechajuliana_func(fecha_asignada)  <= fechajuliana_func(to_char(sysdate,'dd/mm/yyyy'))"
					+ " order by fecha_asignada";
			System.out.println("QUERY ->"+sql);
			PreparedStatement a = conn.prepareStatement(sql);
			ResultSet res = a.executeQuery();
			while (res.next()) {

				SolicitudesView mae = new SolicitudesView();
				mae.setALMACEN_ID(res.getString("ALMACEN_ID"));
				mae.setAPLAZADA(res.getString("APLAZADA"));
				mae.setASIGNADO(res.getString("ASIGNADO"));
				mae.setCLIENTE_ID(res.getString("CLIENTE_ID"));
				mae.setCLIENTE_NOMBRE(res.getString("CLIENTE_NOMBRE"));
				mae.setCOMITE(res.getString("COMITE"));
				mae.setDETALLE_PROBLEMA(res.getString("DETALLE_PROBLEMA"));
				mae.setESTADO(res.getString("ESTADO"));
				mae.setESTADOS_ID(res.getString("ESTADOS_ID"));
				mae.setFECHA(res.getString("FECHA"));
				mae.setFECHA_ASIGNADA(res.getString("FECHA_ASIGNADA"));
				mae.setFECHA_ASIGNADA_ORIGINAL(res.getString("FECHA_ASIGNADA_ORIGINAL"));
				mae.setFECHA_SOLUCION(res.getString("FECHA_SOLUCION"));
				mae.setID_PADRE(res.getString("ID_PADRE"));
				mae.setNM_EMPRESA(res.getString("NM_EMPRESA"));
				mae.setNO_CASO(res.getString("NO_CASO"));
				mae.setNUM(res.getString("NUM"));
				mae.setPROBLEMA(res.getString("PROBLEMA"));
				mae.setREPORTA(res.getString("REPORTA"));
				mae.setSOLICITUD_ID(res.getString("SOLICITUD_ID"));
				mae.setSOLUCION_TECNICA(res.getString("SOLUCION_TECNICA"));
				mae.setSUB_COMITE(res.getString("SUB_COMITE"));
				mae.setSUPERVISA(res.getString("SUPERVISA"));
				mae.setTECNICO_ASIGNADO(res.getString("TECNICO_ASIGNADO"));
				mae.setTECNICO_REPORTA(res.getString("TECNICO_REPORTA"));
				mae.setUBICACION_ADJUNTO(res.getString("UBICACION_ADJUNTO"));
				lstSolicitudes.add(mae);
			}
			res.close();
			a.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error al conectarse");
		}
		return lstSolicitudes;
	}
	@SuppressWarnings("unchecked")
	public List<UsuariosAsignados> consUsrSolActivasxRepo() {
		Connection conn;
		List<UsuariosAsignados> lstUsuariosAsignados= new ArrayList<UsuariosAsignados>();
		String sql;
		try {
			conn = ConectarBaseUpp.getOracleConnection();
			sql = "select distinct trim(a.asignado) as asignado , b.email as email"
				+ " from MSHD_SOLICITUDES_VIEW a, usuarios b "
				+ "where trim(a.asignado) = trim(b.cod_usr) "
				+ "and b.estados_id = 1 and a.estado = 'ACTIVO'";
			System.out.println("QUERY ->"+sql);
			PreparedStatement a = conn.prepareStatement(sql);
			ResultSet res = a.executeQuery();
			while (res.next()) {
				UsuariosAsignados mae = new UsuariosAsignados();
				mae.setAsignadoUsr(res.getString(1));
				mae.setEmail(res.getString(2));
				lstUsuariosAsignados.add(mae);
			}
			res.close();
			a.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error al conectarse");
		}
		return lstUsuariosAsignados;
	}

	
}
