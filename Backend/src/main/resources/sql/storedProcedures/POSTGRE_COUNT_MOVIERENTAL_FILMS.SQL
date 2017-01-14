CREATE OR REPLACE FUNCTION list_mr_movies(IN id bigint) RETURNS SETOF movies AS
  'SELECT * FROM movies
  WHERE id IN
    (SELECT movie_id
     FROM movies NATURAL JOIN inventories
     WHERE movie_rental_id = $1)'
     LANGUAGE sql;
