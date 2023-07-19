import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class CardTest1 {
    @BeforeEach
    void setUpTests() {
        open("http://localhost:9999/");
    }

    @Test
    void shouldSendForm() {

        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79001005050");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
    @Test
    void shouldSendFormWithDashInName() {

        $("[data-test-id=name] input").setValue("Иванов-Сидоров Иван ");
        $("[data-test-id=phone] input").setValue("+79001005050");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void shouldSendFormWithLetterYoInName() {

        $("[data-test-id=name] input").setValue("Иванёв Иван");
        $("[data-test-id=phone] input").setValue("+79001005050");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void shouldSendFormWithDashAndWhitespaceInName() {

        $("[data-test-id=name] input").setValue("Иванов- Сидоров Иван Иванович ");
        $("[data-test-id=phone] input").setValue("+79001005050");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

}
