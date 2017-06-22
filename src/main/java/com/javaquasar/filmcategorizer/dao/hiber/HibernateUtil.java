package com.javaquasar.filmcategorizer.dao.hiber;

import com.javaquasar.filmcategorizer.dao.hiber.pojo.*;
import java.io.File;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Java Quasar
 */
public class HibernateUtil {
    
    private static final String NAME_DB = "./film";
    private static final String NAME_FILE_DB = NAME_DB + ".mv.db";

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static {
        try {
            boolean initFromXML = false;

            Configuration configuration = new Configuration();

            if (initFromXML) {
                initFromXml(configuration);
            } else {
                initFromJava(configuration);
            }
           
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            serviceRegistry = builder.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
            boolean dbExists = new File(NAME_FILE_DB).exists();
            if (!dbExists) {
                initDb();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initFromXml(Configuration configuration) {
        configuration.configure("hibernate.cfg.xml");
        //При вызове метода configure() без параметров, настройки беруться из файла nibernate.cfg.xml
        //new Configuration().addResource("hibernate.cfg.xml").configure();
    }

    private static void initFromJava(Configuration configuration) {
        configuration.addAnnotatedClass(Sex.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Nationality.class)
                .addAnnotatedClass(HairColor.class)
                .addAnnotatedClass(FigureType.class)
                .addAnnotatedClass(PhotoType.class)
                .addAnnotatedClass(Photo.class)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Studio.class)
                .addAnnotatedClass(Genre.class)
                .addAnnotatedClass(ProcessType.class)
                .addAnnotatedClass(Film.class);

        configuration.setProperties(new Properties() {
            {
                put("hibernate.connection.driver_class", "org.h2.Driver");
                put("hibernate.connection.url", "jdbc:h2:" + NAME_DB);
                put("hibernate.connection.username", "");
                put("hibernate.connection.password", "");
                put("hibernate.default_schema", "PUBLIC");

                put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
                put("hibernate.hbm2ddl.auto", "create"); // update create create-drop
                put("connection.pool_size", "1");
                put("cache.provider_class", "org.hibernate.cache.internal.NoCacheProvider");
                put("show_sql", "true");
                put("hibernate.format_sql", "true");

                //put("hibernate.temp.use_jdbc_metadata_defaults", "false");
            }
        });
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

    private static void initDb() {
//        try {
//            Factory.getInstance().getGenderDAO().addGender(new Gender("муж"));
//            Factory.getInstance().getGenderDAO().addGender(new Gender("жен"));
//        } catch (SQLException ex) {
//            Logger.getLogger(HibernateUtil1.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
