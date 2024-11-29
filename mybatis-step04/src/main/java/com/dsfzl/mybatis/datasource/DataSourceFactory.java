package com.dsfzl.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author: dsf
 * @description: 数据源工厂
 * @date 2024/11/25 下午8:05
 */

public interface DataSourceFactory {


    void setProperties(Properties props);

    DataSource getDataSource();
}
