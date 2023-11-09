package com.task.board.controller;


import com.task.board.dto.BoardRequestDTO;
import com.task.board.dto.BoardResponseDTO;
import com.task.board.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) { this.boardService = boardService; }

    @PostMapping("/")
    public BoardResponseDTO createBoard(@RequestBody BoardRequestDTO requestDTO){
        return boardService.createBoard(requestDTO);
    }

    @GetMapping("/")
    public List<BoardResponseDTO> getBoard() {
        return boardService.getBoard();
    }

    @GetMapping("/{id}")
    public BoardResponseDTO detailBoard(@PathVariable Long id){
        return boardService.detailBoard(id);
    }

    @PutMapping("/{id}")
    public BoardResponseDTO updateBoard(@PathVariable Long id, @RequestBody BoardRequestDTO requestDTO){
        return boardService.updateBoard(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public Long DeleteBoard(@PathVariable Long id, @RequestBody BoardRequestDTO requestDTO) {
        return boardService.deleteBoard(id, requestDTO);
    }
}
