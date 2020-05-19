package classes;

import java.util.Objects;

public class Message {
    private int from;
    private int to;
    private String content;
    private long date;
    private String dateString;

    public Message(int from, int to, String content, long date){
        this.from = from;
        this.to = to;
        this.content = content;
        this.date = date;
        this.dateString = getDateString();
    }

    public int getFrom() { return from; }

    public int getTo() { return to; }

    public String getContent() { return content; }

    public long getDate() { return date; }

    public String getDateString() { return DateConverter.format(date); }

    @Override
    public String toString() {
        return String.format("Message{from=%d, to=%d, content='%s', date=%d", from, to, content, date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return from == message.from &&
                to == message.to &&
                date == message.date &&
                Objects.equals(content, message.content);
    }

    @Override
    public int hashCode() { return Objects.hash(from, to, content, date); }
}
