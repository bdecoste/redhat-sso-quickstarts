package org.keycloak.quickstart.appjee;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author <a href="mailto:mstrukel@redhat.com">Marko Strukelj</a>
 */
public class ServiceLocator {

	public static URL getServiceUrl(HttpServletRequest req) {
		try {
			String url = new URL(req.getRequestURL().toString()).getHost();
			System.out.println("!!!!!! url " + url);
			//if ( host != null && !host.equals("localhost"))
			//	return new URL("http://" + host + "/service");
		} catch (MalformedURLException e){
		}

		String host = req.getLocalAddr();

		if (host.equals("localhost")) {
			try {
				host = java.net.InetAddress.getLocalHost().getHostAddress();
			} catch (Exception e) {
			}
		}
		
		System.out.println("!!!!!! host " + host);

		try {
			return new URL("http://" + host + ":8080/service");
		} catch (MalformedURLException e){
			throw new RuntimeException("Malformed URL: " + host);
		}
	}
}
