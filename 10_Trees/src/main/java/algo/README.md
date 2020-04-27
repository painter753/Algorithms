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