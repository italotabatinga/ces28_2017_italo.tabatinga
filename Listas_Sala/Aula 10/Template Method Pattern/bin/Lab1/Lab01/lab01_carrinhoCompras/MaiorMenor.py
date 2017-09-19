'''
Created on 1 de ago de 2017

@author: barretoabb
'''
class MaiorMenor:
    maior = 0
    menor =1000000
        
    def encontra(self, CarrinhoDeCompras):
        for Produto in CarrinhoDeCompras.itens:
            numero = Produto.valor
            if (numero>self.maior):
                self.maior = numero
            if (numero<self.menor):
                self.menor = numero
    
    def retornaMaior(self):
        return self.maior
    
    def retornaMenor(self):
        return self.menor

