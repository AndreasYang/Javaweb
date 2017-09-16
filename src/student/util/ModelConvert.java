package student.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelConvert {
	
	public static List<Map<String, Object>> converList(ResultSet resultSet) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columCount = resultSetMetaData.getColumnCount();
			while (resultSet.next()) {
				Map<String, Object> rowData = new HashMap<String, Object>();
				for (int i = 1; i <= columCount; i++) {
					rowData.put(resultSetMetaData.getColumnLabel(i), resultSet.getObject(i));
				}
				list.add(rowData);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {// ¹Ø±ÕÁ¬½Ó
			try {
				if (resultSet != null)
					resultSet.close();
				resultSet = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return list;
		
	}
}
