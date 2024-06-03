package com.lsy1205.lunchex.lunchminiproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

  // 페이징 처리하기 위한 기본 준비물
  @Builder.Default
  @Min(value = 1)
  @Positive
  private int page = 1;

  @Builder.Default
  @Min(value = 10)
  @Max(value = 100)
  @Positive
  private int size = 10;

  public int getSkip() {
    return (page-1) * 10;
  }

  // 페이징 정보를 유지하고, URL 쿼리 스트링으로 매번 붙이기 반복 사용이 되어서
  // 따로 메서드로 구현.
  private String link;

  // 검색, 필터를 위한 준비물.
  private String keyword;
  private String[] types;
  private boolean finished;
  private LocalDate from;
  private LocalDate to;


  // URL 쿼리 스트링, 파라미터 표시 부분 확인.
  // http://localhost:8080/todo/list
  //  ?size=10
  //  &finished=on
  //  &types=t
  //  &types=w
  //  &keyword=%EC%98%A4%EB%8A%98
  //  &from=2024-05-01
  //  &to=2024-05-31

  // 검색 조건 화면에 표시하기 위한 준비물
  public boolean checkType(String type){
    if(types == null || types.length == 0) {
      return false;
    }
    return Arrays.stream(types).anyMatch(type::equals)  ;
  }

  public String getLink() {
    if(link == null ) {
      StringBuilder builder = new StringBuilder();
      builder.append("page="+this.page);
      builder.append("&size="+this.size);

      //추가1, 완료여부
      if(finished) {
        builder.append("&finished=on");
      }

      //추가2, types 의 여부, t , w
      if(types != null && types.length > 0) {
        for(int i = 0; i < types.length; i++) {
          builder.append("&types="+ types[i]);
        }

      }

      //추가3, keyword , 주의 사항, 한글을 사용하기에, 문자열이 깨지면
      // 안되서, URLencoding 한글 깨짐 방지.
      if(keyword != null) {
        try {
          builder.append("&keyword="+ URLEncoder.encode(keyword, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
//          throw new RuntimeException(e);
          e.printStackTrace();
        }
      }

      // 추가4, 날짜, from,
      if(from != null) {
        builder.append("&from="+ from.toString());
      }

      // 추가5, 날짜,  to
      if(to != null) {
        builder.append("&to="+ to.toString());
      }

      link = builder.toString();
    }
    return link;
  }

}







