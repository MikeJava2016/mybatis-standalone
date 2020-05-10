package com.gupaoedu.type;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MobileTypeHandler extends BaseTypeHandler<List<Integer>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Integer> parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("MobileTypeHandler => setNonNullParameter");

        String res = parameter.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(","));
        ps.setString(i,res);
    }

    @Override
    public List<Integer> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("MobileTypeHandler => getNullableResult(ResultSet rs, String columnName)");
        String res = rs.getString(columnName);
        if (Objects.nonNull(res)) {
            List<Integer> collect = Arrays.stream(res.split(",")).map(x -> Integer.parseInt(x)).collect(Collectors.toList());
            return collect;
        }
        return null;
    }

    @Override
    public List<Integer> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("MobileTypeHandler => getNullableResult(ResultSet rs, int columnIndex)");
        String res = rs.getString(columnIndex);
        if (Objects.nonNull(res)) {
            List<Integer> collect = Arrays.stream(res.split(",")).map(x -> Integer.parseInt(x)).collect(Collectors.toList());
            return collect;
        }
        return null;
    }

    @Override
    public List<Integer> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("MobileTypeHandler => getNullableResult(CallableStatement cs, int columnIndex)");
        String res = cs.getString(columnIndex);
        if (Objects.nonNull(res)) {
            List<Integer> collect = Arrays.stream(res.split(",")).map(x -> Integer.parseInt(x)).collect(Collectors.toList());
            return collect;
        }
        return null;
    }
}
