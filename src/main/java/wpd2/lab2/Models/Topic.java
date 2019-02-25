package wpd2.lab2.Models;

import java.util.Date;
import java.util.HashMap;

public class Topic {

    //Instance Variables

    private int Id;

    private String Name;

    private int AuthorId;

    private Date CreatedOn;

    private HashMap<Integer, TopicComment> Comments;


    //Getters
    public int GetId() { return Id; }

    public String GetName() { return Name; }

    public int GetAuthorId() { return AuthorId; }

    public Date GetCreatedOn() { return CreatedOn; }

    public HashMap<Integer, TopicComment> GetComments() { return Comments; }


    //Setters
    public void SetId(int Id) { this.Id = Id; }

    public void SetName(String Name) { this.Name = Name; }

    public void SetAuthor(int AuthorId) { this.AuthorId = AuthorId; }

    public void SetCreatedOn(Date CreatedOn) { this.CreatedOn = CreatedOn; }

    public void SetComments (HashMap<Integer, TopicComment> Comments) { this.Comments = Comments; }

    //constructors

    //default
    public Topic() {}

    //overloaded
    public Topic(int Id, String Name, int AuthorId, Date CreatedOn) { this.Id = Id; this.Name = Name; this.AuthorId = AuthorId; this.CreatedOn = CreatedOn; Comments = new HashMap<>(); }

    //Methods

    //Create Comment
    public void AddComment(TopicComment Comment) {
        Comments.put(Comment.GetId(), Comment);
    }

    //Delete Comment
    public boolean RemoveComment(int Id) {
        try {
            Comments.remove(Id);
        } catch (Exception e) {
            //if no matching id found return false
            return false;
        }
        //success, return true
        return true;
    }


    //Update Comment
    public boolean EditComment(int OldId,TopicComment NewComment) {
        NewComment.SetId(OldId);
        if(RemoveComment(OldId)) {
            AddComment(NewComment);
            //success return true
            return true;
        } else {
            //failed, return false
            return false;
        }
    }
}
