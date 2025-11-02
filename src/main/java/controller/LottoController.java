package controller;

import domain.*;
import service.LottoService;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService service;

    public LottoController(InputView inputView, OutputView outputView, LottoService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void run(){
        PurchaseAmount purchaseAmount = retryUntilValid(() -> new PurchaseAmount(inputView.inputPurchaseAmount()));
        List<Lotto> lottos = service.purchaseLotto(purchaseAmount);
        outputView.printPurchaseCount(purchaseAmount.countLottos());
        outputView.printLottos(lottos);

        WinningNumbers winningNumbers = retryUntilValid(() -> new WinningNumbers(inputView.inputWinningNumbers()));
        BonusNumber bonusNumber = retryUntilValid(() -> new BonusNumber(inputView.inputBonusNumber(), winningNumbers));

        LottoResult result = service.calculateResult(lottos, winningNumbers, bonusNumber);
        double profitRate = service.calculateProfitRate(result, purchaseAmount);
        outputView.printResult(result, profitRate);
    }

    private <T> T retryUntilValid(Supplier<T> supplier){
        while (true){
            try {
                return supplier.get();
            } catch (IllegalArgumentException e){
                outputView.printError(e.getMessage());
            }
        }
    }
}
