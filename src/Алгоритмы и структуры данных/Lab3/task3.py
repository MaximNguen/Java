import heapq
import matplotlib.pyplot as plt
import networkx as nx

def dijkstra_adj_list(graph, start):
    """
    Алгоритм Дейкстры для списка смежности.
    Возвращает словарь с кратчайшими расстояниями от start до всех вершин.
    """
    distances = {node: float('inf') for node in graph}
    distances[start] = 0
    priority_queue = [(0, start)]
    
    while priority_queue:
        current_dist, current_node = heapq.heappop(priority_queue)
        if current_dist > distances[current_node]:
            continue
        for neighbor, weight in graph[current_node].items():
            distance = current_dist + weight
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(priority_queue, (distance, neighbor))
    return distances

def visualize_dijkstra(graph, start, distances):
    """
    Визуализация графа и кратчайших путей с помощью matplotlib.
    """
    G = nx.Graph()
    
    # Добавляем рёбра и веса из списка смежности
    for node in graph:
        for neighbor, weight in graph[node].items():
            G.add_edge(node, neighbor, weight=weight)
    
    # Расположение вершин
    pos = nx.spring_layout(G, seed=42)
    
    # Настройка цветов:
    # - start: красный
    # - остальные: зелёный (чем темнее, тем больше расстояние)
    node_colors = []
    max_dist = max(distances.values())
    for node in G.nodes():
        if node == start:
            node_colors.append('red')
        else:
            # Нормализуем расстояние для цвета (0-1)
            norm_dist = distances[node] / max_dist if max_dist != 0 else 0
            # Зелёный с градиентом (чем дальше, тем темнее)
            node_colors.append((0, 1 - norm_dist, 0))
    
    # Рисуем граф
    plt.figure(figsize=(10, 8))
    nx.draw(
        G, pos,
        with_labels=True,
        node_color=node_colors,
        node_size=1500,
        edge_color='gray',
        font_weight='bold',
    )
    # Подписываем рёбра весами
    edge_labels = nx.get_edge_attributes(G, 'weight')
    nx.draw_networkx_edge_labels(G, pos, edge_labels=edge_labels)
    
    # Подписываем вершины расстояниями
    for node, (x, y) in pos.items():
        plt.text(
            x, y + 0.1,
            s=f'd={distances[node]}',
            bbox=dict(facecolor='white', alpha=0.8),
            ha='center'
        )
    
    plt.title(f"Алгоритм Дейкстры (старт: {start})")
    plt.show()

# Пример списка смежности (взвешенный граф)
adj_list = {
    'A': {'B': 5, 'C': 3},
    'B': {'A': 5, 'D': 2},
    'C': {'A': 3, 'D': 1},
    'D': {'B': 2, 'C': 1}
}

# Запуск Дейкстры и визуализация
start_node = 'A'
distances = dijkstra_adj_list(adj_list, start_node)
print("Кратчайшие расстояния:", distances)
visualize_dijkstra(adj_list, start_node, distances)
