package com.yse.dev.book.dto;

import com.yse.dev.book.entity.BookLog;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class BookLogReadResponseDTO {
    private Integer bookLogId;
    private String comment;
    private Integer page;
    private LocalDateTime insertDateTime;
    private String displayComment;

    public BookLogReadResponseDTO fromBookLog(BookLog bookLog) {
        this.bookLogId = bookLog.getBookLogId();
        this.comment = bookLog.getComment();
        this.page = bookLog.getPage();
        this.insertDateTime = bookLog.getInsertDateTime();
        this.displayComment = (this.page == null ? "" : "(p." + String.valueOf(this.page) + ".)") + this.comment;

        return this;
    }

    public static BookLogReadResponseDTO BookLogFactory(BookLog bookLog) {
        BookLogReadResponseDTO bookLogReadResponseDTO = new BookLogReadResponseDTO();
        bookLogReadResponseDTO.fromBookLog(bookLog);
        return bookLogReadResponseDTO;
    }
    // displayComment는 책 기록을 보여주기 위한 가상의 필드
}
