import matplotlib.pyplot as plt

def congruente_linear(a, c, M):
    
    xi = (a * xi + c) % M
    xi = xi / M

# Parâmetros do método congruente linear
xi = 123  # Semente inicial
a = 1664525
c = 1013904223
M = 2**32
n = 100000
lista = ""

# Gerar um número pseudoaleatório
congruente_linear(a, c, M)

while n > 0:    
    #Codigo do simulador aqui
    
    
    # Gerar um número pseudoaleatório
    congruente_linear(a, c, M)
    #Decrementa o contador
    n -= 1

