n=22 # publicly known 
g=42 # publicly known
x=13 # only Alice knows this 
y=53 # only Bob knows this

aliceSends = (g**x)%n 
bobComputes = (aliceSends**y)%n
bobSends = (g**y)%n
aliceComputes = (bobSends**x)%n

print "Alice sends    ", aliceSends , "\nBob computes   ", bobComputes 
print "Bob sends      ", bobSends , "\nAlice computes ", aliceComputes