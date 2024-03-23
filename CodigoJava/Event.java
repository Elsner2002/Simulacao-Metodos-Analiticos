public class Event implements Comparable<Event>{

    double timestamp;

    public int compareTo(Event other) {
        return Double.compare(this.timestamp, other.timestamp);
    }

    public static class Saida extends Event {
        Saida(double timestamp) {
            this.timestamp = timestamp;
        }
    }
    public static class Chegada extends Event {
        Chegada(double timestamp) {
            this.timestamp = timestamp;
        }
    }
}

