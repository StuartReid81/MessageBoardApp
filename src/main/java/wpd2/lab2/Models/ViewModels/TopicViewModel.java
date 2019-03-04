package wpd2.lab2.Models.ViewModels;

import wpd2.lab2.Models.TopicComment;
import wpd2.lab2.Models.User;

import java.util.Date;
import java.util.HashMap;

public class TopicViewModel {

    //Instance Variables

    private String Name;

    private String AuthorName;

    private Date CreatedOn;

    private String Signature;

    private HashMap<Integer, TopicComment> Comments;

    //Getters

    public String GetName() { return Name; }

    public String GetAuthorName() { return AuthorName; }

    public Date GetCreatedOn() { return CreatedOn; }

    public String GetSignature() { return Signature; }

    public HashMap<Integer, TopicComment> GetComments() { return Comments; }


    //Setters

    public void SetName(String Name) { this.Name = Name; }

    public void SetAuthorName(String AuthorName) { this.AuthorName = AuthorName; }

    public void SetCreatedOn(Date CreatedOn) { this.CreatedOn = CreatedOn; }

    public void SetSignature(String Signature) { this.Signature = Signature; }

    public void SetComments (HashMap<Integer, TopicComment> Comments) { this.Comments = Comments; }
}
