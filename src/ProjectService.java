import java.util.*;

public class ProjectService {

    private TransferService transfer;
    List<TransferService> allTransfers;
    List<TransferService> route;
    List<List<TransferService>> allCombinations = new ArrayList<>();

    public List<List<TransferService>> allTransferCombinations(List<TransferService> allTransfers) {
        for(TransferService transferService : allTransfers){
            List<TransferService> comb = new ArrayList<>();
            for(List<TransferService> transferServices : allCombinations){
                comb.add((TransferService) transferServices);
                comb.add(transferService);
            }
            allCombinations.add(comb);
        }
        return allCombinations;
    }

    public List<TransferService> path(List<List<TransferService>> allCombinations) {
        int costSum = 0;
        int weightSum = 0;
        int minCost = 0;
        HashMap<List<TransferService>, Integer> map = new HashMap<>();
        for (List<TransferService> transfers : allCombinations) {
            for (TransferService transferService : transfers) {
                costSum += transferService.cost;
                weightSum += transferService.weight;
            }
            if (weightSum == transfer.maxWeight) {
                map.put(transfers, costSum);
                minCost = costSum;
                costSum = 0;
                weightSum = 0;

            }
        }
        List<TransferService> finalTransfers = new ArrayList<>();
        for (Map.Entry<List<TransferService>, Integer> pairs : map.entrySet()) {
            if (pairs.getValue() < minCost) {
                minCost = pairs.getValue();
                finalTransfers = pairs.getKey();
            }
        }

        return finalTransfers;
    }
}