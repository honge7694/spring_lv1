package com.task.board.dto;

import com.task.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardInfoResponseDTO {
    private Long id;
    private String title;
    private String contents;
    private String username;
    private String create_at;

    public BoardInfoResponseDTO(Long id, String title, String contents, String username, String create_at) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.username = username;
        this.create_at = create_at;
    }
}
