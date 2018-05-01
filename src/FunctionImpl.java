import java.rmi.RemoteException;
import java.util.*;

public class FunctionImpl implements Functions {

    public FunctionImpl() {
        super();
    }

    @Override
    public String getMean(ArrayList<Integer> numbers) throws RemoteException {
        StringBuilder answerString = new StringBuilder();
        answerString.append("Here is the mean value: ");
        double total = 0;
        double size = numbers.size();

        // Get the total
        for (Integer number: numbers) {
            total += number;
        }

        double result= total / size;
        answerString.append(" ").append(result);

//        Return the total divided by the size
        return answerString.toString();
    }

    @Override
    public String getMode(ArrayList<Integer> numbers) throws RemoteException {
        StringBuilder answerString = new StringBuilder();
        answerString.append("Here is the mode or modal values: ");

        // Get all the unique numbers in the set
        Set<Integer> uniqueNumbersSet = new HashSet<>(numbers);
        ArrayList<Integer> uniqueNumbers = new ArrayList<Integer>();
        uniqueNumbers.addAll(uniqueNumbersSet);

//        Create a mapping of occurrences
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (Integer unique: uniqueNumbers) {
            occurrences.put(unique, 0);
        }

        // Loop through given numbers and how many times the number occurs to the map
        for (Integer unique: occurrences.keySet()) {
            int targetValue = unique;
            int count = 0;

            for (Integer value: numbers) {
                if (value == targetValue)
                    count++;
            }
            occurrences.put(unique, count);
        }

        // Get all the unique numbers that have the highest values
        int mapMaxValue= Collections.max(occurrences.values());
        for (Map.Entry<Integer, Integer> entry: occurrences.entrySet()) {
            if (entry.getValue() == mapMaxValue) {
                answerString.append(entry.getKey());
                answerString.append(" ");
            }
        }

        return answerString.toString();
    }

    @Override
    public String getMedian(ArrayList<Integer> numbers) throws RemoteException {
        StringBuilder answerString = new StringBuilder();
        answerString.append("Here is the median Value ");

        // Sort the array
        Collections.sort(numbers);
        // Create median value
        double median;

        // Find the median
        if(numbers.size() % 2 == 0) {
            median = ( (double) numbers.get(numbers.size() / 2) + (double) numbers.get(numbers.size() / 2 - 1) )/ 2.0;
        }else {
            median = (double) numbers.get(numbers.size() / 2);
        }

        answerString.append(median);
        return String.valueOf(answerString);
    }

    @Override
    public String getAsc(ArrayList<Integer> numbers) throws RemoteException {
        StringBuilder answerString = new StringBuilder();
        answerString.append("Here are the values in ascending order ");

        // Sort the array
        Collections.sort(numbers);
        // Add numbers to string
        for (Integer integer: numbers) {
            answerString.append(integer);
            answerString.append(" ");
        }

        return answerString.toString();
    }
}
