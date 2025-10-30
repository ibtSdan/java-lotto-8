package provider;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputProvider implements InputProvider{
    @Override
    public String input() {
        return Console.readLine();
    }
}
