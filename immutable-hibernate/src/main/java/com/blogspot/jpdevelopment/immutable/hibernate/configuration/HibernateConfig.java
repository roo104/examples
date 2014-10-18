package com.blogspot.jpdevelopment.immutable.hibernate.configuration;


public class HibernateConfig {
	/*
		@Bean
		public BasicDataSource dataSource() {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/test");
			dataSource.setUsername("root");
			return dataSource;
		}

		@Bean
		public LocalSessionFactoryBean sessionFactory() {
			LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

			sessionFactory.setDataSource(dataSource());
			sessionFactory.setHibernateProperties(additionalProperties());
			sessionFactory.setAnnotatedClasses(Person.class);
			return sessionFactory;
		}

		@Bean
		@Autowired
		public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager txManager = new HibernateTransactionManager();
			txManager.setSessionFactory(sessionFactory);

			return txManager;
		}

		Properties additionalProperties() {
			Properties properties = new Properties();
			properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
			properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
			properties.setProperty("hibernate.show_sql", "true");
			properties.setProperty("hibernate.connection.autocommit", "true");
			return properties;
		}
	*/
}
