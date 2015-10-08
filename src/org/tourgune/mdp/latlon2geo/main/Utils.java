package org.tourgune.mdp.latlon2geo.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Utils {

	public static String getURL(String urlStr) throws Exception	{
		URL url = null;
		URLConnection con = null;
		BufferedReader in = null;
		StringBuilder buffer = null;
		String line = null;
	
		url = new URL(urlStr);
		con = url.openConnection();
		in = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
		
		buffer = new StringBuilder();
		
		while((line = in.readLine())!=null)
		{
			buffer.append(line);
		}
		
		return buffer.toString();
	}
}
