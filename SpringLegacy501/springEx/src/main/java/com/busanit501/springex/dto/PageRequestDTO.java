package com.busanit501.springex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

  // 검색 , 필터 에 사용할 준비물
  private String keyword;
  private String[] types;
  private boolean finished;
  private LocalDate from;
  private LocalDate to;



  private String link;

  // 반환 , 반복되는 코드, page=1&size=10
  // 위의 내용을 문자열로 타입으로 반환 해주는 기능 분리
  public String getLink() {
    if(link == null) {
      StringBuilder builder = new StringBuilder();
      builder.append("page="+this.page);
      builder.append("&size="+this.size);
      link = builder.toString();
    }
    return link;
  }

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
}







