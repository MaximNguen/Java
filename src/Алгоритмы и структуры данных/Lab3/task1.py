import matplotlib.pyplot as plt
import networkx as nx

class Node:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.val = key

def insert(root, key):
    if root is None:
        return Node(key)
    else:
        if key < root.val:
            root.left = insert(root.left, key)
        else:
            root.right = insert(root.right, key)
    return root

def plot_tree(root):
    tree = nx.DiGraph()
    pos = {}
    
    def add_edges(node, x=0, y=0, layer=1):
        if node:
            pos[node.val] = (x, y)
            if node.left:
                tree.add_edge(node.val, node.left.val)
                add_edges(node.left, x - 1/layer, y - 1, layer + 1)
            if node.right:
                tree.add_edge(node.val, node.right.val)
                add_edges(node.right, x + 1/layer, y - 1, layer + 1)
    
    add_edges(root)
    plt.figure(figsize=(8, 5))
    nx.draw(tree, pos, with_labels=True, arrows=False, node_size=2000, node_color='lightblue')
    plt.title("Бинарное дерево поиска (BST)")
    plt.show()


keys = [50, 20, 70, 10, 30, 60, 90]
root = None
for key in keys:
    root = insert(root, key)
plot_tree(root)