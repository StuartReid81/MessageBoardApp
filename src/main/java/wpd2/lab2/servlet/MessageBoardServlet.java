package wpd2.lab2.servlet;

import wpd2.lab2.Models.*;
import wpd2.lab2.Models.ViewModels.MessageBoardViewModel;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessageBoardServlet extends BaseServlet {

    //good practice to declare the template that is populated as a constant, why?
    //declare your template here
    private static final String MESSAGE_BOARD_TEMPLATE = "mb.mustache";
    //auto generated, so that servlet can be serialized
    private static final long serialVersionUID = 687117339002032958L;

    public MessageBoardServlet() {
    }

    //right now, setting the data for the page by hand, later that comes from a data store
    private Object getObject() {
        MessageBoard mb = new MessageBoard();
        mb.SetBoardName("Stuart's Message Board");

        HashMap<Integer, Topic> topics = new HashMap<>();

        Topic topic1 = new Topic(1,"Mars",1, new Date(25/2/2019));
        Topic topic2 = new Topic(2,"Earth",1, new Date(25/2/2019));

        topics.put(1, topic1);
        topics.put(2, topic2);

        mb.SetTopics(topics);

        mb.SetMessage("Never eat yellow snow!");

        MessageBoardViewModel mbvm = new MessageBoardViewModel();

        mbvm.SetBoardName(mb.GetBoardName());
        mbvm.SetMessage(mb.GetMessage());


        ArrayList list = new ArrayList<Topic>();

        int count = topics.size();
        for (int i = 1; i <= count; i++) {
            list.add(topics.get(i));
        }

        mbvm.SetTopics(list);

        return mbvm;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showView(response, MESSAGE_BOARD_TEMPLATE, getObject());
    }
}




