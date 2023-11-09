package com.task.board.dto;

import com.task.board.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDTO {
    private Long id;
    private String title;
    private String contents;
    private String username;
    private LocalDateTime createdAt;


    public BoardResponseDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.contents = board.getContents();
        this.username = board.getUsername();
        this.createdAt = board.getCreatedAt();
    }

    public BoardResponseDTO(Long id, String title, String contents, String username, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.username = username;
        this.createdAt = createdAt;
    }
}
