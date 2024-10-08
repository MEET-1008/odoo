SELECT 
    FORMAT(DateJoined, 'yyyy-MM') AS JoinMonth, 
    COUNT(*) AS TotalMembersJoined
FROM 
    maintable_JVVIR
WHERE 
    YEAR(DateJoined) = 2017
GROUP BY 
    FORMAT(DateJoined, 'yyyy-MM')
ORDER BY 
    JoinMonth ASC;
