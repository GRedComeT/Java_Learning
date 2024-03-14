package com.libraryManagementSystem.util;

import com.libraryManagementSystem.mapper.LibraryMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.function.Consumer;

public class SqlUtil {
    private static SqlSessionFactory factory;

    private SqlUtil() {
    }

    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(boolean autoCommit) {
        return factory.openSession(autoCommit);
    }

    public static void doSqlWork(Consumer<LibraryMapper> consumer) {
        try (SqlSession session = getSqlSession(true)) {
            LibraryMapper mapper = session.getMapper(LibraryMapper.class);
            consumer.accept(mapper);
        }
    }

}
