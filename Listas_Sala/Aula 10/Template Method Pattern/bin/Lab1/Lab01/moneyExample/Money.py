'''
Created on 1 de ago de 2017

@author: barretoabb
'''
class Money:
    amount=0
    currency=""
    
    def __init__(self):
        pass
        
    def getAmmount(self):
        return self.amount;
    
    def setAmmount(self,ammount):
        self.amount=ammount
        
    def getCurrency(self):
        return self.currency;
    
    def setCurrency(self,currency):
        self.currency=currency;
    
    def addMoney(self, Money):
        amt= Money.getAmmount() 
        self.amount=self.amount+amt
        
        
