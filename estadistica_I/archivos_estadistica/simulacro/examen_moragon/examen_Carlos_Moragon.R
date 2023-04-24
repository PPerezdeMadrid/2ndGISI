#variaciones = function(n, k) factorial(n)/factorial(n-k)
variaciones <- function(n, m) {
  exp(lgamma(n + 1L) - lgamma(n - m + 1L))
}

#1)
#n libros
#X = "numero de libros revisados hasta encontrar el buscado"
#P(X < k)

total_cases = function(n){
  libros = 1:n
  sample(libros) #formas de comprobar todos los libros
  #Problema del ordenar en linea n elementos = n!
}

fav_cases = function(n, k){
  #Hay que coger k-1 elementos de n-1 elementos disponibles, donde el k es el elemento buscado 
  #problema del podio variaciones(n-1, k-1)
  
}

#aplicando la place
solucion1 = function(n, k) variaciones(n-1, k-1)/factorial(n)



#2)

total_cases = function(){
  #1:13, los 4 primeros son chicos, las 9 siguientes son chicas, y en el orden que salgan es como se sientan.
  sample(1:13) #problema de ordenar n elementos en una cola = n! permutaciones de n elementos.
}

#a)P(quinta persona = chico) = 0.3076923

fav_cases_2a = function(){
  #elegimos cual de los 4 chicos va a ser el 5º -> 4 posibilidades
  #ordenamos a 4 personas que van a ir antes de la 5º posicion -> problema del podio -> variaciones(12, 4)
  #ordenamos las siguientes personas, problema de ordenar n personas en fila -> 8!
}

#La place
segundaA = (4*variaciones(12, 4) * factorial(8))/factorial(13)

#b) P(primer chico en 5º posicion) = 0.07832168

fav_cases_2b = function(){
  #sabemos que antes de posicion 5 son todo chicas, despues va un chico y falta ordenar desde la 6º posicion hasta la 13º
  #ordenamos 5 chicas + 3 chicos = 8 personas = problema de ordenar n personas en fila -> factorial(8)
  #elegimos que 4 chicas van delante del primer chico = problema del podio = variaciones(9, 4)
  #elegimos que chico va en 5º posicion -> 4 posibilidades
}

segundaB = (factorial(8)*variaciones(9, 4) * 4)/factorial(13)


#c) P(4 hombres en las primeras 4 butacas) = 0.001398601


fav_cases_2c = function(){
  #colocar los cuatro hombres en las primeras 4 butacas -> ordenar en fila 4 elementos = 4!
  #colocar 9 mujeres en las siguientes 9 posiciones -> ordenar en fila 9 elementos = 9!
}

segundaC = (factorial(4)*factorial(9))/factorial(13)


#d)P(Todos los hombres se sienten juntos) = 0.01818182

fav_cases_2c = function(){
  #elegimos cual va a ser el asiento por el que empiezan -> 13 posibilidades
  
  #ordenamos a los hombres en fila = 4!
  #ordenamos a las mujeres en fila = 9!
}

segundaD = (13*factorial(4)*factorial(9))/factorial(13)


#2.2)

#X = "vida util del modulo A"
#Y = "Vida util del modulo B"

f = function(x, y){
  ifelse(x > 0 & x < 10 & y > 0 & y < 10,
         1/5.182385 * exp(-x * y), 
         0)
}

#suponemos que X e Y son independientes debido a que no se condicionan mutuamente. 
#a) P(sistema funcione menos de 2 años) = P(X > 2) * P(Y > 2) = 0.09644709

#P(X < 2)

p_x_menor_2 = integrate2_dydx(f,
                from_x = 2, to_x = 10,
                from_y = function(x) 0, to_y = function(x) 10)$value

#P(Y < 2)
p_y_menor_2 = integrate2_dydx(f,
                from_x = 0, to_x = 10,
                from_y = function(x) 2, to_y = function(x) 10)$value

p_menosDe2Annos = p_x_menor_2 * p_y_menor_2


#b)P(Y > X+2) = 0.2786277

#dibujamos la recta Y = X + 2

xs = 0:10

plot(xs, xs+2, type = "l", ylab = "y")

#Tenemos que sumar la probabilidad de que este por encima de dicha recta

p_y_xmas2 = integrate2_dydx(f,
                from_x = 0, to_x = 10,
                from_y = function(x) x + 2, to_y = function(x) 10)$value


#c) E[Y|X = 4] = E[X,Y]/E[X = 4] <- NO ME HA DADO TIEMPO A COMPLETAR ESTE EJERCICIO PERO ASI ES COMO LO HARIA.

#marginalizamos x
f_x = function(x){
  integrate(f, 0, 10, x = x)$value
}


E_x4 = 4 * f_x(4)
f_y = function(y){
  
}

#2.3)
n= 1000
sims_a = replicate(n,{
  #del 1:8 son los buenos
  participantes = 1:20
  A = sets::as.set(sample(participantes, 10))
  sum(sets::set_contains_element(A, 1:8)) >= 3
})
p_a = sum(sims_a)/n


sims_b = replicate(n,{
  buenos = 1:8
  a_buenos = sample(1:8, 3)
  participantes = (1:20)[-a_buenos]
  A = sets::as.set(sample(participantes, 7))
  sum(sets::set_contains_element(A, 1:8)) == 3
})
p_b = sum(sims_b)/n


#2.4)

#hago uso de un arbol de probabilidades.

p_lluvia = 1/2

p_correcto = 2/3

p_paraguas_pronos_no_llovia = 1/3 

#a) P(no paraguas|llueve) = P(no paraguas, llueve) / P(llueva)

p_no_paraguas_llueve = (p_lluvia * (1 - p_correcto)*p_paraguas_pronos_no_llovia)/p_lluvia

#b) P(llueva|paraguas) = P(llueva, paraguas)/p(paraguas)

p_lloviendo_si_paraguas = (p_lluvia*p_correcto + p_lluvia*(1 - p_correcto)*p_paraguas_pronos_no_llovia)/((1- p_lluvia) * p_correcto + (1- p_lluvia) * (1 - p_correcto)*p_paraguas_pronos_no_llovia + (1- p_lluvia)*p_paraguas_pronos_no_llovia + (1- p_lluvia)*p_correcto*p_paraguas_pronos_no_llovia)


