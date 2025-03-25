package com.example.board.controller;

import com.example.board.entity.Board;
import com.example.board.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<Board> boards = boardService.boardList(page);
        model.addAttribute("boards", boards);
        return "list";
    }
    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable Long id) {
        model.addAttribute("board", boardService.findById(id));
        return "detail";
    }

    @GetMapping("/writeForm")
    public String writeForm() {
        return "write";
    }
    @PostMapping("/write")
    public String write(@ModelAttribute Board board) {
        System.out.println(board);
        boardService.save(board);
        return "redirect:/board/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Board board) {
        board.setCreatedAt(LocalDateTime.now());
        boardService.save(board);
        return "redirect:/board/list";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        boardService.deleteById(id);
        return "redirect:/board/list";
    }

}
