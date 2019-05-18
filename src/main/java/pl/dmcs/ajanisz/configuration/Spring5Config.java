package pl.dmcs.ajanisz.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import pl.dmcs.ajanisz.utils.AppUserRoleConverter;
import pl.dmcs.ajanisz.utils.AppUserRoleListConverter;

import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan("pl.dmcs.ajanisz")
//@Import(SecurityConfiguration.class)
public class Spring5Config implements WebMvcConfigurer {
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[] { "tilesConfiguration/tiles.xml" });
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    // Configure ViewResolvers to deliver preferred views.

    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }


    // Configure message source directory
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/resources/i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    // Configure LocaleResolver with default locale as 'en'
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(new Locale("en"));
        resolver.setCookieName("myLocaleCookie");
        resolver.setCookieMaxAge(4800);
        return resolver;
    }

    // Configure interceptor to switch language when 'lang' parameter found in request

    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addConverter(getMyUserRoleConverter());
        formatterRegistry.addConverter(getMyUserRoleListConverter());
    }

    @Bean
    public AppUserRoleListConverter getMyUserRoleListConverter() {
        return new AppUserRoleListConverter();
    }

    @Bean
    public AppUserRoleConverter getMyUserRoleConverter() {
        return new AppUserRoleConverter();
    }

}