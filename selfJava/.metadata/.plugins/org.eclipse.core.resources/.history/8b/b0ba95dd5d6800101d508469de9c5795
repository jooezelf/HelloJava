package ive_login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // 로그인
    public boolean login(String id, String pw) {
        String sql = "SELECT * FROM users WHERE user_id = ? AND password = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id.trim());
            pstmt.setString(2, pw.trim());
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 게시글 리스트(카테고리별)
    public List<Post> getPostsByCategory(String category) {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT board_no, title, writer, view_count, like_count, reg_date, content, category "
                   + "FROM board WHERE category = ? ORDER BY board_no ASC";

        try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Post p = new Post(
                    rs.getInt("board_no"),
                    rs.getString("title"),
                    rs.getString("writer"),
                    rs.getInt("view_count"),
                    rs.getInt("like_count"),
                    rs.getTimestamp("reg_date"),
                    rs.getString("content"),
                    rs.getString("category")
                );
                posts.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }

    // 게시글 작성 (최대 번호 조회 후 +1로 직접 번호 부여)
    public boolean insertPost(Post post) {
        String sqlGetMax = "SELECT NVL(MAX(board_no), 0) FROM board WHERE category = ?";
        String sqlInsert = "INSERT INTO board (board_no, title, content, writer, category, reg_date, view_count, like_count) "
                + "VALUES (?, ?, ?, ?, ?, SYSDATE, 0, 0)";

        try (Connection conn = DBUtil.getConnection()) {
            conn.setAutoCommit(false);

            int nextBoardNo = 0;
            try (PreparedStatement pstmtMax = conn.prepareStatement(sqlGetMax)) {
                pstmtMax.setString(1, post.getCategory());
                ResultSet rs = pstmtMax.executeQuery();
                if (rs.next()) {
                    nextBoardNo = rs.getInt(1) + 1;
                }
            }

            try (PreparedStatement pstmtInsert = conn.prepareStatement(sqlInsert)) {
                pstmtInsert.setInt(1, nextBoardNo);
                pstmtInsert.setString(2, post.getTitle());
                pstmtInsert.setString(3, post.getContent());
                pstmtInsert.setString(4, post.getWriter());
                pstmtInsert.setString(5, post.getCategory());
                pstmtInsert.executeUpdate();
            }

            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 게시글 삭제 + 번호 재정렬
    public boolean deletePost(Post post) {
        String sqlDelete = "DELETE FROM board WHERE board_no = ?";
        String sqlUpdateSeq = "UPDATE board SET board_no = board_no - 1 WHERE board_no > ?";
        try (Connection conn = DBUtil.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement pstmtDelete = conn.prepareStatement(sqlDelete)) {
                pstmtDelete.setInt(1, post.getBoardNo());
                int deleted = pstmtDelete.executeUpdate();
                if (deleted == 0) {
                    conn.rollback();
                    return false;
                }
            }

            try (PreparedStatement pstmtUpdateSeq = conn.prepareStatement(sqlUpdateSeq)) {
                pstmtUpdateSeq.setInt(1, post.getBoardNo());
                pstmtUpdateSeq.executeUpdate();
            }

            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 조회수 증가
    public boolean increaseViewCount(int boardNo) {
        String sql = "UPDATE board SET view_count = view_count + 1 WHERE board_no = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, boardNo);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 추천수 증가
    public boolean increaseLikeCount(int boardNo) {
        String sql = "UPDATE board SET like_count = like_count + 1 WHERE board_no = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, boardNo);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 댓글 리스트 조회
    public List<Comment> getCommentsByBoardNo(int boardNo) {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT comment_no, board_no, writer, content, reg_date "
                   + "FROM comments WHERE board_no = ? ORDER BY comment_no ASC";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, boardNo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Comment c = new Comment(
                    rs.getInt("comment_no"),
                    rs.getInt("board_no"),
                    rs.getString("writer"),
                    rs.getString("content"),
                    rs.getTimestamp("reg_date")  // Timestamp 로 받음
                );
                comments.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    // 댓글 작성
    public boolean insertComment(Comment comment) {
        String sql = "INSERT INTO comments (comment_no, board_no, writer, content, reg_date) "
                + "VALUES (comments_seq.NEXTVAL, ?, ?, ?, SYSDATE)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, comment.getBoardNo());
            pstmt.setString(2, comment.getWriter());
            pstmt.setString(3, comment.getContent());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 댓글 삭제 + 번호 재정렬 추가
    public boolean deleteComment(int commentNo, String writer) {
        String sqlGetBoardNo = "SELECT board_no FROM comments WHERE comment_no = ? AND writer = ?";
        String sqlDelete = "DELETE FROM comments WHERE comment_no = ? AND writer = ?";
        String sqlUpdateSeq = "UPDATE comments SET comment_no = comment_no - 1 WHERE board_no = ? AND comment_no > ?";

        try (Connection conn = DBUtil.getConnection()) {
            conn.setAutoCommit(false);

            int boardNo = -1;
            // 1) 삭제할 댓글의 board_no 조회
            try (PreparedStatement pstmtGetBoardNo = conn.prepareStatement(sqlGetBoardNo)) {
                pstmtGetBoardNo.setInt(1, commentNo);
                pstmtGetBoardNo.setString(2, writer);
                try (ResultSet rs = pstmtGetBoardNo.executeQuery()) {
                    if (rs.next()) {
                        boardNo = rs.getInt("board_no");
                    } else {
                        // 댓글이 없거나 작성자가 다름
                        conn.rollback();
                        return false;
                    }
                }
            }

            // 2) 댓글 삭제
            try (PreparedStatement pstmtDelete = conn.prepareStatement(sqlDelete)) {
                pstmtDelete.setInt(1, commentNo);
                pstmtDelete.setString(2, writer);
                int deleted = pstmtDelete.executeUpdate();
                if (deleted == 0) {
                    conn.rollback();
                    return false;
                }
            }

            // 3) 댓글 번호 재정렬 (삭제된 번호 이후 댓글들의 번호 -1)
            try (PreparedStatement pstmtUpdateSeq = conn.prepareStatement(sqlUpdateSeq)) {
                pstmtUpdateSeq.setInt(1, boardNo);
                pstmtUpdateSeq.setInt(2, commentNo);
                pstmtUpdateSeq.executeUpdate();
            }

            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ★ 여기서부터 추가 ★
    // boardNo 로 게시글 단건 조회
    public Post getPostByBoardNo(int boardNo) {
        String sql = "SELECT board_no, title, writer, view_count, like_count, reg_date, content, category "
                   + "FROM board WHERE board_no = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, boardNo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Post(
                    rs.getInt("board_no"),
                    rs.getString("title"),
                    rs.getString("writer"),
                    rs.getInt("view_count"),
                    rs.getInt("like_count"),
                    rs.getTimestamp("reg_date"),
                    rs.getString("content"),
                    rs.getString("category")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
