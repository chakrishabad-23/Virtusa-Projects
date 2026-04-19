import java.time.LocalDate;

public class IssueRecord {
    private int userId;
    private LocalDate issueDate;

    public IssueRecord(int userId, LocalDate issueDate) {
        this.userId = userId;
        this.issueDate = issueDate;
    }

    public int getUserId() { return userId; }
    public LocalDate getIssueDate() { return issueDate; }
}