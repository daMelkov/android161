## Задача 1. Открыть адрес на GoogleMap
### Описание
Работа с API любых карт - важная задача для любого бизнес-приложения: будь то интернет-магазин или справочная система. Создадим экран для поиска адреса с использованием Google-карт.

Для этого создайте новый экран со следующими элементами:
- EditText для ввода названия объекта или координат;
- Кнопка “Ищем” - по нажатию на нее переходим в Google-карты и ищем введенный в EditText адрес или координаты.

### Реализация
1. Создайте экран с компонентами EditText для ввода названия объекта или координат;
2. Создайте новый Intent с параметром action - Intent.ACTION_VIEW;
3. Создайте Uri для передачи в качестве параметра data. (intent.setData(uri));
4. Так как программа должна открывать карту и по координатам, и по адресу, то создание Uri должно быть зависимо от вводимых данных:
    - Если пользователь ввел координаты, то Uri примет следующий вид:
    ```
    Uri uri = Uri.parse("geo:55.704968, 37.625206")
    ```
    - Если пользователь ввел адрес, то Uri примет следующий вид:
    ````
    Uri uri = Uri.parse("geo:?q=Moscow")
    ```
В место слово Moscow, можно указать что угодно, например :"аэропорт шереметьево".
5. Нужно проверить ввел ли пользователь координаты или адрес, например можно проверить наличие букв в вводимом тексте. От этого зависит, какой вид Uri нужно применить. Проверку на наличие букв можно осуществить с помощью метода Character.isLetter(), который при входе получает символ, например: Character.isLetter('т')
6. Запускаем созданные Intent с параметрами нажатия кнопки “Ищем”
```
startActivity(intent);
```

![](screen.png)