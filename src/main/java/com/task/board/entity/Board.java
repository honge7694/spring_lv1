package com.task.board.entity;

import com.task.board.dto.BoardRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "board")
@NoArgsConstructor
public class Board extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "contents", nullable = false)
    private String contents;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;

    public Board(BoardRequestDTO requestDTO) {
        this.title = requestDTO.getTitle();
        this.contents = requestDTO.getContents();
        this.username = requestDTO.getUsername();
        this.password = requestDTO.getPassword();
    }

    public void update(BoardRequestDTO requestDTO) {
        this.title = requestDTO.getTitle();
        this.contents = requestDTO.getContents();
        this.username = requestDTO.getUsername();
        this.password = requestDTO.getPassword();
    }
}
