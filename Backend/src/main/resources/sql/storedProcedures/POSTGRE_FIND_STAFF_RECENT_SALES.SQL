CREATE OR REPLACE FUNCTION find_staff_sales(IN id bigint) RETURNS bigint AS
$$ SELECT count(*) FROM rentals
  WHERE staff_id = $1 AND
        rental_date > (CURRENT_DATE - interval '1 month')
$$ LANGUAGE sql;
