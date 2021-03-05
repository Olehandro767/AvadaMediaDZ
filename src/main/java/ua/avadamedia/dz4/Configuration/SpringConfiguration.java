package ua.avadamedia.dz4.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ua.avadamedia.dz4.ModelDAO.BrandModelDAO;
import Presenter.AWTWindow;

@Configuration
public class SpringConfiguration {

    @Bean
    public AWTWindow start() {
        return new AWTWindow();
    }

    @Bean
    @Scope("singleton")
    public BrandModelDAO singletonBrandModelDAO() {
        return new BrandModelDAO();
    }

}