package org.mx.scinemathica.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Utilidades 
{
	public static String codificaPassword(String password)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] b = md.digest(password.getBytes());
			int size = b.length;
			StringBuffer sb = new StringBuffer(size);
			
			for(int i = 0; i < size; i++)
			{
				int u = b[i] & 255;
				if(u < 16)
				{
					sb.append("0" + Integer.toHexString(u));
				}else
				{
					sb.append(Integer.toHexString(u));
				}
			}
			
			return sb.toString();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	public static String convierteYoutubeLink(String url)
	{
		if(url.contains("www"))
		{
			url = url.substring(31);
		}else if(url.contains("youtu.be"))
		{
			url = url.substring(16);
		}
		
		return url;
	}
	
	public static Properties leerArchivo(String context)
	{
		Properties propiedades = new Properties();
		
		try
		{
			//InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("src/org/mx/resources/Connection.properties");
			//propiedades.load(input);
			propiedades.load(new FileInputStream(context));
			
			
		}catch(Exception ex)
		{
			System.out.println("Error, El archivo no exite");
			ex.printStackTrace();
		}
		
		return propiedades;
	}
}
