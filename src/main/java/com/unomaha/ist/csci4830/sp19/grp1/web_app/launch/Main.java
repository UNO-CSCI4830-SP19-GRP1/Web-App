package com.unomaha.ist.csci4830.sp19.grp1.web_app.launch;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.WebResourceSet;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class Main {
	private Main() {
	}

	public static void main(final String[] args) throws LifecycleException {
		final String contextPath = "/";
		final String defaultPort = "8080";
		final Path webappDirLocation = Paths.get("src/main/webapp/");
		final Path buildPath = Paths.get("target/classes");
		final String webAppMount = "/WEB-INF/classes";
		final String internalPath = "/";

		final Tomcat tomcat = new Tomcat();

		//The port that we should run on can be set into an environment variable
		//Look for that variable and use the default port if it isn't there.
		String webPort = System.getenv("PORT");
		if((webPort == null) || webPort.isEmpty()) {
			webPort = defaultPort;
		}
		tomcat.setPort(Integer.valueOf(webPort));

		final Context context = tomcat.addWebapp(contextPath, webappDirLocation.toAbsolutePath().toString());

		// Declare an alternative location for your webAppMount dir
		// Servlet 3.0 annotation will work
		final WebResourceRoot resources = new StandardRoot(context);
		final WebResourceSet resourceSet = new DirResourceSet(resources, webAppMount, buildPath.toAbsolutePath().toString(), internalPath);
		resources.addPreResources(resourceSet);

		context.setResources(resources);

		// Create default connector
		tomcat.getConnector();

		tomcat.start();
		tomcat.getServer().await();
	}
}