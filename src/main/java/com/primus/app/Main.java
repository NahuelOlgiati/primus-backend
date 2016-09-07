package com.primus.app;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.ejb.EJBFraction;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.jpa.JPAFraction;
import org.wildfly.swarm.logging.LoggingFraction;
import org.wildfly.swarm.swagger.SwaggerArchive;

public class Main {

	public static void main(String[] args) throws Exception {

		Swarm swarm = new Swarm();

		swarm.fraction(LoggingFraction.createDebugLoggingFraction());
		swarm.fraction(getDatasourcesFraction());
		swarm.fraction(getJpaFraction());
		swarm.fraction(EJBFraction.createDefaultFraction());
		swarm.start();

		JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
		deployment.addAsLibrary(swarm.createDefaultDeployment());

		SwaggerArchive archive = deployment.as(SwaggerArchive.class);
		archive.setResourcePackages("com.primus.rest.endpoint");
		archive.setTitle("Primus Backend Enpoints");

		deployment.addAllDependencies();
		// deployment.staticContent(); DESCOMENTAR ROMPE TODO LPM
		swarm.deploy(deployment);
	}

	private static JPAFraction getJpaFraction() {
		return new JPAFraction().defaultDatasource("jboss/datasources/postgresDS");
	}

	// private static JPAFraction getJpaFraction() {
	// return new JPAFraction().defaultDatasource("jboss/datasources/primusDS");
	// }

	private static DatasourcesFraction getDatasourcesFraction() {
		return new DatasourcesFraction().jdbcDriver("org.postgresql", (d) -> {
			d.driverClassName("org.postgresql.Driver");
			d.xaDatasourceClass("org.postgresql.xa.PGXADataSource");
			d.driverModuleName("org.postgresql");
		}).dataSource("primusDS", (ds) -> {
			ds.driverName("org.postgresql");
			ds.connectionUrl("jdbc:postgresql://localhost:5433/postgres");
			ds.userName("postgres");
			ds.password("postgres");
		});
	}

	// private static DatasourcesFraction getDatasourcesFraction() {
	// return new DatasourcesFraction().jdbcDriver("org.postgresql", (d) -> {
	// d.driverClassName("org.postgresql.Driver");
	// d.xaDatasourceClass("org.postgresql.xa.PGXADataSource");
	// d.driverModuleName("org.postgresql");
	// }).dataSource("primusDS", (ds) -> {
	// ds.driverName("org.postgresql");
	// ds.connectionUrl("jdbc:postgresql://localhost:5432/primus");
	// ds.userName("postgres");
	// ds.password("postgres");
	// });
	// }
}