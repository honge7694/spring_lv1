package com.task.board.controller;


import com.task.board.dto.BoardRequestDTO;
import com.task.board.dto.BoardResponseDTO;
import com.task.board.entity.Board;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.Statement;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final JdbcTemplate jdbcTemplate;

    public BoardController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/")
    public BoardResponseDTO createBoard(@RequestBody BoardRequestDTO requestDTO){
        // RequestDTO -> Entity
        Board board = new Board(requestDTO);

        // DB 저장
        KeyHolder keyHolder = new GeneratedKeyHolder(); // 기본 키를 변환하기 위한 객체

        String sql = "INSERT INTO board(title, contents, username, password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update( con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, board.getTitle());
            preparedStatement.setString(2, board.getContents());
            preparedStatement.setString(3, board.getUsername());
            preparedStatement.setString(4, board.getPassword());

            return preparedStatement;
        },
        keyHolder);

        // DB Insert로 받아온 기본키 확인
        Long id = keyHolder.getKey().longValue();
        board.setId(id);

        // Entity -> ResponseDTO
        BoardResponseDTO boardResponseDTO = new BoardResponseDTO(board);

        return boardResponseDTO;
    }
}
