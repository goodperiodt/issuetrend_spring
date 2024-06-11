package com.ict_final.issuetrend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_article")
public class Article {
    //기사코드
    @Id
    @Column(name = "article_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleCode;

    //제목
    @Column(length = 500)
    private String title;

    //본문
    @Column(length = 10000)
    private String text;

    //작성날짜
    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    //신문사
    @Column(name = "news_agency", length = 50)
    private String newsAgency;

    //회원 번호
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User user;

    //사진
    @Column(length = 2500)
    private String img;

    //기사링크
    @Column(name = "article_rink",length = 2500)
    private String articleRink;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<ArticleComments> articleComments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<PostComments> postComments;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<KeyWords> keyWords;

}
