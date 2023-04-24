#' Implementa la fórmula de variaciones n! / (n - m)! de forma que sea numéricamente
#' estable
variaciones <- function(n, m) {
  exp(lgamma(n + 1L) - lgamma(n - m + 1L))
}


#' Integral doble que integra usando el orden dydx (primero dy, luego dx)
#' @param .f Función de dos variables. Los nombres de los argumentos deben ser, 
#' necesariamente, x e y.
#' @param from_x Número indicando el límite inferior de la integral exterior (dx).
#' @param to_x Número indicando el límite superior de la integral exterior (dx).
#' @param from_y Función en x indicando el límite inferior de la integral interior (dx).
#' @param from_y Función en x indicando el límite superior de la integral interior (dx).
integrate2_dydx <- function(.f, from_x, to_x, from_y, to_y, ...) {
  stopifnot(is.numeric(from_x) && is.numeric(to_x))
  stopifnot(is.function(from_y) && is.function(to_y))
  # integrate y
  inner_integral <- function(x) {
    sapply(
      x, 
      function(xv) {
        integrate(.f, force(from_y(xv)), force(to_y(xv)), x = xv, ...)$value
      }
    )
  }
  # integrate x
  integrate(inner_integral, from_x, to_x) 
}

#' Integral doble que integra usando el orden dxdy (primero dx, luego dy)
#' @param .f Función de dos variables. Los nombres de los argumentos deben ser, 
#' necesariamente, x e y.
#' @param from_x Función en y indicando el límite inferior de la integral interior (dx).
#' @param to_x Función en y indicando el límite superior de la integral interior (dx).
#' @param from_y Número indicando el límite inferior de la integral exterior (dy).
#' @param from_y Número indicando el límite superior de la integral interior (dy).
integrate2_dxdy <- function(.f, from_x, to_x, from_y, to_y, ...) {
  stopifnot(is.function(from_x) && is.function(to_x))
  stopifnot(is.numeric(from_y) && is.numeric(to_y))
  # integrate x
  inner_integral <- function(y) {
    sapply(
      y, 
      function(yv) {
        integrate(.f, force(from_x(yv)), force(to_x(yv)), y = yv, ...)$value
      }
    )
  }
  # integrate y
  integrate(inner_integral, from_y, to_y) 
} 
