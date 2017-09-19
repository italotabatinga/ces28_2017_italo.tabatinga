'''
Created on 1 de ago de 2017

@author: barretoabb
'''
import unittest
import CarrinhoDeCompras,Produto,MaiorMenor


class Test(unittest.TestCase):
    
    def setUp(self):
        self.carrinho = CarrinhoDeCompras.CarrinhoDeCompras()
        self.carrinho.adiciona(Produto.Produto("banana",100))
        self.carrinho.adiciona(Produto.Produto("laranja",20))
        self.carrinho.adiciona(Produto.Produto("uva",200))
        self.carrinho.adiciona(Produto.Produto("pera",120))
        
    
    def test_checkMaiorMenor(self):
        algoritmo = MaiorMenor.MaiorMenor()
        algoritmo.encontra(self.carrinho)
        
        self.assertEqual(200,algoritmo.retornaMaior())
        self.assertEqual(20,algoritmo.retornaMenor())
        
        



