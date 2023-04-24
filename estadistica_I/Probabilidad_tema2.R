TEORÍA TEMA 2 PROBABILIDAD 
  ¿Fila 5 hombres?: 5! [Permutaciones]
  ¿10 atletas en un podium? 5!/(5-3)! [Variaciones]
  ¿Cuantas palabras con PEPPER? 6!/3!2!1! [Permutaciones con rep o Mississippi]
  ¿Grupo 3 numeros ->1:10 sin imp el orden? 10!/3!(10-3)! [Combianciones]
  ¿Cadenas de 5 bits? 5^2 [Variaciones con rep]  

  Proabilidad Condicionada:
   P(B|A)=P(A intersección B)/P(A)
   Fórmula probabilidad total: P(B)= P(A Inters B) U P(A Intersecc A)
					P(B)=P(A)*P(B|A) + P(A)*P(B|A)
   Fórmula de Bayes: P(Aj|B) = P(A intersecc B)/P(A1)*P(B|A1)*P(A2)*P(B|A2) +...

  Si A y B son independientes:
   P(B intersecc A)=P(A)*P(B)
   P(B|A)=P(B)

COMANDOS
Si tenemos TRUE FALSE --> FALSE

```{r}
cond 1 = game[1]=1 & game[2]=0

setdiff( 1:10, 2 ) --> elige nums 1:10 != 2
set::as.set( )
paste(1:10, rep(1:3, each=2)) --> 11 21 32 42 53 ...
choose(40,2) --> combianción 40 sobre 2
rep("X" , 50) --> vector lleno de X
factorial(25) --> 25!
table --> cuenta las veces q ocurre cada elem
strsplit(baraja, " ") --> separar baraja ("1B","2C",...) -> "1" "B" "2" "C" ...
```
función sapply y pur
```{r}
sapply( elem_a_iterar, function(vec) vec[1] )
pur::map_chr(elem_a_iterar,1) --> coge el 1º elem


     
