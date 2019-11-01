/**
 * The class represents any transaction in the system.
 */
public class Transaction {
    private String date;
    private String name;
    private String type;
    private String detailedContent;
    private String fee;

    public Transaction(String date, String name, String type, String detailedContent, String fee) {
        this.date = date;
        this.name = name;
        this.type = type;
        this.detailedContent = detailedContent;
        this.fee = fee;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDetailedContent() {
        return detailedContent;
    }

    public String getFee() {
        return fee;
    }
}
