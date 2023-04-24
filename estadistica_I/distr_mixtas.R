
## Trabajamos para una gran compañía de streaming que quiere hacer sugerencias 
## de películas a sus usuarios. Para hacer esto, hay que intentar caracterizar 
## los gustos de cada usuario. Asumimos que las películas que ve un usuario 
## únicamente dependen de dos rasgos de su caracter: su ``aventurosidad (X)'' y su 
## ``romanticismo (Y)''. Asumimos que ambos rasgos se pueden caracterizar con 
## $X\sim \mathbb{U}[0, 1]$ y $Y~\sim\mathbb{U}[0, 1]$ (independientes). Si un 
## usuario tiene  como rasgos $X=x$ e $Y=y$:

## * La probabilidad de ver una película de acción es $p_a = \frac{2 x - y + 1}{6}$. 
## * La probabilidad de ver una película romántica es $p_r = \frac{3y - 2x + 2}{10}$
## * La probabilidad de ver una película de acción-amor es $p_{ar} = 1 - p_a - p_r$. 

## De las últimas 20 películas que ha visto un usuario, 4 han sido de acción,
## 4 románticas y 12 de acción-amor. ¿Cuáles son sus rasgos X e Y más probables?

# X ~ U(0, 1)
# Y ~ U(0, 1)
# (nueva variable) Z: nº de pelis accion       
# (nueva variable) A: nº de pelis romanticas   
# (nueva variable) M: nº de pelis accion-amor   

# VA discretas y con tope --> multi.
# (A ,R, M) ~ Multinomial(20, [p_a, p_r, p_m]) --> las probs dependen de x e y ->
# -> (A ,R, M | X, Y) ~ Multinomial(20, [p_a, p_r, p_m])

# moda de X e Y sabiendo q A = 4, R = 4 y  M = 12
# grafica f(x, y | A = 4, R = 4 y  M = 12)
# resolver el problema:
# 1.- cacular f(x, y, a, r, m)

  f = function(x, y, a, r, m){
    # f(a, r, m | x, y) = f(x, y, a, r, m) / f(x, y) -->
    # --> f(x, y, a, r, m) = f(a, r, m | x, y) * f(x, y)
    # f(x, y) = f(x) * f(y)
    p_a = (2 * x - y + 1) / 6
    p_r =  (3 * y - 2 * x + 2) / 10
    p_m = (1 - pa - pr)
    prob = c(p_a, p_r, p_m)
    # dmultinom(a, r, m, ...) * dunif(x, ...) * dunif(y, ...)
    dmultinom(c(a, r, m), 20, prob) * dunif(x) * dunif(y) # dunif tiene por defecto (0, 1)
  }

# 2.- marginalizar f(a, r, m)

  # integrar para todos los valores las x 
  f_pelis = function(a, r, m){
    # integrate f en x         --->
    # integrate f en y         ---> o tmb hacer una integral doble
    
  }

# 3.- f(x, y | a, r, m) = f(x, y, a, r, m) / f(a, r, m)

  f_xy_given_pelis = function(x, y){
    # f(x, y | a, r, m) = f(x, y, a, r, m) / f(a, r, m)
    f(x, y, 4, 4, 12) / f_pelis(4, 4, 12)
  }

# 4.- dibujar la funcion usando contour() y asi obtener el punto donde la
  # prob sea maxima




