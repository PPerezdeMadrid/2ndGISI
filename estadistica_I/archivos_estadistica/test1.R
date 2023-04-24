###TEST DE ESTADISTICA 

# 1º  Tenemos dos urnas: la urna I y la urna II. La urna I contiene tres bolas 
#blancas y cuatro negras mientras que la urna II está inicialmente vacía. 
#Extraemos dos bolas al azar de la urna I y, sin mirar su color, las ponemos 
#dentro de la urna II. A continuación cogemos al azar una bola de la urna I y
#otra bola al azar de la urna II. ¿Cuál es la probabilidad de que ambas sean blancas?

  
  ##URNA 1 y 2 --> 1ª parte:urna I y 2º parte:urna II 
  bolas_totales= c("N", "N", "N", "N", "B", "B", "B")
  bolas_totales=sample(bolas_totales)
  urna_1 = bolas_totales[1:4]
  urna_2 = bolas_totales[5:7]
  
    #sacar dos bolas de cada urna y q sean blancas
    bola_1 = sample(urna_1, 1)
    bola_2 = sample(urna_2,1)
    cond = (bola_1 == "B") &&(bola_2 == "B")
    sum(cond)
    
  N=10000
  sims = replicate(N, {
    bolas_totales= c("N", "N", "N", "N", "B", "B", "B")
    bolas_totales=sample(bolas_totales)
    urna_1 = bolas_totales[1:4]
    urna_2 = bolas_totales[5:7]
    bola_1 = sample(urna_1, 1)
    bola_2 = sample(urna_2,1)
    cond = (bola_1 == "B") &&(bola_2 == "B")
    sum(cond)
  })
  sims
  
  print(
    sum(sims)/N
  )
  
  
  
#2º Hay 39 ex-presidentes de EEUU que han fallecido. ¿Cuál es la probabilidad de 
#que al menos 2 de ellos hayan muerto el mismo dı́a? (Asume que un año tiene 365 dı́as).
  dias = 1:365
    
  #elegir 39 dias aleatorios q se puedan repetir
  dias_p = sample(dias, 39, replace = "TRUE")
  dias_p
  #contar cuanto ocurre cada uno
  table(dias_p)
  #sumar los dias q si y si es >= 2 --> +1
  num_nop = sum(table(dias_p) >=  2)
  cond = (num_nop >=1)
  sum(cond)
  
  N=100
   sims = replicate(N, {
    dias_p = sample(1:365, 39, replace = "TRUE")
    num_nop = sum(table(dias_p) >=  2)
    sum((num_nop >=1)) 
    })
   sims
   
   print(
     sum(sims/N)
   ) 
   #√√ 0.88

#3º Se está desarrollando una nueva mascarilla contra el COVID-19. La mascarilla está 
#formada por N capas sucesivas que filtran el virus del COVID-19. Un virus de COVID-19
#atraviesa una capa de la mascarilla con probabilidad 0.6. ¿Cuántas capas son necesarias 
#para que la probabilidad de que un virus de COVID-19 atraviese todas las capas de la 
#mascarilla sea, como máximo, del 0.1%?
   
  #1 capa --> 0,6^1 // 2 capas = 0.6^2 //...
   posibles_n=1:17
   
  n_con_prob = sapply(posibles_n , function(vec) 0.6^posibles_n[vec])
  n_con_prob
  n_solucion= (n_con_prob <=0.001)
  n = table(n_solucion) + 1
  n
  #14
  
   
#4º Lanzamos varias veces una moneda trucada (la probabilidad de cara es 0.4) hasta que salen 
#2 caras. ¿Cuál es la probabilidad de que se necesiten exactamente 10 lanzamientos para obtener 
#las dos caras? En caso de que quieras resolver el ejercicio por simulaciones, usa el argumento 
#prob de sample().
   
   #prob--> argumento q indica la probabilidad de ocurrencia de los elementos del vector universal.
   # prob se puede incluir un vector de probabilidades en el que cada componente será la probabilidad
   # con la que se elegirá la correspondiente componente del vector que va a ser muestreado.

    #10 lanzamientos --> contar cuantas caras
      moneda = c("T" , "H")
      m_sacada = sample(moneda, 10, replace="TRUE", prob = c(0.6, 0.4))
      sum(m_sacada == "H")
      
      sims_10 = function(){
        moneda = c("T" , "H")
        m_sacada = sample(moneda, 10, replace="TRUE", prob = c(0.6, 0.4))
        sum(m_sacada == "H")
      }
      sims_10()

  N = 5000
  sims =  replicate(N, {
     num_t = sum(sims_10() == 2)
     })
    sims
    
  print(
    sum(sims)/N
  )
  #√√0,12
  
#5º Se sospecha que cierto sorteo de una prestigiosa competición de fútbol se ha amañado
# Se han emparejado 8 equipos para la eliminatoria, sospechosamente cada equipo fuerte 
# se ha emparejado con un equipo débil.¿Cuál es la probabilidad de que los cuatro equipos
# mejores queden emparejados con los 4 peores?. Ten en cuenta que las eliminatorias son
# ida y vuelta, hay que decidir quién juega en local
  
  sims = function(){
    equipos = c(rep("F",4), rep("D", 4))
    equipo = sample(equipos) 
    juego1 = c(equipo[1], equipo[2])
    juego2 = c(equipo[3], equipo[4])
    juego3 = c(equipo[5], equipo[6])
    juego4= c(equipo[7], equipo[8])
    
    casos_fav = function(v){
      cond1 = (v[1] == "D" & v[2]=="F" )
      cond2 = (v[1] == "F" & v[2]=="D" )
      total =c(cond1,cond2)
      sum(total)
    }
    
    if(casos_fav(juego1) + casos_fav(juego2)
       + casos_fav(juego3) + casos_fav(juego4) == 4){
      1
    }else{ 0 }
  }
  
  N=10000
  todos_casos = replicate(N,sims())
  print(
    sum(todos_casos / N)
  )
   #√√22% probabilidades

