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
    private String create_at;


    public BoardResponseDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.contents = board.getContents();
        this.username = board.getUsername();
        this.password = board.getPassword();
        this.create_at = board.getCreated_at();
    }

    public BoardResponseDTO(Long id, String title, String contents, String username, String createAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.username = username;
        this.create_at = createAt;
    }
}
