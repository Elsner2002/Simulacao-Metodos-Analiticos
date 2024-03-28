import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Simulacao {
    
    public static void main(String[] args) {

        var count = 100_000;
        var currentTime = 0.0;
        var fila = new PriorityQueue<Event>();
        fila.add(new Event.Chegada(2));

        var servers = 1;
        var beingServed = 0;
        var capacity = 5;
        var size = 0;
        var perdas = 0;
        var times = new double[capacity];

        NumberGenerator.count = count;

        while (NumberGenerator.count > 0) {
            var event = fila.poll();

            switch (event) {
                case Event.Saida saida -> {
                    times[size] += saida.timestamp - currentTime;
                    size--;
                    beingServed--;
                    if (size > 0) {
                        var novaSaida = new Event.Saida(currentTime + NumberGenerator.nextRandom(3, 5));
                        fila.add(novaSaida);
                        beingServed++;
                    }
                }
                case Event.Chegada chegada -> {
                    if (size == capacity) {
                        perdas++;
                        return;
                    }
                    if (beingServed < servers) {
                        var saida = new Event.Saida(currentTime + NumberGenerator.nextRandom(3, 5));
                        fila.add(saida);
                        beingServed++;
                    }
                    times[size] += chegada.timestamp - currentTime;
                    size++;
                    var novaChegada = new Event.Chegada(currentTime + NumberGenerator.nextRandom(2, 5));
                    fila.add(novaChegada);
                }
                default -> {}
            }
            
            currentTime = event.timestamp;
        }

        final var totalTime = currentTime;
        
        System.out.println("Distribuicao de probabilidade:");
        IntStream.range(0, times.length).forEach(t -> System.out.printf("%d : %f, ", t, times[t]/totalTime));
        System.out.println();
        System.out.println("Tempos Acumulados:");
        IntStream.range(0, times.length).forEach(t -> System.out.printf("%d : %f, ", t, times[t]));
        System.out.println();
        System.out.println("perdas: " + perdas);
        System.out.println("Tempo Global: " + currentTime);
    }
}
