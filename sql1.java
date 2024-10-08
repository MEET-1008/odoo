SELECT 
    ReportsTo,
    COUNT(*) AS Members,
    ROUND(AVG(Age)) AS `Average Age`
FROM 
    maintable_HHI5Q
WHERE 
    ReportsTo IS NOT NULL
GROUP BY 
    ReportsTo
ORDER BY 
    ReportsTo ASC;
