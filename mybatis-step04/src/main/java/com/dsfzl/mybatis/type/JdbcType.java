package com.dsfzl.mybatis.type;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: dsf
 * @description: JDBC类型枚举
 * @date 2024/11/25 下午7:28
 */

public enum JdbcType {

    INTEGER(Types.INTEGER),
    FLOAT(Types.FLOAT),
    DOUBLE(Types.DOUBLE),
    DECIMAL(Types.DECIMAL),
    VARCHAR(Types.VARCHAR),
    TIMESTAMP(Types.TIMESTAMP);

    public final int TYPE_CODE;
    private static Map<Integer, JdbcType> codeLookup = new HashMap<>();

    // 将数字对应的枚举型放入 HashMap
    // 在类加载时，预先构建一个 HashMap，
    // 使得后续可以通过 TYPE_CODE 快速查找对应的 JdbcType 实例，从而提高查找效率。
    static {
        for (JdbcType type : JdbcType.values()) {
            codeLookup.put(type.TYPE_CODE, type);
        }
    }

    JdbcType(int code) {
        this.TYPE_CODE = code;
    }

    public static JdbcType forCode(int code){
        return codeLookup.get(code);
    }
}
