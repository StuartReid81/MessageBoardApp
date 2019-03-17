package wpd2.lab2.Models;

import java.util.HashMap;

public class MessageBoard {

    //Instance variables
    private int Id;

    private String BoardName;

    private String Message;

    //collection of Topics
    private HashMap<Integer, Topic> Topics;


    //Getters
    public int GetId() { return Id; }

    public String GetBoardName() { return BoardName; }

    public String GetMessage() { return Message; }

    public HashMap<Integer, Topic> GetTopics() { return Topics; }


    //Setters
    public void SetId(int Id) { this.Id = Id; }

    public void SetBoardName(String BoardName) { this.BoardName = BoardName; }

    public void SetMessage(String Message) { this.Message = Message; }

    public void SetTopics(HashMap<Integer, Topic> Topics) { this.Topics = Topics; }


    //constructors

    //default
    public MessageBoard() {}

    //overloaded
    public MessageBoard(int Id, String BoardName, String Message) { this.Id = Id; this.BoardName = BoardName; this.Message = Message; Topics = new HashMap<>(); }

    //Methods
    //Create
    public void AddTopic(Topic NewTopic) {
        Topics.put(NewTopic.GetId(), NewTopic);
    }

    //Delete
    public boolean RemoveTopic(int Id) {
        try {
            Topics.remove(Id);
        } catch (Exception e) {
            //if no matching id found return false
            return false;
        }
        //success, return true
        return true;
    }

    //Update
    public boolean EditTopic(int OldId,Topic NewTopic) {
        NewTopic.SetId(OldId);
        if(RemoveTopic(OldId)) {
            AddTopic(NewTopic);
            //success return true
            return true;
        } else {
            //failed, return false
            return false;
        }
    }
}
