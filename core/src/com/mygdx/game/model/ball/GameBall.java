package com.mygdx.game.model.ball;

import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.ball.GameBallStates.GameBallState;
import com.mygdx.game.model.ball.GameBallStates.GameBallStateAlive;
import com.mygdx.game.model.ball.GameBallStates.GameBallStateDead;
import com.mygdx.game.model.ball.GameBallStates.GameBallStateStatic;
import com.mygdx.game.model.color.Color;

import mesmaths.geometrie.base.Vecteur;

/**
 * Classe représentant une bille de jeu (celle contrôlée par le joueur)
 */
public class GameBall extends AbstractBall {

    //Données relatives aux GameBall
    public static final int gameBallRadius = 250;
    private static final double gameBallWeight = 75;
    private static final Color gameBallColor = Color.BLUE();

    //Variables relatives au GameBallState
    private GameBallState gameBallStateAlive, gameBallStateDead, gameBallStateStatic, currentGameBallState;

    // --------------------- \\
    // --- Constructeurs --- \\
    // --------------------- \\
    public GameBall(GameWorld game) {
        super(game, new Vecteur(0,0), gameBallRadius, gameBallWeight, gameBallColor);
        installationStates();
    }

    public GameBall(GameWorld game, Vecteur position) {
        super(game, position, gameBallRadius, gameBallWeight, gameBallColor);
        installationStates();
    }

    // Méthode pour mettre en place la structure des GameBallStates pour la GameBall
    private void installationStates()
    {
        this.gameBallStateAlive = new GameBallStateAlive(this);
        this.gameBallStateDead = new GameBallStateDead(this);
        this.gameBallStateStatic = new GameBallStateStatic(this);
        // Définir l'état courant
        this.currentGameBallState = this.gameBallStateAlive;
    }

    // Gestion du déplacement d'une GameBall
    @Override
    public void update() {
        this.currentGameBallState.update();
    }

    public GameBallState getCurrentGameBallState() {
        return currentGameBallState;
    }

    public void setCurrentGameBallState(GameBallState currentGameBallState) {
        this.currentGameBallState = currentGameBallState;
    }

    public GameBallState getGameBallStateAlive() {
        return gameBallStateAlive;
    }

    public GameBallState getGameBallStateDead() {
        return gameBallStateDead;
    }

    public GameBallState getGameBallStateStatic() {
        return gameBallStateStatic;
    }

    public void resetVelocity() {
        this.velocity.x = 0;
        this.velocity.y = 0;
    }

    // -------------------------------- \\
    // --- Fin de la class GameBall --- \\
    // -------------------------------- \\
}
