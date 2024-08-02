SELECT name from movie
INTERSECT 
SELECT title from book;

SELECT title from book
EXCEPT 
SELECT name from movie;

SELECT name from movie
UNION ALL
SELECT title from book;
