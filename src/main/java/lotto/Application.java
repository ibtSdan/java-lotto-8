package lotto;

import controller.LottoController;
import generator.NumberGenerator;
import generator.RandomNumberGenerator;
import provider.ConsoleInputProvider;
import provider.InputProvider;
import service.LottoService;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputProvider provider = new ConsoleInputProvider();
        InputView inputView = new InputView(provider);
        OutputView outputView = new OutputView();
        NumberGenerator generator = new RandomNumberGenerator();
        LottoService service = new LottoService(generator);

        LottoController controller = new LottoController(inputView, outputView, service);

        controller.run();
    }
}
