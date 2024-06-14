package com.busanit501.lsylunchproject.repository;

import com.busanit501.lsylunchproject.domain.LunchReply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LunchReplyRepository extends JpaRepository<LunchReply, Long> {
    @Query("select r from LunchReply r where r.lunch.mno = :mno")
    Page<LunchReply> listOfBoard(Long mno, Pageable pageable);
}

