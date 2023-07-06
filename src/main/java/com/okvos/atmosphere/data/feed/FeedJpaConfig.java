package com.okvos.atmosphere.data.feed;

import com.okvos.atmosphere.data.feed.entity.Post;
import com.okvos.atmosphere.data.feed.repository.PostLikeRepository;
import com.okvos.atmosphere.data.feed.repository.PostRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = {PostRepository.class, PostLikeRepository.class},
        entityManagerFactoryRef = "feedEntityManagerFactory",
        transactionManagerRef = "feedTransactionManager"
)
public class FeedJpaConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean feedEntityManagerFactory(
            @Qualifier("feedDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder
    ) {
        return builder
                .dataSource(dataSource)
                .packages(Post.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager feedTransactionManager(
            @Qualifier("feedEntityManagerFactory") LocalContainerEntityManagerFactoryBean feedEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(feedEntityManagerFactory.getObject()));
    }
}
