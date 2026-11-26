
SELECT
    p.product_id,
  coalesce ( ROUND(
        SUM(p.price * u.units) / NULLIF(SUM(u.units), 0),
        2
    ),0) AS average_price
FROM Prices p
left JOIN UnitsSold u
    ON p.product_id = u.product_id
    AND u.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY p.product_id;
