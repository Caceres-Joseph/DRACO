# CONULTA 1
SELECT PRIMERA.NOMBRE_ELECCION, PRIMERA.ANIO_ELECCION, PRIMERA.PAIS_ELEC, PRIMERA.PARTIDO_ELEC, PRIMERA.MAYORES_VOTOS, SEGUNDA.VOTOS_TOTAL, (PRIMERA.MAYORES_VOTOS/SEGUNDA.VOTOS_TOTAL)*100 AS PORCENTAJE_VOTOS
FROM
#PRIMER SELECT
(SELECT A.ELEC AS NOMBRE_ELECCION, A.YEAR AS ANIO_ELECCION, A.COUNTRY1 AS PAIS_ELEC, A.P_POLITCO1 AS PARTIDO_ELEC, B.MAXIMO AS MAYORES_VOTOS
FROM (SELECT P.NOMBRE AS COUNTRY1, E.NOMBRE AS ELEC, E.ANIO AS YEAR, PAR.NOMBRE AS P_POLITCO1, SUM(DV.TOTAL_N_PRIMARIO+DV.TOTAL_N_MEDIO+DV.TOTAL_N_UNIV+DV.TOTAL_N_NAC) AS VOTOS FROM ELECCION E, PAIS P, PARTIDO PAR, DETALLES_VOTOS DV
WHERE
DV.ID_ELECCION = E.ID_ELECCION AND
DV.ID_PARTIDO = PAR.ID_PARTIDO AND
E.ID_PAIS = P.ID_PAIS AND
PAR.ID_PAIS = P.ID_PAIS AND
P.NOMBRE IN (SELECT DISTINCT PAIS.NOMBRE FROM PAIS)
GROUP BY P.NOMBRE, E.NOMBRE, E.ANIO ,PAR.NOMBRE) A
JOIN (SELECT SUB.COUNTRY2, MAX(SUB.VOTOS) AS MAXIMO FROM PARTIDO,
(SELECT P.NOMBRE AS COUNTRY2, PAR.NOMBRE AS P_POLITCO2, SUM(DV.TOTAL_N_PRIMARIO+DV.TOTAL_N_MEDIO+DV.TOTAL_N_UNIV+DV.TOTAL_N_NAC) AS VOTOS FROM ELECCION E, PAIS P, PARTIDO PAR, DETALLES_VOTOS DV
WHERE
DV.ID_ELECCION = E.ID_ELECCION AND
DV.ID_PARTIDO = PAR.ID_PARTIDO AND
E.ID_PAIS = P.ID_PAIS AND
PAR.ID_PAIS = P.ID_PAIS AND
P.NOMBRE IN (SELECT DISTINCT PAIS.NOMBRE FROM PAIS)
GROUP BY P.NOMBRE, PAR.NOMBRE) SUB
WHERE PARTIDO.NOMBRE = SUB.P_POLITCO2
GROUP BY SUB.COUNTRY2) B
ON A.VOTOS = B.MAXIMO) PRIMERA,
#SEGUNDO SELECT
(SELECT P.NOMBRE AS COUNTRY1, SUM(DV.TOTAL_N_PRIMARIO+DV.TOTAL_N_MEDIO+DV.TOTAL_N_UNIV+DV.TOTAL_N_NAC) AS VOTOS_TOTAL FROM ELECCION E, PAIS P, PARTIDO PAR, DETALLES_VOTOS DV
WHERE
DV.ID_ELECCION = E.ID_ELECCION AND
DV.ID_PARTIDO = PAR.ID_PARTIDO AND
E.ID_PAIS = P.ID_PAIS AND
PAR.ID_PAIS = P.ID_PAIS AND
P.NOMBRE IN (SELECT DISTINCT PAIS.NOMBRE FROM PAIS)
GROUP BY P.NOMBRE) SEGUNDA
WHERE PRIMERA.PAIS_ELEC = SEGUNDA.COUNTRY1;


#CONSULTA 2
SELECT PRIMERA.MUJERES_ALFABETAS AS VOTOS_MUJERES_INDIGENAS_ALFABETAS, (PRIMERA.MUJERES_ALFABETAS/SEGUNDA.TOTAL_VOTOS)*100 AS PORCENTAJE_SOBRE_TOTAL FROM
#PRIMER SELECT
(SELECT SUM(DV.TOTAL_N_PRIMARIO+DV.TOTAL_N_MEDIO+DV.TOTAL_N_UNIV) AS MUJERES_ALFABETAS FROM DETALLES_VOTOS DV, ETNIA ET, SEXO S
WHERE S.NOMBRE = 'mujeres' AND S.ID_SEXO = DV.ID_SEXO AND ET.ID_ETNIA = DV.ID_ETNIA AND ET.NOMBRE = 'INDIGENAS') PRIMERA,
#SEGUNDO SELECT
(SELECT SUM(DV.TOTAL_N_PRIMARIO+DV.TOTAL_N_MEDIO+DV.TOTAL_N_UNIV+DV.TOTAL_N_NAC) AS TOTAL_VOTOS FROM DETALLES_VOTOS DV) SEGUNDA


#CONULTA 3
SELECT SEGUNDA.P_NOMBRE AS COUNTRY, SEGUNDA.TOTAL_VOTOS_PAIS, PRIMERA.DEPARTAMENTO, PRIMERA.TOTAL_MUN AS TOTAL_EN_MUNICIPIO, (PRIMERA.TOTAL_MUN/SEGUNDA.TOTAL_VOTOS_PAIS)*100 AS PORCENTAJE_MUNICIPIO
FROM
#ME DEVUELVE EL TOTAL DE VOTOS DE MUJERES POR CADA MUNICIPIO DEL PAIS
(SELECT P.NOMBRE AS PAI, D.NOMBRE AS DEPARTAMENTO, SUM(DV.TOTAL_N_PRIMARIO+DV.TOTAL_N_MEDIO+DV.TOTAL_N_UNIV+DV.TOTAL_N_NAC) AS TOTAL_MUN FROM DETALLES_VOTOS DV, SEXO S, PAIS P, MUNICIPIO M,
DEPARTAMENTO D, REGION R
WHERE M.ID_MUNICIPIO = DV.ID_MUNICIPIO AND M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND D.ID_REGION = R.ID_REGION AND R.ID_PAIS = P.ID_PAIS
AND S.NOMBRE = 'mujeres' AND S.ID_SEXO = DV.ID_SEXO
GROUP BY P.NOMBRE, D.NOMBRE) PRIMERA,
#ME DEVUELVE EL TOTAL DE VOTOS EN UN PAIS DONDE HAYA VOTADO UNA MUJER
(SELECT P.NOMBRE AS P_NOMBRE, SUM(DV.TOTAL_N_PRIMARIO+DV.TOTAL_N_MEDIO+DV.TOTAL_N_UNIV+DV.TOTAL_N_NAC) AS TOTAL_VOTOS_PAIS FROM DETALLES_VOTOS DV, SEXO S, PAIS P, MUNICIPIO M,
DEPARTAMENTO D, REGION R
WHERE M.ID_MUNICIPIO = DV.ID_MUNICIPIO AND M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND D.ID_REGION = R.ID_REGION AND R.ID_PAIS = P.ID_PAIS
AND S.NOMBRE = 'mujeres' AND S.ID_SEXO = DV.ID_SEXO
GROUP BY P.NOMBRE
) SEGUNDA
WHERE SEGUNDA.P_NOMBRE = PRIMERA.PAI;

#CONSULTA 4
#PRIMERA
SELECT PRIMERA.COUNTRY AS P_PAIS, ROUND((PRIMERA.VOTOS_ANALFABETAS/SEGUNDA.TOTAL_VOTOS)*100,2) AS PORCENTAJE_VOTOS_ANALFABETAS_PAIS FROM
(SELECT SUM(AUXILIAR.VOTOS_ANALFABETAS) AS TOTAL_VOTOS FROM
(SELECT P.NOMBRE AS COUNTRY, SUM(DV.TOTAL_N_NAC) AS VOTOS_ANALFABETAS  FROM PAIS P, DETALLES_VOTOS DV, REGION R, DEPARTAMENTO D, MUNICIPIO M
WHERE DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND R.ID_REGION = D.ID_REGION AND P.ID_PAIS = R.ID_PAIS
GROUP BY P.NOMBRE) AUXILIAR) SEGUNDA,
(SELECT P.NOMBRE AS COUNTRY, SUM(DV.TOTAL_N_NAC) AS VOTOS_ANALFABETAS  FROM PAIS P, DETALLES_VOTOS DV, REGION R, DEPARTAMENTO D, MUNICIPIO M
WHERE DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND R.ID_REGION = D.ID_REGION AND P.ID_PAIS = R.ID_PAIS
GROUP BY P.NOMBRE) PRIMERA ORDER BY ROUND((PRIMERA.VOTOS_ANALFABETAS/SEGUNDA.TOTAL_VOTOS)*100,2) DESC LIMIT 0,1
#SEGUNDA ESTA ES LA CORRECTA
SELECT P.NOMBRE AS COUNTRY,
(SUM(DV.TOTAL_N_NAC)/SUM(DV.TOTAL_N_PRIMARIO+DV.TOTAL_N_MEDIO+DV.TOTAL_N_UNIV+DV.TOTAL_N_NAC))*100 AS PORCENTAJE
FROM PAIS P, DETALLES_VOTOS DV, REGION R, DEPARTAMENTO D, MUNICIPIO M
WHERE DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND R.ID_REGION = D.ID_REGION AND P.ID_PAIS = R.ID_PAIS
GROUP BY P.NOMBRE
ORDER BY PORCENTAJE DESC LIMIT 0,1;

#CONSULTA 5
SELECT MAIN_1.PAIS, MAIN_1.PARTIDO_GANADOR AS PARTIDO_CON_MAYOR_ALCALDIAS, MAIN_2.MAXI AS ALCALDIAS_GANADAS FROM
(SELECT PRINCIPAL.CON AS PAIS, PRINCIPAL.PARTI AS PARTIDO_GANADOR, COUNT(PRINCIPAL.PARTI) AS NUMERO_ALCALDIAS_GANADAS FROM
(SELECT PRIMERA.PAIS AS CON, PRIMERA.MUNI AS MUNIC, PRIMERA.PARTIDO AS PARTI, SEGUNDA.MAXIMO_MUN AS MAX_NUM FROM
(SELECT AUXILIAR.PAIS_EN_CUESTION AS PAIS, AUXILIAR.MUNICIPIO AS MUNI , AUXILIAR.PARTIDO AS PARTIDO, MAX(AUXILIAR.VOTOS_PARTIDO) AS TOTAL_POR_PARTIDO FROM
(SELECT P.NOMBRE AS PAIS_EN_CUESTION, M.NOMBRE AS MUNICIPIO, PAR.NOMBRE AS PARTIDO, PAR.ID_PARTIDO AS ID_P, SUM(DV.TOTAL_N_PRIMARIO+DV.TOTAL_N_MEDIO+DV.TOTAL_N_UNIV+DV.TOTAL_N_NAC) AS VOTOS_PARTIDO
FROM PAIS P, PARTIDO PAR, DETALLES_VOTOS DV, MUNICIPIO M
WHERE DV.ID_PARTIDO = PAR.ID_PARTIDO AND P.ID_PAIS = PAR.ID_PAIS AND M.ID_MUNICIPIO = DV.ID_MUNICIPIO AND M.ID_MUNICIPIO IN (SELECT ID_MUNICIPIO FROM MUNICIPIO)
GROUP BY P.NOMBRE, M.NOMBRE, PAR.NOMBRE, PAR.ID_PARTIDO) AUXILIAR
GROUP BY AUXILIAR.PAIS_EN_CUESTION, AUXILIAR.MUNICIPIO, AUXILIAR.PARTIDO
ORDER BY AUXILIAR.PAIS_EN_CUESTION, AUXILIAR.MUNICIPIO, AUXILIAR.PARTIDO, MAX(AUXILIAR.VOTOS_PARTIDO) DESC) PRIMERA
JOIN
(SELECT AUXILIAR.PAIS_EN_CUESTION AS PA, AUXILIAR.MUNICIPIO AS MUN, MAX(AUXILIAR.VOTOS_PARTIDO) MAXIMO_MUN FROM
(SELECT P.NOMBRE AS PAIS_EN_CUESTION, M.NOMBRE AS MUNICIPIO, PAR.NOMBRE AS PARTIDO, PAR.ID_PARTIDO AS ID_P, SUM(DV.TOTAL_N_PRIMARIO+DV.TOTAL_N_MEDIO+DV.TOTAL_N_UNIV+DV.TOTAL_N_NAC) AS VOTOS_PARTIDO
FROM PAIS P, PARTIDO PAR, DETALLES_VOTOS DV, MUNICIPIO M
WHERE DV.ID_PARTIDO = PAR.ID_PARTIDO AND P.ID_PAIS = PAR.ID_PAIS AND M.ID_MUNICIPIO = DV.ID_MUNICIPIO AND M.ID_MUNICIPIO IN (SELECT ID_MUNICIPIO FROM MUNICIPIO)
GROUP BY P.NOMBRE, M.NOMBRE, PAR.NOMBRE, PAR.ID_PARTIDO) AUXILIAR
GROUP BY AUXILIAR.PAIS_EN_CUESTION, AUXILIAR.MUNICIPIO
ORDER BY AUXILIAR.PAIS_EN_CUESTION, AUXILIAR.MUNICIPIO, MAX(AUXILIAR.VOTOS_PARTIDO) DESC) SEGUNDA
ON PRIMERA.TOTAL_POR_PARTIDO = SEGUNDA.MAXIMO_MUN AND PRIMERA.PAIS = SEGUNDA.PA AND PRIMERA.MUNI = SEGUNDA.MUN) AS PRINCIPAL
GROUP BY PRINCIPAL.CON, PRINCIPAL.PARTI
ORDER BY PRINCIPAL.CON, COUNT(PRINCIPAL.PARTI) DESC ) MAIN_1
JOIN
(SELECT MAIN.PAIS AS PE, MAX(MAIN.NUMERO_ALCALDIAS_GANADAS) AS MAXI FROM
(SELECT PRINCIPAL.CON AS PAIS, PRINCIPAL.PARTI AS PARTIDO_GANADOR, COUNT(PRINCIPAL.PARTI) AS NUMERO_ALCALDIAS_GANADAS FROM
(SELECT PRIMERA.PAIS AS CON, PRIMERA.MUNI AS MUNIC, PRIMERA.PARTIDO AS PARTI, SEGUNDA.MAXIMO_MUN AS MAX_NUM FROM
(SELECT AUXILIAR.PAIS_EN_CUESTION AS PAIS, AUXILIAR.MUNICIPIO AS MUNI , AUXILIAR.PARTIDO AS PARTIDO, MAX(AUXILIAR.VOTOS_PARTIDO) AS TOTAL_POR_PARTIDO FROM
(SELECT P.NOMBRE AS PAIS_EN_CUESTION, M.NOMBRE AS MUNICIPIO, PAR.NOMBRE AS PARTIDO, PAR.ID_PARTIDO AS ID_P, SUM(DV.TOTAL_N_PRIMARIO+DV.TOTAL_N_MEDIO+DV.TOTAL_N_UNIV+DV.TOTAL_N_NAC) AS VOTOS_PARTIDO
FROM PAIS P, PARTIDO PAR, DETALLES_VOTOS DV, MUNICIPIO M
WHERE DV.ID_PARTIDO = PAR.ID_PARTIDO AND P.ID_PAIS = PAR.ID_PAIS AND M.ID_MUNICIPIO = DV.ID_MUNICIPIO AND M.ID_MUNICIPIO IN (SELECT ID_MUNICIPIO FROM MUNICIPIO)
GROUP BY P.NOMBRE, M.NOMBRE, PAR.NOMBRE, PAR.ID_PARTIDO) AUXILIAR
GROUP BY AUXILIAR.PAIS_EN_CUESTION, AUXILIAR.MUNICIPIO, AUXILIAR.PARTIDO
ORDER BY AUXILIAR.PAIS_EN_CUESTION, AUXILIAR.MUNICIPIO, AUXILIAR.PARTIDO, MAX(AUXILIAR.VOTOS_PARTIDO) DESC) PRIMERA
JOIN
(SELECT AUXILIAR.PAIS_EN_CUESTION AS PA, AUXILIAR.MUNICIPIO AS MUN, MAX(AUXILIAR.VOTOS_PARTIDO) MAXIMO_MUN FROM
(SELECT P.NOMBRE AS PAIS_EN_CUESTION, M.NOMBRE AS MUNICIPIO, PAR.NOMBRE AS PARTIDO, PAR.ID_PARTIDO AS ID_P, SUM(DV.TOTAL_N_PRIMARIO+DV.TOTAL_N_MEDIO+DV.TOTAL_N_UNIV+DV.TOTAL_N_NAC) AS VOTOS_PARTIDO
FROM PAIS P, PARTIDO PAR, DETALLES_VOTOS DV, MUNICIPIO M
WHERE DV.ID_PARTIDO = PAR.ID_PARTIDO AND P.ID_PAIS = PAR.ID_PAIS AND M.ID_MUNICIPIO = DV.ID_MUNICIPIO AND M.ID_MUNICIPIO IN (SELECT ID_MUNICIPIO FROM MUNICIPIO)
GROUP BY P.NOMBRE, M.NOMBRE, PAR.NOMBRE, PAR.ID_PARTIDO) AUXILIAR
GROUP BY AUXILIAR.PAIS_EN_CUESTION, AUXILIAR.MUNICIPIO
ORDER BY AUXILIAR.PAIS_EN_CUESTION, AUXILIAR.MUNICIPIO, MAX(AUXILIAR.VOTOS_PARTIDO) DESC) SEGUNDA
ON PRIMERA.TOTAL_POR_PARTIDO = SEGUNDA.MAXIMO_MUN AND PRIMERA.PAIS = SEGUNDA.PA AND PRIMERA.MUNI = SEGUNDA.MUN) AS PRINCIPAL
GROUP BY PRINCIPAL.CON, PRINCIPAL.PARTI
ORDER BY PRINCIPAL.CON, COUNT(PRINCIPAL.PARTI) DESC) AS MAIN
GROUP BY MAIN.PAIS) MAIN_2
ON MAIN_1.PAIS = MAIN_2.PE AND MAIN_1.NUMERO_ALCALDIAS_GANADAS = MAIN_2.MAXI;


#CONSULTA 6
SELECT PRIMERA.PAIS, PRIMERA.REGI, PRIMERA.ET, SEGUNDA.MAXI FROM
(SELECT P.NOMBRE AS PAIS, R.NOMBRE AS REGI, ET.NOMBRE AS ET, SUM(DV.TOTAL_N_PRIMARIO+DV.TOTAL_N_MEDIO+DV.TOTAL_N_UNIV+DV.TOTAL_N_NAC) AS VOTOS FROM PAIS P, REGION R, DEPARTAMENTO D, MUNICIPIO M, DETALLES_VOTOS DV, ETNIA ET
WHERE
DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND
M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
D.ID_REGION = R.ID_REGION AND
P.ID_PAIS = R.ID_PAIS AND
ET.ID_ETNIA = DV.ID_ETNIA
GROUP BY P.NOMBRE, R.NOMBRE, ET.NOMBRE
ORDER BY P.NOMBRE , VOTOS DESC) PRIMERA
JOIN
(SELECT AUXILIAR.PAIS, AUXILIAR.REG, MAX(AUXILIAR.VOTOS) AS MAXI FROM
(SELECT P.NOMBRE AS PAIS, R.NOMBRE AS REG, ET.NOMBRE AS ET, SUM(DV.TOTAL_N_PRIMARIO+DV.TOTAL_N_MEDIO+DV.TOTAL_N_UNIV+DV.TOTAL_N_NAC) AS VOTOS FROM PAIS P, REGION R, DEPARTAMENTO D, MUNICIPIO M, DETALLES_VOTOS DV, ETNIA ET
WHERE
DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND
M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
D.ID_REGION = R.ID_REGION AND
P.ID_PAIS = R.ID_PAIS AND
ET.ID_ETNIA = DV.ID_ETNIA
GROUP BY P.NOMBRE, R.NOMBRE, ET.NOMBRE
ORDER BY P.NOMBRE , VOTOS DESC) AUXILIAR
GROUP BY AUXILIAR.PAIS, AUXILIAR.REG) SEGUNDA
WHERE PRIMERA.PAIS = SEGUNDA.PAIS AND PRIMERA.VOTOS = SEGUNDA.MAXI AND PRIMERA.ET = 'INDIGENAS';


#CONSULTA 7
SELECT MUJERES.PAIS, HOMBRES.DEPARTAMENTO, MUJERES.MUJER_TOTAL, HOMBRES.HOMBRE_TOTAL, TOTALES.TOTAL_UNIVERSITARIOS,
(MUJERES.MUJER_TOTAL/TOTALES.TOTAL_UNIVERSITARIOS)*100 AS PORCENTAJE_MUJERES, (HOMBRES.HOMBRE_TOTAL/TOTALES.TOTAL_UNIVERSITARIOS)*100 AS PORCENTAJE_HOMBRES FROM
(SELECT P.NOMBRE AS PAIS, D.NOMBRE AS DEPARTAMENTO, S.NOMBRE AS SEXO, SUM(DV.TOTAL_N_UNIV) AS MUJER_TOTAL  FROM DEPARTAMENTO D, SEXO S, DETALLES_VOTOS DV, PAIS P, MUNICIPIO M, REGION R
WHERE
DV.ID_SEXO = S.ID_SEXO AND
DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND
M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
D.ID_REGION = R.ID_REGION AND
R.ID_PAIS = P.ID_PAIS AND
S.NOMBRE = 'mujeres'
GROUP BY P.NOMBRE, D.NOMBRE) MUJERES,
(SELECT P.NOMBRE AS PAIS, D.NOMBRE AS DEPARTAMENTO, S.NOMBRE AS SEXO, SUM(DV.TOTAL_N_UNIV) AS HOMBRE_TOTAL  FROM DEPARTAMENTO D, SEXO S, DETALLES_VOTOS DV, PAIS P, MUNICIPIO M, REGION R
WHERE
DV.ID_SEXO = S.ID_SEXO AND
DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND
M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
D.ID_REGION = R.ID_REGION AND
R.ID_PAIS = P.ID_PAIS AND
S.NOMBRE = 'hombres'
GROUP BY P.NOMBRE, D.NOMBRE) HOMBRES,
(SELECT P.NOMBRE AS PAIS, D.NOMBRE AS DEPARTAMENTO, SUM(DV.TOTAL_N_UNIV) AS TOTAL_UNIVERSITARIOS  FROM DEPARTAMENTO D, SEXO S, DETALLES_VOTOS DV, PAIS P, MUNICIPIO M, REGION R
WHERE
DV.ID_SEXO = S.ID_SEXO AND
DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND
M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
D.ID_REGION = R.ID_REGION AND
R.ID_PAIS = P.ID_PAIS
GROUP BY P.NOMBRE, D.NOMBRE) TOTALES
WHERE
MUJERES.PAIS = HOMBRES.PAIS AND
HOMBRES.PAIS = TOTALES.PAIS AND
MUJERES.DEPARTAMENTO = HOMBRES.DEPARTAMENTO AND
HOMBRES.DEPARTAMENTO = TOTALES.DEPARTAMENTO AND
MUJERES.MUJER_TOTAL > HOMBRES.HOMBRE_TOTAL;

#CONSULTA 8
SELECT PRIMERA.PAIS, PRIMERA.DEPARTAMENTO, PRIMERA.TOTAL_VOTOS FROM
	(SELECT P.NOMBRE AS PAIS, D.NOMBRE AS DEPARTAMENTO, SUM(DV.TOTAL_N_PRIMARIO + DV.TOTAL_N_MEDIO + DV.TOTAL_N_UNIV + DV.TOTAL_N_NAC) AS TOTAL_VOTOS
	FROM DETALLES_VOTOS DV, MUNICIPIO M, PAIS P, REGION R, DEPARTAMENTO D
	WHERE
	DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND
	M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
	D.ID_REGION = R.ID_REGION AND
	R.ID_PAIS = P.ID_PAIS AND
	P.NOMBRE = 'GUATEMALA'
	GROUP BY P.NOMBRE, D.NOMBRE
	ORDER BY PAIS DESC) PRIMERA,

	(SELECT P.NOMBRE AS PAIS, D.NOMBRE AS DEPARTAMENTO, SUM(DV.TOTAL_N_PRIMARIO + DV.TOTAL_N_MEDIO + DV.TOTAL_N_UNIV + DV.TOTAL_N_NAC) AS TOTAL_VOTOS
	FROM DETALLES_VOTOS DV, MUNICIPIO M, PAIS P, REGION R, DEPARTAMENTO D
	WHERE
	DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND
	M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
	D.ID_REGION = R.ID_REGION AND
	R.ID_PAIS = P.ID_PAIS AND
	P.NOMBRE = 'GUATEMALA' AND
	D.NOMBRE = 'Guatemala'
	GROUP BY P.NOMBRE, D.NOMBRE
	ORDER BY PAIS DESC) SEGUNDA
WHERE PRIMERA.TOTAL_VOTOS > SEGUNDA.TOTAL_VOTOS
ORDER BY PRIMERA.PAIS, PRIMERA.DEPARTAMENTO;

#CONSULTA 9
SELECT P.NOMBRE AS PAIS, R.NOMBRE AS REGION, Count(DISTINCT D.NOMBRE) NO_DEP_REGION, SUM(DV.TOTAL_N_PRIMARIO + DV.TOTAL_N_MEDIO + DV.TOTAL_N_UNIV + DV.TOTAL_N_NAC) AS TOTAL_VOTOS,
ROUND(SUM(DV.TOTAL_N_PRIMARIO + DV.TOTAL_N_MEDIO + DV.TOTAL_N_UNIV + DV.TOTAL_N_NAC)/Count(DISTINCT D.NOMBRE),2) AS PROMEDIO_VOTOS
FROM DETALLES_VOTOS DV, MUNICIPIO M, PAIS P, REGION R, DEPARTAMENTO D
WHERE
DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND
M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
D.ID_REGION = R.ID_REGION AND
R.ID_PAIS = P.ID_PAIS
GROUP BY P.NOMBRE, R.NOMBRE
ORDER BY P.NOMBRE, R.NOMBRE DESC

#CONSULTA 10
SELECT SUBSTR(M.NOMBRE,1,1) AS LETRA, SUM(DV.TOTAL_N_PRIMARIO + DV.TOTAL_N_MEDIO + DV.TOTAL_N_UNIV + DV.TOTAL_N_NAC) AS TOTAL_VOTOS  FROM MUNICIPIO M, DETALLES_VOTOS DV
WHERE M.ID_MUNICIPIO = DV.ID_MUNICIPIO
GROUP BY LETRA
ORDER BY LETRA ASC

#CONSULTA 11 TENGO QUE ARREGLAR LA 11
set @p_rank := 1, @current_p := 0;
SELECT ULTIMO.PAIS, ULTIMO.MUNICIPIO, ULTIMO.PARTIDO, ULTIMO.VOTOS FROM
(SELECT N3.ID_P, N3.PAIS, N3.ID_M, N3.MUNICIPIO, N3.ID_PARTI, N3.PARTIDO, N3.VOTOS,
@p_rank := IF(@current_p = N3.ID_M, @p_rank + 1, 1) AS RANK,
@current_p := N3.ID_M AS ACTUAL
FROM
(SELECT * FROM
(SELECT * FROM
(SELECT P.ID_PAIS AS ID_P, P.NOMBRE AS PAIS , M.ID_MUNICIPIO AS ID_M, M.NOMBRE AS MUNICIPIO, PA.ID_PARTIDO AS ID_PARTI, PA.NOMBRE AS PARTIDO, SUM(DV.TOTAL_N_PRIMARIO+DV.TOTAL_N_MEDIO+DV.TOTAL_N_UNIV+DV.TOTAL_N_NAC) AS VOTOS
FROM DETALLES_VOTOS DV, MUNICIPIO M, PARTIDO PA, PAIS P, REGION R, DEPARTAMENTO D
WHERE
DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND
DV.ID_PARTIDO = PA.ID_PARTIDO AND
M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
D.ID_REGION = R.ID_REGION AND
R.ID_PAIS = P.ID_PAIS
GROUP BY M.ID_MUNICIPIO, PA.ID_PARTIDO
ORDER BY P.ID_PAIS, M.ID_MUNICIPIO, VOTOS DESC) N1
ORDER BY N1.ID_P, N1.ID_M, N1.VOTOS DESC) N2
ORDER BY N2.ID_P, N2.ID_M, N2.VOTOS DESC) N3) ULTIMO
WHERE ULTIMO.RANK = 1 OR ULTIMO.RANK = 2
ORDER BY ULTIMO.PAIS, ULTIMO.MUNICIPIO DESC

#CONSULTA 12
SELECT P.NOMBRE AS PAIS, SUM(DV.TOTAL_N_PRIMARIO) AS NIVEL_PRIMARIO, SUM(DV.TOTAL_N_MEDIO) AS NIVEL_MEDIO, SUM(DV.TOTAL_N_UNIV) AS NIVEL_UNIVERSITARIO
FROM DETALLES_VOTOS DV, MUNICIPIO M, DEPARTAMENTO D, REGION R, PAIS P
WHERE
M.ID_MUNICIPIO = DV.ID_MUNICIPIO AND
M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
D.ID_REGION = R.ID_REGION AND
P.ID_PAIS = R.ID_PAIS
AND P.ID_PAIS IN ( SELECT ID_PAIS FROM PAIS)
GROUP BY PAIS ;

#CONSULTA 13
SELECT TOTAL.PAIS, POR_ETNIAS.ETNIA, POR_ETNIAS.VOTOS, TOTAL.VOTOS, (POR_ETNIAS.VOTOS/TOTAL.VOTOS)*100 AS PROCENTAJE FROM
(SELECT P.NOMBRE AS PAIS, E.NOMBRE AS ETNIA, SUM(DV.TOTAL_N_PRIMARIO + DV.TOTAL_N_MEDIO + DV.TOTAL_N_UNIV + DV.TOTAL_N_NAC)  AS VOTOS
FROM PAIS P, REGION R, DEPARTAMENTO D, MUNICIPIO M, ETNIA E, DETALLES_VOTOS DV
WHERE
DV.ID_ETNIA = E.ID_ETNIA AND
DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND
M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
D.ID_REGION = R.ID_REGION AND
R.ID_PAIS = P.ID_PAIS
GROUP BY PAIS, ETNIA
ORDER BY PAIS, ETNIA DESC) POR_ETNIAS
JOIN
(SELECT P.NOMBRE AS PAIS, SUM(DV.TOTAL_N_PRIMARIO + DV.TOTAL_N_MEDIO + DV.TOTAL_N_UNIV + DV.TOTAL_N_NAC)  AS VOTOS
FROM PAIS P, REGION R, DEPARTAMENTO D, MUNICIPIO M, DETALLES_VOTOS DV
WHERE
DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND
M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
D.ID_REGION = R.ID_REGION AND
R.ID_PAIS = P.ID_PAIS
GROUP BY PAIS
ORDER BY PAIS DESC) TOTAL
ON POR_ETNIAS.PAIS = TOTAL.PAIS;

#CONSULTA 14
SELECT MENOR.PAIS, MENOR.PARTIDO AS PARTIDO_MENOR_VOTOS, (MENOR.MENOR_TOTAL/TOTAL_PAISES.VOTOS_TOTALES)*100 AS PORCENTAJE_MENOR, MAYOR.PARTIDO AS PARTIDO_MAYOR_VOTOS, (MAYOR.TOTAL_MAYOR/TOTAL_PAISES.VOTOS_TOTALES)*100 AS PORCENTAJE_MAYOR,
((MAYOR.TOTAL_MAYOR-MENOR.MENOR_TOTAL)/TOTAL_PAISES.VOTOS_TOTALES)*100 AS PORCENTAJE_DIFERENCIA
FROM
(SELECT PRIMERA.PAIS PAIS, SEGUNDA.PARTIDO PARTIDO, PRIMERA.MAYOR_POR_PAIS MENOR_TOTAL FROM
(SELECT MAYOR.PAIS AS PAIS, MIN(MAYOR.VOTOS_PARTIDO) AS MAYOR_POR_PAIS FROM
(SELECT P.NOMBRE AS PAIS, PA.NOMBRE AS PARTIDO, SUM(DV.TOTAL_N_PRIMARIO + DV.TOTAL_N_MEDIO + DV.TOTAL_N_UNIV + DV.TOTAL_N_NAC) AS VOTOS_PARTIDO
FROM PAIS P, PARTIDO PA, DETALLES_VOTOS DV, MUNICIPIO M, REGION R, DEPARTAMENTO D
WHERE
DV.ID_PARTIDO = PA.ID_PARTIDO AND
DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND
M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
D.ID_REGION = R.ID_REGION AND
R.ID_PAIS = P.ID_PAIS AND
P.ID_PAIS = PA.ID_PAIS
GROUP BY P.NOMBRE, PA.NOMBRE) MAYOR
GROUP BY MAYOR.PAIS) PRIMERA
JOIN
(SELECT P.NOMBRE AS PAIS, PA.NOMBRE AS PARTIDO, SUM(DV.TOTAL_N_PRIMARIO + DV.TOTAL_N_MEDIO + DV.TOTAL_N_UNIV + DV.TOTAL_N_NAC) AS VOTOS_PARTIDO
FROM PAIS P, PARTIDO PA, DETALLES_VOTOS DV, MUNICIPIO M, REGION R, DEPARTAMENTO D
WHERE
DV.ID_PARTIDO = PA.ID_PARTIDO AND
DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND
M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
D.ID_REGION = R.ID_REGION AND
R.ID_PAIS = P.ID_PAIS AND
P.ID_PAIS = PA.ID_PAIS
GROUP BY P.NOMBRE, PA.NOMBRE) SEGUNDA
ON PRIMERA.PAIS = SEGUNDA.PAIS AND PRIMERA.MAYOR_POR_PAIS = SEGUNDA.VOTOS_PARTIDO) MENOR
JOIN
(SELECT PRIMERA.PAIS AS PAIS, SEGUNDA.PARTIDO AS PARTIDO, PRIMERA.MAYOR_POR_PAIS AS TOTAL_MAYOR FROM
(SELECT MAYOR.PAIS AS PAIS, MAX(MAYOR.VOTOS_PARTIDO) AS MAYOR_POR_PAIS FROM
(SELECT P.NOMBRE AS PAIS, PA.NOMBRE AS PARTIDO, SUM(DV.TOTAL_N_PRIMARIO + DV.TOTAL_N_MEDIO + DV.TOTAL_N_UNIV + DV.TOTAL_N_NAC) AS VOTOS_PARTIDO
FROM PAIS P, PARTIDO PA, DETALLES_VOTOS DV, MUNICIPIO M, REGION R, DEPARTAMENTO D
WHERE
DV.ID_PARTIDO = PA.ID_PARTIDO AND
DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND
M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
D.ID_REGION = R.ID_REGION AND
R.ID_PAIS = P.ID_PAIS AND
P.ID_PAIS = PA.ID_PAIS
GROUP BY P.NOMBRE, PA.NOMBRE) MAYOR
GROUP BY MAYOR.PAIS) PRIMERA
JOIN
(SELECT P.NOMBRE AS PAIS, PA.NOMBRE AS PARTIDO, SUM(DV.TOTAL_N_PRIMARIO + DV.TOTAL_N_MEDIO + DV.TOTAL_N_UNIV + DV.TOTAL_N_NAC) AS VOTOS_PARTIDO
FROM PAIS P, PARTIDO PA, DETALLES_VOTOS DV, MUNICIPIO M, REGION R, DEPARTAMENTO D
WHERE
DV.ID_PARTIDO = PA.ID_PARTIDO AND
DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND
M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
D.ID_REGION = R.ID_REGION AND
R.ID_PAIS = P.ID_PAIS AND
P.ID_PAIS = PA.ID_PAIS
GROUP BY P.NOMBRE, PA.NOMBRE) SEGUNDA
ON PRIMERA.PAIS = SEGUNDA.PAIS AND PRIMERA.MAYOR_POR_PAIS = SEGUNDA.VOTOS_PARTIDO) MAYOR
ON MENOR.PAIS = MAYOR.PAIS
JOIN
(SELECT P.NOMBRE AS PAIS, SUM(DV.TOTAL_N_PRIMARIO + DV.TOTAL_N_MEDIO + DV.TOTAL_N_UNIV + DV.TOTAL_N_NAC) AS VOTOS_TOTALES
FROM PAIS P, PARTIDO PA, DETALLES_VOTOS DV, MUNICIPIO M, REGION R, DEPARTAMENTO D
WHERE
DV.ID_PARTIDO = PA.ID_PARTIDO AND
DV.ID_MUNICIPIO = M.ID_MUNICIPIO AND
M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO AND
D.ID_REGION = R.ID_REGION AND
R.ID_PAIS = P.ID_PAIS AND
P.ID_PAIS = PA.ID_PAIS
GROUP BY P.NOMBRE) TOTAL_PAISES
ON TOTAL_PAISES.PAIS = MENOR.PAIS
ORDER BY PORCENTAJE_DIFERENCIA ASC LIMIT 0,1;
