package com.busanit501.samplejsp501.menu.dao;

import com.busanit501.samplejsp501.menu.domain.MenuVO;
import com.busanit501.samplejsp501.todo.dao.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {
  public List<MenuVO> selectAll() throws Exception{
    String sql = "select * from lunchmenu";

    @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
    @Cleanup ResultSet resultSet = pstmt.executeQuery();

    List<MenuVO> samples = new ArrayList<MenuVO>();

    while (resultSet.next()){
      MenuVO menuVOBuilder = MenuVO.builder()
          .menuNo(resultSet.getLong("menuNo"))
          .menuTitle(resultSet.getString("menuTitle"))
          .menuRegDate(resultSet.getDate("menuRegDate").toLocalDate())
          .build();
      samples.add(menuVOBuilder);
    }
    return samples;
  }
}







