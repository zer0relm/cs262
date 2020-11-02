SELECT *
    FROM Game
    ORDER BY time DESC
    ;

--SELECT *
--    FROM Game
--    WHERE 

SELECT *
    FROM Player
    WHERE name IS NOT NULL
    ;

SELECT PlayerID
    FROM PlayerGame
    WHERE score >= 2000
    ;

SELECT *
    FROM Player
    WHERE emailAddress LIKE %gmail%
    ;

SELECT Score
    FROM Player, PlayerGame
    Where Player.ID = PlayerGame.playerID
        AND Player.name = 'The King'
    ORDER BY PlayerGame.Score DESC
;
