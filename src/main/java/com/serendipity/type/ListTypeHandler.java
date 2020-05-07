package com.serendipity.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ListTypeHandler extends BaseTypeHandler<List<Integer>> {

    public void setNonNullParameter(PreparedStatement ps, int i, List<Integer> integers, JdbcType jdbcType) throws SQLException {
        StringBuffer sf = new StringBuffer();
        for (int j = 0; j < integers.size(); j++) {
            if (j!=integers.size()-1){
                sf.append(integers.get(j)).append(",");
            } else {
                sf.append(integers.get(j));
            }
        }
        ps.setString(i,sf.toString());
    }

    public List<Integer> getNullableResult(ResultSet rs, String s) throws SQLException {
        String result = rs.getString(s);
        String[] resultArray = result.split("\\,");
        List<Integer> resultList = new ArrayList<Integer>();
        for (int i = 0; i < resultArray.length; i++) {
            resultList.add(Integer.parseInt(resultArray[i]));
        }
        return resultList;
    }

    public List<Integer> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String result = rs.getString(columnIndex);
        String[] resultArray = result.split("\\,");
        List<Integer> resultList = new ArrayList<Integer>();
        for (int i = 0; i < resultArray.length; i++) {
            resultList.add(Integer.parseInt(resultArray[i]));
        }
        return resultList;
    }

    public List<Integer> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String result = cs.getString(columnIndex);
        String[] resultArray = result.split("\\,");
        List<Integer> resultList = new ArrayList<Integer>();
        for (int i = 0; i < resultArray.length; i++) {
            resultList.add(Integer.parseInt(resultArray[i]));
        }
        return resultList;
    }
}