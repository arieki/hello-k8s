package id.talentia.hellok8s.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@EnableJpaRepositories(entityManagerFactoryRef = "localEntityManagerFactory",
    transactionManagerRef = "localTransactionManager",
    basePackages = "id.talentia.hellok8s.repository")
public class JpaConfig extends HikariConfig{

    @Value("${spring.jpa.show-sql}")
    private boolean showSql;

    public JpaConfig(){}

    @Bean(name = "localDataSource")
    @Primary
    public DataSource dataSource(){
        return new HikariDataSource(this);
    }

    @Bean(name = "localEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean locaEntityManagerFactory(final EntityManagerFactoryBuilder builder, 
        @Qualifier("localDataSource") final DataSource dataSource){
            final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
            entityManagerFactoryBean.setJpaVendorAdapter(this.vendorAdapter());
            entityManagerFactoryBean.setDataSource(dataSource);
            entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
            entityManagerFactoryBean.setPackagesToScan("id.talentia.hellok8s.model");
            entityManagerFactoryBean.afterPropertiesSet();
            return entityManagerFactoryBean;
    }

    @Bean(name = "localTransactionManager")
    @Primary
    public PlatformTransactionManager localTransactionManager(
            @Qualifier("localEntityManagerFactory") final EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }

    private HibernateJpaVendorAdapter vendorAdapter(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(showSql);
        return vendorAdapter;
    }
}
