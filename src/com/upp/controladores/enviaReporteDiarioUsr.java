package com.upp.controladores;


import java.util.ArrayList;
import java.util.List;

import com.upp.entidades.SolicitudesView;
import com.upp.entidades.UsuariosAsignados;
import com.upp.servicio.ServicioSolicitudesView;


public class enviaReporteDiarioUsr {
	public static void main(String[] args) {
		System.out.println("ejecuta JAR ETSE");
		String headBody;
		String table;
		List<UsuariosAsignados> lstUsr = new ArrayList<UsuariosAsignados>();
		ServicioSolicitudesView srvSolView = new ServicioSolicitudesView();
		lstUsr = srvSolView.consUsrSolActivasxRepo();
		
		for (UsuariosAsignados usr : lstUsr) {
			// envio de mail
			EmailSenderServiceUpp email = new EmailSenderServiceUpp();
			email.setSubject("Tareas Pendiente - Sistema Upp - CONFIA");
			headBody = "<p>Estimad@,</p>"
					+ "A continuación se detallan las tareas pendientes registradas en el sistema Upp: <br/><br/>"
					
					+ " " + "<br>" + "<br>" + "<table border='1'>" + "<tr>"
					+ "   <th>Código</th>" 
					+ "   <th>Comité</th>" 
					+ "   <th>Sub Comité</th>"
					+ "   <th>Tema</th>" 
					+ "   <th>Resultado Esperado</th>"
					+ "   <th>Fecha Límite</th>"
					+ "</tr>";
			System.out.println("MAIL:"+usr.getEmail());
			email.setReceptor(usr.getEmail());
//			email.setReceptor("soporte@grupoconfia.com");
			// consulta requerimientos
			List<SolicitudesView> lstSol = new ArrayList<SolicitudesView>();
			lstSol = srvSolView.consSolicitudActivasxRepo(usr.getAsignadoUsr());
			table = "";
			for (SolicitudesView re : lstSol) {
				System.out.println("ID:"+re.getSOLICITUD_ID());
				table = table 	+ "<tr>" 
								+ "<td>" + re.getSOLICITUD_ID() + "</td>"
								+ "<td>" + re.getCOMITE() + "</td>"
								+ "<td>" + re.getSUB_COMITE() + "</td>"
								+ "<td>" + re.getPROBLEMA()+ "</td>"
								+ "<td>" + re.getSOLUCION_TECNICA()+ "</td>"
								+ "<td>" + re.getFECHA_ASIGNADA() + "</td>"
								+ "</tr>";
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
}
