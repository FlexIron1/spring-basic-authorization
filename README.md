##Руководство по запуску приложения
Для начала нужно поменять настройки application.properties
Дать доступ к своей базе данных.

 В программе содержится 2 вида пользователя-это ADMIN  и User.
 1)Имя пользователя и пароль от администратора - samat,123.
 2)Имя пользователя и пароль от пользователя - samat2,123.
 Пароли зашифрованы.
 
Создание события посещения сайта пользователем, доступна двум ролям,
приведенным выше.Параметры запросов.

GET-запрос: _/getInfoById/{id}_ -принимает в качесте параметров ID пользователя 
 ,а в ответ возвращает ID пользователя ,а так же список и количество посещений адресов им.

POST-запрос _/infoByUrlsAndId_ - принимает в тело запроса URL и ID пользователя 
,а в ответ возвращает сколько посещений и в какое время посетил эти адреса.

Запросы доступные только для роли ADMIN
POST-запрос _/infoByAnyPeriod/{date}_ - принимает в параметры запроса произвольную дату
и возвращает -
_общее количество посещений за указанный период
           Количество уникальных пользователей за указанный период 
           Количество постоянных пользователей за указанный период
           (пользователей, которые за период просмотрели не менее 10 различных
           страниц)_. 
