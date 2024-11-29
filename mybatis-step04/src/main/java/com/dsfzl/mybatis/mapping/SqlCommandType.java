package com.dsfzl.mybatis.mapping;

/**
 * @author: dsf
 * @description:
 * @date 2024/11/21 下午8:40
 */

public enum SqlCommandType {
    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;
}
