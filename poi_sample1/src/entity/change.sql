SELECT COUNT (poi_id), poi_name FROM POIS GROUP BY poi_id, poi_name HAVING poi_name = 'Shartash';

SELECT COUNT (*) FROM POIS;

SELECT * FROM POIS WHERE EXISTS (SELECT poi_id, poi_name FROM POIS WHERE poi_name = 'Shartash');

SELECT *  FROM POIS_FOR_GROUPS;

SELECT poi_id, town, street, building FROM POIS WHERE poi_name LIKE 'Petr%' OR poi_name = 'Skaly Petra Gronskogo';

SELECT poi_id FROM pois WHERE avail_index = 2 and poi_id IN (SELECT poi_id FROM pois WHERE rating = 2 and poi_id IN (SELECT poi_id FROM POIS WHERE town = 'Severka'));
