package com.task.board.service;

import com.task.board.dto.BoardRequestDTO;
import com.task.board.dto.BoardResponseDTO;
import com.task.board.entity.Board;
import com.task.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardResponseDTO createBoard(BoardRequestDTO requestDTO) {
        // RequestDTO -> Entity
        Board board = new Board(requestDTO);
        // DB 저장
        Board saveBoard = boardRepository.save(board);

        BoardResponseDTO boardResponseDTO = new BoardResponseDTO(saveBoard);
        return boardResponseDTO;
    }

    public List<BoardResponseDTO> getBoard() {
        // DB 조회
        List<Board> boards = boardRepository.findAll();
        Collections.reverse(boards);
        return boards.stream().map(BoardResponseDTO::new).toList();
    }


    public BoardResponseDTO detailBoard(Long id) {
        // 해당 게시글이 DB에 존재하는지 확인
        Board board = findBoard(id);
        BoardResponseDTO detailBoard = new BoardResponseDTO(board);

        return detailBoard;
    }

    @Transactional
    public BoardResponseDTO updateBoard(Long id, BoardRequestDTO requestDTO) {
        Board board = findBoard(id);

        if(board != null && requestDTO.getPassword().equals(board.getPassword())) {
            board.update(requestDTO);
        } else if(!requestDTO.getPassword().equals(board.getPassword())) {
            throw new IllegalArgumentException("선택된 게시글의 비밀번호가 일치하지 않습니다.");
        } else {
            System.out.println("board : " + board.getPassword());
            System.out.println("requestDTO : " + requestDTO.getPassword());
            throw new IllegalArgumentException("선택된 게시글은 존재하지 않습니다.");
        }

        BoardResponseDTO updateBoard = new BoardResponseDTO(board);
        return updateBoard;
    }

    public Long deleteBoard(Long id, BoardRequestDTO requestDTO) {
        Board board = findBoard(id);

        if(board != null && requestDTO.getPassword().equals(board.getPassword())) {
            boardRepository.delete(board);
        } else if(!requestDTO.getPassword().equals(board.getPassword())) {
            throw new IllegalArgumentException("선택된 게시글의 비밀번호가 일치하지 않습니다.");
        } else {
            System.out.println("board : " + board.getPassword());
            System.out.println("requestDTO : " + requestDTO.getPassword());
            throw new IllegalArgumentException("선택된 게시글은 존재하지 않습니다.");
        }
        return id;
    }

    private Board findBoard(Long id){
        return boardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다.")
        );
    }
}
