import Money

mn1 = Money.Money()
mn1.setAmmount(100)
mn1.setCurrency("R$")

mn2 = Money.Money()
mn2.setAmmount(300)
mn2.setCurrency("R$")

mn2.addMoney(mn1)
print(mn2.getAmmount())