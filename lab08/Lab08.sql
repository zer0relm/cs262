-- Single-Table Queries

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
    WHERE emailAddress LIKE '%gmail%'
    ;

-- Multi-Table Queries

SELECT Score
    FROM Player, PlayerGame
    Where Player.ID = PlayerGame.playerID
        AND Player.name = 'The King'
    ORDER BY PlayerGame.Score DESC
;

SELECT name
    FROM Player, PlayerGame, Game
    WHERE PlayerGame.gameID = Game.ID 
      AND PlayerGame.playerID = Player.ID
      AND Game.time = '2006-06-28 13:20:00'
    ORDER BY PlayerGame.score DESC
    LIMIT 1
    ;
-- Only returns queries where the ID of the first player is smaller than
--      that of the second player

