package ua.AvadaMedia.admin.Configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.AvadaMedia.admin.Model.Advertising;
import ua.AvadaMedia.admin.Model.Cinema;
import ua.AvadaMedia.admin.Model.SEOBlock;

@Configuration
public class HibernateUtil {

    @Bean
    public SessionFactory getSessionFactory() {
//        HashMap<String, String> hibernateSettings = new HashMap<>();
//        hibernateSettings.put(Environment.URL, "");
//        configuration.addAnnotatedClass(SEOBlock.class);
//        configuration.addAnnotatedClass(Cinema.class);
//        configuration.addAnnotatedClass(Advertising.class);
//        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
//        return configuration.buildSessionFactory();

        // Create MetadataSources
        MetadataSources sources = new MetadataSources(new StandardServiceRegistryBuilder().configure().build());

        // Create Metadata
        Metadata metadata = sources.getMetadataBuilder().build();

        // Create SessionFactory
        return metadata.getSessionFactoryBuilder().build();

    }

}
