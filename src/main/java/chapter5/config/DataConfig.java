package chapter5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/11/24.
 */
@Configuration
public class DataConfig {
    //@Bean
    //public DataSource dataSource(){
    //    return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("schema.sql").build();
    //}
    //
    //@Bean
    //public JdbcOperations jdbcOperations(DataSource dataSource){
    //    return new JdbcTemplate(dataSource);
    //}
}
