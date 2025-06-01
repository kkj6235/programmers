-- 코드를 작성해주세요

# select substring(DIFFERENTIATION_DATE,1,4) as year, max(size_of_colony) 
# from ecoli_data 
# group by year;


select YEAR(DIFFERENTIATION_DATE) as YEAR, 
(select max(size_of_colony) from ecoli_data where YEAR=YEAR(DIFFERENTIATION_DATE))-size_of_colony as YEAR_DEV, 
ID 
from ecoli_data 
order by YEAR, YEAR_DEV;

# SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR,
# (
#     SELECT MAX(SIZE_OF_COLONY) FROM ECOLI_DATA
#     WHERE YEAR(DIFFERENTIATION_DATE) = YEAR
# ) - SIZE_OF_COLONY AS YEAR_DEV,
# ID
# FROM ECOLI_DATA
# ORDER BY YEAR, YEAR_DEV