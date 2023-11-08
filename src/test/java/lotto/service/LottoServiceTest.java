package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @DisplayName("로또 구입 금액이 숫자가 아닌 문자열로 이루어져있을 때 예외 처리")
    @Test
    void inputBuyLottoAmountNotNumber() {
        String buyAmount = "1000abc";

        assertThatThrownBy(() -> lottoService.buyLottoAmountValidate(buyAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 구입 금액이 1000원 단위로 나누어 떨어지지 않을 때 예외 처리")
    @Test
    void inputBuyLottoAmountIndivisible() {
        String buyAmount = "900";

        assertThatThrownBy(() -> lottoService.buyLottoAmountValidate(buyAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}