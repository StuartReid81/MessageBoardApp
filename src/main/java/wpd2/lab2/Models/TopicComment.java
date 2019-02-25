package wpd2.lab2.Models;

import java.util.Date;

public class TopicComment {

    //Instance Variables
    private int Id;

    private String Name;

    private int AuthorId;

    private Date CreatedOn;

    private TopicComment ReferenceComment;


    //Getters

    public int GetId() {
        return Id;
    }

    public String GetName() {
        return Name;
    }

    public int GetAuthor() {
        return AuthorId;
    }

    public Date GetCreatedOn() {
        return CreatedOn;
    }

    public TopicComment GetReferenceComment() {
        return ReferenceComment;
    }

    //Setters

    public void SetId(int Id) {
        this.Id = Id;
    }

    public void SetName(String Name) {
        this.Name = Name;
    }

    public void SetAuthor(int AuthorId) {
        this.AuthorId = AuthorId;
    }

    public void SetCreatedOn(Date CreatedOn) {
        this.CreatedOn = CreatedOn;
    }

    public void SetReferenceComment(TopicComment ReferenceComment) {
        this.ReferenceComment = ReferenceComment;
    }

    //constructors

    //default
    public TopicComment() {
    }

    //overloaded
    public TopicComment(int Id, String Name, int AuthorId, Date CreatedOn, TopicComment ReferenceComment) {
        this.Id = Id;
        this.Name = Name;
        this.AuthorId = AuthorId;
        this.CreatedOn = CreatedOn;
        this.ReferenceComment = ReferenceComment;
    }
}
