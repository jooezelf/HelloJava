package ive_login;

import java.sql.Timestamp;

public class Comment {
    private int commentId;
    private int boardNo;
    private String writer;
    private String content;
    private Timestamp regDate;

    public Comment(int commentId, int boardNo, String writer, String content) {
        this.commentId = commentId;
        this.boardNo = boardNo;
        this.writer = writer;
        this.content = content;
    }

    public Comment(int commentId, int boardNo, String writer, String content, Timestamp regDate) {
        this.commentId = commentId;
        this.boardNo = boardNo;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
    }

    public int getCommentId() { return commentId; }
    public int getBoardNo() { return boardNo; }
    public String getWriter() { return writer; }
    public String getContent() { return content; }
    public Timestamp getRegDate() { return regDate; }
}
