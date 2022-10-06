package com.blog.myblog.entity;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.UUID;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//
//@Entity
//@Table(name = "comments")
//public class Comment {
//
//    @Id
//    @GeneratedValue(
//            strategy = GenerationType.IDENTITY
//    )
//    private UUID commentId;
//
//    private String name;
//    private String email;
//    private String body;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "post_id", nullable = false)
//    private Post post;
//
//}


import com.blog.myblog.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Id
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
//    private UUID id;

    private String name;
    private String email;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
}
