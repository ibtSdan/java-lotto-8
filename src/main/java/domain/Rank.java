package domain;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(4, false, 1500000),
    FOURTH(3, false, 50000),
    FIFTH(3, false, 5000),
    MISS(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    Rank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getPrize(){
        return prize;
    }

    public static Rank of(int matchCount, boolean matchBonus){
        if (matchCount == 6){
            return FIRST;
        }
        if (matchCount == 5 && matchBonus){
            return SECOND;
        }
        if (matchCount == 4){
            return THIRD;
        }
        if (matchCount == 3){
            return FIFTH;
        }
        return MISS;
    }
}
