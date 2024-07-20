Необходимо преобразовать собранное на семинаре дерево поиска в полноценное левостороннее красно-чёрное дерево. Реализовать метод добавления новых элементов с балансировкой.
- Красно-чёрное дерево имеет следующие критерии:
- Каждая нода имеет цвет (красный или черный);
- Корень дерева всегда черный;
- Новая нода всегда красная;
- Красные ноды могут быть только левым дочерним элементом;
- У красной ноды все дочерние элементы черного цвета.

Соответственно, чтобы данные условия выполнялись, после добавления элемента в дерево необходимо произвести балансировку, благодаря которой все критерии выше станут валидными.
Для балансировки существует 3 операции:
- левый малый поворот
- правый малый поворот
- смена цвета.

Критерии применения этих операций следующие:
- Если правый дочерний элемент красный, а левый черный, то применяем малый правый поворот
- Если левый дочерний элемент красный и его левый дочерний элемент тоже красный, то применяем малый левый поворот
- Если оба дочерних элемента красные, то делаем смену цвета
- Если корень стал красным, то перекрашиваем его в черный
