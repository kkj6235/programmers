-- 코드를 작성해주세요
# select ID, first_name, last_name, email from DEVELOPERS;

select id, email, first_name, last_name from developers as d 
where d.skill_code&(select code from skillcodes where name="Python")
or d.skill_code&(select code from skillcodes where name="C#")
order by id;


# select * from skillcodes s join developers d;

# select d.id, d.email, d.first_name, d.last_name from developers d join skillcodes s on s.code&d.skill_code where s.name='Python' or s.name='C#' order by d.id;

# SELECT DISTINCT B.ID, B.EMAIL, B.FIRST_NAME, B.LAST_NAME
# FROM SKILLCODES A
# JOIN DEVELOPERS B ON (A.CODE & B.SKILL_CODE) > 0
# WHERE A.NAME = 'Python' OR A.NAME = 'C#'
# ORDER BY B.ID;

# select code from skillcodes where name="Python";
# python이나 C# 스킬을 가진 개발자의 정보를 조회하려 한다.