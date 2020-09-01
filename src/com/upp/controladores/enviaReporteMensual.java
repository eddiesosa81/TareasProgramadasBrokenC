package com.upp.controladores;


import java.util.ArrayList;
import java.util.List;

import com.upp.entidades.SolicitudesView;
import com.upp.entidades.UsuariosAsignados;
import com.upp.servicio.ServicioSolicitudesView;


public class enviaReporteMensual {
	public static void main(String[] args) {
		System.out.println("ejecuta JAR ETSE");
		String headBody;
		String table;
		List<UsuariosAsignados> lstUsr = new ArrayList<UsuariosAsignados>();
		ServicioSolicitudesView srvSolView = new ServicioSolicitudesView();
		lstUsr = srvSolView.consUsrSolActivasxRepo();
		
		
		// envio de mail
		EmailSenderServiceUpp email = new EmailSenderServiceUpp();
		email.setSubject("Tareas Pendiente Mensual - Sistema Upp - CONFIA");
		headBody = "<p>Estimad@,</p>"
				+ "A continuación se detallan las tareas pendientes registradas en el sistema Upp: <br/><br/>"
				
				+ " " + "<br>" + "<br>" + "<table border='1'>" + "<tr>"
				+ "   <th>Asignado a</th>"
				+ "   <th>Reportado por</th>"
				+ "   <th>Fecha Asignación</th>" 
				+ "   <th>Fecha Límite</th>"
				+ "   <th>Tema</th>" 
				+ "   <th>Resultado Esperado</th>"
				+ "</tr>";
		
		email.setReceptor("soporte@grupoconfia.com,dvera@grupoconfia.com");
		table = "";
		for (UsuariosAsignados usr : lstUsr) {
			// consulta requerimientos
			List<SolicitudesView> lstSol = new ArrayList<SolicitudesView>();
			lstSol = srvSolView.consSolicitudActivasxRepo(usr.getAsignadoUsr());
			
			if(lstSol.size() > 0){
				for (SolicitudesView re : lstSol) {
					System.out.println("ID:"+re.getSOLICITUD_ID());
					table = table 	+ "<tr>" 
									+ "<td>" + usr.getAsignadoUsr() + "</td>"
									+ "<td>" + re.getREPORTA() + "</td>"
									+ "<td>" + re.getFECHA_ASIGNADA_ORIGINAL() + "</td>"
									+ "<td>" + re.getFECHA_ASIGNADA() + "</td>"
									+ "<td>" + re.getPROBLEMA()+ "</td>"
									+ "<td>" + re.getSOLUCION_TECNICA()+ "</td>"
									+ "</tr>";
				}
			}else{
				table = table 	+ "<tr>" 
						+ "<td></td>"
						+ "<td></td>"
						+ "<td></td>"
						+ "<td></td>"
						+ "<td></td>"
						+ "<td></td>"
						+ "</tr>";
			}
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
