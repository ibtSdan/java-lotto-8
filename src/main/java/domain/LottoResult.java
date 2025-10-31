package domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> result = new EnumMap<Rank, Integer>(Rank.class);

    public LottoResult(){
        for (Rank rank : Rank.values()){
            result.put(rank, 0);
        }
    }

    public void addRank(Rank rank){
        result.put(rank, result.get(rank)+1);
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public int calculateTotalPrize(){
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
