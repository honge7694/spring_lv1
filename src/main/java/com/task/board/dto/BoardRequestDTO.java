package com.task.board.dto;

import lombok.Getter;

@Getter
public class BoardRequestDTO {
    private String title;
    private String contents;
    private String username;
    private String password;
    private String create_at;
}
