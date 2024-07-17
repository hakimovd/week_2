package com.hakimov.calculator.controllers;

import com.hakimov.calculator.db.CalculatorDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalulateController {

    private CalculatorDB calculatorDB;

    @Autowired
    public CalulateController(CalculatorDB calculatorDB) {
        this.calculatorDB = calculatorDB;
    }

    // Получаем страницу с формой калькулятора
    @GetMapping()
    public String getCalculator () {
        return "index";
    }

    // Получаем данные из формы, вычисляем записываем в List и возвращаем результат обратно на страницу
    @PostMapping()
    public String calculateResult (@RequestParam int one_number,
                                   @RequestParam double two_number,
                                   @RequestParam String operator,
                                   Model model) {
        double resaltExpression;

        switch (operator) {
            case("+"):
                resaltExpression = one_number + two_number;
                break;
            case("-"):
                resaltExpression = one_number - two_number;
                break;
            case("*"):
                resaltExpression = one_number * two_number;
                break;
            case("/"):
                resaltExpression = one_number / two_number;
                break;
            default:
                resaltExpression = 0;
                break;
        }

        String result = one_number + " " + operator + " " + two_number + " " + "=" + " " + resaltExpression;

        // Отправляем выражение в вид
        model.addAttribute("result", result);

        // Отправляем в вид все выражения
        model.addAttribute("expressions" , calculatorDB.getExpressions());

        // Сохраняем выражение в Array list
        calculatorDB.save(result);

        return "index";
    }
}
