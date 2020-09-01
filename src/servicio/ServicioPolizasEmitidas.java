package servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.polizasEmitidas;

public class ServicioPolizasEmitidas {

	public List<polizasEmitidas> consultaPolizaEmitida() {
		Connection conn;
		List<polizasEmitidas> lstJefe = new ArrayList<>();
		String sql;
		try {
			conn = ConectarBase.getOracleConnection();
			sql = "select num_cotizacion,cliente,nombre_corto_aseguradora,desc_ramo, "
					+ "poliza,factura_aseguradora,nvl(anexo,0) as anexo, "
					+ "'Error en la Emisión, comuníquese con el Administrador del sistema' as Mensaje, "
					+ "cd_ramo_cotizacion,fecha_emision from consulta_poliza_view "
					+ "where cd_ramo_cotizacion not in (select cd_ramo_cotizacion from ramo_cotizacion_tbl )"
					//+ "and fecha_emision_jul = fechajuliana_func(to_char(sysdate-1,'dd/mm/yyyy'))"
					;
			System.out.println("QUERY ->"+sql);
			PreparedStatement a = conn.prepareStatement(sql);
			ResultSet res = a.executeQuery();
			while (res.next()) {

				polizasEmitidas mae = new polizasEmitidas();
				mae.setNum_cotizacion(res.getString("num_cotizacion"));
				mae.setCliente(res.getString("cliente"));
				mae.setNombre_corto_aseguradora(res.getString("nombre_corto_aseguradora"));
				mae.setDesc_ramo(res.getString("desc_ramo"));
				mae.setPoliza(res.getString("poliza"));
				mae.setFactura_aseguradora(res.getString("factura_aseguradora"));
				mae.setAnexo(res.getString("anexo"));
				mae.setMensaje(res.getString("Mensaje"));
				mae.setCd_ramo_cotizacion(res.getString("cd_ramo_cotizacion"));
				mae.setFecha_emision(res.getDate("fecha_emision"));
				lstJefe.add(mae);
			}
			res.close();
			a.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error al conectarse");
		}
		return lstJefe;
	}
	
//	public void guardaLogEnvio(String codMf,String Proceso) {
//		Connection conn;
//		String sql;
//		// ejecuta el update
//		try {
//			System.out
//					.println("Ingreso datos ORACLE -> INSERT MS_LOG_ENVIO_MAILS");
//			conn = ConectarBase.getOracleConnection();
//
//			sql = "insert into MS_LOG_ENVIO_MAILS (cod_mf,fecha_envio,proceso)"
//					+ " values ("+codMf+",sysdate,'"+Proceso+"')";
//			System.out.println("QUERY UPDATE: " + sql);
//			CallableStatement cs = conn.prepareCall(sql);
//			cs.execute();
//			cs.close();
//			conn.close();
//		} catch (Exception e) {
//			System.out.println("error al INSERTAR: " + e.getMessage());
//		}
//
//	}
//	
}
