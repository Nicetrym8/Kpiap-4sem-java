
# Java workshops BSUIR 2023
Сервис должен принимать два параметра (высота цилиндра, радиус) и вернуть результат подсчёта
объёма цилиндра
## Intro <a href="https://github.com/Nicetrym8/Kpiap-4sem-java/tree/07349a332c2f98fd66b789b5a280c39441070aea">(task1)</a>
1. Создать и запустить локально простой веб/REST сервис, используя любой открытый
(например, в открытом доступе в сети интернет) пример с использованием Java stack:
Spring (Spring Boot)/maven/gradle/Jersey/ Spring MVC. 2. Добавить GET ендпоинт,
принимающий входные параметры в качестве queryParams в URL и возвращающий
результат в виде JSON согласно варианту.
## Error logging/handling <a href="https://github.com/Nicetrym8/Kpiap-4sem-java/tree/eeb7c40ac220da8d8e609e051dbebd7d665215d3">(task2)</a>
1. Добавить валидацию входных параметров с возвращением 400 ошибки, 2. Добавить
обработку внутренних unchecked ошибок с возвратом 500 ошибки 3. Добавить логирование
действий и ошибок 4. Написать unit test
## Collections intro, project structure <a href="https://github.com/Nicetrym8/Kpiap-4sem-java/tree/77f553d63ecd29fc73250c1c19d8cd620118fe26">(task3)</a>
1. Добавить простейший кэш в виде in-memory Map для сервиса. Map должна содержаться в
отдельном бине/классе, который должен добавляться в основной сервис с помощью
dependency injection механизм Spring.
## Concurrency (task4) <a href="https://github.com/Nicetrym8/Kpiap-4sem-java/tree/b68437411a5a47a5f1863929a6d816f9cfdd5df4">(task4)</a>
1. Добавить сервис для подсчёта обращений к основному сервису. Счётчик должен быть
реализован в виде отдельного класса, доступ к которому должен быть синхронизирован. 2.
Используя jmeter/postman или любые другие средвста сконфигурировать нагрузочный тест
и убедиться, что счётчик обращений работает правильно при большой нагрузке.
## Functional programming with Java 8 <a href="https://github.com/Nicetrym8/Kpiap-4sem-java/tree/128a8594820b1be6c0d2a2e68259b76229ecbca5">(task5)</a>  
1. Преобразовать исходный сервис для работы со списком параметров для bulk операций
используя Java 8 лямбда выражения. 2. Добавить POST метод для вызова bulk операции и
передачи списка параметров в виде JSON
## Functional filtering and mapping <a href="https://github.com/Nicetrym8/Kpiap-4sem-java/tree/df336da32bb18d42cf7bf85feb4a535348a8f19b">(task6)</a>
1. Добавить аггрегирующий функционал (подсчёт макс, мин, средних значений) для входных
параметров и результатов с использованием Java 8 map/filters функций. Расширить
результат POST соотвественно.
## Data persistence <a href="https://github.com/Nicetrym8/Kpiap-4sem-java/tree/695ed6c5f7a45de44108023c8ebc52038b53662e">(task7)</a>
1. Добавить возможность сохранения всех результатов вычислений в базе данных или
файле, используя стандартные persistence фреймворки Java (Spring Data/Hibernate/MyBatis)
## Asynchronous calls <a href="https://github.com/Nicetrym8/Kpiap-4sem-java/tree/0b541462eb1421317648ac57f4050497e5b61533">(task8)</a>
1. Добавить возможность асинхронного вызова сервиса используя future, возвращать статус
вызова REST сервиса не дожидаясь результатов подсчётов. Результаты подсчётов должны
быть представлены в БД по предопределённой ID
