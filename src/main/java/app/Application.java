package app;

import java.io.InputStream;
import java.io.OutputStream;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Application {
	
	public static void main(String[] args) {
//		SVNRepositoryFactoryImpl.setup();
//		ISVNAuthenticationManager authenticator;
//		try {
//			authenticator = BasicAuthenticationManager.newInstance("ik04346", "as13ue!+".toCharArray());
//			String urlEncoded = SVNEncodingUtil.uriEncode("http://projets3.ens.math-info.univ-paris5.fr/svn/2018-l3ai2/");
//			SVNURL url = SVNURL.parseURIEncoded(urlEncoded);
//			SVNRepository repository = SVNRepositoryFactory.create(url);
//			repository.setAuthenticationManager(authenticator);
//			repository.testConnection();
//		} catch (SVNException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String host = "https://projets3.ens.math-info.univ-paris5.fr/svn/2018-l3ai2/";
//		Integer port = 80;
//		SSLSocketFactory sslsocketfactory = SSLSocketFactory.getDefault();
//		SSLSocket sslsocket = (SSLSocket) sslsocketfactory
//		  .createSocket(host, port);
//		InputStream in = sslsocket.getInputStream();
//		OutputStream out = sslsocket.getOutputStream();
//		 
//		out.write(1);
//		while (in.available() > 0) {
//		    System.out.print(in.read());
//		}
//		 
//		System.out.println("Secured connection performed successfully");
	}
}
