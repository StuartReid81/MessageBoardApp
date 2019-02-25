package wpd2.lab2.Models.ViewModels;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MessageBoardViewModel {

    private String BoardName;

    private String Message;

    private ArrayList<String> Topics;

    //Getters
    public String GetBoardName() { return BoardName; }

    public String GetMessage() { return Message; }

    public ArrayList<String> GetTopics() { return Topics; }

    //Setters
    public void SetBoardName(String BoardName) { this.BoardName = BoardName; }

    public void SetMessage(String Message) { this.Message = Message; }

    public void SetTopics(ArrayList<String> Topics) { this.Topics = Topics; }
}
