package com.zlfund.headstone.core.common.mybatis.dialect;

/**
 * <ul>
 * <li>Title: PostgresQL数据库分页适配器</li>
 * </ul>
 */
public class PostgresDialect extends Dialect {
    public boolean supportsLimitOffset() {
        return true;
    }

    public boolean supportsLimit() {
        return true;
    }

    public String getLimitString(int offset, int limit) {
        if (offset > 0) {
            return " limit " + limit + "offset  " + offset;
        } else {
            return " limit " + limit;
        }
    }
}
