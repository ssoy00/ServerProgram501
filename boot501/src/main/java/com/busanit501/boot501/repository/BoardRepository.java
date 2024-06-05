package com.busanit501.boot501.repository;

import com.busanit501.boot501.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

// 인터페이스 이름 BoardRepository, 생성시 주의하고,
// JpaRepository<엔티티클래스명,pk(@Id)의 타입>
// 약속.
// 스프링 JPA 진영에서, 기본적인 쿼리 메소드를 만들어줌. crud
public interface BoardRepository extends JpaRepository<Board,Long> {
}













