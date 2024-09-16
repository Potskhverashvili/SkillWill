package com.example.GroupWork5.DTO.commentDto;

public class ViewComment {


    private Long commentId;

    private String comment;

    private Long ownerUserId;

    private Long forPostId;

    // ------------------------- Constructors -----------------------------------
    public ViewComment() {
    }

    public ViewComment(Long commentId, String comment) {
        this.commentId = commentId;
        this.comment = comment;
    }

    public ViewComment(Long commentId, String comment, Long forPostId, Long ownerUserId) {
        this.comment = comment;
        this.forPostId = forPostId;
        this.commentId = commentId;
        this.ownerUserId = ownerUserId;
    }

    // ------------------------- Setters and Getters ------------------------


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getForPostId() {
        return forPostId;
    }

    public void setForPostId(Long forPostId) {
        this.forPostId = forPostId;
    }

    public Long getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Long ownerUserId) {
        this.ownerUserId = ownerUserId;
    }
}
