# Java Junior (семинары)

## Урок 1. Лямбды и Stream API

**[Задание 1](https://github.com/ivvi04/JavaJunior/tree/master/src/main/java/ru/lakeevda/lesson1/task1)**

Напишите программу, которая использует Stream API для обработки списка чисел. 
Программа должна вывести на экран среднее значение всех четных чисел в списке.

**[Задание 2](https://github.com/ivvi04/JavaJunior/tree/master/src/main/java/ru/lakeevda/lesson1/task2)**

**Дополнительная задача**

Переработать метод балансировки корзины товаров cardBalancing() с использованием Stream API

## Урок 2. Reflection API

**[Задание 1](https://github.com/ivvi04/JavaJunior/tree/master/src/main/java/ru/lakeevda/lesson2/task1)**

Создайте абстрактный класс "Animal" с полями "name" и "age".

Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.

Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:

Выведите на экран информацию о каждом объекте.

Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.

**[Задание 2](https://github.com/ivvi04/JavaJunior/tree/master/src/main/java/ru/lakeevda/lesson2/task2)**

**Дополнительная задача**

Доработайте метод генерации запроса на удаление объекта из таблицы БД (`DELETE FROM <Table> WHERE ID = '<id>'`)
в классе QueryBuilder который мы разработали на семинаре.

## Урок 3. Сериализация

**[Задание 1](https://github.com/ivvi04/JavaJunior/tree/master/src/main/java/ru/lakeevda/lesson3/task1)**

Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).

Обеспечьте поддержку сериализации для этого класса.

Создайте объект класса Student и инициализируйте его данными.

Сериализуйте этот объект в файл.

Десериализуйте объект обратно в программу из файла.

Выведите все поля объекта, включая GPA, и ответьте на вопрос, почему значение GPA не было сохранено/восстановлено.

**[Задание 2](https://github.com/ivvi04/JavaJunior/tree/master/src/main/java/ru/lakeevda/lesson3/task2)**

**Дополнительная задача**

Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы)