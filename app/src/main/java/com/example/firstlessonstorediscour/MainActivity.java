package com.example.firstlessonstorediscour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // задание полей
    private float coat = 70; // пальто
    private int coatDiscount = 77; // скидка (в процентах)
    private float hat = 25; // шляпа
    private int hatDiscount = 37; // скидка (в процентах)
    private float businessSuit = 53; // деловой костюм
    private int businessSuitDiscount = 44; // скидка (в процентах)
    private float shoes = 41; // туфли
    private int shoesDiscount = 32; // скидка (в процентах)
    private float shirt = 19; // сорочка
    private float account = 312; // баланс на счету

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView possibilityOut; // поле возможности покупки
    private TextView balanceOut; // поле возможности остатка от покупки

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        possibilityOut = findViewById(R.id.possibilityOut); // вывод информации о возможности покупки
        balanceOut = findViewById(R.id.balanceOut); // вывод информации о возможном остатке от покупки

        // заполнение экрана
        if (possibility()) { // если имеется возможность купить деловой гардероб
            possibilityOut.setText("Имеется достаточно средств для покупки делового гардероба");
            balanceOut.setText("Остаток от покупки " + balance() + " монет");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки делового гардерода");
            balanceOut.setText(" - ");
        }
    }

    // метод подсчёта стоимости делового гардероба
    private float calculation() {
        // создание и инициализация переменной подсчёта стоимости
        float count = (coat * (100 - coatDiscount) + hat * (100 - hatDiscount)
                + businessSuit * (100 - businessSuitDiscount) + shoes * (100 - shoesDiscount)) / 100 + shirt * 3;
        return count; // возврат подсчитанного значения
    }

    // метод определения возможностей бюджета покупки делового гардероба
    private boolean possibility() {
        if (calculation() <= account) { // если стоимость гардероба меньше имеющихся средств
            return true; // то возврат истинного значения
        } else { // иначе
            return false; // возврат ложного значения
        }
    }

    // метод определения возможной сдачи
    private float balance() {
        if (possibility()) { // если имеется возможность купить деловой гардероб
            return account - calculation(); // то возвращается остаток от покупки
        } else { // иначе
            return -1; // возвращается маркер недостатка денежных средств
        }
    }
}
