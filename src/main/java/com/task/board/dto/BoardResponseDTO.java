package com.task.board.dto;

import com.task.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDTO {
    private Long id;
    private String title;
    private String contents;
    private String username;
    private String password;


    public BoardResponseDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.contents = board.getContents();
        this.username = board.getUsername();
        this.password = board.getPassword();
    }
}
