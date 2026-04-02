package domain.piece;

import domain.board.Intersection;
import domain.game.Side;
import java.util.List;

public final class EmptyPiece extends Piece {

    public EmptyPiece() {
        super(Side.NONE);
    }

    @Override
    public boolean canMove(Intersection from, Intersection to, AlivePieces alivePieces) {
        return false;
    }

    @Override
    public List<Intersection> movableIntersections(Intersection from, AlivePieces alivePieces) {
        return List.of();
    }
}
