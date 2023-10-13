package com.yse.dev.book.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column(length = 200)
    private String title;

    private Integer price;

    @CreationTimestamp
    private LocalDateTime insertDateTime;

    @OneToMany(mappedBy="book", fetch=FetchType.LAZY)
    @Builder.Default
    private List<BookLog> bookLogList = new ArrayList();
}
