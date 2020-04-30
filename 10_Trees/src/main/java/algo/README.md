# Lesson 10
## Test tree for 100000 elements. Order: random
| TreeName | Add item | Get Item | Remove Item |
| --- | --- | --- | --- |
| BS Tree | 44 | 6 | 11 |
| AVL Tree | 164 | 9 | 16 |
| C Tree | 220 | 1 | 20 |

## Test tree for 100000 elements. Order: ascended
| TreeName | Add item | Get Item | Remove Item |
| --- | --- | --- | --- |
| BS Tree | 10697 | 1134 | 1081 |
| AVL Tree | 36 | 3 | 4 |
| C Tree | 59 | 1 | 11 |

## Вывод
Если элементы поступают в произвольном порядке, то временные затарты для 
BS Tree сравнительно такие же или ниже чем у AVL и Cartesian Tree.

В случае, если порядок следования элементов строго определен (по возрастани или убыват), 
то предпочтительнее использовать деревья с возможностью балансировки. 
Это позволит сократить время на поиск элемента в дереве.

# Lesson 11
## Test tree for 1000000 elements. Order: random
| TreeName | Add item | Get Item | Remove Item |
| --- | --- | --- | --- |
| AVL Tree | 1412 | 90 | 104 |
| C Tree | 1880 | 5 | 217 |
| Splay Tree | 2357 | 314 | 142 |
| RND Tree | 1820 | 149 | 110 |

## Test tree for 1000000 elements. Order: ascended
| TreeName | Add item | Get Item | Remove Item |
| --- | --- | --- | --- |
| AVL Tree | 252 | 94 | 117 |
| C Tree | 1487 | 3 | 208 |
| RND Tree | 1499 | 99 | 125 |
| Splay Tree | 2545 | 332 | 143 |

## Вывод
Затраты на вытягивание элементов ближе к корню не компенсируют производительность для RND и Splay Tree по сравнению с AVL Tree
Что касается сравнения RND Tree и Splay Tree, последняя структура проигрывает в производительности за счет того, что при каждом действии, будь то вставка, удаление или поиск элемента гарантированно запускается процесс перетряхивания дерева, а это требует дополнительных временных затрат.
