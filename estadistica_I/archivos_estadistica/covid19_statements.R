library(readr)


#' Section 1: Reading data, data types and indexing
#' =============================================================================
#' * Motivating problem: Download Covid-19 data by country and compare the cumulative
#' number of infections between two different countries.
#' * Topics: data types
#' * Section: "Beyond numbers and data types"-"Formulas" (included)
#'

#' ### Exercise 1
#' Load data, and create a new data.frame with the following columns:
#' day, moth, year, cases, deaths, contriesAndTerritories, Cumulative...
#' Also, since the names are quite long, rename the latest two to 'country' and
#' 'cum_rate'. Tip: do not write all the names! Get the old ones and then override
#' just the latest two.
#'

# covid19 es un data.frame: matriz con tipos de datos distintos
covid19 <- read_csv("covid19.csv")

new_covid = covid19[ , c("day", "month", "year", "cases", "deaths", "countriesAndTerritories",
             "Cumulative_number_for_14_days_of_COVID.19_cases_per_100000")]

colnames(new_covid)[6:7] = c("countries", "cumul_rate")


#' ### Exercise 2
#' Since we want to plot number of cases against time we need a new column.
#' Why? Consider which variable should be used for the x-axis of the plot,
#' day?, month?, year?. Only using one of these variables will not work.
#' We must use these three variables to create a new variable named 'time'
#' that approximately counts the number of days since the beginning of 2019.
#' Use the formula: day + (month - 1) * 30 + (year - 2019) * 365
#' (there is an exact and simple way of transforming dates to numbers, but this
#' is not the point of the exercise). Then eliminate day, month and year from the
#' resulting data.frame
#'

new_covid$time = new_covid$day + (new_covid$month - 1) * 30 + (new_covid$year - 2019) * 365
new_covid$day = NULL
new_covid = new_covid[, c(-1, -2)]

#' Section 2: logical indexing and plots
#' =============================================================================
#' * Motivating problem: Let's plot the 'cum_rate' variable against time for several
#' countries (Let's say Spain and Portugal), so we can compare their epidemiological
#' situation
#' * Topics: logicals and logical indexing, plots
#' * Sections: Beyond numbers-formulas (both included), Simple graphics in R
#'

#' ### Exercise 3
#' plot the 'cum_rate' variable against 'time' for both Spain and Portugal. Proceed
#' as follows:
#' 1) create a data.frame with the data from Spain (name it 'spain') and then
#' create another one from Portugal ('portugal').
#' 2) Use the plot function.
#'

# porgugal = ...
spain = new_covid[new_covid$countries == "Spain", ]
portugal = new_covid[new_covid$countries == "Portugal", ]

plot(spain$time, spain$cumul_rate, type = "l",
     xlab = "Time (days since 1/1/2019)",
     ylab = "Cumulative inf. rate",
     main = "Covid 19 pandemic",
     #ylim = c(0, 500)
)
points(portugal$time, portugal$cumul_rate, col="red", type = "l")
legend("topleft", c("Spain", "Portugal"), col = c("black", "red"),
       lty = 1)



#' Section 3: loops
#' =============================================================================
#' * Motivating problem: Let's plot the 'cum_rate' variable against 'time' for a large
#' list of countries without duplicating code!
#' situation
#' * Topics: loops
#' * Sections: Programming
#'

#' ### Exercise 4
#' Let's plot the 'cum_rate' variable against 'time' for
#' the following countries: Spain, Portugal, Italy, France and Germany. You must
#' use a for/while loop!
#'
#'
countries = c("Spain", "Portugal", "Italy", "France", "Germany")

spain = new_covid[new_covid$countries == "Spain", ]
plot(spain$time, spain$cumul_rate, type = "l",
     xlab = "Time (days since 1/1/2019)",
     ylab = "Cumulative inf. rate",
     main = "Covid 19 pandemic",
     #ylim = c(0, 500)
)
i = 2
for (country in countries[-1]) {
  # filtrar por pais
  current_df = new_covid[new_covid$countries == country, ]
  points(current_df$time, current_df$cumul_rate, col = i, type = "l")
  i = i + 1
}
legend("topleft", legend = countries, col = 1:length(countries), lty = 1)

# Versión 2

countries = c("Venezuela", "Spain", "Portugal", "Italy", "France", "Germany")

i = 1
for (country in countries) {
  current_df = new_covid[new_covid$countries == country, ]
  if (country == countries[1]) { #españa --> plot
    plot(current_df$time, current_df$cumul_rate, col = i, type = "l")
  } else {
    points(current_df$time, current_df$cumul_rate, col = i, type = "l")
  }
  i = i + 1
}
legend("topleft", legend = countries, col = 1:length(countries), lty = 1)



#' Section 4: functions, packages and scoping
#' =============================================================================
#' * Motivating problem: Let's calculate the total number of cases since the
#' beginning of data collection for the previous countries. This should be stored
#' in a new data.frame/vector. Then, let's print the information using some ASCII art.
#' * Topics: functions, scoping, packages, apply
#' * Sections: Functions, packages, scoping
#'

my_sum = function(x, y = 10) {
  x + y
}



#' ### Exercise 5
#' Use a function and sapply to calculate the total number of cases since the
#' beginning of data collection for the previous countries. This should be stored
#' in a new data.frame/vector. Then, print the information for each country,
#' using the say function from package 'cowsay' so that information is given
#' by a shark (you must look at the documentation!)
#'

count_by_country = function(df, country) {
  current_country = df[df$countries == country, ]
  sum(current_country$cases)
}

a = count_by_country(new_covid, "Spain" )
b = count_by_country(new_covid, "Portugal")

countries = c("Venezuela", "Spain", "Portugal", "Italy", "France", "Germany")
cases_by_country = c() #variable declarada para usarla en el bucle 
  for (country in countries){
    current_cases = count_by_country(new_covid, country)
    cases_by_country = c(cases_by_country , current_cases)
  }

print(cases_by_country)
names(cases_by_country) = countries
#a cada numero --> le asigno nombre
cases_by_country
  
cases_by_country[6]
#alemania 270070 

count_spain_portugal = count_by_countries(new_covid, c("Spain", "Portugal"))
count_spain_portugal

#------ESTADISTICA III --------#
# Estilo lenguaje R 
# programación funiconal --> todo se hace con funciones
# bucles for por ejemplo --> funciones
# vector: countries, funnción: count_by_country

sapply(countries, count_by_country) 
#sapplay convierte en vector un vector con una funcion
#venezuela --> aplico funcion --> escupo en forma de vector

#count_by_country ( ------, ------) luego necesitamos datos -->se hace en sapply
sapply(countries, count_by_country, df = new_covid)
new_result = sapply(countries, count_by_country, df = new_covid)
new_result

# otra forma FUNCIONES LAMBDA
sapply(countries, count_by_country, df = new_covid)
 sapply(
  countries, 
  function(country) {
    current_country = new_covid[new_covid$countries == country, ]
    sum(current_country$cases)}, 
    )
#variables globales SOLO en funciones lMBDA, 
# ANTE LA DUDA DECLARAMOS TODS LOS ELEMENTOS Y LOS PASAMOS

 
#como modificar variables
 demo = function(x){
   x = 1
   x
 }

 x = 5 
 demo (x) #sale 1
 print(x) #sale 5
 
 #la variable x = 1 solo dentro del bucle no para siempre
 # java (paso por referencia): lo q cambia dentro cambia fuera
 # R (paso por copia): lo q cambia dentro NO cambia fuera
 
 
 








