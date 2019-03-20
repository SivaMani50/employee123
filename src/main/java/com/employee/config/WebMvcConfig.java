package com.employee.config;
 
import java.util.List;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
 
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
 
/**
* @author et7er
*/
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.employee" })
@EnableTransactionManagement
public class WebMvcConfig extends WebMvcConfigurerAdapter {
 
    List<HttpMessageConverter<?>> convertersList = null;
 
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
 
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        final InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(""); //$NON-NLS-1$
        resolver.setSuffix(".html"); //$NON-NLS-1$
        return resolver;
    } 
    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
 
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/"); //$NON-NLS-1$ //$NON-NLS-2$
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/"); //$NON-NLS-1$ //$NON-NLS-2$
    }
 
    @Bean
    public MappingJackson2HttpMessageConverter msgConverter() {
        final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(jacksonObjectMapper());
        return converter;
    }
 
    @Bean
    public ObjectMapper jacksonObjectMapper() {
       final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }
 
   @Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
        converters.add(msgConverter());
       convertersList = converters;
   } 
}