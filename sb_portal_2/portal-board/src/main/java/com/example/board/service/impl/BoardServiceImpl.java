package com.example.board.service.impl;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import com.example.board.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }
    @Override
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    public Board findById(Long id) {
        return boardRepository.findById(id).get();
    }

    @Override
    public void save(Board board) {
        boardRepository.save(board);
    }
    @Override
    public Page<Board> boardList(int page) {
        return boardRepository.findAllByOrderByIdDesc(PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "id")));
    }

}
