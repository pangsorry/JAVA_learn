package kr.or.connect.mvcexam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "kr.or.connect.mvcexam.controller" })
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	
    //web.xml의 설정으로 인해 모든 요청이 DispatcherServlet으로 들어가게 된다. 그 중에는 css나 이미지 자바스크립트 등의 요청도 포함되어 있으므로
	//그것들을 각각 구분하기 위해서 핸들러들을 설정하는 부분이다.
	//각 요청에 대한 위치를 알려주고 있음.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
 
    // default servlet handler를 사용하게 합니다.
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
   
    
    //특정 url에 대한 처리를 controller class를 작성하지 않고 매핑할수 있게 해준다.
    //    ('/'=모든요청)이 들어오면 main이라는 viewname을 이용해서 view 정보를 찾는 것을 도와준다.
    // view정보는 getInternalResourceViewResolver()에서 viewname을 통해 찾을 수 있다.
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
    		System.out.println("addViewControllers가 호출됩니다. ");
        registry.addViewController("/").setViewName("main");
    }
    
    
    //getInternalResourceViewResolver 메소드를 이용해 view정보를 찾을 수 있다.
    //prefix와 suffix가 들어온 값(viewname)의 앞과 뒤에 각각 붙여져서 특정 파일을 찾을 수 있게 된다.
    //ex) viewname=main   //  result = /WEB-INF/views/main.jsp
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}