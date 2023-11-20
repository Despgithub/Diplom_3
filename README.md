# Diplom_3

<hr>
Дипломный проект по тестированию UI приложения по заказу бургеров Stellar Burgers.

## Описание

<hr>
На проекте используется Java 11 и Maven и следующие библиотеки:
<ul>
<li>Selenium 4.15.0</li>
<li>Junit 4.13.2</li>
<li>Rest-assured 5.3.2</li>
<li>Gson 2.10.1</li>
<li>Allure 2.24.0</li>
<li>Lombok 1.18.30</li>
<li>Javafaker 1.0.2</li>
<li>Aspectj 1.9.20.1</li>
</ul>

## Запуск тестов

По умолчанию тесты запускаются в _Google Chrome_, для запуска в _Яндекс.Браузер_ необходимо использовать параметр *
*_-Dbrowser=yandex_**
<hr>

```
mvn clean test
```

## Генерация отчета Allure

<hr>

```
mvn allure:serve
```

## Запуск тестов и генерация отчета Allure

<hr>

```
mvn clean test allure:serve
```