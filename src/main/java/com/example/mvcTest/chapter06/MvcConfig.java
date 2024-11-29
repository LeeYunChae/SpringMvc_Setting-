package com.example.mvcTest.chapter06;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.example"})
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        registry.jsp("/WEB-INF/views/",".jsp");
    }
    //히카리
    @Bean
    public DataSource dataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        //dataSource.setDriverClassName("oracle.jdbc,OracleDriver");
       // dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
       // dataSource.setUsername("testuser");
      //  dataSource.setPassword("test1234");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 클래스
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/boarddb"); // MySQL JDBC URL
        dataSource.setUsername("root"); // MySQL 사용자 이름
        dataSource.setPassword("root1234"); // MySQL 비밀번호
        return dataSource;
    }
    //마이빗
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
        ssf.setDataSource(dataSource());//의존성 주입
        //mapper파일의 위치
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        ssf.setMapperLocations(resolver.getResource("classpath:/mapper/**/*.xml"));
        return ssf.getObject();

    }
    //DAO에서 주입받을 객체
    //sql 실행하려고
    @Bean
    public SqlSessionTemplate sst() throws Exception{
        return  new SqlSessionTemplate(sqlSessionFactory());
    }

}
