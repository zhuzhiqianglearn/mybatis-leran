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

@MappedTypes(Date.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class CustomTimeStampHandler extends BaseTypeHandler<Date> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    Date parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, String.valueOf(parameter.getTime()));

    }

    @Override
    public Date getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        String sqlTimestamp = rs.getString(columnName);
        if (sqlTimestamp != null) {
            return new Date(Long.parseLong(sqlTimestamp));
        }
        return null;
    }

    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        String sqlTimestamp = rs.getString(columnIndex);
        if (sqlTimestamp != null) {
            return new Date(Long.parseLong(sqlTimestamp));
        }
        return null;
    }

    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        String sqlTimestamp = cs.getString(columnIndex);
        if (sqlTimestamp != null) {
            return new Date(Long.parseLong(sqlTimestamp));
        }
        return null;
    }

}