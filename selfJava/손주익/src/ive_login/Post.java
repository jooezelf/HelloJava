package ive_login;

import java.sql.Timestamp;
import java.util.List;

public class Post {
    private int boardNo;
    private String title;
    private String writer;
    private int viewCount;
    private int likeCount;
    private Timestamp regDate;
    private String content;
    private String category;
    private List<Comment> comments;

    public Post(int boardNo, String title, String writer, int viewCount, int likeCount,
                Timestamp regDate, String content, String category) {
        this.boardNo = boardNo;
        this.title = title;
        this.writer = writer;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.regDate = regDate;
        this.content = content;
        this.category = category;
    }

    public Post(String title, String writer, String content, String category) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.category = category;
    }

    public int getBoardNo() { return boardNo; }
    public String getTitle() { return title; }
    public String getWriter() { return writer; }
    public int getViewCount() { return viewCount; }
    public void setViewCount(int viewCount) { this.viewCount = viewCount; }
    public int getLikeCount() { return likeCount; }
    public void setLikeCount(int likeCount) { this.likeCount = likeCount; }
    public Timestamp getRegDate() { return regDate; }
    public String getContent() { return content; }
    public String getCategory() { return category; }
    public List<Comment> getComments() { return comments; }
    public void setComments(List<Comment> comments) { this.comments = comments; }
}
