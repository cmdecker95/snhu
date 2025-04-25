package com.gamingroom.gameauth;

import com.gamingroom.gameauth.auth.GameAuthenticator;
import com.gamingroom.gameauth.auth.GameAuthorizer;
import com.gamingroom.gameauth.auth.GameUser;
import com.gamingroom.gameauth.controller.GameUserRESTController;
import com.gamingroom.gameauth.controller.RESTClientController;
import com.gamingroom.gameauth.healthcheck.AppHealthCheck;
import com.gamingroom.gameauth.healthcheck.HealthCheckController;

import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Environment;

import jakarta.ws.rs.client.Client;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Import for CORS filter
import org.eclipse.jetty.servlets.CrossOriginFilter;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * Main application class that sets up the application configuration, REST
 * resources, and health checks.
 */
public class GameAuthApplication extends Application<GameAuthConfiguration> {
	private static final Logger LOGGER = LoggerFactory.getLogger(GameAuthApplication.class);

	@Override
	public void run(GameAuthConfiguration c, Environment e) throws Exception {

		LOGGER.info("Initialize REST client");
		JerseyClientBuilder clientBuilder = new JerseyClientBuilder(e);
		Client client = clientBuilder.build("DemoRESTClient");

		LOGGER.info("Register REST endpoints");
		e.jersey().register(new GameUserRESTController(e.getValidator()));
		e.jersey().register(new RESTClientController(client));

		LOGGER.info("Setting up REST client controller for health checks");
		e.healthChecks().register("APIHealthCheck", new AppHealthCheck(client));
		e.jersey().register(new HealthCheckController(e.healthChecks()));

		LOGGER.info("Setting up authentication and authorization filters");
		e.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<GameUser>()
				.setAuthenticator(new GameAuthenticator())
				.setAuthorizer(new GameAuthorizer())
				.setRealm("App Security")
				.buildAuthFilter()));

		LOGGER.info("Registering AuthValueFactoryProvider for GameUser");
		e.jersey().register(new AuthValueFactoryProvider.Binder<>(GameUser.class));
		e.jersey().register(RolesAllowedDynamicFeature.class);
        
		// Configure CORS parameters to allow requests from all origins
		LOGGER.info("Configuring CORS filters");
		final FilterRegistration.Dynamic cors = e.servlets().addFilter("CORS", CrossOriginFilter.class);
		
		// Configure CORS parameters
		cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*"); // Allow all origins with wildcard
		cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "*"); // Allow all HTTP methods
		cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "*"); // Allow all headers
		cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true"); // Allow credentials like cookies
		cors.setInitParameter(CrossOriginFilter.PREFLIGHT_MAX_AGE_PARAM, "86400"); // Cache preflight requests for 24 hours (in seconds)
		cors.setInitParameter(CrossOriginFilter.EXPOSED_HEADERS_PARAM, "*"); // Expose all headers to the browser
		
		// Apply the CORS filter to all paths
		cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
	}

	public static void main(String[] args) throws Exception {
		new GameAuthApplication().run(args);
	}
}
