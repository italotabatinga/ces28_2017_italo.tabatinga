
import CarrinhoDeCompras,Produto,MaiorMenor

carrinho = CarrinhoDeCompras.CarrinhoDeCompras()
carrinho.adiciona(Produto.Produto("banana",100))
carrinho.adiciona(Produto.Produto("laranja",20))
carrinho.adiciona(Produto.Produto("uva",200))
carrinho.adiciona(Produto.Produto("pera",120))

algoritmo = MaiorMenor.MaiorMenor()
algoritmo.encontra(carrinho)

maior = algoritmo.retornaMaior()
menor = algoritmo.retornaMenor()

print("maior valor no carrinho eh ", maior)
print ("menor valor no carrinho eh ",menor)