package org.mx.scinemathica.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.mx.scinemathica.util.Utilidades;
import org.springframework.stereotype.Service;

@Service
public class MailService 
{
	public String enviaCorreoService(String subject,String mensaje,String context)
	{
		Properties p = new Properties();
		Transport t;
		String respuesta;
		try
		{
			 
			 Session session = Session.getDefaultInstance(p,null);
			 session.setDebug(true);
			 
			 p = Utilidades.leerArchivo(context);
			 //System.out.println("user properties" + p.getProperty("mail.smtp.user"));
			 MimeMessage message = new MimeMessage(session);
			 message.setFrom(new InternetAddress(p.getProperty("mail.smtp.admin")));
			 message.setRecipient(Message.RecipientType.TO, new InternetAddress(p.getProperty("mail.smtp.admin")));
			 message.setSubject(subject);
			 message.setText(mensaje);
			 
			 //t = session.getTransport("smtp");
			 //t.connect(p.getProperty("mail.smtp.user"),p.getProperty("mail.smtp.password"));
			 Transport.send(message);
			 
			 respuesta = "Exito en el envio, Gracias por tus comentarios";
			 
			 //t.close();
			 
		}catch(MessagingException me)
		{
			System.out.println("Ocurrio error");
			respuesta = "Fallo el envio, intentelo mas tarde";
			me.printStackTrace();
		}catch(Exception ex)
		{
			System.out.println("ocurrio un error en correo service");
			respuesta = "Fallo el envio, intentelo mas tarde";
			ex.printStackTrace();
		}
		return respuesta;
	}
	
	
	public String enviaCorreoService(String subject,String mensaje,String context,String mail)
	{
		Properties p = new Properties();
		Transport t;
		String respuesta;
		try
		{
			 
			 Session session = Session.getDefaultInstance(p,null);
			 session.setDebug(true);
			 
			 p = Utilidades.leerArchivo(context);
			 //System.out.println("user properties welcome" + p.getProperty("mail.smtp.user"));
			 MimeMessage message = new MimeMessage(session);
			 message.setFrom(new InternetAddress(p.getProperty("mail.smtp.admin")));
			 message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));
			 message.setSubject(subject);
			 message.setText(mensaje);
			 
			 Transport.send(message);
			 
			 respuesta = "Exito en el envio, Gracias por tus comentarios";
			 			 
		}catch(MessagingException me)
		{
			System.out.println("Ocurrio error");
			respuesta = "Fallo el envio, intentelo mas tarde";
			me.printStackTrace();
		}catch(Exception ex)
		{
			System.out.println("ocurrio un error en correo service");
			respuesta = "Fallo el envio, intentelo mas tarde";
			ex.printStackTrace();
		}
		return respuesta;
	}
}
