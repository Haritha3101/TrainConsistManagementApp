import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " - Capacity: " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");
        System.out.println("==================================================");

        // Create large test dataset
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 1; i <= 100000; i++) {
            if (i % 3 == 0) {
                bogies.add(new Bogie("Sleeper", 72));
            } else if (i % 3 == 1) {
                bogies.add(new Bogie("AC Chair", 50));
            } else {
                bogies.add(new Bogie("First Class", 80));
            }
        }

        long loopStart = System.nanoTime();

        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.capacity > 60) {
                loopFiltered.add(bogie);
            }
        }

        long loopEnd = System.nanoTime();
        long loopExecutionTime = loopEnd - loopStart;

        long streamStart = System.nanoTime();

        List<Bogie> streamFiltered = bogies.stream()
                .filter(bogie -> bogie.capacity > 60)
                .collect(Collectors.toList());

        long streamEnd = System.nanoTime();
        long streamExecutionTime = streamEnd - streamStart;

        System.out.println("Loop Execution Time (ns): " + loopExecutionTime);
        System.out.println("Stream Execution Time (ns): " + streamExecutionTime);
        System.out.println();

        System.out.println("Loop Filtered Bogies Count   : " + loopFiltered.size());
        System.out.println("Stream Filtered Bogies Count : " + streamFiltered.size());
        System.out.println();

        if (loopFiltered.size() == streamFiltered.size()) {
            System.out.println("Both loop and stream produced the same result count.");
        } else {
            System.out.println("Mismatch found between loop and stream results.");
        }

        System.out.println();
        System.out.println("UC13 performance benchmarking completed...");
    }
}