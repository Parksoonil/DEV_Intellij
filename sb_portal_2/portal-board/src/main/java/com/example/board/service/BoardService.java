package com.example.board.service;

import com.example.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {
    List<Board> findAll();
    Board findById(Long id);
    void save(Board board);
    void deleteById(Long id);
    Page<Board> boardList(Pageable pageable);
}
