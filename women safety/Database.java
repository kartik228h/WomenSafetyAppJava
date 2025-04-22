import java.util.*;
import java.io.*;

public class Database {
    private static Map<String, User> users = new HashMap<>();
    private static List<String> emergencies = new ArrayList<>();
    private static List<String> complaints = new ArrayList<>();
    private static final String FILE_PATH = "user_data.txt"; // Text file path

    public User registerUser(String name, String location) {
        String id = name.substring(0, 3).toUpperCase() + new Random().nextInt(1000);
        User u = new User(id, name, location);
        users.put(id, u);
        writeToFile("User Registered: " + u.getName() + " with ID: " + u.getId());
        return u;
    }

    public User loginUser(String id) {
        return users.get(id);
    }

    public void saveEmergency(String report) {
        emergencies.add(report);
        writeToFile("Emergency Report: " + report);
    }

    public void saveComplaint(String report) {
        complaints.add(report);
        writeToFile("Complaint Report: " + report);
    }

    private void writeToFile(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getEmergencies() {
        return emergencies;
    }

    public List<String> getComplaints() {
        return complaints;
    }
}
