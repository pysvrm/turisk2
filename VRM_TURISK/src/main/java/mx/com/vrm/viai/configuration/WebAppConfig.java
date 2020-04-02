package mx.com.vrm.viai.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

// TODO: Auto-generated Javadoc
/**
 * The Class WebAppConfig.
 */
@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = { "mx.com" })
@EnableJpaRepositories(basePackages = { "mx.com.vrm.viai.dao" })
@Import({ SpringSecurityConfiguration.class })
public class WebAppConfig extends WebMvcConfigurerAdapter {

	/**
	 * View resolver.
	 *
	 * @return the internal resource view resolver
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	/**
	 * Tiles configurer.
	 *
	 * @return the tiles configurer
	 */
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/views/**/tiles.xml" });
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}

	/**
	 * Tiles view resolver.
	 *
	 * @return the view resolver
	 */
	@Bean
	public ViewResolver tilesViewResolver() {
		return new TilesViewResolver();
	}

	/**
	 * Entity manager factory.
	 *
	 * @return the local container entity manager factory bean
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "mx.com.vrm.viai.model" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	/**
	 * Data source.
	 *
	 * @return the data source
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		// LOCAL -CV
		dataSource.setUrl(
				"jdbc:mysql://localhost:3306/vrm_viai?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
	}

	/**
	 * Transaction manager.
	 *
	 * @param emf
	 *            the emf
	 * @return the platform transaction manager
	 */
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	/**
	 * Exception translation.
	 *
	 * @return the persistence exception translation post processor
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	/**
	 * Additional properties.
	 *
	 * @return the properties
	 */
	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "none");
		properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");

		// TODO:Otras propiedades que se pueden habilitar.

		/*
		 * properties.setProperty("hibernate.auto_close_session",
		 * environment.getRequiredProperty("hibernate.auto_close_session"));
		 * properties.setProperty("hibernate.cache.use_second_level_cache",
		 * environment.getRequiredProperty(
		 * "hibernate.cache.use_second_level_cache"));
		 * properties.setProperty("hibernate.cache.use_query_cache",
		 * environment.getRequiredProperty("hibernate.cache.use_query_cache"));
		 * properties.setProperty("hibernate.generate_statistics",
		 * environment.getRequiredProperty("hibernate.generate_statistics"));
		 */

		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
	 * #configureViewResolvers(org.springframework.web.servlet.config.annotation
	 * .ViewResolverRegistry)
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
	 * #addResourceHandlers(org.springframework.web.servlet.config.annotation.
	 * ResourceHandlerRegistry)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}

	/**
	 * User details service.
	 *
	 * @return the user details service
	 */
	@Bean(name = "userDetailsService")
	public UserDetailsService userDetailsService() {
		JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
		jdbcImpl.setDataSource(dataSource());
		jdbcImpl.setUsersByUsernameQuery("select username,password, enabled from users where username=?");
		jdbcImpl.setAuthoritiesByUsernameQuery("select b.username, a.rol from user_roles a, users b "
				+ " where b.username=? and a.iduser_roles=b.user_roles_id;");
		return jdbcImpl;
	}
}