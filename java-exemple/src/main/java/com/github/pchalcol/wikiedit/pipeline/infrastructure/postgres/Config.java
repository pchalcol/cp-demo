package com.github.pchalcol.wikiedit.pipeline.infrastructure.postgres;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

public class Config {

    private static String DRIVER = "org.postgresql.Driver";
    private static String URL = "jdbc:postgresql://localhost:5432/test";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "password";

    public static SqlSessionFactory sqlSessionFactory() {

        DataSource dataSource = new PooledDataSource(DRIVER, URL, USERNAME, PASSWORD);

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("Development", transactionFactory, dataSource);

        Configuration configuration = new Configuration(environment);
        configuration.addMapper(WikiEditSinkEventMapper.class);

        return new SqlSessionFactoryBuilder().build(configuration);
    }
}
