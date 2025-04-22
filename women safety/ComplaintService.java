import java.time.LocalDateTime;

public class ComplaintService {
    public void fileComplaint(User user, String details) {
        String ts = LocalDateTime.now().toString();
        String rec = String.format(
            "Complaint by %s (ID:%s) at %s — %s",
            user.getName(), user.getId(), ts, details
        );
        new Database().saveComplaint(rec);
        System.out.println("✅ Complaint Registered:");
        System.out.println(rec);
    }
}
