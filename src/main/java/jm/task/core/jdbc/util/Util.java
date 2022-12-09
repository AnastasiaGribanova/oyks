package jm.task.core.jdbc.util;
import java.util.Properties;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;


public class Util {
    private static SessionFactory sessionFactory;
    /*private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/new_schema?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }*/
    static {
        Properties prop= new Properties();

        prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/new_schema");

        //You can use any database you want, I had it configured for Postgres
        prop.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");

        prop.setProperty("hibernate.connection.username", "root");
        prop.setProperty("hibernate.connection.password", "root");
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        prop.setProperty(Environment.SHOW_SQL, "true"); //If you wish to see the generated sql query
        prop.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        prop.setProperty(Environment.HBM2DDL_AUTO, "drop-and-create");

        try{
            sessionFactory = new Configuration().addProperties(prop).addAnnotatedClass(User.class).buildSessionFactory();
        }catch (HibernateException e){
            System.out.println("FUCK" + e);
        }

    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}







/*public class Util {
    private static SessionFactory sessionFactory;

    static {
        Properties prop= new Properties();

        prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/new_schema");

        //You can use any database you want, I had it configured for Postgres
        prop.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");

        prop.setProperty("hibernate.connection.username", "root");
        prop.setProperty("hibernate.connection.password", "root");
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        prop.setProperty(Environment.SHOW_SQL, "true"); //If you wish to see the generated sql query
        prop.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        prop.setProperty(Environment.HBM2DDL_AUTO, "drop-and-create");

        try{
            sessionFactory = new Configuration().addProperties(prop).addAnnotatedClass(User.class).buildSessionFactory();
        }catch (HibernateException e){
            System.out.println("FUCK" + e);
        }

    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    *//*public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/new_schema?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true\" +\n" +
                        "            \"&useLegacyDatetimeCode=false&serverTimezone=UTC");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "root");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }*//*
}*/
