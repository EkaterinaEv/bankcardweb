package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BankCardApiTest2 {
    @Test
    void formTest() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Екатерина Евтюхова");
        $("[data-test-id=phone] input").setValue("+79110000000");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void NegativeTestName() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Ekaterina Евтюхова");
        $("[data-test-id=phone] input").setValue("+79110000000");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void NegativeTestPhone() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Екатерина Евтюхова");
        $("[data-test-id=phone] input").setValue("+7911000000");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void NegativeTestCheckbox() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Екатерина Евтюхова");
        $("[data-test-id=phone] input").setValue("+79110000000");
        $("button").click();
        $("[data-test-id=agreement].input_invalid .checkbox__text").shouldHave(Condition.exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));
    }

    @Test
    public void NameNullTest() {
        open("http://localhost:9999/");
        $("[data-test-id=phone] input").setValue("+79110000000");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void PhoneNullTest() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Екатерина Евтюхова");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }
}
