package com.task.board.entity;

import com.task.board.dto.BoardRequestDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Board {
    private Long id;
    private String title;
    private String contents;
    private String username;
    private String password;

    public Board(BoardRequestDTO requestDTO) {
        this.title = requestDTO.getTitle();
        this.contents = requestDTO.getContents();
        this.username = requestDTO.getUsername();
        this.password = requestDTO.getPassword();
    }
}
