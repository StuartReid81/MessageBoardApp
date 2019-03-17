package wpd2.lab2.DB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wpd2.lab2.Models.MessageBoard;
import wpd2.lab2.Models.Topic;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MessageBoardRepository implements AutoCloseable {

    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(MessageBoardRepository.class);

    public static final String MEMORY = "jdbc:h2:mem:shop";

    private Connection connection;

    static Connection getConnection(String db) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");  // ensure the driver class is loaded when the DriverManager looks for an installed class. Idiom.
        return DriverManager.getConnection(db, "sa", "");  // default password, ok for embedded.
    }

    public MessageBoardRepository() {
        this(MEMORY);
    }

    public MessageBoardRepository(String db) {
        try {
            connection = getConnection(db);
            loadResource("/MessageBoard.sql");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMessageBoard(MessageBoard messageBoard) {
        final String ADD_PERSON_QUERY = "INSERT INTO MessageBoards (BoardName, Message) VALUES (?,?)";
        try (PreparedStatement ps = connection.prepareStatement(ADD_PERSON_QUERY)) {
            ps.setString(1, messageBoard.GetBoardName());
            ps.setString(2, messageBoard.GetMessage());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MessageBoard> getAllMessageBoards() {
        final String LIST_PERSONS_QUERY = "SELECT Id, BoardName, Message FROM MessageBoards";
        List<MessageBoard> out = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(LIST_PERSONS_QUERY)) {
            ResultSet rs = ps.executeQuery();
            MessageBoard mb = new MessageBoard();
            while (rs.next()) {
                mb.SetId(rs.getInt(1));
                mb.SetBoardName(rs.getString(2));
                mb.SetMessage(rs.getString(3));
                mb.SetTopics(getTopicsByMessageBoardId(mb.GetId()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    private void loadResource(String name) {
        try {
            String cmd = new Scanner(getClass().getResource(name).openStream()).useDelimiter("\\Z").next();
            PreparedStatement ps = connection.prepareStatement(cmd);
            ps.execute();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private HashMap<Integer, Topic> getTopicsByMessageBoardId(int Id) {
        final String GET_TOPICS_FOR_MB = "SELECT Id, Name, AuthorId, CreatedOn FROM Topics";
        HashMap<Integer, Topic> out = new HashMap<Integer, Topic>();
        return out;
    }
}
