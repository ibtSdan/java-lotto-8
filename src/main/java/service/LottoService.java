package service;

import domain.Lotto;
import domain.PurchaseAmount;
import generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final NumberGenerator generator;

    public LottoService(NumberGenerator generator){
        this.generator = generator;
    }

    public List<Lotto> purchaseLotto(PurchaseAmount amount){
        int count = amount.getValue()/1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++){
            List<Integer> numbers = generator.generateNumbers();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
