package com.busanit501.lsylunchproject.repository.search;

import com.busanit501.lsylunchproject.domain.Lunch;
import com.busanit501.lsylunchproject.dto.LunchListReplyCountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LunchSearch {
    Page<Lunch> search(Pageable pageable);

    Page<Lunch> searchAll(String[] types, String keyword ,Pageable pageable);
    // 댓글 개수를 포함한 전체 게시글 목록.
    Page<LunchListReplyCountDTO> searchWithReplyCount(
            String[] types, String keyword ,Pageable pageable
    );
}
