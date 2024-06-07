package com.busanit501.boot501.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 10;

    // 제목, 내용, 작성자
    // 검색 종류 , t, c, w, tc,tw, twc
    private String type;

    private String keyword;

    // 타입 분리작업
    public String[] getTypes() {
        if(type == null || type.isEmpty()) {
            return null;
        }
        //예시 type={"twc"} -> "t", "w", "c" , 분리함.
        return type.split("");
    }

    // 페이징 정보 반환하기.
    // ...props , 가변 인자 -> (String title, String content, ...)
    // 매개변수에 인자 값으로 여러개의 문자열 타입의 요소를 추가 가능.
    public Pageable getPageable(String...props) {
        // 화면에서 1페이지 -> 0
        // 화면에서 2페이지 -> 1
        return PageRequest.of(this.page - 1,10, Sort.by(props).descending());
    }

}


