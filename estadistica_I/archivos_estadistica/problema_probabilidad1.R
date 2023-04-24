
# es una baraja española, cual es la probabilidad de sacar una
# pareja en una mano de tres cartas

# Regla LaPlace = nº casos favorables / nº casos totales (equiprobable)
# 4 palos, 10 nos.

c("O", "B", "C", "E") #oros bastos copas espadas

# FORMA CUTRE:

sim_cases = function() {         #simulador de casis
baraja = c(
  paste("O", 1:10),
  paste("B", 1:10),
  paste("C", 1:10),
  paste("E", 1:10)
)
#GENERAR CASOS
#coger tres cartas y sacarlas por pantalla
#sample--> acepta: la urna de donde voy a sacar cosa y cuantas cosas quiero sacar
#sample(baraja, 3)
sets::as.set(sample(baraja, 3))
}
sim_cases()

#choose(40,3)--> combinaciones 40 sobre 3


#tres cartas donde te aseguras q dos son iguales
    # 1º: elijo un número >> 3
 n = sample(1:10 , 1)
  #2º: elijo dos palos >> B,O--> pareja= 3B y 3O
 palos = sample(c("E", "c", "B", "O"), 2)
 pareja = paste(palos , n)
    #elijo una carta que no tenga el 3 --> C 4 
 #cartas_validas = setdiff(cards, paste("E", "c", "B", "O")) , n)
 ###### MIRAR EJERCICIO CPRREGIDO COLGADO

 ?setdiff

bebidas = c("cafe","cafe","cafe", "canna", "canna")
formas_bar = function() {z  
  choose(bebidas, 1) 
  i = 1
  choose(bebidas - i, 1)
  i = i + 1 
}



sim_cases = function(){
  cartas = paste(c("E", "C", "B", "O"), rep(1:10, each = 4))
  set::as:set(sample(cards, 3))          #--> nº formas-Combinacion: Choose(40,3)
}

sim_fav_case() = function(){
  # 1) Elijo un numero para mi pareja
  numero_pareja = sample(1:10,1)                        #--> nº formas: 10
  # 2) ELijo 2 palos entre los 4 posibles para combinar con el numero
  palos = sample(c("E", "C", "B", "O"),2)               #--> nº formas: choose (4,2)
  mi_pareja = paste (palos, numero_pareja)
  # 4) Entre las 40 - 4 cartas con un numero distinto a mi pareja, elijo una
  num_validos = setdiff(1:10, numero_pareja)                                              ##setdiff --> numero ≠ al num_pareja
  cartas_restantes = paste(c("E", "C", "B", "O"), rep(num_validos, each = 4))
  final_carta = set::as.set(c(mi_pareja, final_carta))
 
}

sim_cases = function(){
  cartas = paste(c("E", "C", "B", "O"), rep(1:10, each = 4))
  sample(cards, 3)          #--> nº formas: variaciones(40,3)
}

sim_fav_cases = function(){
  # 1) Elijo un numero para mi pareja
  numero_pareja = sample(1:10,1)                        #--> nº formas: 10
  # 2) Entre las 40 - 4 cartas con un numero distinto a mi pareja, elijo una
  num_validos = setdiff(1:10, numero_pareja)                                              ##setdiff --> numero ≠ al num_pareja
  cartas_restantes = paste(c("E", "C", "B", "O"), rep(num_validos, each = 4))
  carta_final = sample(cartas_restantes, 1)            #--> nº formas:36
  # 3) Esta vez, debo elegir una posición para la carta
  cartas = rep(NA, 3)
  indice = sample (1:3, 1)                            #--> nº formas: 3
  cartas[indice] = carta final
  # 4) Elijo 2 palos entre los 4 posibles. El orden importa
  palos = sample(c("E", "C", "B", "O"), 2)           #--> nº formas: variaciones(4,2)
  mi_pareja = paste(palos, numero_pareja)
  cartas[setdiff(1:3, indidce)] = mi_pareja
  cartas
}

(10 * 36 * 3 * variaciones(4,2))/variaciones(40,3)








