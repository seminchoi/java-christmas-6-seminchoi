package christmas.message;

import java.util.List;
import java.util.function.Consumer;

public class MessageBuilder {
    private static final String NEW_LINE_CHARACTER = "\n";
    private final StringBuilder stringBuilder = new StringBuilder();

    public void makeShortCircuits(List<Consumer<MessageBuilder>> consumers) {
        for (Consumer<MessageBuilder> consumer : consumers) {
            makeShortCircuit(consumer);
        }
    }

    private void makeShortCircuit(Consumer<MessageBuilder> consumer) {
        consumer.accept(this);
        endShortCircuit();
    }

    public void append(String message) {
        stringBuilder.append(message);
        stringBuilder.append(NEW_LINE_CHARACTER);
    }

    public void endShortCircuit() {
        stringBuilder.append(NEW_LINE_CHARACTER);
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
