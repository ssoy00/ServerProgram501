package com.lsy1205.lunchex.lunchminiproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

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

  public String getLink() {
    if(link == null ) {
      StringBuilder builder = new StringBuilder();
      builder.append("page="+this.page);
      builder.append("&size="+this.size);
      link = builder.toString();
    }
    return link;
  }

}







