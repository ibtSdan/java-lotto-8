package controller;

import domain.BonusNumber;
import domain.Lotto;
import domain.PurchaseAmount;
import domain.WinningNumbers;
import generator.NumberGenerator;
import message.ErrorMessage;
import provider.InputProvider;
import service.LottoService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator generator;
    private final LottoService  service;

    public LottoController(InputView inputView, OutputView outputView, NumberGenerator generator, LottoService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = generator;
        this.service = service;
    }

    public void run(){
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        List<Lotto> lottos = service.purchaseLotto(purchaseAmount);
        outputView.printPurchaseCount(purchaseAmount.getValue()/1000);
        outputView.printLottos(lottos);
        WinningNumbers winningNumbers = inputWinningNumbers();
        BonusNumber bonusNumber = inputBonusNumber(winningNumbers);
        // 결과 출력
    }

    // 제너릭으로 리팩토링 할 부분
    private PurchaseAmount inputPurchaseAmount(){
        while (true){
            try{
                return new PurchaseAmount(inputView.inputPurchaseAmount());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumbers inputWinningNumbers(){
        while (true){
            try{
                return new WinningNumbers(inputView.inputWinningNumbers());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber inputBonusNumber(WinningNumbers winningNumbers){
        while (true){
            try{
                return new BonusNumber(inputView.inputBonusNumber(), winningNumbers);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
