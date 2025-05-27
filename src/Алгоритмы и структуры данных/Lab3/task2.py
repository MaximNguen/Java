import networkx as nx
import matplotlib.pyplot as plt

# Создаем граф
G = nx.Graph()

# Добавляем вершины и ребра (соответствуют Java-коду)
edges = [(0, 1), (0, 2), (1, 3), (1, 4), (2, 4), (3, 4), (3, 5), (4, 5)]
G.add_edges_from(edges)

# Рисуем граф
plt.figure(figsize=(8, 6))
pos = nx.spring_layout(G)  # Позиции вершин для визуализации
nx.draw_networkx_nodes(G, pos, node_size=700, node_color='lightblue')
nx.draw_networkx_edges(G, pos, width=2, edge_color='gray')
nx.draw_networkx_labels(G, pos, font_size=12, font_family='sans-serif')

# Добавляем заголовок
plt.title("Визуализация графа с 6 вершинами", size=15)
plt.axis('off')  # Отключаем оси
plt.tight_layout()
plt.show()