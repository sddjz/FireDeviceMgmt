package com.example.mybatis_demo.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BaseConfig implements WebMvcConfigurer{ //获取真实路径和访问路径
	
	
		@Value("${thk.imagesRealPath}")
		private String realPath;
		@Value("${thk.imagesServerPath}")
		private String serverPath;
		
		 @Autowired
	private CrosInterceptor crosInterceptor;

		
		//添加文件服务器位置
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
		    //registry.addResourceHandler(new String[]{serverPath+"/**"}).addResourceLocations("file:"+realPath);
		    //registry.addResourceHandler(serverPath+"/**").addResourceLocations("file:/"+realPath);
			registry.addResourceHandler("/images/**").addResourceLocations("file:c:/workspace/dev_folder/Image/");

		}

		 @Override
		 public void addInterceptors(InterceptorRegistry registry) {
		        //创建用户拦截器对象并指定其拦截的路径和排除的路径
		        registry.addInterceptor(crosInterceptor).addPathPatterns("/**");
		    }		
		
		   
}