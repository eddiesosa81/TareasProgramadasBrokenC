package controladores;


import java.util.ArrayList;
import java.util.List;

import entidades.polizasEmitidas;
import servicio.ServicioPolizasEmitidas;

public class enviaPolizaEmitidas {
	public static void main(String[] args) {
		System.out.println("ejecuta JAR ETSE");
		String headBody;
		String table;
		// envio de mail
		EmailSenderService email = new EmailSenderService(); 
		email.setSubject("Auditoría de Emisión - Sistema Confia");
		headBody = "<p>Estimad@,</p>"
				+ "A continuación se detallan las pólizas emitidas con error: <br/><br/>"
				
				+ " " + "<br>" + "<br>" + "<table border='1'>" + "<tr>"
				+ "   <th>NUMERO DE COTIZACION</th>" + "   <th>CLIENTE</th>"
				+ "   <th>ASEGURADORA</th>" + "   <th>RAMO</th>"
				+ "   <th>POLIZA</th>"
				+ "   <th>FACTURA</th>"
				+ "   <th>ANEXO</th>"
				+ "   <th>FECHA EMISION</th>"
				+ "   <th>MENSAJE DE ERROR</th>"
				+ "</tr>";
		
		email.setReceptor("comercial@grupoconfia.com,edison.sosa@onewayec.com,cobranzas@grupoconfia");
		//email.setReceptor("edison.sosa@ec.aseyco.com");
		// consulta requerimientos
		List<polizasEmitidas> lstPol = new ArrayList<>();
		ServicioPolizasEmitidas srvMae = new ServicioPolizasEmitidas();
		lstPol = srvMae.consultaPolizaEmitida();
		table = "";
		for (polizasEmitidas re : lstPol) {
			table = table + "<tr>" 
					+ "<td>" + re.getNum_cotizacion() + "</td>"
					+ "<td>" + re.getCliente() + "</td>"
					+ "<td>" + re.getNombre_corto_aseguradora()+ "</td>"
					+ "<td>" + re.getDesc_ramo()+ "</td>"
					+ "<td>" + re.getPoliza() + "</td>"
					+ "<td>" + re.getFactura_aseguradora() + "</td>" 
					+ "<td>" + re.getAnexo() + "</td>" 
					+ "<td>" + re.getFecha_emision() + "</td>" 
					+ "<td>" + re.getMensaje()+ "</td>" 
					+ "</tr>";
//			srvMae.guardaLogEnvio(re.getCodigo_jde().trim(), "SALIDA DE PERSONAL RETAIL");
		}
		table = table
				+ "</table>"
				+ " "
				+ "<br>"
				+ "<br>"
				+ "<p><strong>Nota: </strong>"
				+ "Este mensaje ha sido generado automáticamente, por favor no lo responda."
				+ "</p> ";

		table = headBody + table;
		email.setTexto(table);
		email.sendEmail();

	}
}
