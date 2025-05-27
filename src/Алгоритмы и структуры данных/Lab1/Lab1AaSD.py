import numpy as np
import matplotlib.pyplot as plt

insertSort = np.array([1.2527, 1.688, 1.9221, 3.369, 5.0867, 4.7298, 6.1659, 7.4381, 7.7073, 7.2387])
quickSort = np.array([1.1173, 1.3193, 1.3528, 1.6011, 1.8268, 1.6981, 1.8213, 1.9218, 1.8247, 2.4908])
numsOfTest = np.array([100, 200, 300, 400, 500 ,600, 700 ,800, 900, 1000])

plt.plot(numsOfTest, insertSort, label = "Сортировка вставками", marker = "o")
plt.plot(numsOfTest, quickSort, label = "Быстрая сортировка", marker = "o")

plt.title("Сранение времени работы сортировок")
plt.xlabel("Размер массива")
plt.ylabel("Время выполнения (мс)")

plt.legend()
plt.grid()
plt.show()