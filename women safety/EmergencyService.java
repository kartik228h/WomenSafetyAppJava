import java.time.LocalDateTime;

public class EmergencyService {
    public void sendSOS(User user) {
        String ts = LocalDateTime.now().toString();
        String report = String.format(
            "SOS from %s (ID:%s) at %s — Location: %s",
            user.getName(), user.getId(), ts, user.getLocation()
        );
        new Database().saveEmergency(report);
        System.out.println("🚨 Emergency Alert Sent:");
        System.out.println(report);
    }
}
