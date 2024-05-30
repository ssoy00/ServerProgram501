package com.lsy1205.lunchex.lunchminiproject.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
  @Select("select now()")
  String getTime();
}













