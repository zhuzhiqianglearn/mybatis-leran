package com.mybatis.firstdemo;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyselfStringHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    String parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter);

    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        String sqlTimestamp = rs.getString(columnName);
        if (sqlTimestamp != null) {
            return sqlTimestamp+"---hander";
        }
        return null;
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        String sqlTimestamp = rs.getString(columnIndex);
        if (sqlTimestamp != null) {
            return sqlTimestamp+"---hander";
        }
        return null;
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        String sqlTimestamp = cs.getString(columnIndex);
        if (sqlTimestamp != null) {
            return sqlTimestamp+"---hander";

        }
        return null;
    }

}