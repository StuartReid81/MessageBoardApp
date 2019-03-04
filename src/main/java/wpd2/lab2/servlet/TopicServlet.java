package wpd2.lab2.servlet;

import wpd2.lab2.Models.*;
import wpd2.lab2.Models.ViewModels.MessageBoardViewModel;
import wpd2.lab2.Models.ViewModels.TopicViewModel;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TopicServlet extends BaseServlet {

    //good practice to declare the template that is populated as a constant, why?
    //declare your template here
    private static final String TOPIC_TEMPLATE = "topic.mustache";
    //auto generated, so that servlet can be serialized
    private static final long serialVersionUID = 687117339002032958L;

    public TopicServlet() {
    }

    //right now, setting the data for the page by hand, later that comes from a data store
    private Object getObject(String TopicIdString) {

        int TopicId = Integer.parseInt(TopicIdString);

        Topic topic;

        if (TopicId == 1)
        {
            topic = new Topic(1,"Mars",1, new Date(25/2/2019));
        } else {
            topic = new Topic(2,"Earth",1, new Date(25/2/2019));
        }

        User user = new User(1,"Faisal",null, "I love Lamp");

        TopicViewModel tvm = new TopicViewModel();

        tvm.SetAuthorName(user.GetName());
        tvm.SetSignature(user.GetSignature());

        tvm.SetCreatedOn(topic.GetCreatedOn());
        tvm.SetName(topic.GetName());

        return tvm;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showView(response, TOPIC_TEMPLATE, getObject(request.getParameter("id")));
    }
}